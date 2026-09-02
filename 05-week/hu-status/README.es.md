<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       05-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 05

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Conectar la UI Figma de la Semana 04 con la capa de dominio, entregar y presentar OptiView Platform MVP 1 como monolito modular (HU-01, HU-05, HU-08), y documentar la ruta de monolito hacia los cuatro microservicios objetivo en opti-docs.
<!-- CONFIG-END -->

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-047 | Reescribir mapa de dominio canónico con modelo de 4 microservicios en opti-docs | done | https://github.com/jdtovar07/opti-docs/commit/808a9b6e0c870556c41f98d443c1f1b05f97c3b3 |
| HU-OPT-048 | Mapear vistas Figma a pantallas React y rutas implementadas (frontend MVP 1) | done | https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3 |
| HU-OPT-049 | Modelar eventos de dominio WorkOrder y flujo de creación de orden para ms-ordenes | done | [`ms-ordenes-domain.md`](./ms-ordenes-domain.md) |
| HU-OPT-050 | Modelar DDD táctico de WorkOrder — agregado, máquina de estados, invariantes | done | [`ms-ordenes-domain.md`](./ms-ordenes-domain.md) |
| HU-OPT-051 | Esbozar estructura hexagonal Go y casos de uso para ms-ordenes | done | [`ms-ordenes-domain.md`](./ms-ordenes-domain.md) |
| HU-OPT-052 | Trazar vistas Figma de órdenes a boceto REST y comandos de dominio | done | [`ms-ordenes-domain.md`](./ms-ordenes-domain.md) |
| HU-OPT-053 | Entregar y presentar OptiView Platform MVP 1 — monolito modular (HU-01, HU-05, HU-08) | done | https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15 |
| HU-OPT-054 | Preparar y presentar deck de expo MVP 1 (arquitectura, HUs, demo, monolito→microservicios) | done | [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) |

## 2. Mi contribución individual

### Mis commits esta semana (`jdtovar07`)

**optiview-platform** — frontend MVP 1 + cadena de release Git Flow:

