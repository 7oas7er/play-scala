#!/usr/bin/env bash
echo "UnpackNewArtifact ..."
cd /tmp
unzip *zip -d play-scala-application
sudo chmod a+w play-scala-application/play-scala-0.1.0-SNAPSHOT
sudo chmod a+w play-scala-application/play-scala-0.1.0-SNAPSHOT/logs/application.log
echo "... done"