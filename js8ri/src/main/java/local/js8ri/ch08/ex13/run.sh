#!/bin/sh
cd ../../../../
javac local/js8ri/ch08/ex13/SampleTestCase.java
javac local/js8ri/ch08/ex13/TestCaseProcessor.java
javac -implicit:none -processor local.js8ri.ch08.ex13.TestCaseProcessor local/js8ri/ch08/ex13/SampleTestCase.java local.js8ri.ch08.ex13.TestCase
