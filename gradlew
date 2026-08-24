#!/usr/bin/env sh
# Gradle wrapper - minimal
BASEDIR=$(dirname "$0")
if [ -z "$JAVA_HOME" ]; then
  java -jar "$BASEDIR/gradle/wrapper/gradle-wrapper.jar" "$@"
else
  "$JAVA_HOME/bin/java" -jar "$BASEDIR/gradle/wrapper/gradle-wrapper.jar" "$@"
fi
