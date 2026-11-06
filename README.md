# Entloom

Entloom is an open-source platform for building enterprise ontologies, governed data context and AI agents.

The repository follows a single-repository platform model: the server and the web client live together, share one release line and are still independently buildable and deployable. This keeps API changes, UI changes, Docker images, documentation and community contributions reviewable in one place.

## Repository layout

```text
entloom/
├── server/                 # Java 25 + Spring Boot 4.1.2 modular monolith
├── ui/                     # Vue 3 + TypeScript + Vite 8 client
├── docs/                   # Architecture and contributor-facing design notes
├── deploy/                 # Deployment configuration and runbooks
├── scripts/                # Repeatable local and deployment commands
├── docker-compose.yml      # Local PostgreSQL, Redis, server and UI stack
├── Makefile                # Unified developer commands
└── .github/workflows/      # Repository-wide CI
```

The private BigDataFlowing website and learning center are separate products. They are not part of this public repository.

## What is in the first foundation

- Versioned REST APIs under `/api/v1`.
- A protected `/api/v1/auth/me` endpoint backed by database users and roles, with a local HTTP Basic sign-in flow.
- A modular-monolith server with Spring Modulith.
- Project creation and listing as the first persisted domain slice.
- A Vue shell for the platform workspace.
- PostgreSQL for durable state and Redis for coordination and caching.
- Docker Compose for local development.
- Apache License 2.0, contribution guidance and security reporting policy.

## Quick start with Docker

Requirements: Docker Desktop with Compose v2.

```bash
cp .env.example .env
make up
```

The default endpoints are:

- UI: http://localhost:4173
- Server health: http://localhost:8080/actuator/health
- API smoke endpoint: http://localhost:8080/api/v1/hello

The local profile seeds the first development administrator in `users` and `user_roles` using the credentials in `.env`. The example values are `entloom` / `change-me`; replace them before sharing or deploying an environment. The UI uses these credentials to call the protected project API through HTTP Basic during this foundation phase.

Stop the stack with:

```bash
make down
```

## Local development

Run the server:

```bash
cd server
set -a; source ../.env; set +a
./mvnw test
./mvnw spring-boot:run
```

Run the UI:

```bash
cd ui
npm install
npm run dev
```

Or use the root commands:

```bash
make server-test
make ui-check
make ui-build
```

The server uses Java 25. The UI uses Node.js 22.18+ or 24.12+.

## Product direction

Entloom is designed around an enterprise context graph rather than a generic administration scaffold. The planned capability areas are:

| Area | Purpose |
| --- | --- |
| Identity and tenancy | Organizations, users, roles, permissions and tenant boundaries |
| Projects | Workspaces, versions, ownership and lifecycle |
| Ontology Studio | Classes, properties, relations, mappings and release workflows |
| Metadata context | Assets, schemas, business terms, ownership, quality and lineage |
| Validation | Structural checks, references, duplicates and quality rules |
| Agent runtime | Tools, providers, policies, evaluations and controlled actions |
| Evidence and audit | Traceable evidence, decisions and security events |

The first implementation remains a modular monolith. A module becomes a separate service only when measured scale, isolation or deployment needs justify it.

## Contributing

Read [CONTRIBUTING.md](CONTRIBUTING.md) before opening an issue or pull request. Please keep customer data, private learning materials, credentials and production configuration out of this repository.

## License

Entloom is released under the [Apache License 2.0](LICENSE). The license covers the source code. The Entloom and BigDataFlowing names, logos, private website, learning materials, paid content and customer data remain outside this repository.
