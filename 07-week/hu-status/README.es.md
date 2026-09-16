<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       07-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 07

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Documentar comunicación inter-servicios (REST, gRPC, mensajería) y contratos versionados / contract testing para el camino evolutivo de microservicios de OptiView, y dar Manage access a todos los colaboradores de OptiView (personas + team `@code-corhuila/opti-view`) en los repos creados.
<!-- CONFIG-END -->

> **Entrega Semana 07 — contratos de comunicación + acceso del equipo a los repos evolutivos.** Parte de la Semana 06 (Compose, ambientes, layout de repos). Esta semana documenta **cómo hablarán los servicios** y **cómo evolucionan los contratos con seguridad**, y completa el setup de org **agregando a cada miembro del equipo en todos los repositorios creados**.

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-061 | Documentar comunicación inter-servicios — REST, gRPC y mensajería | done | [`inter-service-communication-rest-grpc-messaging.md`](./inter-service-communication-rest-grpc-messaging.md) |
| HU-OPT-062 | Elaborar resumen visual de REST / gRPC / mensajería | done | [`inter-service-communication-rest-grpc-messaging.png`](./inter-service-communication-rest-grpc-messaging.png) |
| HU-OPT-063 | Documentar contratos versionados y contract testing | done | [`planning-versioned-contracts-contract-testing.md`](./planning-versioned-contracts-contract-testing.md) |
| HU-OPT-064 | Elaborar resumen visual de contratos versionados / contract testing | done | [`planning-versioned-contracts-contract-testing.png`](./planning-versioned-contracts-contract-testing.png) |
| HU-OPT-065 | Agregar a todos los colaboradores de OptiView (personas + team) en los repos evolutivos creados | done | [`repo-collaborators-access.png`](./repo-collaborators-access.png) — Manage access en `code-corhuila/opti-docs` |

## 2. Mi contribución individual

> **Alcance esta semana:** documentación de sistemas distribuidos + acceso GitHub/org para el equipo — **no** código nuevo de features. Continúa el camino evolutivo definido en la Semana 06.

### Notas de estudio y visuales

| Artefacto | Qué cubre |
|-----------|-----------|
| [`inter-service-communication-rest-grpc-messaging.md`](./inter-service-communication-rest-grpc-messaging.md) | Modelos sync vs async; REST (HTTP/JSON); gRPC (Protobuf, streaming); mensajería (brokers, colas/tópicos); cuándo usar cada uno; notas de seguridad y observabilidad |
| [`inter-service-communication-rest-grpc-messaging.png`](./inter-service-communication-rest-grpc-messaging.png) | Resumen visual de REST / gRPC / mensajería |
| [`planning-versioned-contracts-contract-testing.md`](./planning-versioned-contracts-contract-testing.md) | Definición de contrato; estrategias de versionado (URI / header / query / media type); cambios compatibles vs breaking; CDC / provider testing; Pact, Spring Cloud Contract, OpenAPI; integración CI/CD |
| [`planning-versioned-contracts-contract-testing.png`](./planning-versioned-contracts-contract-testing.png) | Resumen visual de contratos versionados y contract testing |

### Mapeo a OptiView (camino evolutivo)

| Tema | Aplicación en OptiView |
|------|------------------------|
| REST | Externo / SPA ↔ `api-gateway` y APIs HTTP públicas (el MVP 1 ya usa REST) |
| gRPC | Candidato para llamadas internas servicio-a-servicio cuando se extraigan los `ms-*` |
| Mensajería | Flujos event-driven (p. ej. Saga de órdenes entre pacientes / inventario / órdenes) — alinea con el diseño Saga de la Semana 01 |
| Contratos versionados | OpenAPI (y luego Protobuf) por servicio en `opti-docs/07-api/` — evolucionar sin romper la SPA ni servicios hermanos |
| Contract testing | Checks CDC / provider antes de promover `develop` → `qa` → `main` en cada `ms-*` |

### Acceso del equipo — todos los colaboradores en los repos creados

En la Semana 06 **definimos** el layout de repositorios evolutivos. Esta semana completé **Manage access** para que **todos los colaboradores de abajo** tengan acceso en los repos creados bajo `code-corhuila` (mismo patrón de acceso aplicado en los repos evolutivos).

