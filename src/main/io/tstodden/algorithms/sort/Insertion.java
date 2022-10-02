package io.tstodden.algorithms.sort;

import edu.princeton.cs.algs4.StdIn;

public class Insertion extends Sorter {

  public static <T extends Comparable<T>> void sort(T[] a) {
    for (int i = 1; i < a.length; i++) {
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exchange(a, j, j - 1);
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
