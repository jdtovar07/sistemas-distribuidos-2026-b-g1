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
- SPRINT_GOAL: Documentar modelos de despliegue en la nube y estrategias zero-downtime (rolling / blue-green / canary); documentar el plan de despliegue, Infrastructure as Code y el ciclo de rollback; y mapear ambos al Git Flow de OptiView (develop → qa → release → main), imágenes GHCR, rollbacks Flyway y tags SemVer tras MVP 2.
<!-- CONFIG-END -->

> **Ventana de la semana:** lunes **2026-10-19** → domingo **2026-10-25** (cada semana del curso es lun–dom).  
> **Entrega Semana 12:** (1) notas + visuales de **despliegue en la nube** y **plan de despliegue / IaC / rollback**, y (2) mapeo a OptiView sobre el camino de release del MVP 2.

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-143 | Documentar despliegue en la nube — modelos, estrategias y zero-downtime | done | [`cloud-deployment-models-strategies.md`](./cloud-deployment-models-strategies.md) |
| HU-OPT-144 | Elaborar resumen visual de modelos / estrategias de cloud deployment | done | [`cloud-deployment-models-strategies-vertical.png`](./cloud-deployment-models-strategies-vertical.png) |
| HU-OPT-145 | Documentar plan de despliegue, Infrastructure as Code y rollback | done | [`deployment-plan-iac-rollback.md`](./deployment-plan-iac-rollback.md) |
| HU-OPT-146 | Elaborar resumen visual de plan de despliegue / IaC / rollback | done | [`deployment-plan-iac-rollback-vertical.png`](./deployment-plan-iac-rollback-vertical.png) |

## 2. Mi contribución individual

> **Autor:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Alcance Semana 12 (lun–dom):** notas y visuales de cloud deployment + IaC/rollback, mapeadas a cómo OptiView ya shippea el MVP 2.

### Notas de estudio y visuales (esta semana)

| Artefacto | Qué cubre |
|-----------|-----------|
| [`cloud-deployment-models-strategies.md`](./cloud-deployment-models-strategies.md) | IaaS / PaaS / containers / serverless; registry → orquestador → LB → health checks; rolling / blue-green / canary; escala horizontal / autoscaling |
| [`cloud-deployment-models-strategies-vertical.png`](./cloud-deployment-models-strategies-vertical.png) | Resumen visual de esos conceptos |
| [`deployment-plan-iac-rollback.md`](./deployment-plan-iac-rollback.md) | Plan escrito, IaC declarativo, checklist pre-deploy, triggers de rollback, Plan → Provision → Deploy → Verify → Keep/Rollback |
| [`deployment-plan-iac-rollback-vertical.png`](./deployment-plan-iac-rollback-vertical.png) | Resumen visual del ciclo de release seguro |

### Mapeo a OptiView (cómo aterrizan los conceptos del MVP 2)

| Concepto | Dónde aparece en OptiView |
|----------|---------------------------|
| Contenedores + registry | Cada servicio `opti-*` construye imagen Docker; CI publica a **GHCR** en push a `develop` |
| Compose local como plataforma | `opti-infra` hace `include` de los `deploy/compose.yml` hermanos en la red `platform` |
| Promoción por ambiente | Git Flow: `feat/*` → `develop` → `qa-*` → `release/x.y.z` → `main` con **un PR por ambiente** |
| Entrega progresiva | Notas Semana 09 + framing en `opti-docs`; rings/flags antes del cutover total |
| Artefactos versionados | Tags SemVer `v2.0.0` (19 repos) y `v2.1.0` (tips post-seed) |
| Cambios de DB reversibles | Flyway `V*` + `U*` en `05_rollbacks/` (p. ej. seeds demo) |
| Trigger de rollback | Health/smoke fallido tras promover → redesplegar tag anterior o revertir el PR de ambiente |
| Observabilidad en el release | `otel-collector` / Prometheus / Grafana en `opti-infra` (Semana 11) para verificar el corte |

### Continuidad

