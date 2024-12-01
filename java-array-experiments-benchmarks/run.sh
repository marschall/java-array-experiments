#!/bin/sh

set -u
set -e

${JAVA_HOME}/bin/java --class-path tmp/commons-math3-3.6.1.jar:tmp/java-array-experiments-benchmarks-1.0.0-SNAPSHOT.jar:tmp/java-array-experiments-core-1.0.0-SNAPSHOT.jar:tmp/jmh-core-1.37.jar:tmp/jopt-simple-5.0.4.jar \
  --enable-preview \
  --add-modules jdk.incubator.vector \
  com.github.marschall.javaarrayexperiments.benchmarks.IntVectorBenchmarks
