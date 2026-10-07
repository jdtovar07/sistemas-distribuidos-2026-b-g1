<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       10-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 10

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document persistence patterns (saga, outbox, CQRS) and MVP 2 release practices; land this week's vertical slices on the Week 09 scaffolds (auth notifications/goals, seller attribution, reports, gateway routes, front shell, worker alerts, saga identity); and late-report the Sunday 4 Oct hardening fixes that did not make the Week 09 HU-status.
<!-- CONFIG-END -->

> **Week window:** Monday **2026-10-05** → Sunday **2026-10-11** (each course week is Mon–Sun).  
> **Week 10 deliverable:** (1) study notes on **persistence** and **MVP 2 release**, (2) **this week's** vertical slices on the Week 09 scaffolds, and (3) a short **late-report** block for work finished on **Sunday 2026-10-04** (Week 09) that did not fit into the Week 09 HU-status in time.

## 1. User stories worked this week

### A. This week (Mon 2026-10-05 → Sun 2026-10-11)

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-090 | Document persistence in distributed systems (saga, outbox, CQRS) | done | [`persistence-saga-outbox-cqrs.md`](./persistence-saga-outbox-cqrs.md) |
| HU-OPT-091 | Produce visual summary of saga / outbox / CQRS | done | [`persistence-saga-outbox-cqrs.png`](./persistence-saga-outbox-cqrs.png) |
| HU-OPT-092 | Document release practices for shipping MVP 2 | done | [`release-shipping-mvp-2.md`](./release-shipping-mvp-2.md) |
| HU-OPT-093 | Produce visual summary of MVP 2 release | done | [`release-shipping-mvp-2.png`](./release-shipping-mvp-2.png) |
| HU-OPT-094 | Optional user email (auth-db + auth-api) | done | https://github.com/code-corhuila/opti-auth-db/pull/6 · https://github.com/code-corhuila/opti-auth-api/pull/4 |
| HU-OPT-095 | Letters-only full name validation in `opti-auth-api` | done | https://github.com/code-corhuila/opti-auth-api/pull/3 |
| HU-OPT-096 | Route Nequi payments through Wompi in `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/5 |
| HU-OPT-097 | Rework `opti-front` shell into sidebar + topbar layout | done | https://github.com/code-corhuila/opti-front/pull/3 |
| HU-OPT-098 | Front shell polish (FormData upload, avatar/tabs CSS, sidebar icons) | done | https://github.com/code-corhuila/opti-front/pull/10 · [#8](https://github.com/code-corhuila/opti-front/pull/8) |
| HU-OPT-099 | Add split-screen login matching mockup in `opti-front` | done | https://github.com/code-corhuila/opti-front/pull/4 |
| HU-OPT-100 | Route `/api/v1/lenses` to products-api in `opti-api-gateway` | done | https://github.com/code-corhuila/opti-api-gateway/pull/3 |
| HU-OPT-101 | Add `seller_id` to work orders in `opti-sales-db` | done | https://github.com/code-corhuila/opti-sales-db/pull/4 |
| HU-OPT-102 | Add `gateway_transaction_id` to payments in `opti-sales-db` | done | https://github.com/code-corhuila/opti-sales-db/pull/5 |
| HU-OPT-103 | Attribute work orders to seller + sales revenue reports in `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/2 |
| HU-OPT-104 | Carry caller identity through place-order saga in `opti-workflow` | done | https://github.com/code-corhuila/opti-workflow/pull/2 |
| HU-OPT-105 | Add sales-goal + notification schema in `opti-auth-db` | done | https://github.com/code-corhuila/opti-auth-db/pull/4 |
| HU-OPT-106 | Add notifications + seller sales goals in `opti-auth-api` | done | https://github.com/code-corhuila/opti-auth-api/pull/2 |
| HU-OPT-107 | Add SERVICE-only seller-sales report in `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/4 |
| HU-OPT-108 | Route `/api/v1/notifications` to auth-api in `opti-api-gateway` | done | https://github.com/code-corhuila/opti-api-gateway/pull/5 |
| HU-OPT-109 | Notify seller on sales-goal reach in `opti-worker` | done | https://github.com/code-corhuila/opti-worker/pull/2 |
| HU-OPT-116 | Optional email field in `opti-auth-portal` | done | https://github.com/code-corhuila/opti-auth-portal/pull/3 |
| HU-OPT-117 | Letters-only full name in `opti-auth-portal` | done | https://github.com/code-corhuila/opti-auth-portal/pull/2 |
| HU-OPT-118 | Split "Mi cuenta" into Perfil / Seguridad / Preferencias tabs | done | https://github.com/code-corhuila/opti-auth-portal/pull/4 |
| HU-OPT-119 | Wire shared Avatar component in `opti-auth-portal` | done | https://github.com/code-corhuila/opti-auth-portal/pull/5 |
| HU-OPT-120 | Ask for Nequi phone number on payment in `opti-sales-portal` | done | https://github.com/code-corhuila/opti-sales-portal/pull/3 |
| HU-OPT-121 | Polymorphic work-order item (`product_type` / `product_id`) in `opti-sales-db` (HU-25) | done | https://github.com/code-corhuila/opti-sales-db/pull/6 |
| HU-OPT-122 | Generalize work-order items to any product type in `opti-sales-api` (HU-25) | done | https://github.com/code-corhuila/opti-sales-api/pull/6 |
| HU-OPT-123 | Sell lenses, accessories and liquids in `opti-sales-portal` (HU-25) | done | https://github.com/code-corhuila/opti-sales-portal/pull/4 |
| HU-OPT-124 | Update new-sale subtitle for HU-25 / HU-22 in `opti-sales-portal` | done | https://github.com/code-corhuila/opti-sales-portal/pull/7 |
| HU-OPT-125 | Generalize place-order saga to any product type in `opti-workflow` (HU-25) | done | https://github.com/code-corhuila/opti-workflow/pull/3 |
| HU-OPT-126 | New-sale registration screen in `opti-sales-portal` | done | https://github.com/code-corhuila/opti-sales-portal/pull/2 |
| HU-OPT-127 | Document demo user passwords in `opti-auth-db` | done | https://github.com/code-corhuila/opti-auth-db/pull/5 |
| HU-OPT-128 | Align auth-portal profile sections with shared redesign | done | https://github.com/code-corhuila/opti-auth-portal/pull/7 |
| HU-OPT-129 | Complete front redesign, Spanish errors and media routing | done | https://github.com/code-corhuila/opti-front/pull/21 |
| HU-OPT-130 | Track one sale operation and complete billing workflow in `opti-sales-portal` | done | https://github.com/code-corhuila/opti-sales-portal/pull/11 |
| HU-OPT-131 | Require settled invoice before delivery in `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/10 |
| HU-OPT-132 | CI: publish Docker images to GHCR on push to develop (portals / front / workflow) | done | https://github.com/code-corhuila/opti-auth-portal/pull/6 · [customers-portal#9](https://github.com/code-corhuila/opti-customers-portal/pull/9) · [front#18](https://github.com/code-corhuila/opti-front/pull/18) · [products-portal#8](https://github.com/code-corhuila/opti-products-portal/pull/8) · [sales-portal#10](https://github.com/code-corhuila/opti-sales-portal/pull/10) · [workflow#4](https://github.com/code-corhuila/opti-workflow/pull/4) |
| HU-OPT-133 | CI: package Flyway migrations as GHCR images (`customers-db`, `sales-db`) | done | https://github.com/code-corhuila/opti-customers-db/pull/4 · https://github.com/code-corhuila/opti-sales-db/pull/7 |

