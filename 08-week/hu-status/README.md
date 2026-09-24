<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       08-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 08

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document Agile & DevOps practices for distributed teams and planning practices (story mapping, estimation, MVP commitment); rename opti-docs section 08 to 08-diagrams; and add four OptiView architecture diagrams to guide the next evolutionary cuts after MVP 1.
<!-- CONFIG-END -->

> **Week 08 deliverable — planning the next OptiView cuts.** After MVP 1 (Week 05), ops foundations (Week 06), and contracts + repo access (Week 07), this week documents **how a distributed team plans and delivers** (Agile + DevOps) and **how we map / estimate / commit MVP scope** for the evolutionary `opti-*` services, plus the **`08-uml/` → `08-diagrams/` folder rename** and **four Mermaid diagrams** in `code-corhuila/opti-docs` adapted from the instructor simple-stock-flow session.

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-066 | Document Agile & DevOps for distributed teams | done | [`agile-devops-distributed-teams.md`](./agile-devops-distributed-teams.md) |
| HU-OPT-067 | Produce visual summary of Agile & DevOps for distributed teams | done | [`agile-devops-distributed-teams.png`](./agile-devops-distributed-teams.png) |
| HU-OPT-068 | Document story mapping, estimation and MVP commitment | done | [`planning-story-mapping-estimation-mvp-commitment.md`](./planning-story-mapping-estimation-mvp-commitment.md) |
| HU-OPT-069 | Produce visual summary of story mapping / estimation / MVP commitment | done | [`planning-story-mapping-estimation-mvp-commitment.png`](./planning-story-mapping-estimation-mvp-commitment.png) |
| HU-OPT-070 | Rename `opti-docs` section folder `08-uml/` → `08-diagrams/` and record it in CHANGELOG | done | https://github.com/code-corhuila/opti-docs/commit/1d613d37d7a0cb361fb9b55dfc2680bc56d8b97f |
| HU-OPT-071 | Add planned monorepo work-tree diagram (`flow-arbol-de-trabajo.mmd`) | done | https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/flow-arbol-de-trabajo.mmd |
| HU-OPT-072 | Add hexagonal repo-structure diagram for Java + Go (`c4-estructura-repositorios.mmd`) | done | https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/c4-estructura-repositorios.mmd |
| HU-OPT-073 | Add double-hexagon diagram portal-paciente + ms-pacientes (`c4-doble-hexagono.mmd`) | done | https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/c4-doble-hexagono.mmd |
| HU-OPT-074 | Add inward-dependency + test-layers diagram (`flow-regla-dependencia.mmd`) | done | https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/flow-regla-dependencia.mmd |

## 2. My individual contribution

> **Scope this week:** Agile / product-planning documentation mapped to OptiView, plus architecture diagrams in `opti-docs` — **not** new application feature code. Builds on MVP 1 (`opti-view`) and the evolutionary `code-corhuila/opti-*` catalog (19 repos) with full collaborator access from Week 07.

### Study notes and visuals

| Artifact | What it covers |
|----------|----------------|
| [`agile-devops-distributed-teams.md`](./agile-devops-distributed-teams.md) | Agile principles for remote/distributed work; DevOps culture; CI/CD; IaC; automation; observability; communication strategies for multi-location teams |
| [`agile-devops-distributed-teams.png`](./agile-devops-distributed-teams.png) | Visual summary of Agile & DevOps for distributed teams |
| [`planning-story-mapping-estimation-mvp-commitment.md`](./planning-story-mapping-estimation-mvp-commitment.md) | Story maps (activities → tasks → stories); estimation (story points, Fibonacci, T-shirt, Planning Poker); MVP definition & commitment; MoSCoW; value vs effort; release planning |
| [`planning-story-mapping-estimation-mvp-commitment.png`](./planning-story-mapping-estimation-mvp-commitment.png) | Visual summary of story mapping, estimation and MVP commitment |

### Folder rename in `opti-docs`

