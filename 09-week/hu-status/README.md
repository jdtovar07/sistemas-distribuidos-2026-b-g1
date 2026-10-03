<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       09-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 09

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document configuration vs secrets vs feature flags; plan secure configuration and progressive delivery; fix opti-docs 07-api contracts per the Project Tracker; and scaffold the first evolutionary opti-* services (auth, sales, gateway, front shell, worker, workflow) on develop.
<!-- CONFIG-END -->

> **Week 09 deliverable — secure config + first evolutionary scaffolds.** After MVP 1 (Week 05), the 19-repo layout (Week 06), contracts + access (Week 07), and Agile/DevOps planning (Week 08), this week: (1) documents **configuration / secrets / feature flags** and **progressive delivery**, (2) applies the **Project Tracker (2026-09-28)** OpenAPI fixes in `opti-docs`, and (3) lands the **first hexagonal / Flyway / CI scaffolds** on `develop` for auth, sales, api-gateway, front shell, worker and workflow under `code-corhuila`.

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-075 | Document configuration, secrets and feature flags | done | [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md) |
| HU-OPT-076 | Produce visual summary of configuration, secrets and feature flags | done | [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png) |
| HU-OPT-077 | Document planning for secure configuration and progressive delivery | done | [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md) |
| HU-OPT-078 | Produce visual summary of secure configuration / progressive delivery | done | [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png) |
| HU-OPT-079 | Apply Project Tracker fixes to `opti-docs` 07-api contracts | done | https://github.com/code-corhuila/opti-docs/pull/20 |
| HU-OPT-080 | Scaffold `opti-auth-db` schema + Flyway CI | done | https://github.com/code-corhuila/opti-auth-db/pull/1 |
| HU-OPT-081 | Scaffold `opti-auth-api` hexagonal domain + REST + CI | done | https://github.com/code-corhuila/opti-auth-api/pull/1 |
| HU-OPT-082 | Scaffold `opti-auth-portal` login / session screens + CI | done | https://github.com/code-corhuila/opti-auth-portal/pull/1 |
| HU-OPT-083 | Scaffold `opti-sales-db` schema + Flyway CI | done | https://github.com/code-corhuila/opti-sales-db/pull/1 |
| HU-OPT-084 | Scaffold `opti-sales-api` hexagonal domain + REST + CI | done | https://github.com/code-corhuila/opti-sales-api/pull/1 |
| HU-OPT-085 | Scaffold `opti-sales-portal` POS / order screens + CI | done | https://github.com/code-corhuila/opti-sales-portal/pull/1 |
| HU-OPT-086 | Scaffold `opti-api-gateway` routing, JWT validation and rate limiting | done | https://github.com/code-corhuila/opti-api-gateway/pull/1 |
| HU-OPT-087 | Scaffold `opti-front` Module Federation shell + layout | done | https://github.com/code-corhuila/opti-front/pull/1 |
| HU-OPT-088 | Scaffold `opti-worker` event consumers and outbox dispatch | done | https://github.com/code-corhuila/opti-worker/pull/1 |
| HU-OPT-089 | Scaffold `opti-workflow` saga orchestrator and Redis state store | done | https://github.com/code-corhuila/opti-workflow/pull/1 |

## 2. My individual contribution

> **Scope this week:** study notes + `opti-docs` contract fixes **and** first implementation PRs on the evolutionary `code-corhuila/opti-*` repos (Git Flow: `feat/*` → `develop`). Author: Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).

### Study notes and visuals

| Artifact | What it covers |
|----------|----------------|
| [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md) | Configuration vs secrets vs feature flags |
| [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png) | Visual summary: Configure / Protect / Innovate |
| [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md) | Secure configuration + progressive delivery (canary / rings / flags) |
| [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png) | Visual summary of that planning |

### `opti-docs` 07-api contract fixes (Project Tracker 2026-09-28)

