# Product Brief

project_key: PRJ-OPTIVIEW-ORDENES

## Declared Tech Stack

- backend: Go 1.22+
- database: PostgreSQL 16 (schema: orders_schema)
- messaging: RabbitMQ (domain events producer and consumer)
- auth: Keycloak + JWT
- frontend: Angular 18+ (sales portal — work-order management)

---

## 00 — Initial Context

OptiView is an integral management platform for optical stores and visual-health centres in Colombia and Latin America. This brief covers the **Orders bounded context** — the operational core of the system — implemented as the `ms-ordenes` microservice in Go 1.22+.

The work order is the central document of an optical store: it links a patient, their current optical formula, a chosen frame and a lens type into a single unit of work that must be produced by a laboratory and delivered to the patient. Today this process is managed entirely through paper, WhatsApp messages and phone calls — there is no digital state machine, no visibility for the patient, and no integration with external laboratories or the billing system.

`ms-ordenes` owns the complete work-order lifecycle: from creation through lab assignment to delivery. It consumes `PatientDataValidated` from `ms-pacientes` and `StockReserved` from `ms-inventario`; it produces `OrderCreated`, `OrderStatusChanged` and `OrderDelivered` events consumed by `ms-facturacion` and the notification service.

---

## 01 — Needs and Problems

- Create a work order that links patient + optical formula + frame + lens type in a single validated document, without manual retyping.
- Track the full lifecycle of a work order through clearly defined states: Quotation → Approved → In Lab → Ready → Delivered → Warranty.
- Assign an order to an internal or external laboratory and know at any moment which lab has which order and what its production status is.
- Record assembly details (mounting height, reading distance, special observations) that are not in the formula but are critical for correct lens mounting.
- Notify the patient automatically when the order state changes — especially when it is ready for pick-up.
- Keep a complete order history per patient so the optometrist can reference previous frame-and-lens choices.

Main problem: the work-order flow is opaque — the patient does not know where their glasses are, the store does not know which orders are overdue at the lab, and the billing team does not know when an order is delivered so they can close the invoice.

---

## 02 — Current Process

1. Patient selects frame and lens → seller writes order on paper → copy goes to the lab via WhatsApp photo.
2. Lab confirms receipt by WhatsApp reply (or says nothing until delivery).
3. When the lab delivers, staff receives the glasses, does a visual check and calls the patient.
4. Patient comes in → receives glasses → pays → seller manually marks the order as done on a spreadsheet.
5. No link exists between this order and the patient's formula history or the billing system.

Expected process with `ms-ordenes`:
1. Seller selects patient → system fetches current formula from `ms-pacientes` REST API automatically.
2. Seller selects frame and lens → `ms-inventario` validates availability and reserves stock.
3. Order created in `ms-ordenes` → `OrderCreated` event emitted → `ms-facturacion` generates quotation automatically.
4. Lab assignment recorded → order state changes tracked digitally with timestamps.
5. Each state change emits `OrderStatusChanged` → notification service sends patient update.
6. Order delivered → `OrderDelivered` event → `ms-facturacion` closes the invoice.

---

## 03 — Open Questions

- Should the stock reservation be released automatically if the order is not approved within N minutes (requires Saga compensation timeout design)?
- Can an order be cancelled after it has been sent to the lab, and if so, what is the compensation flow (return stock, void invoice)?
- Is the lab always external, or can there be an internal lab with its own workflow inside `ms-ordenes`?
- Should the patient be able to see the real-time state of their order through the patient portal, and if so, what data is exposed?
- What happens when the lab delivers a defective product — does a Warranty state trigger a new work order or a correction of the existing one?
- Who can change an order state: only the assigned seller, any seller, or also the optometrist?

---

## 04 — Business Glossary

- **Work order (OT)**: document linking patient + optical formula + frame + lens type and defining the production work to be done by a laboratory.
- **Order state**: current step of the work order in its lifecycle (Quotation, Approved, In Lab, Ready, Delivered, Warranty).
- **Laboratory**: workshop (internal or external) where lenses are ground and mounted into the frame.
- **Assembly detail**: additional measurements required for correct lens mounting beyond the optical formula: mounting height, reading distance, special instructions.
- **Stock reservation**: temporary hold on a frame and lens unit while the order is being approved, preventing another order from taking the same item.
- **OrderCreated**: domain event emitted when a work order is persisted and approved; consumed by `ms-facturacion` to generate the quotation.
- **OrderStatusChanged**: domain event emitted on every state transition; consumed by the notification service to alert the patient.
- **OrderDelivered**: domain event emitted when the patient receives their glasses; consumed by `ms-facturacion` to close and finalise the invoice.
- **Saga**: distributed transaction pattern used to coordinate the multi-step order-creation flow across `ms-pacientes`, `ms-inventario` and `ms-ordenes`, with compensating actions on failure.
