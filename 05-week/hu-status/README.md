<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       05-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 05

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Bridge the Week-04 Figma UI to the domain layer, deliver and present OptiView Platform MVP 1 as a modular monolith (HU-01, HU-05, HU-08), and document the path from monolith to the four target microservices in opti-docs.
<!-- CONFIG-END -->

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-047 | Rewrite canonical domain map with confirmed 4-microservice model in opti-docs | done | https://github.com/jdtovar07/opti-docs/commit/808a9b6e0c870556c41f98d443c1f1b05f97c3b3 |
| HU-OPT-048 | Map Figma views to implemented React screens and routes (MVP 1 frontend) | done | https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3 |
| HU-OPT-049 | Model WorkOrder domain events and order-creation flow for ms-ordenes | done | [`ms-ordenes-domain.md`](./ms-ordenes-domain.md) |
| HU-OPT-050 | Model WorkOrder tactical DDD — aggregate, state machine, invariants | done | [`ms-ordenes-domain.md`](./ms-ordenes-domain.md) |
| HU-OPT-051 | Sketch hexagonal Go package structure and use cases for ms-ordenes | done | [`ms-ordenes-domain.md`](./ms-ordenes-domain.md) |
| HU-OPT-052 | Trace Figma order views to REST contract sketch and domain commands | done | [`ms-ordenes-domain.md`](./ms-ordenes-domain.md) |
| HU-OPT-053 | Deliver and present OptiView Platform MVP 1 — modular monolith (HU-01, HU-05, HU-08) | done | https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15 |
| HU-OPT-054 | Prepare and present MVP 1 expo deck (architecture, HUs, demo, monolith→microservices) | done | [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) |

## 2. My individual contribution

### My commits this week (`jdtovar07`)

**optiview-platform** — MVP 1 frontend + Git Flow release chain:

