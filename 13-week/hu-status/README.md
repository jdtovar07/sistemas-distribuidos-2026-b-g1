<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       13-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 13

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document authentication, authorization and Zero Trust for distributed systems; document threat modeling (STRIDE) and the security backlog; and map both to OptiView's JWT gateway choke point, SERVICE_TOKEN for worker/workflow, and post–MVP 2 hardening priorities.
<!-- CONFIG-END -->

> **Week window:** Monday **2026-10-26** → Sunday **2026-11-01** (each course week is Mon–Sun).  
> **Week 13 deliverable:** (1) study notes + visuals on **authn / authz / Zero Trust**, and (2) **threat modeling + security backlog**, mapped onto the shipped OptiView MVP 2 platform.

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-149 | Document security — AuthN, AuthZ and Zero Trust | done | [`security-authn-authz-zero-trust.md`](./security-authn-authz-zero-trust.md) |
| HU-OPT-150 | Produce visual summary of AuthN / AuthZ / Zero Trust | done | [`security-authn-authz-zero-trust-vertical.png`](./security-authn-authz-zero-trust-vertical.png) |
| HU-OPT-151 | Document threat modeling and the security backlog | done | [`threat-modeling-security-backlog.md`](./threat-modeling-security-backlog.md) |
| HU-OPT-152 | Produce visual summary of threat modeling / security backlog | done | [`threat-modeling-security-backlog-vertical.png`](./threat-modeling-security-backlog-vertical.png) |

## 2. My individual contribution

> **Author:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Week 13 scope (Mon–Sun):** security study notes and visuals; OptiView mapping for identity at the edge and threats across trust boundaries.

### Study notes and visuals (this week)

| Artifact | What it covers |
|----------|----------------|
| [`security-authn-authz-zero-trust.md`](./security-authn-authz-zero-trust.md) | AuthN vs AuthZ; JWT / OAuth2 / OIDC; API gateway as choke point; service-to-service trust; Zero Trust; common vulnerability classes |
| [`security-authn-authz-zero-trust-vertical.png`](./security-authn-authz-zero-trust-vertical.png) | Visual summary of those concepts |
| [`threat-modeling-security-backlog.md`](./threat-modeling-security-backlog.md) | Four key questions, DFD / trust boundaries, STRIDE, risk rating, mitigate/eliminate/transfer/accept, security backlog items |
| [`threat-modeling-security-backlog-vertical.png`](./threat-modeling-security-backlog-vertical.png) | Visual summary of threat modeling → backlog |

### OptiView mapping (how Week 13 concepts land on MVP 2)

| Concept | Where it shows up in OptiView |
|---------|-------------------------------|
| AuthN | `opti-auth-api` issues RS256 JWTs; `scripts/dev-keys.sh` / `dev-token.sh` for develop-only identity |
| AuthZ | Roles/claims on the token; portals and APIs expect Bearer auth through the gateway |
| Gateway choke point | `opti-api-gateway` is the only public API entry (besides the front); validates/forwards identity |
| Service-to-service | `SERVICE_TOKEN` for `opti-worker` / `opti-workflow` calling domain APIs — short-lived service identity (develop secrets in `.env`, never committed) |
| Zero Trust (direction) | Do not treat the `platform` Docker network as “safe inside”; every hop should carry verifiable identity (`traceparent` + auth from Week 12 workshop plan) |
| Trust boundaries | Browser → front/gateway; gateway → domain APIs; workflow → customers/products/sales; DBs behind each BC |
| STRIDE samples | Spoofing (stolen JWT); Tampering (saga payload); Repudiation (missing audit); Disclosure (secrets in logs); DoS (gateway flood); EoP (seller → admin) |
| Security backlog (candidates) | Secret store for qa/main; rotate SERVICE_TOKEN; harden CORS/rate limits on gateway; never log tokens; mTLS or tighter service tokens between workflow and APIs |

### Continuity

| Week | What we already have | How Week 13 uses it |
|------|----------------------|---------------------|
| 12 | Cloud/IaC notes + observability workshop on `place-order` | Secure release path + incident runbooks need authZ-aware alerts and least privilege |
| 11 | Observability / SLOs; MVP 2 classroom expo | Golden signals + auth failures as security-relevant SLIs |
| 09–10 | Progressive delivery; MVP 2 tags | Threat model the promote path and public demo surfaces |

### Ceremonies & flow (this week)

| Ceremony | When / evidence |
|----------|-----------------|
| Planning | Mon kickoff: AuthN/AuthZ/Zero Trust + threat modeling notes; map to gateway / JWT / SERVICE_TOKEN (`SPRINT_GOAL`) |
| Daily | Async check-ins: study progress, draft security-backlog candidates for the board |
| Review | Walkthrough OptiView trust boundaries (browser → gateway → APIs → DBs / saga) vs STRIDE |
| Retro | Keep secrets out of git; treat develop keys as non-prod only; next: turn top STRIDE items into board tickets with owners |
| Per-env PRs | Study week — no new product PRs. Carry-forward env evidence from Week 10 seed promotes (products/auth/sales db) |

## 3. Blockers and risks

- Shared **secret store** for qa/main still undecided (`opti-infra`) — highest security backlog item.
- Develop JWT keys / SERVICE_TOKEN live in local `.env` only; process for rotating them in shared envs is undefined.
- Full OAuth2/OIDC IdP is not the current path — custom `opti-auth-api` tokens; migrating to OIDC would be a future ADR.
- Threat model is still **paper + backlog candidates** — not every mitigation is ticketed on the team board yet.

## 4. Plan for next week

- Turn top 3 STRIDE mitigations into board items (secret store, gateway rate limit, no-token-in-logs check).
- Continue workshop → real code: `traceparent` + JSON logs without leaking secrets.
- Optional: document JWT claim / role matrix in `opti-docs`.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [x] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week window is Mon–Sun. Study week on security after the Week 12 workshop/deploy notes. Team uses `feat/*` by agreement; one PR per environment when shipping product. Course-fork HU-status commits on `main`.

## 6. Evidence links

**Course fork (Week 13 docs):**

- [`security-authn-authz-zero-trust.md`](./security-authn-authz-zero-trust.md)
- [`security-authn-authz-zero-trust-vertical.png`](./security-authn-authz-zero-trust-vertical.png)
- [`threat-modeling-security-backlog.md`](./threat-modeling-security-backlog.md)
- [`threat-modeling-security-backlog-vertical.png`](./threat-modeling-security-backlog-vertical.png)

**OptiView identity / edge (shipped platform):**

- https://github.com/code-corhuila/opti-auth-api
- https://github.com/code-corhuila/opti-api-gateway
- https://github.com/code-corhuila/opti-infra (`scripts/dev-keys.sh`, `scripts/dev-token.sh`, `.env` ignored)

**Related prior work:**

- Week 12: [`12-week/hu-status/README.md`](../../12-week/hu-status/README.md) · workshop summary [`resumen-observabilidad.md`](../../12-week/hu-status/resumen-observabilidad.md)
- Week 11: [`11-week/hu-status/README.md`](../../11-week/hu-status/README.md)
- Org repos: https://github.com/orgs/code-corhuila/repositories?q=opti
