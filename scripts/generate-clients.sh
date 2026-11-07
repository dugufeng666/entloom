#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
SPEC="${ROOT_DIR}/server/src/main/resources/openapi/entloom.yaml"
CACHE_DIR="${ROOT_DIR}/.cache"
GENERATOR_VERSION="${OPENAPI_GENERATOR_VERSION:-7.10.0}"
GENERATOR_JAR="${CACHE_DIR}/openapi-generator-cli-${GENERATOR_VERSION}.jar"
mkdir -p "${CACHE_DIR}"
if [[ ! -f "${GENERATOR_JAR}" ]]; then
  curl --fail --location --retry 3 "https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/${GENERATOR_VERSION}/openapi-generator-cli-${GENERATOR_VERSION}.jar" --output "${GENERATOR_JAR}"
fi

java -jar "${GENERATOR_JAR}" validate -i "${SPEC}"

rm -rf "${ROOT_DIR}/clients/javascript" "${ROOT_DIR}/clients/java" "${ROOT_DIR}/clients/python"
java -jar "${GENERATOR_JAR}" generate -i "${SPEC}" -g typescript-fetch -o "${ROOT_DIR}/clients/javascript" --additional-properties=supportsES6=true,npmName=@entloom/client,npmVersion=0.1.0,hideGenerationTimestamp=true
java -jar "${GENERATOR_JAR}" generate -i "${SPEC}" -g java -o "${ROOT_DIR}/clients/java" --additional-properties=library=restclient,hideGenerationTimestamp=true,groupId=io.entloom,artifactId=entloom-client,artifactVersion=0.1.0
java -jar "${GENERATOR_JAR}" generate -i "${SPEC}" -g python -o "${ROOT_DIR}/clients/python" --additional-properties=packageName=entloom_client,projectName=entloom-client,packageVersion=0.1.0,hideGenerationTimestamp=true
