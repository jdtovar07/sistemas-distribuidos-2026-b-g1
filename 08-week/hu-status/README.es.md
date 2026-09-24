<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       08-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 08

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Documentar prácticas Agile & DevOps para equipos distribuidos y prácticas de planeación (story mapping, estimación, compromiso MVP); renombrar la sección 08 de opti-docs a 08-diagrams; y agregar cuatro diagramas de arquitectura de OptiView para guiar los siguientes cortes evolutivos después del MVP 1.
<!-- CONFIG-END -->

> **Entrega Semana 08 — planear los siguientes cortes de OptiView.** Después del MVP 1 (Semana 05), bases operativas (Semana 06) y contratos + acceso a repos (Semana 07), esta semana documenta **cómo un equipo distribuido planea y entrega** (Agile + DevOps) y **cómo mapeamos / estimamos / comprometemos el alcance MVP** para los servicios evolutivos `opti-*`, más el **rename `08-uml/` → `08-diagrams/`** y **cuatro diagramas Mermaid** en `code-corhuila/opti-docs` adaptados de la sesión simple-stock-flow del profesor.

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-066 | Documentar Agile & DevOps para equipos distribuidos | done | [`agile-devops-distributed-teams.md`](./agile-devops-distributed-teams.md) |
| HU-OPT-067 | Elaborar resumen visual de Agile & DevOps para equipos distribuidos | done | [`agile-devops-distributed-teams.png`](./agile-devops-distributed-teams.png) |
| HU-OPT-068 | Documentar story mapping, estimación y compromiso MVP | done | [`planning-story-mapping-estimation-mvp-commitment.md`](./planning-story-mapping-estimation-mvp-commitment.md) |
| HU-OPT-069 | Elaborar resumen visual de story mapping / estimación / compromiso MVP | done | [`planning-story-mapping-estimation-mvp-commitment.png`](./planning-story-mapping-estimation-mvp-commitment.png) |
| HU-OPT-070 | Renombrar la carpeta de sección `08-uml/` → `08-diagrams/` en `opti-docs` y registrarlo en CHANGELOG | done | https://github.com/code-corhuila/opti-docs/commit/1d613d37d7a0cb361fb9b55dfc2680bc56d8b97f |
| HU-OPT-071 | Agregar diagrama del árbol de trabajo del monorepo (`flow-arbol-de-trabajo.mmd`) | done | https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/flow-arbol-de-trabajo.mmd |
| HU-OPT-072 | Agregar diagrama hexagonal de repos Java + Go (`c4-estructura-repositorios.mmd`) | done | https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/c4-estructura-repositorios.mmd |
| HU-OPT-073 | Agregar diagrama de doble hexágono portal-paciente + ms-pacientes (`c4-doble-hexagono.mmd`) | done | https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/c4-doble-hexagono.mmd |
| HU-OPT-074 | Agregar diagrama de dependencias inward + capas de test (`flow-regla-dependencia.mmd`) | done | https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/flow-regla-dependencia.mmd |

## 2. Mi contribución individual

> **Alcance esta semana:** documentación Agile / planeación de producto mapeada a OptiView, más diagramas de arquitectura en `opti-docs` — **no** código nuevo de features. Parte del MVP 1 (`opti-view`) y del catálogo evolutivo `code-corhuila/opti-*` (19 repos) con acceso completo de colaboradores desde la Semana 07.

### Notas de estudio y visuales

| Artefacto | Qué cubre |
|-----------|-----------|
| [`agile-devops-distributed-teams.md`](./agile-devops-distributed-teams.md) | Principios Agile para trabajo remoto/distribuido; cultura DevOps; CI/CD; IaC; automatización; observabilidad; estrategias de comunicación multi-ubicación |
| [`agile-devops-distributed-teams.png`](./agile-devops-distributed-teams.png) | Resumen visual de Agile & DevOps para equipos distribuidos |
| [`planning-story-mapping-estimation-mvp-commitment.md`](./planning-story-mapping-estimation-mvp-commitment.md) | Story maps (actividades → tareas → historias); estimación (story points, Fibonacci, T-shirt, Planning Poker); definición y compromiso MVP; MoSCoW; valor vs esfuerzo; planeación de releases |
| [`planning-story-mapping-estimation-mvp-commitment.png`](./planning-story-mapping-estimation-mvp-commitment.png) | Resumen visual de story mapping, estimación y compromiso MVP |

