package sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Selection {
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

  private static <T extends Comparable<T>> boolean less(T v, T w) {
    return v.compareTo(w) < 0;
  }

  private static <T extends Comparable<T>> void exchange(T[] a, int i, int j) {
    T t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static <T extends Comparable<T>> void show(T[] a) {
    for (T item : a) {
      StdOut.print(item + " ");
    }
    StdOut.println();
  }

  private static <T extends Comparable<T>> boolean isSorted(T[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String[] a = StdIn.readAllStrings();
    sort(a);
    assert isSorted(a);
    show(a);
  }
}
