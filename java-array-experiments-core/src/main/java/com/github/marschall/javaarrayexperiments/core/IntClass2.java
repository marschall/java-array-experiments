package com.github.marschall.javaarrayexperiments.core;

import java.util.Random;

public class IntClass2 {

  public static int loop2(int u) {
    int[] a = new int[10_000]; // Array of 10k elements initialized to 0
    int r = new Random().nextInt(a.length); // Get a random number 0 <= r < 10k
    return loop2(u, r, a)[r]; // Return a single element from the array
  }

  public static int[] loop2(int u, int r, int[] a) {
    for (int i = 0; i < a.length; i++) { // 10k outer loop iterations
      for (int j = 0; j < 100_000; j++) { // 100k inner loop iterations, per outer loop iteration
        a[i] = a[i] + j % u; // Simple sum
      }
      a[i] += r; // Add a random value to each element in array
    }
    return a; // Return the array
  }

  public static int loop2rewritten(int u) {
    int[] a = new int[10_000]; // Array of 10k elements initialized to 0
    int r = new Random().nextInt(a.length); // Get a random number 0 <= r < 10k
    return loop2Rewritten(u, r, a)[r]; // Return a single element from the array
  }

  public static int[] loop2Rewritten(int u, int r, int[] a) {
    for (int i = 0; i < a.length; i++) { // 10k outer loop iterations
      int x = 0;
      for (int j = 0; j < 100_000; j++) { // 100k inner loop iterations, per outer loop iteration
        x = x + j % u; // Simple sum
      }
      a[i] = x + r; // Add a random value to each element in array
    }
    return a; // Return the array
  }

  public static int loop2Rewritten2(int u) {
    int[] a = new int[10_000]; // Array of 10k elements initialized to 0
    int r = new Random().nextInt(a.length); // Get a random number 0 <= r < 10k
    return loop2Rewritten2(u, r, a)[r]; // Return a single element from the array
  }

  public static int[] loop2Rewritten2(int u, int r, int[] a) {
    for (int i = 0; i < a.length; i++) { // 10k outer loop iterations
      int x = 0;
      int z = (int) (99_999L * (100_000L / 2L)) % u;
      a[i] = x + z + r; // Add a random value to each element in array
    }
    return a; // Return the array
  }

}