### B. Late-reported from Week 09 (done Sunday 2026-10-04 — not in the Week 09 HU-status)

> **Note:** The following work was completed on **Sunday 2026-10-04** (last day of Week 09) but **did not make it into** [`09-week/hu-status/README.md`](../../09-week/hu-status/README.md) in time. It is **not** new Week 10 work; it is reported here only so the evidence is not lost.

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-110 | Fix Flyway `[environments.default]` schemas in `opti-auth-db` | done | https://github.com/code-corhuila/opti-auth-db/pull/3 |
| HU-OPT-111 | Mark `verify-rebuild.sh` executable in `opti-auth-db` | done | https://github.com/code-corhuila/opti-auth-db/pull/2 |
| HU-OPT-112 | Fix Flyway `[environments.default]` schemas in `opti-sales-db` | done | https://github.com/code-corhuila/opti-sales-db/pull/3 |
| HU-OPT-113 | Mark `verify-rebuild.sh` executable in `opti-sales-db` | done | https://github.com/code-corhuila/opti-sales-db/pull/2 |
| HU-OPT-114 | Mark `smoke.sh` executable in `opti-api-gateway` | done | https://github.com/code-corhuila/opti-api-gateway/pull/2 |
| HU-OPT-115 | Allow Vitest to pass with no unit tests yet in `opti-front` | done | https://github.com/code-corhuila/opti-front/pull/2 |

## 2. My individual contribution

> **Author:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Week 10 scope (Mon–Sun):** study notes + slices dated **2026-10-05 … 2026-10-11**.  
> **Late-report:** hardening fixes dated **2026-10-04** (Week 09) missing from last week's file.

### Study notes and visuals (this week)

