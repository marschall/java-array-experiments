package com.github.marschall.javaarrayexperiments.core;

public class IntClass {

  public static int[] loop() {
    int[] array = new int[10000];
    for (int i = 0; i < 10000; i++) {
      for (int j = 0; j < 100000; j++) {
        array[i] = array[i] + j + i;
      }
    }
    return array;
  }

}
