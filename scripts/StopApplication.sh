#!/usr/bin/env bash
if [ ! -d /tmp/play-scala-application ]; then
    echo "No play-scala application found. Nothing to stop."
    exit 0
fi
if [ ! -f /tmp/play-scala-application/play-scala-0.1.0-SNAPSHOT/RUNNING_PID ]; then
    echo "play-scala application is not running. Nothing to stop."
    exit 0
fi
cd /tmp/play-scala-application/play-scala-0.1.0-SNAPSHOT
sudo kill $(cat RUNNING_PID)