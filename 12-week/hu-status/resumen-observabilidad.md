# Taller de observabilidad (OptiView)

Autor: Juan Diego Tovar Rodriguez (jdtovar07) · Equipo: The Illusionists · Materia: Sistemas Distribuidos
Fork: https://github.com/jdtovar07/sistemas-distribuidos-2026-b-g1 (carpeta `11-week/workshop`)
Reflexión: Google Docs "W11 Reflection - Juan Diego Tovar Rodriguez" (bilingüe: español primero, inglés después)

## 1. Objetivo
Hacer observable un recorrido crítico de OptiView: la saga `place-order` de `opti-workflow`, que pasa por `opti-api-gateway`, `opti-customers-api`, `opti-products-api` y `opti-sales-api`. Se pasó de "no sé qué pasó" a trazas, logs estructurados, métricas, SLO, alertas, runbook y un simulacro de incidente.

## 2. Qué se hizo, checkpoint por checkpoint
| CP | Commit | Fecha (Colombia) | Entregable | Idea central |
|---|---|---|---|---|
| CP0 | 50be758 | 20/10 19:13 | `README.md` del taller (35 líneas) | La observabilidad se planifica antes del código |
| CP1 | e74085d | 20/10 19:29 | `01-journey.md` (74) | Un `trace_id` une los saltos de una petición |
| CP2 | 74e067e | 20/10 19:45 | `02-log-contract.md` (78) | Logs JSON con los mismos campos en todos los servicios |
| CP3 | 031e6ed, e5c1c65 (push 1); 2f1440b, 6bd96d2, d866d03, 10bc00c (push 2) | 20/10 19:58 y 20:14 | Módulo `03-instrumentation/opti-workflow-obs` (solo JDK) | Propagar contexto no es exportar trazas |
| CP4 | d020764 | 20/10 20:24 | `04-metrics.md` (98) | Cuatro señales doradas; etiquetas acotadas |
| CP5 | - | - | No existe | - |
| CP6 | d2e581a | 20/10 20:53 | `05-slo.md` (93) | SLI, SLO y presupuesto de error |
| CP7 | 5377b37 | 20/10 21:09 | `06-alert-policy.md` + `06-alerts.yml` | Alertar por velocidad de gasto, no por CPU |
| CP8 | 58e78d3 | 20/10 21:26 | `07-runbook.md` (66) | El runbook convierte un incidente en pasos |
| CP9 | 7767691 | 21/10 07:12 | `08-incident.md` (97) | Ensayar el incidente antes de que ocurra |
| CP10 | 5fc02a5 (por confirmar) | 21/10 08:13 | Plan final en el Doc | Qué mejorar primero, en qué orden |

Los commits 2835699 y 62f4578 son seguimiento en `hu-status`, no checkpoints.

## 3. Cifras y decisiones que conviene recordar
- **Tráfico supuesto:** 8 ópticas x 75 sagas/día = 600/día (MVP 2 corre solo en `develop` y `qa`, no hay tráfico real).
- **SLO (30 días):** disponibilidad 99.5 % (presupuesto de 90 sagas fallidas) y latencia: 99 % bajo 2 s (180 sagas lentas).
- **Alertas:** `PlaceOrderAvailabilityFastBurn` (14.4, ventanas 1 h y 5 min, umbral 7.2 %), `SlowBurn` (6, 6 h y 30 min, 3 %) y una alerta extra de latencia (14.4 %). No se crearon alertas de CPU ni de memoria de Redis, porque el vendedor no siente la CPU.
- **Instrumentación:** `traceparent` W3C, logs JSON con `trace_id`, `span_id`, `correlation_id`, métricas en formato Prometheus. El módulo usa solo JDK porque no hay Maven y el equipo tiene JDK 25.
- **Regla de commits:** máximo 150 líneas; el push 1 de CP3 (168 líneas) se partió en 48 y 120.

## 4. Simulacro de incidente (CP9)
`opti-products-api` tardó 3 s en el 25 % de las peticiones, de 14:00 a 14:40. Con 3 s y un timeout de 5 s ninguna saga falla: la disponibilidad se mantuvo en 100 %, pero solo el 75 % de las sagas quedó bajo 2 s. `PlaceOrderLatencyFastBurn` avisa a los 35 minutos (14:35), cuando ya pasaron 7 de las 8 sagas lentas. Fue un ejercicio; nada ocurrió de verdad.

## 5. Qué se verificó de verdad y qué no
- Se corrió el test del módulo en la máquina del autor (21/10): 7 de 7, `ALL CHECKS PASSED`.
- No hubo errores de código; la fricción fue el entorno (sin Maven) y el límite de 150 líneas.
- No verificado: integración con los servicios reales, exportación de trazas, contexto en Redis, `promtool` sobre las reglas, tráfico real, ensayo del runbook fuera del simulacro.

## 6. Plan para el código real (orden)
1. `traceparent` en el gateway y logs JSON con campos comunes en los cinco servicios.
2. Llevar `Metrics` y `StockCall` a `opti-workflow` real (`route` como plantilla, nunca `patient_id`).
3. `promtool check rules` y copiar las reglas a `opti-infra/observability`.
4. Panel de Grafana con el p95 por participante.
5. Alerta de ventana corta para latencia (de 35 a menos de 10 minutos).
6. Prueba en CI de que `reserve-stock` usa índice tras cada migración.
7. Timeout por paso menor a 5 s y circuit breaker en `opti-workflow`.

## 7. Riesgos y bloqueos
Tráfico del SLO supuesto; `promtool` no instalado; el código de CP3 no es el servicio real; reinicio y rollback solo ensayados en el simulacro; coordinación con Bairon para los cambios de logs en servicios compartidos.

## 8. Aprendizajes
Una alerta se diseña desde lo que siente el usuario y no desde la CPU. Un SLO sin tráfico real es una hipótesis. La disponibilidad puede estar al 100 % con un servicio lento, y eso solo se ve con la latencia por participante.

## 9. Proceso y entrega
- El uso de IA está autorizado por el profesor en todos los entregables (correo "Nota Corte 1", 13/09/2026). Los archivos técnicos de CP0 a CP9 se redactaron con asistencia de IA el 20-21/10/2026; el autor corrió y revisó el resultado.
- Entrega 1 (en clase, 20/10): CP0 a CP4. Entrega 2 (take-home): CP6 a CP10. Verificar la fecha límite en Moodle (el archivo local dice 22/10 10:10).
- Seguimiento local: `entrega-w11/reflection-doc-link.txt` y `entrega-w11/hoja-de-hechos-commits.md`.

---
## Plantilla para los demás temas
```
# <Nombre del tema>
Autor · Equipo · Repo/carpeta · Enlace a la reflexión
1. Objetivo
2. Qué se hizo (tabla: checkpoint | commit | fecha | entregable | idea central)
3. Cifras y decisiones clave
4. Qué se verificó y qué no
5. Plan para el código real (orden)
6. Riesgos y bloqueos
7. Aprendizajes
8. Proceso y entrega (IA, fechas, enlaces)
```
