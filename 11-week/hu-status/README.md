<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       11-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 11

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document observability (logs, metrics, distributed tracing) and reliability planning (SLIs, SLOs, error budgets, alerting); map those practices to OptiView's existing otel-collector / Prometheus / Grafana stack; and present MVP 2 live to the whole class and the professor.
<!-- CONFIG-END -->

> **Week window:** Monday **2026-10-12** → Sunday **2026-10-18** (each course week is Mon–Sun).  
> **Week 11 deliverable:** (1) study notes + visuals on **observability** and **SLIs/SLOs**, (2) OptiView mapping to the Week 10 MVP 2 platform, and (3) **classroom expo** of MVP 2 to the class and the professor.

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-138 | Document observability — logs, metrics and distributed tracing | done | [`observability-logs-metrics-tracing.md`](./observability-logs-metrics-tracing.md) |
| HU-OPT-139 | Produce visual summary of observability (three pillars + golden signals) | done | [`observability-logs-metrics-tracing-vertical.png`](./observability-logs-metrics-tracing-vertical.png) |
| HU-OPT-140 | Document reliability planning — SLIs, SLOs, error budgets and alerting | done | [`reliability-slis-slos.md`](./reliability-slis-slos.md) |
| HU-OPT-141 | Produce visual summary of SLIs / SLOs / error budgets | done | [`reliability-slis-slos-vertical.png`](./reliability-slis-slos-vertical.png) |
| HU-OPT-142 | Present OptiView MVP 2 live to the class and the professor | done | Classroom expo (Week 11) · platform tags [`v2.0.0`](https://github.com/code-corhuila/opti-front/releases/tag/v2.0.0) / [`v2.1.0`](https://github.com/code-corhuila/opti-products-db/releases/tag/v2.1.0) · live stack via `opti-infra` + optional ngrok demo tunnel |

## 2. My individual contribution

> **Author:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Week 11 scope (Mon–Sun):** observability + reliability study notes/visuals; MVP 2 classroom presentation built on the Week 10 release.

### Study notes and visuals (this week)

| Artifact | What it covers |
|----------|----------------|
| [`observability-logs-metrics-tracing.md`](./observability-logs-metrics-tracing.md) | Three pillars (logs / metrics / traces), correlation IDs, golden signals, monitoring vs observability |
| [`observability-logs-metrics-tracing-vertical.png`](./observability-logs-metrics-tracing-vertical.png) | Visual summary of those concepts |
| [`reliability-slis-slos.md`](./reliability-slis-slos.md) | SLI / SLO / SLA, error budgets, burn-rate alerting, reliability loop |
| [`reliability-slis-slos-vertical.png`](./reliability-slis-slos-vertical.png) | Visual summary of reliability planning |

### OptiView mapping (how Week 11 concepts land on MVP 2)

| Concept | Where it shows up in OptiView |
|---------|-------------------------------|
| Metrics + traces intake | `opti-infra` runs `otel-collector` (OTLP) → Prometheus scrape → Grafana datasource |
| Correlation across services | Platform checklist: same `X-Correlation-Id` / `traceId` across gateway and domain services |
| Golden signals (planning) | Latency / traffic / errors / saturation as the lens for future portal & API SLOs (gateway + auth/sales/products) |
| Error budget (planning) | Explicit reliability target before more evolutionary slices; freeze risky changes when budget is spent |
| Live MVP 2 | Classroom expo of the integrated system tagged `v2.0.0` (all 19 `opti-*`) with post-seed tips `v2.1.0` on products/auth/sales db + docs |

### Classroom expo — MVP 2 (this week)

Presented **OptiView MVP 2** to the whole class and the professor: multi-repo Git Flow platform (`feat/*` → develop → qa → release → main), vertical slices from Week 09–10 scaffolds, demo seeds, and the observability stack already composed in `opti-infra`. Live demo path: `./scripts/up.sh` + migrations + optional public tunnel (ngrok) over the demo proxy so the SPA uses one origin for gateway + front.

### Continuity

| Week | What we already have | How Week 11 uses it |
|------|----------------------|---------------------|
| 10 | MVP 2 tagged `v2.0.0`, seeds on `release/2.1.0` → main, vertical slices | Expo + reliability/observability framing on that shipped cut |
| 09 | Evolutionary scaffolds (auth/sales/gateway/front/worker/workflow) | Those services are what we observe and set SLOs against |
| 06–08 | 19-repo layout, contracts, Agile/DevOps planning | Same team flow and board for the classroom review |

### Ceremonies & flow (this week)

| Ceremony | When / evidence |
|----------|-----------------|
| Planning | Mon kickoff: observability + SLI/SLO notes, OptiView mapping, prepare MVP 2 classroom expo (`SPRINT_GOAL`) |
| Daily | Async check-ins: who presents which slice, demo script, infra up/down for rehearsal |
| Review | **Classroom expo** of MVP 2 to the class and the professor (live platform + release tags) |
| Retro | Keep `feat/*` → develop → `qa-*` → `release/*` → main; next: wire more OTel from services into the existing collector; draft concrete SLOs for gateway + sales |
| Per-env PRs | No new product PRs this week (study + expo). Carry-forward evidence from Week 10 per-env seed flow: products-db [#13](https://github.com/code-corhuila/opti-products-db/pull/13)/[#14](https://github.com/code-corhuila/opti-products-db/pull/14)/[#15](https://github.com/code-corhuila/opti-products-db/pull/15); auth-db [#10](https://github.com/code-corhuila/opti-auth-db/pull/10)–[#12](https://github.com/code-corhuila/opti-auth-db/pull/12); sales-db [#10](https://github.com/code-corhuila/opti-sales-db/pull/10)–[#12](https://github.com/code-corhuila/opti-sales-db/pull/12) |

## 3. Blockers and risks

- Observability stack in `opti-infra` is ready to receive OTel, but full SDK instrumentation across every `opti-*-api` is still progressive — collector alone does not invent spans.
- Concrete numeric SLOs for gateway / sales / auth are not yet ratified by the team (this week documents the method).
- Secret store for shared environments still undecided (`opti-infra`).
- Public demo tunnel (ngrok) is optional ops only — credentials stay off-repo.

## 4. Plan for next week

- Draft candidate SLOs (availability + latency) for `opti-api-gateway` and place-order / payment paths.
- Start emitting OTel metrics/traces from at least one domain API into the existing collector.
- Keep portal UX for notifications / seller reports moving if capacity allows.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [x] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week window is Mon–Sun. Study + classroom expo week on top of the Week 10 MVP 2 cut. Team uses `feat/*` (not `hu-xxx-dev`) by agreement; one PR per environment when shipping product changes. Course-fork HU-status commits on `main`.

## 6. Evidence links

**Course fork (Week 11 docs):**

- [`observability-logs-metrics-tracing.md`](./observability-logs-metrics-tracing.md)
- [`observability-logs-metrics-tracing-vertical.png`](./observability-logs-metrics-tracing-vertical.png)
- [`reliability-slis-slos.md`](./reliability-slis-slos.md)
- [`reliability-slis-slos-vertical.png`](./reliability-slis-slos-vertical.png)

**MVP 2 expo (shipped platform):**

- Tags: https://github.com/code-corhuila/opti-front/releases/tag/v2.0.0 (same `v2.0.0` on every `opti-*` repo)
- Post-seed tips: https://github.com/code-corhuila/opti-products-db/releases/tag/v2.1.0 · https://github.com/code-corhuila/opti-auth-db/releases/tag/v2.1.0 · https://github.com/code-corhuila/opti-sales-db/releases/tag/v2.1.0 · https://github.com/code-corhuila/opti-docs/releases/tag/v2.1.0
- Observability compose: https://github.com/code-corhuila/opti-infra (`otel-collector` / `prometheus` / `grafana`)

**Related prior work:**

- Week 10: [`10-week/hu-status/README.md`](../../10-week/hu-status/README.md)
- Org repos: https://github.com/orgs/code-corhuila/repositories?q=opti

<!-- W11-WORKSHOP-START -->
## 7. Guided workshop - observability on my project (delivery 1)

Individual in-class workshop of 2026-10-20, checkpoints CP0 to CP4. Journey observed: the `place-order` saga of `opti-workflow` (`opti-api-gateway`, `opti-customers-api`, `opti-products-api`, `opti-sales-api`).

| Checkpoint | What | File | Commit |
|---|---|---|---|
| CP0 | Setup and CONFIG block | [`workshop/README.md`](../workshop/README.md) | [`50be758`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/50be75865a8607500088f5c90d82d6d706c68807) |
| CP1 | Critical journey `place-order` and trace map | [`workshop/01-journey.md`](../workshop/01-journey.md) | [`e74085d`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/e74085de5015c24504e3642980abd5ceddcddbfa) |
| CP2 | Structured log contract | [`workshop/02-log-contract.md`](../workshop/02-log-contract.md) | [`74e067e`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/74e067e174e7ec56e9bf04fcc896c084c6885318) |
| CP3 (push 1) | Trace-context filter and JSON logger | [`workshop/03-instrumentation/`](../workshop/03-instrumentation/) | [`e5c1c65`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/e5c1c65ce5a582b0f14a386428294b18d5ed2cac) |
| CP3 (push 2) | Downstream propagation, metrics and test | [`workshop/03-instrumentation/HOW-TO-RUN.md`](../workshop/03-instrumentation/HOW-TO-RUN.md) | pending |
| CP4 | Golden signals and metric catalog | [`workshop/04-metrics.md`](../workshop/04-metrics.md) | pending |

Reflection document: https://docs.google.com/document/d/1wNcQKXvOGbR3IC6YAwaY2q2N6iZZHF96EAHxq3cKygA/edit?usp=sharing
<!-- W11-WORKSHOP-END -->
