# CP7 - Alert policy

Rules in [06-alerts.yml](06-alerts.yml). SLO numbers from [05-slo.md](05-slo.md): availability 99.5 %
(budget 90 failed sagas or 216 min per 30 days), latency 99 % under 2 s (budget 180 slow sagas or 432 min).

## What each alert means before it fires

| Alert | Burn rate and windows | Threshold on the ratio | Budget spent when it fires | In sagas (about 50 per hour) | Action |
|---|---|---|---|---|---|
| `PlaceOrderAvailabilityFastBurn` | 14.4, 1 h confirmed by 5 min | 14.4 x 0.005 = **7.2 %** failed | 14.4 x 1 h / 720 h = **2 %** of the month | 3.6 of 50 sagas failed = 4 % of the 90 | page the person on call |
| `PlaceOrderAvailabilitySlowBurn` | 6, 6 h confirmed by 30 min | 6 x 0.005 = **3 %** failed | 6 x 6 h / 720 h = **5 %** of the month | 9 of 300 sagas failed = 10 % of the 90 | ticket, handled in office hours |
| `PlaceOrderLatencyFastBurn` (extra) | 14.4, 1 h confirmed by 5 min | 14.4 x 0.01 = **14.4 %** slower than 2 s | **2 %** of the latency budget | 7.2 of 50 slow = 4 % of the 180 | page the person on call |

Why the percentage in sagas is higher than the percentage in time: the budget is counted over 24 hours
but the shops sell only 12 hours, so each open hour carries twice the average traffic. The alert is
built on ratios, so it is not affected; only the "sagas" column is.

Minimum traffic guard: each rule also requires `increase(...) > 20` sagas in 1 h (`> 60` in 6 h), about
40 % of the normal traffic. Without it, at night one failed saga out of two would be 50 % and would page someone for nothing.

## Two cause-based alerts I will NOT create

| Alert | Why not |
|---|---|
| `opti-workflow` CPU above 80 % | the seller does not feel CPU. A saga can wait on a slow `opti-products-api` with the CPU at 5 %, and a busy CPU with all sagas under 2 s costs the budget nothing. The latency and availability alerts catch the symptom whatever the cause. |
| Redis memory above 70 % | the saga state is small (one JSON per saga) and a full Redis already shows up as `failed` sagas and the availability alert. A memory alert would page for a condition that may take weeks to hurt; it belongs to a dashboard and a weekly review, not to the phone. |

Both stay as graphs in Grafana for diagnosis once an SLO alert has fired.

## Validation

`06-alerts.yml` was checked as YAML (it parses, 6 recording rules and 3 alerts). `promtool check rules`
is not installed on my machine, so the PromQL syntax was reviewed by hand; run `promtool check rules 06-alerts.yml` before copying it to `opti-infra/observability/`.
