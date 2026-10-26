<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       12-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 12

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document cloud deployment models and zero-downtime strategies (rolling / blue-green / canary); document the deployment plan, Infrastructure as Code and rollback loop; map both to OptiView's Git Flow / GHCR / Flyway / SemVer after MVP 2; and complete the guided observability workshop on the `place-order` saga (CP0–CP9 + reflection).
<!-- CONFIG-END -->

> **Week window:** Monday **2026-10-19** → Sunday **2026-10-25** (each course week is Mon–Sun).  
> **Week 12 deliverable:** (1) study notes + visuals on **cloud deployment** and **deployment plan / IaC / rollback**, (2) OptiView mapping onto the shipped MVP 2 release path, and (3) **guided observability workshop** on `place-order` (artifacts under `11-week/workshop/`, executed 20–21 Oct inside this week window).

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-143 | Document cloud deployment — models, strategies and zero-downtime | done | [`cloud-deployment-models-strategies.md`](./cloud-deployment-models-strategies.md) |
| HU-OPT-144 | Produce visual summary of cloud deployment models / strategies | done | [`cloud-deployment-models-strategies-vertical.png`](./cloud-deployment-models-strategies-vertical.png) |
| HU-OPT-145 | Document deployment plan, Infrastructure as Code and rollback | done | [`deployment-plan-iac-rollback.md`](./deployment-plan-iac-rollback.md) |
| HU-OPT-146 | Produce visual summary of deployment plan / IaC / rollback | done | [`deployment-plan-iac-rollback-vertical.png`](./deployment-plan-iac-rollback-vertical.png) |
| HU-OPT-147 | Observability workshop Delivery 1 — journey, log contract, instrumentation, metrics (CP0–CP4) | done | [`../workshop/`](../../11-week/workshop/) · [`50be758`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/50be758) … [`d020764`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/d020764) · summary [`resumen-observabilidad.md`](./resumen-observabilidad.md) |
| HU-OPT-148 | Observability workshop Delivery 2 — SLOs, burn-rate alerts, runbook, incident drill (CP6–CP9) + reflection | done | [`05-slo.md`](../../11-week/workshop/05-slo.md) · [`06-alerts.yml`](../../11-week/workshop/06-alerts.yml) · [`07-runbook.md`](../../11-week/workshop/07-runbook.md) · [`08-incident.md`](../../11-week/workshop/08-incident.md) · [`7767691`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/7767691) · [reflection Doc](https://docs.google.com/document/d/1wNcQKXvOGbR3IC6YAwaY2q2N6iZZHF96EAHxq3cKygA/edit?usp=sharing) |

## 2. My individual contribution

> **Author:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Week 12 scope (Mon–Sun):** cloud deployment + IaC/rollback notes; guided observability workshop on OptiView `place-order` (folder lives under `11-week/workshop/` by course layout; work dates 20–21 Oct = Week 12).

### Study notes and visuals (this week)

| Artifact | What it covers |
|----------|----------------|
| [`cloud-deployment-models-strategies.md`](./cloud-deployment-models-strategies.md) | IaaS / PaaS / containers / serverless; registry → orchestrator → LB → health checks; rolling / blue-green / canary; horizontal / autoscaling |
| [`cloud-deployment-models-strategies-vertical.png`](./cloud-deployment-models-strategies-vertical.png) | Visual summary of those concepts |
| [`deployment-plan-iac-rollback.md`](./deployment-plan-iac-rollback.md) | Written deployment plan, declarative IaC, pre-deploy checklist, rollback triggers, Plan → Provision → Deploy → Verify → Keep/Rollback |
| [`deployment-plan-iac-rollback-vertical.png`](./deployment-plan-iac-rollback-vertical.png) | Visual summary of the safe-release loop |
| [`resumen-observabilidad.md`](./resumen-observabilidad.md) | Compact workshop facts: checkpoints, SLOs, alerts, incident drill, verification status, plan for real code |

### Guided observability workshop (executed this week)

Critical journey: `place-order` saga (`opti-workflow` via gateway → customers / products / sales). Goal: go from “I don’t know what happened” to traces, structured logs, metrics, SLO, burn-rate alerts, runbook and a blameless incident drill.

| Delivery | When | Checkpoints | Outcome |
|----------|------|-------------|---------|
| 1 (in class) | Tue 20 Oct | CP0–CP4 | Journey map, JSON log contract, JDK-only `opti-workflow-obs` module (`traceparent`, metrics), golden signals catalog — tests **7/7 ALL CHECKS PASSED** |
| 2 (take-home) | Tue–Wed 20–21 Oct | CP6–CP9 (+ CP10 plan in reflection) | SLO 99.5% avail / 99% &lt; 2 s latency (hypothesized 600 sagas/day); Prometheus burn-rate rules; runbook; products-api latency drill |

Assumed traffic for the SLO: 8 stores × 75 sagas/day = **600/day** (MVP 2 only on develop/qa — no real prod traffic yet). Alert design follows **user symptoms**, not CPU. Full checkpoint ↔ commit table: [`resumen-observabilidad.md`](./resumen-observabilidad.md) and Week 11 §7.

### OptiView mapping (cloud / IaC + workshop)

| Concept | Where it shows up in OptiView |
|---------|-------------------------------|
| Containers + registry | Docker images; CI → **GHCR** on `develop` |
| Env promotion | `feat/*` → `develop` → `qa-*` → `release/x.y.z` → `main` (one PR per env) |
| Versioned artifacts / rollback | SemVer `v2.0.0` / `v2.1.0`; Flyway `U*` undos |
| Observability intake | `opti-infra` otel-collector / Prometheus / Grafana; workshop rules ready to copy into `observability/` |
| Trace propagation | Workshop `traceparent` + JSON logs with `trace_id` / `correlation_id` for the five place-order participants |
| Release verify | Health + burn-rate alerts + runbook before Keep/Rollback |

### Continuity

| Week | What we already have | How Week 12 uses it |
|------|----------------------|---------------------|
| 11 | Observability theory + SLI/SLO framing; MVP 2 expo | Workshop turns theory into place-order artifacts; cloud week uses signals for Keep/Rollback |
| 10 | MVP 2 tagged; seeds via `release/2.1.0` | Concrete versioned cut + Git Flow evidence |
| 09 | Progressive delivery | Canary/rings vocabulary meets env promotion |

### Ceremonies & flow (this week)

| Ceremony | When / evidence |
|----------|-----------------|
| Planning | Mon kickoff: cloud/IaC notes + finish observability workshop CP0–CP9 (`SPRINT_GOAL`) |
| Daily | Async: workshop checkpoint progress (Tue class + take-home), align release-tag naming |
| Review | Walkthrough cloud strategies vs OptiView promote path; workshop Delivery 1 in class + Delivery 2 reflection |
| Retro | Alert on user-facing burn rate, not CPU; keep one PR per env + prior SemVer for rollback; next: promote/rollback runbook + wire workshop rules into `opti-infra` |
| Per-env PRs | Study + workshop week — no new product PRs. Carry-forward: products-db [#13](https://github.com/code-corhuila/opti-products-db/pull/13)/[#14](https://github.com/code-corhuila/opti-products-db/pull/14)/[#15](https://github.com/code-corhuila/opti-products-db/pull/15); auth-db [#10](https://github.com/code-corhuila/opti-auth-db/pull/10)–[#12](https://github.com/code-corhuila/opti-auth-db/pull/12); sales-db [#10](https://github.com/code-corhuila/opti-sales-db/pull/10)–[#12](https://github.com/code-corhuila/opti-sales-db/pull/12) |

## 3. Blockers and risks

- Shared cloud target (managed K8s vs PaaS) not yet a team ADR — Compose + GHCR today.
- Secret store for qa/main still undecided (`opti-infra`).
- Workshop SLO traffic is **hypothesized** (no real prod load); `promtool` not installed locally; CP3 module is not the real `opti-workflow` service yet.
- Full dual-cluster blue-green/canary is planned vocabulary; promotion today is env branches + tags.
- Coordinate structured-log field names with teammates (e.g. Bairon) before landing on shared APIs.

## 4. Plan for next week

- Security study (authn/authz/zero trust + threat modeling) — Week 13 topic.
- Draft OptiView promote/rollback runbook; copy burn-rate rules into `opti-infra/observability` after `promtool check`.
- Real-code plan from workshop: `traceparent` at gateway + JSON logs on the five place-order services.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [x] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week window is Mon–Sun. Workshop files sit under `11-week/workshop/` (course folder name) but commits dated **20–21 Oct** are Week 12 work. Team uses `feat/*` by agreement; one PR per environment when shipping product. Course-fork HU-status on `main`.

## 6. Evidence links

**Course fork (Week 12 docs):**

- [`cloud-deployment-models-strategies.md`](./cloud-deployment-models-strategies.md)
- [`cloud-deployment-models-strategies-vertical.png`](./cloud-deployment-models-strategies-vertical.png)
- [`deployment-plan-iac-rollback.md`](./deployment-plan-iac-rollback.md)
- [`deployment-plan-iac-rollback-vertical.png`](./deployment-plan-iac-rollback-vertical.png)
- [`resumen-observabilidad.md`](./resumen-observabilidad.md)

**Observability workshop (executed Week 12; files under 11-week):**

- https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/tree/main/11-week/workshop
- Reflection: https://docs.google.com/document/d/1wNcQKXvOGbR3IC6YAwaY2q2N6iZZHF96EAHxq3cKygA/edit?usp=sharing
- Representative commits: [`50be758`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/50be758) · [`d866d03`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/d866d03) · [`d2e581a`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/d2e581a) · [`5377b37`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/5377b37) · [`7767691`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/7767691)

**OptiView release / deploy path:**

- Tags: https://github.com/code-corhuila/opti-front/releases/tag/v2.0.0 · https://github.com/code-corhuila/opti-products-db/releases/tag/v2.1.0
- Infra: https://github.com/code-corhuila/opti-infra

**Related prior work:**

- Week 11: [`11-week/hu-status/README.md`](../../11-week/hu-status/README.md)
- Week 10: [`10-week/hu-status/README.md`](../../10-week/hu-status/README.md)
