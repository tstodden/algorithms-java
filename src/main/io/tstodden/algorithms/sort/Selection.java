package io.tstodden.algorithms.sort;

import edu.princeton.cs.algs4.StdIn;

public class Selection extends Sorter {
  public static <T extends Comparable<T>> void sort(T[] a) {
    for (int i = 0; i < a.length; i++) {
      int smallest = i;

      for (int j = i + 1; j < a.length; j++) {
        if (less(a[j], a[smallest])) {
          smallest = j;
        }
      }

      if (i != smallest) {
        exchange(a, i, smallest);
      }
    }
  }

  public static void main(String[] args) {
    String[] a = StdIn.readAllStrings();
    sort(a);
    assert isSorted(a);
    show(a);
  }
}
