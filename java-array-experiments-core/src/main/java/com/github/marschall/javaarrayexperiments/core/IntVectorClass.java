package com.github.marschall.javaarrayexperiments.core;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

public class IntVectorClass {
  
  private static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;

  public static int[] loop() {
    int[] array = new int[10_000];
    IntVector va = IntVector.fromArray(SPECIES, array, 0);
    
    va.addIndex(1)
      .intoArray(array, 0);
    
    for (int i = 0; i < 10_000; i++) {
      for (int j = 0; j < 100_000; j++) {
        array[i] = array[i] + j + i;
      }
    }
    return array;
  }

//  public static void main(String[] args) {
//    System.out.println(SPECIES.vectorBitSize() + " bit");
//  }

}
