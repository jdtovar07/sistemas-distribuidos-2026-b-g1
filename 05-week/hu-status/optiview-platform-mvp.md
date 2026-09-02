# OptiView Platform — MVP 1 (Corte 1)

> First executable increment of OptiView, presented as the team's **MVP 1**. Primary development
> by **`jdtovar07`**: React SPA frontend (commit [`170aefe`](https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3))
> and Git Flow release to `main` (commit [`185c06b`](https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15)),
> following the Week-04 **Figma UI guide** and backlog **HUs** HU-01, HU-05, HU-08.
>
> **Architectural decision:** starts as a **modular monolith** (single deployable) with clean
> / hexagonal boundaries inside one Spring Boot module — intentional stepping stone before
> extracting the four domain microservices documented in `opti-docs`.

**Repository:** https://github.com/jdtovar07/optiview-platform  
**Release:** tag `v1.0.0` — commit [`185c06b`](https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15)  
**Expo deck:** [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) — MVP 1 presentation to professor and classroom  
**Run:** `docker compose up --build` → http://localhost:8080

---

## Why monolith first, microservices later

| Phase | Architecture | Rationale |
|-------|-------------|-----------|
| **MVP 1 (now)** | Modular monolith — one backend + one React SPA + one PostgreSQL | Small team, short cut; local transactions; single `docker compose up`; proves HUs end-to-end |
| **Target (opti-docs)** | 4 domain microservices + api-gateway | `ms-pacientes`, `ms-inventario`, `ms-ordenes`, `ms-facturacion` — each with own schema and deploy cycle |

ADR [`0001-monolito-modular-hexagonal`](https://github.com/jdtovar07/optiview-platform/blob/main/docs/adr/0001-monolito-modular-hexagonal.md) documents the decision: domain packages (`model` / `usecase` / `infrastructure`) are designed so each aggregate can be **extracted to its own service** without rewriting business rules — the Week-05 tactical model in [`ms-ordenes-domain.md`](./ms-ordenes-domain.md) describes the Go target for the Orders slice.

**Extraction path (planned):**

```
optiview-platform (monolith MVP 1)
  ├── patient module   ──extract──►  ms-pacientes  (Java / Spring Boot)
  ├── frame module   ──extract──►  ms-inventario (Java / Spring Boot)
  ├── workorder module ──extract──►  ms-ordenes    (Go)
  └── (billing TBD)  ──extract──►  ms-facturacion (Go)
```

---

## Scope — 3 user stories implemented

| HU | Description | Business rules enforced | Tests |
|----|-------------|------------------------|-------|
| **HU-01** | Register a patient | Unique document; names, phone, EPS required | `PatientTest` |
| **HU-05** | Register a frame in inventory | Unique SKU; `stock ≥ 0`; `sale_price ≥ cost` | `FrameTest` |
| **HU-08** | Create a work order (happy path) | Links patient + frame with stock; initial status `QUOTATION`; deducts 1 unit; insufficient stock → error | `CreateWorkOrderUseCaseTest`, `OptiviewIntegrationTest` |

Out of MVP 1 scope (planned for later cuts / microservices): lenses/treatments in orders, billing, reports, user management UI, patient portal.

---

## Figma → implemented screens

Screens in `frontend/src/screens/` were built following the Week-04 Figma frames:

| Figma frame (Week 04) | React screen | Route / flow |
|----------------------|--------------|--------------|
| 07 Inicio de sesión | `Login.tsx` | `/login` |
| 01 Dashboard Admin | `Dashboard.tsx` | `/` — summary KPIs (`GET /api/summary`) |
| 08 Pacientes | `Patients.tsx` | `/patients` — search list |
| 09 Nuevo paciente | `PatientNew.tsx` | `/patients/new` — HU-01 form |
| 10 Detalle paciente | `PatientDetail.tsx` | `/patients/:id` |
| 03 Inventario | `Inventory.tsx` | `/frames` — frame list |
| 21 Registrar montura | `FrameNew.tsx` | `/frames/new` — HU-05 form |
| 12 Órdenes de trabajo | `WorkOrders.tsx` | `/work-orders` — order list |
| 13–14 Wizard (simplified) | `WorkOrderNew.tsx` | `/work-orders/new` — patient + frame selection (HU-08) |
| 05 Detalle de Orden | `WorkOrderDetail.tsx` | `/work-orders/:id` |

MVP 1 simplifies the 4-step wizard (13→14→19→20) into a single create screen — lenses and treatments deferred to MVP 2 / `ms-ordenes` microservice.

---

## Tech stack (MVP 1)

| Layer | Technology |
|-------|------------|
| Backend | Java 21 · Spring Boot 3.5 · Spring Security (JWT) · Spring Data JPA |
| Database | PostgreSQL 16 · Flyway (`V1__init.sql`) |
| Frontend | React 18 · Vite · TypeScript · Nginx reverse proxy |
| Delivery | `docker-compose.yml` — `db` + `backend` + `frontend` |
| Architecture | Clean / hexagonal inside one Maven module (`model` → `usecase` → `infrastructure`) |

Demo users (seeded): `admin` / `seller` / `optometrist` — see repo README.

---

## Git Flow applied (optiview-platform) — `jdtovar07` commits

| Step | Branch flow | Commit (jdtovar07) |
|------|-------------|-------------------|
| Frontend feature | `feat(frontend): add OptiView SPA` | [`170aefe`](https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3) |
| Merge to develop | `feature/frontend-spa` → `develop` | [`ac4f682`](https://github.com/jdtovar07/optiview-platform/commit/ac4f6825faa608881256eab21d0ced267a888e6d) |
| QA promotion | `develop` → `qa` | [`d85b2e4`](https://github.com/jdtovar07/optiview-platform/commit/d85b2e46295bdffdae9df360aa2af312cfa5a1d9) |
| Production release | `qa` → `main` + tag `v1.0.0` | [`185c06b`](https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15) |

---

## API endpoints (MVP 1)

| Method | Route | HU | Figma view |
|--------|-------|-----|------------|
| `POST` | `/api/auth/login` | — | 07 |
| `GET` | `/api/summary` | — | 01 |
| `GET/POST` | `/api/patients` | HU-01 | 08, 09 |
| `GET` | `/api/patients/{id}` | HU-01 | 10 |
| `GET/POST` | `/api/frames` | HU-05 | 03, 21 |
| `GET/POST` | `/api/work-orders` | HU-08 | 12, 13–14 |
| `GET` | `/api/work-orders/{id}` | HU-08 | 05 |

---

## Correlations

- Figma UI design → [`04-week/hu-status/figma-ui-flow.md`](../../04-week/hu-status/figma-ui-flow.md)
- Target microservices model → [`ms-ordenes-domain.md`](./ms-ordenes-domain.md)
- Canonical domain map → [`opti-docs/02-domain/domain-map.md`](https://github.com/jdtovar07/opti-docs/blob/main/02-domain/domain-map.md)
- ADR monolith decision → [`optiview-platform/docs/adr/0001`](https://github.com/jdtovar07/optiview-platform/blob/main/docs/adr/0001-monolito-modular-hexagonal.md)
- MVP 1 expo presentation → [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx)
