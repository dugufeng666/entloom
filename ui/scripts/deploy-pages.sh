#!/usr/bin/env bash
set -euo pipefail

npm ci
npm run build

echo "The dist/ directory is ready for Cloudflare Pages or another static host."
echo "Deploy it with the provider's authenticated CI environment; no credentials belong in this repository."
