<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       14-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 14

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Documentar pipelines CI/CD, quality gates y métricas DORA; documentar Definition of Done como gates automatizados y branch protection; y mapear ambos al CI de GitHub Actions de OptiView (checks en develop/qa/main) y al publish a GHCR en develop tras MVP 2.
<!-- CONFIG-END -->

> **Ventana de la semana:** lunes **2026-11-02** → domingo **2026-11-08** (cada semana del curso es lun–dom).  
> **Entrega Semana 14:** (1) notas + visuales de **CI/CD y quality gates**, y (2) **DoD-as-gates / branch protection**, mapeados a los workflows Actions de OptiView.

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-153 | Documentar CI/CD — pipelines y quality gates | done | [`cicd-pipelines-quality-gates.md`](./cicd-pipelines-quality-gates.md) |
| HU-OPT-154 | Elaborar resumen visual de pipelines CI/CD / quality gates | done | [`cicd-pipelines-quality-gates-horizontal.png`](./cicd-pipelines-quality-gates-horizontal.png) |
| HU-OPT-155 | Documentar diseño de pipeline, DoD-as-gates y branch protection | done | [`pipeline-dod-gates-branch-protection.md`](./pipeline-dod-gates-branch-protection.md) |
| HU-OPT-156 | Elaborar resumen visual de DoD gates / branch protection | done | [`pipeline-dod-gates-branch-protection-horizontal.png`](./pipeline-dod-gates-branch-protection-horizontal.png) |

## 2. Mi contribución individual

> **Autor:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Alcance Semana 14:** notas CI/CD + DoD/branch-protection; mapeo a Actions y GHCR de OptiView.

### Notas y visuales

| Artefacto | Qué cubre |
|-----------|-----------|
| [`cicd-pipelines-quality-gates.md`](./cicd-pipelines-quality-gates.md) | CI vs CD; etapas; gates; trunk-based; DORA |
| [`cicd-pipelines-quality-gates-horizontal.png`](./cicd-pipelines-quality-gates-horizontal.png) | Resumen visual |
| [`pipeline-dod-gates-branch-protection.md`](./pipeline-dod-gates-branch-protection.md) | Pipeline del proyecto; DoD; gates; branch protection |
| [`pipeline-dod-gates-branch-protection-horizontal.png`](./pipeline-dod-gates-branch-protection-horizontal.png) | Resumen visual |

### Mapeo a OptiView

| Concepto | Dónde aparece |
|----------|---------------|
| CI en PR | `opti-front` CI en PRs a develop/qa/main (test + build) |
| Publish | push a `develop` → imagen GHCR |
| Promoción | un PR por ambiente tras CI verde |
| DoD | Conventional Commits + review + CI verde + sin secretos |

### Ceremonias y flujo

| Ceremonia | Cuándo / evidencia |
|-----------|--------------------|
| Planning | Kickoff: notas CI/CD + DoD; mapear a Actions/GHCR |
| Daily | Async: avance; inventario de `ci.yml` / `publish.yml` |
| Review | Flujo PR → merge develop → GHCR → promote por ambiente |
| Retro | CI obligatorio antes de merge; siguiente: unificar branch protection + gate SAST |
| PRs por ambiente | Semana de estudio — sin PRs de producto nuevos |

## 3. Bloqueadores y riesgos

- Branch protection desigual entre repos; coverage/SAST no siempre bloqueantes; tags GHCR mayormente `:latest`; DORA aún sin dashboard.

## 4. Plan para la próxima semana

- Inventario de workflows en `opti-*`.
- Plantilla de gate SAST/deps en un BC.
- Seguir llevando el security backlog Semana 13 a gates reales.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [x] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [x] Tests agregados/actualizados (unit / integration)
- [x] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: Ventana lun–dom. `feat/*` por acuerdo. HU-status en `main`.

## 6. Enlaces de evidencia

- Artefactos en esta carpeta
- https://github.com/code-corhuila/opti-front/blob/main/.github/workflows/ci.yml
- https://github.com/code-corhuila/opti-front/blob/main/.github/workflows/publish.yml
- Semana 13: [`13-week/hu-status/README.md`](../../13-week/hu-status/README.md)
