#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
SERVER_DIR="${ROOT_DIR}/server"
PORT="${ENTLOOM_OPENAPI_PORT:-18080}"
BASE_URL="http://localhost:${PORT}"
SNAPSHOT="${ROOT_DIR}/server/src/main/resources/openapi/entloom.yaml"
RUNTIME_SPEC="$(mktemp)"
LOG_FILE="$(mktemp)"
SERVER_PID=""

cleanup() {
  if [[ -n "${SERVER_PID}" ]] && kill -0 "${SERVER_PID}" 2>/dev/null; then
    kill "${SERVER_PID}" 2>/dev/null || true
    wait "${SERVER_PID}" 2>/dev/null || true
  fi
  rm -f "${RUNTIME_SPEC}" "${LOG_FILE}"
}
trap cleanup EXIT

(
  cd "${SERVER_DIR}"
  ./mvnw -B -ntp \
    -Dmaven.compiler.release=17 \
    -Dmaven.compiler.source=17 \
    -Dmaven.compiler.target=17 \
    spring-boot:run \
    -Dspring-boot.run.profiles=test \
    -Dspring-boot.run.useTestClasspath=true \
    "-Dspring-boot.run.arguments=--server.port=${PORT}"
) >"${LOG_FILE}" 2>&1 &
SERVER_PID=$!

for attempt in $(seq 1 60); do
  if curl --silent --fail "${BASE_URL}/api/v1/openapi.yaml" --output "${RUNTIME_SPEC}"; then
    break
  fi
  if ! kill -0 "${SERVER_PID}" 2>/dev/null; then
    cat "${LOG_FILE}"
    echo "Spring Boot server exited before serving OpenAPI" >&2
    exit 1
  fi
  sleep 1
done

if [[ ! -s "${RUNTIME_SPEC}" ]]; then
  cat "${LOG_FILE}"
  echo "Timed out waiting for ${BASE_URL}/api/v1/openapi.yaml" >&2
  exit 1
fi

if ! cmp -s "${SNAPSHOT}" "${RUNTIME_SPEC}"; then
  echo "Runtime OpenAPI contract differs from ${SNAPSHOT}:" >&2
  diff -u "${SNAPSHOT}" "${RUNTIME_SPEC}" || true
  exit 1
fi

echo "Runtime OpenAPI contract matches ${SNAPSHOT}"
