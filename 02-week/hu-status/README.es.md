<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       02-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 02

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Documentar Scrum y Kanban, practicar Git Flow en un repo sandbox, e iniciar el product backlog de OptiView en el tablero de The Illusionists con historias verificables (HU-01, HU-02).
<!-- CONFIG-END -->

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-010 | Documentar formas de trabajo Scrum y Kanban para The Illusionists | done | [`Scrum-Kanbam-JD.md`](./Scrum-Kanbam-JD.md) |
| HU-OPT-011 | Producir un resumen visual (infografía) de Scrum vs Kanban | done | [`Scrum&Kanbam.png`](./Scrum&Kanbam.png) |
| HU-OPT-012 | Practicar Git Flow en un repo sandbox (feature → dev vía PR) | done | https://github.com/jdtovar07/test_distributed_systems/pull/1 |
| HU-OPT-013 | Documentar la práctica de Git Flow y mapearla al flujo del curso | done | [`git-flow.md`](./git-flow.md) |
| HU-OPT-014 | Documentar el flujo completo de ambientes (dev → qa → main + hotfix) en `dev` | done | https://github.com/jdtovar07/test_distributed_systems/pull/2 |
| HU-OPT-015 | Promover `dev` → `qa` en el sandbox (PR de ambiente) | done | https://github.com/jdtovar07/test_distributed_systems/pull/4 |
| HU-OPT-016 | Promover `qa` → `main` en el sandbox (PR de producción) | done | https://github.com/jdtovar07/test_distributed_systems/pull/5 |
| HU-OPT-017 | Practicar el flujo hotfix (`hotfix/*` → `main`) en el sandbox | done | https://github.com/jdtovar07/test_distributed_systems/pull/6 |
| HU-OPT-018 | Propagar hotfix `main` → `qa` | done | https://github.com/jdtovar07/test_distributed_systems/pull/7 |
| HU-OPT-019 | Propagar hotfix `main` → `dev` | done | https://github.com/jdtovar07/test_distributed_systems/pull/8 |
| HU-OPT-030 | Producir un resumen visual del Git Flow practicado en el sandbox | done | [`GitFlow.png`](./GitFlow.png) |
| HU-OPT-031 | Crear HU-01 (Registrar paciente) en el tablero del equipo | done | https://github.com/jdtovar07/jdtovar07/issues/1 |
| HU-OPT-032 | Crear HU-02 (Registrar fórmula óptica) en el tablero del equipo | done | https://github.com/jdtovar07/jdtovar07/issues/2 |
| HU-OPT-033 | Documentar la evidencia del backlog / tablero Kanban de The Illusionists | done | [`board-backlog.md`](./board-backlog.md) |
| HU-OPT-034 | Practicar cierre de release clásico (`release/*` → `main`) | done | https://github.com/jdtovar07/test_distributed_systems/pull/9 |

## 2. Mi contribución individual