| Semana | Qué ya tenemos | Cómo lo usa la Semana 12 |
|--------|----------------|--------------------------|
| 11 | Observabilidad + SLI/SLO; expo MVP 2 | Verificar / decidir rollback con esas señales |
| 10 | MVP 2 taggeado; seeds vía `release/2.1.0` → main | Ejemplo concreto de corte planeado y versionado |
| 09 | Progressive delivery + scaffolds | Vocabulario (canary / rings) encuentra el Git Flow real |

### Ceremonias y flujo (esta semana)

| Ceremonia | Cuándo / evidencia |
|-----------|--------------------|
| Planning | Kickoff lunes: notas cloud + IaC/rollback; mapear a Git Flow / GHCR / Flyway (`SPRINT_GOAL`) |
| Daily | Check-ins async: bloqueos en docs, alinear tags vs PRs de ambiente |
| Review | Recorrido de estrategias vs cómo promovemos OptiView (develop → qa → main) + evidencia de tags |
| Retro | Mantener un PR por ambiente; siempre dejar un tag SemVer previo alcanzable para rollback; siguiente: runbook corto promote/rollback en `opti-infra` |
| PRs por ambiente | Semana de estudio — sin PRs de producto nuevos. Evidencia de arrastre: products-db [#13](https://github.com/code-corhuila/opti-products-db/pull/13)/[#14](https://github.com/code-corhuila/opti-products-db/pull/14)/[#15](https://github.com/code-corhuila/opti-products-db/pull/15); auth-db [#10](https://github.com/code-corhuila/opti-auth-db/pull/10)–[#12](https://github.com/code-corhuila/opti-auth-db/pull/12); sales-db [#10](https://github.com/code-corhuila/opti-sales-db/pull/10)–[#12](https://github.com/code-corhuila/opti-sales-db/pull/12) |

## 3. Bloqueadores y riesgos

- El target cloud compartido (K8s gestionado vs PaaS) aún no es ADR de equipo — hoy el camino es Compose local + GHCR.
- Secret store para qa/main sin decidir (`opti-infra`).
- Blue-green/canary en cluster gestionado es vocabulario planificado; hoy la promoción es **ramas de ambiente + tags**, no dos clusters en vivo.
- Hay undos Flyway para seeds; no toda migración histórica tiene `U*` pareja aún.

## 4. Plan para la próxima semana

- Borrador de **runbook promote / rollback** de OptiView (orden: dbs → apis → portals → front/gateway).
- Candidato: documentar digests GHCR + mapeo tag → ambiente en `opti-docs`.
- Continuar emisión OTel / SLOs concretos del plan Semana 11 si hay capacidad.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [x] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [x] Tests agregados/actualizados (unit / integration)
- [x] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: Ventana lun–dom. Semana de estudio mapeando cloud/IaC al camino MVP 2. El equipo usa `feat/*` (no `hu-xxx-dev`) por acuerdo; un PR por ambiente al shippear producto. HU-status del fork en `main`.

## 6. Enlaces de evidencia

**Fork del curso (docs Semana 12):**

- [`cloud-deployment-models-strategies.md`](./cloud-deployment-models-strategies.md)
- [`cloud-deployment-models-strategies-vertical.png`](./cloud-deployment-models-strategies-vertical.png)
- [`deployment-plan-iac-rollback.md`](./deployment-plan-iac-rollback.md)
- [`deployment-plan-iac-rollback-vertical.png`](./deployment-plan-iac-rollback-vertical.png)

**Camino de release / deploy OptiView (entregado):**

- Tags: https://github.com/code-corhuila/opti-front/releases/tag/v2.0.0 · https://github.com/code-corhuila/opti-products-db/releases/tag/v2.1.0
- Compose infra: https://github.com/code-corhuila/opti-infra
- Progressive delivery / entornos: Semana 09 [`planning-secure-configuration-and-progressive-delivery.md`](../../09-week/hu-status/planning-secure-configuration-and-progressive-delivery.md) · [`opti-docs` 10-devops](https://github.com/code-corhuila/opti-docs/tree/main/10-devops)

**Trabajo previo:**

- Semana 11: [`11-week/hu-status/README.md`](../../11-week/hu-status/README.md)
- Semana 10: [`10-week/hu-status/README.md`](../../10-week/hu-status/README.md)
- Repos org: https://github.com/orgs/code-corhuila/repositories?q=opti
