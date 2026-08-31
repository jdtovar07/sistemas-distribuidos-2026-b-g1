<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       04-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 04

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Build the complete OptiView Product UI in Figma — 25 high-fidelity views covering admin, sales and patient portal flows — in collaboration with Bairon Suarez, and document every screen with its purpose, components and navigation map.
<!-- CONFIG-END -->

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-040 | Design admin dashboard and core operations views (01–05) | done | [`figma-ui-flow.md`](./figma-ui-flow.md) |
| HU-OPT-041 | Design patients module views (08–11) | done | [`figma-ui-flow.md`](./figma-ui-flow.md) |
| HU-OPT-042 | Design work orders list and new-order wizard (12–14, 19–20) | done | [`figma-ui-flow.md`](./figma-ui-flow.md) |
| HU-OPT-043 | Design billing, reports, suppliers and settings (15–18) | done | [`figma-ui-flow.md`](./figma-ui-flow.md) |
| HU-OPT-044 | Design inventory and user management forms (21–22) | done | [`figma-ui-flow.md`](./figma-ui-flow.md) |
| HU-OPT-045 | Design patient portal views (06–07, 23–25) | done | [`figma-ui-flow.md`](./figma-ui-flow.md) |
| HU-OPT-046 | Document complete Figma UI flow with navigation map and design conventions | done | [`figma-ui-flow.md`](./figma-ui-flow.md) |

## 2. My individual contribution

- Built the complete **OptiView Product UI** Figma file in collaboration with **Bairon Suarez** — 25 application views (frames `01`–`25`) on the page **OptiView - Product UI**, plus a presentation cover (`00`).
- **Figma file:** https://www.figma.com/design/zD1Tfk9xzgg6eXSMvaOLdB/Untitled?node-id=0-1&t=VyPMTbmxBNHalmpI-1
- Defined a shared **design system** for all views: desktop admin/sales layout (left sidebar + top bar + white content area), mobile-first patient portal, teal/dark sidebar palette, table + form patterns, Spanish user-facing labels and colour-coded order-status badges.
- Designed **admin & operations views (01–05, 08–12, 15–18, 21–22):**
  - `01` Dashboard Admin — KPI cards, charts, recent orders
  - `02` Ventas y Caja — POS / cash register for `VENDEDOR`
  - `03` Inventario — stock table with low-stock alerts (`ms-inventario`)
  - `04` Usuarios y Roles — RBAC management aligned with `security-policy-opti.md`
  - `05` Detalle de Orden — full work-order lifecycle view (`ms-ordenes`, HU-09)
  - `08` Pacientes — searchable registry (HU-01)
  - `09` Nuevo paciente — registration form (HU-01)
  - `10` Detalle paciente — profile with formula history (HU-03, HU-04)
  - `11` Nueva fórmula óptica — prescription capture (HU-02)
  - `12` Órdenes de trabajo — order listing with status filters (HU-08)
  - `15` Facturación y cartera — invoices and payments (HU-10, HU-11, HU-12)
  - `16` Reportes — analytics and export
  - `17` Proveedores y laboratorios — supplier and lab registry
  - `18` Configuración — store and system settings
  - `21` Registrar montura — add frame to inventory (HU-05)
  - `22` Crear usuario — staff account creation (Keycloak)
- Designed the **new-order wizard (13–14, 19–20)** — 4-step flow for HU-08:
  - Step 1 `13` Paciente — select patient and active formula (`ms-pacientes`)
  - Step 2 `14` Montura — pick frame from stock (`ms-inventario`)
  - Step 3 `19` Lentes — configure lens options from formula
  - Step 4 `20` Resumen — review and confirm, triggering the distributed Saga
- Designed **patient portal views (06–07, 23–25)** with Bairon Suarez — mobile-oriented layouts:
  - `06` Portal del Paciente — home with active order and reminders
  - `07` Inicio de sesión — Keycloak login (phone mockup for patient app)
  - `23` Portal — Detalle de orden — read-only order tracking
  - `24` Portal — Realizar abono — partial/full payment (HU-11)
  - `25` Portal — Mi perfil — contact data and notification preferences
- Wrote [`figma-ui-flow.md`](./figma-ui-flow.md) documenting every view: frame name, target app, actor/role, purpose, key UI components, related backlog HU and microservice, plus a navigation map and collaboration split.
- Captured Figma evidence screenshot: [`OptiView-Product-UI.png`](./OptiView-Product-UI.png).

## 3. Blockers and risks

- Figma views are high-fidelity mockups only — no Angular/React implementation yet; risk of UI–API drift if OpenAPI contracts are not written before coding starts.
- Patient portal views (06–07, 23–25) use mobile layouts; responsive breakpoints for tablet/desktop are not yet defined.
- Stock-reservation timeout (HU-OPT-020) still undefined — the wizard summary view (`20`) cannot show a countdown/compensation message without that value.
- RBAC visibility rules per view (which sidebar items each role sees) are implied in the design but not yet documented as a permission matrix in `opti-docs/12-ux-ui/`.

## 4. Plan for next week

- Map each Figma view to OpenAPI endpoints and publish contracts in `opti-docs/07-api/contracts/openapi/`.
- Start Angular implementation of `portal-admin` shell (sidebar + router) from views 01 and 08.
- Model the tactical DDD layer for `ms-ordenes` (`WorkOrder` aggregate, state machine, domain events).
- Update `opti-docs/12-ux-ui/navigation-map.md` with the Figma navigation map from [`figma-ui-flow.md`](./figma-ui-flow.md).
- Resolve stock-reservation timeout with the team for HU-OPT-020 acceptance criteria.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [ ] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [ ] Tests added/updated (unit / integration)
- [ ] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes on the unchecked items:
- Each Figma view maps to a backlog HU with verifiable UI acceptance criteria (form fields, navigation paths, role visibility) documented in [`figma-ui-flow.md`](./figma-ui-flow.md).
- No production code this week — deliverable is the complete Figma UI + documentation.
- DDD/domain code planned for Week 05 after UI contracts are frozen.

## 6. Evidence links

- Figma file (OptiView - Product UI): https://www.figma.com/design/zD1Tfk9xzgg6eXSMvaOLdB/Untitled?node-id=0-1&t=VyPMTbmxBNHalmpI-1
- UI flow documentation: [`figma-ui-flow.md`](./figma-ui-flow.md)
- Figma screenshot (25 views): [`OptiView-Product-UI.png`](./OptiView-Product-UI.png)
- Product brief / PRD: [`01-week/hu-status/prd.md`](../../01-week/hu-status/prd.md)
- Week-03 governance (RBAC roles per view): [`opti-docs/security-policy-opti.md`](https://github.com/jdtovar07/opti-docs/blob/main/00-governance/security-policy-opti.md)
- The Illusionists Board: https://github.com/orgs/TheIllusionists/projects/1

![OptiView Product UI — 25 Figma views (frames 01–25)](./OptiView-Product-UI.png)
