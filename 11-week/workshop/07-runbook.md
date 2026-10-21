# CP8 - Runbook: `PlaceOrderAvailabilityFastBurn`

Alert of [06-alerts.yml](06-alerts.yml). Meaning: more than 7.2 % of the `place-order` sagas
of the last hour ended `failed`, and the last 5 minutes are still bad. 2 % of the monthly budget is gone.

## 1. Symptoms

- Sellers in the sales portal see "could not create the quotation" or wait about 15 s (three attempts of 5 s).
- `opti-api-gateway` returns `503 SERVICE_UNAVAILABLE` on `/api/v1/sagas`.
- `workflow_saga_requests_total{outcome="failed"}` goes up; sagas stay `RUNNING` and `workflow_sagas_in_flight` grows.

## 2. Confirm and find the guilty hop (5 minutes)

1. Error ratio now:

```promql
sum(rate(workflow_saga_requests_total{saga="place-order",outcome="failed"}[5m]))
/ sum(rate(workflow_saga_requests_total{saga="place-order",outcome!="rejected"}[5m]))
```

2. Which participant: `histogram_quantile(0.95, sum by (le, participant) (rate(workflow_participant_call_duration_seconds_bucket[5m])))`
   and `sum by (participant) (rate(workflow_saga_requests_total{outcome="failed"}[5m]))`. The step is
   `check-patient` (customers), `reserve-stock` (products) or `open-order` (sales).
3. Take one failed `trace_id` from the gateway answer or from the logs, then read the whole story:

```bash
cd opti-infra && docker compose --env-file .env -f compose.yml logs --no-log-prefix \
  opti-api-gateway opti-workflow opti-customers-api opti-products-api opti-sales-api \
  | grep '"trace_id":"<TRACE_ID>"' | jq -c '[.timestamp,.service,.event,.duration_ms,.failure_reason]'
```

4. Is it only business refusals? If `outcome="compensated"` is high and `failed` is not, the alert is wrong: stock is out, not the system. Close it and tell the shop.

## 3. Mitigations, from lowest to highest risk

| Order | Action | Risk | Use when |
|---|---|---|---|
| 1 | Restart the one slow participant: `docker compose restart opti-products-api` (or the one found in step 2). Sagas are safe to repeat: every step has the idempotency key `<sagaId>:<step>` and `SAGA_RESUME_*` takes over the `RUNNING` ones. | low | the participant is stuck or slow after hours of uptime |
| 2 | Roll back the last release of the guilty participant to the previous tag (`v2.0.0`) and, if the release had a migration, run its script of `opti-<domain>-db/05_rollbacks`. | medium | the alert started within an hour of a deploy |
| 3 | Pause the cause of extra load: set `EXPIRE_EVERY` of `opti-worker` to a large value and restart it, so `expire-stale-orders` stops launching `cancel-order` sagas. | medium | the failures come together with a batch of cancellations |
| 4 | Stop the bleeding at the door: in `opti-api-gateway` answer `503` for `/api/v1/sagas` from `nginx/routes` and reload. Sellers cannot quote, but no stock is left reserved by half-done sagas. | high, user-visible | steps 1 to 3 did not help in 15 minutes or `COMPENSATION_FAILED` appears |

Not available today, so not listed: feature flags and a circuit breaker (see action items in `08-incident.md`).

## 4. Escalation

| After | Who | Role |
|---|---|---|
| 0 min | person on call of the sprint | confirms and runs steps 1 to 3 |
| 15 min without improvement | owner of the failing repository (`opti-products-*`, `opti-customers-*` or `opti-sales-*`) | knows the last change and its rollback |
| 30 min, or any `COMPENSATION_FAILED` | tech lead of the team | decides on step 4 and on freezing releases (CP6 policy) |
| user impact over 30 min | product owner | tells the optical shops and the instructor |

## 5. Verify recovery

- `place_order:error_ratio{window="5m"}` below `0.005` for 15 minutes in a row.
- `workflow_sagas_in_flight` back to its normal level (a few) and no saga `RUNNING` older than `SAGA_RESUME_AFTER`.
- One real `place-order` from the portal ends `COMPLETED` in under 2 s.
- No `COMPENSATION_FAILED` in the last hour: `grep failure_reason` in the workflow log. If there is one, release that stock by hand with the saga's `reservation_id` before closing.
- Write down the times (start, alert, mitigation, recovery) for the postmortem.

## Variant: latency fast burn

For `PlaceOrderLatencyFastBurn` the symptom is slow, not failed: availability stays at 100 %. Use
step 2 with `histogram_quantile` per participant (the slow one is the one with p95 above 1 s) and
the same mitigations 1, 2 and 3. Do **not** use step 4: a slow quotation is better than none.
