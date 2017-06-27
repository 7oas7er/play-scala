#!/usr/bin/env bash

if [ ! -z "$(ls -A /tmp)" ]; then
   echo "Found old deployment artifact. Removing it."
   sudo rm -R /tmp/*
else
   echo "No old deployment artifact found. Nothing to remove."
fi


