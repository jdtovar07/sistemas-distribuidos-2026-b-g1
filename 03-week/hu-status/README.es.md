

```
 ni las cabeceras de tabla.
 ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
   03-week/hu-status/README.md  (dentro de TU fork).
 Este archivo es una copia en español para lectura y no se califica. -->
```

# Estado Semanal - Semana 03



- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Adaptar los documentos de gobernanza de OptiView en el repositorio SSOT opti-docs, y exponer al profesor y al salón de clase el avance acumulado de las Semanas 01–03 — incluyendo la idea inicial del proyecto y el PRD.



## 1. Historias de usuario trabajadas esta semana


| HU ID      | Título                                                                                | Estado (todo/doing/done) | Evidencia (URL de PR o commit)                                                                                                                                                   |
| ---------- | ------------------------------------------------------------------------------------- | ------------------------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| HU-OPT-035 | Adaptar reglas de documentación para OptiView en `opti-docs/00-governance/`           | done                     | [https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded](https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded) |
| HU-OPT-036 | Adaptar el estándar de documentación por microservicio para los servicios OptiView    | done                     | [https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded](https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded) |
| HU-OPT-037 | Adaptar la política de seguridad (Keycloak JWT, RBAC, OWASP) para OptiView            | done                     | [https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded](https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded) |
| HU-OPT-038 | Adaptar las reglas técnicas de seguridad (controles Java + Go) para OptiView          | done                     | [https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded](https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded) |
| HU-OPT-039 | Exponer al profesor y al salón el avance acumulado Semanas 01–03 y el PRD de OptiView | done                     | `[01-week/hu-status/prd.md](../../01-week/hu-status/prd.md)`                                                                                                                     |


## 2. Mi contribución individual

- **Expuse ante el profesor y el salón de clase** los temas y entregables acumulados en las Semanas 01–03: la idea inicial del proyecto OptiView y el **brief de producto / PRD** (`[prd.md](../../01-week/hu-status/prd.md)`) del bounded context Órdenes de Trabajo (`ms-ordenes`); los fundamentos arquitectónicos de la Semana 01 (mapa de contextos, Saga para creación distribuida de órdenes, boceto de capas hexagonales, justificación Go vs. Java en ADR-001); la práctica Agile y Git Flow de la Semana 02 (brief Scrum & Kanban, evidencia del sandbox Git Flow, primeras HUs HU-01 y HU-02 en el tablero The Illusionists); y el trabajo de gobernanza de la Semana 03 en `opti-docs` (reglas de documentación, estándar por microservicio, política de seguridad y reglas técnicas de seguridad).
- Estudié el material de la sesión de la Semana 03 sobre la **estructura del repositorio de documentación** (`[estructura-repositorio-docs.md](../01-session/estructura-repositorio-docs.md)`): carpetas numeradas `00`–`15`, patrón SSOT, README por sección, convenciones `_template-*.md` y la capa de gobernanza en `00-governance/`.
- Cloné y revisé el repositorio del equipo `**opti-docs**` (`[jdtovar07/opti-docs](https://github.com/jdtovar07/opti-docs)`) — el SSOT documental de OptiView, separado del fork del curso — e identifiqué los archivos de gobernanza del scaffold que aún usaban placeholders genéricos.
- Redacté `**documentation-rules-opti.md**`: política de idioma (inglés para código/docs, español para títulos de HU y etiquetas de UI), nomenclatura kebab-case, dueños por sección para el equipo Illusionists de 5 personas, qué documentar vs. qué no documentar, y el proceso de actualización ligado al Definition of Done.
- Redacté `**microservices-documentation-opti.md**`: registro de servicios OptiView con nombres concretos (`api-gateway`, `ms-pacientes`, `ms-inventario`, `ms-ordenes`, `ms-facturacion`), puertos, esquemas de BD, stack por servicio (Java 21 + Spring Boot 3 vs. Go 1.22), documentos obligatorios por servicio (README, data-model, events, runbook) y reglas API-first con contratos OpenAPI.
- Redacté `**security-policy-opti.md**`: principios de seguridad (Defense in Depth, Least Privilege, Zero Trust entre microservicios), autenticación Keycloak + JWT (RS256, access 1 h / refresh 7 d), roles RBAC mapeados a actores reales de OptiView (`RECEPCIONISTA`, `OPTOMETRA`, `VENDEDOR`, `OPERADOR_LABORATORIO`, etc.), modelo de permisos `[recurso]:[acción]`, gestión de secretos, validación de entradas, checklist OWASP Top 10 y SLAs de remediación de vulnerabilidades.
- Redacté `**security-rules-opti.md**`: controles concretos OWASP Top 10 con ejemplos de código Java (Spring Security, JPA) y Go (middleware HTTP) para los servicios OptiView; verificación JWT en la capa Use Case (regla hexagonal); límites de paginación; validación de esquema en mensajes RabbitMQ; fijado de dependencias y requisitos de logging de seguridad.
- Usé el sufijo `**-opti**` en los cuatro archivos para que los documentos adaptados por el equipo convivan con las plantillas originales del scaffold (`documentation-rules.md`, `microservices-documentation.md`, etc.) sin sobrescribirlas.
- Hice commit de los cuatro documentos de gobernanza en `opti-docs` con Conventional Commits: `docs(governance): add OptiView-specific governance documents` — commit `[38346918c11999439328610c46d826860b489ded](https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded)`.

