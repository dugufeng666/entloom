.PHONY: help up down logs server-test ui-check ui-build build

help:
	@printf '%s\n' \
	  'make up           Start PostgreSQL, Redis, server and UI' \
	  'make down         Stop the local Docker stack' \
	  'make logs         Follow Docker Compose logs' \
	  'make server-test  Run the Java test suite' \
	  'make ui-check     Run the UI type checks and tests' \
	  'make ui-build     Build the UI for production' \
	  'make build        Run server tests and UI checks/build'

up:
	docker compose up --build -d

down:
	docker compose down

logs:
	docker compose logs -f

server-test:
	cd server && ./mvnw -B test

ui-check:
	cd ui && npm ci && npm run typecheck && npm run test

ui-build:
	cd ui && npm run build

build: server-test ui-check ui-build
