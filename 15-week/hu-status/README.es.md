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
- SPRINT_GOAL: Documentar testing at scale (contract, E2E, load, chaos) y el checklist de release production-grade de MVP 3; mapear a OptiView tras MVP 2; y aterrizar el slice de factura PDF / comprobantes privados en `develop` (mergeado 2026-11-10).
<!-- CONFIG-END -->

> **Ventana de la semana:** lunes **2026-11-09** → domingo **2026-11-15** (cada semana del curso es lun–dom).  
> **Entrega Semana 15:** (1) notas testing at scale, (2) shipping MVP 3, y (3) slice **factura PDF / comprobante privado** — **mergeado a `develop`** (falta promover a `qa`/`main`).

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-159 | Documentar testing at scale — contract, E2E, load y chaos | done | [`testing-at-scale-contract-e2e-load-chaos.md`](./testing-at-scale-contract-e2e-load-chaos.md) |
| HU-OPT-160 | Elaborar resumen visual de testing at scale | done | [`testing-at-scale-contract-e2e-load-chaos-vertical.png`](./testing-at-scale-contract-e2e-load-chaos-vertical.png) |
| HU-OPT-161 | Documentar shipping MVP 3 — release production-grade | done | [`release-shipping-mvp3-production-grade.md`](./release-shipping-mvp3-production-grade.md) |
| HU-OPT-162 | Elaborar resumen visual del release production-grade MVP 3 | done | [`release-shipping-mvp3-production-grade-vertical.png`](./release-shipping-mvp3-production-grade-vertical.png) |
| HU-OPT-163 | Persistencia de comprobantes privados en `opti-sales-db` (V020) | done | [`972c2fe`](https://github.com/code-corhuila/opti-sales-db/commit/972c2fe) · PR [#20](https://github.com/code-corhuila/opti-sales-db/pull/20) → merge [`ee42ba2`](https://github.com/code-corhuila/opti-sales-db/commit/ee42ba2) |
| HU-OPT-164 | Factura PDF + pagos simulados con evidencia privada en `opti-sales-api` | done | [`04caffd`](https://github.com/code-corhuila/opti-sales-api/commit/04caffd) · PR [#18](https://github.com/code-corhuila/opti-sales-api/pull/18) → merge [`402a4ad`](https://github.com/code-corhuila/opti-sales-api/commit/402a4ad) |
| HU-OPT-165 | Descargas de factura + confirmación de pago en `opti-sales-portal` | done | [`2e161bd`](https://github.com/code-corhuila/opti-sales-portal/commit/2e161bd) · PR [#19](https://github.com/code-corhuila/opti-sales-portal/pull/19) → merge [`cae999b`](https://github.com/code-corhuila/opti-sales-portal/commit/cae999b) |
| HU-OPT-166 | Payloads grandes de comprobante solo al crear pago en `opti-api-gateway` | done | [`a2b6e85`](https://github.com/code-corhuila/opti-api-gateway/commit/a2b6e85) · PR [#17](https://github.com/code-corhuila/opti-api-gateway/pull/17) → merge [`939e0ea`](https://github.com/code-corhuila/opti-api-gateway/commit/939e0ea) |
| HU-OPT-167 | Descargas autenticadas + polish shell en `opti-front` | done | [`d330808`](https://github.com/code-corhuila/opti-front/commit/d330808) · PR [#30](https://github.com/code-corhuila/opti-front/pull/30) → merge [`4ff44f1`](https://github.com/code-corhuila/opti-front/commit/4ff44f1) |

## 2. Mi contribución individual

> **Autor:** Juan Diego Tovar Rodriguez / `jdtovar07`.  
> **Alcance Semana 15:** notas testing + MVP 3; slice factura/comprobantes **mergeado a `develop`** (2026-11-10).

### Slice en `develop` (pendiente promover a qa/main)

Commits autoría Juan Diego; PRs mergeados por el equipo. Companions de products/customers del compañero.

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
| E2E | Demos manuales; path PDF en `develop` |
| Load / chaos | Sin corridas sistemáticas |
| Observabilidad | Stack en `opti-infra`; SDK progresivo |
| Seguridad | JWT + taller Redis; PR abierto auth-db #19 (no mergear antes de demo) |
| Release versionado | Tags `v2.0.0` / `v2.1.0`; slice PDF aún sin tag |

Journey crítico a probar: login → place-order → pago → PDF.

### Ceremonias y flujo

| Ceremonia | Cuándo / evidencia |
|-----------|--------------------|
| Planning | Kickoff: testing + MVP 3; track PRs PDF |
| Daily | Async: CI → merge 2026-11-10 |
| Review | Demo en vivo desde `develop` |
| Retro | Slice en `develop`; falta contratos + E2E + load antes de `v3.0.0` |
| PRs por ambiente | feat → develop **hecho**; falta qa/main |

## 3. Bloqueadores y riesgos

- Slice aún no en `qa`/`main`/tag; sin suite de contratos ni baseline de load; secret store / Redis; branch protection desigual; OTel incompleto.

## 4. Plan para la próxima semana

- Promover HU-OPT-163…167 a qa → main + tag.
- Plan mínimo de contract tests en place-order.
- Candidato: E2E smoke (login + place-order + descarga factura) en CI.

## 5. Autochequeo de cumplimiento

- [x] Conventional Commits
- [x] PR por ambiente
- [x] Criterios de aceptación testeables
- [x] Tests
- [x] DDD / hexagonal
- [x] Sin secretos en repo

## 6. Enlaces de evidencia

- Notas week-15 (mismo directorio)
- Merges develop: sales-db #20, sales-api #18, sales-portal #19, gateway #17, front #30
