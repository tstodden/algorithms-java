package io.tstodden.algorithms.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestMerge {

  @Test
  public void testSortingStrings() {
    String[] got = {"b", "c", "a", "d"};

    Merge.sort(got);

    String[] want = {"a", "b", "c", "d"};
    assertArrayEquals(want, got);
  }

  @Test
  public void testSortingIntegers() {
    Integer[] got = {4, 2, 3, 1};

    Merge.sort(got);

    Integer[] want = {1, 2, 3, 4};
    assertArrayEquals(want, got);
  }

  @Test
  public void testSortingDoubles() {
    Double[] got = {3.4, 5.6, 1.2, 7.8};

    Merge.sort(got);

    Double[] want = {1.2, 3.4, 5.6, 7.8};
    assertArrayEquals(got, want);
  }
}
