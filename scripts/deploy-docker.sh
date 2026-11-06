#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")/.."
docker compose up --build -d
docker compose ps
echo "Entloom UI is available at http://localhost:4173"
echo "Entloom server is available at http://localhost:8080"
