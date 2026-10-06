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
- SPRINT_GOAL: Documentar patrones de persistencia (saga, outbox, CQRS) y prácticas de release de MVP 2; aterrizar los slices verticales de esta semana sobre los scaffolds de la Semana 09; y reportar tarde los fixes de hardening del domingo 4 oct que no alcanzaron a entrar en el HU-status de la Semana 09.
<!-- CONFIG-END -->

> **Ventana de la semana:** lunes **2026-10-05** → domingo **2026-10-11** (cada semana del curso es lun–dom).  
> **Entrega Semana 10:** (1) notas de **persistencia** y **release MVP 2**, (2) slices verticales **de esta semana** sobre los scaffolds de la Semana 09, y (3) un bloque de **reporte tardío** del trabajo del **domingo 2026-10-04** (Semana 09) que no alcanzó a quedar en el HU-status de esa semana.

## 1. Historias de usuario trabajadas esta semana

### A. Esta semana (lun 2026-10-05 → dom 2026-10-11)

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-090 | Documentar persistencia en sistemas distribuidos (saga, outbox, CQRS) | done | [`persistence-saga-outbox-cqrs.md`](./persistence-saga-outbox-cqrs.md) |
| HU-OPT-091 | Elaborar resumen visual de saga / outbox / CQRS | done | [`persistence-saga-outbox-cqrs.png`](./persistence-saga-outbox-cqrs.png) |
| HU-OPT-092 | Documentar prácticas de release para shipping MVP 2 | done | [`release-shipping-mvp-2.md`](./release-shipping-mvp-2.md) |
| HU-OPT-093 | Elaborar resumen visual del release MVP 2 | done | [`release-shipping-mvp-2.png`](./release-shipping-mvp-2.png) |
| HU-OPT-094 | Email opcional de usuario (auth-db + auth-api) | done | https://github.com/code-corhuila/opti-auth-db/pull/6 · https://github.com/code-corhuila/opti-auth-api/pull/4 |
| HU-OPT-095 | Validación de nombre solo letras en `opti-auth-api` | done | https://github.com/code-corhuila/opti-auth-api/pull/3 |
| HU-OPT-096 | Rutar pagos Nequi por Wompi en `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/5 |
| HU-OPT-097 | Rehacer shell de `opti-front` con sidebar + topbar | done | https://github.com/code-corhuila/opti-front/pull/3 |
| HU-OPT-098 | Polish del shell front (FormData, CSS avatar/tabs, iconos sidebar) | done | https://github.com/code-corhuila/opti-front/pull/10 · [#8](https://github.com/code-corhuila/opti-front/pull/8) |
| HU-OPT-099 | Login split-screen según mockup en `opti-front` | done | https://github.com/code-corhuila/opti-front/pull/4 |
| HU-OPT-100 | Rutar `/api/v1/lenses` a products-api en `opti-api-gateway` | done | https://github.com/code-corhuila/opti-api-gateway/pull/3 |
| HU-OPT-101 | Agregar `seller_id` a work orders en `opti-sales-db` | done | https://github.com/code-corhuila/opti-sales-db/pull/4 |
| HU-OPT-102 | Agregar `gateway_transaction_id` a payments en `opti-sales-db` | done | https://github.com/code-corhuila/opti-sales-db/pull/5 |
| HU-OPT-103 | Atribuir work orders al vendedor + reportes de ingresos en `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/2 |
| HU-OPT-104 | Llevar identidad del caller en la saga place-order en `opti-workflow` | done | https://github.com/code-corhuila/opti-workflow/pull/2 |
| HU-OPT-105 | Schema de sales-goal + notificaciones en `opti-auth-db` | done | https://github.com/code-corhuila/opti-auth-db/pull/4 |
| HU-OPT-106 | Notificaciones + metas de vendedor en `opti-auth-api` | done | https://github.com/code-corhuila/opti-auth-api/pull/2 |
| HU-OPT-107 | Reporte seller-sales solo SERVICE en `opti-sales-api` | done | https://github.com/code-corhuila/opti-sales-api/pull/4 |
| HU-OPT-108 | Rutar `/api/v1/notifications` a auth-api en `opti-api-gateway` | done | https://github.com/code-corhuila/opti-api-gateway/pull/5 |
| HU-OPT-109 | Notificar al vendedor al alcanzar meta en `opti-worker` | done | https://github.com/code-corhuila/opti-worker/pull/2 |
| HU-OPT-116 | Campo email opcional en `opti-auth-portal` | done | https://github.com/code-corhuila/opti-auth-portal/pull/3 |
| HU-OPT-117 | Nombre solo letras en `opti-auth-portal` | done | https://github.com/code-corhuila/opti-auth-portal/pull/2 |
| HU-OPT-118 | Separar "Mi cuenta" en pestañas Perfil / Seguridad / Preferencias | done | https://github.com/code-corhuila/opti-auth-portal/pull/4 |
| HU-OPT-119 | Conectar Avatar compartido en `opti-auth-portal` | done | https://github.com/code-corhuila/opti-auth-portal/pull/5 |
| HU-OPT-120 | Pedir teléfono Nequi al pagar en `opti-sales-portal` | done | https://github.com/code-corhuila/opti-sales-portal/pull/3 |
| HU-OPT-121 | Ítem de work-order polimórfico (`product_type` / `product_id`) en `opti-sales-db` (HU-25) | done | https://github.com/code-corhuila/opti-sales-db/pull/6 |
| HU-OPT-122 | Generalizar ítems de work-order a cualquier tipo de producto en `opti-sales-api` (HU-25) | done | https://github.com/code-corhuila/opti-sales-api/pull/6 |
| HU-OPT-123 | Vender lentes, accesorios y líquidos en `opti-sales-portal` (HU-25) | done | https://github.com/code-corhuila/opti-sales-portal/pull/4 |
| HU-OPT-124 | Actualizar subtítulo de nueva venta (HU-25 / HU-22) en `opti-sales-portal` | done | https://github.com/code-corhuila/opti-sales-portal/pull/7 |
| HU-OPT-125 | Generalizar saga place-order a cualquier tipo de producto en `opti-workflow` (HU-25) | done | https://github.com/code-corhuila/opti-workflow/pull/3 |

