# Entloom Architecture

Entloom starts as a modular monolith with a separately deployable web client. The repository boundary is intentionally larger than the runtime boundary: server and UI can build into independent images, while their contracts, migrations, documentation and release checks stay together.

## Runtime components

```text
Browser ──HTTP──> UI (Nginx static assets)
                     │
                     └──HTTP /api──> Server (Spring Boot)
                                          ├── PostgreSQL
                                          └── Redis
```

## Design rules

1. The API is versioned under `/api/v1`.
2. Domain modules live inside `server/` until measured deployment or scaling needs justify extraction.
3. Database changes use ordered Flyway migrations.
4. The UI consumes server contracts through API client modules; generated types will be introduced when the OpenAPI surface stabilizes.
5. Deployment configuration must be reproducible from the root repository and must not contain production secrets.

## OpenMetadata-inspired lessons

The repository should grow around a coherent context model and public extension points: schemas, APIs, connectors, events, SDKs and agent integrations belong to the same platform story. A single repository makes those relationships visible to contributors and lets a change travel from domain model to server API, UI screen, tests and deployment examples in one pull request.
