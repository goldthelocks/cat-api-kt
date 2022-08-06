#!/bin/bash

IMAGE_NAME=goldthelocks/cat-api-kt
BRANCH=${BUILDKITE_BRANCH:-snapshot}
BUILD_COMMIT=$(git rev-parse --short HEAD)

log_message() {
  MESSAGE=$1

  echo "==================================================="
  echo $MESSAGE
  echo "==================================================="
}

log_message "Building docker image..."

DOCKER_TAGS="-t $IMAGE_NAME:$BRANCH"

if [ "$BUILDKITE" == "true" ]; then
  buildkite-agent artifact download "target/*" target/
fi

if [ "$BUILDKITE" == "true" ]; then
  log_message "Doing buildkite docker build..."

  if [ "$BUILDKITE_BRANCH" == "master" ]; then
    DOCKER_TAGS="$DOCKER_TAGS -t $IMAGE_NAME:release_$BUILD_COMMIT"
    DOCKER_TAGS="$DOCKER_TAGS -t $IMAGE_NAME:latest"
  fi
else
  log_message "Doing local docker build..."

  DOCKER_TAGS="$DOCKER_TAGS -t $IMAGE_NAME:latest"
fi

docker build . \
  --no-cache \
  -f Dockerfile \
  $DOCKER_TAGS