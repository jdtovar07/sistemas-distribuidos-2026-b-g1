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
- SPRINT_GOAL: Documentar testing at scale y release MVP 3; aterrizar factura PDF en `develop` → `qa` → `main` con tag `v3.0.0`; sincronizar tablero; exponer el proyecto; completar certificación C3; reportar tarde el avance C3 de Semanas 13–14.
<!-- CONFIG-END -->

> **Ventana de la semana:** lunes **2026-11-09** → domingo **2026-11-15**.  
> **Entrega:** notas + MVP 3 + slice PDF **`main` + `v3.0.0` (2026-11-15)** + exposición + C3 cerrada + late-report W13/W14.

## 1. Historias de usuario trabajadas esta semana

### A. Esta semana (lun 2026-11-09 → dom 2026-11-15)

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
| HU-OPT-168 | Promover slice MVP 3 a `qa` | done | PRs qa + tablero [#76](https://github.com/code-corhuila/opti-docs/issues/76) |
| HU-OPT-169 | Merge `release/3.0.0` → `main` + tag `v3.0.0` | done | merges 2026-11-15 + tags · tablero [#77](https://github.com/code-corhuila/opti-docs/issues/77) |
| HU-OPT-170 | Retirar credenciales demo fijas (`auth-db` V019) | doing | auth-db [#19](https://github.com/code-corhuila/opti-auth-db/pull/19) + tablero [#78](https://github.com/code-corhuila/opti-docs/issues/78) |
| HU-OPT-171 | [backlog] Plan contract-tests place-order + PDF | todo | [#79](https://github.com/code-corhuila/opti-docs/issues/79) |
| HU-OPT-172 | [backlog] E2E smoke login → PDF | todo | [#80](https://github.com/code-corhuila/opti-docs/issues/80) |
| HU-OPT-173 | Exponer el proyecto OptiView completo al profesor (video + expo + Q&A) | done | Sesión en clase — ver § Exposición |
| HU-OPT-174 | Completar capítulos 9–14 + bitácora C3 | done | [`certification/`](../../certification/) evidencia `09`…`14` |
| HU-OPT-175 | Aprobar examen final y obtener certificado C3 | done | 76/100 · [`19-final-exam.png`](../../certification/evidence/19-final-exam.png) · [`certificate.pdf`](../../certification/certificate.pdf) |
| HU-OPT-176 | Nota de diseño + ADRs mapeando curso → OptiView | done | [`architecture-design-note.md`](../../certification/design/architecture-design-note.md) · ADR-C3-01/02 · diagrama |

### B. Reporte tardío Semanas 13–14 (no figuró en esos HU-status)

> La certificación **empezó en Semana 13** (31-oct) y siguió en **Semana 14** (caps. 1–8, 3–5 nov). Los HU-status de [`13-week`](../../13-week/hu-status/README.md) y [`14-week`](../../14-week/hu-status/README.md) **no mencionan C3**. Aquí solo se hace visible; el cierre (9–14, examen, certificado) es trabajo real de Semana 15 (§A).

| HU ID | Título | Estado | Cuándo | Evidencia |
|---|---|---|---|---|
| HU-OPT-177 | [tarde W13] Inscripción + inicio C3 | done | Semana 13 — **2026-10-31** | [`00-enrollment.png`](../../certification/evidence/00-enrollment.png) |
| HU-OPT-178 | [tarde W14] Capítulos 1–8 C3 | done | Semana 14 — **2026-11-03 → 05** | [`01`](../../certification/evidence/01-chapter-01.png)…[`08`](../../certification/evidence/08-chapter-08.png) |

## 2. Mi contribución individual

> **Autor:** Juan Diego Tovar Rodriguez / `jdtovar07`.  
> Slice PDF/pagos; Git Flow develop→qa + release abierto; exposición; **certificación C3 Huawei completada** esta semana.

### Exposición en clase (esta semana)

The Illusionists presentó el **proyecto OptiView completo** ante el profesor:

1. **Video** — apertura con demo del sistema integrado.
2. **Exposición en vivo** — recorrido del sistema (arquitectura, Git Flow, MVP 2→3 con factura PDF / pagos).
3. **Preguntas** — el profesor lanzó **dos preguntas a cada integrante** (defensa individual tras la expo de equipo).

Participé en la presentación del equipo y respondí las dos preguntas individuales.

### Certificación C3 — Huawei ICT Academy

Track **HCCDP Solution Architectures** en [`certification/`](../../certification/) (inicio **2026-10-31** → cierre **2026-11-12**; **42 h**).

- **Semanas 13–14 (no estaban en esos HU-status → §B):** inscripción + caps. 1–8.
- **Semana 15 (§A):** caps. 9–14, examen **76/100**, [`certificate.pdf`](../../certification/certificate.pdf), nota de diseño + ADRs.

### Estado Git Flow (2026-11-10)

| Repo | develop | qa | main + `v3.0.0` |
|------|---------|-----|------------------|
| sales-db / sales-api / sales-portal / gateway / front | mergeado | mergeado | **mergeado + tag (15-nov)** |
| products-* / customers-* (compañero) | mergeado | mergeado | **mergeado + tag** |

### Follow-up seguridad

- `opti-auth-db` [#19](https://github.com/code-corhuila/opti-auth-db/pull/19) + `opti-infra` [#7](https://github.com/code-corhuila/opti-infra/pull/7) — abiertos; sin mergear para no romper demo `OptiView2026`.

### Notas

| Artefacto | Qué cubre |
|-----------|-----------|
| testing-at-scale *.md/.png | Pirámide, contratos, E2E, load, chaos |
| release-shipping-mvp3 *.md/.png | Checklist production-grade MVP 3 |

### Tablero y backlog

| Tablero | URL |
|---------|-----|
| opti-board | https://github.com/orgs/code-corhuila/projects/3 |
| Opti View — Backlog | https://github.com/orgs/code-corhuila/projects/15 |

| Status | Cards semana 15 |
|--------|-----------------|
| Done | Producto [#65](https://github.com/code-corhuila/opti-docs/issues/65)–[#70](https://github.com/code-corhuila/opti-docs/issues/70) · estudio/qa/release [#72](https://github.com/code-corhuila/opti-docs/issues/72)–[#77](https://github.com/code-corhuila/opti-docs/issues/77) |
| Blocked | [#78](https://github.com/code-corhuila/opti-docs/issues/78) auth-db V019 |
| Backlog | [#79](https://github.com/code-corhuila/opti-docs/issues/79) contratos · [#80](https://github.com/code-corhuila/opti-docs/issues/80) E2E |

### Ceremonias

| Ceremonia | Evidencia |
|-----------|-----------|
| Planning | Kickoff testing + MVP 3 + tablero + prep expo |
| Daily | develop → qa → merge release + tag `v3.0.0` (dom 15-nov) |
| Review | **Expo al profesor:** video → exposición → dos preguntas por integrante |
| Retro | MVP 3 en `main`/`v3.0.0`; #79/#80 backlog; auth-db #19 abierto |
| PRs por ambiente | feat→develop done · qa done · release→main **done** + tag |
| Board sync | Issues en `opti-docs` + projects/3 y /15 |

## 3. Bloqueadores y riesgos

- auth-db #19 / infra #7 siguen abiertos (CI).
- Sin suite de contratos / E2E / load sistemáticos.

## 4. Plan para la próxima semana

- Resolver CI auth-db #19 / infra #7.
- Plan mínimo contract + E2E smoke (#79/#80).
- Opcional: zips/`release notes` de `v3.0.0` si el curso pide paquete Corte-3.

## 5. Autochequeo

- [x] Conventional Commits
- [x] PR por ambiente
- [x] Criterios testeables
- [x] Tests
- [x] DDD / hexagonal
- [x] Sin secretos

## 6. Evidencia

- Notas week-15 (este directorio)
- develop / qa / **main + `v3.0.0`** (ver README.md EN; merges 2026-11-15)
- Tableros: [projects/3](https://github.com/orgs/code-corhuila/projects/3) · [projects/15](https://github.com/orgs/code-corhuila/projects/15)
- Cards Done hasta [#77](https://github.com/code-corhuila/opti-docs/issues/77); blocked [#78](https://github.com/code-corhuila/opti-docs/issues/78); backlog [#79](https://github.com/code-corhuila/opti-docs/issues/79)/[#80](https://github.com/code-corhuila/opti-docs/issues/80)
- Certificación C3: [`certification/README.md`](../../certification/README.md) · certificado + diseño (Semana 15)
- Late-report: inscripción/caps. 1–8 **no** estaban en [`13-week`](../../13-week/hu-status/README.md) ni [`14-week`](../../14-week/hu-status/README.md) — declarados aquí (§B)
