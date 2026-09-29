<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       09-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 09

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document configuration vs secrets vs feature flags, and plan secure configuration plus progressive delivery for the evolutionary opti-* services after MVP 1.
<!-- CONFIG-END -->

> **Week 09 deliverable — secure config and safer releases.** After MVP 1 (Week 05), environment/repo layout (Week 06), contracts + access (Week 07), and Agile/DevOps planning (Week 08), this week documents **how OptiView separates configuration, secrets and feature flags**, and **how we plan secure configuration + progressive delivery** so the next `opti-*` cuts can deploy without a big-bang release.

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-075 | Document configuration, secrets and feature flags | done | [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md) |
| HU-OPT-076 | Produce visual summary of configuration, secrets and feature flags | done | [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png) |
| HU-OPT-077 | Document planning for secure configuration and progressive delivery | done | [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md) |
| HU-OPT-078 | Produce visual summary of secure configuration / progressive delivery | done | [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png) |

## 2. My individual contribution

> **Scope this week:** DevOps / delivery documentation mapped to OptiView — **not** new application feature code. Builds on Week 06 (env vars, no secrets in repo, 19-repo layout) and Week 08 (Git Flow `develop` → `qa` → `main`).

### Study notes and visuals

| Artifact | What it covers |
|----------|----------------|
| [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md) | Configuration (env-specific behavior without code changes); secrets (credentials, keys, tokens — never in git); feature flags (deploy ≠ release: gradual rollout, A/B, instant disable) |
| [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png) | Visual summary: Configure / Protect / Innovate — differences, best practices, recommended architecture |
| [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md) | Secure configuration architecture; progressive delivery (canary, rings, flags); traditional 100% release vs 5% → 25% → 50% → 100% |
| [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png) | Visual summary of secure configuration + progressive delivery planning |

### Mapping to OptiView

| Topic | OptiView application |
|-------|----------------------|
| Configuration | Per-environment values for each `opti-*-api` / portal (`LOG_LEVEL`, DB host, gateway URLs) via env vars / Compose — same binary, different settings on `develop` / `qa` / `main` |
| Secrets | DB passwords, JWT/Keycloak client secrets, payment-like keys: **not** in git. `.env.example` with keys only; real values from a secret store owned by `opti-infra` (choice still open: Vault / cloud secret manager / Compose secrets) |
| Feature flags | Separate **deploy** from **release** while extracting MVP 1 (`opti-view`) into `opti-customers-*` / `opti-sales-*`: ship code dark, enable per cohort, kill-switch without rollback deploy |
| Progressive delivery | Canary / rings on the Git Flow path: internal → small % on `qa` → 100% on `main`. If a cut misbehaves, disable the flag instead of reverting every `opti-*` repo |
| Least privilege | Each service reads only the secrets of its bounded context (`opti-customers-db` credentials stay out of `opti-sales-api`) |
| Audit | Config and flag changes must be traceable (who enabled `newCheckoutExperience`-style flags on which environment) |

### Continuity from Weeks 05–08

| Week | What we already have | How Week 09 uses it |
|------|----------------------|---------------------|
| 05 | MVP 1 presented | Baseline still running; flags let us extract BCs without a big-bang cutover |
| 06 | Compose, env planning, 19-repo layout, “no secrets in repo” | Week 09 deepens that: config ≠ secrets ≠ flags, and names the progressive-delivery path |
| 07 | Contracts + collaborator access on every `opti-*` | Team can change config/flags per service without sharing credentials in chat or git |
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

Notes: Week 09 is documentation (configuration / secrets / flags + secure-config and progressive-delivery planning). No application feature code this week — unchecked DDD/tests apply when evolutionary service PRs start. Weekly HU-status on this course fork is committed on `main` (same as weeks 06–08), not `hu-xxx-dev` → `develop`. “No secrets in repo” and env-based configuration are the core of this week’s notes.

## 6. Evidence links

**Course fork (Week 09 docs):**

- Configuration / secrets / flags notes: [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md)
- Configuration / secrets / flags visual: [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png)
- Secure configuration / progressive delivery notes: [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md)
- Planning visual: [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png)

**Related prior work:**

- Week 08 Agile/DevOps + planning: [`08-week/hu-status/README.md`](../../08-week/hu-status/README.md)
- Week 06 Compose / environments / config: [`06-week/hu-status/README.md`](../../06-week/hu-status/README.md)
- Org repos: https://github.com/orgs/code-corhuila/repositories?q=opti
- MVP baseline: https://github.com/code-corhuila/opti-view
