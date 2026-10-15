<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       11-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 11

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Documentar observabilidad (logs, metrics, tracing distribuido) y planeación de confiabilidad (SLIs, SLOs, error budgets, alerting); mapear esas prácticas al stack otel-collector / Prometheus / Grafana de OptiView; y presentar MVP 2 en vivo a toda la clase y al profesor.
<!-- CONFIG-END -->

> **Ventana de la semana:** lunes **2026-10-12** → domingo **2026-10-18** (cada semana del curso es lun–dom).  
> **Entrega Semana 11:** (1) notas + visuales de **observabilidad** y **SLIs/SLOs**, (2) mapeo a OptiView sobre el MVP 2 de la Semana 10, y (3) **expo en clase** del MVP 2 ante el grupo y el profesor.

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-138 | Documentar observabilidad — logs, metrics y tracing distribuido | done | [`observability-logs-metrics-tracing.md`](./observability-logs-metrics-tracing.md) |
| HU-OPT-139 | Elaborar resumen visual de observabilidad (tres pilares + golden signals) | done | [`observability-logs-metrics-tracing-vertical.png`](./observability-logs-metrics-tracing-vertical.png) |
| HU-OPT-140 | Documentar planeación de confiabilidad — SLIs, SLOs, error budgets y alerting | done | [`reliability-slis-slos.md`](./reliability-slis-slos.md) |
| HU-OPT-141 | Elaborar resumen visual de SLIs / SLOs / error budgets | done | [`reliability-slis-slos-vertical.png`](./reliability-slis-slos-vertical.png) |
| HU-OPT-142 | Presentar OptiView MVP 2 en vivo a la clase y al profesor | done | Expo en clase (Semana 11) · tags [`v2.0.0`](https://github.com/code-corhuila/opti-front/releases/tag/v2.0.0) / [`v2.1.0`](https://github.com/code-corhuila/opti-products-db/releases/tag/v2.1.0) · stack vivo con `opti-infra` + túnel ngrok opcional |

## 2. Mi contribución individual

> **Autor:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Alcance Semana 11 (lun–dom):** notas/visuales de observabilidad + confiabilidad; presentación en clase del MVP 2 construido en la Semana 10.

### Notas de estudio y visuales (esta semana)

| Artefacto | Qué cubre |
|-----------|-----------|
| [`observability-logs-metrics-tracing.md`](./observability-logs-metrics-tracing.md) | Tres pilares (logs / metrics / traces), correlation IDs, golden signals, monitoring vs observability |
| [`observability-logs-metrics-tracing-vertical.png`](./observability-logs-metrics-tracing-vertical.png) | Resumen visual de esos conceptos |
| [`reliability-slis-slos.md`](./reliability-slis-slos.md) | SLI / SLO / SLA, error budgets, burn-rate alerting, ciclo de confiabilidad |
| [`reliability-slis-slos-vertical.png`](./reliability-slis-slos-vertical.png) | Resumen visual de planeación de confiabilidad |

### Mapeo a OptiView (cómo aterrizan los conceptos del MVP 2)

| Concepto | Dónde aparece en OptiView |
|----------|---------------------------|
| Intake de metrics + traces | `opti-infra` levanta `otel-collector` (OTLP) → scrape de Prometheus → datasource en Grafana |
| Correlación entre servicios | Checklist de plataforma: mismo `X-Correlation-Id` / `traceId` en gateway y APIs de dominio |
| Golden signals (planeación) | Latency / traffic / errors / saturation como lente para futuros SLOs de portal y API |
| Error budget (planeación) | Meta explícita de confiabilidad antes de más slices; congelar cambios riesgosos si el presupuesto se agota |
| MVP 2 en vivo | Expo en clase del sistema integrado con tag `v2.0.0` (19 `opti-*`) y tips post-seed `v2.1.0` en products/auth/sales db + docs |

### Expo en clase — MVP 2 (esta semana)

Presentamos **OptiView MVP 2** a toda la clase y al profesor: plataforma multi-repo con Git Flow (`feat/*` → develop → qa → release → main), slices verticales de las Semanas 09–10, seeds demo y el stack de observabilidad ya compuesto en `opti-infra`. Camino de demo: `./scripts/up.sh` + migraciones + túnel público opcional (ngrok) sobre el proxy demo para que el SPA use un solo origin (gateway + front).

### Continuidad

| Semana | Qué ya tenemos | Cómo lo usa la Semana 11 |
|--------|----------------|--------------------------|
| 10 | MVP 2 taggeado `v2.0.0`, seeds en `release/2.1.0` → main, slices verticales | Expo + marco de observabilidad/confiabilidad sobre ese corte |
| 09 | Scaffolds evolutivos (auth/sales/gateway/front/worker/workflow) | Esos servicios son los que observamos y contra los que planteamos SLOs |
| 06–08 | Layout 19 repos, contratos, planeación Agile/DevOps | Mismo flujo de equipo para la review en clase |

### Ceremonias y flujo (esta semana)

| Ceremonia | Cuándo / evidencia |
|-----------|--------------------|
| Planning | Kickoff lunes: notas de observabilidad + SLI/SLO, mapeo OptiView, preparar expo MVP 2 (`SPRINT_GOAL`) |
| Daily | Check-ins async: quién presenta cada slice, guion de demo, ensayar up/down de infra |
| Review | **Expo en clase** del MVP 2 ante el grupo y el profesor (plataforma en vivo + tags de release) |
| Retro | Mantener `feat/*` → develop → `qa-*` → `release/*` → main; siguiente: más OTel desde los servicios al collector; borrador de SLOs concretos para gateway + sales |
| PRs por ambiente | Sin PRs de producto nuevos esta semana (estudio + expo). Evidencia de arrastre Semana 10: products-db [#13](https://github.com/code-corhuila/opti-products-db/pull/13)/[#14](https://github.com/code-corhuila/opti-products-db/pull/14)/[#15](https://github.com/code-corhuila/opti-products-db/pull/15); auth-db [#10](https://github.com/code-corhuila/opti-auth-db/pull/10)–[#12](https://github.com/code-corhuila/opti-auth-db/pull/12); sales-db [#10](https://github.com/code-corhuila/opti-sales-db/pull/10)–[#12](https://github.com/code-corhuila/opti-sales-db/pull/12) |

## 3. Bloqueadores y riesgos

- El stack de observabilidad en `opti-infra` ya puede recibir OTel, pero la instrumentación SDK en cada `opti-*-api` sigue siendo progresiva — el collector solo no inventa spans.
- Aún no hay SLOs numéricos ratificados por el equipo para gateway / sales / auth (esta semana documenta el método).
- Secret store compartido sin decidir (`opti-infra`).
- Túnel demo público (ngrok) es ops opcional — credenciales fuera del repo.

## 4. Plan para la próxima semana

- Borrador de SLOs candidatos (disponibilidad + latencia) para `opti-api-gateway` y rutas place-order / pago.
- Empezar a emitir metrics/traces OTel desde al menos una API de dominio hacia el collector existente.
- Seguir UX de notificaciones / reportes de vendedor si hay capacidad.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [x] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [x] Tests agregados/actualizados (unit / integration)
- [x] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: Ventana lun–dom. Semana de estudio + expo sobre el corte MVP 2 de la Semana 10. El equipo usa `feat/*` (no `hu-xxx-dev`) por acuerdo; un PR por ambiente al shippear producto. HU-status del fork en `main`.

## 6. Enlaces de evidencia

**Fork del curso (docs Semana 11):**

- [`observability-logs-metrics-tracing.md`](./observability-logs-metrics-tracing.md)
- [`observability-logs-metrics-tracing-vertical.png`](./observability-logs-metrics-tracing-vertical.png)
- [`reliability-slis-slos.md`](./reliability-slis-slos.md)
- [`reliability-slis-slos-vertical.png`](./reliability-slis-slos-vertical.png)

**Expo MVP 2 (plataforma entregada):**

- Tags: https://github.com/code-corhuila/opti-front/releases/tag/v2.0.0 (mismo `v2.0.0` en cada `opti-*`)
- Tips post-seed: https://github.com/code-corhuila/opti-products-db/releases/tag/v2.1.0 · https://github.com/code-corhuila/opti-auth-db/releases/tag/v2.1.0 · https://github.com/code-corhuila/opti-sales-db/releases/tag/v2.1.0 · https://github.com/code-corhuila/opti-docs/releases/tag/v2.1.0
- Compose de observabilidad: https://github.com/code-corhuila/opti-infra (`otel-collector` / `prometheus` / `grafana`)

**Trabajo previo:**

- Semana 10: [`10-week/hu-status/README.md`](../../10-week/hu-status/README.md)
- Repos org: https://github.com/orgs/code-corhuila/repositories?q=opti
