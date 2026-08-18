# Product backlog on GitHub Projects — Week 02

Evidence that The Illusionists started tracking OptiView work as GitHub Issues with testable acceptance criteria, visible on the org Kanban board.

## Board

| Field | Value |
|---|---|
| Organization | [TheIllusionists](https://github.com/TheIllusionists) |
| Project | [The illusionists Board](https://github.com/orgs/TheIllusionists/projects/1) |
| Views | Backlog · Board (Kanban: To Do / In Progress / In Review / Done) |
| Issues repo (profile) | [`jdtovar07/jdtovar07`](https://github.com/jdtovar07/jdtovar07) |

## User stories created

### HU-01 — Registrar paciente

| Field | Value |
|---|---|
| Issue | https://github.com/jdtovar07/jdtovar07/issues/1 |
| Labels | `ms-pacientes` · `feature` · `priority: alta` |
| Milestone | Fase 1 — Core backend |
| Story points | 3 |
| Board status | **To Do** |

**As a** receptionist / optometrist, **I want** to register a new patient with personal and contact data, **so that** their information is available before the visual exam.

Acceptance criteria (testable): document uniqueness, required fields, `status = ACTIVE` on success, clear duplicate error, immediate list refresh.

### HU-02 — Registrar fórmula óptica

| Field | Value |
|---|---|
| Issue | https://github.com/jdtovar07/jdtovar07/issues/2 |
| Labels | `ms-pacientes` · `feature` · `priority: alta` |
| Milestone | Fase 1 — Core backend |
| Story points | 5 |
| Board status | **To Do** |

**As an** optometrist, **I want** to register the patient's optical formula after the exam, **so that** the prescription is recorded and can be used when creating a work order.

Acceptance criteria (testable): OD/OI sphere/cylinder/axis/addition/PD, axis 0–180, lens type, single `is_current` formula, required examiner + exam date, visible on patient record.

## Evidence screenshots

### Backlog view

![The Illusionists Board — Backlog with HU-01 and HU-02 in To Do](./board-backlog.png)

### Board (Kanban) view

![The Illusionists Board — Kanban To Do column with HU-01 and HU-02](./board-kanban.png)

## How this ties to Week 02 WoW

- **Scrum:** Product Backlog items with story points and a milestone (Fase 1).
- **Kanban:** same items on the Board columns (WIP-ready: To Do → In Progress → In Review → Done).
- **Course compliance:** stories include **testable acceptance criteria** (not wishes).
- Scope note: these first HUs belong to `ms-pacientes`; work-order HUs for `ms-ordenes` will follow the same board pattern.
