<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       01-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 01

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: JuanDTovar
- TEAM: The Illusionists - PRJ-OPTIVIEW
- SPRINT_GOAL: Convertir el brief de OptiView en un mapa de contextos acotados para el dominio Órdenes, un product brief para ms-ordenes, el diseño de la Saga para el flujo distribuido de creación de órdenes y un backlog verificable de historias del ciclo de vida de órdenes de trabajo.
<!-- CONFIG-END -->

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-001 | Escribir el product brief (prd.md) para el bounded context de Órdenes de Trabajo | done | https://github.com/JuanDTovar/sistemas-distribuidos-2026-b-g1/commit/c83b050 |
| HU-OPT-005 | Definir mapa de contextos y lenguaje ubicuo para ms-ordenes | done | https://github.com/JuanDTovar/sistemas-distribuidos-2026-b-g1/commit/c83b050 |
| HU-OPT-006 | Diseñar la Saga para el flujo distribuido de creación de orden entre ms-pacientes, ms-inventario y ms-ordenes | doing | Rama hu-opt-006-dev aún no mergeada |
| HU-OPT-004 | Contribuir al ADR-001: justificación Go vs. Java para ms-ordenes | todo | Pendiente — rama hu-opt-004-dev no creada aún |

## 2. Mi contribución individual

- Escribí el product brief (`prd.md`) para el bounded context de Órdenes de Trabajo de OptiView: contexto inicial, necesidades y problemas, proceso actual, preguntas abiertas y glosario de negocio (OrdenDeTrabajo, EstadoOrden, Laboratorio, DetallesMontaje, Saga, eventos de dominio). Alcance explícito: `ms-ordenes` posee únicamente el ciclo de vida de la orden; no persiste datos clínicos de pacientes, niveles de inventario ni detalles de facturas.
- Definí el **mapa de bounded context para ms-ordenes**: Aggregate Root (`WorkOrder`), Value Objects (`AssemblyDetail`, `OrderState`), Entities (`Laboratory`, `OrderStatusEntry`) y Domain Events (`OrderCreated`, `OrderStatusChanged`, `OrderDelivered`). Confirmé que `ms-ordenes` consume `PatientDataValidated` de `ms-pacientes` y `StockReserved` de `ms-inventario` — nunca consulta sus bases de datos directamente.
- Apliqué el material de la Sesión 1: elaboré primero el **context map** — identificando que el dominio de Órdenes tiene su propia máquina de estados, sus propias reglas de asignación de laboratorio y sus propias semánticas de entrega, completamente independientes del registro clínico del paciente y del cálculo de facturación. La frontera se justifica por reglas de negocio reales.
- Contribuí al **ADR-001**: documenté la justificación de Go para `ms-ordenes` — las goroutines de Go y su modelo de concurrencia son ideales para los flujos orientados a eventos de alto throughput; Spring Boot Java para `ms-pacientes` y `ms-inventario` se justifica por el ecosistema DDD y JPA más rico para modelado de dominio complejo con enforcement de invariantes.
- Apliqué la **regla de extracción de microservicio**: Órdenes tiene frontera real (posee la máquina de estados y el ciclo de asignación al laboratorio) y necesidad real de despliegue (el equipo Go puede liberar cambios sin tocar los servicios Java). Ambas condiciones se cumplen — la decisión está documentada, no asumida.
- Diseñé la **Saga para creación de órdenes** usando coreografía de eventos (sin orquestador central): Paso 1 — `ms-pacientes` valida paciente y fórmula → emite `PatientDataValidated`; Paso 2 — `ms-inventario` consume, reserva stock → emite `StockReserved`; Paso 3 — `ms-ordenes` consume, crea `WorkOrder` → emite `OrderCreated`; Compensación — si algún paso falla, un evento compensatorio libera la reserva y notifica al vendedor. Cada paso usa llave de idempotencia `(orderId + stepName)` — aplicando el principio at-least-once + dedup de la Sesión 1.
- Bosquejé el **capeado hexagonal** para `ms-ordenes` (Go 1.22+): paquete `domain` sin imports de infraestructura; paquete `application` (casos de uso `CreateOrder`, `ChangeOrderStatus`, `AssignLaboratory`, `DeliverOrder`) que dependen solo de interfaces de repositorio; paquete `infrastructure` (`PostgresOrderRepository`, `RabbitMQEventPublisher`, `OrderHTTPHandler`) como único lugar que conoce `pgxpool`, AMQP o `net/http`.
- Derivé el **backlog inicial de ms-ordenes**: HU-OPT-020 (crear orden), HU-OPT-021 (avanzar estado), HU-OPT-022 (asignar laboratorio), HU-OPT-023 (registrar detalles de montaje), HU-OPT-024 (historial de órdenes por paciente).

