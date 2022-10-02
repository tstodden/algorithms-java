package io.tstodden.algorithms.collinear;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class TestBruteCollinearPoints {

  @Test
  public void testTwoLinesWithBothPositiveAndNegativeSlopes() {
    Point[] points = {
      new Point(+0, +0),
      new Point(+2, -2),
      new Point(+1, +1),
      new Point(-1, +0),
      new Point(+2, +2),
      new Point(+1, -1),
      new Point(-1, +1),
      new Point(-1, -1),
      new Point(+2, +1)
    };
    var sut = new BruteCollinearPoints(points);

    int got = sut.numberOfSegments();

    assertEquals(2, got);
  }

  @Test
  public void testOneLineWithAVerticalSlope() {
    Point[] points = {
      new Point(0, 0), new Point(0, 2), new Point(0, 1), new Point(0, -1), new Point(2, 0),
    };
    var sut = new BruteCollinearPoints(points);

    int got = sut.numberOfSegments();

    assertEquals(1, got);
  }

  @Test
  public void testOneLineWithAHorizontalSlope() {
    Point[] points = {
      new Point(1, 0), new Point(2, 0), new Point(-1, 0), new Point(0, 0), new Point(0, 2),
    };

    var sut = new BruteCollinearPoints(points);

    int got = sut.numberOfSegments();

    assertEquals(1, got);
  }

  @Test
  public void testThrowsWhenPointsIsNull() {
    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> new BruteCollinearPoints(null));

    assertEquals("points cannot be null", exception.getMessage());
  }

  @Test
  public void testThrowsWhenAPointIsNull() {
    Point[] points = {new Point(0, 0), null};

    Exception exception =
        assertThrows(IllegalArgumentException.class, () -> new BruteCollinearPoints(points));

    assertEquals("no point can be null", exception.getMessage());
  }
}
