# CP9 - Incident drill and blameless postmortem

**Scenario (drill, nothing of this happened):** `opti-products-api` answers `POST /api/v1/frames/{id}/reservations`
(step `reserve-stock`, the hop marked in [01-journey.md](01-journey.md)) in 3 seconds for 25 % of the
requests, during 40 minutes: 14:00 to 14:40. Traffic is the one of [05-slo.md](05-slo.md): 50 sagas per hour.
3 s is below `HTTP_TIMEOUT` (5 s), so nothing times out and nothing is retried: the sagas are slow, not failed.

## 1. The trace of one slow request

`trace_id` `e3b0a7c19d5f4268b14a7d02c6f83e51`, started at 14:17:42.310.

```
opti-api-gateway  POST /api/v1/sagas/place-order                     3298 ms
  opti-workflow  POST /api/v1/sagas/place-order (saga place-order)   3276 ms
    saga.step check-patient                                            64 ms
      opti-customers-api  GET /api/v1/patients/{id}                    29 ms
    saga.step reserve-stock                                          3041 ms   <- the slow hop
      opti-products-api  POST /api/v1/frames/{id}/reservations      3005 ms
    saga.step open-order                                              143 ms
      opti-sales-api  POST /api/v1/work-orders                        118 ms
    (state saved in Redis between steps)                               28 ms
```

Check: 64 + 3041 + 143 + 28 = 3276; plus 22 ms of the gateway = 3298.

## 2. Four log lines of that trace (CP2 format)

```json
{"timestamp":"2026-10-20T14:17:42.310Z","level":"INFO","service":"opti-workflow","version":"0.1.0","environment":"main","trace_id":"e3b0a7c19d5f4268b14a7d02c6f83e51","span_id":"6d1f9a02c47b8e35","correlation_id":"corr-2b94d0e7","event":"saga.started","message":"place-order started","saga_id":"7a3c5e18-90b2-4d6f-8e41-c5d02f9b1a37","saga_type":"place-order","product_type":"FRAME"}
{"timestamp":"2026-10-20T14:17:45.381Z","level":"INFO","service":"opti-products-api","version":"2.1.0","environment":"main","trace_id":"e3b0a7c19d5f4268b14a7d02c6f83e51","span_id":"90e2b7d4a1c5f368","correlation_id":"corr-2b94d0e7","event":"stock.reservation.completed","message":"frame reserved","duration_ms":3005,"product_type":"FRAME","http_status":201,"reservation_id":"f4b82d60-1a9e-4c37-b5d8-02e6a7c93f14"}
{"timestamp":"2026-10-20T14:17:45.417Z","level":"WARN","service":"opti-workflow","version":"0.1.0","environment":"main","trace_id":"e3b0a7c19d5f4268b14a7d02c6f83e51","span_id":"2c8a5f71e0d9b436","correlation_id":"corr-2b94d0e7","event":"participant.call.slow","message":"products-api answered over 2 s","duration_ms":3041,"saga_id":"7a3c5e18-90b2-4d6f-8e41-c5d02f9b1a37","saga_step":"reserve-stock","participant":"opti-products-api","http_status":201}
{"timestamp":"2026-10-20T14:17:45.586Z","level":"INFO","service":"opti-workflow","version":"0.1.0","environment":"main","trace_id":"e3b0a7c19d5f4268b14a7d02c6f83e51","span_id":"6d1f9a02c47b8e35","correlation_id":"corr-2b94d0e7","event":"saga.completed","message":"place-order completed","duration_ms":3276,"saga_id":"7a3c5e18-90b2-4d6f-8e41-c5d02f9b1a37","saga_type":"place-order"}
```

The slow line comes from `workflow` (it measured 3041 ms) and `products-api` confirms 3005 ms: the time is spent inside products, not in the network.

## 3. What the SLIs do

| SLI (05-slo.md) | Value during the incident | Fires? |
|---|---|---|
| Availability: good / valid sagas | **100 %**: every saga ended `completed` or `compensated`; no `5xx`, no timeout | no |
| Latency: sagas <= 2 s / all | **75 %** in the 5-minute window (25 % are at 3 s) | yes, see below |
| Compensation integrity | no compensation was needed because of this | no |

