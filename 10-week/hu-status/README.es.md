<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       10-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 10

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Documentar patrones de persistencia (saga, outbox, CQRS) y prácticas de release de MVP 2; y aterrizar slices verticales sobre los scaffolds de la Semana 09 — notificaciones, atribución al vendedor, reportes de ventas, rutas del gateway, polish del front, alertas del worker e identidad en la saga — hacia un release integrado de OptiView.
<!-- CONFIG-END -->

> **Entrega Semana 10 — patrones de persistencia + slices verticales hacia MVP 2.** Tras los scaffolds de la Semana 09 (auth / sales / gateway / front / worker / workflow), esta semana: (1) documenta **database-per-service, saga, outbox, CQRS y consistencia eventual**, (2) documenta **cómo shipping MVP 2 como sistema integrado**, y (3) implementa los primeros **slices cross-service** en `develop` que ejercitan esos patrones.

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-090 | Documentar persistencia en sistemas distribuidos (saga, outbox, CQRS) | done | [`persistence-saga-outbox-cqrs.md`](./persistence-saga-outbox-cqrs.md) |
| HU-OPT-091 | Elaborar resumen visual de saga / outbox / CQRS | done | [`persistence-saga-outbox-cqrs.png`](./persistence-saga-outbox-cqrs.png) |
| HU-OPT-092 | Documentar prácticas de release para shipping MVP 2 | done | [`release-shipping-mvp-2.md`](./release-shipping-mvp-2.md) |
| HU-OPT-093 | Elaborar resumen visual del release MVP 2 | done | [`release-shipping-mvp-2.png`](./release-shipping-mvp-2.png) |
| HU-OPT-094 | Schema de sales-goal + notificaciones en `opti-auth-db` | done | https://github.com/code-corhuila/opti-auth-db/pull/4 |
| HU-OPT-095 | Notificaciones + metas de vendedor en `opti-auth-api` | done | https://github.com/code-corhuila/opti-auth-api/pull/2 |
| HU-OPT-096 | Agregar `seller_id` a work orders en `opti-sales-db` | done | https://github.com/code-corhuila/opti-sales-db/pull/4 |
| HU-OPT-097 | Agregar `gateway_transaction_id` a payments en `opti-sales-db` | done | https://github.com/code-corhuila/opti-sales-db/pull/5 |
| HU-OPT-098 | Atribuir work orders al vendedor + reportes de ingresos en `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/2 |
| HU-OPT-099 | Reporte seller-sales solo SERVICE en `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/4 |
| HU-OPT-100 | Rutar `/api/v1/lenses` a products-api en `opti-api-gateway` | done | https://github.com/code-corhuila/opti-api-gateway/pull/3 |
| HU-OPT-101 | Rutar `/api/v1/notifications` a auth-api en `opti-api-gateway` | done | https://github.com/code-corhuila/opti-api-gateway/pull/5 |
| HU-OPT-102 | Rehacer shell de `opti-front` con sidebar + topbar | done | https://github.com/code-corhuila/opti-front/pull/3 |
| HU-OPT-103 | Login split-screen según mockup en `opti-front` | done | https://github.com/code-corhuila/opti-front/pull/4 |
| HU-OPT-104 | Notificar al vendedor al alcanzar meta en `opti-worker` | done | https://github.com/code-corhuila/opti-worker/pull/2 |
| HU-OPT-105 | Llevar identidad del caller en la saga place-order en `opti-workflow` | done | https://github.com/code-corhuila/opti-workflow/pull/2 |
| HU-OPT-106 | Email opcional de usuario (auth-db + auth-api) | done | https://github.com/code-corhuila/opti-auth-db/pull/6 · https://github.com/code-corhuila/opti-auth-api/pull/4 |
| HU-OPT-107 | Validación de nombre solo letras en `opti-auth-api` | done | https://github.com/code-corhuila/opti-auth-api/pull/3 |
| HU-OPT-108 | Rutar pagos Nequi por Wompi en `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/5 |
| HU-OPT-109 | Polish del shell front (FormData, CSS avatar/tabs, iconos sidebar) | done | https://github.com/code-corhuila/opti-front/pull/10 · [#8](https://github.com/code-corhuila/opti-front/pull/8) |

## 2. Mi contribución individual

> **Alcance esta semana:** notas de estudio sobre persistencia + release, **y** primeros slices verticales sobre los scaffolds de la Semana 09 (Git Flow: `feat/*` → `develop`). Autor: Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).

### Notas de estudio y visuales

| Artefacto | Qué cubre |
|-----------|-----------|
| [`persistence-saga-outbox-cqrs.md`](./persistence-saga-outbox-cqrs.md) | Database-per-service, saga, outbox, CQRS, consistencia eventual |
| [`persistence-saga-outbox-cqrs.png`](./persistence-saga-outbox-cqrs.png) | Resumen visual de esos cinco conceptos |
| [`release-shipping-mvp-2.md`](./release-shipping-mvp-2.md) | Release, MVP, sistema integrado, pasos y buenas prácticas |
| [`release-shipping-mvp-2.png`](./release-shipping-mvp-2.png) | Resumen visual de shipping MVP 2 |

### Slices verticales que ejercitan los patrones

| Patrón (Sesión 1) | Cómo lo apliqué en OptiView |
|-------------------|-----------------------------|
| Database-per-service | Schema auth de metas/notificaciones (`opti-auth-db` #4); schema sales de `seller_id` / gateway tx (`opti-sales-db` #4/#5) |
| Saga | `opti-workflow` #2 lleva la identidad del caller en place-order |
| Outbox / async | `opti-worker` #2 notifica cuando el vendedor alcanza su meta |
| Lecturas tipo CQRS | Reportes en `opti-sales-api` #2/#4; gateway expone `/notifications` y `/lenses` (#5/#3) |
| Release integrado (Sesión 2) | Shell + login (#3/#4), email/nombre y Wompi Nequi para acercar un MVP 2 usable |

### Commits representativos (autoría mía)

- Auth: [`e0883ff`](https://github.com/code-corhuila/opti-auth-db/commit/e0883ff) · [`789b64c`](https://github.com/code-corhuila/opti-auth-api/commit/789b64c) · [`362dce4`](https://github.com/code-corhuila/opti-auth-api/commit/362dce4)
- Sales: [`ac8ce44`](https://github.com/code-corhuila/opti-sales-db/commit/ac8ce44) · [`7c7481a`](https://github.com/code-corhuila/opti-sales-db/commit/7c7481a) · [`be311b9`](https://github.com/code-corhuila/opti-sales-api/commit/be311b9) · [`ee08573`](https://github.com/code-corhuila/opti-sales-api/commit/ee08573) · [`93c2776`](https://github.com/code-corhuila/opti-sales-api/commit/93c2776) · [`8c7708d`](https://github.com/code-corhuila/opti-sales-api/commit/8c7708d)
- Platform: [`4b36f57`](https://github.com/code-corhuila/opti-api-gateway/commit/4b36f57) · [`7bb20c8`](https://github.com/code-corhuila/opti-api-gateway/commit/7bb20c8) · [`7e2fecc`](https://github.com/code-corhuila/opti-front/commit/7e2fecc) · [`3df81a4`](https://github.com/code-corhuila/opti-front/commit/3df81a4) · [`6db0832`](https://github.com/code-corhuila/opti-worker/commit/6db0832) · [`031209a`](https://github.com/code-corhuila/opti-workflow/commit/031209a)

### Continuidad Semanas 05–09

| Semana | Qué ya tenemos | Cómo lo usa la Semana 10 |
|--------|----------------|--------------------------|
| 05 | MVP 1 (`opti-view`) | UX base mientras el front evolutivo avanza |
| 06–07 | Layout 19 repos + contratos | Nuevas rutas detrás del gateway + OpenAPI |
| 08 | Agile/DevOps + Git Flow | Cada slice usó `feat/*` → PR → `develop` |
| 09 | Primeros scaffolds | Esta semana llena esos esqueletos con features reales |

## 3. Bloqueadores y riesgos

- El release “one-click” de MVP 2 aún **no está tageado** — los slices van a `develop`, falta el corte coordinado a `qa`/`main`.
- Customers / products avanzan sobre todo en PRs de otros; la ruta de lenses depende de products-api.
- Secret store compartido sigue sin decidir (`opti-infra`).
- Riesgo: drift de contratos de reportes/notificaciones vs `opti-docs`.

## 4. Plan para la próxima semana

- Promover los slices integrados hacia un candidato MVP 2 (`develop` → smoke en `qa`).
- Cablear UX de portales para notificaciones y reportes de vendedor end to end.
- Ampliar cobertura de saga / outbox (más compensaciones, más consumers).

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [x] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [x] Tests agregados/actualizados (unit / integration)
- [x] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: Las notas de estudio son documentación. El trabajo evolutivo usó `feat/*` → PR → `develop`. Auth-api / sales-api / worker / workflow mantienen hexagonal; Flyway en `*-db`. El HU-status del fork del curso se sigue commiteando en `main`.

## 6. Enlaces de evidencia

**Fork del curso (docs Semana 10):**

- [`persistence-saga-outbox-cqrs.md`](./persistence-saga-outbox-cqrs.md)
- [`persistence-saga-outbox-cqrs.png`](./persistence-saga-outbox-cqrs.png)
- [`release-shipping-mvp-2.md`](./release-shipping-mvp-2.md)
- [`release-shipping-mvp-2.png`](./release-shipping-mvp-2.png)

**Slices auth / sales:**

- https://github.com/code-corhuila/opti-auth-db/pull/4 · https://github.com/code-corhuila/opti-auth-db/pull/6
- https://github.com/code-corhuila/opti-auth-api/pull/2 · https://github.com/code-corhuila/opti-auth-api/pull/3 · https://github.com/code-corhuila/opti-auth-api/pull/4
- https://github.com/code-corhuila/opti-sales-db/pull/4 · https://github.com/code-corhuila/opti-sales-db/pull/5
- https://github.com/code-corhuila/opti-sales-api/pull/2 · https://github.com/code-corhuila/opti-sales-api/pull/4 · https://github.com/code-corhuila/opti-sales-api/pull/5

**Slices de plataforma:**

- https://github.com/code-corhuila/opti-api-gateway/pull/3 · https://github.com/code-corhuila/opti-api-gateway/pull/5
- https://github.com/code-corhuila/opti-front/pull/3 · https://github.com/code-corhuila/opti-front/pull/4 · https://github.com/code-corhuila/opti-front/pull/8 · https://github.com/code-corhuila/opti-front/pull/10
- https://github.com/code-corhuila/opti-worker/pull/2
- https://github.com/code-corhuila/opti-workflow/pull/2

**Trabajo previo relacionado:**

- Semana 09: [`09-week/hu-status/README.md`](../../09-week/hu-status/README.md)
- Semana 08: [`08-week/hu-status/README.md`](../../08-week/hu-status/README.md)
- Repos org: https://github.com/orgs/code-corhuila/repositories?q=opti
- MVP: https://github.com/code-corhuila/opti-view
