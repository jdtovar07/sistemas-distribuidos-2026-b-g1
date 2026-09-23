<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       08-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 08

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Document Agile & DevOps practices for distributed teams and planning practices (story mapping, estimation, MVP commitment) to guide OptiView's next evolutionary cuts after MVP 1 and the 19-repo layout under code-corhuila.
<!-- CONFIG-END -->

> **Week 08 deliverable — planning the next OptiView cuts.** After MVP 1 (Week 05), ops foundations (Week 06), and contracts + repo access (Week 07), this week documents **how a distributed team plans and delivers** (Agile + DevOps) and **how we map / estimate / commit MVP scope** for the evolutionary `opti-*` services.

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-OPT-066 | Document Agile & DevOps for distributed teams | done | [`agile-devops-distributed-teams.md`](./agile-devops-distributed-teams.md) |
| HU-OPT-067 | Produce visual summary of Agile & DevOps for distributed teams | done | [`agile-devops-distributed-teams.png`](./agile-devops-distributed-teams.png) |
| HU-OPT-068 | Document story mapping, estimation and MVP commitment | done | [`planning-story-mapping-estimation-mvp-commitment.md`](./planning-story-mapping-estimation-mvp-commitment.md) |
| HU-OPT-069 | Produce visual summary of story mapping / estimation / MVP commitment | done | [`planning-story-mapping-estimation-mvp-commitment.png`](./planning-story-mapping-estimation-mvp-commitment.png) |

## 2. My individual contribution

> **Scope this week:** Agile / product-planning documentation mapped to OptiView — **not** new application feature code. Builds on MVP 1 (`opti-view`) and the evolutionary `code-corhuila/opti-*` catalog (19 repos) with full collaborator access from Week 07.

### Study notes and visuals

| Artifact | What it covers |
|----------|----------------|
| [`agile-devops-distributed-teams.md`](./agile-devops-distributed-teams.md) | Agile principles for remote/distributed work; DevOps culture; CI/CD; IaC; automation; observability; communication strategies for multi-location teams |
| [`agile-devops-distributed-teams.png`](./agile-devops-distributed-teams.png) | Visual summary of Agile & DevOps for distributed teams |
| [`planning-story-mapping-estimation-mvp-commitment.md`](./planning-story-mapping-estimation-mvp-commitment.md) | Story maps (activities → tasks → stories); estimation (story points, Fibonacci, T-shirt, Planning Poker); MVP definition & commitment; MoSCoW; value vs effort; release planning |
| [`planning-story-mapping-estimation-mvp-commitment.png`](./planning-story-mapping-estimation-mvp-commitment.png) | Visual summary of story mapping, estimation and MVP commitment |

### Mapping to OptiView

| Topic | OptiView application |
|-------|----------------------|
| Distributed Agile | The Illusionists + OptiView collaborators work across `code-corhuila/opti-*` repos — need shared ceremonies, board and Git Flow per service |
| DevOps / CI-CD | Target per `opti-*-api`: build → test → promote `develop` → `qa` → `main`; Compose/IaC owned by `opti-infra` |
| Story mapping | User journey across auth → customers → products → sales (portals + APIs) to prioritize the next evolutionary slice |
| Estimation | Story points / Planning Poker on backlog HUs before coding scaffolds in `opti-customers-*` / `opti-sales-*` |
| MVP commitment | MVP 1 already shipped (`opti-view`); next commitment = thinnest vertical slice on evolutionary repos (not a big-bang rewrite) |
| MoSCoW | Must: gateway + one BC end-to-end; Should: remaining BCs; Won't (this cut): full K8s production orchestration |

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

Notes: Week 08 is documentation (Agile/DevOps + story mapping / estimation / MVP commitment). No application code this week — unchecked items apply when evolutionary service PRs start. Planning notes emphasize small MVP slices and collaborative estimation.

## 6. Evidence links

**Course fork (Week 08 docs):**

- Agile & DevOps notes: [`agile-devops-distributed-teams.md`](./agile-devops-distributed-teams.md)
- Agile & DevOps visual: [`agile-devops-distributed-teams.png`](./agile-devops-distributed-teams.png)
- Story mapping / estimation / MVP notes: [`planning-story-mapping-estimation-mvp-commitment.md`](./planning-story-mapping-estimation-mvp-commitment.md)
- Planning visual: [`planning-story-mapping-estimation-mvp-commitment.png`](./planning-story-mapping-estimation-mvp-commitment.png)

**Related prior work:**

- Week 07 contracts + repo access: [`07-week/hu-status/README.md`](../../07-week/hu-status/README.md)
- Week 06 Compose / environments / repo layout: [`06-week/hu-status/README.md`](../../06-week/hu-status/README.md)
- Org repos: https://github.com/orgs/code-corhuila/repositories?q=opti
- MVP baseline: https://github.com/code-corhuila/opti-view
