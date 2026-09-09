<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       06-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 06

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Documentar fundamentos de Docker Compose y orquestación, planear ambientes y estrategia de configuración de OptiView después del MVP 1, participar en la retrospectiva multi-equipo en clase, y definir el layout de repositorios para el camino evolutivo más allá del primer MVP.
<!-- CONFIG-END -->

> **Entrega Semana 06 — bases operativas post-MVP 1.** Después de presentar el MVP 1 (Semana 05), esta semana se centra en **cómo corremos y evolucionamos la plataforma**: notas de Docker Compose / orquestación, planeación de ambientes y configuración para OptiView, **retrospectiva en clase con todos los equipos de trabajo**, y el **mapa de repos** para el corte evolutivo del MVP 1 (monolito → microservicios).

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-055 | Documentar fundamentos de Docker Compose y orquestación de contenedores | done | [`docker-compose-orchestration-basics.md`](./docker-compose-orchestration-basics.md) |
| HU-OPT-056 | Elaborar resumen visual de Docker Compose / orquestación | done | [`docker-basics.png`](./docker-basics.png) |
| HU-OPT-057 | Documentar planeación de ambientes, estrategia de configuración y orquestación | done | [`planning-environments-config-orchestration.md`](./planning-environments-config-orchestration.md) |
| HU-OPT-058 | Elaborar resumen visual de planeación de ambientes / config / orquestación | done | [`planning-environments-config-orchestration.png`](./planning-environments-config-orchestration.png) |
| HU-OPT-059 | Participar en la retrospectiva de clase que cubrió todos los equipos de trabajo | done | Ver §2 — Retrospectiva en clase |
| HU-OPT-060 | Definir el layout de repositorios para el camino evolutivo del MVP 1 | done | Ver §2 — Repos evolutivos del MVP |

## 2. Mi contribución individual

> **Alcance esta semana:** documentación DevOps / plataforma y planeación de equipo — **no** código nuevo de features. Parte del MVP 1 (`optiview-platform` tag `v1.0.0`) de la Semana 05.

### Notas de estudio y visuales

| Artefacto | Qué cubre |
|-----------|-----------|
| [`docker-compose-orchestration-basics.md`](./docker-compose-orchestration-basics.md) | Apps multi-contenedor, `docker-compose.yml`, redes, volúmenes, env vars, comandos Compose, Compose vs Kubernetes, buenas prácticas |
| [`docker-basics.png`](./docker-basics.png) | Resumen visual de Docker Compose / orquestación |
| [`planning-environments-config-orchestration.md`](./planning-environments-config-orchestration.md) | Dev / Test / Staging / Production, flujo de promoción, separación de config, secretos, feature flags, conceptos de orquestación (escala, LB, self-healing, discovery) |
| [`planning-environments-config-orchestration.png`](./planning-environments-config-orchestration.png) | Resumen visual de planeación de ambientes + config + orquestación |

### Mapeo a OptiView (después del MVP 1)

El MVP 1 ya corre en local con `docker compose up --build` (frontend + monolito Java + PostgreSQL). Las notas de esta semana enmarcan la **siguiente evolución**:

| Tema | Aplicación en OptiView |
|------|------------------------|
| Compose | Mantener Compose para trabajo local multi-servicio al extraer microservicios |
| Ambientes | Alinear con el Git Flow ya practicado: `develop` → `qa` → `main` (dev / qa / prod) |
| Configuración | Sin secretos en el repo; variables de entorno / almacén de secretos por ambiente |
| Orquestación | Compose para local/dev; orquestación tipo Kubernetes como objetivo de producción más adelante |

### Retrospectiva en clase — todos los equipos de trabajo

En clase hicimos una **retrospectiva que cubrió todos los equipos de trabajo** (no solo The Illusionists). Cada equipo compartió qué salió bien y qué mejorar después del primer corte MVP.

| Foco | Resultado para OptiView / The Illusionists |
|------|---------------------------------------------|
| Qué salió bien | MVP 1 entregado y presentado (SPA frontend + backend monolito + demo en vivo) |
| Qué mejorar | División de trabajo más clara al salir del monolito; mayor disciplina de ambientes/config |
| Decisión | Tratar el MVP 1 como **línea base** y planear un camino **evolutivo** (repos + servicios) en lugar de un rewrite big-bang |

### MVP evolutivo — layout de repositorios definido

**Definimos los repositorios** que llevarán la progresión evolutiva del primer MVP (monolito → servicios por bounded context), alineados con el mapa de dominio canónico en `opti-docs` (`ms-pacientes` / `ms-inventario` / `ms-ordenes` / `ms-facturacion`):

| Repositorio (planeado / definido) | Rol en la evolución |
|-----------------------------------|---------------------|
| `optiview-platform` | Línea base MVP 1 (monolito modular + SPA React) — sigue como referencia ejecutable |
| `opti-docs` | SSOT documental (dominio, gobernanza, contratos API) |
| `ms-pacientes` | Bounded context Pacientes (extraer del monolito) |
| `ms-inventario` | Bounded context Inventario / monturas y lentes |
| `ms-ordenes` | Bounded context Órdenes de trabajo |
| `ms-facturacion` | Bounded context Facturación |
| `api-gateway` | Punto de entrada único para la SPA cuando se dividan los servicios |
| Frontend SPA | Sigue como cliente React; más adelante apunta al gateway en lugar del `/api` del monolito |

Este layout soporta **extracción incremental**: mantener el MVP 1 funcionando mientras cada `ms-*` se separa con su propio Git Flow (`feature` → `develop` → `qa` → `main`).

## 3. Bloqueadores y riesgos

- Los repos evolutivos están **definidos** esta semana; scaffolds de servicio y CI por repo aún faltan.
- Compose alcanza para el MVP local; orquestación de producción (K8s) está documentada a nivel conceptual, no desplegada.
- La estrategia de config/secretos está documentada; el equipo aún debe elegir un secret-store concreto para ambientes compartidos.

## 4. Plan para la próxima semana

- Empezar scaffolds de los primeros repos evolutivos (`ms-*` / gateway) según el layout de arriba.
- Alinear docs OpenAPI / eventos en `opti-docs` con el orden de extracción.
- Mantener el stack Compose local como arnés de integración mientras se dividen servicios.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [ ] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [ ] Tests agregados/actualizados (unit / integration)
- [ ] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: La Semana 06 es documentación + planeación de plataforma (Compose, ambientes, config, retrospectiva, mapa de repos). Sin código de aplicación ni ramas HU esta semana — los ítems sin marcar aplican cuando los repos evolutivos empiecen a recibir código. Separación de configuración y “sin secretos en el repo” están explícitos en las notas de planeación.

## 6. Enlaces de evidencia

**Fork del curso (docs Semana 06):**

- Notas Docker Compose / orquestación: [`docker-compose-orchestration-basics.md`](./docker-compose-orchestration-basics.md)
- Visual Docker Compose: [`docker-basics.png`](./docker-basics.png)
- Planeación ambientes / config / orquestación: [`planning-environments-config-orchestration.md`](./planning-environments-config-orchestration.md)
- Visual de planeación: [`planning-environments-config-orchestration.png`](./planning-environments-config-orchestration.png)

**Trabajo previo relacionado:**

- Plataforma MVP 1 (Semana 05): https://github.com/jdtovar07/optiview-platform (tag `v1.0.0`)
- Mapa de dominio (4 microservicios): https://github.com/jdtovar07/opti-docs/blob/main/02-domain/domain-map.md