| Artifact | What it covers |
|----------|----------------|
| [`persistence-saga-outbox-cqrs.md`](./persistence-saga-outbox-cqrs.md) | Database-per-service, saga, outbox, CQRS, eventual consistency |
| [`persistence-saga-outbox-cqrs.png`](./persistence-saga-outbox-cqrs.png) | Visual summary of those five concepts |
| [`release-shipping-mvp-2.md`](./release-shipping-mvp-2.md) | Release, MVP, integrated system, release steps and good practices |
| [`release-shipping-mvp-2.png`](./release-shipping-mvp-2.png) | Visual summary of shipping MVP 2 |

### This week's vertical slices (on Week 09 scaffolds)

| Pattern | How I applied it this week |
|---------|----------------------------|
| Database-per-service | Auth goals/notifications schema; sales `seller_id` / payment gateway id / polymorphic `product_type`+`product_id` |
| Saga | `opti-workflow` carries caller identity and reserves any product type (HU-25) through place-order |
| Outbox / async | `opti-worker` notifies when a seller hits their sales goal |
| CQRS-style reads | Sales revenue + seller-sales reports; gateway `/lenses` + `/notifications` |
| Integrated release | Front shell/login + redesign, auth-portal tabs, Nequi phone, sell any product type, Wompi, GHCR publish for apps/migrations |

### Representative commits this week (author dates in the Mon–Sun window)

