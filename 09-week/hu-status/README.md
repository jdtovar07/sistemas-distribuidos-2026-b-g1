<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       09-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 09

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document configuration vs secrets vs feature flags, plan secure configuration plus progressive delivery, and apply the course Project Tracker fixes to the opti-docs 07-api OpenAPI contracts.
<!-- CONFIG-END -->

> **Week 09 deliverable — secure config, safer releases, and contract fixes.** After MVP 1 (Week 05), environment/repo layout (Week 06), contracts + access (Week 07), and Agile/DevOps planning (Week 08), this week documents **how OptiView separates configuration, secrets and feature flags**, **how we plan secure configuration + progressive delivery**, and **the Project Tracker (2026-09-28) fixes** to the `opti-docs` OpenAPI contracts so create-POSTs, money fields and gateway routes match the course audit.

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-075 | Document configuration, secrets and feature flags | done | [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md) |
| HU-OPT-076 | Produce visual summary of configuration, secrets and feature flags | done | [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png) |
| HU-OPT-077 | Document planning for secure configuration and progressive delivery | done | [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md) |
| HU-OPT-078 | Produce visual summary of secure configuration / progressive delivery | done | [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png) |
| HU-OPT-079 | Apply Project Tracker fixes to `opti-docs` 07-api contracts (idempotency, COP cents, missing resources, gateway routes) | done | https://github.com/code-corhuila/opti-docs/commit/184f0e26e4876095a55cf1aa0d87e416e1320f13 |

## 2. My individual contribution

> **Scope this week:** DevOps / delivery documentation mapped to OptiView, plus OpenAPI contract fixes in `opti-docs` — **not** new application feature code. Builds on Week 06 (env vars, no secrets in repo, 19-repo layout), Week 07 (first 07-api contracts) and Week 08 (Git Flow `develop` → `qa` → `main`).

### Study notes and visuals

| Artifact | What it covers |
|----------|----------------|
| [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md) | Configuration (env-specific behavior without code changes); secrets (credentials, keys, tokens — never in git); feature flags (deploy ≠ release: gradual rollout, A/B, instant disable) |
| [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png) | Visual summary: Configure / Protect / Innovate — differences, best practices, recommended architecture |
| [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md) | Secure configuration architecture; progressive delivery (canary, rings, flags); traditional 100% release vs 5% → 25% → 50% → 100% |
| [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png) | Visual summary of secure configuration + progressive delivery planning |

### `opti-docs` 07-api contract fixes (Project Tracker 2026-09-28)

