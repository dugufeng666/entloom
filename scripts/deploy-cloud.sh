#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "$0")/.." && pwd)"
echo "This script builds the Entloom server and UI images for a container platform."
echo "Provide registry credentials and deployment settings through your CI/CD environment."
docker build -t "${ENTLOOM_SERVER_IMAGE:-entloom-server:local}" "$ROOT_DIR/server"
docker build -t "${ENTLOOM_UI_IMAGE:-entloom-ui:local}" "$ROOT_DIR/ui"