Evidencia (captura de Manage access): [`repo-collaborators-access.png`](./repo-collaborators-access.png) — ejemplo de [`code-corhuila/opti-docs`](https://github.com/code-corhuila/opti-docs/settings/access).

| Nombre | GitHub | Acceso |
|--------|--------|--------|
| Juan Diego Tovar Rodriguez | `jdtovar07` | **admin** (realicé / verifiqué las invitaciones) |
| BaironSuarez | `BackSua` | **admin** |
| JDev | `ItzJunixs` | write |
| jssanchezzz | `jssanchezzz` | write (outside collaborator) |
| julianvargasb | `julianvargasb` | write (outside collaborator) |
| ALLAN ZAPATA TORRES | `AllanZapata23` | write (outside collaborator) |
| Daniela Sanabria Mosquera | `DaniKaizenNetwork` | write (outside collaborator) |
| Team `@code-corhuila/opti-view` | team (3 miembros) | **admin** |

**Repositorios cubiertos** (layout evolutivo Semana 06 — ahora con este set de colaboradores):

| Repositorio | Propósito |
|-------------|-----------|
| `opti-docs` | SSOT documental (`code-corhuila/opti-docs`) |
| `optiview-platform` | Línea base MVP 1 (monolito + SPA) |
| `ms-pacientes` | Bounded context Pacientes |
| `ms-inventario` | Bounded context Inventario |
| `ms-ordenes` | Bounded context Órdenes de trabajo |
| `ms-facturacion` | Bounded context Facturación |
| `api-gateway` | Punto de entrada edge para la SPA |

Resultado: todas las personas/team listados pueden contribuir en los repos evolutivos sin esperar grants individuales ad-hoc.

## 3. Bloqueadores y riesgos

- El tooling de contract testing (Pact / Spring Cloud Contract) está documentado pero aún no cableado en CI de los nuevos `ms-*`.
- El estilo de comunicación por frontera (REST vs gRPC vs eventos) aún necesita ADRs por par de servicios antes de codear.
- Los outside collaborators (`AllanZapata23`, `DaniKaizenNetwork`, `jssanchezzz`, `julianvargasb`) deben mantener las invitaciones aceptadas; el team org `@code-corhuila/opti-view` es la vía preferida para acceso admin compartido.

## 4. Plan para la próxima semana

- Publicar primeros stubs OpenAPI (o Proto) del `ms-*` de mayor prioridad y guardarlos en `opti-docs`.
- Armar skeletons de servicio con ramas Git Flow (`develop` / `qa` / `main`) ahora que todos tienen acceso.
- Elegir la primera herramienta de contract testing y agregar un smoke check en PR a `develop`.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [ ] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [ ] Tests agregados/actualizados (unit / integration)
- [ ] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: La Semana 07 es documentación (comunicación + contratos) más setup de colaboradores GitHub en repos evolutivos. Sin código de aplicación esta semana — los ítems sin marcar aplican cuando los `ms-*` empiecen a recibir PRs de implementación. Versionado de contratos y “sin secretos en contratos/docs” están explícitos en las notas de planeación.

## 6. Enlaces de evidencia

**Fork del curso (docs Semana 07):**

- Notas comunicación inter-servicios: [`inter-service-communication-rest-grpc-messaging.md`](./inter-service-communication-rest-grpc-messaging.md)
- Visual de comunicación: [`inter-service-communication-rest-grpc-messaging.png`](./inter-service-communication-rest-grpc-messaging.png)
- Notas contratos versionados / contract testing: [`planning-versioned-contracts-contract-testing.md`](./planning-versioned-contracts-contract-testing.md)
- Visual de contratos: [`planning-versioned-contracts-contract-testing.png`](./planning-versioned-contracts-contract-testing.png)
- Colaboradores del repo (Manage access): [`repo-collaborators-access.png`](./repo-collaborators-access.png)

**Trabajo previo relacionado:**

- Layout de repos + Compose / ambientes (Semana 06): [`06-week/hu-status/README.md`](../../06-week/hu-status/README.md)
- Mapa de dominio (4 microservicios): https://github.com/jdtovar07/opti-docs/blob/main/02-domain/domain-map.md
- Plataforma MVP 1: https://github.com/jdtovar07/optiview-platform (tag `v1.0.0`)
