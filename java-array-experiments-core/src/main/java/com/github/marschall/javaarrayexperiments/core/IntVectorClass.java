package com.github.marschall.javaarrayexperiments.core;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

public class IntVectorClass {
  
  private static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;

  public static int[] loop() {
    int[] array = new int[10_000];
    return loop(array);
  }

  public static int[] loop(int[] a) {
    int i = 0;
    int upperBound = SPECIES.loopBound(a.length);
    for (; i < upperBound; i += SPECIES.length()) {
        var va = IntVector.fromArray(SPECIES, a, i);
        va.broadcast(i)
          .addIndex(1)
          .mul(100_000)
          .add((int) (99_999L * (100_000L / 2L)))
          .intoArray(a, i);
    }
    for (; i < a.length; i++) {
      int x = i * 100_000;
      int z = (int) (99_999L * (100_000L / 2L));
      a[i] = x + z;
    }
    return a;
  }

}