**Which alert fires first: `PlaceOrderLatencyFastBurn`, at minute 35 (14:35).** The availability alerts
never fire: the availability SLI does not see slowness. The 5-minute window is bad from minute 5,
but the 1-hour window must reach 14.4 %. With uniform traffic the slow ratio of the last hour at minute
*t* is 25 % x *t* / 60, and 25 % x *t* / 60 > 14.4 % gives *t* > 34.6, so the first evaluation above the line is 14:35.

## 4. Which runbook step stops the bleeding

[07-runbook.md](07-runbook.md), section 3: **step 1** (restart `opti-products-api`) does not help,
because the cause is a database object, not a stuck process. **Step 2** (roll back the release and run the
script of `opti-products-db/05_rollbacks`) ends the incident at 14:40.

## 5. Blameless postmortem

### Timeline (all times 14:xx of the drill day)

| Time | Event |
|---|---|
| 13:50 | release `2.1.0` of `opti-products-db` and `opti-products-api` is deployed to `main` (assumed root cause, below) |
| 14:00 | 25 % of the `reserve-stock` calls start to take 3 s. Nobody is told |
| 14:35 | `PlaceOrderLatencyFastBurn` fires and pages the person on call |
| 14:36 | acknowledged; the runbook of section 2 starts |
| 14:37 | `histogram_quantile` per participant shows `opti-products-api` p95 at 3 s; the trace of section 1 confirms `reserve-stock` |
| 14:38 | step 1: restart of `opti-products-api`, no change |
| 14:39 | step 2: rollback of the release and of its migration starts |
| 14:40 | the removed index is back; slow calls stop |
| 14:55 | 5-minute slow ratio under 1 % for 15 minutes: recovery verified |

### Impact

- Duration 40 minutes. Sagas in that time: 40 x 50 / 60 = about 33; slow: 25 % = **about 8 requests**, each 3.3 s instead of under 1 s.
- Failed sagas: **0**. Availability budget used: 0 of 90.
- Latency budget used: 8 of 180 slow sagas = **4.4 %** of the month. In minutes: 40 min x 25 % = **10 of 432 minutes (2.3 %)**; the two numbers differ because the minutes assume 24 h of traffic and the shops sell only 12 h.
- Compensation integrity: untouched.

### Root cause (assumed for the drill)

Migration `2.1.0` of `opti-products-db` removed the index of `products.stock_reservation` by frame. For the
frames that have many past reservations (25 % of the catalog) the search became a full scan of about 3 s.

### Contributing factors

- The 1-hour window of the fast alert needs 35 minutes to see a degradation of 25 %: 7 of the 8 slow sagas happened before the page.
- No panel shows the latency of each participant, so the guilty hop was found with a trace and not with a graph.
- The migration was validated on `develop` with a small catalog, where a full scan also answers in milliseconds.
- There is no per-step timeout lower than 5 s and no circuit breaker in `opti-workflow`.

### Action items

| # | User story | Acceptance criteria |
|---|---|---|
| 1 | As the person on call, I want an alert on a short window so that a participant that slows down 25 % of the calls pages me in less than 10 minutes. | Given `workflow_saga_duration_seconds` where 25 % of the sagas last 3 s, when the rule `PlaceOrderLatencyVeryFastBurn` (burn 14.4 over 15 min, confirmed over 2 min) is tested with `promtool test rules`, then it fires at or before minute 10. The test file is in the repo and passes in CI. |
| 2 | As the person on call, I want a Grafana panel with the p95 of every participant of `opti-workflow` so that I find the slow service in under 2 minutes without reading traces. | Given `workflow_participant_call_duration_seconds`, when I open the dashboard in `opti-infra/observability`, then I see one line per `participant` (`opti-customers-api`, `opti-products-api`, `opti-sales-api`) for the last hour, and a drill that slows one of them makes its line cross 1 s within 2 minutes. |
| 3 | As a developer of `opti-products-db`, I want CI to check that the queries of reserve-stock still use an index after every migration so that a dropped index cannot reach `main`. | Given a migration that drops the index of `products.stock_reservation` by frame, when the CI job runs `EXPLAIN` on the reservation query over a seeded catalog of 100,000 rows, then the job fails with the name of the query. With the index in place the job passes. |
