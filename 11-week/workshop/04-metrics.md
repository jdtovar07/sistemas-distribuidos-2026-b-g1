# CP4 - Golden signals and metric catalog

Journey `place-order`. One table per service, four golden signals each. Names follow the
Prometheus rules: `snake_case`, a unit suffix (`_seconds`), `_total` for counters. The first two
metrics of `opti-workflow` are the ones exposed by the code in `03-instrumentation/`.

`route` is always the route **template** (`/api/v1/work-orders/{id}`), never the real URL.
`status_class` is `2xx`, `3xx`, `4xx`, `5xx`.

## 1. `opti-api-gateway` (NGINX, no code: metrics come from its access log or an exporter)

| Signal | Metric | Type | Labels | PromQL for the dashboard |
|---|---|---|---|---|
| Latency | `gateway_request_duration_seconds` | histogram | `route` | `histogram_quantile(0.95, sum by (le) (rate(gateway_request_duration_seconds_bucket{route="/api/v1/sagas"}[5m])))` |
| Traffic | `gateway_requests_total` | counter | `route`, `status_class` | `sum by (route) (rate(gateway_requests_total[5m]))` |
| Errors | `gateway_requests_total` | counter | `route`, `status_class` | `sum(rate(gateway_requests_total{route="/api/v1/sagas",status_class="5xx"}[5m])) / sum(rate(gateway_requests_total{route="/api/v1/sagas"}[5m]))` |
| Saturation | `gateway_rate_limited_total` | counter | `zone` (`general`, `login`) | `sum by (zone) (rate(gateway_rate_limited_total[5m]))` - every `429` is a client that hit the limit |

## 2. `opti-workflow` (saga `place-order`)

| Signal | Metric | Type | Labels | PromQL |
|---|---|---|---|---|
| Latency | `workflow_saga_duration_seconds` | histogram | `saga` | `histogram_quantile(0.95, sum by (le) (rate(workflow_saga_duration_seconds_bucket{saga="place-order"}[5m])))` |
| Latency of a dependency | `workflow_participant_call_duration_seconds` | histogram | `participant`, `operation` | `histogram_quantile(0.95, sum by (le, participant) (rate(workflow_participant_call_duration_seconds_bucket[5m])))` |
| Traffic | `workflow_saga_requests_total` | counter | `saga`, `outcome` | `sum by (saga) (rate(workflow_saga_requests_total[5m]))` |
| Errors | `workflow_saga_requests_total` | counter | `saga`, `outcome` | `sum(rate(workflow_saga_requests_total{saga="place-order",outcome="failed"}[5m])) / sum(rate(workflow_saga_requests_total{saga="place-order"}[5m]))` |
| Saturation | `workflow_sagas_in_flight` | gauge | `saga` | `max_over_time(workflow_sagas_in_flight{saga="place-order"}[5m])` - sagas `RUNNING` or `COMPENSATING`; the resume task takes over after `SAGA_RESUME_AFTER` (30 s) |
| Errors of the undo | `workflow_saga_compensations_total` | counter | `saga`, `result` (`ok`, `failed`) | `sum(rate(workflow_saga_compensations_total{result="failed"}[1h]))` - used by SLO 3 in CP6 |

`outcome` values: `completed`, `compensated` (business refusal such as `INSUFFICIENT_STOCK`,
nothing left behind), `failed` (technical failure or `COMPENSATION_FAILED`), `rejected` (the
request itself is invalid, `4xx`). Only `failed` burns the availability budget.

## 3. `opti-customers-api` (step `check-patient`)

| Signal | Metric | Type | Labels | PromQL |
|---|---|---|---|---|
| Latency | `customers_http_request_duration_seconds` | histogram | `route`, `method` | `histogram_quantile(0.95, sum by (le) (rate(customers_http_request_duration_seconds_bucket{route="/api/v1/patients/{id}"}[5m])))` |
| Traffic | `customers_http_requests_total` | counter | `route`, `method`, `status_class` | `sum by (route) (rate(customers_http_requests_total[5m]))` |
| Errors | `customers_http_requests_total` | counter | `route`, `method`, `status_class` | `sum(rate(customers_http_requests_total{status_class="5xx"}[5m])) / sum(rate(customers_http_requests_total[5m]))` |
| Saturation | `customers_db_pool_connections_in_use` | gauge | none | `max_over_time(customers_db_pool_connections_in_use[5m]) / 10` - the pool is 10 (declared limit) |

## 4. `opti-products-api` (step `reserve-stock`, the critical hop)

