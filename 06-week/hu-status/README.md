<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       06-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 06

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document Docker Compose and orchestration foundations, plan OptiView environments and configuration strategy after MVP 1, participate in the classroom multi-team retrospective, and define the repository layout for the evolutionary path beyond the first MVP.
<!-- CONFIG-END -->

> **Week 06 deliverable — post-MVP 1 ops foundations.** After presenting MVP 1 (Week 05), this week focuses on **how we run and evolve the platform**: Docker Compose / orchestration study notes, environment + config planning for OptiView, a **classroom retrospective across all work teams**, and the **repo map** for the evolutionary cut of MVP 1 (monolith → microservices).

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-055 | Document Docker Compose and container orchestration basics | done | [`docker-compose-orchestration-basics.md`](./docker-compose-orchestration-basics.md) |
| HU-OPT-056 | Produce visual summary of Docker Compose / orchestration | done | [`docker-basics.png`](./docker-basics.png) |
| HU-OPT-057 | Document environment planning, configuration strategy and orchestration | done | [`planning-environments-config-orchestration.md`](./planning-environments-config-orchestration.md) |
| HU-OPT-058 | Produce visual summary of environments / config / orchestration planning | done | [`planning-environments-config-orchestration.png`](./planning-environments-config-orchestration.png) |
| HU-OPT-059 | Participate in classroom retrospective covering all work teams | done | See §2 — Classroom retrospective |
| HU-OPT-060 | Define repository layout for the evolutionary path of MVP 1 | done | See §2 — Evolutionary MVP repos |

## 2. My individual contribution

> **Scope this week:** DevOps / platform documentation and team planning — **not** new application feature code. Builds on MVP 1 (`optiview-platform` tag `v1.0.0`) from Week 05.

### Study notes and visuals

| Artifact | What it covers |
|----------|----------------|
| [`docker-compose-orchestration-basics.md`](./docker-compose-orchestration-basics.md) | Multi-container apps, `docker-compose.yml`, networking, volumes, env vars, Compose commands, Compose vs Kubernetes, best practices |
| [`docker-basics.png`](./docker-basics.png) | Visual summary of Docker Compose / orchestration basics |
| [`planning-environments-config-orchestration.md`](./planning-environments-config-orchestration.md) | Dev / Test / Staging / Production, promotion flow, config separation, secrets, feature flags, orchestration concepts (scale, LB, self-healing, discovery) |
| [`planning-environments-config-orchestration.png`](./planning-environments-config-orchestration.png) | Visual summary of environment + config + orchestration planning |

### Mapping to OptiView (after MVP 1)

MVP 1 already runs locally with `docker compose up --build` (frontend + Java monolith + PostgreSQL). This week’s notes frame the **next evolution**:

| Topic | OptiView application |
|-------|----------------------|
| Compose | Keep Compose for local multi-service work as we extract microservices |
| Environments | Align with Git Flow already practiced: `develop` → `qa` → `main` (dev / qa / prod) |
| Configuration | No secrets in repo; env vars / secret store per environment |
| Orchestration | Compose for local/dev; Kubernetes-class orchestration as the production target later |

### Classroom retrospective — all work teams

In class we ran a **retrospective across all work teams** (not only The Illusionists). Each team shared what went well and what to improve after the first MVP cut.

| Focus | Outcome for OptiView / The Illusionists |
|-------|------------------------------------------|
| What went well | MVP 1 delivered and presented (frontend SPA + monolith backend + live demo) |
| What to improve | Clearer split of work as we leave the monolith; stronger environment/config discipline |
| Decision | Treat MVP 1 as the **baseline** and plan an **evolutionary** path (repos + services) instead of a big-bang rewrite |

### Evolutionary MVP — repository layout defined

We **defined the repositories** that will carry the evolutionary progression of the first MVP (monolith → bounded-context services), aligned with the canonical domain map in `opti-docs` (`ms-pacientes` / `ms-inventario` / `ms-ordenes` / `ms-facturacion`):

| Repository (planned / defined) | Role in the evolution |
|--------------------------------|------------------------|
| `optiview-platform` | MVP 1 baseline (modular monolith + React SPA) — remains the runnable reference |
| `opti-docs` | Documentation SSOT (domain, governance, API contracts) |
| `ms-pacientes` | Patients bounded context (extract from monolith) |
| `ms-inventario` | Inventory / frames & lenses bounded context |
| `ms-ordenes` | Work orders bounded context |
| `ms-facturacion` | Billing / invoicing bounded context |
| `api-gateway` | Single entry point for the SPA as services are split |
| Frontend SPA | Continues as React client; later points at gateway instead of monolith `/api` |

This layout supports **incremental extraction**: keep MVP 1 working while each `ms-*` is carved out with its own Git Flow (`feature` → `develop` → `qa` → `main`).

## 3. Blockers and risks

- Evolutionary repos are **defined** this week; service scaffolds and CI per repo are still upcoming.
- Compose is sufficient for local MVP; production orchestration (K8s) is documented conceptually but not deployed yet.
- Config/secrets strategy is documented; team still needs a concrete secret-store choice for shared environments.

## 4. Plan for next week

- Start scaffolding the first evolutionary repos (`ms-*` / gateway) from the layout above.
- Align OpenAPI / events docs in `opti-docs` with the extraction order.
- Keep Compose local stack as the integration harness while services are split.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [ ] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [ ] Tests added/updated (unit / integration)
- [ ] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week 06 is documentation + classroom planning (Compose, environments, config, retrospective, repo map). No application code or HU branches this week — unchecked items apply when evolutionary service repos start receiving code. Configuration separation and “no secrets in repo” are explicit in the planning notes.

## 6. Evidence links

**Course fork (Week 06 docs):**

- Docker Compose / orchestration notes: [`docker-compose-orchestration-basics.md`](./docker-compose-orchestration-basics.md)
- Docker Compose visual: [`docker-basics.png`](./docker-basics.png)
- Environments / config / orchestration planning: [`planning-environments-config-orchestration.md`](./planning-environments-config-orchestration.md)
- Planning visual: [`planning-environments-config-orchestration.png`](./planning-environments-config-orchestration.png)

**Related prior work:**

- MVP 1 platform (Week 05): https://github.com/jdtovar07/optiview-platform (tag `v1.0.0`)
- Domain map (4 microservices): https://github.com/jdtovar07/opti-docs/blob/main/02-domain/domain-map.md
