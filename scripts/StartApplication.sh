#!/usr/bin/env bash
echo "StartApplication ..."
if [ ! -d /tmp/play-scala-application ]; then
    echo "No play-scala application found. Nothing to start."
    exit 1
fi
echo "Found the app. Going to start it."
cd /tmp/play-scala-application/play-scala-0.1.0-SNAPSHOT/bin
./play-scala -Dconfig.resource=production.conf -Dplay.crypto.secret=abcdefghijk > /dev/null 2> /dev/null < /dev/null &
echo "... done"