### B. Reporte tardío de la Semana 09 (hecho el domingo 2026-10-04 — no quedó en el HU-status de esa semana)

> **Nota:** Este trabajo se completó el **domingo 2026-10-04** (último día de la Semana 09) pero **no alcanzó a entrar** en [`09-week/hu-status/README.md`](../../09-week/hu-status/README.md). **No** es trabajo nuevo de la Semana 10; se informa aquí solo para no perder la evidencia.

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-110 | Corregir schemas Flyway `[environments.default]` en `opti-auth-db` | done | https://github.com/code-corhuila/opti-auth-db/pull/3 |
| HU-OPT-111 | Marcar `verify-rebuild.sh` ejecutable en `opti-auth-db` | done | https://github.com/code-corhuila/opti-auth-db/pull/2 |
| HU-OPT-112 | Corregir schemas Flyway `[environments.default]` en `opti-sales-db` | done | https://github.com/code-corhuila/opti-sales-db/pull/3 |
| HU-OPT-113 | Marcar `verify-rebuild.sh` ejecutable en `opti-sales-db` | done | https://github.com/code-corhuila/opti-sales-db/pull/2 |
| HU-OPT-114 | Marcar `smoke.sh` ejecutable en `opti-api-gateway` | done | https://github.com/code-corhuila/opti-api-gateway/pull/2 |
| HU-OPT-115 | Permitir que Vitest pase sin unit tests aún en `opti-front` | done | https://github.com/code-corhuila/opti-front/pull/2 |

## 2. Mi contribución individual

> **Autor:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Alcance Semana 10 (lun–dom):** notas de estudio + slices con fecha **2026-10-05 … 2026-10-11**.  
> **Reporte tardío:** fixes de hardening con fecha **2026-10-04** (Semana 09) que faltaron en el archivo de la semana pasada.

### Notas de estudio y visuales (esta semana)

| Artefacto | Qué cubre |
|-----------|-----------|
| [`persistence-saga-outbox-cqrs.md`](./persistence-saga-outbox-cqrs.md) | Database-per-service, saga, outbox, CQRS, consistencia eventual |
| [`persistence-saga-outbox-cqrs.png`](./persistence-saga-outbox-cqrs.png) | Resumen visual de esos cinco conceptos |
| [`release-shipping-mvp-2.md`](./release-shipping-mvp-2.md) | Release, MVP, sistema integrado, pasos y buenas prácticas |
| [`release-shipping-mvp-2.png`](./release-shipping-mvp-2.png) | Resumen visual de shipping MVP 2 |

### Slices verticales de esta semana (sobre scaffolds Semana 09)

| Patrón | Cómo lo apliqué esta semana |
|--------|-----------------------------|
| Database-per-service | Schema auth de metas/notificaciones; sales `seller_id` / gateway tx / ítem polimórfico |
| Saga | `opti-workflow` lleva identidad del caller y reserva cualquier tipo de producto (HU-25) |
| Outbox / async | `opti-worker` notifica al alcanzar la meta de ventas |
| Lecturas tipo CQRS | Reportes de ventas; gateway `/lenses` + `/notifications` |
| Release integrado | Shell/login, tabs Mi cuenta, teléfono Nequi, venta de cualquier producto, Wompi |

### Commits representativos de esta semana (fechas dentro de lun–dom)

