package com.github.marschall.javaarrayexperiments.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntClassTests {

  @Test
  void loop() {
    int[] loop = IntClass.loop();
    assertNotNull(loop);
  }

  @Test
  void loopRewritten() {
    int[] loop = IntClass.loop();
    int[] loopRewritten = IntClass.loopRewritten();
    assertArrayEquals(loop, loopRewritten);
  }

  @Test
  void loopRewritten2() {
    int[] loopRewritten = IntClass.loopRewritten();
    int[] loopRewritten2 = IntClass.loopRewritten2();
    assertArrayEquals(loopRewritten, loopRewritten2);
  }

  @Test
  void loopRewritten3() {
    int[] loopRewritten2 = IntClass.loopRewritten2();
    int[] loopRewritten3 = IntClass.loopRewritten3();
    assertArrayEquals(loopRewritten2, loopRewritten3);
  }
  
  @Test
  void overflow() {
    long z = 0;
    for (int j = 0; j < 100_000; j++) {
      z = Math.addExact(j, z);
    }
    assertEquals(4999950000L, z);
    assertEquals(4999950000L, 99_999L * (100_000L / 2L));
  }

}
