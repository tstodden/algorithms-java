package io.tstodden.algorithms.collinear;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import org.junit.Test;

public class TestPoint {

  private static final Point REFERENCE_POINT = new Point(0, 0);
  private static final double ACCEPTABLE_DELTA = 0.001;

  @Test
  public void testPointLessThanTheReference() {
    Point sut = new Point(-1, -1);

    int got = sut.compareTo(REFERENCE_POINT);

    assertEquals(-1, got);
  }

  @Test
  public void testPointEqualToTheReference() {
    Point sut = new Point(0, 0);

    int got = sut.compareTo(REFERENCE_POINT);

    assertEquals(0, got);
  }

  @Test
  public void testPointGreaterThanTheReference() {
    Point sut = new Point(1, 1);

    int got = sut.compareTo(REFERENCE_POINT);

    assertEquals(1, got);
  }

  @Test
  public void testPointLessThanTheReferenceWithAnEqualY() {
    Point sut = new Point(-1, 0);

    int got = sut.compareTo(REFERENCE_POINT);

    assertEquals(-1, got);
  }

  @Test
  public void testPointGreaterThanTheReferenceWithAnEqualY() {
    Point sut = new Point(1, 0);

    int got = sut.compareTo(REFERENCE_POINT);

    assertEquals(1, got);
  }

  @Test
  public void testPositiveSlopeToTheReference() {
    Point sut = new Point(1, 1);

    double got = sut.slopeTo(REFERENCE_POINT);

    assertEquals(1.0, got, ACCEPTABLE_DELTA);
  }

  @Test
  public void testNegativeSlopeToTheReference() {
    Point sut = new Point(-1, 1);

    double got = sut.slopeTo(REFERENCE_POINT);

    assertEquals(-1, got, ACCEPTABLE_DELTA);
  }

  @Test
  public void testSlopeToTheSamePointAsTheReference() {
    Point sut = new Point(0, 0);

    double got = sut.slopeTo(REFERENCE_POINT);

    assertEquals(Double.NEGATIVE_INFINITY, got, ACCEPTABLE_DELTA);
  }

  @Test
  public void testVerticalSlopeToTheReference() {
    Point sut = new Point(0, 1);

    double got = sut.slopeTo(REFERENCE_POINT);

    assertEquals(Double.POSITIVE_INFINITY, got, ACCEPTABLE_DELTA);
  }

  @Test
  public void testHorizontalSlopeToTheReference() {
    Point sut = new Point(1, 0);

    double got = sut.slopeTo(REFERENCE_POINT);

    assertEquals(0, got, ACCEPTABLE_DELTA);
  }

  public static class TestSlopeOrder {

    private static final Point flatter = new Point(2, 1);
    private static final Point steeper = new Point(1, 2);

    @Test
    public void testGreaterThanCompareForSlopeOrder() {
      Comparator<Point> sut = REFERENCE_POINT.slopeOrder();

      int got = sut.compare(flatter, steeper);

      assertEquals(1, got);
    }

    @Test
    public void testLessThanCompareForSlopeOrder() {
      Comparator<Point> sut = REFERENCE_POINT.slopeOrder();

      int got = sut.compare(steeper, flatter);

      assertEquals(-1, got);
    }

    @Test
    public void testEqualToCompareForSlopeOrder() {
      Comparator<Point> sut = REFERENCE_POINT.slopeOrder();

      int got = sut.compare(steeper, steeper);

      assertEquals(0, got);
    }

    @Test
    public void testVerticalCompareForSlopeOrder() {
      Comparator<Point> sut = REFERENCE_POINT.slopeOrder();
      Point vertical = new Point(0, 2);

      int got = sut.compare(steeper, vertical);

      assertEquals(1, got);
    }

    @Test
    public void testHorizontalCompareForSlopeOrder() {
      Comparator<Point> sut = REFERENCE_POINT.slopeOrder();
      Point horizontal = new Point(2, 0);

      int got = sut.compare(steeper, horizontal);

      assertEquals(-1, got);
    }

    @Test
    public void testSamePointCompareForSlopeOrder() {
      Comparator<Point> sut = REFERENCE_POINT.slopeOrder();

      int got = sut.compare(steeper, REFERENCE_POINT);

      assertEquals(-1, got);
    }
  }
}
