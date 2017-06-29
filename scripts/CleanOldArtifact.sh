#!/usr/bin/env bash
set -x
echo "CleanOldArtifact ..."
if [ ! -z "$(ls -A /tmp)" ]; then
   echo "Found old deployment artifact. Removing it."
   sudo rm -r /tmp/*
else
   echo "No old deployment artifact found. Nothing to remove."
fi
echo "... done"