- **Mon 5 Oct:** [`ec92f2a`](https://github.com/code-corhuila/opti-auth-db/commit/ec92f2a) email schema · [`669b820`](https://github.com/code-corhuila/opti-auth-api/commit/669b820) / [`f80fa74`](https://github.com/code-corhuila/opti-auth-api/commit/f80fa74) auth · [`eac2745`](https://github.com/code-corhuila/opti-auth-portal/commit/eac2745) / [`014c8a9`](https://github.com/code-corhuila/opti-auth-portal/commit/014c8a9) / [`0d7aea2`](https://github.com/code-corhuila/opti-auth-portal/commit/0d7aea2) auth-portal · [`8c7708d`](https://github.com/code-corhuila/opti-sales-api/commit/8c7708d) Wompi · [`a8916e2`](https://github.com/code-corhuila/opti-sales-portal/commit/a8916e2) Nequi phone · [`a92f443`](https://github.com/code-corhuila/opti-sales-db/commit/a92f443) polymorphic item · [`7e2fecc`](https://github.com/code-corhuila/opti-front/commit/7e2fecc) shell · [`51a55fe`](https://github.com/code-corhuila/opti-front/commit/51a55fe) FormData  
- **Tue 6 Oct+ (same week):** [`3df81a4`](https://github.com/code-corhuila/opti-front/commit/3df81a4) login · [`03ef5e0`](https://github.com/code-corhuila/opti-front/commit/03ef5e0) redesign · [`191db60`](https://github.com/code-corhuila/opti-auth-portal/commit/191db60) profile redesign · [`54a58a1`](https://github.com/code-corhuila/opti-sales-portal/commit/54a58a1) billing workflow · [`5f80d80`](https://github.com/code-corhuila/opti-sales-api/commit/5f80d80) payment-before-delivery · [`4b36f57`](https://github.com/code-corhuila/opti-api-gateway/commit/4b36f57) lenses · [`6002dab`](https://github.com/code-corhuila/opti-sales-api/commit/6002dab) / [`1c204f4`](https://github.com/code-corhuila/opti-sales-portal/commit/1c204f4) / [`910cac3`](https://github.com/code-corhuila/opti-workflow/commit/910cac3) HU-25 · GHCR publish ([`b77f610`](https://github.com/code-corhuila/opti-front/commit/b77f610) + portals/workflow) · Flyway GHCR ([`9258f84`](https://github.com/code-corhuila/opti-customers-db/commit/9258f84) / [`e2550a7`](https://github.com/code-corhuila/opti-sales-db/commit/e2550a7)) · [`ea76900`](https://github.com/code-corhuila/opti-auth-db/commit/ea76900) demo passwords · notifications / seller reports / worker goal alert  


### Late-reported Week 09 commits (Sunday 4 Oct only)

- [`30f0c40`](https://github.com/code-corhuila/opti-auth-db/commit/30f0c40) / [`2a9c46f`](https://github.com/code-corhuila/opti-auth-db/commit/2a9c46f) auth-db  
- [`b4f7ccc`](https://github.com/code-corhuila/opti-sales-db/commit/b4f7ccc) / [`0b6be0f`](https://github.com/code-corhuila/opti-sales-db/commit/0b6be0f) sales-db  
- [`68202ed`](https://github.com/code-corhuila/opti-api-gateway/commit/68202ed) gateway  
- [`74faf25`](https://github.com/code-corhuila/opti-front/commit/74faf25) front Vitest  

### Continuity

| Week | What we already have | How Week 10 uses it |
|------|----------------------|---------------------|
| 09 | First scaffolds on auth/sales/gateway/front/worker/workflow | This week fills those skeletons with real BC features (Mon–Sun) |
| 05–08 | MVP 1, 19 repos, contracts, Git Flow | Same `feat/*` → `develop` path |

## 3. Blockers and risks

- End-to-end tagged MVP 2 across all 19 repos is **not cut yet** — slices land on `develop`.
- Lenses route depends on products-api readiness (other teammates).
- Secret store for shared environments still undecided (`opti-infra`).
- Risk: report/notification contracts drifting from `opti-docs`.

## 4. Plan for next week

- Promote integrated slices toward a tagged MVP 2 candidate (`develop` → `qa` smoke).
- Wire portal UX for notifications and seller reports end to end.
- Keep saga / outbox coverage growing.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [x] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week window is Mon–Sun. Section B is late-reporting of Sunday 4 Oct Week 09 work only. Evolutionary work used `feat/*` → PR → `develop`. Course-fork HU-status commits on `main`.

## 6. Evidence links

**Course fork (Week 10 docs):**

- [`persistence-saga-outbox-cqrs.md`](./persistence-saga-outbox-cqrs.md)
- [`persistence-saga-outbox-cqrs.png`](./persistence-saga-outbox-cqrs.png)
- [`release-shipping-mvp-2.md`](./release-shipping-mvp-2.md)
- [`release-shipping-mvp-2.png`](./release-shipping-mvp-2.png)

**This week (Mon–Sun) — auth / sales / platform:**

- https://github.com/code-corhuila/opti-auth-db/pull/4 · https://github.com/code-corhuila/opti-auth-db/pull/5 · https://github.com/code-corhuila/opti-auth-db/pull/6
- https://github.com/code-corhuila/opti-auth-api/pull/2 · https://github.com/code-corhuila/opti-auth-api/pull/3 · https://github.com/code-corhuila/opti-auth-api/pull/4
- https://github.com/code-corhuila/opti-auth-portal/pull/2 · https://github.com/code-corhuila/opti-auth-portal/pull/3 · https://github.com/code-corhuila/opti-auth-portal/pull/4 · https://github.com/code-corhuila/opti-auth-portal/pull/5 · https://github.com/code-corhuila/opti-auth-portal/pull/6 · https://github.com/code-corhuila/opti-auth-portal/pull/7
- https://github.com/code-corhuila/opti-sales-db/pull/4 · https://github.com/code-corhuila/opti-sales-db/pull/5 · https://github.com/code-corhuila/opti-sales-db/pull/6 · https://github.com/code-corhuila/opti-sales-db/pull/7
- https://github.com/code-corhuila/opti-sales-api/pull/2 · https://github.com/code-corhuila/opti-sales-api/pull/4 · https://github.com/code-corhuila/opti-sales-api/pull/5 · https://github.com/code-corhuila/opti-sales-api/pull/6 · https://github.com/code-corhuila/opti-sales-api/pull/10
- https://github.com/code-corhuila/opti-sales-portal/pull/2 · https://github.com/code-corhuila/opti-sales-portal/pull/3 · https://github.com/code-corhuila/opti-sales-portal/pull/4 · https://github.com/code-corhuila/opti-sales-portal/pull/7 · https://github.com/code-corhuila/opti-sales-portal/pull/10 · https://github.com/code-corhuila/opti-sales-portal/pull/11
- https://github.com/code-corhuila/opti-customers-db/pull/4 · https://github.com/code-corhuila/opti-customers-portal/pull/9 · https://github.com/code-corhuila/opti-products-portal/pull/8
- https://github.com/code-corhuila/opti-api-gateway/pull/3 · https://github.com/code-corhuila/opti-api-gateway/pull/5
- https://github.com/code-corhuila/opti-front/pull/3 · https://github.com/code-corhuila/opti-front/pull/4 · https://github.com/code-corhuila/opti-front/pull/8 · https://github.com/code-corhuila/opti-front/pull/10 · https://github.com/code-corhuila/opti-front/pull/18 · https://github.com/code-corhuila/opti-front/pull/21
- https://github.com/code-corhuila/opti-worker/pull/2 · https://github.com/code-corhuila/opti-workflow/pull/2 · https://github.com/code-corhuila/opti-workflow/pull/3 · https://github.com/code-corhuila/opti-workflow/pull/4

**Late-reported Week 09 (Sunday 4 Oct):**

- https://github.com/code-corhuila/opti-auth-db/pull/2 · https://github.com/code-corhuila/opti-auth-db/pull/3
- https://github.com/code-corhuila/opti-sales-db/pull/2 · https://github.com/code-corhuila/opti-sales-db/pull/3
- https://github.com/code-corhuila/opti-api-gateway/pull/2
- https://github.com/code-corhuila/opti-front/pull/2

**Related prior work:**

- Week 09: [`09-week/hu-status/README.md`](../../09-week/hu-status/README.md)
- Org repos: https://github.com/orgs/code-corhuila/repositories?q=opti
