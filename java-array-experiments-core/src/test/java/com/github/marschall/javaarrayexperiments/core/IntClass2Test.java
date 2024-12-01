package com.github.marschall.javaarrayexperiments.core;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntClass2Test {

  private int[] a1;
  private int[] a2;
  private int u;
  private int r;

  @BeforeEach
  void setUp() {
    this.a1 = new int[10_000];
    this.a2 = new int[10_000];
    this.u = 40;
    this.r = 3615;
  }

  @Test
  void loop2Rewritten() {
    int[] loop = IntClass2.loop2(this.u, this.r, this.a1);
    int[] loopRewritten = IntClass2.loop2Rewritten(this.u, this.r, this.a2);
    assertArrayEquals(loop, loopRewritten);
  }

  @Test
  void loop2Rewritten2() {
    Arrays.fill(this.a1, 0);
    int[] loop = IntClass2.loop2(this.u, this.r, this.a1);
//    int[] loopRewritten = IntClass2.loop2Rewritten2(this.u, this.r, this.a2);
    int first = loop[0];
    int second = loop[1];
    int last = loop[loop.length - 1];
    long x = (100_000L * this.u) / 2;
    // 1950000 = 48750 * 40
    assertEquals(1953615, first);
    assertEquals(1950000, first - this.r);
    assertEquals(1953615, second);
    assertEquals(1950000, second - this.r);
    assertEquals(1953615, last);
    assertEquals(1950000, last - this.r);
//    assertArrayEquals(loop, loopRewritten);
  }

}
