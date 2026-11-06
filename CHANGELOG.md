# Changelog

## Unreleased

- Merged the server and UI foundations into a single public Entloom repository.
- Added a root Docker Compose stack for PostgreSQL, Redis, server and UI.
- Added repository-wide Makefile commands and CI.
- Added the first persisted project API slice.
- Added database-backed local users, roles and BCrypt password storage.
- Added project detail, editing and forward-only draft/active/archived lifecycle actions.
- Added the first project-scoped ontology API and draft/released/archived lifecycle migration.
