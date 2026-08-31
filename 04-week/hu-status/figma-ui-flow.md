# OptiView — Product UI (Figma)

> Complete high-fidelity UI design for OptiView across the admin, sales and patient-facing
> applications. Built in Figma in collaboration with **Bairon Suarez** (The Illusionists).
> File page: **OptiView - Product UI** — 25 application views (frames `01`–`25`) plus a
> presentation cover (`00`).

**Figma file:** https://www.figma.com/design/zD1Tfk9xzgg6eXSMvaOLdB/Untitled?node-id=0-1&t=VyPMTbmxBNHalmpI-1

---

## Design system conventions (shared across views)

| Element | Convention |
|---------|------------|
| Admin / sales apps | Desktop layout — fixed left sidebar, top bar with search and user menu, white content area |
| Patient portal | Mobile-first layout — bottom navigation or stacked cards; login (view 07) shows phone mockups |
| Primary colour | Teal / dark sidebar (`#1a2332` range) with white cards and blue accent actions |
| Typography | Sans-serif; section titles in bold; table headers uppercase or semi-bold |
| Tables | Search bar + filters + paginated data grid + row actions (view, edit) |
| Forms | Label above field; required fields marked; primary CTA bottom-right |
| Status badges | Colour-coded pills for order states (`PENDIENTE`, `EN_LABORATORIO`, `LISTO`, `ENTREGADO`, `CANCELADO`) |
| Navigation | Sidebar items map to bounded contexts: Pacientes, Inventario, Órdenes, Facturación, Reportes, Configuración |

---

## View catalogue (25 application views)

### Admin & operations — portal-admin / portal-ventas (desktop)

| # | Frame name | App | Actor | Purpose | Key components | Related HU / service |
|---|------------|-----|-------|---------|----------------|-------------------|
| 01 | Dashboard Admin | portal-admin | `ADMIN_OPTICA` | Operational overview — daily KPIs at a glance | Stat cards (patients today, open orders, low stock, revenue), bar/line charts, recent-orders table, quick-action buttons | HU-12 daily closing summary · all services |
| 02 | Ventas y Caja | portal-ventas | `VENDEDOR` | Point-of-sale and cash-register view | Open orders queue, payment method selector, totals panel, daily sales counter | HU-08, HU-11 · `ms-ordenes`, `ms-facturacion` |
| 03 | Inventario | portal-admin | `ADMIN_INVENTARIO` | Stock listing for frames and lenses | Filterable table (SKU, brand, qty, min stock), low-stock alert badge, "Registrar montura" CTA | HU-05, HU-06 · `ms-inventario` |
| 04 | Usuarios y Roles | portal-admin | `SUPER_ADMIN` | RBAC user management | User table, role assignment dropdown (`RECEPCIONISTA`, `OPTOMETRA`, `VENDEDOR`, …), active/inactive toggle | `security-policy-opti.md` roles · Keycloak |
| 05 | Detalle de Orden | portal-admin / portal-ventas | `VENDEDOR`, `OPERADOR_LABORATORIO` | Single work-order detail with full lifecycle | Order header (ID, patient, date), status timeline, assembly details, lab assignment, action buttons (advance status, cancel) | HU-09 · `ms-ordenes` |
| 08 | Pacientes | portal-admin | `RECEPCIONISTA`, `OPTOMETRA` | Searchable patient registry | Search by document/name, paginated table, "Nuevo paciente" button | HU-01, HU-14 · `ms-pacientes` |
| 09 | Nuevo paciente | portal-admin | `RECEPCIONISTA` | Patient registration form | Fields: document type/number, names, phone, email, address; validation messages in Spanish | HU-01 · `ms-pacientes` |
| 10 | Detalle paciente | portal-admin | `OPTOMETRA`, `RECEPCIONISTA` | Patient profile with history tabs | Personal data card, formula history list, periodic controls, "Nueva fórmula" CTA | HU-03, HU-04 · `ms-pacientes` |
| 11 | Nueva fórmula óptica | portal-admin | `OPTOMETRA` | Optical prescription capture | OD/OI sphere, cylinder, axis, addition, lens type selector (`monofocal`, `bifocal`, `progresivo`, `ocupacional`), save/cancel | HU-02 · `ms-pacientes` |
| 12 | Órdenes de trabajo | portal-ventas | `VENDEDOR`, `OPERADOR_LABORATORIO` | Work-order listing and status filter | Status filter chips, order table (patient, frame, state, lab), "Nueva orden" CTA | HU-08, HU-09 · `ms-ordenes` |
| 15 | Facturación y cartera | portal-ventas | `VENDEDOR`, `ADMIN_OPTICA` | Invoices, payments and accounts receivable | Invoice list, payment status, "Registrar pago" modal, daily closing entry point | HU-10, HU-11, HU-12 · `ms-facturacion` |
| 16 | Reportes | portal-admin | `ADMIN_OPTICA` | Business analytics and exports | Date-range picker, chart widgets (sales, inventory turnover, patient growth), export CSV/PDF button | Reports · multiple services |
| 17 | Proveedores y laboratorios | portal-admin | `ADMIN_INVENTARIO` | Supplier and lab partner registry | Two tabs — suppliers (contact, lead time) and laboratories (name, turnaround, active orders) | HU-09 lab assignment · `ms-inventario`, `ms-ordenes` |
| 18 | Configuración | portal-admin | `SUPER_ADMIN`, `ADMIN_OPTICA` | System and store settings | Store info, notification preferences, integration toggles (Keycloak realm, RabbitMQ status indicator) | `10-devops/environments.md` |
| 21 | Registrar montura | portal-admin | `ADMIN_INVENTARIO` | Add new frame to inventory | SKU, brand, model, buy/sell price, initial stock, min stock threshold | HU-05 · `ms-inventario` |
| 22 | Crear usuario | portal-admin | `SUPER_ADMIN` | New staff account form | Name, email, role selector, temporary password flow (Keycloak) | RBAC · Keycloak |

