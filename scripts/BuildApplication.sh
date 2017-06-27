#!/usr/bin/env bash
echo "Building application in $WORKSPACE"
set -x
sbt clean clean-files
sbt compile
sbt test
sbt dist
cp appspec.yml target/universal
cp -R scripts target/universal