<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       15-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 15

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document testing at scale and MVP 3 production-grade release; land invoice-PDF / private payment-evidence on `develop` → `qa` → open `release/3.0.0` → `main`; sync opti-board / Opti View backlog.
<!-- CONFIG-END -->

> **Week window:** Monday **2026-11-09** → Sunday **2026-11-15** (each course week is Mon–Sun).  
> **Week 15 deliverable:** (1) testing-at-scale notes, (2) MVP 3 shipping notes, (3) payment PDF slice — **`develop` merged → `qa` merged → `release/3.0.0` PRs open to `main`** (tag `v3.0.0` pending merge).

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-159 | Document testing at scale — contract, E2E, load and chaos | done | notes + board [#72](https://github.com/code-corhuila/opti-docs/issues/72) |
| HU-OPT-160 | Produce visual summary of testing at scale | done | visual + board [#73](https://github.com/code-corhuila/opti-docs/issues/73) |
| HU-OPT-161 | Document shipping MVP 3 — production-grade release | done | notes + board [#74](https://github.com/code-corhuila/opti-docs/issues/74) |
| HU-OPT-162 | Produce visual summary of MVP 3 production-grade release | done | visual + board [#75](https://github.com/code-corhuila/opti-docs/issues/75) |
| HU-OPT-163 | Persist private payment receipts in `opti-sales-db` (V020) | done | [`972c2fe`](https://github.com/code-corhuila/opti-sales-db/commit/972c2fe) · develop [#20](https://github.com/code-corhuila/opti-sales-db/pull/20) · board product [#67](https://github.com/code-corhuila/opti-docs/issues/67) (HU-140) |
| HU-OPT-164 | Invoice PDFs + protected simulated payments in `opti-sales-api` | done | [`04caffd`](https://github.com/code-corhuila/opti-sales-api/commit/04caffd) · develop [#18](https://github.com/code-corhuila/opti-sales-api/pull/18) · board [#65](https://github.com/code-corhuila/opti-docs/issues/65)/[#66](https://github.com/code-corhuila/opti-docs/issues/66) (HU-138/139) |
| HU-OPT-165 | Invoice downloads + payment confirmation in `opti-sales-portal` | done | [`2e161bd`](https://github.com/code-corhuila/opti-sales-portal/commit/2e161bd) · develop [#19](https://github.com/code-corhuila/opti-sales-portal/pull/19) · board [#65](https://github.com/code-corhuila/opti-docs/issues/65)/[#66](https://github.com/code-corhuila/opti-docs/issues/66) |
| HU-OPT-166 | Large private receipt payloads only on payment create (`opti-api-gateway`) | done | [`a2b6e85`](https://github.com/code-corhuila/opti-api-gateway/commit/a2b6e85) · develop [#17](https://github.com/code-corhuila/opti-api-gateway/pull/17) · board [#67](https://github.com/code-corhuila/opti-docs/issues/67) |
| HU-OPT-167 | Authenticated downloads + shell polish in `opti-front` | done | [`d330808`](https://github.com/code-corhuila/opti-front/commit/d330808) · develop [#30](https://github.com/code-corhuila/opti-front/pull/30) · board [#69](https://github.com/code-corhuila/opti-docs/issues/69) (HU-142) |
| HU-OPT-168 | Promote MVP 3 payments/PDF slice to `qa` (cherry-pick per env) | done | qa PRs + board [#76](https://github.com/code-corhuila/opti-docs/issues/76) |
| HU-OPT-169 | Open `release/3.0.0` → `main` for MVP 3 cut | doing | release PRs + board [#77](https://github.com/code-corhuila/opti-docs/issues/77) (In review) |
| HU-OPT-170 | Retire fixed demo credentials (`opti-auth-db` V019) | doing | PR [#19](https://github.com/code-corhuila/opti-auth-db/pull/19) + board [#78](https://github.com/code-corhuila/opti-docs/issues/78) (Blocked/CI) |
| HU-OPT-171 | [backlog] Contract-test plan for place-order + payment PDF | todo | board [#79](https://github.com/code-corhuila/opti-docs/issues/79) |
| HU-OPT-172 | [backlog] E2E smoke: login → place-order → invoice PDF | todo | board [#80](https://github.com/code-corhuila/opti-docs/issues/80) |

## 2. My individual contribution

> **Author:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Week 15 scope:** testing-at-scale + MVP 3 notes; payment PDF / private-evidence vertical slice authored by me; Git Flow promotion through `develop` → `qa`; `release/3.0.0` opened to `main`.

### Vertical slice — Git Flow status (2026-11-10)

Feature commits authored by **Juan Diego Tovar Rodriguez**. PRs opened/merged with team (@BackSua). Teammate-owned companions on products/customers ride the same train.

| Repo | Feature commit (mine) | → `develop` | → `qa` | → `main` (`release/3.0.0`) |
|------|----------------------|-------------|--------|----------------------------|
| `opti-sales-db` | [`972c2fe`](https://github.com/code-corhuila/opti-sales-db/commit/972c2fe) | [#20](https://github.com/code-corhuila/opti-sales-db/pull/20) [`ee42ba2`](https://github.com/code-corhuila/opti-sales-db/commit/ee42ba2) | [#21](https://github.com/code-corhuila/opti-sales-db/pull/21) [`db95435`](https://github.com/code-corhuila/opti-sales-db/commit/db95435) | [#22](https://github.com/code-corhuila/opti-sales-db/pull/22) **OPEN** |
| `opti-sales-api` | [`04caffd`](https://github.com/code-corhuila/opti-sales-api/commit/04caffd) (+ `b55b726`, `43f8396`) | [#18](https://github.com/code-corhuila/opti-sales-api/pull/18) [`402a4ad`](https://github.com/code-corhuila/opti-sales-api/commit/402a4ad) | [#19](https://github.com/code-corhuila/opti-sales-api/pull/19) [`535ced6`](https://github.com/code-corhuila/opti-sales-api/commit/535ced6) | [#20](https://github.com/code-corhuila/opti-sales-api/pull/20) **OPEN** |
| `opti-sales-portal` | [`2e161bd`](https://github.com/code-corhuila/opti-sales-portal/commit/2e161bd) | [#19](https://github.com/code-corhuila/opti-sales-portal/pull/19) [`cae999b`](https://github.com/code-corhuila/opti-sales-portal/commit/cae999b) | [#20](https://github.com/code-corhuila/opti-sales-portal/pull/20) [`3c74aff`](https://github.com/code-corhuila/opti-sales-portal/commit/3c74aff) | [#21](https://github.com/code-corhuila/opti-sales-portal/pull/21) **OPEN** |
| `opti-api-gateway` | [`a2b6e85`](https://github.com/code-corhuila/opti-api-gateway/commit/a2b6e85) | [#17](https://github.com/code-corhuila/opti-api-gateway/pull/17) [`939e0ea`](https://github.com/code-corhuila/opti-api-gateway/commit/939e0ea) | [#18](https://github.com/code-corhuila/opti-api-gateway/pull/18) [`2868d11`](https://github.com/code-corhuila/opti-api-gateway/commit/2868d11) | [#19](https://github.com/code-corhuila/opti-api-gateway/pull/19) **OPEN** |
| `opti-front` | [`d330808`](https://github.com/code-corhuila/opti-front/commit/d330808) | [#30](https://github.com/code-corhuila/opti-front/pull/30) [`4ff44f1`](https://github.com/code-corhuila/opti-front/commit/4ff44f1) | [#31](https://github.com/code-corhuila/opti-front/pull/31) [`4da0f05`](https://github.com/code-corhuila/opti-front/commit/4da0f05) | [#32](https://github.com/code-corhuila/opti-front/pull/32) **OPEN** |

**Teammate companions (same MVP 3 train):**

| Repo | → `develop` | → `qa` | → `main` |
|------|-------------|--------|----------|
| `opti-products-api` | [#12](https://github.com/code-corhuila/opti-products-api/pull/12) | [#13](https://github.com/code-corhuila/opti-products-api/pull/13) | [#14](https://github.com/code-corhuila/opti-products-api/pull/14) OPEN |
| `opti-products-portal` | [#12](https://github.com/code-corhuila/opti-products-portal/pull/12) | [#13](https://github.com/code-corhuila/opti-products-portal/pull/13) | [#14](https://github.com/code-corhuila/opti-products-portal/pull/14) OPEN |
| `opti-customers-api` | [#7](https://github.com/code-corhuila/opti-customers-api/pull/7) | [#8](https://github.com/code-corhuila/opti-customers-api/pull/8) | [#9](https://github.com/code-corhuila/opti-customers-api/pull/9) OPEN |
| `opti-customers-portal` | [#12](https://github.com/code-corhuila/opti-customers-portal/pull/12) | [#13](https://github.com/code-corhuila/opti-customers-portal/pull/13) | [#14](https://github.com/code-corhuila/opti-customers-portal/pull/14) OPEN |

### Security follow-up (separate from MVP 3 cut)

| Repo | Commit | PR | Status |
|------|--------|-----|--------|
| `opti-auth-db` | [`764ed45`](https://github.com/code-corhuila/opti-auth-db/commit/764ed45) V019 retire fixed demo hashes | [#19](https://github.com/code-corhuila/opti-auth-db/pull/19) | OPEN (CI rebuild FAILURE) |
| `opti-infra` (teammate) | safe local install docs | [#7](https://github.com/code-corhuila/opti-infra/pull/7) | OPEN — pairs with auth-db V019 |

Left unmerged on purpose for classroom demo (`admin` / `OptiView2026` still works on current `develop` volumes).

### Study notes and visuals (this week)

| Artifact | What it covers |
|----------|----------------|
| [`testing-at-scale-contract-e2e-load-chaos.md`](./testing-at-scale-contract-e2e-load-chaos.md) | Distributed testing pyramid; Pact; E2E; load; chaos |
| [`testing-at-scale-contract-e2e-load-chaos-vertical.png`](./testing-at-scale-contract-e2e-load-chaos-vertical.png) | Visual summary |
| [`release-shipping-mvp3-production-grade.md`](./release-shipping-mvp3-production-grade.md) | Production-grade checklist; MVP 1→2→3; tag → deploy → smoke → keep/rollback |
| [`release-shipping-mvp3-production-grade-vertical.png`](./release-shipping-mvp3-production-grade-vertical.png) | Visual summary |

### OptiView gap map (after this week’s promotion)

| Production-grade item | OptiView status (today) |
|-----------------------|-------------------------|
| Payment / invoice evidence | On **`develop` + `qa`**; `release/3.0.0` PRs open to **`main`** |
| Versioned release | `v2.0.0` / `v2.1.0` exist; **`v3.0.0` tag pending** main merges |
| Unit / CI | Present on several repos |
| Contract / E2E / load / chaos | Documented; not yet blocking gates |
| Observability | Stack in `opti-infra`; SDK progressive |
| Security | JWT + W13 workshop; auth-db #19 open (demo credentials) |

**Critical journey:** login → place-order → payment + invoice PDF (demoed locally from `develop` this week).

### Continuity

| Week | What we already have | How Week 15 uses it |
|------|----------------------|---------------------|
| 14 | CI/CD, DoD-as-gates | Green path for env PRs |
| 13 | AuthN/AuthZ, Redis workshop | Security checklist + auth-db V019 follow-up |
| 11–12 | Observability + rollback | Keep/Rollback language for MVP 3 release notes |
| 10 | MVP 2 `v2.0.0` | Baseline; MVP 3 adds PDF/payments evidence |

### Board & backlog (synced this week)

| Board | URL |
|-------|-----|
| **opti-board** (Kanban) | https://github.com/orgs/code-corhuila/projects/3 |
| **Opti View — Backlog** | https://github.com/orgs/code-corhuila/projects/15 |

Issues live in [`code-corhuila/opti-docs`](https://github.com/code-corhuila/opti-docs/issues) (team SSOT for epics/HUs; `board-sync` workflow moves Status on open/close).

| Board Status | Items (Week 15) |
|--------------|-----------------|
| **Done** | Product slice already on board: [#65](https://github.com/code-corhuila/opti-docs/issues/65)–[#70](https://github.com/code-corhuila/opti-docs/issues/70) (HU-138…143). Study + qa: [#72](https://github.com/code-corhuila/opti-docs/issues/72)–[#76](https://github.com/code-corhuila/opti-docs/issues/76) (HU-159…162, 168). |
| **In review** | [#77](https://github.com/code-corhuila/opti-docs/issues/77) HU-169 — `release/3.0.0` → `main` |
| **In progress / Blocked** | [#78](https://github.com/code-corhuila/opti-docs/issues/78) HU-170 — auth-db V019 (CI red; hold for demo) |
| **Backlog** | [#79](https://github.com/code-corhuila/opti-docs/issues/79) contract-test plan · [#80](https://github.com/code-corhuila/opti-docs/issues/80) E2E smoke · prior security backlog still open (e.g. Redis [#55](https://github.com/code-corhuila/opti-docs/issues/55)–[#57](https://github.com/code-corhuila/opti-docs/issues/57), Wompi [#61](https://github.com/code-corhuila/opti-docs/issues/61)–[#63](https://github.com/code-corhuila/opti-docs/issues/63)) |

Mapping note: fork HUs **163–167** are the personal evidence of commits that implement board product HUs **138–142** (same vertical slice).

### Ceremonies & flow (this week)

| Ceremony | When / evidence |
|----------|-----------------|
| Planning | Mon: testing-at-scale + MVP 3 notes; pull PDF slice + Git Flow onto board/backlog |
| Daily | Async: develop → qa → open `release/3.0.0`; sync card Status on opti-board / Opti View backlog |
| Review | Live demo from `develop`; qa ready; board shows Done vs In review |
| Retro | Slice on develop+qa; main/tag open on board (#77); contracts/E2E parked as backlog (#79/#80) |
| Per-env PRs | feat→develop **done** · qa-* **done** · release/3.0.0→main **open** |
| Board sync | Created/closed Week 15 issues on `opti-docs`; Status set on [projects/3](https://github.com/orgs/code-corhuila/projects/3) + [projects/15](https://github.com/orgs/code-corhuila/projects/15) |

## 3. Blockers and risks

- **`release/3.0.0` → `main` still OPEN** across the train — no `v3.0.0` tag until merges land (needs `ariel5253` approval on `main` per policy).
- `opti-auth-db` #19 CI `rebuild` FAILURE — security hardening blocked independently of MVP 3.
- Contract tests / automated E2E / load baseline still missing for a fully production-grade claim.
- Secret store / Redis requirepass and uneven branch protection remain backlog.

## 4. Plan for next week

- Merge `release/3.0.0` PRs to `main` and cut SemVer **`v3.0.0`** (+ zips if required).
- Fix CI on auth-db #19 (and infra #7) after demo window — or keep demo seeds until classroom closes.
- Draft minimal contract-test + one E2E smoke for login → place-order → invoice PDF.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (feat→develop, qa-*, release→main)
- [x] Testable acceptance criteria
- [x] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week window Mon–Sun. Cherry-pick promotion (`-x`) used for qa/release per team Git Flow. Course-fork HU-status commits on `main`.

## 6. Evidence links

**Course fork (Week 15 docs):**

- [`testing-at-scale-contract-e2e-load-chaos.md`](./testing-at-scale-contract-e2e-load-chaos.md)
- [`testing-at-scale-contract-e2e-load-chaos-vertical.png`](./testing-at-scale-contract-e2e-load-chaos-vertical.png)
- [`release-shipping-mvp3-production-grade.md`](./release-shipping-mvp3-production-grade.md)
- [`release-shipping-mvp3-production-grade-vertical.png`](./release-shipping-mvp3-production-grade-vertical.png)

**My commits → `develop` (merged 2026-11-10):**

- https://github.com/code-corhuila/opti-sales-db/pull/20
- https://github.com/code-corhuila/opti-sales-api/pull/18
- https://github.com/code-corhuila/opti-sales-portal/pull/19
- https://github.com/code-corhuila/opti-api-gateway/pull/17
- https://github.com/code-corhuila/opti-front/pull/30

**Promote → `qa` (merged 2026-11-10):**

- https://github.com/code-corhuila/opti-sales-db/pull/21
- https://github.com/code-corhuila/opti-sales-api/pull/19
- https://github.com/code-corhuila/opti-sales-portal/pull/20
- https://github.com/code-corhuila/opti-api-gateway/pull/18
- https://github.com/code-corhuila/opti-front/pull/31

**`release/3.0.0` → `main` (OPEN):**

- https://github.com/code-corhuila/opti-sales-db/pull/22
- https://github.com/code-corhuila/opti-sales-api/pull/20
- https://github.com/code-corhuila/opti-sales-portal/pull/21
- https://github.com/code-corhuila/opti-api-gateway/pull/19
- https://github.com/code-corhuila/opti-front/pull/32

**Security follow-up (OPEN):**

- https://github.com/code-corhuila/opti-auth-db/pull/19
- https://github.com/code-corhuila/opti-infra/pull/7

**Board / backlog (Week 15 cards):**

- Boards: https://github.com/orgs/code-corhuila/projects/3 · https://github.com/orgs/code-corhuila/projects/15
- Done: https://github.com/code-corhuila/opti-docs/issues/72 … https://github.com/code-corhuila/opti-docs/issues/76 (+ product [#65](https://github.com/code-corhuila/opti-docs/issues/65)–[#70](https://github.com/code-corhuila/opti-docs/issues/70))
- In review: https://github.com/code-corhuila/opti-docs/issues/77
- Blocked: https://github.com/code-corhuila/opti-docs/issues/78
- Backlog: https://github.com/code-corhuila/opti-docs/issues/79 · https://github.com/code-corhuila/opti-docs/issues/80

**Prior baseline:**

- MVP 2 tag: https://github.com/code-corhuila/opti-front/releases/tag/v2.0.0
- W13 workshop: [`13-week/workshop/`](../../13-week/workshop/)
- W14 CI/DoD: [`14-week/hu-status/README.md`](../../14-week/hu-status/README.md)
