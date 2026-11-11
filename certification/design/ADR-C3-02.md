# ADR-C3-02: Centralised observability with LTS, AOM, Cloud Eye and SMN

## Status

Proposed

## Context

OptiView has no structured observability: logging is "Spring Boot logs for now", tracing and
health checks are only targets, and this is recorded as technical debt AT-002 with the note that
it must be closed "before having 2+ services in production" (`05-architecture/overview.md` §5 P4
and §7; technical debt table AT-002). Today a failure is debugged by hand on the host. Once the
monolith is split into `api-gateway` plus four services (design note §1), a failure in one service
will be invisible from the others, and the operations principle in design note §2 (be notified
before users are) cannot be met without a central place for logs, metrics and alarms.

## Decision

Adopt the Huawei Cloud operations stack as the system's observability layer: **LTS** (Log Tank
Service) for centralised log collection via the ICAgent on each host, **AOM** for metrics and
application monitoring, **Cloud Eye (CES)** for infrastructure metrics and alarm rules, and
**SMN** (Simple Message Notification) to push alarms to the on-call operator by email. A keyword
alarm on application logs (for example, a service-stopped event) raises a CES alarm that SMN
delivers, so an operator learns of an outage before the store's staff report it.

## Alternatives considered

- Self-hosted Prometheus + Grafana + Loki on the same Docker host: rejected because it adds a
  monitoring stack the team would have to run and keep available on the very host it is meant to
  observe — if the host fails, so does its monitoring.
- No central observability, keep per-host logs: rejected because it does not scale past one
  service and leaves AT-002 open, directly contradicting the operations principle in the design
  note.

## Consequences

- Positive: a single view of logs and metrics, proactive alerting through SMN, and a direct path
  to close technical debt AT-002; aligns with the chapter 8 cloud O&M design techniques.
- Negative: adds managed-service cost and couples operations to Huawei Cloud tooling; the team
  must install and keep the ICAgent healthy on every host and define meaningful alarm thresholds
  to avoid alert fatigue.