- **Lun 5 oct:** email auth · auth-portal (email / tabs / avatar) · Wompi · teléfono Nequi · ítem polimórfico sales-db · shell front  
- **Mar 6 oct+ (misma semana):** login · lenses · HU-25 (sales-api / sales-portal / workflow) · seller_id / reportes · saga identity · notificaciones / worker  

### Reporte tardío Semana 09 (solo domingo 4 oct)

- [`30f0c40`](https://github.com/code-corhuila/opti-auth-db/commit/30f0c40) / [`2a9c46f`](https://github.com/code-corhuila/opti-auth-db/commit/2a9c46f) auth-db  
- [`b4f7ccc`](https://github.com/code-corhuila/opti-sales-db/commit/b4f7ccc) / [`0b6be0f`](https://github.com/code-corhuila/opti-sales-db/commit/0b6be0f) sales-db  
- [`68202ed`](https://github.com/code-corhuila/opti-api-gateway/commit/68202ed) gateway  
- [`74faf25`](https://github.com/code-corhuila/opti-front/commit/74faf25) front Vitest

## 3. Bloqueadores y riesgos

- MVP 2 tageado end-to-end aún **no cortado** — los slices van a `develop`.
- La ruta de lenses depende de products-api (otros compañeros).
- Secret store compartido sin decidir (`opti-infra`).
- Riesgo: drift de contratos de reportes/notificaciones vs `opti-docs`.

## 4. Plan para la próxima semana

- Promover slices hacia candidato MVP 2 (`develop` → smoke en `qa`).
- Cablear UX de portales para notificaciones y reportes end to end.
- Ampliar cobertura de saga / outbox.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [x] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [x] Tests agregados/actualizados (unit / integration)
- [x] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: Ventana lun–dom. La sección B solo reporta tarde el domingo 4 oct de la Semana 09. Git Flow `feat/*` → `develop`. HU-status del fork en `main`.

## 6. Enlaces de evidencia

**Fork del curso (docs Semana 10):**

- [`persistence-saga-outbox-cqrs.md`](./persistence-saga-outbox-cqrs.md)
- [`persistence-saga-outbox-cqrs.png`](./persistence-saga-outbox-cqrs.png)
- [`release-shipping-mvp-2.md`](./release-shipping-mvp-2.md)
- [`release-shipping-mvp-2.png`](./release-shipping-mvp-2.png)

**Esta semana (lun–dom) — auth / sales / platform:**

- https://github.com/code-corhuila/opti-auth-db/pull/4 · https://github.com/code-corhuila/opti-auth-db/pull/6
- https://github.com/code-corhuila/opti-auth-api/pull/2 · https://github.com/code-corhuila/opti-auth-api/pull/3 · https://github.com/code-corhuila/opti-auth-api/pull/4
- https://github.com/code-corhuila/opti-auth-portal/pull/2 · https://github.com/code-corhuila/opti-auth-portal/pull/3 · https://github.com/code-corhuila/opti-auth-portal/pull/4 · https://github.com/code-corhuila/opti-auth-portal/pull/5
- https://github.com/code-corhuila/opti-sales-db/pull/4 · https://github.com/code-corhuila/opti-sales-db/pull/5 · https://github.com/code-corhuila/opti-sales-db/pull/6
- https://github.com/code-corhuila/opti-sales-api/pull/2 · https://github.com/code-corhuila/opti-sales-api/pull/4 · https://github.com/code-corhuila/opti-sales-api/pull/5 · https://github.com/code-corhuila/opti-sales-api/pull/6
- https://github.com/code-corhuila/opti-sales-portal/pull/3 · https://github.com/code-corhuila/opti-sales-portal/pull/4 · https://github.com/code-corhuila/opti-sales-portal/pull/7
- https://github.com/code-corhuila/opti-api-gateway/pull/3 · https://github.com/code-corhuila/opti-api-gateway/pull/5
- https://github.com/code-corhuila/opti-front/pull/3 · https://github.com/code-corhuila/opti-front/pull/4 · https://github.com/code-corhuila/opti-front/pull/8 · https://github.com/code-corhuila/opti-front/pull/10
- https://github.com/code-corhuila/opti-worker/pull/2 · https://github.com/code-corhuila/opti-workflow/pull/2 · https://github.com/code-corhuila/opti-workflow/pull/3

**Reporte tardío Semana 09 (domingo 4 oct):**

- https://github.com/code-corhuila/opti-auth-db/pull/2 · https://github.com/code-corhuila/opti-auth-db/pull/3
- https://github.com/code-corhuila/opti-sales-db/pull/2 · https://github.com/code-corhuila/opti-sales-db/pull/3
- https://github.com/code-corhuila/opti-api-gateway/pull/2
- https://github.com/code-corhuila/opti-front/pull/2

**Trabajo previo:**

- Semana 09: [`09-week/hu-status/README.md`](../../09-week/hu-status/README.md)
- Repos org: https://github.com/orgs/code-corhuila/repositories?q=opti
