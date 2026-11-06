# Changelog

## Unreleased

- Merged the server and UI foundations into a single public Entloom repository.
- Added a root Docker Compose stack for PostgreSQL, Redis, server and UI.
- Added repository-wide Makefile commands and CI.
- Added the first persisted project API slice.
- Added database-backed local users, roles and BCrypt password storage.
- Added project detail, editing and forward-only draft/active/archived lifecycle actions.
- Added the first project-scoped ontology API and draft/released/archived lifecycle migration.
- Added draft-only ontology class definitions with read-only released snapshots.
- Added typed ontology class properties with draft-only mutation rules.
- Added ontology class-to-class relations with explicit cardinality and draft-only mutation rules.
- Added semantic release manifests with release identity, actor and model counts.
