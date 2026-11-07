#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
BASE_URL="${ENTLOOM_SERVER_URL:-http://localhost:8080}"
curl --fail --location "${BASE_URL}/api/v1/openapi.yaml" --output "${ROOT_DIR}/server/src/main/resources/openapi/entloom.yaml"
echo "Updated server/src/main/resources/openapi/entloom.yaml from ${BASE_URL}/api/v1/openapi.yaml"
