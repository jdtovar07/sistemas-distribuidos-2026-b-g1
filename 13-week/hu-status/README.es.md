<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       13-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 13

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Documentar autenticación, autorización y Zero Trust en sistemas distribuidos; documentar threat modeling (STRIDE) y el security backlog; y mapear ambos al choke point JWT del gateway de OptiView, SERVICE_TOKEN de worker/workflow y prioridades de hardening post–MVP 2.
<!-- CONFIG-END -->

> **Ventana de la semana:** lunes **2026-10-26** → domingo **2026-11-01** (cada semana del curso es lun–dom).  
> **Entrega Semana 13:** (1) notas + visuales de **authn / authz / Zero Trust**, y (2) **threat modeling + security backlog**, mapeados al MVP 2 de OptiView.

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-149 | Documentar seguridad — AuthN, AuthZ y Zero Trust | done | [`security-authn-authz-zero-trust.md`](./security-authn-authz-zero-trust.md) |
| HU-OPT-150 | Elaborar resumen visual de AuthN / AuthZ / Zero Trust | done | [`security-authn-authz-zero-trust-vertical.png`](./security-authn-authz-zero-trust-vertical.png) |
| HU-OPT-151 | Documentar threat modeling y el security backlog | done | [`threat-modeling-security-backlog.md`](./threat-modeling-security-backlog.md) |
| HU-OPT-152 | Elaborar resumen visual de threat modeling / security backlog | done | [`threat-modeling-security-backlog-vertical.png`](./threat-modeling-security-backlog-vertical.png) |

## 2. Mi contribución individual

> **Autor:** Juan Diego Tovar Rodriguez / `jdtovar07` (`jdtovar-2021a@corhuila.edu.co`).  
> **Alcance Semana 13 (lun–dom):** notas y visuales de seguridad; mapeo a OptiView (identidad en el borde y amenazas en límites de confianza).

### Notas de estudio y visuales

| Artefacto | Qué cubre |
|-----------|-----------|
| [`security-authn-authz-zero-trust.md`](./security-authn-authz-zero-trust.md) | AuthN vs AuthZ; JWT / OAuth2 / OIDC; gateway; confianza servicio-a-servicio; Zero Trust; vulnerabilidades comunes |
| [`security-authn-authz-zero-trust-vertical.png`](./security-authn-authz-zero-trust-vertical.png) | Resumen visual |
| [`threat-modeling-security-backlog.md`](./threat-modeling-security-backlog.md) | Cuatro preguntas, DFD / trust boundaries, STRIDE, riesgo, mitigaciones, backlog |
| [`threat-modeling-security-backlog-vertical.png`](./threat-modeling-security-backlog-vertical.png) | Resumen visual |

### Mapeo a OptiView

| Concepto | Dónde aparece |
|----------|---------------|
| AuthN / AuthZ | `opti-auth-api` emite JWT RS256; roles/claims; Bearer vía gateway |
| Choke point | `opti-api-gateway` único entry API público (además del front) |
| Servicio-a-servicio | `SERVICE_TOKEN` para worker/workflow (`.env` local, nunca en git) |
| Zero Trust (dirección) | La red Docker `platform` no es “interior seguro”; cada hop con identidad verificable |
| Backlog candidatos | Secret store qa/main; rotar SERVICE_TOKEN; rate limit gateway; no loguear tokens; tokens de servicio más estrictos |

### Ceremonias y flujo (esta semana)

| Ceremonia | Cuándo / evidencia |
|-----------|--------------------|
| Planning | Kickoff: AuthN/AuthZ/Zero Trust + threat modeling; mapear a gateway / JWT / SERVICE_TOKEN |
| Daily | Async: avance de notas; candidatos de security backlog |
| Review | Límites de confianza OptiView vs STRIDE |
| Retro | Secretos fuera de git; claves develop solo no-prod; siguiente: top STRIDE → tickets con dueño |
| PRs por ambiente | Semana de estudio — sin PRs de producto nuevos |

## 3. Bloqueadores y riesgos

- Secret store compartido sin decidir; rotación de tokens en ambientes compartidos indefinida; IdP OIDC aún no es el camino actual; threat model en papel pendiente de tickets en el board.

## 4. Plan para la próxima semana

- Top 3 mitigaciones STRIDE al board (secret store, rate limit gateway, no-token-in-logs).
- Seguir plan del taller → código real (`traceparent` + logs JSON sin secretos).
- Opcional: matriz de claims/roles JWT en `opti-docs`.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [x] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [x] Tests agregados/actualizados (unit / integration)
- [x] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: Ventana lun–dom. Semana de estudio de seguridad tras workshop/deploy Semana 12. `feat/*` por acuerdo. HU-status en `main`.

## 6. Enlaces de evidencia

- Docs de esta carpeta (4 artefactos)
- https://github.com/code-corhuila/opti-auth-api · https://github.com/code-corhuila/opti-api-gateway · https://github.com/code-corhuila/opti-infra
- Semana 12: [`12-week/hu-status/README.md`](../../12-week/hu-status/README.md)
