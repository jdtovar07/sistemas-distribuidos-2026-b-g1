<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       12-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 12

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Documentar modelos de despliegue en la nube y estrategias zero-downtime (rolling / blue-green / canary); documentar el plan de despliegue, Infrastructure as Code y el ciclo de rollback; mapear ambos al Git Flow / GHCR / Flyway / SemVer de OptiView tras MVP 2; y completar el taller guiado de observabilidad sobre la saga `place-order` (CP0–CP9 + reflexión).
<!-- CONFIG-END -->

> **Ventana de la semana:** lunes **2026-10-19** → domingo **2026-10-25** (cada semana del curso es lun–dom).  
> **Entrega Semana 12:** (1) notas + visuales de **despliegue en la nube** y **plan / IaC / rollback**, (2) mapeo a OptiView, y (3) **taller de observabilidad** sobre `place-order` (artefactos en `11-week/workshop/`, ejecutado 20–21 oct dentro de esta ventana).

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-143 | Documentar despliegue en la nube — modelos, estrategias y zero-downtime | done | [`cloud-deployment-models-strategies.md`](./cloud-deployment-models-strategies.md) |
| HU-OPT-144 | Elaborar resumen visual de modelos / estrategias de cloud deployment | done | [`cloud-deployment-models-strategies-vertical.png`](./cloud-deployment-models-strategies-vertical.png) |
| HU-OPT-145 | Documentar plan de despliegue, Infrastructure as Code y rollback | done | [`deployment-plan-iac-rollback.md`](./deployment-plan-iac-rollback.md) |
| HU-OPT-146 | Elaborar resumen visual de plan de despliegue / IaC / rollback | done | [`deployment-plan-iac-rollback-vertical.png`](./deployment-plan-iac-rollback-vertical.png) |
| HU-OPT-147 | Taller observabilidad Entrega 1 — journey, contrato de logs, instrumentación, métricas (CP0–CP4) | done | [`../workshop/`](../../11-week/workshop/) · [`50be758`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/50be758) … [`d020764`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/d020764) · [`resumen-observabilidad.md`](./resumen-observabilidad.md) |
| HU-OPT-148 | Taller observabilidad Entrega 2 — SLOs, alertas burn-rate, runbook, simulacro (CP6–CP9) + reflexión | done | [`05-slo.md`](../../11-week/workshop/05-slo.md) · [`06-alerts.yml`](../../11-week/workshop/06-alerts.yml) · [`07-runbook.md`](../../11-week/workshop/07-runbook.md) · [`08-incident.md`](../../11-week/workshop/08-incident.md) · [`7767691`](https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/commit/7767691) · [Doc reflexión](https://docs.google.com/document/d/1wNcQKXvOGbR3IC6YAwaY2q2N6iZZHF96EAHxq3cKygA/edit?usp=sharing) |

## 2. Mi contribución individual

> **Autor:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Alcance Semana 12:** notas cloud/IaC + taller de observabilidad sobre `place-order` (carpeta `11-week/workshop/` por layout del curso; fechas 20–21 oct = Semana 12).

### Notas y visuales

| Artefacto | Qué cubre |
|-----------|-----------|
| [`cloud-deployment-models-strategies.md`](./cloud-deployment-models-strategies.md) | Modelos cloud, zero-downtime, scaling |
| [`cloud-deployment-models-strategies-vertical.png`](./cloud-deployment-models-strategies-vertical.png) | Resumen visual |
| [`deployment-plan-iac-rollback.md`](./deployment-plan-iac-rollback.md) | Plan, IaC, checklist, rollback |
| [`deployment-plan-iac-rollback-vertical.png`](./deployment-plan-iac-rollback-vertical.png) | Resumen visual |
| [`resumen-observabilidad.md`](./resumen-observabilidad.md) | Hechos del taller: CP, SLOs, alertas, simulacro, plan al código real |

### Taller de observabilidad (esta semana)

Journey crítico: saga `place-order`. Entrega 1 (20 oct, clase): CP0–CP4. Entrega 2 (take-home): CP6–CP9 + reflexión. Tests del módulo: **7/7 ALL CHECKS PASSED**. SLO hipotético 99.5% disponibilidad / 99% &lt; 2 s. Detalle: [`resumen-observabilidad.md`](./resumen-observabilidad.md).

### Ceremonias y flujo (esta semana)

| Ceremonia | Cuándo / evidencia |
|-----------|--------------------|
| Planning | Kickoff: notas cloud/IaC + cerrar taller CP0–CP9 |
| Daily | Async: avance de checkpoints + nombres de tags |
| Review | Estrategias cloud vs promote OptiView; Entrega 1 en clase + reflexión Entrega 2 |
| Retro | Alertar por burn-rate de usuario, no CPU; un PR por ambiente; siguiente: runbook + reglas en `opti-infra` |
| PRs por ambiente | Sin PRs de producto nuevos; evidencia de arrastre Semana 10 (products/auth/sales db #13–15 / #10–12) |

## 3. Bloqueadores y riesgos

- Target cloud sin ADR; secret store pendiente; SLO del taller con tráfico supuesto; módulo CP3 ≠ servicio real; coordinar campos de log con el equipo.

## 4. Plan para la próxima semana

- Seguridad (authn/authz/zero trust + threat modeling) — tema Semana 13.
- Runbook promote/rollback; llevar reglas burn-rate a `opti-infra` tras `promtool`.
- Plan real: `traceparent` en gateway + logs JSON en los cinco servicios del place-order.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [x] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [x] Tests agregados/actualizados (unit / integration)
- [x] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: Ventana lun–dom. Archivos del taller en `11-week/workshop/` (nombre de carpeta del curso); trabajo con fechas **20–21 oct** = Semana 12. `feat/*` por acuerdo. HU-status en `main`.

## 6. Enlaces de evidencia

- Docs Semana 12 en esta carpeta + [`resumen-observabilidad.md`](./resumen-observabilidad.md)
- Workshop: https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1/tree/main/11-week/workshop
- Reflexión: https://docs.google.com/document/d/1wNcQKXvOGbR3IC6YAwaY2q2N6iZZHF96EAHxq3cKygA/edit?usp=sharing
- Semana 11: [`11-week/hu-status/README.md`](../../11-week/hu-status/README.md)
