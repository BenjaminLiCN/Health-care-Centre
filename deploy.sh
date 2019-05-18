#!/usr/bin/env bash
#post build scripts
#jenkins!
echo "Build finished, a jar file should be created by now.."
cd /var/lib/jenkins/workspace/healthCentre
echo "Check if there's any process running..."
pid=`ps |grep java|awk '{print $1}'`
if [ -n "$pid" ]
then
  ps |grep java|awk '{print $1}'|xargs sudo kill -9
  echo "There was a process but now it's dead"
fi
echo "deploying..."
BUILD_ID=dontKillMe nohup /home/deploy/startup.sh &
ls