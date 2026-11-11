# ADR-C3-01: Managed cross-AZ PostgreSQL (RDS) for the critical data store

## Status

Proposed

## Context

OptiView runs one self-managed PostgreSQL 16 instance per environment on a single Docker host
(design note §1, §4; `05-architecture/deployment.md` §1). That instance holds the `patients_schema`
and `billing_schema`, whose loss would destroy clinical and financial records that are kept by
soft delete precisely so they are never lost (`06-data/models.md` §3). With no standby, the host
is a single point of failure: a disk or node failure means both downtime and potential data loss,
which is incompatible with the reliability and disaster-recovery targets set in design note §2 and
§4 (RTO 30 min, RPO 5 min).

## Decision

Replace the self-managed instance with **Huawei Cloud RDS for PostgreSQL** in a primary/standby
high-availability deployment across two Availability Zones, keeping the schema-per-service model
(one instance, four schemas) unchanged. RDS provides an automatically promoted cross-AZ standby,
automated daily backups retained in object storage, and point-in-time recovery, which together
deliver the RPO/RTO numbers the design note commits to without the team operating replication by
hand.

## Alternatives considered

- Self-managed PostgreSQL with streaming replication on a second ECS: rejected because it puts the
  burden of configuring, monitoring and failing over replication on a small student team, which is
  exactly the operational cost the course warns against for this scale.
- Database-per-service on four separate RDS instances: rejected as premature — the architecture is
  explicitly "schema per service, not database per service" (`06-data/models.md` §1), and four
  managed instances multiply cost with no benefit at the current one-store scale.

## Consequences

- Positive: eliminates the database single point of failure, gives automated backups and
  point-in-time recovery, and meets the DR targets without custom replication code.
- Negative: introduces a recurring managed-service cost and a cloud-provider dependency, and the
  team must manage schema migrations (Flyway / golang-migrate) against a managed endpoint rather
  than a local container.