- Escribí el brief de formas de trabajo ágiles (`Scrum-Kanbam-JD.md`): principios del Manifiesto Ágil, Scrum (roles, eventos, artefactos, ciclo de Sprint, velocidad / burndown) y Kanban (límites WIP, tablero, lead time / cycle time / throughput).
- Elaboré una tabla comparativa Scrum vs Kanban (estructura, roles, reuniones, política de cambio, uso ideal) y una recomendación breve para enseñar / aplicar ambas en un equipo de software.
- Creé el resumen visual [`Scrum&Kanbam.png`](./Scrum&Kanbam.png) como evidencia de sesión de la Semana 02.
- Vinculé el material a OptiView / The Illusionists: Scrum para entrega por Sprint de historias de `ms-ordenes`; principios Kanban (visualizar el trabajo, limitar WIP) para el flujo diario en el tablero.
- Configuré el repo sandbox [`jdtovar07/test_distributed_systems`](https://github.com/jdtovar07/test_distributed_systems) con ramas longevas `main`, `dev` y `qa`.
- Ejecuté el primer paso de Git Flow: rama `feature/documentar-feature-flow` desde `dev`, documenté el flujo feature en el README del sandbox con Conventional Commits, abrí y **mergeé el PR #1** hacia `dev`.
- Ejecuté el segundo paso: rama `docs/documentar-flujo-ambientes`, documenté las promociones `dev` → `qa` → `main` y el hotfix, abrí y **mergeé el PR #2** hacia `dev`.
- Ejecuté la primera promoción real de ambiente: abrí y **mergeé el PR #4** (`dev` → `qa`). Cerré el PR #3 sin merge tras apuntar por error a `main`.
- Completé la cadena hasta producción: abrí y **mergeé el PR #5** (`qa` → `main`) — Feature → `dev` → `qa` → `main` quedó practicado en el sandbox.
- Practiqué el camino hotfix: rama `hotfix/documentar-hotfix` desde `main`, documenté la propagación, abrí y **mergeé el PR #6** hacia `main`.
- Propagué el hotfix a QA: abrí y **mergeé el PR #7** (`main` → `qa`).
- Cerré el loop del hotfix hacia desarrollo: abrí y **mergeé el PR #8** (`main` → `dev`) — `main`, `qa` y `dev` quedaron alineados.
- Practiqué el cierre de release clásico de Git Flow: rama `release/1.0.0`, documenté el flujo de release, abrí y **mergeé el PR #9** hacia `main`.
- Creé el resumen visual de Git Flow [`GitFlow.png`](./GitFlow.png): Master / Develop / Feature / Release / Hotfix con tags (`v1.0.0`, `v1.0.1`).
- Escribí [`git-flow.md`](./git-flow.md) como entregable de la Semana 02: registra evidencia de PRs #1–#2 y #4–#9 y mapea `dev` → `develop` del curso.
- Creé los primeros ítems del backlog OptiView como Issues de GitHub con criterios de aceptación verificables: [HU-01 — Registrar paciente](https://github.com/jdtovar07/jdtovar07/issues/1) (3 SP) y [HU-02 — Registrar fórmula óptica](https://github.com/jdtovar07/jdtovar07/issues/2) (5 SP), etiquetados para `ms-pacientes` / Fase 1.
- Ubiqué ambas historias en [The illusionists Board](https://github.com/orgs/TheIllusionists/projects/1) en **To Do** (visibles en Backlog y Kanban); documenté la evidencia en [`board-backlog.md`](./board-backlog.md) con capturas.

## 3. Bloqueos y riesgos

- Ítems abiertos de la Semana 01 en el repo **grupal**: timeout de reserva de stock para HU-OPT-020; el flujo HU + PR por ambiente está demostrado en el sandbox pero aún no aplicado al repositorio de OptiView / grupo.
- El sandbox usa el nombre de rama `dev` en lugar de `develop` del curso — documentado como alias en [`git-flow.md`](./git-flow.md); riesgo de confusión si el equipo copia el nombre corto al repo grupal.
- Las primeras HUs del tablero son de `ms-pacientes`; las historias de `ms-ordenes` aún no están en el board.

## 4. Plan para la próxima semana

- Aplicar el mismo Git Flow en el repo grupal / OptiView (`develop`, `qa`, `main` + ramas `hu-opt-xxx-*`).
- Agregar HUs de `ms-ordenes` al tablero de The Illusionists con criterios de aceptación verificables.
- Resolver con el equipo el timeout de reserva de stock (bloquea el criterio de aceptación de HU-OPT-020).

## 5. Autoevaluación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [x] Rama HU + PR por entorno (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [ ] Pruebas agregadas o actualizadas (unitarias / integración)
- [ ] Límites DDD / hexagonal respetados (el dominio no tiene I/O)
- [x] Sin secretos; configuración por variables de entorno

Notas sobre los ítems sin marcar:
- Se usaron Conventional Commits en los PRs del sandbox (`docs(...)`, `chore(...)`, `fix(hotfix): ...`, `fix(qa): ...`, `fix(dev): ...`, `docs(release): ...`).
- Flujo completo del sandbox: Feature → `dev` → `qa` → `main` + loop de hotfix + cierre de release (PRs #1–#2, #4–#9).
- Criterios de aceptación verificables: escritos en [HU-01](https://github.com/jdtovar07/jdtovar07/issues/1) y [HU-02](https://github.com/jdtovar07/jdtovar07/issues/2); implementación/pruebas aún pendientes.
- Aún no hay código de producción ni pruebas de dominio esta semana — el foco fue WoW ágil + Git Flow + backlog en el tablero.

## 6. Enlaces de evidencia

- Brief Scrum & Kanban: [`Scrum-Kanbam-JD.md`](./Scrum-Kanbam-JD.md)
- Infografía: [`Scrum&Kanbam.png`](./Scrum&Kanbam.png)
- Práctica de Git Flow: [`git-flow.md`](./git-flow.md)
- Infografía Git Flow: [`GitFlow.png`](./GitFlow.png)
- Documentación del tablero / backlog: [`board-backlog.md`](./board-backlog.md)
- The Illusionists Board: https://github.com/orgs/TheIllusionists/projects/1
- HU-01 — Registrar paciente: https://github.com/jdtovar07/jdtovar07/issues/1
- HU-02 — Registrar fórmula óptica: https://github.com/jdtovar07/jdtovar07/issues/2
- Repo sandbox: https://github.com/jdtovar07/test_distributed_systems
- PR #1 — feature → `dev` (merged): https://github.com/jdtovar07/test_distributed_systems/pull/1
- PR #2 — documentar `dev` → `qa` → `main` + hotfix en `dev` (merged): https://github.com/jdtovar07/test_distributed_systems/pull/2
- PR #4 — promover `dev` → `qa` (merged): https://github.com/jdtovar07/test_distributed_systems/pull/4
- PR #5 — promover `qa` → `main` (merged): https://github.com/jdtovar07/test_distributed_systems/pull/5
- PR #6 — hotfix → `main` (merged): https://github.com/jdtovar07/test_distributed_systems/pull/6
- PR #7 — sync hotfix `main` → `qa` (merged): https://github.com/jdtovar07/test_distributed_systems/pull/7
- PR #8 — sync hotfix `main` → `dev` (merged): https://github.com/jdtovar07/test_distributed_systems/pull/8
- PR #9 — release/`1.0.0` → `main` (merged): https://github.com/jdtovar07/test_distributed_systems/pull/9

![Resumen Scrum y Kanban — Semana 02](./Scrum&Kanbam.png)

![Git Flow — Master, Develop, Feature, Release, Hotfix](./GitFlow.png)

![The Illusionists Board — Backlog](./board-backlog.png)

![The Illusionists Board — Kanban](./board-kanban.png)
