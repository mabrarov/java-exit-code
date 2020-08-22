#!/bin/bash

set -e

if [[ "${COPILOT_BUILD}" -ne 0 ]]; then
  bash <(curl -s https://copilot.blackducksoftware.com/ci/travis/scripts/upload)
fi
