#!/usr/bin/env bash

cd client && npm ci && npm run build
cd ..
rm -rf src/main/resources/public
cp -r client/dist src/main/resources/public
env SPRING_PROFILES_ACTIVE=development mvn clean install