| Commit | Message |
|--------|---------|
| [`170aefe`](https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3) | `feat(frontend): add OptiView SPA and its documentation to the monorepo` |
| [`ac4f682`](https://github.com/jdtovar07/optiview-platform/commit/ac4f6825faa608881256eab21d0ced267a888e6d) | Merge `feature/frontend-spa` → `develop` |
| [`d85b2e4`](https://github.com/jdtovar07/optiview-platform/commit/d85b2e46295bdffdae9df360aa2af312cfa5a1d9) | Promote `develop` → `qa` |
| [`185c06b`](https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15) | Promote `qa` → `main` — **Release MVP 1 (Corte 1)** + tag `v1.0.0` |

**opti-docs** — canonical domain architecture:

| Commit | Message |
|--------|---------|
| [`808a9b6`](https://github.com/jdtovar07/opti-docs/commit/808a9b6e0c870556c41f98d443c1f1b05f97c3b3) | `docs(domain): rewrite domain map with confirmed 4-microservice model` |

**Course fork** — Week-05 documentation:

| Deliverable | Content |
|-------------|---------|
| [`ms-ordenes-domain.md`](./ms-ordenes-domain.md) | WorkOrder aggregate, state machine, hexagonal Go layout, Figma→API traceability |
| [`optiview-platform-mvp.md`](./optiview-platform-mvp.md) | MVP 1 monolith documentation, Figma→screen mapping, monolith→microservices path |
| [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) | MVP 1 presentation deck — expo to professor and classroom |

### What I did

- **Delivered and presented OptiView Platform MVP 1** ([`optiview-platform`](https://github.com/jdtovar07/optiview-platform)) following the Week-04 **Figma UI guide** and backlog **HUs** HU-01, HU-05, HU-08. I built the **React SPA frontend** (commit `170aefe`) mapping Figma frames to screens: Login (07), Dashboard (01), Patients/New/Detail (08–10), Inventory/FrameNew (03, 21), WorkOrders/New/Detail (12, 13–14, 05). Promoted the release through Git Flow to **`main`** + tag **`v1.0.0`** (commit `185c06b`).
- **Monolith-first, microservices-next:** MVP 1 is a **modular monolith** (Java Spring Boot + React + PostgreSQL, `docker compose up`) per ADR-0001 — domain packages (`model` / `usecase` / `infrastructure`) designed so patient, inventory and work-order modules extract later into `ms-pacientes`, `ms-inventario`, `ms-ordenes` without rewriting business rules.
- **Rewrote the canonical domain map** in `opti-docs` (commit `808a9b6`): confirmed **4 domain microservices** + `api-gateway`, bounded contexts, context relationships (U→D, ACL, OHS) and core/supporting/generic classification — supersedes the earlier 3-service draft.
- Wrote [`ms-ordenes-domain.md`](./ms-ordenes-domain.md): `WorkOrder` aggregate, 7-state machine mapped to Figma badges, invariants INV-ORD-001…005, domain events (`OrdenCreada`, `OrdenEstadoCambiado`, `OrdenEntregada`), hexagonal Go packages and `orders_schema` tables — blueprint for extracting the work-order module from the monolith.
- Wrote [`optiview-platform-mvp.md`](./optiview-platform-mvp.md) documenting MVP scope, Figma→screen table, API endpoints, Git Flow evidence and extraction path.
- Prepared and presented **[`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx)** — slide deck for the MVP 1 expo explaining OptiView Platform: product context, Figma-guided UI, implemented HUs (HU-01, HU-05, HU-08), modular monolith architecture (ADR-0001), live demo flow (`docker compose up`), and the planned path from monolith to four microservices.

> Team context (not my commits): Bairon Suarez contributed the backend MVP 1 core and `navigation-map.md` in opti-docs; Julian Vargas contributed `domain-events.md`. I aligned my `ms-ordenes-domain.md` with their catalogs but my graded evidence is the commits listed above.

## 3. Blockers and risks

- **OpenAPI contract for `ms-ordenes` not yet published** in `opti-docs/07-api/contracts/openapi/` — REST sketch exists in `ms-ordenes-domain.md` but no `ms-ordenes.yaml` yet.
- Stock-reservation timeout (HU-OPT-020) still undefined — `QUOTATION` compensation cannot be specified in acceptance criteria.
- MVP 1 wizard simplifies Figma steps 13→20 (no lenses/treatments step yet) — full 4-step wizard deferred to MVP 2 / microservices split.
- Go microservice `ms-ordenes` not started yet — tactical model in `ms-ordenes-domain.md` is the extraction blueprint.

## 4. Plan for next week

- Extract patient module from monolith → `ms-pacientes`; frame module → `ms-inventario`; work-order module → `ms-ordenes` (Go).
- Add lenses/treatments to order wizard (Figma frames 19–20).
- Publish `ms-ordenes.yaml` OpenAPI contract in opti-docs.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [x] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Git Flow on `optiview-platform` executed by me (`feature/frontend-spa` → `develop` → `qa` → `main`, commits `ac4f682`, `d85b2e4`, `185c06b`). HU-01/05/08 criteria enforced in monolith domain + integration tests.

## 6. Evidence links — my commits (`jdtovar07`)

**optiview-platform:**

- Frontend SPA (Figma → React): https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3
- Merge feature → develop: https://github.com/jdtovar07/optiview-platform/commit/ac4f6825faa608881256eab21d0ced267a888e6d
- Promote develop → qa: https://github.com/jdtovar07/optiview-platform/commit/d85b2e46295bdffdae9df360aa2af312cfa5a1d9
- **Release MVP 1 (v1.0.0):** https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15

**opti-docs:**

- Domain map rewrite: https://github.com/jdtovar07/opti-docs/commit/808a9b6e0c870556c41f98d443c1f1b05f97c3b3

**Course fork (Week 05 docs):**

- Tactical DDD model: [`ms-ordenes-domain.md`](./ms-ordenes-domain.md)
- MVP 1 documentation: [`optiview-platform-mvp.md`](./optiview-platform-mvp.md)
- MVP 1 expo presentation: [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx)
- Week-04 Figma UI flow: [`04-week/hu-status/figma-ui-flow.md`](../../04-week/hu-status/figma-ui-flow.md)
- Week-01 product brief: [`01-week/hu-status/prd.md`](../../01-week/hu-status/prd.md)
- ADR monolith → microservices: https://github.com/jdtovar07/optiview-platform/blob/main/docs/adr/0001-monolito-modular-hexagonal.md
