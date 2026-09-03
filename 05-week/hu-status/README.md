<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       05-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 05

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Deliver and present OptiView Platform MVP 1 (Corte 1) this week — complete React SPA from the Week-04 Figma guide (HU-01, HU-05, HU-08), Git Flow release on optiview-platform, and classroom expo with live demo.
<!-- CONFIG-END -->

> **Week 05 deliverable — MVP 1 presentation.** Everything in this folder supports the **MVP expo this week**: the React frontend I built, the release tag `v1.0.0`, the Figma→screen mapping, and the deck [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx). The live demo runs with `docker compose up --build` → http://localhost:8080.

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-048 | Build the full React SPA from the Week-04 Figma UI guide | done | https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3 |
| HU-OPT-049 | Implement Patients module screens — list, register, detail (Figma 08–10, HU-01) | done | https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3 |
| HU-OPT-050 | Implement Inventory screens — frame list and register (Figma 03, 21, HU-05) | done | https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3 |
| HU-OPT-051 | Implement Work Orders screens — list, create, detail (Figma 12, 13–14, 05, HU-08) | done | https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3 |
| HU-OPT-052 | Release MVP 1 frontend through Git Flow (feature → develop → qa → main) | done | https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15 |
| HU-OPT-053 | Update canonical domain map in `opti-docs` — 4-microservice model aligned with MVP architecture | done | https://github.com/jdtovar07/opti-docs/commit/808a9b6e0c870556c41f98d443c1f1b05f97c3b3 |
| HU-OPT-054 | Prepare and present MVP 1 expo deck (Figma, HUs, live demo, monolith context) | done | [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) |

## 2. My individual contribution

> **Scope clarification:** my work this week was **frontend + documentation** — React SPA, Figma-to-screen implementation, Git Flow release, **domain map in opti-docs**, MVP docs in the course fork, and classroom presentation. I did **not** implement backend code or Go microservices this week. The Java monolith backend was built by a teammate; my frontend consumes its REST API for the live demo.

### My commits this week (`jdtovar07`) — frontend only

