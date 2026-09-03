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
- SPRINT_GOAL: Entregar y presentar OptiView Platform MVP 1 (Corte 1) esta semana — SPA React completa desde la guía Figma de la Semana 04 (HU-01, HU-05, HU-08), release por Git Flow en optiview-platform, y expo en clase con demo en vivo.
<!-- CONFIG-END -->

> **Entrega Semana 05 — presentación MVP 1.** Todo en esta carpeta apoya la **expo del MVP esta semana**: el frontend React que construí, el release tag `v1.0.0`, el mapeo Figma→pantalla y el deck [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx). La demo en vivo corre con `docker compose up --build` → http://localhost:8080.

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-048 | Construir la SPA React completa desde la guía Figma de la Semana 04 | done | https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3 |
| HU-OPT-049 | Implementar pantallas del módulo Pacientes — listado, registro, detalle (Figma 08–10, HU-01) | done | https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3 |
| HU-OPT-050 | Implementar pantallas de Inventario — listado y registro de monturas (Figma 03, 21, HU-05) | done | https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3 |
| HU-OPT-051 | Implementar pantallas de Órdenes — listado, crear, detalle (Figma 12, 13–14, 05, HU-08) | done | https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3 |
| HU-OPT-052 | Publicar frontend MVP 1 por Git Flow (feature → develop → qa → main) | done | https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15 |
| HU-OPT-053 | Actualizar mapa de dominio canónico en `opti-docs` — modelo de 4 microservicios alineado con arquitectura MVP | done | https://github.com/jdtovar07/opti-docs/commit/808a9b6e0c870556c41f98d443c1f1b05f97c3b3 |
| HU-OPT-054 | Preparar y presentar deck de expo MVP 1 (Figma, HUs, demo en vivo, contexto monolito) | done | [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) |

## 2. Mi contribución individual

> **Aclaración de alcance:** mi trabajo esta semana fue **frontend + documentación** — React SPA, implementación Figma→pantalla, release por Git Flow, **mapa de dominio en opti-docs**, docs MVP en el fork del curso, y presentación en clase. **No** implementé código backend ni microservicios Go esta semana. El backend monolito Java lo construyó un compañero; mi frontend consume su API REST en la demo en vivo.

### Mis commits esta semana (`jdtovar07`) — solo frontend

