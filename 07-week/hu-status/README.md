<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       07-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 07

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document inter-service communication (REST, gRPC, messaging) and versioned contracts / contract testing for OptiView's evolutionary microservices path, and grant every Illusionists teammate collaborator access on all repos created for the post-MVP 1 layout.
<!-- CONFIG-END -->

> **Week 07 deliverable — communication contracts + team access on evolutionary repos.** Builds on Week 06 (Compose, environments, repo layout). This week documents **how services will talk** and **how contracts evolve safely**, and completes the org setup by **adding every team member to all created repositories**.

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-061 | Document inter-service communication — REST, gRPC and messaging | done | [`inter-service-communication-rest-grpc-messaging.md`](./inter-service-communication-rest-grpc-messaging.md) |
| HU-OPT-062 | Produce visual summary of REST / gRPC / messaging | done | [`inter-service-communication-rest-grpc-messaging.png`](./inter-service-communication-rest-grpc-messaging.png) |
| HU-OPT-063 | Document versioned contracts and contract testing | done | [`planning-versioned-contracts-contract-testing.md`](./planning-versioned-contracts-contract-testing.md) |
| HU-OPT-064 | Produce visual summary of versioned contracts / contract testing | done | [`planning-versioned-contracts-contract-testing.png`](./planning-versioned-contracts-contract-testing.png) |
| HU-OPT-065 | Add every Illusionists teammate as collaborator on all evolutionary repos | done | See §2 — Team access on created repos |

## 2. My individual contribution

> **Scope this week:** distributed-systems documentation + GitHub org/repo access for the team — **not** new application feature code. Continues the evolutionary path defined in Week 06.

### Study notes and visuals

| Artifact | What it covers |
|----------|----------------|
| [`inter-service-communication-rest-grpc-messaging.md`](./inter-service-communication-rest-grpc-messaging.md) | Sync vs async models; REST (HTTP/JSON); gRPC (Protobuf, streaming); messaging (brokers, queues/topics); when to use each; security and observability notes |
| [`inter-service-communication-rest-grpc-messaging.png`](./inter-service-communication-rest-grpc-messaging.png) | Visual summary of REST / gRPC / messaging |
| [`planning-versioned-contracts-contract-testing.md`](./planning-versioned-contracts-contract-testing.md) | Contract definition; versioning strategies (URI / header / query / media type); backward-compatible vs breaking changes; CDC / provider testing; Pact, Spring Cloud Contract, OpenAPI; CI/CD integration |
| [`planning-versioned-contracts-contract-testing.png`](./planning-versioned-contracts-contract-testing.png) | Visual summary of versioned contracts and contract testing |

### Mapping to OptiView (evolutionary path)

| Topic | OptiView application |
|-------|----------------------|
| REST | External / SPA ↔ `api-gateway` and public HTTP APIs (MVP 1 already uses REST) |
| gRPC | Candidate for internal service-to-service calls once `ms-*` are extracted |
| Messaging | Event-driven flows (e.g. order Saga across patients / inventory / orders) — aligns with Week-01 Saga design |
| Versioned contracts | OpenAPI (and later Protobuf) per service in `opti-docs/07-api/` — evolve without breaking the SPA or sibling services |
| Contract testing | CDC / provider checks before promoting `develop` → `qa` → `main` on each `ms-*` |

### Team access — collaborators added to all created repos

In Week 06 we **defined** the evolutionary repository layout. This week I **added each Illusionists teammate** as collaborator on **every created repo**, so the whole team can push, open PRs and follow Git Flow per service.

**Team members granted access** (5-member Illusionists roster):

| GitHub user | Role in access setup |
|-------------|----------------------|
| `jdtovar07` | Owner / admin of the created repos — performed the collaborator invites |
| `BackSua` | Collaborator added to all created repos |
| `ItzJunixs` | Collaborator added to all created repos |
| `jssanchezzz` | Collaborator added to all created repos |
| `julianvargasb` | Collaborator added to all created repos |

**Repositories covered** (evolutionary layout from Week 06 — now with full team access):

| Repository | Purpose |
|------------|---------|
| `optiview-platform` | MVP 1 baseline (monolith + SPA) |
| `opti-docs` | Documentation SSOT |
| `ms-pacientes` | Patients bounded context |
| `ms-inventario` | Inventory bounded context |
| `ms-ordenes` | Work orders bounded context |
| `ms-facturacion` | Billing bounded context |
| `api-gateway` | Edge entry point for the SPA |

Result: any Illusionist can contribute on any evolutionary repo without waiting for individual access grants.

## 3. Blockers and risks

- Contract-testing tooling (Pact / Spring Cloud Contract) is documented but not wired into CI yet on the new `ms-*` repos.
- Communication style per boundary (REST vs gRPC vs events) still needs ADRs per service pair before coding starts.
- Collaborator invites depend on teammates accepting GitHub invitations where required.

## 4. Plan for next week

- Publish first OpenAPI (or Proto) stubs for the highest-priority `ms-*` and store them in `opti-docs`.
- Scaffold service skeletons with Git Flow branches (`develop` / `qa` / `main`) now that everyone has access.
- Decide first contract-testing tool and add a smoke check on PR to `develop`.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [ ] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [ ] Tests added/updated (unit / integration)
- [ ] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week 07 is documentation (communication + contracts) plus GitHub collaborator setup on evolutionary repos. No application code this week — unchecked items apply when `ms-*` start receiving implementation PRs. Contract versioning and “no secrets in contracts/docs” are explicit in the planning notes.

## 6. Evidence links

**Course fork (Week 07 docs):**

- Inter-service communication notes: [`inter-service-communication-rest-grpc-messaging.md`](./inter-service-communication-rest-grpc-messaging.md)
- Communication visual: [`inter-service-communication-rest-grpc-messaging.png`](./inter-service-communication-rest-grpc-messaging.png)
- Versioned contracts / contract testing notes: [`planning-versioned-contracts-contract-testing.md`](./planning-versioned-contracts-contract-testing.md)
- Contracts visual: [`planning-versioned-contracts-contract-testing.png`](./planning-versioned-contracts-contract-testing.png)

**Related prior work:**

- Week 06 repo layout + Compose / environments: [`06-week/hu-status/README.md`](../../06-week/hu-status/README.md)
- Domain map (4 microservices): https://github.com/jdtovar07/opti-docs/blob/main/02-domain/domain-map.md
- MVP 1 platform: https://github.com/jdtovar07/optiview-platform (tag `v1.0.0`)
