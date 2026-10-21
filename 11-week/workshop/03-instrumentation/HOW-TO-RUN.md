# HOW-TO-RUN - `opti-workflow-obs`

A small slice of `opti-workflow` that shows the CP1 to CP4 contracts working: trace context
filter, JSON logger (CP2 format), propagation to `opti-products-api` and two metrics.
JDK only, no Maven and no libraries. Tested with Temurin 25 (any JDK 21+ works).

```bash
cd 11-week/workshop/03-instrumentation/opti-workflow-obs
javac -d out $(find src test -name '*.java')       # install: nothing to download
java -cp out co.edu.corhuila.opti.workflow.obs.PropagationTest   # test
java -cp out co.edu.corhuila.opti.workflow.obs.WorkflowApp        # run: port 8085
```

Environment (all optional): `PORT` (8085), `PRODUCTS_URL` (`http://localhost:8082`),
`ENVIRONMENT` (`develop`), `DEMO_FRAME_ID`.

Manual check with the app running:

```bash
curl -i -X POST localhost:8085/api/v1/sagas/place-order \
  -H 'traceparent: 00-9c1e7a34d2f84b6a8f03b5e7c1d29a64-a1b2c3d4e5f60718-01'
curl localhost:8085/metrics
```

## Files

| File | Role |
|---|---|
| `TraceContext.java` | parse, create and format `traceparent`; `child()` makes the next span |
| `TraceContextFilter.java` | reads or creates the context, returns it in the response, logs start and end |
| `JsonLog.java` | CP2 log line; masks the keys of the "never log" list |
| `StockCall.java` | outbound call `POST /api/v1/frames/{id}/reservations` with a child `traceparent` |
| `Metrics.java` | `workflow_saga_requests_total` and `workflow_saga_duration_seconds` |
| `WorkflowApp.java` | `POST /api/v1/sagas/place-order` (only the `reserve-stock` hop) and `GET /metrics` |
| `test/.../PropagationTest.java` | proves the `trace_id` received equals the one sent downstream |

## Real output of my machine

Command: `java -cp out co.edu.corhuila.opti.workflow.obs.PropagationTest` (JSON lines shortened
here to the fields that matter; the full lines have the 11 contract fields).

```text
PASS  trace_id received equals trace_id sent downstream
PASS  response returns the same trace_id
PASS  downstream span is not the gateway span
PASS  a missing traceparent starts a new trace that still reaches products
PASS  a slow products-api writes participant.call.timeout
PASS  counter by outcome is exposed
PASS  latency histogram is exposed
ALL CHECKS PASSED
```

Three of the log lines the test printed (same `trace_id`, three different `span_id`):

```text
{"timestamp":"2026-10-20T23:51:54.431Z","level":"INFO","service":"opti-workflow", ... "trace_id":"9c1e7a34d2f84b6a8f03b5e7c1d29a64","span_id":"afaf7bd705f61604","event":"saga.started", ...}
{"timestamp":"2026-10-20T23:51:54.451Z","level":"INFO","service":"opti-workflow", ... "trace_id":"9c1e7a34d2f84b6a8f03b5e7c1d29a64","span_id":"8e32f4a7a68277c4","event":"participant.call.completed","duration_ms":19, ...}
{"timestamp":"2026-10-20T23:51:54.762Z","level":"WARN","service":"opti-workflow", ... "trace_id":"9c1e7a34d2f84b6a8f03b5e7c1d29a64","span_id":"5625655c182ff009","event":"participant.call.timeout","duration_ms":305, ...}
```

## Known limits

- Only the `reserve-stock` hop is implemented; `check-patient` and `open-order` would use the same call pattern.
- Spans are not exported to the collector yet; `trace_id` and `span_id` live in headers and logs.
- The `traceparent` stored in Redis for the async resume (CP1, step 6) is a design, not code.
