package io.tstodden.algorithms.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestMergeBottomUp {

  @Test
  public void testSortingStrings() {
    String[] got = {"b", "c", "a", "d"};

    MergeBottomUp.sort(got);

    String[] want = {"a", "b", "c", "d"};
    assertArrayEquals(want, got);
  }

  @Test
  public void testSortingIntegers() {
    Integer[] got = {4, 2, 3, 1};

    MergeBottomUp.sort(got);

    Integer[] want = {1, 2, 3, 4};
    assertArrayEquals(want, got);
  }

  @Test
  public void testSortingDoubles() {
    Double[] got = {3.4, 5.6, 1.2, 7.8};

    MergeBottomUp.sort(got);

    Double[] want = {1.2, 3.4, 5.6, 7.8};
    assertArrayEquals(got, want);
  }
}
