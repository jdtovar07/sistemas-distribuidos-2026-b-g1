# CP2 - Structured log contract

One JSON object per line on stdout, the same fields in `opti-api-gateway`, `opti-workflow`,
`opti-customers-api`, `opti-products-api` and `opti-sales-api`. Names are `snake_case`.

> Today the Java services write `correlationId` (camelCase, from MDC key `correlationId`). This
> contract renames it to `correlation_id` and adds `trace_id` and `span_id`; the mapping is a
> one-line change in each logback pattern.

## 1. Mandatory fields

| Field | Type | Required | Example | Why it exists |
|---|---|---|---|---|
| `timestamp` | string, ISO-8601 UTC, ms | yes | `2026-10-20T14:02:11.120Z` | order the lines of five services in one timeline |
| `level` | string | yes | `WARN` | filter by severity, drive alerts |
| `service` | string | yes | `opti-workflow` | which repository wrote the line |
| `version` | string | yes | `0.1.0` | link an incident to a release (`v2.1.0` tags) |
| `environment` | string | yes | `develop`, `qa`, `main` | the three branches of the per-environment flow |
| `trace_id` | 32 hex | yes | `5d2a8e41c7b94f03a6e18d92b04c7f35` | everything that happened to one request |
| `span_id` | 16 hex | yes | `b7ad6b7169203331` | the exact hop inside the trace |
| `correlation_id` | string | yes | `corr-7f3a91c2` | same value as the `X-Correlation-Id` header already used by the gateway and the clients' error `traceId` |
| `event` | string, dotted | yes | `participant.call.timeout` | stable name to count and alert on, not text |
| `message` | string | yes | `products-api did not answer` | human sentence, no personal data |
| `duration_ms` | integer | optional | `5003` | latency of the operation; required on `*.completed` and `*.timeout` events |

## 2. Domain fields of OptiView

| Field | Type | Required | Example | Why it exists |
|---|---|---|---|---|
| `saga_id` | UUID | in `opti-workflow` | `0d6f2b44-3f0c-4f7e-9c1e-5a1f77d2b8a0` | the saga is the business transaction; also the base of the idempotency key `<sagaId>:<step>` |
| `saga_step` | string | when a step runs | `reserve-stock` | the three steps of `place-order` fail for different reasons and have different runbooks |
| `participant` | string | on outbound calls | `opti-products-api` | tells which downstream hop was slow, without reading the URL |
| `failure_reason` | string | when a saga ends not completed | `INSUFFICIENT_STOCK` | the closed list of `FailureReason` of `opti-workflow`; lets us separate business refusals from technical failures |
| `product_type` | string | stock and order lines | `FRAME` | `FRAME`, `LENS`, `ACCESSORY` or `LIQUID` use different endpoints in `opti-products-api` |
| `patient_id` | UUID | when a patient is involved | `3c9b1e0a-8d12-4b55-a2c7-6e4f90d1a7b3` | a pseudonym that lets support find the record; never the name or the document |
| `reservation_id` | UUID | after `reserve-stock` | `a8e51c3f-62d4-4f19-b0aa-9e7d3c22f5e1` | follows the stock reservation until it is released or consumed |
| `http_status` | integer | on HTTP events | `422` | error ratio per service |
| `attempt` | integer | on retried calls | `2` | `HTTP_ATTEMPTS=3` retries 5xx, 429 and network failures |

## 3. Never log

| Data | Where it exists in OptiView | Rule and mask |
|---|---|---|
| Patient name, document number, phone, email | `customers.patient` | never; log `patient_id` only. The logger replaces keys `document_number`, `phone`, `email` with `***` |
| Optical prescription (sphere, cylinder, axis, add) | `customers.optical_formula` | health data: never; log the formula id if needed |
| `Authorization` header, JWT, `SERVICE_TOKEN` | every service | never; log the `sub` claim role only. Key `authorization` and `service_token` become `***` |
| Passwords, password hashes | `opti-auth-api`, `auth` database | never, not even hashed |
| Payment data: Nequi phone, card or account numbers | `sales.payment` | never; log `payment_id` and `amount_cents`; the phone, if ever needed, shows only the last 2 digits (`******21`) |
| Full request bodies | all | never; log field names and sizes, not values |
| Stack traces in HTTP answers | all | stay in the log, tied to `trace_id`, never in the response (rule already in `opti-workflow/README.md`) |

## 4. Seven lines of one request

One failed `place-order`: `products-api` does not answer in 5 s, the retry returns a business
refusal. All lines have the same `trace_id`; timestamps go forward.

