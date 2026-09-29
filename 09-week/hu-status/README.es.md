<!-- PLANTILLA HU-STATUS (traducción al español) - NO borres los marcadores <!-- ... -->
     ni las cabeceras de tabla.
     ATENCIÓN: la nota semanal se lee AUTOMÁTICAMENTE del archivo en inglés:
       09-week/hu-status/README.md  (dentro de TU fork).
     Este archivo es una copia en español para lectura y no se califica. -->

# Estado Semanal - Semana 09

<!-- CONFIG-START - debe coincidir con el CONFIG de tu repo de perfil (username/username) -->
- FULL_NAME: Juan Diego Tovar Rodriguez
- GITHUB_USER: jdtovar07
- TEAM: The Illusionists
- SPRINT_GOAL: Documentar configuración vs secretos vs feature flags, y planear configuración segura más entrega progresiva para los servicios evolutivos opti-* después del MVP 1.
<!-- CONFIG-END -->

> **Entrega Semana 09 — config segura y releases más seguros.** Después del MVP 1 (Semana 05), layout de ambientes/repos (Semana 06), contratos + acceso (Semana 07) y planeación Agile/DevOps (Semana 08), esta semana documenta **cómo OptiView separa configuración, secretos y feature flags**, y **cómo planeamos configuración segura + progressive delivery** para que los siguientes cortes `opti-*` se desplieguen sin un release big-bang.

## 1. Historias de usuario trabajadas esta semana

| HU ID | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-OPT-075 | Documentar configuración, secretos y feature flags | done | [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md) |
| HU-OPT-076 | Elaborar resumen visual de configuración, secretos y feature flags | done | [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png) |
| HU-OPT-077 | Documentar planeación de configuración segura y entrega progresiva | done | [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md) |
| HU-OPT-078 | Elaborar resumen visual de configuración segura / entrega progresiva | done | [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png) |

## 2. Mi contribución individual

> **Alcance esta semana:** documentación DevOps / entrega mapeada a OptiView — **no** código nuevo de features. Parte de la Semana 06 (env vars, sin secretos en el repo, layout de 19 repos) y de la Semana 08 (Git Flow `develop` → `qa` → `main`).

### Notas de estudio y visuales

| Artefacto | Qué cubre |
|-----------|-----------|
| [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md) | Configuración (comportamiento por ambiente sin cambiar código); secretos (credenciales, keys, tokens — nunca en git); feature flags (deploy ≠ release: rollout gradual, A/B, apagado instantáneo) |
| [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png) | Resumen visual: Configure / Protect / Innovate — diferencias, buenas prácticas, arquitectura recomendada |
| [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md) | Arquitectura de configuración segura; progressive delivery (canary, anillos, flags); release 100% tradicional vs 5% → 25% → 50% → 100% |
| [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png) | Resumen visual de planeación de configuración segura + entrega progresiva |

### Mapeo a OptiView

| Tema | Aplicación en OptiView |
|------|------------------------|
| Configuración | Valores por ambiente en cada `opti-*-api` / portal (`LOG_LEVEL`, host de DB, URLs del gateway) vía env vars / Compose — mismo binario, settings distintos en `develop` / `qa` / `main` |
| Secretos | Passwords de DB, secretos JWT/Keycloak, keys: **no** en git. `.env.example` solo con claves; valores reales en un secret store a cargo de `opti-infra` (elección aún abierta: Vault / cloud secret manager / Compose secrets) |
| Feature flags | Separar **deploy** de **release** al extraer el MVP 1 (`opti-view`) hacia `opti-customers-*` / `opti-sales-*`: subir código apagado, encender por cohorte, kill-switch sin rollback de deploy |
| Progressive delivery | Canary / anillos en el Git Flow: interno → % pequeño en `qa` → 100% en `main`. Si un corte falla, se apaga el flag en vez de revertir cada repo `opti-*` |
| Least privilege | Cada servicio lee solo los secretos de su bounded context (credenciales de `opti-customers-db` no entran a `opti-sales-api`) |
| Auditoría | Cambios de config y flags deben ser trazables (quién encendió flags estilo `newCheckoutExperience` y en qué ambiente) |

