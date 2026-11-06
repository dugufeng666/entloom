# Contributing to Entloom

Entloom is a public platform repository. The server and UI are developed in one repository so that API contracts, migrations, screens, deployment files and documentation can evolve together.

## Before opening a pull request

- Keep changes focused on one behavior or domain slice.
- Add or update tests for server behavior and UI API flows.
- Run `make server-test`, `make ui-check` and `make ui-build` when the affected area supports them.
- Update the relevant README or architecture note when a public contract changes.
- Do not commit credentials, customer data, private learning materials or production configuration.

## Directory ownership

- `server/` contains the Java API and persistence modules.
- `ui/` contains the Vue client and reusable platform screens.
- `docs/` contains architecture and contributor-facing decisions.
- `deploy/` and the root `docker-compose.yml` contain reproducible deployment configuration.

Issues and pull requests should describe the user-facing or operator-facing behavior, the validation performed and any migration or compatibility impact.
