<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       15-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 15

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document testing at scale (contract, E2E, load, chaos) and the production-grade MVP 3 release checklist; map both onto OptiView after MVP 2 (place-order saga, CI/GHCR, observability stack, security backlog) as the gap analysis toward a v3.0.0 production cut.
<!-- CONFIG-END -->

> **Week window:** Monday **2026-11-09** → Sunday **2026-11-15** (each course week is Mon–Sun).  
> **Week 15 deliverable:** (1) study notes + visuals on **testing at scale**, and (2) **shipping MVP 3 / production-grade release**, mapped to what OptiView already has vs what is still missing for a production cut.

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-159 | Document testing at scale — contract, E2E, load and chaos | done | [`testing-at-scale-contract-e2e-load-chaos.md`](./testing-at-scale-contract-e2e-load-chaos.md) |
| HU-OPT-160 | Produce visual summary of testing at scale | done | [`testing-at-scale-contract-e2e-load-chaos-vertical.png`](./testing-at-scale-contract-e2e-load-chaos-vertical.png) |
| HU-OPT-161 | Document shipping MVP 3 — production-grade release | done | [`release-shipping-mvp3-production-grade.md`](./release-shipping-mvp3-production-grade.md) |
| HU-OPT-162 | Produce visual summary of MVP 3 production-grade release | done | [`release-shipping-mvp3-production-grade-vertical.png`](./release-shipping-mvp3-production-grade-vertical.png) |

## 2. My individual contribution

> **Author:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Week 15 scope (Mon–Sun):** testing-at-scale + MVP 3 production-readiness notes; gap analysis against the shipped MVP 2 platform.

### Study notes and visuals (this week)

| Artifact | What it covers |
|----------|----------------|
| [`testing-at-scale-contract-e2e-load-chaos.md`](./testing-at-scale-contract-e2e-load-chaos.md) | Distributed testing pyramid; contract tests (Pact); integration with real deps; E2E; load (k6/JMeter); chaos engineering |
| [`testing-at-scale-contract-e2e-load-chaos-vertical.png`](./testing-at-scale-contract-e2e-load-chaos-vertical.png) | Visual summary of those concepts |
| [`release-shipping-mvp3-production-grade.md`](./release-shipping-mvp3-production-grade.md) | What “production-grade” means; MVP 1→2→3; readiness checklist; tag → zero-downtime → smoke → golden signals → keep/rollback; operability |
| [`release-shipping-mvp3-production-grade-vertical.png`](./release-shipping-mvp3-production-grade-vertical.png) | Visual summary of the MVP 3 release loop |

### OptiView gap map (MVP 2 today → MVP 3 production-grade)

| Production-grade item | OptiView status (today) |
|-----------------------|-------------------------|
| Unit / CI tests | Present on several repos (e.g. `opti-front` CI: test + build on PR to develop/qa/main) |
| Contract tests | Documented since Week 07; **not** yet a blocking Pact-style gate across gateway ↔ APIs |
| E2E critical path | Manual demos / classroom expo; **few automated** place-order journeys in CI |
| Load / chaos | **Not run** systematically against SLOs; workshop SLO traffic was hypothesized |
| Observability | `otel-collector` / Prometheus / Grafana composed; SDK emission still progressive (Weeks 11–12) |
| Security | JWT + SERVICE_TOKEN; Week 13 workshop (Redis boundary, CI negative test) — secret store / Redis requirepass still backlog |
| CI/CD + DoD gates | Week 14 notes; GHCR publish on develop; branch protection uneven across 19 repos |
| Versioned release | SemVer `v2.0.0` / `v2.1.0` tags + Flyway `U*` undos — pattern ready for a future `v3.0.0` |
| Runbooks / on-call / SLOs | Method documented (Weeks 11–12); numeric SLOs and runbooks not fully ratified |

**Critical journey to prove for MVP 3:** login → place-order saga (gateway → customers / products / sales / workflow) → payment path — with contract tests on each hop, one E2E smoke, and load against the Week 12 hypothesized peak before tagging `v3.0.0`.

### Continuity

| Week | What we already have | How Week 15 uses it |
|------|----------------------|---------------------|
| 14 | CI/CD, DoD-as-gates, branch protection | Gates that must stay green for a production-grade cut |
| 13 | AuthN/AuthZ, threat model, Redis workshop | Security checklist item for MVP 3 |
| 11–12 | Observability + release/rollback + place-order workshop | Golden signals + Keep/Rollback during the MVP 3 release |
| 10 | MVP 2 tagged `v2.0.0` | Baseline “it works together”; MVP 3 raises the bar to “operable in production” |

### Ceremonies & flow (this week)

| Ceremony | When / evidence |
|----------|-----------------|
| Planning | Mon kickoff: testing-at-scale + MVP 3 production-grade notes; gap map vs OptiView (`SPRINT_GOAL`) |
| Daily | Async: study progress; list missing contract/E2E/load items per BC |
| Review | Walkthrough readiness checklist against current MVP 2 evidence (tags, CI, otel, security workshop) |
| Retro | MVP 2 proved integration; next cut needs automated contracts + one E2E + load before `v3.0.0`; keep one PR per env |
| Per-env PRs | Study week — no new product PRs. Carry-forward env pattern from Week 10 seed promotes |

## 3. Blockers and risks

- No shared contract-test suite or load baseline yet — MVP 3 tag would be premature without them.
- Secret store / Redis password hardening still open (Week 13 backlog).
- Branch protection and SAST gates not uniform across all `opti-*` repos.
- OTel SDK not fully emitted from every API — observability checklist partially met.

## 4. Plan for next week

- Draft a minimal contract-test plan for gateway ↔ sales/products on the place-order path.
- Candidate: one automated E2E smoke (login + place-order) in CI on `develop`.
- Optional: first k6 script against gateway health/latency using the hypothesized SLO.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [x] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week window is Mon–Sun. Study week: testing + MVP 3 readiness mapped onto shipped MVP 2. Team uses `feat/*` by agreement; one PR per environment when shipping product. Course-fork HU-status commits on `main`.

## 6. Evidence links

**Course fork (Week 15 docs):**

- [`testing-at-scale-contract-e2e-load-chaos.md`](./testing-at-scale-contract-e2e-load-chaos.md)
- [`testing-at-scale-contract-e2e-load-chaos-vertical.png`](./testing-at-scale-contract-e2e-load-chaos-vertical.png)
- [`release-shipping-mvp3-production-grade.md`](./release-shipping-mvp3-production-grade.md)
- [`release-shipping-mvp3-production-grade-vertical.png`](./release-shipping-mvp3-production-grade-vertical.png)

**Prior OptiView evidence this week builds on:**

- MVP 2 tags: https://github.com/code-corhuila/opti-front/releases/tag/v2.0.0
- CI/publish: https://github.com/code-corhuila/opti-front/blob/main/.github/workflows/ci.yml
- Observability: https://github.com/code-corhuila/opti-infra
- W13 workshop: [`13-week/workshop/`](../../13-week/workshop/)
- W14 CI/DoD: [`14-week/hu-status/README.md`](../../14-week/hu-status/README.md)

**Related prior work:**

- Week 14: [`14-week/hu-status/README.md`](../../14-week/hu-status/README.md)
- Week 12: [`12-week/hu-status/README.md`](../../12-week/hu-status/README.md)
- Week 10: [`10-week/hu-status/README.md`](../../10-week/hu-status/README.md)
