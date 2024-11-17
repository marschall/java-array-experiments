package com.github.marschall.javaarrayexperiments.core;

public class IntClass {

  public static int[] loop() {
    int[] array = new int[10_000];
    return loop(array);
  }

  public static int[] loop(int[] array) {
    for (int i = 0; i < 10_000; i++) {
      for (int j = 0; j < 100_000; j++) {
        array[i] = array[i] + j + i;
      }
    }
    return array;
  }

  public static int[] loopRewritten() {
    int[] array = new int[10_000];
    return loopRewritten(array);
  }

  public static int[] loopRewritten(int[] array) {
    for (int i = 0; i < 10_000; i++) {
      int x = array[i];
      for (int j = 0; j < 100_000; j++) {
        x = x + j + i;
      }
      array[i] = x;
    }
    return array;
  }
  
  public static int[] loopRewritten2() {
    int[] array = new int[10_000];
    return loopRewritten2(array);
  }
  
  public static int[] loopRewritten2(int[] array) {
    for (int i = 0; i < 10_000; i++) {
      int x = 0;
      for (int j = 0; j < 100_000; j++) {
        x = x + j + i;
      }
      array[i] = x;
    }
    return array;
  }

}