```json
{"timestamp":"2026-10-20T14:02:11.120Z","level":"INFO","service":"opti-workflow","version":"0.1.0","environment":"main","trace_id":"5d2a8e41c7b94f03a6e18d92b04c7f35","span_id":"b7ad6b7169203331","correlation_id":"corr-7f3a91c2","event":"saga.started","message":"place-order started","saga_id":"0d6f2b44-3f0c-4f7e-9c1e-5a1f77d2b8a0","saga_type":"place-order","patient_id":"3c9b1e0a-8d12-4b55-a2c7-6e4f90d1a7b3","product_type":"FRAME"}
{"timestamp":"2026-10-20T14:02:11.171Z","level":"INFO","service":"opti-customers-api","version":"2.1.0","environment":"main","trace_id":"5d2a8e41c7b94f03a6e18d92b04c7f35","span_id":"c2e4a1d90b7f5a68","correlation_id":"corr-7f3a91c2","event":"patient.lookup.completed","message":"patient found and active","duration_ms":29,"patient_id":"3c9b1e0a-8d12-4b55-a2c7-6e4f90d1a7b3","http_status":200}
{"timestamp":"2026-10-20T14:02:11.186Z","level":"INFO","service":"opti-workflow","version":"0.1.0","environment":"main","trace_id":"5d2a8e41c7b94f03a6e18d92b04c7f35","span_id":"b7ad6b7169203331","correlation_id":"corr-7f3a91c2","event":"saga.step.completed","message":"patient checked","duration_ms":64,"saga_id":"0d6f2b44-3f0c-4f7e-9c1e-5a1f77d2b8a0","saga_step":"check-patient"}
{"timestamp":"2026-10-20T14:02:16.195Z","level":"WARN","service":"opti-workflow","version":"0.1.0","environment":"main","trace_id":"5d2a8e41c7b94f03a6e18d92b04c7f35","span_id":"e91f0c3a7d24b856","correlation_id":"corr-7f3a91c2","event":"participant.call.timeout","message":"products-api did not answer","duration_ms":5003,"saga_id":"0d6f2b44-3f0c-4f7e-9c1e-5a1f77d2b8a0","saga_step":"reserve-stock","participant":"opti-products-api","attempt":1}
{"timestamp":"2026-10-20T14:02:16.489Z","level":"WARN","service":"opti-products-api","version":"2.1.0","environment":"main","trace_id":"5d2a8e41c7b94f03a6e18d92b04c7f35","span_id":"4a7c9e12f0b3d685","correlation_id":"corr-7f3a91c2","event":"stock.reservation.rejected","message":"insufficient stock","duration_ms":41,"product_type":"FRAME","http_status":422,"failure_reason":"INSUFFICIENT_STOCK"}
{"timestamp":"2026-10-20T14:02:16.531Z","level":"WARN","service":"opti-workflow","version":"0.1.0","environment":"main","trace_id":"5d2a8e41c7b94f03a6e18d92b04c7f35","span_id":"b7ad6b7169203331","correlation_id":"corr-7f3a91c2","event":"saga.compensated","message":"place-order ended, nothing to undo","duration_ms":5411,"saga_id":"0d6f2b44-3f0c-4f7e-9c1e-5a1f77d2b8a0","saga_step":"reserve-stock","failure_reason":"INSUFFICIENT_STOCK","attempt":2}
{"timestamp":"2026-10-20T14:02:16.541Z","level":"INFO","service":"opti-api-gateway","version":"1.0.0","environment":"main","trace_id":"5d2a8e41c7b94f03a6e18d92b04c7f35","span_id":"1f8b3d6e2a9c4057","correlation_id":"corr-7f3a91c2","event":"http.request.completed","message":"POST /api/v1/sagas/place-order","duration_ms":5421,"http_status":201}
```

Filtering by `trace_id` = `5d2a8e41...` tells the story: the saga started, the patient was
valid, the stock call timed out once (5 s lost), the retry showed the frame had no stock, the
saga ended without creating anything, and the seller waited 5.4 s for a refusal.

## 5. Levels

| Level | Use it when | Example in OptiView |
|---|---|---|
| `ERROR` | a technical failure lost work or needs a person | saga ends `FAILED` with `COMPENSATION_FAILED`; Redis unreachable when saving saga state |
| `WARN` | something went wrong but the system handled it, including business refusals | `participant.call.timeout` on `reserve-stock`; `INSUFFICIENT_STOCK` |
| `INFO` | a normal event of the business flow | `saga.started`, `saga.step.completed`, `http.request.completed` |
| `DEBUG` | detail for a developer, off in `main` | the request line a participant client builds, without bodies |
