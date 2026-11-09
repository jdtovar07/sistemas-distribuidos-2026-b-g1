<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       15-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 15

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document testing at scale (contract, E2E, load, chaos) and the production-grade MVP 3 release checklist; map both onto OptiView after MVP 2; and land the invoice-PDF / private payment-evidence vertical slice on `develop` (PRs open, awaiting CI green + merge).
<!-- CONFIG-END -->

> **Week window:** Monday **2026-11-09** → Sunday **2026-11-15** (each course week is Mon–Sun).  
> **Week 15 deliverable:** (1) study notes + visuals on **testing at scale**, (2) **shipping MVP 3 / production-grade release**, and (3) **payment PDF / private receipt** slice — commits authored, PRs open to `develop`, **not merged yet** (waiting on checks / team merge).

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-159 | Document testing at scale — contract, E2E, load and chaos | done | [`testing-at-scale-contract-e2e-load-chaos.md`](./testing-at-scale-contract-e2e-load-chaos.md) |
| HU-OPT-160 | Produce visual summary of testing at scale | done | [`testing-at-scale-contract-e2e-load-chaos-vertical.png`](./testing-at-scale-contract-e2e-load-chaos-vertical.png) |
| HU-OPT-161 | Document shipping MVP 3 — production-grade release | done | [`release-shipping-mvp3-production-grade.md`](./release-shipping-mvp3-production-grade.md) |
| HU-OPT-162 | Produce visual summary of MVP 3 production-grade release | done | [`release-shipping-mvp3-production-grade-vertical.png`](./release-shipping-mvp3-production-grade-vertical.png) |
| HU-OPT-163 | Persist private payment receipts in `opti-sales-db` (V020) | doing | commit [`972c2fe`](https://github.com/code-corhuila/opti-sales-db/commit/972c2fe) · PR [#20](https://github.com/code-corhuila/opti-sales-db/pull/20) → `develop` (**open, awaiting merge**) |
| HU-OPT-164 | Invoice PDFs + protected simulated payments with private evidence in `opti-sales-api` | doing | commit [`04caffd`](https://github.com/code-corhuila/opti-sales-api/commit/04caffd) · PR [#18](https://github.com/code-corhuila/opti-sales-api/pull/18) → `develop` (**open, awaiting merge / CI**) |
| HU-OPT-165 | Invoice downloads + simulated payment confirmation UX in `opti-sales-portal` | doing | commit [`2e161bd`](https://github.com/code-corhuila/opti-sales-portal/commit/2e161bd) · PR [#19](https://github.com/code-corhuila/opti-sales-portal/pull/19) → `develop` (**open, awaiting merge / CI**) |
| HU-OPT-166 | Allow large private receipt payloads only on payment creation in `opti-api-gateway` | doing | commit [`a2b6e85`](https://github.com/code-corhuila/opti-api-gateway/commit/a2b6e85) · PR [#17](https://github.com/code-corhuila/opti-api-gateway/pull/17) → `develop` (**open, awaiting merge / CI**) |
| HU-OPT-167 | Authenticated downloads, visible icons and sidebar nav polish in `opti-front` | doing | commit [`d330808`](https://github.com/code-corhuila/opti-front/commit/d330808) · PR [#30](https://github.com/code-corhuila/opti-front/pull/30) → `develop` (**open, awaiting merge / CI**) |

## 2. My individual contribution

> **Author:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Week 15 scope (Mon–Sun):** testing-at-scale + MVP 3 production-readiness notes; gap analysis; **payment PDF / private-evidence** vertical slice (my commits on open PRs — merge pending).

### Vertical slice in flight — invoice PDF + private payment evidence (awaiting merge)

Cross-repo cut toward production-grade payments (complements MVP 2 billing). **Author of the commits below: Juan Diego Tovar Rodriguez.** PRs opened by teammate @BackSua to `develop`; related products/customers PDF PRs are teammate-owned. **Not merged yet** — waiting for CI to go green and team merge before promoting to `qa` / `main`.

| Repo | My commit | Open PR → develop | Status |
|------|-----------|-------------------|--------|
| `opti-sales-db` | [`972c2fe`](https://github.com/code-corhuila/opti-sales-db/commit/972c2fe) private payment receipts | [#20](https://github.com/code-corhuila/opti-sales-db/pull/20) | open (mergeable) |
| `opti-sales-api` | [`04caffd`](https://github.com/code-corhuila/opti-sales-api/commit/04caffd) invoice PDFs + simulated payments + private evidence | [#18](https://github.com/code-corhuila/opti-sales-api/pull/18) | open (CI unstable) |
| `opti-sales-portal` | [`2e161bd`](https://github.com/code-corhuila/opti-sales-portal/commit/2e161bd) invoice downloads + payment confirmation | [#19](https://github.com/code-corhuila/opti-sales-portal/pull/19) | open (CI unstable) |
| `opti-api-gateway` | [`a2b6e85`](https://github.com/code-corhuila/opti-api-gateway/commit/a2b6e85) large receipt payloads only on payment create | [#17](https://github.com/code-corhuila/opti-api-gateway/pull/17) | open (CI unstable) |
| `opti-front` | [`d330808`](https://github.com/code-corhuila/opti-front/commit/d330808) authenticated downloads + shell polish | [#30](https://github.com/code-corhuila/opti-front/pull/30) | open (CI unstable) |

Teammate companion PRs (same feature train, not my commits): products-api [#12](https://github.com/code-corhuila/opti-products-api/pull/12) · products-portal [#12](https://github.com/code-corhuila/opti-products-portal/pull/12) · customers-api [#7](https://github.com/code-corhuila/opti-customers-api/pull/7) · customers-portal [#12](https://github.com/code-corhuila/opti-customers-portal/pull/12).

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
| E2E critical path | Manual demos / classroom expo; **few automated** place-order journeys in CI; payment PDF slice adds a richer billing path once merged |
| Payment / invoice evidence (in flight) | Private receipts + invoice PDFs + gateway payload rules — **open PRs to `develop`** (HU-OPT-163…167) |
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
| Planning | Mon kickoff: testing-at-scale + MVP 3 notes; track payment-PDF PRs to `develop` (`SPRINT_GOAL`) |
| Daily | Async: CI status on open PRs #17/#18/#19/#20/#30; coordinate merge with @BackSua |
| Review | Readiness checklist + demo of payment evidence once PRs land on `develop` |
| Retro | MVP 2 proved integration; finish merge of payment slice then promote per env; still need contracts + E2E + load before `v3.0.0` |
| Per-env PRs | First target: merge feat → **`develop`** (open now). Then `qa-*` / `release` / `main` once CI is green — one PR per environment |

## 3. Blockers and risks

- **Payment-PDF PRs open but not merged** — several show CI **FAILURE / UNSTABLE**; blocked on green checks before promote.
- No shared contract-test suite or load baseline yet — MVP 3 tag would be premature without them.
- Secret store / Redis password hardening still open (Week 13 backlog).
- Branch protection and SAST gates not uniform across all `opti-*` repos.
- OTel SDK not fully emitted from every API — observability checklist partially met.

## 4. Plan for next week

- Get HU-OPT-163…167 PRs **CI-green and merged to `develop`**, then promote through qa → main.
- Draft a minimal contract-test plan for gateway ↔ sales/products on the place-order path.
- Candidate: one automated E2E smoke (login + place-order + invoice download) in CI on `develop`.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [x] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week window is Mon–Sun. Study notes + vertical slice in flight (PRs open, not merged). Team uses `feat/*` by agreement; one PR per environment when shipping product. Course-fork HU-status commits on `main`.

## 6. Evidence links

**Course fork (Week 15 docs):**

- [`testing-at-scale-contract-e2e-load-chaos.md`](./testing-at-scale-contract-e2e-load-chaos.md)
- [`testing-at-scale-contract-e2e-load-chaos-vertical.png`](./testing-at-scale-contract-e2e-load-chaos-vertical.png)
- [`release-shipping-mvp3-production-grade.md`](./release-shipping-mvp3-production-grade.md)
- [`release-shipping-mvp3-production-grade-vertical.png`](./release-shipping-mvp3-production-grade-vertical.png)

**Open PRs (my commits — awaiting merge to `develop`):**

- https://github.com/code-corhuila/opti-sales-db/pull/20 · https://github.com/code-corhuila/opti-sales-db/commit/972c2fe
- https://github.com/code-corhuila/opti-sales-api/pull/18 · https://github.com/code-corhuila/opti-sales-api/commit/04caffd
- https://github.com/code-corhuila/opti-sales-portal/pull/19 · https://github.com/code-corhuila/opti-sales-portal/commit/2e161bd
- https://github.com/code-corhuila/opti-api-gateway/pull/17 · https://github.com/code-corhuila/opti-api-gateway/commit/a2b6e85
- https://github.com/code-corhuila/opti-front/pull/30 · https://github.com/code-corhuila/opti-front/commit/d330808

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
