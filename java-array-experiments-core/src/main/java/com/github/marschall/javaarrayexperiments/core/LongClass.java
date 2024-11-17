package com.github.marschall.javaarrayexperiments.core;

public class LongClass {

  public static long[] loop() {
    long[] array = new long[10_000];
    for (int i = 0; i < 10_000; i++) {
      for (int j = 0; j < 100_000; j++) {
        array[i] = array[i] + j + i;
      }
    }
    return array;
  }

}
