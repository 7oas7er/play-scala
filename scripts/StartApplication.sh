#!/usr/bin/env bash
if [ ! -d /tmp/play-scala-application ]; then
    echo "No play-scala application found. Nothing to start."
    exit 1
fi
cd /tmp/play-scala-application/play-scala-0.1.0-SNAPSHOT/bin
./play-scala -Dplay.crypto.secret=abcdefghijk > /dev/null 2> /dev/null < /dev/null &