## 3. Bloqueadores y riesgos

- Ítems abiertos de Semana 01 / 02: timeout de reserva de stock para HU-OPT-020; ramas `develop` y `qa` aún no creadas en el repositorio grupal / de código OptiView.
- Los documentos de gobernanza están adaptados en `opti-docs` pero aún no ratificados por todo el equipo Illusionists — los cambios en `00-governance/` requieren acuerdo del equipo según las propias reglas de documentación.
- Varios ítems marcados como **⚠️ Pendiente de definición por el equipo** dentro de los nuevos documentos (estrategia de cifrado en reposo, proveedor TLS/CA, stack de alertas, canal de notificación de vulnerabilidades) — riesgo de bloquear criterios de despliegue a QA hasta resolverlos.
- Aún no hay código de producción ni tests de dominio para `ms-ordenes`; los límites hexagonales están documentados en la política pero aún no aplicados en código.

## 4. Plan para la próxima semana

- Modelar la capa táctica DDD de `ms-ordenes`: agregado `WorkOrder`, value object `OrderState`, eventos de dominio e invariantes de la máquina de estados.
- Esbozar la estructura de paquetes hexagonal en Go (`domain` / `application` / `infrastructure`) y definir los contratos REST + eventos para la creación de órdenes.
- Documentar la propiedad de datos (`orders_schema`) y agregar el primer contrato OpenAPI de `ms-ordenes` en `opti-docs/07-api/contracts/openapi/`.
- Implementar el agregado `WorkOrder` con tests unitarios para transiciones de estado ilegales.
- Resolver el timeout de reserva de stock con el equipo y agregarlo como criterio de aceptación verificable para HU-OPT-020.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [ ] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [ ] Criterios de aceptación verificables
- [ ] Tests agregados/actualizados (unit / integration)
- [ ] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas sobre los ítems no marcados:

- Conventional Commits usados en `opti-docs`: `docs(governance): add OptiView-specific governance documents`.
- El trabajo de esta semana fue solo documentación en el repo separado `opti-docs`; no hubo rama HU a `develop` en el fork del curso.
- Criterios de aceptación y tests para `ms-ordenes` están planificados para la Semana 04; las reglas hexagonales y DDD ya están escritas en gobernanza pero aún no materializadas en código Go.
- No se committearon secretos; la política de seguridad prohíbe explícitamente credenciales en código fuente, `.env` o logs.

## 6. Enlaces de evidencia

- Commit de gobernanza (4 documentos OptiView): [https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded](https://github.com/jdtovar07/opti-docs/commit/38346918c11999439328610c46d826860b489ded)
- Repositorio `opti-docs`: [https://github.com/jdtovar07/opti-docs](https://github.com/jdtovar07/opti-docs)
- Archivos adaptados en `00-governance/`:
  - `[documentation-rules-opti.md](https://github.com/jdtovar07/opti-docs/blob/main/00-governance/documentation-rules-opti.md)`
  - `[microservices-documentation-opti.md](https://github.com/jdtovar07/opti-docs/blob/main/00-governance/microservices-documentation-opti.md)`
  - `[security-policy-opti.md](https://github.com/jdtovar07/opti-docs/blob/main/00-governance/security-policy-opti.md)`
  - `[security-rules-opti.md](https://github.com/jdtovar07/opti-docs/blob/main/00-governance/security-rules-opti.md)`
- Material de sesión Semana 03 (estructura del repo de documentación): `[estructura-repositorio-docs.md](../01-session/estructura-repositorio-docs.md)`
- Brief de producto / PRD OptiView (expuesto en clase): `[01-week/hu-status/prd.md](../../01-week/hu-status/prd.md)`
- Evidencia Semana 01 (arquitectura y status): `[01-week/hu-status/README.md](../../01-week/hu-status/README.md)`
- Evidencia Semana 02 (Scrum, Git Flow y backlog): `[02-week/hu-status/README.md](../../02-week/hu-status/README.md)`
- Tablero The Illusionists: [https://github.com/orgs/TheIllusionists/projects/1](https://github.com/orgs/TheIllusionists/projects/1)