| Commit | Message |
|--------|---------|
| [`170aefe`](https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3) | `feat(frontend): add OptiView SPA and its documentation to the monorepo` — **39 files, all under `frontend/`** (10 screens, Layout, auth, API client, Docker/Nginx) |
| [`ac4f682`](https://github.com/jdtovar07/optiview-platform/commit/ac4f6825faa608881256eab21d0ced267a888e6d) | Merge `feature/frontend-spa` → `develop` |
| [`d85b2e4`](https://github.com/jdtovar07/optiview-platform/commit/d85b2e46295bdffdae9df360aa2af312cfa5a1d9) | Promote `develop` → `qa` |
| [`185c06b`](https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15) | Promote `qa` → `main` — **Release MVP 1 (Corte 1)** + tag `v1.0.0` |

Commit `170aefe` file proof — zero `backend/` paths:

```
frontend/src/screens/  → Login, Dashboard, Patients, PatientNew, PatientDetail,
                         Inventory, FrameNew, WorkOrders, WorkOrderNew, WorkOrderDetail
frontend/src/          → App.tsx, api.ts, auth.tsx, useApi.ts, Layout.tsx, theme.tsx
docs/adr/0003-         → ADR separated React SPA
```

### What I built (frontend)

**Stack:** React 18 · Vite · TypeScript · Nginx proxy (`/api` → backend) · served via `docker compose`.

| Figma frame | React screen (`frontend/src/screens/`) | HU | What the UI does |
|-------------|----------------------------------------|-----|------------------|
| 07 Login | `Login.tsx` | — | Auth form, JWT session |
| 01 Dashboard | `Dashboard.tsx` | — | Summary KPIs via `GET /api/summary` |
| 08 Pacientes | `Patients.tsx` | HU-01 | Searchable patient list |
| 09 Nuevo paciente | `PatientNew.tsx` | HU-01 | Registration form (document, names, phone, EPS) |
| 10 Detalle paciente | `PatientDetail.tsx` | HU-01 | Patient profile view |
| 03 Inventario | `Inventory.tsx` | HU-05 | Frame stock table |
| 21 Registrar montura | `FrameNew.tsx` | HU-05 | Frame registration form (SKU, prices, stock) |
| 12 Órdenes de trabajo | `WorkOrders.tsx` | HU-08 | Work order list with status |
| 13–14 Wizard (simplified) | `WorkOrderNew.tsx` | HU-08 | Create order — patient + frame selection |
| 05 Detalle de Orden | `WorkOrderDetail.tsx` | HU-08 | Order detail view |

**Shared frontend infrastructure I implemented:**
- `Layout.tsx` — sidebar + top bar matching Figma admin layout
- `auth.tsx` / `api.ts` / `useApi.ts` — JWT auth and REST client to the monolith backend
- `Field.tsx` / `toast.tsx` / `theme.tsx` — reusable form components and UI feedback
- `App.tsx` — React Router route tree wiring all screens

### MVP 1 expo — what I present this week

| Step | What | Evidence |
|------|------|----------|
| 1 | Context — OptiView, team, Corte 1 scope | [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) slides 1–3 |
| 2 | Figma guide (Week 04) → implemented screens | [`figma-ui-flow.md`](../../04-week/hu-status/figma-ui-flow.md) + table above |
| 3 | **Live demo** — login → dashboard → patients → inventory → work orders | `docker compose up --build` on [`optiview-platform`](https://github.com/jdtovar07/optiview-platform) tag `v1.0.0` |
| 4 | My contribution — frontend SPA + Git Flow release | commit [`170aefe`](https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3) → [`185c06b`](https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15) |
| 5 | Team architecture — monolith today, microservices later | deck + [`optiview-platform-mvp.md`](./optiview-platform-mvp.md) |

### Documentation I created or updated this week

| Where | What | Purpose |
|-------|------|---------|
| **optiview-platform** (`170aefe`) | `frontend/README.md` — how to run/build the SPA | Dev guide inside the monorepo |
| **optiview-platform** (`170aefe`) | `docs/adr/0003-frontend-separado.md` — ADR for separated React SPA | Architecture decision for the frontend |
| **optiview-platform** (`170aefe`) | `docs/README.md`, root `README.md` | Monorepo docs updated for frontend delivery |
| **opti-docs** ([`808a9b6`](https://github.com/jdtovar07/opti-docs/commit/808a9b6e0c870556c41f98d443c1f1b05f97c3b3)) | [`02-domain/domain-map.md`](https://github.com/jdtovar07/opti-docs/blob/main/02-domain/domain-map.md) — canonical bounded contexts (`ms-pacientes`, `ms-inventario`, `ms-ordenes`, `ms-facturacion`) | Domain architecture doc for MVP expo context |
| **Course fork** (`05-week/hu-status/`) | [`README.md`](./README.md) + [`README.es.md`](./README.es.md) | Weekly status (graded) — HUs, commits, expo plan |
| **Course fork** (`05-week/hu-status/`) | [`optiview-platform-mvp.md`](./optiview-platform-mvp.md) | MVP 1 reference — Figma→screen map, demo script, release commits |
| **Course fork** (`05-week/hu-status/`) | [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) | Classroom presentation deck |

### Documentation and presentation

- [`optiview-platform-mvp.md`](./optiview-platform-mvp.md) — MVP 1 reference doc for this week's expo: Figma→screen mapping, frontend scope, demo URL, release commits.
- [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) — **MVP 1 classroom deck** — Figma guide, implemented HUs, live demo script, monolith-first strategy.

### Team context (not my code this week)

- **Backend (Java Spring Boot monolith):** built by Bairon Suarez — REST API my frontend calls for the live demo.
- **opti-docs governance** (4 docs in `00-governance/`): adapted in **Week 03** — commit [`3834691`](https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded), not Week 05.

## 3. Blockers and risks

- MVP 1 order wizard simplifies Figma steps 13→20 (single create screen, no lenses/treatments step yet).
- Frontend has no automated UI tests yet — manual verification against Figma and HU acceptance criteria.
- Backend and frontend are coupled through REST; when the team splits to microservices, the frontend API client will need to point to the gateway instead of the monolith.

## 4. Plan for next week

- Complete the 4-step order wizard in the frontend (Figma frames 19–20 — lenses + summary).
- Add remaining Figma screens not yet implemented (billing, reports, patient portal).
- Start consuming APIs through a future `api-gateway` when microservices are extracted from the monolith.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [ ] Tests added/updated (unit / integration)
- [ ] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Git Flow on `optiview-platform` for the frontend feature (`feature/frontend-spa` → `develop` → `qa` → `main`). HU-01/05/08 UI acceptance criteria verifiable by walking each Figma-mapped screen. No backend/domain code written by me this week — unchecked DDD/tests apply to backend (teammate).

## 6. Evidence links — my commits (`jdtovar07`)

**optiview-platform (frontend):**

- **Full React SPA (Figma → screens):** https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3
- Merge feature → develop: https://github.com/jdtovar07/optiview-platform/commit/ac4f6825faa608881256eab21d0ced267a888e6d
- Promote develop → qa: https://github.com/jdtovar07/optiview-platform/commit/d85b2e46295bdffdae9df360aa2af312cfa5a1d9
- **Release MVP 1 (v1.0.0):** https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15

**opti-docs (domain documentation):**

- **Domain map rewrite (Week 05):** https://github.com/jdtovar07/opti-docs/commit/808a9b6e0c870556c41f98d443c1f1b05f97c3b3
- Canonical file: [`02-domain/domain-map.md`](https://github.com/jdtovar07/opti-docs/blob/main/02-domain/domain-map.md)

**Course fork (Week 05 docs):**

- Frontend MVP documentation: [`optiview-platform-mvp.md`](./optiview-platform-mvp.md)
- MVP 1 expo presentation: [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx)
- Week-04 Figma UI guide: [`04-week/hu-status/figma-ui-flow.md`](../../04-week/hu-status/figma-ui-flow.md)