| Commit | Mensaje |
|--------|---------|
| [`170aefe`](https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3) | `feat(frontend): add OptiView SPA and its documentation to the monorepo` — **39 archivos, todos bajo `frontend/`** (10 pantallas, Layout, auth, cliente API, Docker/Nginx) |
| [`ac4f682`](https://github.com/jdtovar07/optiview-platform/commit/ac4f6825faa608881256eab21d0ced267a888e6d) | Merge `feature/frontend-spa` → `develop` |
| [`d85b2e4`](https://github.com/jdtovar07/optiview-platform/commit/d85b2e46295bdffdae9df360aa2af312cfa5a1d9) | Promover `develop` → `qa` |
| [`185c06b`](https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15) | Promover `qa` → `main` — **Release MVP 1 (Corte 1)** + tag `v1.0.0` |

Prueba del commit `170aefe` — cero rutas `backend/`:

```
frontend/src/screens/  → Login, Dashboard, Patients, PatientNew, PatientDetail,
                         Inventory, FrameNew, WorkOrders, WorkOrderNew, WorkOrderDetail
frontend/src/          → App.tsx, api.ts, auth.tsx, useApi.ts, Layout.tsx, theme.tsx
docs/adr/0003-         → ADR SPA React separada
```

### Lo que construí (frontend)

**Stack:** React 18 · Vite · TypeScript · proxy Nginx (`/api` → backend) · servido vía `docker compose`.

| Frame Figma | Pantalla React (`frontend/src/screens/`) | HU | Qué hace la UI |
|-------------|------------------------------------------|-----|----------------|
| 07 Login | `Login.tsx` | — | Formulario auth, sesión JWT |
| 01 Dashboard | `Dashboard.tsx` | — | KPIs resumen vía `GET /api/summary` |
| 08 Pacientes | `Patients.tsx` | HU-01 | Listado buscable de pacientes |
| 09 Nuevo paciente | `PatientNew.tsx` | HU-01 | Formulario registro (documento, nombres, teléfono, EPS) |
| 10 Detalle paciente | `PatientDetail.tsx` | HU-01 | Vista perfil del paciente |
| 03 Inventario | `Inventory.tsx` | HU-05 | Tabla stock de monturas |
| 21 Registrar montura | `FrameNew.tsx` | HU-05 | Formulario registro montura (SKU, precios, stock) |
| 12 Órdenes de trabajo | `WorkOrders.tsx` | HU-08 | Listado órdenes con estado |
| 13–14 Wizard (simplificado) | `WorkOrderNew.tsx` | HU-08 | Crear orden — selección paciente + montura |
| 05 Detalle de Orden | `WorkOrderDetail.tsx` | HU-08 | Vista detalle de orden |

**Infraestructura frontend compartida que implementé:**
- `Layout.tsx` — sidebar + barra superior según layout admin Figma
- `auth.tsx` / `api.ts` / `useApi.ts` — auth JWT y cliente REST al backend monolito
- `Field.tsx` / `toast.tsx` / `theme.tsx` — componentes reutilizables y feedback UI
- `App.tsx` — árbol de rutas React Router conectando todas las pantallas

### Expo MVP 1 — lo que presento esta semana

| Paso | Qué | Evidencia |
|------|-----|-----------|
| 1 | Contexto — OptiView, equipo, alcance Corte 1 | [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) diapositivas 1–3 |
| 2 | Guía Figma (Semana 04) → pantallas implementadas | [`figma-ui-flow.md`](../../04-week/hu-status/figma-ui-flow.md) + tabla arriba |
| 3 | **Demo en vivo** — login → dashboard → pacientes → inventario → órdenes | `docker compose up --build` en [`optiview-platform`](https://github.com/jdtovar07/optiview-platform) tag `v1.0.0` |
| 4 | Mi aporte — SPA frontend + release Git Flow | commit [`170aefe`](https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3) → [`185c06b`](https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15) |
| 5 | Arquitectura del equipo — monolito hoy, microservicios después | deck + [`optiview-platform-mvp.md`](./optiview-platform-mvp.md) |

### Documentación que creé o actualicé esta semana

| Dónde | Qué | Para qué |
|-------|-----|----------|
| **optiview-platform** (`170aefe`) | `frontend/README.md` — cómo correr/build la SPA | Guía de desarrollo dentro del monorepo |
| **optiview-platform** (`170aefe`) | `docs/adr/0003-frontend-separado.md` — ADR SPA React separada | Decisión de arquitectura del frontend |
| **optiview-platform** (`170aefe`) | `docs/README.md`, `README.md` raíz | Docs del monorepo actualizados para la entrega frontend |
| **opti-docs** ([`808a9b6`](https://github.com/jdtovar07/opti-docs/commit/808a9b6e0c870556c41f98d443c1f1b05f97c3b3)) | [`02-domain/domain-map.md`](https://github.com/jdtovar07/opti-docs/blob/main/02-domain/domain-map.md) — contextos acotados canónicos (`ms-pacientes`, `ms-inventario`, `ms-ordenes`, `ms-facturacion`) | Doc de arquitectura de dominio para contexto de la expo MVP |
| **Fork del curso** (`05-week/hu-status/`) | [`README.md`](./README.md) + [`README.es.md`](./README.es.md) | Estado semanal (calificado) — HUs, commits, plan de expo |
| **Fork del curso** (`05-week/hu-status/`) | [`optiview-platform-mvp.md`](./optiview-platform-mvp.md) | Referencia MVP 1 — mapa Figma→pantalla, guion demo, commits release |
| **Fork del curso** (`05-week/hu-status/`) | [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) | Deck de presentación en clase |

### Documentación y presentación

- [`optiview-platform-mvp.md`](./optiview-platform-mvp.md) — doc de referencia MVP 1 para la expo de esta semana: mapeo Figma→pantalla, alcance frontend, URL demo, commits del release.
- [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx) — **deck de clase MVP 1** — guía Figma, HUs implementadas, guion de demo en vivo, estrategia monolito primero.

### Contexto de equipo (no mi código esta semana)

- **Backend (monolito Java Spring Boot):** construido por Bairon Suarez — API REST que mi frontend consume en la demo en vivo.
- **Gobernanza opti-docs** (4 docs en `00-governance/`): adaptada en la **Semana 03** — commit [`3834691`](https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded), no Semana 05.

## 3. Bloqueadores y riesgos

- El wizard de orden del MVP 1 simplifica pasos Figma 13→20 (pantalla única de creación, sin paso lentes/tratamientos).
- El frontend aún no tiene tests UI automatizados — verificación manual contra Figma y criterios de aceptación HU.
- Backend y frontend acoplados por REST; cuando el equipo divida en microservicios, el cliente API del frontend deberá apuntar al gateway.

## 4. Plan para la próxima semana

- Completar wizard de 4 pasos en frontend (frames Figma 19–20 — lentes + resumen).
- Agregar pantallas Figma restantes (facturación, reportes, portal paciente).
- Empezar a consumir APIs vía `api-gateway` cuando se extraigan microservicios del monolito.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [x] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [ ] Tests agregados/actualizados (unit / integration)
- [ ] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: Git Flow en `optiview-platform` para la feature frontend (`feature/frontend-spa` → `develop` → `qa` → `main`). Criterios UI HU-01/05/08 verificables recorriendo cada pantalla mapeada desde Figma. No escribí código backend/dominio esta semana — DDD/tests sin marcar aplican al backend (compañero).

## 6. Enlaces de evidencia — mis commits (`jdtovar07`)

**optiview-platform (frontend):**

- **SPA React completa (Figma → pantallas):** https://github.com/jdtovar07/optiview-platform/commit/170aefe87e4303e3b57395b42f989f00596e6fd3
- Merge feature → develop: https://github.com/jdtovar07/optiview-platform/commit/ac4f6825faa608881256eab21d0ced267a888e6d
- Promover develop → qa: https://github.com/jdtovar07/optiview-platform/commit/d85b2e46295bdffdae9df360aa2af312cfa5a1d9
- **Release MVP 1 (v1.0.0):** https://github.com/jdtovar07/optiview-platform/commit/185c06bc5f07a6935a1affec764cdaf949f5ba15

**opti-docs (documentación de dominio):**

- **Reescritura mapa de dominio (Semana 05):** https://github.com/jdtovar07/opti-docs/commit/808a9b6e0c870556c41f98d443c1f1b05f97c3b3
- Archivo canónico: [`02-domain/domain-map.md`](https://github.com/jdtovar07/opti-docs/blob/main/02-domain/domain-map.md)

**Fork del curso (docs Semana 05):**

- Documentación MVP frontend: [`optiview-platform-mvp.md`](./optiview-platform-mvp.md)
- Presentación expo MVP 1: [`OptiView_MVP1_Expo.pptx`](./OptiView_MVP1_Expo.pptx)
- Guía UI Figma Semana 04: [`04-week/hu-status/figma-ui-flow.md`](../../04-week/hu-status/figma-ui-flow.md)