| Commit | Mensaje |
|--------|---------|
| [`170aefe`](https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3) | `feat(frontend): add OptiView SPA and its documentation to the monorepo` |
| [`ac4f682`](https://github.com/jdtovar07/optiview-platform/commit/ac4f6825faa608881256eab21d0ced267a888e6d) | Merge `feature/frontend-spa` → `develop` |
| [`d85b2e4`](https://github.com/jdtovar07/optiview-platform/commit/d85b2e46295bdffdae9df360aa2af312cfa5a1d9) | Promover `develop` → `qa` |
| [`185c06b`](https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15) | Promover `qa` → `main` — **Release MVP 1 (Corte 1)** + tag `v1.0.0` |

**opti-docs** — arquitectura de dominio canónica:

| Commit | Mensaje |
|--------|---------|
| [`808a9b6`](https://github.com/jdtovar07/opti-docs/commit/808a9b6e0c870556c41f98d443c1f1b05f97c3b3) | `docs(domain): rewrite domain map with confirmed 4-microservice model` |

**Fork del curso** — documentación Semana 05:

| Entregable | Contenido |
|-------------|---------|
| [`ms-ordenes-domain.md`](./ms-ordenes-domain.md) | Agregado WorkOrder, máquina de estados, layout hexagonal Go, trazabilidad Figma→API |
| [`optiview-platform-mvp.md`](./optiview-platform-mvp.md) | Documentación MVP 1 monolito, mapeo Figma→pantalla, ruta monolito→microservicios |
| [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) | Presentación MVP 1 — expo al profesor y al salón |

### Qué hice

- **Entregué y presenté OptiView Platform MVP 1** ([`optiview-platform`](https://github.com/jdtovar07/optiview-platform)) siguiendo la **guía Figma** de la Semana 04 y las **HUs** HU-01, HU-05, HU-08. Construí el **frontend React SPA** (commit `170aefe`) mapeando frames Figma a pantallas: Login (07), Dashboard (01), Pacientes/Nuevo/Detalle (08–10), Inventario/Registrar montura (03, 21), Órdenes/Nueva/Detalle (12, 13–14, 05). Promoví el release por Git Flow hasta **`main`** + tag **`v1.0.0`** (commit `185c06b`).
- **Monolito primero, microservicios después:** MVP 1 es un **monolito modular** (Java Spring Boot + React + PostgreSQL, `docker compose up`) según ADR-0001 — paquetes de dominio (`model` / `usecase` / `infrastructure`) diseñados para extraer después los módulos patient, inventory y work-order hacia `ms-pacientes`, `ms-inventario`, `ms-ordenes` sin reescribir reglas de negocio.
- **Reescribí el mapa de dominio canónico** en `opti-docs` (commit `808a9b6`): confirmé **4 microservicios de dominio** + `api-gateway`, contextos delimitados, relaciones (U→D, ACL, OHS) y clasificación core/supporting/generic — reemplaza el borrador anterior de 3 servicios.
- Escribí [`ms-ordenes-domain.md`](./ms-ordenes-domain.md): agregado `WorkOrder`, máquina de 7 estados mapeada a badges Figma, invariantes INV-ORD-001…005, eventos de dominio, paquetes hexagonales Go y tablas `orders_schema` — blueprint para extraer el módulo work-order del monolito.
- Escribí [`optiview-platform-mvp.md`](./optiview-platform-mvp.md) documentando alcance MVP, tabla Figma→pantalla, endpoints API, evidencia Git Flow y ruta de extracción.
- Preparé y presenté **[`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx)** — diapositivas para la expo del MVP 1 explicando OptiView Platform: contexto del producto, UI guiada por Figma, HUs implementadas (HU-01, HU-05, HU-08), arquitectura monolito modular (ADR-0001), flujo de demo en vivo (`docker compose up`) y la ruta planificada de monolito a cuatro microservicios.

> Contexto de equipo (no mis commits): Bairon Suarez aportó el core backend del MVP 1 y `navigation-map.md` en opti-docs; Julian Vargas aportó `domain-events.md`. Alineé mi `ms-ordenes-domain.md` con sus catálogos, pero mi evidencia calificada son los commits listados arriba.

## 3. Bloqueadores y riesgos

- **Contrato OpenAPI de `ms-ordenes` aún no publicado** en `opti-docs/07-api/contracts/openapi/` — boceto REST en `ms-ordenes-domain.md` pero sin `ms-ordenes.yaml`.
- Timeout de reserva de stock (HU-OPT-020) sigue sin definir.
- Wizard MVP 1 simplifica pasos Figma 13→20 (sin lentes/tratamientos) — wizard completo diferido a MVP 2 / split microservicios.
- Microservicio Go `ms-ordenes` sin iniciar — modelo táctico en `ms-ordenes-domain.md` es el blueprint de extracción.

## 4. Plan para la próxima semana

- Extraer módulo patient → `ms-pacientes`; frame → `ms-inventario`; work-order → `ms-ordenes` (Go).
- Agregar lentes/tratamientos al wizard (frames Figma 19–20).
- Publicar contrato OpenAPI `ms-ordenes.yaml` en opti-docs.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [x] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [x] Tests agregados/actualizados (unit / integration)
- [x] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: Git Flow en `optiview-platform` ejecutado por mí (`feature/frontend-spa` → `develop` → `qa` → `main`, commits `ac4f682`, `d85b2e4`, `185c06b`). Criterios HU-01/05/08 en tests de dominio e integración del monolito.

## 6. Enlaces de evidencia — mis commits (`jdtovar07`)

**optiview-platform:**

- Frontend SPA (Figma → React): https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3
- Merge feature → develop: https://github.com/jdtovar07/optiview-platform/commit/ac4f6825faa608881256eab21d0ced267a888e6d
- Promover develop → qa: https://github.com/jdtovar07/optiview-platform/commit/d85b2e46295bdffdae9df360aa2af312cfa5a1d9
- **Release MVP 1 (v1.0.0):** https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15

**opti-docs:**

- Reescritura mapa de dominio: https://github.com/jdtovar07/opti-docs/commit/808a9b6e0c870556c41f98d443c1f1b05f97c3b3

**Fork del curso (docs Semana 05):**

- Modelo DDD táctico: [`ms-ordenes-domain.md`](./ms-ordenes-domain.md)
- Documentación MVP 1: [`optiview-platform-mvp.md`](./optiview-platform-mvp.md)
- Presentación expo MVP 1: [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx)
- Flujo UI Figma Semana 04: [`04-week/hu-status/figma-ui-flow.md`](../../04-week/hu-status/figma-ui-flow.md)
- Brief de producto Semana 01: [`01-week/hu-status/prd.md`](../../01-week/hu-status/prd.md)
- ADR monolito → microservicios: https://github.com/jdtovar07/optiview-platform/blob/main/docs/adr/0001-monolito-modular-hexagonal.md
