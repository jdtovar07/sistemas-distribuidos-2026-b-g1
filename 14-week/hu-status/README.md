<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       14-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 14

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document CI/CD pipelines, quality gates and DORA metrics; document Definition of Done as automated gates and branch protection; and map both to OptiView's GitHub Actions CI (PR checks on develop/qa/main) and GHCR publish-on-develop flow after MVP 2.
<!-- CONFIG-END -->

> **Week window:** Monday **2026-11-02** → Sunday **2026-11-08** (each course week is Mon–Sun).  
> **Week 14 deliverable:** (1) study notes + visuals on **CI/CD and quality gates**, and (2) **DoD-as-gates / branch protection**, mapped onto OptiView's multi-repo Actions workflows.

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-153 | Document CI/CD — pipelines and quality gates | done | [`cicd-pipelines-quality-gates.md`](./cicd-pipelines-quality-gates.md) |
| HU-OPT-154 | Produce visual summary of CI/CD pipelines / quality gates | done | [`cicd-pipelines-quality-gates-horizontal.png`](./cicd-pipelines-quality-gates-horizontal.png) |
| HU-OPT-155 | Document pipeline design, DoD-as-gates and branch protection | done | [`pipeline-dod-gates-branch-protection.md`](./pipeline-dod-gates-branch-protection.md) |
| HU-OPT-156 | Produce visual summary of DoD gates / branch protection | done | [`pipeline-dod-gates-branch-protection-horizontal.png`](./pipeline-dod-gates-branch-protection-horizontal.png) |

## 2. My individual contribution

> **Author:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Week 14 scope (Mon–Sun):** CI/CD + DoD/branch-protection study notes and visuals; map to how OptiView already gates PRs and publishes images.

### Study notes and visuals (this week)

| Artifact | What it covers |
|----------|----------------|
| [`cicd-pipelines-quality-gates.md`](./cicd-pipelines-quality-gates.md) | CI vs CD vs Continuous Deployment; pipeline stages; quality gates; trunk-based PR checks; DORA metrics |
| [`cicd-pipelines-quality-gates-horizontal.png`](./cicd-pipelines-quality-gates-horizontal.png) | Visual summary of those concepts |
| [`pipeline-dod-gates-branch-protection.md`](./pipeline-dod-gates-branch-protection.md) | Designing the project pipeline; Definition of Done; DoD → automated gates; branch protection + required status checks |
| [`pipeline-dod-gates-branch-protection-horizontal.png`](./pipeline-dod-gates-branch-protection-horizontal.png) | Visual summary of DoD-as-gates / branch protection |

### OptiView mapping (how Week 14 concepts land on MVP 2)

| Concept | Where it shows up in OptiView |
|---------|-------------------------------|
| CI on every PR | e.g. [`opti-front` CI](https://github.com/code-corhuila/opti-front/blob/main/.github/workflows/ci.yml): `pull_request` → `develop` / `qa` / `main` — `npm ci` → test → build (timeout 10m) |
| Package / CD-ish publish | [`opti-front` Publish](https://github.com/code-corhuila/opti-front/blob/main/.github/workflows/publish.yml): push to **`develop`** → build & push `ghcr.io/code-corhuila/opti-front:latest` (same pattern on portals / workflow / Flyway images from Week 10) |
| Env promotion after CI | Git Flow still requires **one PR per environment** (`develop` → `qa-*` → `release/*` → `main`); CI must be green before merge |
| Quality gates (today) | Build + unit/test + package image; security SAST/coverage thresholds are progressive (security gates sketched in Week 13 workshop) |
| DoD ↔ gates | Conventional Commits + review + green CI + no secrets in repo = mechanical “done” for a slice |
| Branch protection (target) | Require PR + required status checks on `develop`/`qa`/`main`; block force-push — enforce per `opti-*` repo as the team hardens |
| DORA (direction) | Frequent small PRs to `develop`, short lead time via GHCR + Compose, rollback via prior SemVer tag (Week 12) |

### Continuity

| Week | What we already have | How Week 14 uses it |
|------|----------------------|---------------------|
| 13 | AuthN/AuthZ, threat model, security backlog / workshop | Security scans belong as future CI gates |
| 12 | Cloud/IaC + observability workshop | Pipeline verify step feeds Keep/Rollback |
| 10 | GHCR publish + MVP 2 tags | Concrete CI → package evidence already shipping |

### Ceremonies & flow (this week)

| Ceremony | When / evidence |
|----------|-----------------|
| Planning | Mon kickoff: CI/CD + DoD/branch-protection notes; map to Actions CI + GHCR (`SPRINT_GOAL`) |
| Daily | Async: study progress; note which `opti-*` repos already have `ci.yml` / `publish.yml` |
| Review | Walkthrough OptiView pipeline: PR checks → merge develop → GHCR publish → promote via env PRs |
| Retro | Keep CI required before merge; next: align required checks + branch protection across the 19 repos; add SAST/dependency gate where missing |
| Per-env PRs | Study week — no new product PRs. Carry-forward: Week 10 seed promotes (products/auth/sales db) as the env-PR pattern CI must protect |

## 3. Blockers and risks

- Branch protection / required checks are **not uniform** across all 19 `opti-*` repos yet.
- Coverage thresholds and SAST are not consistently wired as blocking gates.
- Publish tags mostly `:latest` on develop — digest/SemVer tagging in GHCR is a hardening item.
- DORA numbers are not measured yet (no shared dashboard); this week documents the metrics.

## 4. Plan for next week

- Inventory `ci.yml` / `publish.yml` across `opti-*` and list missing required checks.
- Candidate: add dependency/SAST gate on at least one BC (auth or sales) as a template.
- Keep security-backlog items from Week 13 moving into real CI gates.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [x] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week window is Mon–Sun. Study week mapping CI/CD onto OptiView Actions + GHCR. Team uses `feat/*` by agreement; one PR per environment when shipping product. Course-fork HU-status commits on `main`.

## 6. Evidence links

**Course fork (Week 14 docs):**

- [`cicd-pipelines-quality-gates.md`](./cicd-pipelines-quality-gates.md)
- [`cicd-pipelines-quality-gates-horizontal.png`](./cicd-pipelines-quality-gates-horizontal.png)
- [`pipeline-dod-gates-branch-protection.md`](./pipeline-dod-gates-branch-protection.md)
- [`pipeline-dod-gates-branch-protection-horizontal.png`](./pipeline-dod-gates-branch-protection-horizontal.png)

**OptiView CI / publish (examples):**

- https://github.com/code-corhuila/opti-front/blob/main/.github/workflows/ci.yml
- https://github.com/code-corhuila/opti-front/blob/main/.github/workflows/publish.yml
- Org: https://github.com/orgs/code-corhuila/repositories?q=opti

**Related prior work:**

- Week 13: [`13-week/hu-status/README.md`](../../13-week/hu-status/README.md)
- Week 12: [`12-week/hu-status/README.md`](../../12-week/hu-status/README.md)
- Week 10 (GHCR slices): [`10-week/hu-status/README.md`](../../10-week/hu-status/README.md)
