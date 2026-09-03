# OptiView Platform — MVP 1 (Corte 1) — Week 05 presentation

> **Purpose:** reference doc for the **MVP 1 classroom expo this week (Week 05)**.
> My delivery is the **React frontend** that powers the live demo; the team monolith backend runs alongside it in `docker compose`.

**Author:** `jdtovar07` — frontend only  
**Repository:** https://github.com/jdtovar07/optiview-platform (tag **`v1.0.0`**)  
**Expo deck:** [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx)  
**Live demo:** `docker compose up --build` → http://localhost:8080

---

## What gets presented this week

| Artifact | Role in the expo |
|----------|------------------|
| React SPA (`frontend/`) | **Live demo** — walk through Login → Dashboard → Patients → Inventory → Work Orders |
| [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) | Slides — context, Figma guide, HUs, demo script, architecture |
| [`figma-ui-flow.md`](../../04-week/hu-status/figma-ui-flow.md) | Week-04 Figma frames that map to the screens shown live |
| Release `v1.0.0` | Proof the MVP is shipped — Git Flow feature → develop → qa → main |

---

## My commits — frontend only (`jdtovar07`)

| Step | Commit | Action |
|------|--------|--------|
| Feature | [`170aefe`](https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3) | Add React SPA + ADR 0003 — **39 files, all under `frontend/`** |
| Merge | [`ac4f682`](https://github.com/jdtovar07/optiview-platform/commit/ac4f6825faa608881256eab21d0ced267a888e6d) | `feature/frontend-spa` → `develop` |
| QA | [`d85b2e4`](https://github.com/jdtovar07/optiview-platform/commit/d85b2e46295bdffdae9df360aa2af312cfa5a1d9) | `develop` → `qa` |
| Release | [`185c06b`](https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15) | `qa` → `main` + tag **`v1.0.0`** |

Commit `170aefe` touches **zero** `backend/` paths — the Java monolith was built by a teammate.

---

## Live demo script (MVP 1 expo)

1. **Login** (`Login.tsx`, Figma 07) — authenticate with demo credentials
2. **Dashboard** (`Dashboard.tsx`, Figma 01) — show KPI summary
3. **Patients** (HU-01) — list → register new → view detail (Figma 08–10)
4. **Inventory** (HU-05) — frame list → register frame (Figma 03, 21)
5. **Work Orders** (HU-08) — list → create order → view detail (Figma 12, 13–14, 05)

Wizard note: order creation simplifies Figma steps 19–20 (lenses + summary) — deferred to a later cut.

---

## Figma → React screens

| Figma frame | React screen | Route | HU | API consumed |
|-------------|-------------|-------|-----|--------------|
| 07 Login | `Login.tsx` | `/login` | — | `POST /api/auth/login` |
| 01 Dashboard | `Dashboard.tsx` | `/` | — | `GET /api/summary` |
| 08 Pacientes | `Patients.tsx` | `/patients` | HU-01 | `GET /api/patients?q=` |
| 09 Nuevo paciente | `PatientNew.tsx` | `/patients/new` | HU-01 | `POST /api/patients` |
| 10 Detalle paciente | `PatientDetail.tsx` | `/patients/:id` | HU-01 | `GET /api/patients/{id}` |
| 03 Inventario | `Inventory.tsx` | `/frames` | HU-05 | `GET /api/frames` |
| 21 Registrar montura | `FrameNew.tsx` | `/frames/new` | HU-05 | `POST /api/frames` |
| 12 Órdenes de trabajo | `WorkOrders.tsx` | `/work-orders` | HU-08 | `GET /api/work-orders` |
| 13–14 Wizard | `WorkOrderNew.tsx` | `/work-orders/new` | HU-08 | `POST /api/work-orders` |
| 05 Detalle de Orden | `WorkOrderDetail.tsx` | `/work-orders/:id` | HU-08 | `GET /api/work-orders/{id}` |

---

## Frontend stack

| Piece | Technology |
|-------|------------|
| Framework | React 18 · Vite · TypeScript |
| Routing | React Router (`App.tsx`) |
| Auth | JWT via `auth.tsx` + `api.ts` |
| Layout | `Layout.tsx` — sidebar + top bar (Figma admin pattern) |
| Styling | `index.css` + `theme.tsx` |
| Delivery | Nginx in Docker, proxy `/api` → backend |
| ADR | [`0003-frontend-separado`](https://github.com/jdtovar07/optiview-platform/blob/main/docs/adr/0003-frontend-separado.md) |

---

## Team context for the expo (not my code)

MVP 1 runs as a **modular monolith** (Java backend + React frontend + PostgreSQL in one `docker compose`).
The backend REST API was built by **Bairon Suarez**; my frontend consumes it for the demo.
The team's **future target** is four microservices (`ms-pacientes`, `ms-inventario`, `ms-ordenes`, `ms-facturacion`) — mentioned in the deck for context, not part of this week's frontend delivery.

---

## Correlations

- Figma UI guide (Week 04) → [`figma-ui-flow.md`](../../04-week/hu-status/figma-ui-flow.md)
- Week 05 status (graded) → [`README.md`](./README.md)
- MVP expo deck → [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx)
