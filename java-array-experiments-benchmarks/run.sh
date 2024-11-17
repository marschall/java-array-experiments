#!/bin/sh

set -u
set -e

java -cp tmp/*.jar \
  --enable-preview \
  --add-modules jdk.incubator.vector \
  com.github.marschall.javaarrayexperiments.benchmarks.IntArrayBenchmarks