Applied on child branch `docs/fix-api-contracts-week9` → PR to `main` (docs-repo rule; independent of teammate PR #19). Commit [`184f0e2`](https://github.com/code-corhuila/opti-docs/commit/184f0e26e4876095a55cf1aa0d87e416e1320f13), then merged current `main` ([`fae63e4`](https://github.com/code-corhuila/opti-docs/commit/fae63e43e8cc715f7f432bccf6a5e7375cddaa3f)) after #19 landed.

| File | What changed |
|------|----------------|
| [`ms-pacientes.yaml`](https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/contracts/openapi/ms-pacientes.yaml) | Server URL `/v1` (no duplicated `/patients`); `Idempotency-Key` on `POST /patients` |
| [`ms-inventario.yaml`](https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/contracts/openapi/ms-inventario.yaml) | Prices in COP cents (`integer`/`int64`); full `/lenses` resource; idempotency on create POSTs |
| [`ms-ordenes.yaml`](https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/contracts/openapi/ms-ordenes.yaml) | Typed treatments (`OrderTreatmentInput` / `OrderTreatmentResponse`); idempotency on `POST /work-orders` |
| [`ms-facturacion.yaml`](https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/contracts/openapi/ms-facturacion.yaml) | Money fields in cents; `/daily-closings`; idempotency on payments; kept English `CASH` enum from #19 |
| [`_shared.yaml`](https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/contracts/openapi/_shared.yaml) | `ErrorResponse.required` includes `traceId`; reusable `IdempotencyKeyParam` |
| [`api-gateway.yaml`](https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/contracts/openapi/api-gateway.yaml) | Proxy routes `/api/v1/inventory/{id*}`, `/orders/{id*}`, `/billing/{id*}` |
| [`authentication.md`](https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/authentication.md) | Permission examples match real gateway paths; public vs internal path note |

Compare: https://github.com/code-corhuila/opti-docs/compare/main...docs/fix-api-contracts-week9

### Mapping to OptiView

| Topic | OptiView application |
|-------|----------------------|
| Configuration | Per-environment values for each `opti-*-api` / portal (`LOG_LEVEL`, DB host, gateway URLs) via env vars / Compose — same binary, different settings on `develop` / `qa` / `main` |
| Secrets | DB passwords, JWT/Keycloak client secrets, payment-like keys: **not** in git. `.env.example` with keys only; real values from a secret store owned by `opti-infra` (choice still open: Vault / cloud secret manager / Compose secrets) |
| Feature flags | Separate **deploy** from **release** while extracting MVP 1 (`opti-view`) into `opti-customers-*` / `opti-sales-*`: ship code dark, enable per cohort, kill-switch without rollback deploy |
| Progressive delivery | Canary / rings on the Git Flow path: internal → small % on `qa` → 100% on `main`. If a cut misbehaves, disable the flag instead of reverting every `opti-*` repo |
| Least privilege | Each service reads only the secrets of its bounded context (`opti-customers-db` credentials stay out of `opti-sales-api`) |
| Audit | Config and flag changes must be traceable (who enabled `newCheckoutExperience`-style flags on which environment) |
| OpenAPI contracts | Tracker-aligned 07-api: idempotent creates, money in COP cents, `/lenses` + `/daily-closings`, gateway proxies for inventory/orders/billing |

### Continuity from Weeks 05–08

| Week | What we already have | How Week 09 uses it |
|------|----------------------|---------------------|
| 05 | MVP 1 presented | Baseline still running; flags let us extract BCs without a big-bang cutover |
| 06 | Compose, env planning, 19-repo layout, “no secrets in repo” | Week 09 deepens that: config ≠ secrets ≠ flags, and names the progressive-delivery path |
| 07 | First 07-api contracts + collaborator access | Week 09 patches those contracts (idempotency, cents, missing routes) so the next `opti-*-api` scaffolds match the tracker |
| 08 | Agile/DevOps + Git Flow planning | Progressive delivery is how those ceremonies release: small slices, fast rollback via flags |

## 3. Blockers and risks

- Secret-store product for shared environments is still **not chosen** (Week 06 blocker, owned by `opti-infra`). Until then, local Compose + `.env` (gitignored) is the only safe path.
- Feature-flag tool not ratified (env-var flags vs Unleash / LaunchDarkly). Env-var booleans are enough for the first evolutionary slice; a dedicated service is overkill until more than one BC is live.
- Progressive delivery is documented, not wired: no canary pipeline on `opti-*-api` yet.
- Risk: mixing secrets into `application.properties` / committed `.env` as services get scaffolded — needs a review gate (same “no secret defaults” rule as Week 08 session constitution).

## 4. Plan for next week

- Freeze a `.env.example` (keys only, no values) convention for `opti-infra` and the first `opti-*-api` scaffold.
- Pick the first flag for the next OptiView slice (e.g. serve customers from `opti-customers-api` vs `opti-view`) with a documented kill-switch.
- Keep the secret-store decision on the `opti-infra` backlog; do not block the first scaffold on Vault.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [ ] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [ ] Tests added/updated (unit / integration)
- [ ] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week 09 is documentation (configuration / secrets / flags + secure-config and progressive-delivery planning + `opti-docs` 07-api contract fixes). No application feature code this week — unchecked DDD/tests apply when evolutionary service PRs start. Weekly HU-status on this course fork is committed on `main` (same as weeks 06–08), not `hu-xxx-dev` → `develop`. The contract work used child branch `docs/fix-api-contracts-week9` → PR to `main` (docs-repo rule). “No secrets in repo” and env-based configuration are the core of this week’s notes.

## 6. Evidence links

**Course fork (Week 09 docs):**

- Configuration / secrets / flags notes: [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md)
- Configuration / secrets / flags visual: [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png)
- Secure configuration / progressive delivery notes: [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md)
- Planning visual: [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png)

**opti-docs (07-api Project Tracker fixes):**

- Contracts commit: https://github.com/code-corhuila/opti-docs/commit/184f0e26e4876095a55cf1aa0d87e416e1320f13
- Merge of current `main` (after PR #19): https://github.com/code-corhuila/opti-docs/commit/fae63e43e8cc715f7f432bccf6a5e7375cddaa3f
- Branch → `main`: https://github.com/code-corhuila/opti-docs/compare/main...docs/fix-api-contracts-week9
- `ms-pacientes.yaml`: https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/contracts/openapi/ms-pacientes.yaml
- `ms-inventario.yaml`: https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/contracts/openapi/ms-inventario.yaml
- `ms-ordenes.yaml`: https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/contracts/openapi/ms-ordenes.yaml
- `ms-facturacion.yaml`: https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/contracts/openapi/ms-facturacion.yaml
- `_shared.yaml`: https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/contracts/openapi/_shared.yaml
- `api-gateway.yaml`: https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/contracts/openapi/api-gateway.yaml
- `authentication.md`: https://github.com/code-corhuila/opti-docs/blob/docs/fix-api-contracts-week9/07-api/authentication.md

**Related prior work:**

- Week 08 Agile/DevOps + planning: [`08-week/hu-status/README.md`](../../08-week/hu-status/README.md)
- Week 07 contracts + repo access: [`07-week/hu-status/README.md`](../../07-week/hu-status/README.md)
- Week 06 Compose / environments / config: [`06-week/hu-status/README.md`](../../06-week/hu-status/README.md)
- Org repos: https://github.com/orgs/code-corhuila/repositories?q=opti
- MVP baseline: https://github.com/code-corhuila/opti-view
