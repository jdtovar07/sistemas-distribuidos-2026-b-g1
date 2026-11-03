<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       14-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 14

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document CI/CD pipelines, quality gates and DORA metrics; document Definition of Done as automated gates and branch protection; map both to OptiView Actions CI + GHCR; and late-report the Week 13 threat-modeling workshop + excused work-travel absence that were not fully reflected in the Week 13 HU-status table.
<!-- CONFIG-END -->

> **Week window:** Monday **2026-11-02** → Sunday **2026-11-08** (each course week is Mon–Sun).  
> **Week 14 deliverable:** (1) study notes + visuals on **CI/CD and quality gates**, (2) **DoD-as-gates / branch protection**, and (3) a **late-report** block for Week 13 work (excused absence + threat-modeling workshop) that did not make it clearly into the Week 13 HU-status in time.

## 1. User stories worked this week

### A. This week (Mon 2026-11-02 → Sun 2026-11-08)

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-153 | Document CI/CD — pipelines and quality gates | done | [`cicd-pipelines-quality-gates.md`](./cicd-pipelines-quality-gates.md) |
| HU-OPT-154 | Produce visual summary of CI/CD pipelines / quality gates | done | [`cicd-pipelines-quality-gates-horizontal.png`](./cicd-pipelines-quality-gates-horizontal.png) |
| HU-OPT-155 | Document pipeline design, DoD-as-gates and branch protection | done | [`pipeline-dod-gates-branch-protection.md`](./pipeline-dod-gates-branch-protection.md) |
| HU-OPT-156 | Produce visual summary of DoD gates / branch protection | done | [`pipeline-dod-gates-branch-protection-horizontal.png`](./pipeline-dod-gates-branch-protection-horizontal.png) |

### B. Late-reported from Week 13 (missed / incomplete in Week 13 HU-status)

> **Note:** The following belongs to **Week 13** (Mon 2026-10-26 → Sun 2026-11-01). It is reported here because the Week 13 HU-status did **not** list these items clearly in the HU table / top deliverable (workshop + excused absence). Work and commits themselves are dated **2026-10-30** (inside Week 13). This is **not** new Week 14 product work.

#### Excused absence (permiso) — Week 13

| Item | Detail |
|------|--------|
| Reason | Company work travel outside the city (labor commitments) |
| Dates away | **2026-10-26 → 2026-10-30** |
| Status | Justified to CORHUILA Systems Engineering program (student email 2026-10-26; program reply 2026-10-27 asking faculty to support catch-up in Distributed Systems / Telemática II / degree project) |
| Return | Academic activities resume **2026-11-02** (this Week 14) |
| Catch-up | Threat-modeling workshop completed **2026-10-30** (still inside Week 13 window) |

#### Threat-modeling workshop — Week 13 (catch-up 2026-10-30)

