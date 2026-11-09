<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       15-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 15

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Documentar testing at scale (contract, E2E, load, chaos) y el checklist de release production-grade de MVP 3; mapear ambos a OptiView tras MVP 2 (saga place-order, CI/GHCR, observabilidad, security backlog) como análisis de brechas hacia un corte `v3.0.0`.
<!-- CONFIG-END -->

> **Ventana de la semana:** lunes **2026-11-09** → domingo **2026-11-15** (cada semana del curso es lun–dom).  
> **Entrega Semana 15:** (1) notas + visuales de **testing at scale**, y (2) **shipping MVP 3 / release production-grade**, con mapeo de lo que OptiView ya tiene vs lo que falta para producción.

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-159 | Documentar testing at scale — contract, E2E, load y chaos | done | [`testing-at-scale-contract-e2e-load-chaos.md`](./testing-at-scale-contract-e2e-load-chaos.md) |
| HU-OPT-160 | Elaborar resumen visual de testing at scale | done | [`testing-at-scale-contract-e2e-load-chaos-vertical.png`](./testing-at-scale-contract-e2e-load-chaos-vertical.png) |
| HU-OPT-161 | Documentar shipping MVP 3 — release production-grade | done | [`release-shipping-mvp3-production-grade.md`](./release-shipping-mvp3-production-grade.md) |
| HU-OPT-162 | Elaborar resumen visual del release production-grade MVP 3 | done | [`release-shipping-mvp3-production-grade-vertical.png`](./release-shipping-mvp3-production-grade-vertical.png) |

## 2. Mi contribución individual

> **Autor:** Juan Diego Tovar Rodriguez / `jdtovar07`.  
> **Alcance Semana 15:** notas de testing + readiness MVP 3; gap analysis sobre el MVP 2 entregado.

### Notas y visuales

| Artefacto | Qué cubre |
|-----------|-----------|
| [`testing-at-scale-contract-e2e-load-chaos.md`](./testing-at-scale-contract-e2e-load-chaos.md) | Pirámide distribuida; Pact/contratos; integración; E2E; load; chaos |
| [`testing-at-scale-contract-e2e-load-chaos-vertical.png`](./testing-at-scale-contract-e2e-load-chaos-vertical.png) | Resumen visual |
| [`release-shipping-mvp3-production-grade.md`](./release-shipping-mvp3-production-grade.md) | Production-grade; MVP 1→2→3; checklist; tag → deploy → smoke → señales → keep/rollback |
| [`release-shipping-mvp3-production-grade-vertical.png`](./release-shipping-mvp3-production-grade-vertical.png) | Resumen visual |

### Gap map OptiView (MVP 2 → MVP 3)

| Ítem | Estado hoy |
|------|------------|
| CI / unit | Presente en varios repos |
| Contract tests | Documentados; aún no gate bloqueante |
| E2E | Demos manuales; poco automatizado |
| Load / chaos | Sin corridas sistemáticas |
| Observabilidad | Stack en `opti-infra`; SDK progresivo |
| Seguridad | JWT + taller Redis; secret store pendiente |
| Release versionado | Tags `v2.0.0` / `v2.1.0` listos como patrón para `v3.0.0` |

Journey crítico a probar: login → place-order → pago.

### Ceremonias y flujo

| Ceremonia | Cuándo / evidencia |
|-----------|--------------------|
| Planning | Kickoff: testing + MVP 3; gap map |
| Daily | Async: avance; listar gaps por BC |
| Review | Checklist readiness vs evidencia MVP 2 |
| Retro | MVP 2 = integración; falta contratos + E2E + load antes de `v3.0.0` |
| PRs por ambiente | Semana de estudio |

## 3. Bloqueadores y riesgos

- Sin suite de contratos ni baseline de load; secret store / Redis; branch protection desigual; OTel incompleto.

## 4. Plan para la próxima semana

- Plan mínimo de contract tests gateway ↔ sales/products.
- Candidato: un E2E smoke en CI.
- Opcional: script k6 vs gateway.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [x] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [x] Tests agregados/actualizados (unit / integration)
- [x] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: Ventana lun–dom. `feat/*` por acuerdo. HU-status en `main`.

## 6. Enlaces de evidencia

- Artefactos en esta carpeta
- Semana 14: [`14-week/hu-status/README.md`](../../14-week/hu-status/README.md)
- Tags MVP 2: https://github.com/code-corhuila/opti-front/releases/tag/v2.0.0
