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
- SPRINT_GOAL: Documentar pipelines CI/CD, quality gates y DORA; documentar DoD como gates y branch protection; mapear a Actions/GHCR de OptiView; y reportar tarde el taller de threat modeling de la Semana 13 + la inasistencia justificada (permiso) que no quedaron claros en el HU-status de esa semana.
<!-- CONFIG-END -->

> **Ventana de la semana:** lunes **2026-11-02** → domingo **2026-11-08** (cada semana del curso es lun–dom).  
> **Entrega Semana 14:** (1) notas CI/CD + quality gates, (2) DoD-as-gates / branch protection, y (3) **reporte tardío** de Semana 13 (permiso + taller) que faltó dejar claro en el HU-status de esa semana.

## 1. Historias de usuario trabajadas esta semana

### A. Esta semana (lun 2026-11-02 → dom 2026-11-08)

| HU ID | Título | Estado | Evidencia |
|---|---|---|---|
| HU-OPT-153 | Documentar CI/CD — pipelines y quality gates | done | [`cicd-pipelines-quality-gates.md`](./cicd-pipelines-quality-gates.md) |
| HU-OPT-154 | Resumen visual CI/CD / quality gates | done | [`cicd-pipelines-quality-gates-horizontal.png`](./cicd-pipelines-quality-gates-horizontal.png) |
| HU-OPT-155 | Documentar pipeline, DoD-as-gates y branch protection | done | [`pipeline-dod-gates-branch-protection.md`](./pipeline-dod-gates-branch-protection.md) |
| HU-OPT-156 | Resumen visual DoD gates / branch protection | done | [`pipeline-dod-gates-branch-protection-horizontal.png`](./pipeline-dod-gates-branch-protection-horizontal.png) |

### B. Reporte tardío de Semana 13 (faltó / incompleto en el HU-status de esa semana)

> **Nota:** Pertenece a la **Semana 13** (26 oct → 1 nov). Se reporta aquí porque el HU-status de esa semana **no** dejó claros en la tabla de HUs / entrega el **taller** ni el **permiso**. Los commits del taller son del **2026-10-30** (dentro de Semana 13). **No** es trabajo nuevo de Semana 14.

#### Permiso / inasistencia justificada — Semana 13

| Ítem | Detalle |
|------|---------|
| Motivo | Viaje laboral fuera de la ciudad |
| Fechas | **2026-10-26 → 2026-10-30** |
| Estado | Justificado ante el programa CORHUILA (correo 26 oct; respuesta del programa 27 oct) |
| Retorno | **2026-11-02** (esta Semana 14) |
| Puesta al día | Taller completado el **2026-10-30** (aún Semana 13) |

#### Taller threat modeling — Semana 13

| HU ID | Título | Estado | Evidencia |
|---|---|---|---|
| HU-OPT-157 | Taller — superficie de ataque, STRIDE, historias, gates CI (CP0–CP4) | done | [`13-week/workshop/`](../../13-week/workshop/) · [PR #54](https://github.com/code-corhuila/opti-docs/pull/54) · [#55](https://github.com/code-corhuila/opti-docs/issues/55)–[#57](https://github.com/code-corhuila/opti-docs/issues/57) · [`fcca309`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/fcca309) |
| HU-OPT-158 | Taller — prueba negativa + reflexión (CP8) | done | [`HOW-TO-RUN.md`](../../13-week/workshop/04-security-ci/HOW-TO-RUN.md) · [`78ecb8d`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/78ecb8d) · [Doc reflexión](https://docs.google.com/document/d/1CpweMfF1q3NIK31v7BaFRtAijCozIFu8sYVDAiC_Xw4/edit?usp=sharing) |

## 2. Mi contribución individual

Notas CI/CD de esta semana + retorno a asistencia normal tras el permiso + late-report del taller Semana 13.

### Ceremonias y flujo

| Ceremonia | Cuándo / evidencia |
|-----------|--------------------|
| Planning | Lun 2 nov (regreso): CI/CD + late-report W13 |
| Daily | Async: avance e inventario de workflows |
| Review | Pipeline OptiView + reporte tardío del taller |
| Retro | Reportar a tiempo lo que falte en el HU-status; llevar gate Redis a infra real |
| PRs por ambiente | Semana de estudio |

## 3. Bloqueadores y riesgos

- Branch protection desigual; SAST/coverage no siempre bloqueantes; Redis sin password sigue abierto (historias taller #55–#57).

## 4. Plan para la próxima semana

- Inventario CI/publish; promover gate del taller a `opti-infra`; plantilla SAST en un BC.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [x] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [x] Tests agregados/actualizados (unit / integration)
- [x] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: Sección B solo reporta tarde Semana 13 (permiso + taller). `feat/*` por acuerdo. HU-status en `main`.

## 6. Enlaces de evidencia

- Docs Semana 14 en esta carpeta
- Workshop Semana 13: https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/tree/main/13-week/workshop
- [`13-week/hu-status/README.md`](../../13-week/hu-status/README.md)
