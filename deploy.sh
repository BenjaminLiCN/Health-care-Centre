#!/usr/bin/env bash
#post build scripts
echo "Build finished, a jar file should be created by now"
cd /var/lib/jenkins/workspace/healthCentre
echo "kill the existing process "
pid=`ps |grep java|awk '{print $1}'`
if [ -n "$pid" ]
then
  ps |grep java|awk '{print $1}'|xargs sudo kill -9
  echo "There was a process but now it's dead"
fi
BUILD_ID=dontKillMe nohup /home/deploy/startup.sh &
ls