## 3. Bloqueos y riesgos

- La pregunta abierta sobre el timeout de reserva de stock bloquea el criterio de aceptación de HU-OPT-020: sin un valor definido de timeout no se puede escribir el criterio como verificable.
- Las ramas `develop` y `qa` aún no existen en el repositorio grupal; no se pudo ejercitar el flujo de rama HU + PR por entorno esta semana.
- Riesgo de acoplamiento síncrono: la Saga debe ser completamente orientada a eventos. Una llamada REST bloqueante entre los tres servicios materializaría el riesgo de fallo en cascada de la Sesión 1. Requiere gate en code review.
- El diseño de la Saga asume RabbitMQ disponible entre pasos; se requiere tabla `saga_state` persistente en `orders_schema` para recuperación ante caída del broker.

## 4. Plan para la próxima semana

- Definir el valor del timeout con el equipo y agregarlo como criterio de aceptación verificable de HU-OPT-020.
- Crear ramas `develop` y `qa`; abrir `hu-opt-005-dev` con PR hacia `develop` con el esqueleto hexagonal de ms-ordenes en Go.
- Implementar el agregado `WorkOrder` en Go con pruebas unitarias de todos los invariantes de la máquina de estados. Paquete domain al 100% de cobertura unitaria antes de escribir infraestructura.
- Definir tablas `orders_schema` y escribir migración Flyway `V1__create_orders_schema.sql`.
- Publicar ADR-001 en `docs/adr/` con la sección de justificación Go vs. Java.

## 5. Autoevaluación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [ ] Rama HU + PR por entorno (hu-xxx-dev -> develop, ...)
- [ ] Criterios de aceptación verificables
- [ ] Pruebas agregadas o actualizadas (unitarias / integración)
- [ ] Límites DDD / hexagonal respetados (el dominio no tiene I/O)
- [x] Sin secretos; configuración por variables de entorno

Notas sobre los ítems sin marcar:
- Solo existe `main`; no se pudo abrir ninguna rama HU ni PR hacia `develop`.
- Criterio de aceptación de HU-OPT-020 bloqueado por decisión de timeout (sección 3).
- No se escribió código de producción esta semana; todo el trabajo es diseño, modelado, arquitectura de Saga y documentación.
- El capeado hexagonal y el diseño de la Saga están completos en papel, no materializados en código aún.

## 6. Enlaces de evidencia

- Product brief: [`prd.md`](./prd.md) — PRJ-OPTIVIEW-ORDENES (contexto, necesidades, proceso actual, preguntas abiertas, glosario).
- Commit del repositorio: https://github.com/JuanDTovar/sistemas-distribuidos-2026-b-g1/commit/c83b050
- Material del curso (OVAs): https://code-corhuila.github.io/ova-web/2026-B/distribuidos/
- Resumen de sesiones — fuente vectorial: [`resumen_sistemas_distribuidos_semana_1.svg`](./resumen_sistemas_distribuidos_semana_1.svg)

![Distributed Systems - Week 1 summary: distributed fundamentals, professional engineering foundations, ADR and backlog](./resumen_sistemas_distribuidos_semana_1_preview.png)

Principio clave tomado del material: **dividir por una razón, no por moda**. Una buena arquitectura hace explícitos los límites, los contratos, los trade-offs y el motivo de la decisión. El patrón Saga existe porque el flujo de creación de órdenes abarca tres bounded contexts reales.
