package com.github.marschall.javaarrayexperiments.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntVectorClassTests {

  @Test
  void loop() {
    int[] loop = IntClass.loop();
    int[] vectorLoop = IntVectorClass.loop();
    assertArrayEquals(loop, vectorLoop);
  }

}
