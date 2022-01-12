#!/bin/bash

# Builds and publishes image to docker repo

IMAGE_NAME=goldthelocks/cat-api-kt
BUILD_COMMIT=$(git rev-parse --short HEAD)

echo "==================================================="
echo "Building app..."
echo "==================================================="
./mvnw clean install

echo "==================================================="
echo "Building docker image..."
echo "==================================================="

docker build \
  --file Dockerfile \
  --no-cache \
  --tag ${IMAGE_NAME}:latest \
  --tag ${IMAGE_NAME}:${BUILD_COMMIT} \
  .