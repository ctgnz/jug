package nz.co.ctg.fxpong.model;

import org.eclipse.gef4.geometry.euclidean.Angle;
import org.eclipse.gef4.geometry.planar.Point;

public class Geometry {

  public static Point getPointOnLine(Point start, Angle heading, double distance) {
    double x2 = start.x + distance * Math.cos(heading.rad());
    double y2 = start.y + distance * Math.sin(heading.rad());
    return new Point(x2, y2);
  }

  public static Point[] getPointsOnLine(Point start, Point end, double frameCount) {
    double xdist = end.x - start.x;
    double ydist = end.y - start.y;
    double dx = xdist / frameCount;
    double dy = ydist / frameCount;
    Point[] pts = new Point[(int) frameCount];
    for (int frame = 0; frame < pts.length; frame++) {
      double xoff = dx * frame;
      double yoff = dy * frame;
      pts[frame] = new Point(start.x + xoff, start.y + yoff);
    }
    return pts;
  }

}
