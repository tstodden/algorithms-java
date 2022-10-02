package io.tstodden.algorithms.collinear;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

  private final Point[] points;
  private LineSegment[] segments;

  private static final double ACCEPTABLE_DELTA = 0.0001;

  /**
   * Initializes a new brute force collinear point evaluator.
   *
   * @param points the array of points to evaluate
   * @throws IllegalArguementException if points or any point within points is null
   */
  public BruteCollinearPoints(Point[] points) {
    if (points == null) {
      throw new IllegalArgumentException("points cannot be null");
    }
    for (Point p : points) {
      if (p == null) {
        throw new IllegalArgumentException("no point can be null");
      }
    }
    this.points = points;
  }

  /**
   * @return the number of collinear line segments identified in the point array
   */
  public int numberOfSegments() {
    if (segments == null) {
      segments = createSegments();
    }
    return segments.length;
  }

  /**
   * @return the collinear line segments identified in the point array
   */
  public LineSegment[] segments() {
    if (segments == null) {
      segments = createSegments();
    }
    return segments;
  }

  private LineSegment[] createSegments() {
    List<LineSegment> segments = new ArrayList<>();

    Arrays.sort(points);

    for (int i = 0; i < points.length - 3; i++) {
      for (int j = i + 1; j < points.length - 2; j++) {
        for (int k = j + 1; k < points.length - 1; k++) {
          for (int m = k + 1; m < points.length; m++) {
            double slopeJ = points[i].slopeTo(points[j]);
            double slopeK = points[i].slopeTo(points[k]);
            double slopeM = points[i].slopeTo(points[m]);

            if (fuzzyEquals(slopeJ, slopeK) && fuzzyEquals(slopeK, slopeM)) {
              segments.add(new LineSegment(points[i], points[m]));
            }
          }
        }
      }
    }
    LineSegment[] result = new LineSegment[segments.size()];
    return segments.toArray(result);
  }

  private boolean fuzzyEquals(double x, double y) {
    if (x == Double.POSITIVE_INFINITY && y == Double.POSITIVE_INFINITY) {
      return true;
    } else if (x == Double.POSITIVE_INFINITY || y == Double.POSITIVE_INFINITY) {
      return false;
    }
    return Math.abs(x - y) < ACCEPTABLE_DELTA;
  }

  public static void main(String[] args) {

    // read the n points from a file
    In in = new In(args[0]);
    int n = in.readInt();
    Point[] points = new Point[n];
    for (int i = 0; i < n; i++) {
      int x = in.readInt();
      int y = in.readInt();
      points[i] = new Point(x, y);
    }

    // draw the points
    StdDraw.enableDoubleBuffering();
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    for (Point p : points) {
      p.draw();
    }
    StdDraw.show();

    // print and draw the line segments
    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
    for (LineSegment segment : collinear.segments()) {
      StdOut.println(segment);
      segment.draw();
    }
    StdDraw.show();
  }
}