| Signal | Metric | Type | Labels | PromQL |
|---|---|---|---|---|
| Latency | `products_http_request_duration_seconds` | histogram | `route`, `method` | `histogram_quantile(0.95, sum by (le) (rate(products_http_request_duration_seconds_bucket{route="/api/v1/frames/{id}/reservations"}[5m])))` |
| Traffic | `products_http_requests_total` | counter | `route`, `method`, `status_class` | `sum by (route) (rate(products_http_requests_total[5m]))` |
| Errors | `products_http_requests_total` | counter | `route`, `method`, `status_class` | `sum(rate(products_http_requests_total{status_class="5xx"}[5m])) / sum(rate(products_http_requests_total[5m]))` |
| Saturation | `products_db_pool_connections_in_use` | gauge | none | `max_over_time(products_db_pool_connections_in_use[5m]) / 10` |
| Business | `products_stock_reservations_total` | counter | `product_type`, `result` (`reserved`, `insufficient_stock`) | `sum(rate(products_stock_reservations_total{result="insufficient_stock"}[1h])) / sum(rate(products_stock_reservations_total[1h]))` |

## 5. `opti-sales-api` (step `open-order`)

| Signal | Metric | Type | Labels | PromQL |
|---|---|---|---|---|
| Latency | `sales_http_request_duration_seconds` | histogram | `route`, `method` | `histogram_quantile(0.95, sum by (le) (rate(sales_http_request_duration_seconds_bucket{route="/api/v1/work-orders"}[5m])))` |
| Traffic | `sales_http_requests_total` | counter | `route`, `method`, `status_class` | `sum by (route) (rate(sales_http_requests_total[5m]))` |
| Errors | `sales_http_requests_total` | counter | `route`, `method`, `status_class` | `sum(rate(sales_http_requests_total{status_class="5xx"}[5m])) / sum(rate(sales_http_requests_total[5m]))` |
| Saturation | `sales_db_pool_connections_in_use` | gauge | none | `max_over_time(sales_db_pool_connections_in_use[5m]) / 10` |

## 6. Label cardinality

| Label | Values | Series it multiplies by |
|---|---|---|
| `route` | route templates of one service, about 12 (`opti-sales-api` has 9 in its README table) | 12 |
| `method` | `GET`, `POST` (4 in total with `PUT`, `DELETE`) | 4 |
| `status_class` | 4 in practice (`2xx`, `4xx`, `5xx`, `3xx` almost never) | 4 |
| `saga` | `place-order`, `cancel-order` | 2 |
| `outcome` | `completed`, `compensated`, `failed`, `rejected` | 4 |
| `participant` | `opti-customers-api`, `opti-products-api`, `opti-sales-api` | 3 |
| `operation` | `check-patient`, `reserve-stock`, `release-stock`, `open-order`, `get-order`, `cancel-order` | 6 |
| `product_type` | `FRAME`, `LENS`, `ACCESSORY`, `LIQUID` | 4 |
| `zone` | `general`, `login` | 2 |

Worst case for the biggest family, `customers_http_requests_total`: 12 x 4 x 4 = 192 series;
with the real combinations used it is about 40. The histogram family multiplies by the number of
buckets (8 + `+Inf`), so `workflow_saga_duration_seconds` is 2 x 9 = 18 series. The whole journey stays under 2,000 series.

**Forbidden labels** and what replaces each one:

| Forbidden label | Why | Replacement |
|---|---|---|
| `patient_id`, `saga_id`, `reservation_id`, `work_order_id` | one value per request: unbounded | the log field of the same name (CP2), found through `trace_id` |
| raw URL or path with ids | one series per id | `route` template |
| `sku`, patient name, document, email | unbounded and personal data | none: they never leave the database |
| `correlation_id`, `trace_id` | unbounded | an exemplar on the histogram, or the log query |
| `error_message` | free text | `failure_reason` from the closed `FailureReason` list, only in logs |

## 7. Histogram buckets

The seller is at the counter with the patient in front of him. From the sales flow I assume a quote that answers in
under 2 s feels immediate, and the services themselves declare a 5 s timeout (`HTTP_TIMEOUT=PT5S`).

- Saga and gateway: `0.05, 0.1, 0.25, 0.5, 1, 2, 5, 10`. One bucket sits exactly on **2 s**, the latency
  SLO of CP6, because a Prometheus SLI can only be exact on a bucket boundary. `5` is the timeout and `10` catches a saga that waited for two retries.
- Participant calls and the `*_http_request_duration_seconds` of the APIs: `0.025, 0.05, 0.1, 0.25, 0.5, 1, 2.5, 5`.
  A healthy database call answers in tens of milliseconds, so the fine buckets at the low end show the normal and the first signs of degradation.