Boundary: **`opti-workflow` → Redis** (saga state store for `place-order`). Claim: [opti-docs #53](https://github.com/code-corhuila/opti-docs/issues/53).

| HU ID | Title | Status | Evidence |
|---|---|---|---|
| HU-OPT-157 | Threat-modeling workshop — attack surface, STRIDE, security stories, CI gates (CP0–CP4) | done | [`13-week/workshop/`](../../13-week/workshop/) · [`33d47c9`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/33d47c9) · [`409ff20`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/409ff20) · [opti-docs PR #54](https://github.com/code-corhuila/opti-docs/pull/54) · issues [#55](https://github.com/code-corhuila/opti-docs/issues/55)/[#56](https://github.com/code-corhuila/opti-docs/issues/56)/[#57](https://github.com/code-corhuila/opti-docs/issues/57) · [`fcca309`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/fcca309) |
| HU-OPT-158 | Threat-modeling workshop — negative authZ test run + reflection (CP8) | done | [`HOW-TO-RUN.md`](../../13-week/workshop/04-security-ci/HOW-TO-RUN.md) · [`78ecb8d`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/78ecb8d) · [`249fa7c`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/249fa7c) · [reflection Doc](https://docs.google.com/document/d/1CpweMfF1q3NIK31v7BaFRtAijCozIFu8sYVDAiC_Xw4/edit?usp=sharing) |

| CP | What | Evidence |
|---|---|---|
| CP0 | Boundary, CONFIG and claim | [`workshop/README.md`](../../13-week/workshop/README.md) · [`33d47c9`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/33d47c9) · [#53](https://github.com/code-corhuila/opti-docs/issues/53) |
| CP1 | Attack surface and trust boundaries | [`01-attack-surface.md`](../../13-week/workshop/01-attack-surface.md) · [`409ff20`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/409ff20) |
| CP2 | STRIDE for the boundary | [opti-docs PR #54](https://github.com/code-corhuila/opti-docs/pull/54) |
| CP3 | Three security backlog stories | [#55](https://github.com/code-corhuila/opti-docs/issues/55) · [#56](https://github.com/code-corhuila/opti-docs/issues/56) · [#57](https://github.com/code-corhuila/opti-docs/issues/57) · [`a9576ec`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/a9576ec) |
| CP4 | Security gates in CI + negative test harness | [`04-security-ci/`](../../13-week/workshop/04-security-ci/) · [`fcca309`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/fcca309) |
| CP8 | Negative test run (real output) | [`HOW-TO-RUN.md`](../../13-week/workshop/04-security-ci/HOW-TO-RUN.md) · [`78ecb8d`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/78ecb8d) |

Local Docker on 2026-10-30: **PASS** with Redis password, **FAIL** without password (recorded in HOW-TO-RUN).

## 2. My individual contribution

> **Author:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Week 14 scope (Mon–Sun):** CI/CD + DoD/branch-protection notes; return to normal attendance after Week 13 excused travel; late-report Week 13 workshop + permiso.

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
| CI on every PR | e.g. [`opti-front` CI](https://github.com/code-corhuila/opti-front/blob/main/.github/workflows/ci.yml): `pull_request` → `develop` / `qa` / `main` — `npm ci` → test → build |
| Package / publish | [`opti-front` Publish](https://github.com/code-corhuila/opti-front/blob/main/.github/workflows/publish.yml): push to **`develop`** → GHCR image |
| Env promotion | One PR per environment after CI green |
| Security gates (from W13 workshop) | Negative Redis authZ test + CI harness under `13-week/workshop/04-security-ci/` — candidates to promote into real `opti-*` required checks |
| DoD ↔ gates | Conventional Commits + review + green CI + no secrets |
| Branch protection (target) | Require PR + status checks on `develop`/`qa`/`main`; block force-push |
| DORA (direction) | Small PRs, short lead time via GHCR + Compose, rollback via SemVer tag |

### Continuity

| Week | What we already have | How Week 14 uses it |
|------|----------------------|---------------------|
| 13 | Security notes + workshop (late-reported here) | Workshop CI/security gates feed this week's DoD-as-gates topic |
| 12 | Cloud/IaC + observability workshop | Pipeline verify → Keep/Rollback |
| 10 | GHCR publish + MVP 2 tags | Concrete CI → package evidence |

### Ceremonies & flow (this week)

| Ceremony | When / evidence |
|----------|-----------------|
| Planning | Mon 2 Nov kickoff (back from excused travel): CI/CD + DoD notes; late-report Week 13 workshop/permiso (`SPRINT_GOAL`) |
| Daily | Async: study progress; inventory which `opti-*` repos have `ci.yml` / `publish.yml` |
| Review | Walkthrough OptiView pipeline: PR checks → merge develop → GHCR → env promote; plus late-report of W13 workshop |
| Retro | Late-report missing HU-status rows the same week when possible; wire workshop Redis/CI gate into real repos next |
| Per-env PRs | Study week — no new product PRs. Carry-forward Week 10 seed promotes as the env-PR pattern CI must protect |

## 3. Blockers and risks

- Branch protection / required checks not uniform across all 19 `opti-*` repos.
- Coverage/SAST not consistently blocking; GHCR often `:latest` only.
- DORA not measured yet (no shared dashboard).
- Week 13 Redis-without-password risk still open until infra harden PR lands (workshop stories #55–#57).

## 4. Plan for next week

- Inventory `ci.yml` / `publish.yml` across `opti-*` and list missing required checks.
- Promote workshop security gate (Redis requirepass / negative test) toward a real `opti-infra` change.
- Candidate: SAST/dependency gate template on one BC.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [x] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

Notes: Week window is Mon–Sun. Section B late-reports Week 13 permiso + workshop that were incomplete in the Week 13 HU-status. Team uses `feat/*` by agreement. Course-fork HU-status on `main`.

## 6. Evidence links

**Course fork (Week 14 docs):**

- [`cicd-pipelines-quality-gates.md`](./cicd-pipelines-quality-gates.md)
- [`cicd-pipelines-quality-gates-horizontal.png`](./cicd-pipelines-quality-gates-horizontal.png)
- [`pipeline-dod-gates-branch-protection.md`](./pipeline-dod-gates-branch-protection.md)
- [`pipeline-dod-gates-branch-protection-horizontal.png`](./pipeline-dod-gates-branch-protection-horizontal.png)

**Late-reported Week 13 (workshop + absence):**

- https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/tree/main/13-week/workshop
- Claim [#53](https://github.com/code-corhuila/opti-docs/issues/53) · STRIDE [PR #54](https://github.com/code-corhuila/opti-docs/pull/54) · stories [#55](https://github.com/code-corhuila/opti-docs/issues/55)–[#57](https://github.com/code-corhuila/opti-docs/issues/57)
- Reflection: https://docs.google.com/document/d/1CpweMfF1q3NIK31v7BaFRtAijCozIFu8sYVDAiC_Xw4/edit?usp=sharing
- Week 13 file: [`13-week/hu-status/README.md`](../../13-week/hu-status/README.md)

**OptiView CI / publish:**

- https://github.com/code-corhuila/opti-front/blob/main/.github/workflows/ci.yml
- https://github.com/code-corhuila/opti-front/blob/main/.github/workflows/publish.yml