### New-order wizard — portal-ventas (multi-step flow)

| # | Frame name | Step | Purpose | Key components | Related HU / service |
|---|------------|------|---------|----------------|-------------------|
| 13 | Nueva orden — Paciente | 1 / 4 | Select or confirm patient and active formula | Patient search autocomplete, selected patient card, formula preview (OD/OI values) | HU-08 · `ms-pacientes` (sync validation) |
| 14 | Nueva orden — Montura | 2 / 4 | Pick frame from available stock | Frame grid/list with image thumbnail, SKU, price, stock qty; out-of-stock items disabled | HU-08 · `ms-inventario` (stock check) |
| 19 | Nueva orden — Lentes | 3 / 4 | Configure lens options from formula | Lens type (from formula), material, treatments (anti-reflective, blue light), lab preference | HU-08 · `ms-ordenes` |
| 20 | Nueva orden — Resumen | 4 / 4 | Review and confirm before Saga starts | Summary cards (patient, frame, lenses, prices), total, "Confirmar orden" CTA triggering distributed flow | HU-08 · Saga across `ms-pacientes`, `ms-inventario`, `ms-ordenes` |

**Wizard navigation:** linear stepper at top (`Paciente → Montura → Lentes → Resumen`); back/next buttons; cancel returns to view 12.

### Patient portal — portal-paciente (mobile-oriented)

| # | Frame name | Actor | Purpose | Key components | Related HU / service |
|---|------------|-------|---------|----------------|-------------------|
| 06 | Portal del Paciente | Patient (authenticated) | Home screen after login | Welcome banner, active order card with status, upcoming control reminder, quick links (orders, payments, profile) | `portal-paciente` · `ms-pacientes`, `ms-ordenes` |
| 07 | Inicio de sesión | All users | Keycloak login entry point | Email/password fields, "Iniciar sesión" button, forgot-password link; shown in phone mockup for patient app and desktop for admin | Keycloak + JWT · all services |
| 23 | Portal — Detalle de orden | Patient | Track a single order from the patient side | Order status stepper (read-only), estimated delivery date, lab name, contact optician link | HU-09 (read-only) · `ms-ordenes` |
| 24 | Portal — Realizar abono | Patient | Partial or full payment on outstanding balance | Amount input, payment method icons (efectivo, tarjeta, PSE, Nequi, Daviplata), confirmation summary | HU-11 · `ms-facturacion` |
| 25 | Portal — Mi perfil | Patient | Personal data and notification preferences | Editable contact fields (not clinical data), notification toggles, logout button | `ms-pacientes` (PII read/update) |

---

## Navigation map (primary flows)

```
07 Login
 ├── Admin sidebar → 01 Dashboard
 │                  → 08 Pacientes → 09 Nuevo → 10 Detalle → 11 Fórmula
 │                  → 03 Inventario → 21 Registrar montura
 │                  → 12 Órdenes → 13→14→19→20 Wizard → 05 Detalle
 │                  → 02 Ventas y Caja
 │                  → 15 Facturación → 24 (portal mirror)
 │                  → 16 Reportes
 │                  → 17 Proveedores
 │                  → 04 Usuarios → 22 Crear usuario
 │                  → 18 Configuración
 └── Patient app  → 06 Portal → 23 Detalle orden
                              → 24 Abono
                              → 25 Perfil
```

---

## Collaboration split (Week 04)

| Contributor | Responsibility |
|-------------|----------------|
| **Juan Diego Tovar Rodriguez** (`jdtovar07`) | Admin views (01–05, 08–12, 15–18), new-order wizard (13–14, 19–20), design-system tokens, Figma file structure, this documentation |
| **Bairon Suarez** | Patient portal views (06–07, 23–25), inventory/user forms (21–22), responsive mobile layouts, component consistency review |

---

## Correlations

- Product brief / PRD → [`01-week/hu-status/prd.md`](../../01-week/hu-status/prd.md)
- UX/UI section in `opti-docs` → `12-ux-ui/design-system.md`, `12-ux-ui/navigation-map.md`
- User stories → `04-requirements/user-stories.md`
- RBAC roles per view → `opti-docs/00-governance/security-policy-opti.md`
