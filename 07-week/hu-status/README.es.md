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
| HU-OPT-065 | Dar Manage access a todos los colaboradores de OptiView en los 19 repos `code-corhuila/opti-*` | done | [`repo-collaborators-access.png`](./repo-collaborators-access.png) + [`opti-repos-page1.png`](./opti-repos-page1.png) · [`page2`](./opti-repos-page2.png) · [`page3`](./opti-repos-page3.png) |

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
| gRPC | Candidato para llamadas internas servicio-a-servicio cuando se extraigan los `opti-*-api` |
| Mensajería | Flujos event-driven vía `opti-workflow` / `opti-worker` (p. ej. Saga de órdenes) — alinea con el diseño Saga de la Semana 01 |
| Contratos versionados | OpenAPI (y luego Protobuf) por BC en `opti-docs` — evolucionar sin romper `opti-front` ni servicios hermanos |
| Contract testing | Checks CDC / provider antes de promover `develop` → `qa` → `main` en cada `opti-*-api` |

### Acceso del equipo — todos los colaboradores en todos los repos `opti-*` creados

En la Semana 06 **definimos/creamos** el layout evolutivo bajo [`code-corhuila`](https://github.com/orgs/code-corhuila/repositories?q=opti). Esta semana completé **Manage access** para que **todos los colaboradores de abajo** tengan acceso en **los 19 repositorios `opti-*`**.

Evidencia:

- Manage access (ejemplo `opti-docs`): [`repo-collaborators-access.png`](./repo-collaborators-access.png)
- Listado de repos de la org (`q=opti`, 19 repos): [`opti-repos-page1.png`](./opti-repos-page1.png) · [`opti-repos-page2.png`](./opti-repos-page2.png) · [`opti-repos-page3.png`](./opti-repos-page3.png)

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

**Todos los repositorios con acceso otorgado** (`code-corhuila`, privados):

| Área | Repositorios |
|------|--------------|
| MVP / docs | `opti-view`, `opti-docs` |
| Plataforma | `opti-front`, `opti-api-gateway`, `opti-infra`, `opti-workflow`, `opti-worker` |
| Auth | `opti-auth-api`, `opti-auth-db`, `opti-auth-portal` |
| Customers | `opti-customers-api`, `opti-customers-db`, `opti-customers-portal` |
| Products | `opti-products-api`, `opti-products-db`, `opti-products-portal` |
| Sales | `opti-sales-api`, `opti-sales-db`, `opti-sales-portal` |

**Total: 19 repos** — todas las personas/team listados pueden contribuir en cada `opti-*` sin grants ad-hoc.

## 3. Bloqueadores y riesgos

- El tooling de contract testing (Pact / Spring Cloud Contract) está documentado pero aún no cableado en CI de los nuevos `opti-*-api`.
- El estilo de comunicación por frontera (REST vs gRPC vs eventos) aún necesita ADRs por par de servicios antes de codear.
- Los outside collaborators (`AllanZapata23`, `DaniKaizenNetwork`, `jssanchezzz`, `julianvargasb`) deben mantener las invitaciones aceptadas; el team org `@code-corhuila/opti-view` es la vía preferida para acceso admin compartido.

## 4. Plan para la próxima semana

- Publicar primeros stubs OpenAPI (o Proto) del BC de mayor prioridad (`opti-customers-*` / `opti-sales-*`) y guardarlos en `opti-docs`.
- Armar skeletons de servicio con ramas Git Flow (`develop` / `qa` / `main`) ahora que todos tienen acceso en los 19 repos.
- Elegir la primera herramienta de contract testing y agregar un smoke check en PR a `develop`.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [ ] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [ ] Tests agregados/actualizados (unit / integration)
- [ ] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: La Semana 07 es documentación (comunicación + contratos) más setup de colaboradores GitHub en todos los repos `code-corhuila/opti-*`. Sin código de aplicación esta semana — los ítems sin marcar aplican cuando los `opti-*-api` empiecen a recibir PRs de implementación. Versionado de contratos y “sin secretos en contratos/docs” están explícitos en las notas de planeación.

## 6. Enlaces de evidencia

**Fork del curso (docs Semana 07):**

- Notas comunicación inter-servicios: [`inter-service-communication-rest-grpc-messaging.md`](./inter-service-communication-rest-grpc-messaging.md)
- Visual de comunicación: [`inter-service-communication-rest-grpc-messaging.png`](./inter-service-communication-rest-grpc-messaging.png)
- Notas contratos versionados / contract testing: [`planning-versioned-contracts-contract-testing.md`](./planning-versioned-contracts-contract-testing.md)
- Visual de contratos: [`planning-versioned-contracts-contract-testing.png`](./planning-versioned-contracts-contract-testing.png)
- Colaboradores del repo (Manage access): [`repo-collaborators-access.png`](./repo-collaborators-access.png)
- Listado repos `opti-*` de la org (19): [`opti-repos-page1.png`](./opti-repos-page1.png) · [`opti-repos-page2.png`](./opti-repos-page2.png) · [`opti-repos-page3.png`](./opti-repos-page3.png)

**Trabajo previo relacionado:**

- Layout de repos + Compose / ambientes (Semana 06): [`06-week/hu-status/README.md`](../../06-week/hu-status/README.md)
- Repos de la org: https://github.com/orgs/code-corhuila/repositories?q=opti
- Mapa de dominio: https://github.com/code-corhuila/opti-docs/blob/main/02-domain/domain-map.md
- Línea base MVP: https://github.com/code-corhuila/opti-view