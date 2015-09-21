#!/bin/bash
JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
JJS_PATH=$JAVA_HOME/jre/bin/jjs
$JJS_PATH class.js

