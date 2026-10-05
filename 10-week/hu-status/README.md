<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       10-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 10

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document persistence patterns (saga, outbox, CQRS) and MVP 2 release practices; then land vertical slices on the Week 09 scaffolds — notifications, seller attribution, sales reports, gateway routes, front shell polish, worker goal alerts and saga identity — toward an integrated OptiView release.
<!-- CONFIG-END -->

> **Week 10 deliverable — persistence patterns + integrated vertical slices toward MVP 2.** After the Week 09 scaffolds (auth / sales / gateway / front / worker / workflow), this week: (1) documents **database-per-service, saga, outbox, CQRS and eventual consistency**, (2) documents **shipping MVP 2 as an integrated system**, and (3) implements the first **cross-service slices** on `develop` that exercise those patterns (notifications + goals, seller attribution, reports, gateway routes, shell UX, worker alerts, saga caller identity).

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-090 | Document persistence in distributed systems (saga, outbox, CQRS) | done | [`persistence-saga-outbox-cqrs.md`](./persistence-saga-outbox-cqrs.md) |
| HU-OPT-091 | Produce visual summary of saga / outbox / CQRS | done | [`persistence-saga-outbox-cqrs.png`](./persistence-saga-outbox-cqrs.png) |
| HU-OPT-092 | Document release practices for shipping MVP 2 | done | [`release-shipping-mvp-2.md`](./release-shipping-mvp-2.md) |
| HU-OPT-093 | Produce visual summary of MVP 2 release | done | [`release-shipping-mvp-2.png`](./release-shipping-mvp-2.png) |
| HU-OPT-094 | Add sales-goal + notification schema in `opti-auth-db` | done | https://github.com/code-corhuila/opti-auth-db/pull/4 |
| HU-OPT-095 | Add notifications + seller sales goals in `opti-auth-api` | done | https://github.com/code-corhuila/opti-auth-api/pull/2 |
| HU-OPT-096 | Add `seller_id` to work orders in `opti-sales-db` | done | https://github.com/code-corhuila/opti-sales-db/pull/4 |
| HU-OPT-097 | Add `gateway_transaction_id` to payments in `opti-sales-db` | done | https://github.com/code-corhuila/opti-sales-db/pull/5 |
| HU-OPT-098 | Attribute work orders to seller + sales revenue reports in `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/2 |
| HU-OPT-099 | Add SERVICE-only seller-sales report in `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/4 |
| HU-OPT-100 | Route `/api/v1/lenses` to products-api in `opti-api-gateway` | done | https://github.com/code-corhuila/opti-api-gateway/pull/3 |
| HU-OPT-101 | Route `/api/v1/notifications` to auth-api in `opti-api-gateway` | done | https://github.com/code-corhuila/opti-api-gateway/pull/5 |
| HU-OPT-102 | Rework `opti-front` shell into sidebar + topbar layout | done | https://github.com/code-corhuila/opti-front/pull/3 |
| HU-OPT-103 | Add split-screen login matching mockup in `opti-front` | done | https://github.com/code-corhuila/opti-front/pull/4 |
| HU-OPT-104 | Notify seller on sales-goal reach in `opti-worker` | done | https://github.com/code-corhuila/opti-worker/pull/2 |
| HU-OPT-105 | Carry caller identity through place-order saga in `opti-workflow` | done | https://github.com/code-corhuila/opti-workflow/pull/2 |
| HU-OPT-106 | Optional user email (auth-db + auth-api) | done | https://github.com/code-corhuila/opti-auth-db/pull/6 · https://github.com/code-corhuila/opti-auth-api/pull/4 |
| HU-OPT-107 | Letters-only full name validation in `opti-auth-api` | done | https://github.com/code-corhuila/opti-auth-api/pull/3 |
| HU-OPT-108 | Route Nequi payments through Wompi in `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/5 |
| HU-OPT-109 | Front shell polish (FormData upload, avatar/tabs CSS, sidebar icons) | done | https://github.com/code-corhuila/opti-front/pull/10 · [#8](https://github.com/code-corhuila/opti-front/pull/8) |

## 2. My individual contribution

> **Scope this week:** study notes on persistence + release, **and** the first vertical slices on top of the Week 09 scaffolds (Git Flow: `feat/*` → `develop`). Author: Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).

### Study notes and visuals

| Artifact | What it covers |
|----------|----------------|
| [`persistence-saga-outbox-cqrs.md`](./persistence-saga-outbox-cqrs.md) | Database-per-service, saga, outbox, CQRS, eventual consistency |
| [`persistence-saga-outbox-cqrs.png`](./persistence-saga-outbox-cqrs.png) | Visual summary of those five concepts |
| [`release-shipping-mvp-2.md`](./release-shipping-mvp-2.md) | Release, MVP, integrated system, release steps and good practices |
| [`release-shipping-mvp-2.png`](./release-shipping-mvp-2.png) | Visual summary of shipping MVP 2 |

### Vertical slices that exercise the patterns

| Pattern (Session 1) | How I applied it in OptiView |
|---------------------|------------------------------|
| Database-per-service | Auth schema for goals/notifications (`opti-auth-db` #4); sales schema for `seller_id` / payment gateway id (`opti-sales-db` #4/#5) — each BC owns its tables |
| Saga | `opti-workflow` #2 carries the caller's identity through place-order so seller attribution survives the multi-step flow |
| Outbox / async | `opti-worker` #2 reacts when a seller reaches their sales goal and creates a notification |
| CQRS-style reads | `opti-sales-api` #2/#4 revenue + seller-sales reports as dedicated read paths; gateway exposes `/notifications` and `/lenses` (#5/#3) |
| Integrated release (Session 2) | Front shell + login mockup (#3/#4) plus auth email/fullname polish and Wompi Nequi payments so the system feels closer to a shippable MVP 2 |

### Representative commits (authored by me)

- Auth: [`e0883ff`](https://github.com/code-corhuila/opti-auth-db/commit/e0883ff) schema · [`789b64c`](https://github.com/code-corhuila/opti-auth-api/commit/789b64c) notifications · [`362dce4`](https://github.com/code-corhuila/opti-auth-api/commit/362dce4) sales goals  
- Sales: [`ac8ce44`](https://github.com/code-corhuila/opti-sales-db/commit/ac8ce44) seller_id · [`7c7481a`](https://github.com/code-corhuila/opti-sales-db/commit/7c7481a) gateway tx · [`be311b9`](https://github.com/code-corhuila/opti-sales-api/commit/be311b9) attribution · [`ee08573`](https://github.com/code-corhuila/opti-sales-api/commit/ee08573) / [`93c2776`](https://github.com/code-corhuila/opti-sales-api/commit/93c2776) reports · [`8c7708d`](https://github.com/code-corhuila/opti-sales-api/commit/8c7708d) Wompi Nequi  
- Platform: [`4b36f57`](https://github.com/code-corhuila/opti-api-gateway/commit/4b36f57) lenses · [`7bb20c8`](https://github.com/code-corhuila/opti-api-gateway/commit/7bb20c8) notifications · [`7e2fecc`](https://github.com/code-corhuila/opti-front/commit/7e2fecc) shell · [`3df81a4`](https://github.com/code-corhuila/opti-front/commit/3df81a4) login · [`6db0832`](https://github.com/code-corhuila/opti-worker/commit/6db0832) goal alert · [`031209a`](https://github.com/code-corhuila/opti-workflow/commit/031209a) saga identity  

### Continuity from Weeks 05–09

| Week | What we already have | How Week 10 uses it |
|------|----------------------|---------------------|
| 05 | MVP 1 (`opti-view`) | Baseline UX while evolutionary front/portals catch up |
| 06–07 | 19-repo layout + contracts | New routes and resources stay behind gateway + OpenAPI |
| 08 | Agile/DevOps + Git Flow | Every slice used `feat/*` → PR → `develop` |
| 09 | First scaffolds on auth/sales/gateway/front/worker/workflow | This week fills those skeletons with real BC features |

## 3. Blockers and risks

- End-to-end “one-click” MVP 2 release across all 19 repos is **not tagged yet** — slices land on `develop`, but a coordinated `qa`/`main` cut is still open.
- Customers / products BCs still move mostly on other teammates’ PRs; lenses route depends on products-api readiness.
- Secret store for shared environments still undecided (`opti-infra`).
- Risk: report/notification contracts drifting from `opti-docs` — keep OpenAPI as SSOT when adding more read models.

## 4. Plan for next week

- Promote integrated slices toward a tagged MVP 2 candidate (`develop` → `qa` smoke).
- Wire portal UX for notifications and seller reports end to end.
- Keep saga / outbox coverage growing (more compensating steps, richer outbox consumers).

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [x] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Study notes are documentation. Evolutionary work used `feat/*` → PR → `develop`. Auth-api / sales-api / worker / workflow kept hexagonal boundaries; Flyway stays in `*-db`. Course-fork HU-status still commits on `main`.

## 6. Evidence links

**Course fork (Week 10 docs):**

- [`persistence-saga-outbox-cqrs.md`](./persistence-saga-outbox-cqrs.md)
- [`persistence-saga-outbox-cqrs.png`](./persistence-saga-outbox-cqrs.png)
- [`release-shipping-mvp-2.md`](./release-shipping-mvp-2.md)
- [`release-shipping-mvp-2.png`](./release-shipping-mvp-2.png)

**Auth / sales slices:**

- https://github.com/code-corhuila/opti-auth-db/pull/4 · https://github.com/code-corhuila/opti-auth-db/pull/6
- https://github.com/code-corhuila/opti-auth-api/pull/2 · https://github.com/code-corhuila/opti-auth-api/pull/3 · https://github.com/code-corhuila/opti-auth-api/pull/4
- https://github.com/code-corhuila/opti-sales-db/pull/4 · https://github.com/code-corhuila/opti-sales-db/pull/5
- https://github.com/code-corhuila/opti-sales-api/pull/2 · https://github.com/code-corhuila/opti-sales-api/pull/4 · https://github.com/code-corhuila/opti-sales-api/pull/5

**Platform slices:**

- https://github.com/code-corhuila/opti-api-gateway/pull/3 · https://github.com/code-corhuila/opti-api-gateway/pull/5
- https://github.com/code-corhuila/opti-front/pull/3 · https://github.com/code-corhuila/opti-front/pull/4 · https://github.com/code-corhuila/opti-front/pull/8 · https://github.com/code-corhuila/opti-front/pull/10
- https://github.com/code-corhuila/opti-worker/pull/2
- https://github.com/code-corhuila/opti-workflow/pull/2

**Related prior work:**

- Week 09: [`09-week/hu-status/README.md`](../../09-week/hu-status/README.md)
- Week 08: [`08-week/hu-status/README.md`](../../08-week/hu-status/README.md)
- Org repos: https://github.com/orgs/code-corhuila/repositories?q=opti
- MVP baseline: https://github.com/code-corhuila/opti-view
