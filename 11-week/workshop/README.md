# Week 11 workshop - Observability, SLOs and incident response

Individual work of Juan Diego Tovar Rodriguez. Journey observed: `place-order` saga of OptiView.

<!-- CONFIG-START -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- DOCS_REPO: https://github.com/code-corhuila/opti-docs
- REFLECTION_DOC: https://docs.google.com/document/d/1wNcQKXvOGbR3IC6YAwaY2q2N6iZZHF96EAHxq3cKygA/edit?usp=sharing
- JOURNEY: place-order saga - a seller opens a quotation for a patient and a frame (opti-api-gateway -> opti-workflow -> opti-customers-api, opti-products-api, opti-sales-api)
<!-- CONFIG-END -->

## Contents

| File | Checkpoint |
|---|---|
| [01-journey.md](01-journey.md) | CP1 |
| [02-log-contract.md](02-log-contract.md) | CP2 |
| [03-instrumentation/](03-instrumentation/HOW-TO-RUN.md) | CP3 |
| [04-metrics.md](04-metrics.md) | CP4 |
| [05-slo.md](05-slo.md) | CP6 |
| [06-alerts.yml](06-alerts.yml), [06-alert-policy.md](06-alert-policy.md) | CP7 |
| [07-runbook.md](07-runbook.md) | CP8 |
| [08-incident.md](08-incident.md) | CP9 |

## What I own in OptiView

Facts that every file of this workshop relies on, all taken from `opti-docs` and from the
READMEs of the repositories:

- `opti-workflow` runs the sagas `place-order` and `cancel-order`; its state is in Redis.
- `opti-api-gateway` is the only entry point and already forwards `X-Correlation-Id`.
- `opti-customers-api`, `opti-products-api` and `opti-sales-api` are called only through their published API.
- `opti-infra/observability` already has `otel-collector`, `prometheus` and `grafana`; no service sends traces yet.
