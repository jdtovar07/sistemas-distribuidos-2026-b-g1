<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       12-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 12

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document cloud deployment models and zero-downtime strategies (rolling / blue-green / canary); document the deployment plan, Infrastructure as Code and rollback loop; and map both to OptiView's Git Flow (develop → qa → release → main), GHCR images, Flyway rollbacks and SemVer tags after MVP 2.
<!-- CONFIG-END -->

> **Week window:** Monday **2026-10-19** → Sunday **2026-10-25** (each course week is Mon–Sun).  
> **Week 12 deliverable:** (1) study notes + visuals on **cloud deployment** and **deployment plan / IaC / rollback**, and (2) OptiView mapping onto the shipped MVP 2 multi-repo release path.

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-143 | Document cloud deployment — models, strategies and zero-downtime | done | [`cloud-deployment-models-strategies.md`](./cloud-deployment-models-strategies.md) |
| HU-OPT-144 | Produce visual summary of cloud deployment models / strategies | done | [`cloud-deployment-models-strategies-vertical.png`](./cloud-deployment-models-strategies-vertical.png) |
| HU-OPT-145 | Document deployment plan, Infrastructure as Code and rollback | done | [`deployment-plan-iac-rollback.md`](./deployment-plan-iac-rollback.md) |
| HU-OPT-146 | Produce visual summary of deployment plan / IaC / rollback | done | [`deployment-plan-iac-rollback-vertical.png`](./deployment-plan-iac-rollback-vertical.png) |

## 2. My individual contribution

> **Author:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Week 12 scope (Mon–Sun):** cloud deployment + IaC/rollback study notes and visuals, mapped to how OptiView already ships MVP 2.

### Study notes and visuals (this week)

| Artifact | What it covers |
|----------|----------------|
| [`cloud-deployment-models-strategies.md`](./cloud-deployment-models-strategies.md) | IaaS / PaaS / containers / serverless; registry → orchestrator → LB → health checks; rolling / blue-green / canary; horizontal / autoscaling |
| [`cloud-deployment-models-strategies-vertical.png`](./cloud-deployment-models-strategies-vertical.png) | Visual summary of those concepts |
| [`deployment-plan-iac-rollback.md`](./deployment-plan-iac-rollback.md) | Written deployment plan, declarative IaC, pre-deploy checklist, rollback triggers, Plan → Provision → Deploy → Verify → Keep/Rollback |
| [`deployment-plan-iac-rollback-vertical.png`](./deployment-plan-iac-rollback-vertical.png) | Visual summary of the safe-release loop |

### OptiView mapping (how Week 12 concepts land on MVP 2)

| Concept | Where it shows up in OptiView |
|---------|-------------------------------|
| Containers + registry | Each `opti-*` service builds a Docker image; CI publishes to **GHCR** on push to `develop` (portals / front / workflow / Flyway images) |
| Local “compose as platform” | `opti-infra` `include`s sibling `deploy/compose.yml` files on the shared `platform` network — local analogue of orchestrated containers |
| Env promotion (safe path) | Git Flow: `feat/*` → `develop` → `qa-*` → `release/x.y.z` → `main` with **one PR per environment** |
| Progressive / canary-minded delivery | Week 09 notes + `opti-docs` progressive-delivery framing; rings/flags before full cutover |
| Versioned artifacts | SemVer tags `v2.0.0` (all 19 repos) and `v2.1.0` (post-seed tips on products/auth/sales db + docs) |
| Reversible DB changes | Flyway `V*` forward + `U*` rollbacks under `05_rollbacks/` (e.g. demo seeds) |
| Rollback trigger (practice) | Failed health / smoke after promote → redeploy previous tag or revert the env PR; keep `develop`/`qa`/`main` from drifting |
| Observability during release | `otel-collector` / Prometheus / Grafana already composed in `opti-infra` (Week 11) to verify a cut |

### Continuity

