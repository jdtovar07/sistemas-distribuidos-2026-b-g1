<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       09-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 09

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Documentar configuración vs secretos vs feature flags; planear configuración segura y progressive delivery; corregir contratos 07-api de opti-docs según el Project Tracker; y armar los primeros scaffolds evolutivos opti-* (auth, sales, gateway, front shell, worker, workflow) en develop.
<!-- CONFIG-END -->

> **Entrega Semana 09 — config segura + primeros scaffolds evolutivos.** Después del MVP 1 (Semana 05), layout de 19 repos (Semana 06), contratos + acceso (Semana 07) y planeación Agile/DevOps (Semana 08), esta semana: (1) documenta **configuración / secretos / feature flags** y **progressive delivery**, (2) aplica los arreglos del **Project Tracker (2026-09-28)** en `opti-docs`, y (3) deja en `develop` los **primeros scaffolds hexagonales / Flyway / CI** de auth, sales, api-gateway, front shell, worker y workflow bajo `code-corhuila`.

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-075 | Documentar configuración, secretos y feature flags | done | [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md) |
| HU-OPT-076 | Elaborar resumen visual de configuración, secretos y feature flags | done | [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png) |
| HU-OPT-077 | Documentar planeación de configuración segura y entrega progresiva | done | [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md) |
| HU-OPT-078 | Elaborar resumen visual de configuración segura / entrega progresiva | done | [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png) |
| HU-OPT-079 | Aplicar arreglos del Project Tracker a los contratos 07-api de `opti-docs` | done | https://github.com/code-corhuila/opti-docs/pull/20 |
| HU-OPT-080 | Scaffold de schema + CI Flyway en `opti-auth-db` | done | https://github.com/code-corhuila/opti-auth-db/pull/1 |
| HU-OPT-081 | Scaffold hexagonal + REST + CI en `opti-auth-api` | done | https://github.com/code-corhuila/opti-auth-api/pull/1 |
| HU-OPT-082 | Scaffold de pantallas login / sesión + CI en `opti-auth-portal` | done | https://github.com/code-corhuila/opti-auth-portal/pull/1 |
| HU-OPT-083 | Scaffold de schema + CI Flyway en `opti-sales-db` | done | https://github.com/code-corhuila/opti-sales-db/pull/1 |
| HU-OPT-084 | Scaffold hexagonal + REST + CI en `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/1 |
| HU-OPT-085 | Scaffold de pantallas POS / órdenes + CI en `opti-sales-portal` | done | https://github.com/code-corhuila/opti-sales-portal/pull/1 |
| HU-OPT-086 | Scaffold de routing, JWT y rate limiting en `opti-api-gateway` | done | https://github.com/code-corhuila/opti-api-gateway/pull/1 |
| HU-OPT-087 | Scaffold del shell Module Federation + layout en `opti-front` | done | https://github.com/code-corhuila/opti-front/pull/1 |
| HU-OPT-088 | Scaffold de consumers de eventos y outbox en `opti-worker` | done | https://github.com/code-corhuila/opti-worker/pull/1 |
| HU-OPT-089 | Scaffold del orquestador de saga + Redis en `opti-workflow` | done | https://github.com/code-corhuila/opti-workflow/pull/1 |

## 2. Mi contribución individual

> **Alcance esta semana:** notas de estudio + arreglos de contratos en `opti-docs` **y** primeros PRs de implementación en los repos evolutivos `code-corhuila/opti-*` (Git Flow: `feat/*` → `develop`). Autor: Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).

### Notas de estudio y visuales

| Artefacto | Qué cubre |
|-----------|-----------|
| [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md) | Configuración vs secretos vs feature flags |
| [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png) | Resumen visual: Configure / Protect / Innovate |
| [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md) | Configuración segura + progressive delivery |
| [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png) | Resumen visual de esa planeación |

### Arreglos 07-api en `opti-docs` (Project Tracker 2026-09-28)

PR [`#20`](https://github.com/code-corhuila/opti-docs/pull/20) mergeado a `main` (`ee66ffa`). Commit [`184f0e2`](https://github.com/code-corhuila/opti-docs/commit/184f0e26e4876095a55cf1aa0d87e416e1320f13): idempotency en POSTs de creación, dinero en centavos COP, `/lenses` + `/daily-closings`, proxies del gateway, nota de paths en auth. Independiente del PR #19 del compañero.

### Scaffolds evolutivos en `develop` (mis PRs)

| Área | Repo | PR | Qué entregué |
|------|------|----|--------------|
| Auth BC | `opti-auth-db` | [#1](https://github.com/code-corhuila/opti-auth-db/pull/1) | Schema Flyway, seed, rollback + CI |
| Auth BC | `opti-auth-api` | [#1](https://github.com/code-corhuila/opti-auth-api/pull/1) | Dominio hexagonal / application / REST + CI |
| Auth BC | `opti-auth-portal` | [#1](https://github.com/code-corhuila/opti-auth-portal/pull/1) | Pantallas login + sesión + CI |
| Sales BC | `opti-sales-db` | [#1](https://github.com/code-corhuila/opti-sales-db/pull/1) | Schema Flyway, seed, rollback + CI |
| Sales BC | `opti-sales-api` | [#1](https://github.com/code-corhuila/opti-sales-api/pull/1) | Dominio hexagonal / application / REST + CI |
| Sales BC | `opti-sales-portal` | [#1](https://github.com/code-corhuila/opti-sales-portal/pull/1) | Pantallas POS + órdenes + CI |
| Platform | `opti-api-gateway` | [#1](https://github.com/code-corhuila/opti-api-gateway/pull/1) | Routing, JWT, rate limiting + CI |
| Platform | `opti-front` | [#1](https://github.com/code-corhuila/opti-front/pull/1) | Shell Module Federation, contrato compartido, layout + CI |
| Platform | `opti-worker` | [#1](https://github.com/code-corhuila/opti-worker/pull/1) | Consumers de eventos + outbox + CI |
| Platform | `opti-workflow` | [#1](https://github.com/code-corhuila/opti-workflow/pull/1) | Orquestador de saga + Redis + CI |

### Mapeo a OptiView

| Tema | Aplicación en OptiView |
|------|------------------------|
| Config / secretos / flags | Config por ambiente; sin secretos en git; flags para dark-launch al salir del MVP 1 |
| Progressive delivery | Git Flow `feat` → `develop` → `qa` → `main` |
| Auth BC | Camino de credenciales / sesión para portales y JWT del gateway |
| Sales BC | Slice de work orders / POS tras los contratos |
| Gateway + front | Enrutamiento en el borde + shell MF para enchufar portales |
| Worker + workflow | Async / outbox y saga de place-order |
| OpenAPI | 07-api alineado al Tracker como SSOT de los scaffolds |

### Continuidad Semanas 05–08

| Semana | Qué ya tenemos | Cómo lo usa la Semana 09 |
|--------|----------------|--------------------------|
| 05 | MVP 1 (`opti-view`) | Línea base mientras los repos evolutivos reciben código |
| 06 | Layout 19 repos + Compose | Primeros commits reales en esos repos |
| 07 | Contratos + acceso | Tracker fix + scaffolds consumen esos contratos |
| 08 | Agile/DevOps + Git Flow | Cada scaffold usó `feat/*` → PR → `develop` |

## 3. Bloqueadores y riesgos

- Secret store compartido aún **sin elegir** (`opti-infra`). Compose local + `.env` gitignored sigue siendo el camino seguro.
- BCs customers / products avanzan en PRs de otros — la integración entre BCs aún es delgada.
- Progressive delivery más allá de `develop` (canary en `qa`) aún no cableado.
- Riesgo: drift scaffold vs OpenAPI — `opti-docs` `main` es la SSOT.

## 4. Plan para la próxima semana

- Seguir slices verticales en auth / sales (notificaciones, atribución al vendedor, reportes).
- Alinear rutas del gateway con recursos nuevos (`/lenses`, `/notifications`).
- Mantener convención `.env.example` (solo claves) en `opti-*-api` / `opti-infra`.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [x] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [x] Tests agregados/actualizados (unit / integration)
- [x] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: Las notas de estudio + PR #20 de `opti-docs` son documentación. El trabajo evolutivo usó `feat/*` → PR → `develop` en cada `opti-*`. Hexagonal + CI con tests en auth-api / sales-api / worker / workflow / gateway. El HU-status del fork del curso se sigue commiteando en `main`.

## 6. Enlaces de evidencia

**Fork del curso (docs Semana 09):**

- [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md)
- [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png)
- [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md)
- [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png)

**opti-docs:**

- PR #20 (mergeado): https://github.com/code-corhuila/opti-docs/pull/20
- Commit de contratos: https://github.com/code-corhuila/opti-docs/commit/184f0e26e4876095a55cf1aa0d87e416e1320f13
- Tip de `main` con #20: https://github.com/code-corhuila/opti-docs/commit/ee66ffa

**Scaffolds code-corhuila (mis PRs → `develop`):**

- Auth: https://github.com/code-corhuila/opti-auth-db/pull/1 · https://github.com/code-corhuila/opti-auth-api/pull/1 · https://github.com/code-corhuila/opti-auth-portal/pull/1
- Sales: https://github.com/code-corhuila/opti-sales-db/pull/1 · https://github.com/code-corhuila/opti-sales-api/pull/1 · https://github.com/code-corhuila/opti-sales-portal/pull/1
- Platform: https://github.com/code-corhuila/opti-api-gateway/pull/1 · https://github.com/code-corhuila/opti-front/pull/1 · https://github.com/code-corhuila/opti-worker/pull/1 · https://github.com/code-corhuila/opti-workflow/pull/1

**Trabajo previo relacionado:**

- Semana 08: [`08-week/hu-status/README.md`](../../08-week/hu-status/README.md)
- Semana 07: [`07-week/hu-status/README.md`](../../07-week/hu-status/README.md)
- Semana 06: [`06-week/hu-status/README.md`](../../06-week/hu-status/README.md)
- Repos org: https://github.com/orgs/code-corhuila/repositories?q=opti
- MVP: https://github.com/code-corhuila/opti-view
