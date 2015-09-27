#!/bin/bash
JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
JJS_PATH=$JAVA_HOME/jre/bin/jjs
echo ""
echo "[CASE 1] An argument "17" specified."
echo ""
$JJS_PATH -scripting age.js -- 17
echo ""
echo "[CASE 2] AGE "27" ENV specified."
echo ""
AGE=27 $JJS_PATH -scripting age.js
echo ""
echo "[CASE 3] Nothing specified."
echo ""
$JJS_PATH -scripting age.js
echo ""

