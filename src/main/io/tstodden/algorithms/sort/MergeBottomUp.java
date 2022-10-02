package io.tstodden.algorithms.sort;

import edu.princeton.cs.algs4.StdIn;

public class MergeBottomUp extends Sorter {

  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void sort(T[] a) {
    int n = a.length;
    T[] aux = (T[]) new Comparable[a.length];
    for (int len = 1; len < n; len *= 2) {
      for (int lo = 0; lo < n - len; lo += 2 * len) {
        merge(a, aux, lo, lo + len - 1, Math.min(lo + 2 * len - 1, n - 1));
      }
    }
  }

  private static <T extends Comparable<T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
    int i = lo, j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (less(aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
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
