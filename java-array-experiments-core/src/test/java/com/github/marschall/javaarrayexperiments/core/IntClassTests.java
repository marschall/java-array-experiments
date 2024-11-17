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
    int[] loop = IntClass.loopRewritten();
    int[] loopRewritten = IntClass.loopRewritten2();
    assertArrayEquals(loop, loopRewritten);
  }

}