### Continuidad Semanas 05–08

| Semana | Qué ya tenemos | Cómo lo usa la Semana 09 |
|--------|----------------|--------------------------|
| 05 | MVP 1 presentado | Línea base aún corriendo; los flags permiten extraer BCs sin cutover big-bang |
| 06 | Compose, planeación de ambientes, layout 19 repos, “sin secretos en el repo” | La Semana 09 lo profundiza: config ≠ secretos ≠ flags, y nombra el camino de progressive delivery |
| 07 | Contratos + acceso colaboradores en cada `opti-*` | El equipo puede cambiar config/flags por servicio sin compartir credenciales en chat o git |
| 08 | Agile/DevOps + planeación Git Flow | Progressive delivery es cómo esas ceremonias sueltan: slices pequeños, rollback rápido vía flags |

## 3. Bloqueadores y riesgos

- El producto de secret store para ambientes compartidos **sigue sin elegirse** (bloqueador de Semana 06, a cargo de `opti-infra`). Hasta entonces, Compose local + `.env` (gitignored) es el único camino seguro.
- Herramienta de feature flags no ratificada (flags por env-var vs Unleash / LaunchDarkly). Booleanos en env-var alcanzan para el primer slice evolutivo; un servicio dedicado es overkill hasta que haya más de un BC en vivo.
- Progressive delivery está documentado, no cableado: aún no hay pipeline canary en `opti-*-api`.
- Riesgo: mezclar secretos en `application.properties` / `.env` commiteado al armar scaffolds — hace falta un gate de review (misma regla de “sin defaults de secretos” de la constitución de la Semana 08).

## 4. Plan para la próxima semana

- Congelar convención `.env.example` (solo claves, sin valores) para `opti-infra` y el primer scaffold `opti-*-api`.
- Elegir el primer flag del siguiente slice OptiView (p. ej. servir customers desde `opti-customers-api` vs `opti-view`) con kill-switch documentado.
- Dejar la decisión del secret store en el backlog de `opti-infra`; no bloquear el primer scaffold por Vault.

## 5. Autoverificación de cumplimiento

- [x] Conventional Commits - `type(scope): summary`
- [ ] Rama HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [ ] Tests agregados/actualizados (unit / integration)
- [ ] Límites DDD / hexagonal respetados (dominio sin I/O)
- [x] Sin secretos; config vía variables de entorno

Notas: La Semana 09 es documentación (configuración / secretos / flags + planeación de config segura y progressive delivery). Sin código de features esta semana — los ítems DDD/tests sin marcar aplican cuando empiecen los PRs de servicios evolutivos. El HU-status semanal de este fork se commitea en `main` (igual que las semanas 06–08), no `hu-xxx-dev` → `develop`. “Sin secretos en el repo” y config por ambiente son el núcleo de las notas de esta semana.

## 6. Enlaces de evidencia

**Fork del curso (docs Semana 09):**

- Notas configuración / secretos / flags: [`configuration-secrets-and-feature-flags.md`](./configuration-secrets-and-feature-flags.md)
- Visual configuración / secretos / flags: [`configuration-secrets-and-feature-flags.png`](./configuration-secrets-and-feature-flags.png)
- Notas configuración segura / entrega progresiva: [`planning-secure-configuration-and-progressive-delivery.md`](./planning-secure-configuration-and-progressive-delivery.md)
- Visual de planeación: [`planning-secure-configuration-and-progressive-delivery.png`](./planning-secure-configuration-and-progressive-delivery.png)

**Trabajo previo relacionado:**

- Agile/DevOps + planeación (Semana 08): [`08-week/hu-status/README.md`](../../08-week/hu-status/README.md)
- Compose / ambientes / config (Semana 06): [`06-week/hu-status/README.md`](../../06-week/hu-status/README.md)
- Repos de la org: https://github.com/orgs/code-corhuila/repositories?q=opti
- Línea base MVP: https://github.com/code-corhuila/opti-view
