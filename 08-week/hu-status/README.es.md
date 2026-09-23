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
- SPRINT_GOAL: Documentar prácticas Agile & DevOps para equipos distribuidos y prácticas de planeación (story mapping, estimación, compromiso MVP) para guiar los siguientes cortes evolutivos de OptiView después del MVP 1 y el layout de 19 repos bajo code-corhuila.
<!-- CONFIG-END -->

> **Entrega Semana 08 — planear los siguientes cortes de OptiView.** Después del MVP 1 (Semana 05), bases operativas (Semana 06) y contratos + acceso a repos (Semana 07), esta semana documenta **cómo un equipo distribuido planea y entrega** (Agile + DevOps) y **cómo mapeamos / estimamos / comprometemos el alcance MVP** para los servicios evolutivos `opti-*`.

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-066 | Documentar Agile & DevOps para equipos distribuidos | done | [`agile-devops-distributed-teams.md`](./agile-devops-distributed-teams.md) |
| HU-OPT-067 | Elaborar resumen visual de Agile & DevOps para equipos distribuidos | done | [`agile-devops-distributed-teams.png`](./agile-devops-distributed-teams.png) |
| HU-OPT-068 | Documentar story mapping, estimación y compromiso MVP | done | [`planning-story-mapping-estimation-mvp-commitment.md`](./planning-story-mapping-estimation-mvp-commitment.md) |
| HU-OPT-069 | Elaborar resumen visual de story mapping / estimación / compromiso MVP | done | [`planning-story-mapping-estimation-mvp-commitment.png`](./planning-story-mapping-estimation-mvp-commitment.png) |

## 2. Mi contribución individual

> **Alcance esta semana:** documentación Agile / planeación de producto mapeada a OptiView — **no** código nuevo de features. Parte del MVP 1 (`opti-view`) y del catálogo evolutivo `code-corhuila/opti-*` (19 repos) con acceso completo de colaboradores desde la Semana 07.

### Notas de estudio y visuales

| Artefacto | Qué cubre |
|-----------|-----------|
| [`agile-devops-distributed-teams.md`](./agile-devops-distributed-teams.md) | Principios Agile para trabajo remoto/distribuido; cultura DevOps; CI/CD; IaC; automatización; observabilidad; estrategias de comunicación multi-ubicación |
| [`agile-devops-distributed-teams.png`](./agile-devops-distributed-teams.png) | Resumen visual de Agile & DevOps para equipos distribuidos |
| [`planning-story-mapping-estimation-mvp-commitment.md`](./planning-story-mapping-estimation-mvp-commitment.md) | Story maps (actividades → tareas → historias); estimación (story points, Fibonacci, T-shirt, Planning Poker); definición y compromiso MVP; MoSCoW; valor vs esfuerzo; planeación de releases |
| [`planning-story-mapping-estimation-mvp-commitment.png`](./planning-story-mapping-estimation-mvp-commitment.png) | Resumen visual de story mapping, estimación y compromiso MVP |

### Mapeo a OptiView

| Tema | Aplicación en OptiView |
|------|------------------------|
| Agile distribuido | The Illusionists + colaboradores OptiView trabajan en repos `code-corhuila/opti-*` — necesitan ceremonias, tablero y Git Flow compartidos por servicio |
| DevOps / CI-CD | Objetivo por `opti-*-api`: build → test → promover `develop` → `qa` → `main`; Compose/IaC a cargo de `opti-infra` |
| Story mapping | Journey del usuario auth → customers → products → sales (portals + APIs) para priorizar el siguiente slice evolutivo |
| Estimación | Story points / Planning Poker sobre HUs del backlog antes de codear scaffolds en `opti-customers-*` / `opti-sales-*` |
| Compromiso MVP | MVP 1 ya entregado (`opti-view`); siguiente compromiso = slice vertical más delgado en repos evolutivos (no rewrite big-bang) |
| MoSCoW | Must: gateway + un BC end-to-end; Should: BCs restantes; Won't (este corte): orquestación K8s completa en producción |

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

Notas: La Semana 08 es documentación (Agile/DevOps + story mapping / estimación / compromiso MVP). Sin código de aplicación esta semana — los ítems sin marcar aplican cuando empiecen los PRs de servicios evolutivos. Las notas de planeación enfatizan slices MVP pequeños y estimación colaborativa.

## 6. Enlaces de evidencia

**Fork del curso (docs Semana 08):**

- Notas Agile & DevOps: [`agile-devops-distributed-teams.md`](./agile-devops-distributed-teams.md)
- Visual Agile & DevOps: [`agile-devops-distributed-teams.png`](./agile-devops-distributed-teams.png)
- Notas story mapping / estimación / MVP: [`planning-story-mapping-estimation-mvp-commitment.md`](./planning-story-mapping-estimation-mvp-commitment.md)
- Visual de planeación: [`planning-story-mapping-estimation-mvp-commitment.png`](./planning-story-mapping-estimation-mvp-commitment.png)

**Trabajo previo relacionado:**

- Contratos + acceso repos (Semana 07): [`07-week/hu-status/README.md`](../../07-week/hu-status/README.md)
- Compose / ambientes / layout repos (Semana 06): [`06-week/hu-status/README.md`](../../06-week/hu-status/README.md)
- Repos de la org: https://github.com/orgs/code-corhuila/repositories?q=opti
- Línea base MVP: https://github.com/code-corhuila/opti-view
