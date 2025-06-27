#!/bin/sh
export GRADLE_OPTS=""
exec ./gradle/wrapper/gradle-wrapper.jar "$@"
