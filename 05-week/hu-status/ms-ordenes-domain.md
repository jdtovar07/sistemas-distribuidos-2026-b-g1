# ms-ordenes — Tactical DDD Model

> Tactical domain design for the **Orders** bounded context (`ms-ordenes`, Go 1.22).
> Reconciles the Week-01 product brief ([`prd.md`](../../01-week/hu-status/prd.md)), the
> Figma UI flow ([`04-week/hu-status/figma-ui-flow.md`](../../04-week/hu-status/figma-ui-flow.md)),
> the canonical domain map (`opti-docs/02-domain/domain-map.md`) and the event catalog
> (`opti-docs/02-domain/domain-events.md`).

**Author:** Juan Diego Tovar Rodriguez (`jdtovar07`) — Week 05 deliverable.  
**Primary commits:** [`170aefe`](https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3) (frontend SPA) · [`185c06b`](https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15) (MVP 1 release) · [`808a9b6`](https://github.com/jdtovar07/opti-docs/commit/808a9b6e0c870556c41f98d443c1f1b05f97c3b3) (domain map)

---

## Bounded context recap

| Field | Value |
|-------|-------|
| Service | `ms-ordenes` (Go 1.22) |
| Schema | `orders_schema` (PostgreSQL 16) |
| Owns | Work-order lifecycle, lab assignment, assembly details, status history |
| Does NOT own | Patient clinical data, stock levels, invoice amounts |
| Upstream (read) | `ms-pacientes` (patient + current formula), `ms-inventario` (frame/lens stock) |
| Downstream (events) | `ms-inventario` (`OrdenCreada` → stock deduction), `ms-facturacion` (`OrdenCreada` → invoice) |

---

## Aggregate root: `WorkOrder`

Single aggregate per work order. All mutations go through `WorkOrder` methods; no external code
updates `order_status_history` directly.

### Attributes

| Field | Type | Rule |
|-------|------|------|
| `id` | UUID | Aggregate identity |
| `orderCode` | string | Human-readable code (`OT-0142`), unique |
| `patientId` | UUID | Reference only — no PII stored beyond display name snapshot |
| `patientDisplayName` | string | Denormalised for list views |
| `prescriptionSnapshot` | `PrescriptionSnapshot` (VO) | Immutable copy at order-creation time |
| `frameId` / `lensId` | UUID | References validated synchronously against `ms-inventario` |
| `treatments` | `[]Treatment` (VO) | Applied treatments (anti-reflective, blue-light, etc.) |
| `assemblyDetail` | `AssemblyDetail` (VO) | Mounting height, reading distance, special notes |
| `laboratoryId` | UUID? | Set when assigned to lab |
| `status` | `OrderStatus` (VO) | Current lifecycle state |
| `statusHistory` | `[]OrderStatusEntry` | Append-only audit trail |
| `subtotal` | Money (VO) | Quote total before billing consumes it |
| `createdAt` / `updatedAt` | timestamp | Audit |

### Value objects

```go
// PrescriptionSnapshot — copied from ms-pacientes at order creation; never updated
type PrescriptionSnapshot struct {
    FormulaID   uuid.UUID
    SphereOD, CylinderOD, AxisOD float64
    SphereOI, CylinderOI, AxisOI float64
    LensType    string // monofocal | bifocal | progresivo | ocupacional
    CapturedAt  time.Time
}

// AssemblyDetail — mounting instructions beyond the formula
type AssemblyDetail struct {
    MountingHeightMM  *float64
    ReadingDistanceCM *float64
    SpecialNotes      string
}

// OrderStatus — enum VO with transition rules enforced in aggregate
type OrderStatus string
```

### Entities inside the aggregate

| Entity | Role |
|--------|------|
| `OrderStatusEntry` | One row per transition: `fromStatus`, `toStatus`, `changedBy`, `reason`, `changedAt` |
| `Laboratory` (reference) | Stored as `laboratoryId`; full lab registry lives in `orders_schema.laboratories` table but assignment is part of `WorkOrder` behaviour |

---

## State machine

Maps Figma status badges (`figma-ui-flow.md`) to domain states and `opti-docs` event names.

```
                    ┌─────────────┐
                    │  QUOTATION  │  ← CreateWorkOrder (wizard step 20 "Resumen")
                    └──────┬──────┘
              approve      │      cancel (reason required)
                    ┌──────▼──────┐         ┌───────────┐
                    │  APPROVED   │         │ CANCELLED │ (terminal)
                    └──────┬──────┘         └───────────┘
                           │ OrdenCreada published
                    ┌──────▼──────┐
                    │ IN_LABORATORY│  Figma: EN_LABORATORIO
                    └──────┬──────┘
                           │
                    ┌──────▼──────┐
                    │    READY    │  Figma: LISTO
                    └──────┬──────┘
                           │
                    ┌──────▼──────┐
                    │  DELIVERED  │  Figma: ENTREGADO → OrdenEntregada
                    └──────┬──────┘
                           │
                    ┌──────▼──────┐
                    │  WARRANTY   │  (optional post-delivery claim)
                    └─────────────┘
```

| Figma badge | Domain state | Allowed next states |
|-------------|--------------|---------------------|
| (draft) | `QUOTATION` | `APPROVED`, `CANCELLED` |
| PENDIENTE | `APPROVED` | `IN_LABORATORY`, `CANCELLED` |
| EN_LABORATORIO | `IN_LABORATORY` | `READY` |
| LISTO | `READY` | `DELIVERED` |
| ENTREGADO | `DELIVERED` | `WARRANTY` |
| CANCELADO | `CANCELLED` | — (terminal) |

**Invariants (business rules):**

- INV-ORD-001: `Approve()` only from `QUOTATION`; synchronous stock check against `ms-inventario` must pass before state change and `OrdenCreada` emission.
- INV-ORD-002: `Cancel()` requires a non-empty `reason` string; allowed from `QUOTATION`, `APPROVED` only (not after lab work starts — open question from PRD §03).
- INV-ORD-003: `AdvanceStatus()` validates the transition matrix above; illegal transitions return `ErrInvalidTransition` (domain error, not HTTP 500).
- INV-ORD-004: `prescriptionSnapshot` is set once at creation and is immutable.
- INV-ORD-005: `AssignLaboratory()` only when status is `APPROVED` or `IN_LABORATORY`.

---

## Domain events

| Event | Trigger | Consumers |
|-------|---------|-----------|
| `OrdenCreada` | `QUOTATION → APPROVED` | `ms-inventario` (stock), `ms-facturacion` (invoice) |
| `OrdenEstadoCambiado` | Any valid transition | Notification service (future), `portal-paciente` (REST read) |
| `OrdenEntregada` | `READY → DELIVERED` | `ms-facturacion` (close invoice) |

Standard envelope per `opti-docs/02-domain/domain-events.md` (`eventId`, `correlationId`, etc.).

---

## Hexagonal architecture (Go packages)

```
ms-ordenes/
├── domain/                    # ZERO infrastructure imports
│   ├── work_order.go          # Aggregate root + invariants
│   ├── order_status.go        # OrderStatus VO + transition matrix
│   ├── prescription_snapshot.go
│   ├── assembly_detail.go
│   └── errors.go              # ErrInvalidTransition, ErrStockUnavailable
├── application/               # Use cases — depend on domain + ports only
│   ├── create_work_order.go   # HU-08 — wizard steps 13→20
│   ├── approve_work_order.go  # Publishes OrdenCreada
│   ├── advance_status.go      # HU-09
│   ├── assign_laboratory.go   # HU-09
│   ├── deliver_order.go
│   └── ports.go               # OrderRepository, EventPublisher, PatientPort, InventoryPort
└── infrastructure/
    ├── http/                  # REST handlers (views 05, 12, 13–20)
    ├── postgres/              # orders_schema repositories
    ├── rabbitmq/              # event publisher
    └── clients/               # REST adapters to ms-pacientes, ms-inventario
```

### Use cases ↔ Figma views

| Figma frame | Use case | HTTP (sketch) |
|-------------|----------|---------------|
| 12 Órdenes de trabajo | `ListWorkOrders` | `GET /api/v1/orders?status=` |
| 13–20 Wizard | `CreateWorkOrder` | `POST /api/v1/orders` |
| 05 Detalle de Orden | `GetWorkOrder` | `GET /api/v1/orders/{id}` |
| 05 (actions) | `AdvanceStatus`, `Cancel` | `PATCH /api/v1/orders/{id}/status` |
| 17 Proveedores (lab tab) | `AssignLaboratory` | `PATCH /api/v1/orders/{id}/laboratory` |
| 23 Portal Detalle | `GetWorkOrder` (read-only, patient role) | same GET, RBAC-filtered |

Full route tree for all four client apps: `opti-docs/12-ux-ui/navigation-map.md`.

---

## Data model (`orders_schema`)

| Table | Purpose |
|-------|---------|
| `work_orders` | Aggregate persistence |
| `order_status_history` | Append-only status audit |
| `laboratories` | Lab registry (internal/external) |
| `order_treatments` | Treatments applied per order |
| `saga_state` | Idempotency / compensation tracking (Week-01 open item) |

Migration tool: **`golang-migrate`** (per `microservices-documentation.md`).

---

## Figma → domain → API traceability

| Week-04 Figma view | Week-05 navigation route | Domain command | Event |
|--------------------|--------------------------|----------------|-------|
| 13 Nueva orden — Paciente | `/orders/new` step 1 | (collect patientId) | — |
| 14 Nueva orden — Montura | step 2 | (collect frameId) | — |
| 19 Nueva orden — Lentes | step 3 | (collect lens + treatments) | — |
| 20 Nueva orden — Resumen | step 4 | `CreateWorkOrder` | — |
| 20 Confirmar | — | `ApproveWorkOrder` | `OrdenCreada` |
| 05 Detalle de Orden | `/orders/:id` | `AdvanceStatus` | `OrdenEstadoCambiado` |
| 12 Órdenes de trabajo | `/orders` | `ListWorkOrders` | — |
| 23 Portal Detalle | `/my-order` | `GetWorkOrder` (read) | — |

---

## Open questions (carried from PRD)

- Stock-reservation timeout for `QUOTATION` orders not approved within N minutes (HU-OPT-020 blocker).
- Cancellation after `IN_LABORATORY` — compensation flow (return stock, void invoice).
- Who may call `AdvanceStatus`: seller only, lab operator, or both (RBAC matrix TBD).

---

## Correlations

- Product brief → [`01-week/hu-status/prd.md`](../../01-week/hu-status/prd.md)
- Figma UI → [`04-week/hu-status/figma-ui-flow.md`](../../04-week/hu-status/figma-ui-flow.md)
- Domain map (canonical) → [`opti-docs/02-domain/domain-map.md`](https://github.com/jdtovar07/opti-docs/blob/main/02-domain/domain-map.md)
- Domain events → [`opti-docs/02-domain/domain-events.md`](https://github.com/jdtovar07/opti-docs/blob/main/02-domain/domain-events.md)
- Navigation map → [`opti-docs/12-ux-ui/navigation-map.md`](https://github.com/jdtovar07/opti-docs/blob/main/12-ux-ui/navigation-map.md)
