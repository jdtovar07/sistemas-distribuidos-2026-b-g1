<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       03-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 03

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Adapt OptiView governance documents in the opti-docs SSOT repository, and present cumulative Week 01–03 progress — including the initial project idea and PRD — to the professor and the classroom.
<!-- CONFIG-END -->

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-035 | Adapt documentation rules for OptiView in `opti-docs/00-governance/` | done | https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded |
| HU-OPT-036 | Adapt per-microservice documentation standard for OptiView services | done | https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded |
| HU-OPT-037 | Adapt security policy (Keycloak JWT, RBAC, OWASP) for OptiView | done | https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded |
| HU-OPT-038 | Adapt technical security rules (Java + Go controls) for OptiView | done | https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded |
| HU-OPT-039 | Present cumulative Week 01–03 progress and the OptiView PRD to the professor and the classroom | done | [`01-week/hu-status/prd.md`](../../01-week/hu-status/prd.md) |

## 2. My individual contribution

- **Presented to the professor and the classroom** the topics and deliverables accumulated across Weeks 01–03: the initial OptiView project idea and the **product brief / PRD** ([`prd.md`](../../01-week/hu-status/prd.md)) for the Work Orders bounded context (`ms-ordenes`); the Week-01 architectural foundations (bounded context map, Saga for distributed order creation, hexagonal layering sketch, ADR-001 Go vs. Java rationale); the Week-02 Agile and Git Flow practice (Scrum & Kanban brief, sandbox Git Flow evidence, first backlog items HU-01 and HU-02 on The Illusionists board); and the Week-03 governance work in `opti-docs` (documentation rules, microservice documentation standard, security policy and technical security rules).
- Studied the Week-03 session material on the **documentation repository structure** ([`estructura-repositorio-docs.md`](../01-session/estructura-repositorio-docs.md)): numbered folders `00`–`15`, SSOT pattern, per-section READMEs, `_template-*.md` conventions and the governance layer in `00-governance/`.
- Cloned and reviewed the team **`opti-docs`** repository ([`jdtovar07/opti-docs`](https://github.com/jdtovar07/opti-docs)) — the OptiView documentation SSOT, separate from the course fork — and identified the scaffold governance files that still used generic placeholders.
- Authored **`documentation-rules-opti.md`**: language policy (English for code/docs, Spanish for user-facing HU titles and UI labels), kebab-case file naming, owners per section for the 5-member Illusionists team, what to document vs. what not to document, and the update process tied to the Definition of Done.
- Authored **`microservices-documentation-opti.md`**: OptiView service registry with concrete names (`api-gateway`, `ms-pacientes`, `ms-inventario`, `ms-ordenes`, `ms-facturacion`), ports, DB schemas, stack per service (Java 21 + Spring Boot 3 vs. Go 1.22), required per-service documents (README, data-model, events, runbook) and API-first OpenAPI contract rules.
- Authored **`security-policy-opti.md`**: security principles (Defense in Depth, Least Privilege, Zero Trust between microservices), Keycloak + JWT authentication (RS256, 1 h access / 7 d refresh), RBAC roles mapped to real OptiView actors (`RECEPCIONISTA`, `OPTOMETRA`, `VENDEDOR`, `OPERADOR_LABORATORIO`, etc.), permission model `[resource]:[action]`, secret management, input validation, OWASP Top 10 checklist and vulnerability remediation SLAs.
- Authored **`security-rules-opti.md`**: concrete OWASP Top 10 controls with Java (Spring Security, JPA) and Go (HTTP middleware) code examples for OptiView services; JWT verification in the Use Case layer (hexagonal rule); pagination limits; RabbitMQ message schema validation; dependency pinning and security logging requirements.
- Used the **`-opti` suffix** on all four files so the team-adapted documents coexist with the original scaffold templates (`documentation-rules.md`, `microservices-documentation.md`, etc.) without overwriting them.
- Committed the four governance documents to `opti-docs` with Conventional Commits: `docs(governance): add OptiView-specific governance documents` — commit [`38346918c11999439328610c46d826860b489ded`](https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded).

## 3. Blockers and risks

- Week-01 / Week-02 open items still open: stock-reservation timeout for HU-OPT-020; `develop` and `qa` long-lived branches not yet created in the group / OptiView code repository.
- Governance documents are adapted in `opti-docs` but not yet ratified by the full Illusionists team — changes in `00-governance/` require team agreement per the documentation rules themselves.
- Several items marked **⚠️ Pendiente de definición por el equipo** inside the new documents (encryption-at-rest strategy, TLS/CA provider, alerting stack, vulnerability notification channel) — risk of blocking QA deploy criteria until resolved.
- No production code or domain tests yet for `ms-ordenes`; hexagonal boundaries are documented in policy but not yet enforced in code.

## 4. Plan for next week

- Model the tactical DDD layer for `ms-ordenes`: `WorkOrder` aggregate, `OrderState` value object, domain events and state-machine invariants.
- Sketch the hexagonal package structure in Go (`domain` / `application` / `infrastructure`) and define the REST + event contracts for order creation.
- Document data ownership (`orders_schema`) and add the first OpenAPI contract for `ms-ordenes` in `opti-docs/07-api/contracts/openapi/`.
- Implement the `WorkOrder` aggregate with unit tests for illegal state transitions.
- Resolve the stock-reservation timeout with the team and add it as a testable acceptance criterion for HU-OPT-020.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [ ] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [ ] Testable acceptance criteria
- [ ] Tests added/updated (unit / integration)
- [ ] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes on the unchecked items:
- Conventional Commits used in `opti-docs`: `docs(governance): add OptiView-specific governance documents`.
- Work this week was documentation-only in the separate `opti-docs` repo; no HU branch to `develop` in the course fork.
- Acceptance criteria and tests for `ms-ordenes` are planned for Week 04; hexagonal and DDD rules are now written in governance but not yet materialised in Go code.
- No secrets were committed; security policy explicitly forbids credentials in source code, `.env` or logs.

## 6. Evidence links

- Governance commit (4 OptiView documents): https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded
- `opti-docs` repository: https://github.com/jdtovar07/opti-docs
- Adapted files in `00-governance/`:
  - [`documentation-rules-opti.md`](https://github.com/jdtovar07/opti-docs/blob/main/00-governance/documentation-rules-opti.md)
  - [`microservices-documentation-opti.md`](https://github.com/jdtovar07/opti-docs/blob/main/00-governance/microservices-documentation-opti.md)
  - [`security-policy-opti.md`](https://github.com/jdtovar07/opti-docs/blob/main/00-governance/security-policy-opti.md)
  - [`security-rules-opti.md`](https://github.com/jdtovar07/opti-docs/blob/main/00-governance/security-rules-opti.md)
- Week-03 session material (documentation repo structure): [`estructura-repositorio-docs.md`](../01-session/estructura-repositorio-docs.md)
- OptiView product brief / PRD (presented in class): [`01-week/hu-status/prd.md`](../../01-week/hu-status/prd.md)
- Week-01 status and architecture evidence: [`01-week/hu-status/README.md`](../../01-week/hu-status/README.md)
- Week-02 Scrum, Git Flow and backlog evidence: [`02-week/hu-status/README.md`](../../02-week/hu-status/README.md)
- The Illusionists Board: https://github.com/orgs/TheIllusionists/projects/1