### Rename de carpeta en `opti-docs`

Se renombró la sección **`08-uml/` → `08-diagrams/`** para que la carpeta numerada quede en inglés (ADR-001 / `documentation-rules.md`). Commit [`1d613d3`](https://github.com/code-corhuila/opti-docs/commit/1d613d37d7a0cb361fb9b55dfc2680bc56d8b97f), mergeado a `main` en el PR [`#14`](https://github.com/code-corhuila/opti-docs/pull/14).

| Antes | Después |
|-------|---------|
| `08-uml/` | `08-diagrams/` |

Quedó registrado en [`CHANGELOG.md`](https://github.com/code-corhuila/opti-docs/blob/main/CHANGELOG.md) (ruta anterior → ruta nueva + motivo) para que no lo tomen como carpeta rota. También se actualizaron `README.md` (índice + mermaid), `00-sdd-guide.md`, `06-data/README.md` y las rutas internas de la sección.

### Diagramas OptiView en `opti-docs` (`08-diagrams/`)

Adapté la sesión *simple-stock-flow* del profesor (`08-week/02-session/diagramas/`) a OptiView. Mis cuatro fuentes Mermaid (commit [`c9bba3f`](https://github.com/code-corhuila/opti-docs/commit/c9bba3f0bc8e8427e0d295f2bdb68eb8e0294235), mismo PR [`#14`](https://github.com/code-corhuila/opti-docs/pull/14)):

| ID | Fuente | Qué muestra |
|----|--------|-------------|
| INFRA-03 | [`flow-arbol-de-trabajo.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/flow-arbol-de-trabajo.mmd) | Árbol planeado del monorepo (`optiview-distributed-system`: services, apps, infra, docs) |
| INFRA-04 | [`c4-estructura-repositorios.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/c4-estructura-repositorios.mmd) | Layout hexagonal de `ms-pacientes` (Java) y `ms-ordenes` (Go) |
| HEX-01 | [`c4-doble-hexagono.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/c4-doble-hexagono.mmd) | `portal-paciente` (React) + `ms-pacientes` tocándose en un solo punto HTTP |
| DEP-01 | [`flow-regla-dependencia.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/flow-regla-dependencia.mmd) | Dependencias inward (`infrastructure` → `application` → `domain`) + tres capas de test |

### Mapeo a OptiView

| Tema | Aplicación en OptiView |
|------|------------------------|
| Agile distribuido | The Illusionists + colaboradores OptiView trabajan en repos `code-corhuila/opti-*` — necesitan ceremonias, tablero y Git Flow compartidos por servicio |
| DevOps / CI-CD | Objetivo por `opti-*-api`: build → test → promover `develop` → `qa` → `main`; Compose/IaC a cargo de `opti-infra` |
| Story mapping | Journey del usuario auth → customers → products → sales (portals + APIs) para priorizar el siguiente slice evolutivo |
| Estimación | Story points / Planning Poker sobre HUs del backlog antes de codear scaffolds en `opti-customers-*` / `opti-sales-*` |
| Compromiso MVP | MVP 1 ya entregado (`opti-view`); siguiente compromiso = slice vertical más delgado en repos evolutivos (no rewrite big-bang) |
| MoSCoW | Must: gateway + un BC end-to-end; Should: BCs restantes; Won't (este corte): orquestación K8s completa en producción |
| Rename de carpeta | `08-uml/` → `08-diagrams/` para que las secciones queden en inglés (ADR-001); registrado en CHANGELOG para que living-docs no lo tome como ruta rota |
| Diagramas hexagonales | Congelar la regla de dependencias inward y el punto de contacto portal↔API **antes** de armar scaffolds de `opti-*-api` / portals |

### Continuidad Semanas 05–07

| Semana | Qué ya tenemos | Cómo lo usa la Semana 08 |
|--------|----------------|--------------------------|
| 05 | MVP 1 presentado | Línea base de “cómo se ve un compromiso MVP” |
| 06 | Compose, ambientes, layout 19 repos | Ambientes de entrega para incrementos Agile |
| 07 | REST/gRPC/mensajería + contratos + acceso colaboradores | El equipo puede planear/estimar juntos en cada `opti-*` |

## 3. Bloqueadores y riesgos

- El story map del siguiente corte MVP evolutivo está documentado como práctica; aún falta un taller en vivo con todo el equipo OptiView.
- El método de estimación (story points vs T-shirt) aún no está ratificado por todo el equipo para el backlog `opti-*`.
- La automatización CI/CD descrita en las notas DevOps aún no está cableada en cada `opti-*-api`.

## 4. Plan para la próxima semana

- Hacer una sesión corta de story mapping del siguiente slice OptiView (auth → customers → sales).
- Estimar el slice Must-Have y abrir primeros PRs de scaffold en los `opti-*-api` / portal elegidos.
- Bocetar el primer skeleton de pipeline CI en `opti-infra` alineado con ambientes Git Flow.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [ ] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [ ] Tests agregados/actualizados (unit / integration)
- [ ] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: La Semana 08 es documentación (Agile/DevOps + story mapping / estimación / compromiso MVP + diagramas y rename en `opti-docs`). Sin código de features esta semana — los ítems DDD/tests sin marcar aplican cuando empiecen los PRs de servicios evolutivos. El trabajo en `opti-docs` usó las ramas hijas `docs/rename-08-uml-to-08-diagrams` (PR #14, mergeado) y `docs/translate-week8-diagrams-to-english` (seguimiento en inglés) → PR a `main` (regla del repo de docs), no una rama `hu-xxx-dev` en este fork del curso.

## 6. Enlaces de evidencia

**Fork del curso (docs Semana 08):**

- Notas Agile & DevOps: [`agile-devops-distributed-teams.md`](./agile-devops-distributed-teams.md)
- Visual Agile & DevOps: [`agile-devops-distributed-teams.png`](./agile-devops-distributed-teams.png)
- Notas story mapping / estimación / MVP: [`planning-story-mapping-estimation-mvp-commitment.md`](./planning-story-mapping-estimation-mvp-commitment.md)
- Visual de planeación: [`planning-story-mapping-estimation-mvp-commitment.png`](./planning-story-mapping-estimation-mvp-commitment.png)

**opti-docs (rename de carpeta + mis cuatro diagramas):**

- Commit del rename: https://github.com/code-corhuila/opti-docs/commit/1d613d37d7a0cb361fb9b55dfc2680bc56d8b97f
- CHANGELOG (ruta vieja → ruta nueva): https://github.com/code-corhuila/opti-docs/blob/main/CHANGELOG.md
- Commit de los diagramas: https://github.com/code-corhuila/opti-docs/commit/c9bba3f0bc8e8427e0d295f2bdb68eb8e0294235
- PR #14 (mergeado): https://github.com/code-corhuila/opti-docs/pull/14
- Seguimiento en inglés: https://github.com/code-corhuila/opti-docs/commit/e4305aa (rama [`docs/translate-week8-diagrams-to-english`](https://github.com/code-corhuila/opti-docs/compare/main...docs/translate-week8-diagrams-to-english))
- INFRA-03 árbol de trabajo: [`flow-arbol-de-trabajo.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/flow-arbol-de-trabajo.mmd)
- INFRA-04 estructura de repos: [`c4-estructura-repositorios.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/c4-estructura-repositorios.mmd)
- HEX-01 doble hexágono: [`c4-doble-hexagono.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/c4-doble-hexagono.mmd)
- DEP-01 regla de dependencia: [`flow-regla-dependencia.mmd`](https://github.com/code-corhuila/opti-docs/blob/main/08-diagrams/diagrams/source/flow-regla-dependencia.mmd)

**Trabajo previo relacionado:**

- Contratos + acceso repos (Semana 07): [`07-week/hu-status/README.md`](../../07-week/hu-status/README.md)
- Compose / ambientes / layout repos (Semana 06): [`06-week/hu-status/README.md`](../../06-week/hu-status/README.md)
- Repos de la org: https://github.com/orgs/code-corhuila/repositories?q=opti
- Línea base MVP: https://github.com/code-corhuila/opti-view