| Week | What we already have | How Week 12 uses it |
|------|----------------------|---------------------|
| 11 | Observability + SLI/SLO framing; MVP 2 classroom expo | Release verification / rollback decisions use those signals |
| 10 | MVP 2 tagged; seeds via `release/2.1.0` → main | Concrete example of a planned, versioned, multi-repo cut |
| 09 | Progressive delivery + first scaffolds | Strategy vocabulary (canary / rings) meets real Git Flow path |

### Ceremonies & flow (this week)

| Ceremony | When / evidence |
|----------|-----------------|
| Planning | Mon kickoff: cloud deployment + IaC/rollback notes; map to OptiView Git Flow / GHCR / Flyway (`SPRINT_GOAL`) |
| Daily | Async check-ins: blockers on docs, align naming of release tags vs env PRs |
| Review | Walkthrough of deployment strategies vs how we promote OptiView (develop → qa → main) + tag evidence |
| Retro | Keep one PR per environment; always ship with a prior SemVer tag reachable for rollback; next: write a short runbook for `opti-infra` promote/rollback |
| Per-env PRs | Study week — no new product PRs. Carry-forward evidence: products-db [#13](https://github.com/code-corhuila/opti-products-db/pull/13)/[#14](https://github.com/code-corhuila/opti-products-db/pull/14)/[#15](https://github.com/code-corhuila/opti-products-db/pull/15); auth-db [#10](https://github.com/code-corhuila/opti-auth-db/pull/10)–[#12](https://github.com/code-corhuila/opti-auth-db/pull/12); sales-db [#10](https://github.com/code-corhuila/opti-sales-db/pull/10)–[#12](https://github.com/code-corhuila/opti-sales-db/pull/12) |

## 3. Blockers and risks

- Shared cloud target (managed K8s vs PaaS) is not yet a team ADR — local Compose + GHCR is the current path.
- Secret store for qa/main still undecided (`opti-infra`).
- Full blue-green/canary in a managed cluster is planned vocabulary; today promotion is **env branches + tags**, not dual live clusters.
- Flyway undo scripts exist for seeds; not every historical migration has a paired `U*` yet.

## 4. Plan for next week

- Draft a one-page OptiView **promote / rollback runbook** (order: dbs → apis → portals → front/gateway).
- Candidate: document GHCR image digests + tag → env mapping in `opti-docs`.
- Continue OTel emission / concrete SLOs from Week 11 plan if capacity allows.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [x] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week window is Mon–Sun. Study week mapping cloud/IaC concepts onto the shipped MVP 2 path. Team uses `feat/*` (not `hu-xxx-dev`) by agreement; one PR per environment when shipping product changes. Course-fork HU-status commits on `main`.

## 6. Evidence links

**Course fork (Week 12 docs):**

- [`cloud-deployment-models-strategies.md`](./cloud-deployment-models-strategies.md)
- [`cloud-deployment-models-strategies-vertical.png`](./cloud-deployment-models-strategies-vertical.png)
- [`deployment-plan-iac-rollback.md`](./deployment-plan-iac-rollback.md)
- [`deployment-plan-iac-rollback-vertical.png`](./deployment-plan-iac-rollback-vertical.png)

**OptiView release / deploy path (shipped):**

- Tags: https://github.com/code-corhuila/opti-front/releases/tag/v2.0.0 · https://github.com/code-corhuila/opti-products-db/releases/tag/v2.1.0
- Infra compose: https://github.com/code-corhuila/opti-infra
- Progressive delivery / env notes: Week 09 [`planning-secure-configuration-and-progressive-delivery.md`](../../09-week/hu-status/planning-secure-configuration-and-progressive-delivery.md) · [`opti-docs` 10-devops](https://github.com/code-corhuila/opti-docs/tree/main/10-devops)

**Related prior work:**

- Week 11: [`11-week/hu-status/README.md`](../../11-week/hu-status/README.md)
- Week 10: [`10-week/hu-status/README.md`](../../10-week/hu-status/README.md)
- Org repos: https://github.com/orgs/code-corhuila/repositories?q=opti
