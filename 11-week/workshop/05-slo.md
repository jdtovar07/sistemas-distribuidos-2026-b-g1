# CP6 - SLIs, SLOs and error budget for `place-order`

All metric names come from [04-metrics.md](04-metrics.md). Window of every SLO: **30 days rolling**.

## 1. Traffic of the journey (my estimate)

OptiView has no production traffic yet (MVP 2 runs on `develop`/`qa`), so this is an assumption to replace with
the first real month of data.

| Assumption | Value | Why |
|---|---|---|
| Optical shops using OptiView | 8 | a regional chain of the size a first customer would be |
| `place-order` per shop per day | 75 | 8 to 10 hours open, a quotation every 6 to 8 minutes; an optical shop quotes many more than it sells |
| Sagas per day | 8 x 75 = **600** | |
| Sagas per month (30 days) | **18,000** | |
| Open hours | 12 per day, so about 50 sagas per hour | traffic is zero at night: ratio alerts need a minimum-traffic guard (CP7) |
| Sagas that compensate (`INSUFFICIENT_STOCK`, patient not found) | 8 % = 48 per day = **1,440 per month** | I assume one quotation in twelve asks for a frame with no stock |

## 2. The three SLOs

### SLO 1 - Availability: 99.5 %

- **SLI** = sagas that ended `completed` or `compensated` / sagas that were valid. A `compensated`
  saga is a **good** event: the system refused correctly and left no stock reserved. `rejected` (invalid
  request, `4xx`) is not a valid event: the client is wrong, not the service.
- **PromQL:**

```promql
sum(rate(workflow_saga_requests_total{saga="place-order",outcome=~"completed|compensated"}[30d]))
/
sum(rate(workflow_saga_requests_total{saga="place-order",outcome!="rejected"}[30d]))
```

- **Budget:** 0.5 % x 18,000 = **90 failed sagas per month**, or 0.5 % x 43,200 min = **216 minutes** of full outage.

### SLO 2 - Latency: 99 % of sagas finish in 2 seconds or less

- **SLI** = sagas with duration <= 2 s / all sagas. 2 s is the limit I set for the seller at the counter
  (see the buckets of CP4); 99 % and not 95 % because three sequential calls to healthy services
  take well under 1 s, so a slow saga means a dependency is degrading.
- **PromQL:**

```promql
sum(rate(workflow_saga_duration_seconds_bucket{saga="place-order",le="2.0"}[30d]))
/
sum(rate(workflow_saga_duration_seconds_count{saga="place-order"}[30d]))
```

- **Budget:** 1 % x 18,000 = **180 slow sagas per month**, or 1 % x 43,200 = **432 minutes** during which every saga is slow.

### SLO 3 - Compensation integrity: 99.9 % of compensations succeed

- **Why this one:** `place-order` reserves stock in `opti-products-api` before it opens the order in
  `opti-sales-api`. If the undo fails, a frame stays reserved for nobody and the saga ends `FAILED`
  with `COMPENSATION_FAILED`: the seller cannot sell a frame that exists on the shelf. This is the failure
  that costs money, so it deserves its own target.
- **SLI** = compensations that finished OK / compensations started (metric `workflow_saga_compensations_total{result}`, added to the CP4 catalog).
- **PromQL:**

```promql
sum(rate(workflow_saga_compensations_total{result="ok"}[30d]))
/
sum(rate(workflow_saga_compensations_total[30d]))
```

- **Budget:** 0.1 % x 1,440 = **1.44, so one failed compensation per month**; in time, 0.1 % x 43,200 = **43 minutes** of total compensation outage. One incident of this kind uses the whole month.

## 3. Summary

| SLO | Target | Bad events allowed per 30 days | Equivalent time |
|---|---|---|---|
| Availability | 99.5 % | 90 sagas | 216 min |
| Latency (<= 2 s) | 99 % | 180 sagas | 432 min |
| Compensation integrity | 99.9 % | 1 compensation | 43 min |

Check of the arithmetic: 18,000 x 0.005 = 90; 18,000 x 0.01 = 180; 1,440 x 0.001 = 1.44; 30 x 24 x 60 = 43,200.

## 4. Error budget policy

| Budget consumed (in the 30-day window) | What the team does |
|---|---|
| **50 %** | Warning in the sprint channel. Review the 5 worst traces of the period. No change in the plan, but every new release of `opti-workflow`, `opti-products-api` or `opti-sales-api` needs a rollback tag ready. |
| **75 %** | Only reliability work and bug fixes enter the sprint. New features of the `place-order` flow wait. The person on call writes a short note of what is spending the budget. |
| **100 %** | Release freeze for the three services of the journey, except fixes that give budget back. A postmortem (like `08-incident.md`) is mandatory and its action items go first in the next sprint. The freeze ends when the SLI is back over the target for 7 days. |

For SLO 3 the policy is stricter: **one** failed compensation already means "75 % or more", because the budget is 1.44 events.

## 5. Are the targets realistic?

- 99.5 % is the target of a small business system with one person on call during business hours; 99.9 % would need
  redundancy (two instances, a replicated Redis) that the team does not have today.
- `HTTP_ATTEMPTS=3` with a 5 s timeout means a bad dependency can already make a saga last 15 s, so the latency SLO is the first one that will be violated, before availability.
- With about 50 sagas per hour a single failure is 2 % of one hour: the burn-rate alerts of CP7 need a minimum traffic guard.