Renamed section **`08-uml/` → `08-diagrams/`** so the numbered folder is English (ADR-001 / `documentation-rules.md`). Commit [`1d613d3`](https://github.com/code-corhuila/opti-docs/commit/1d613d37d7a0cb361fb9b55dfc2680bc56d8b97f), merged to `main` via PR [`#14`](https://github.com/code-corhuila/opti-docs/pull/14).

| Before | After |
|--------|--------|
| `08-uml/` | `08-diagrams/` |

Recorded in [`CHANGELOG.md`](https://github.com/code-corhuila/opti-docs/blob/main/CHANGELOG.md) (previous path → current path + reason) so living-docs checks do not treat the move as a broken folder. Also updated `README.md` (index + mermaid graph), `00-sdd-guide.md`, `06-data/README.md`, and paths inside the section.

### OptiView diagrams in `opti-docs` (`08-diagrams/`)

Adapted the instructor *simple-stock-flow* session (`08-week/02-session/diagramas/`) to OptiView. My four Mermaid sources (commit [`c9bba3f`](https://github.com/code-corhuila/opti-docs/commit/c9bba3f0bc8e8427e0d295f2bdb68eb8e0294235), same PR [`#14`](https://github.com/code-corhuila/opti-docs/pull/14)):

| ID | Source | What it shows |
|----|--------|----------------|
| INFRA-03 | [`flow-arbol-de-trabajo.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/flow-arbol-de-trabajo.mmd) | Planned monorepo tree (`optiview-distributed-system`: services, apps, infra, docs) |
| INFRA-04 | [`c4-estructura-repositorios.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/c4-estructura-repositorios.mmd) | Hexagonal layout of `ms-pacientes` (Java) and `ms-ordenes` (Go) |
| HEX-01 | [`c4-doble-hexagono.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/c4-doble-hexagono.mmd) | `portal-paciente` (React) + `ms-pacientes` touching at one HTTP point |
| DEP-01 | [`flow-regla-dependencia.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/flow-regla-dependencia.mmd) | Inward dependencies (`infrastructure` → `application` → `domain`) + three test layers |

### Mapping to OptiView

| Topic | OptiView application |
|-------|----------------------|
| Distributed Agile | The Illusionists + OptiView collaborators work across `code-corhuila/opti-*` repos — need shared ceremonies, board and Git Flow per service |
| DevOps / CI-CD | Target per `opti-*-api`: build → test → promote `develop` → `qa` → `main`; Compose/IaC owned by `opti-infra` |
| Story mapping | User journey across auth → customers → products → sales (portals + APIs) to prioritize the next evolutionary slice |
| Estimation | Story points / Planning Poker on backlog HUs before coding scaffolds in `opti-customers-*` / `opti-sales-*` |
| MVP commitment | MVP 1 already shipped (`opti-view`); next commitment = thinnest vertical slice on evolutionary repos (not a big-bang rewrite) |
| MoSCoW | Must: gateway + one BC end-to-end; Should: remaining BCs; Won't (this cut): full K8s production orchestration |
| Folder rename | `08-uml/` → `08-diagrams/` so section folders stay English (ADR-001); recorded in CHANGELOG so living-docs does not treat it as a broken path |
| Hexagonal diagrams | Freeze the inward-dependency rule and the portal↔API contact point **before** scaffolding `opti-*-api` / portals |

### Continuity from Weeks 05–07

| Week | What we already have | How Week 08 uses it |
|------|----------------------|---------------------|
| 05 | MVP 1 presented | Baseline for “what an MVP commitment looks like” |
| 06 | Compose, environments, 19-repo layout | Delivery environments for Agile increments |
| 07 | REST/gRPC/messaging + contracts + collaborator access | Team can plan/estimate together on every `opti-*` repo |

## 3. Blockers and risks

- Story map for the next evolutionary MVP cut is documented as practice; a live mapping workshop with the full OptiView team is still pending.
- Estimation method (story points vs T-shirt) not yet ratified team-wide for the `opti-*` backlog.
- CI/CD automation described in DevOps notes is not wired yet on every `opti-*-api` repo.

## 4. Plan for next week

- Run a short story-mapping session for the next OptiView slice (auth → customers → sales).
- Estimate the Must-Have slice and open first scaffold PRs on the chosen `opti-*-api` / portal repos.
- Sketch the first CI pipeline skeleton in `opti-infra` aligned with Git Flow environments.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [ ] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [ ] Tests added/updated (unit / integration)
- [ ] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week 08 is documentation (Agile/DevOps + story mapping / estimation / MVP commitment + `08-uml/` → `08-diagrams/` rename + `opti-docs` diagrams). No application feature code this week — unchecked DDD/tests apply when evolutionary service PRs start. The `opti-docs` work used child branches `docs/rename-08-uml-to-08-diagrams` (PR #14, merged) and `docs/translate-week8-diagrams-to-english` (English follow-up) → PR to `main` (docs-repo rule), not a `hu-xxx-dev` branch on this course fork.

## 6. Evidence links

**Course fork (Week 08 docs):**

- Agile & DevOps notes: [`agile-devops-distributed-teams.md`](./agile-devops-distributed-teams.md)
- Agile & DevOps visual: [`agile-devops-distributed-teams.png`](./agile-devops-distributed-teams.png)
- Story mapping / estimation / MVP notes: [`planning-story-mapping-estimation-mvp-commitment.md`](./planning-story-mapping-estimation-mvp-commitment.md)
- Planning visual: [`planning-story-mapping-estimation-mvp-commitment.png`](./planning-story-mapping-estimation-mvp-commitment.png)

**opti-docs (folder rename + my four diagrams):**

- Rename commit: https://github.com/code-corhuila/opti-docs/commit/1d613d37d7a0cb361fb9b55dfc2680bc56d8b97f
- CHANGELOG (old path → new path): https://github.com/code-corhuila/opti-docs/blob/main/CHANGELOG.md
- Diagrams commit: https://github.com/code-corhuila/opti-docs/commit/c9bba3f0bc8e8427e0d295f2bdb68eb8e0294235
- PR #14 (merged): https://github.com/code-corhuila/opti-docs/pull/14
- English follow-up: https://github.com/code-corhuila/opti-docs/commit/e4305aa (branch [`docs/translate-week8-diagrams-to-english`](https://github.com/code-corhuila/opti-docs/compare/main...docs/translate-week8-diagrams-to-english))
- INFRA-03 work tree: [`flow-arbol-de-trabajo.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/flow-arbol-de-trabajo.mmd)
- INFRA-04 repo structure: [`c4-estructura-repositorios.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/c4-estructura-repositorios.mmd)
- HEX-01 double hexagon: [`c4-doble-hexagono.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/c4-doble-hexagono.mmd)
- DEP-01 dependency rule: [`flow-regla-dependencia.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/flow-regla-dependencia.mmd)

**Related prior work:**

- Week 07 contracts + repo access: [`07-week/hu-status/README.md`](../../07-week/hu-status/README.md)
- Week 06 Compose / environments / repo layout: [`06-week/hu-status/README.md`](../../06-week/hu-status/README.md)
- Org repos: https://github.com/orgs/code-corhuila/repositories?q=opti
- MVP baseline: https://github.com/code-corhuila/opti-view