PR [`#20`](https://github.com/code-corhuila/opti-docs/pull/20) merged to `main` (`ee66ffa`). Commit [`184f0e2`](https://github.com/code-corhuila/opti-docs/commit/184f0e26e4876095a55cf1aa0d87e416e1320f13): idempotency on create POSTs, money in COP cents, `/lenses` + `/daily-closings`, gateway proxies for inventory/orders/billing, auth path note. Independent of teammate PR #19.

### Evolutionary scaffolds on `develop` (my authored PRs)

| Area | Repo | PR | What I shipped |
|------|------|----|----------------|
| Auth BC | `opti-auth-db` | [#1](https://github.com/code-corhuila/opti-auth-db/pull/1) | Flyway schema, seed, rollback + CI |
| Auth BC | `opti-auth-api` | [#1](https://github.com/code-corhuila/opti-auth-api/pull/1) | Hexagonal domain / application / REST + CI |
| Auth BC | `opti-auth-portal` | [#1](https://github.com/code-corhuila/opti-auth-portal/pull/1) | Login + session screens + CI |
| Sales BC | `opti-sales-db` | [#1](https://github.com/code-corhuila/opti-sales-db/pull/1) | Flyway schema, seed, rollback + CI |
| Sales BC | `opti-sales-api` | [#1](https://github.com/code-corhuila/opti-sales-api/pull/1) | Hexagonal domain / application / REST + CI |
| Sales BC | `opti-sales-portal` | [#1](https://github.com/code-corhuila/opti-sales-portal/pull/1) | Point-of-sale + order screens + CI |
| Platform | `opti-api-gateway` | [#1](https://github.com/code-corhuila/opti-api-gateway/pull/1) | Routing, JWT validation, rate limiting + CI |
| Platform | `opti-front` | [#1](https://github.com/code-corhuila/opti-front/pull/1) | Module Federation shell, shared contract, layout + CI |
| Platform | `opti-worker` | [#1](https://github.com/code-corhuila/opti-worker/pull/1) | Event consumers + outbox dispatch + CI |
| Platform | `opti-workflow` | [#1](https://github.com/code-corhuila/opti-workflow/pull/1) | Saga orchestrator + Redis state store + CI |

Representative commits (authored by me):

- Auth: [`33a8a47`](https://github.com/code-corhuila/opti-auth-db/commit/33a8a47) schema · [`7d5d9d9`](https://github.com/code-corhuila/opti-auth-api/commit/7d5d9d9) hexagonal API · [`821873e`](https://github.com/code-corhuila/opti-auth-portal/commit/821873e) login screens  
- Sales: [`9360871`](https://github.com/code-corhuila/opti-sales-db/commit/9360871) schema · [`e52c503`](https://github.com/code-corhuila/opti-sales-api/commit/e52c503) hexagonal API · [`af7e43a`](https://github.com/code-corhuila/opti-sales-portal/commit/af7e43a) POS screens  
- Platform: [`9628463`](https://github.com/code-corhuila/opti-api-gateway/commit/9628463) gateway · [`3ea7e3c`](https://github.com/code-corhuila/opti-front/commit/3ea7e3c) shell · [`0b34185`](https://github.com/code-corhuila/opti-worker/commit/0b34185) worker · [`e4a859c`](https://github.com/code-corhuila/opti-workflow/commit/e4a859c) saga  

### Mapping to OptiView

| Topic | OptiView application |
|-------|----------------------|
| Configuration / secrets / flags | Env-based config per `opti-*-api`; no secrets in git; flags for dark-launch while extracting from MVP 1 |
| Progressive delivery | Git Flow `feat` → `develop` → `qa` → `main`; small PRs per BC |
| Auth BC | `opti-auth-{db,api,portal}` — credentials / session path for portals and gateway JWT |
| Sales BC | `opti-sales-{db,api,portal}` — work orders / POS slice after contracts |
| Gateway + front | Edge routing + Module Federation shell so portals plug in without a big-bang rewrite |
| Worker + workflow | Async consumers / outbox and place-order saga — matches Week 01–07 event design |
| OpenAPI | Tracker-aligned 07-api so scaffolds match accepted contracts |

### Continuity from Weeks 05–08

| Week | What we already have | How Week 09 uses it |
|------|----------------------|---------------------|
| 05 | MVP 1 (`opti-view`) | Baseline while evolutionary repos take first code |
| 06 | 19-repo layout + Compose / env planning | First real commits land in those repos |
| 07 | Contracts + collaborator access | Tracker fix + scaffolds consume those contracts |
| 08 | Agile/DevOps + Git Flow | Every scaffold used `feat/*` → PR → `develop` |

## 3. Blockers and risks

- Secret-store product for shared environments still **not chosen** (`opti-infra`). Local Compose + gitignored `.env` remains the safe path.
- Customers / products BCs (`opti-customers-*`, `opti-products-*`) are advancing on other teammates’ PRs — integration across BCs still thin.
- Progressive delivery beyond `develop` (canary on `qa`) not wired yet.
- Risk: scaffold drift vs OpenAPI — keep contracts (`opti-docs` `main`) as the SSOT before more REST surface grows.

## 4. Plan for next week

- Continue vertical slices on auth / sales (notifications, seller attribution, reports) already sketched after the scaffolds.
- Align gateway routes with new resources (`/lenses`, `/notifications`) as product APIs land.
- Keep `.env.example` (keys only) convention across `opti-*-api` / `opti-infra`.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [x] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Study notes + `opti-docs` PR #20 stay documentation. Evolutionary work used `feat/*` → PR → `develop` on each `opti-*` repo (course Git Flow; not `hu-xxx-dev` naming, but same per-environment promotion idea). Hexagonal layering and CI with tests landed on auth-api / sales-api / worker / workflow / gateway. Course-fork HU-status still commits on `main`.

## 6. Evidence links

**Course fork (Week 09 docs):**

- [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md)
- [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png)
- [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md)
- [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png)

**opti-docs:**

- PR #20 (merged): https://github.com/code-corhuila/opti-docs/pull/20
- Contracts commit: https://github.com/code-corhuila/opti-docs/commit/184f0e26e4876095a55cf1aa0d87e416e1320f13
- `main` tip including #20: https://github.com/code-corhuila/opti-docs/commit/ee66ffa

**code-corhuila scaffolds (my PRs → `develop`):**

- Auth: https://github.com/code-corhuila/opti-auth-db/pull/1 · https://github.com/code-corhuila/opti-auth-api/pull/1 · https://github.com/code-corhuila/opti-auth-portal/pull/1
- Sales: https://github.com/code-corhuila/opti-sales-db/pull/1 · https://github.com/code-corhuila/opti-sales-api/pull/1 · https://github.com/code-corhuila/opti-sales-portal/pull/1
- Platform: https://github.com/code-corhuila/opti-api-gateway/pull/1 · https://github.com/code-corhuila/opti-front/pull/1 · https://github.com/code-corhuila/opti-worker/pull/1 · https://github.com/code-corhuila/opti-workflow/pull/1

**Related prior work:**

- Week 08: [`08-week/hu-status/README.md`](../../08-week/hu-status/README.md)
- Week 07: [`07-week/hu-status/README.md`](../../07-week/hu-status/README.md)
- Week 06: [`06-week/hu-status/README.md`](../../06-week/hu-status/README.md)
- Org repos: https://github.com/orgs/code-corhuila/repositories?q=opti
- MVP baseline: https://github.com/code-corhuila/opti-view
