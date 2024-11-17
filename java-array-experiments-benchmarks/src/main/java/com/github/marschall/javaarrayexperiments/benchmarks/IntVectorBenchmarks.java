package com.github.marschall.javaarrayexperiments.benchmarks;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.github.marschall.javaarrayexperiments.core.IntClass;
import com.github.marschall.javaarrayexperiments.core.IntVectorClass;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class IntVectorBenchmarks {

  private static final int ARRAY_SIZE = 10_000;

  private int[] array;

  @Setup
  public void setup() {
    this.array = new int[ARRAY_SIZE];
  }

  @Benchmark
  public int[] vectorized() {
    return IntVectorClass.loop(this.array);
  }

  @Benchmark
  public int[] rewritten3() {
    return IntClass.loopRewritten3(this.array);
  }

  public static void main(String[] args) throws RunnerException {
    Options options = new OptionsBuilder()
        .include(".*IntVectorBenchmarks.*")
        .forks(1)
        .warmupIterations(3)
        .measurementIterations(5)
        .resultFormat(ResultFormatType.TEXT)
        .result("int-vector-result.txt")
        .build();
    new Runner(options).run();
  }

}
