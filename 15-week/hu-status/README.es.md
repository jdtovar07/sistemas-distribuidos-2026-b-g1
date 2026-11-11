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
- SPRINT_GOAL: Documentar testing at scale y release MVP 3; aterrizar factura PDF / comprobantes en `develop`, promover a `qa` y abrir `release/3.0.0` → `main` (merge + tag pendientes).
<!-- CONFIG-END -->

> **Ventana de la semana:** lunes **2026-11-09** → domingo **2026-11-15**.  
> **Entrega:** notas testing + MVP 3 + slice pagos/PDF — **`develop` mergeado → `qa` mergeado → PRs `release/3.0.0` abiertos a `main`**.

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado | Evidencia |
|---|---|---|---|
| HU-OPT-159 | Documentar testing at scale | done | [`testing-at-scale-contract-e2e-load-chaos.md`](./testing-at-scale-contract-e2e-load-chaos.md) |
| HU-OPT-160 | Visual testing at scale | done | [`testing-at-scale-contract-e2e-load-chaos-vertical.png`](./testing-at-scale-contract-e2e-load-chaos-vertical.png) |
| HU-OPT-161 | Documentar shipping MVP 3 | done | [`release-shipping-mvp3-production-grade.md`](./release-shipping-mvp3-production-grade.md) |
| HU-OPT-162 | Visual release MVP 3 | done | [`release-shipping-mvp3-production-grade-vertical.png`](./release-shipping-mvp3-production-grade-vertical.png) |
| HU-OPT-163 | Comprobantes privados `opti-sales-db` V020 | done | [#20](https://github.com/code-corhuila/opti-sales-db/pull/20) → develop |
| HU-OPT-164 | Factura PDF + pagos `opti-sales-api` | done | [#18](https://github.com/code-corhuila/opti-sales-api/pull/18) → develop |
| HU-OPT-165 | Descargas factura `opti-sales-portal` | done | [#19](https://github.com/code-corhuila/opti-sales-portal/pull/19) → develop |
| HU-OPT-166 | Payload comprobante en gateway | done | [#17](https://github.com/code-corhuila/opti-api-gateway/pull/17) → develop |
| HU-OPT-167 | Descargas autenticadas `opti-front` | done | [#30](https://github.com/code-corhuila/opti-front/pull/30) → develop |
| HU-OPT-168 | Promover slice MVP 3 a `qa` | done | sales-db [#21](https://github.com/code-corhuila/opti-sales-db/pull/21) · sales-api [#19](https://github.com/code-corhuila/opti-sales-api/pull/19) · sales-portal [#20](https://github.com/code-corhuila/opti-sales-portal/pull/20) · gateway [#18](https://github.com/code-corhuila/opti-api-gateway/pull/18) · front [#31](https://github.com/code-corhuila/opti-front/pull/31) |
| HU-OPT-169 | Abrir `release/3.0.0` → `main` | doing | sales-db [#22](https://github.com/code-corhuila/opti-sales-db/pull/22) · sales-api [#20](https://github.com/code-corhuila/opti-sales-api/pull/20) · sales-portal [#21](https://github.com/code-corhuila/opti-sales-portal/pull/21) · gateway [#19](https://github.com/code-corhuila/opti-api-gateway/pull/19) · front [#32](https://github.com/code-corhuila/opti-front/pull/32) |
| HU-OPT-170 | Retirar credenciales demo fijas (`auth-db` V019) | doing | [#19](https://github.com/code-corhuila/opti-auth-db/pull/19) (CI rojo) |

## 2. Mi contribución individual

> **Autor:** Juan Diego Tovar Rodriguez / `jdtovar07`.  
> Commits del slice PDF/pagos: míos. Promoción Git Flow: develop → qa hechos; release/3.0.0 → main abiertos.

### Estado Git Flow (2026-11-10)

| Repo | develop | qa | main (`release/3.0.0`) |
|------|---------|-----|------------------------|
| sales-db / sales-api / sales-portal / gateway / front | mergeado | mergeado | **OPEN** |
| products-* / customers-* (compañero) | mergeado | mergeado | **OPEN** |

### Follow-up seguridad

- `opti-auth-db` [#19](https://github.com/code-corhuila/opti-auth-db/pull/19) + `opti-infra` [#7](https://github.com/code-corhuila/opti-infra/pull/7) — abiertos; sin mergear para no romper demo `OptiView2026`.

### Notas

| Artefacto | Qué cubre |
|-----------|-----------|
| testing-at-scale *.md/.png | Pirámide, contratos, E2E, load, chaos |
| release-shipping-mvp3 *.md/.png | Checklist production-grade MVP 3 |

### Ceremonias

| Ceremonia | Evidencia |
|-----------|-----------|
| Planning | Kickoff testing + MVP 3 + track PDF |
| Daily | develop → qa → abrir release/3.0.0 |
| Review | Demo local desde develop |
| Retro | develop+qa listos; falta main/tag + contratos/E2E |
| PRs por ambiente | feat→develop done · qa done · release→main open |

## 3. Bloqueadores y riesgos

- PRs `release/3.0.0` → `main` aún abiertos (sin tag `v3.0.0`).
- auth-db #19 CI fallido.
- Sin suite de contratos / E2E / load sistemáticos.

## 4. Plan para la próxima semana

- Merge a `main` + tag `v3.0.0`.
- Resolver CI auth-db #19 tras la ventana de demo.
- Plan mínimo contract + E2E smoke del journey de pago/PDF.

## 5. Autochequeo

- [x] Conventional Commits
- [x] PR por ambiente
- [x] Criterios testeables
- [x] Tests
- [x] DDD / hexagonal
- [x] Sin secretos

## 6. Evidencia

- Notas week-15 (este directorio)
- develop: sales-db #20, sales-api #18, sales-portal #19, gateway #17, front #30
- qa: sales-db #21, sales-api #19, sales-portal #20, gateway #18, front #31
- release→main OPEN: sales-db #22, sales-api #20, sales-portal #21, gateway #19, front #32
- auth-db #19 (open)
