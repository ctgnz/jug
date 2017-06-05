package nz.co.ctg.fxpong.model;

import org.eclipse.gef4.geometry.euclidean.Angle;
import org.eclipse.gef4.geometry.planar.Dimension;
import org.eclipse.gef4.geometry.planar.Line;
import org.eclipse.gef4.geometry.planar.Point;
import org.eclipse.gef4.geometry.planar.Rectangle;

import javafx.geometry.Side;

public class GameArena {
  private final Rectangle boundary;
  private final Line top;
  private final Line right;
  private final Line bottom;
  private final Line left;

  public GameArena(Dimension size) {
    boundary = new Rectangle(0, 0, size.width, size.height);
    top = new Line(boundary.getTopLeft(), boundary.getTopRight());
    right = new Line(boundary.getTopRight(), boundary.getBottomRight());
    bottom = new Line(boundary.getBottomRight(), boundary.getBottomLeft());
    left = new Line(boundary.getBottomLeft(), boundary.getTopLeft());
  }

  public Line getBottom() {
    return bottom;
  }

  public Rectangle getBoundary() {
    return boundary;
  }

  public Point getCentre() {
    return boundary.getCenter();
  }

  public Line getLeft() {
    return left;
  }

  public Point getLeftPlayerStart() {
    return new Point(50, boundary.getHeight() / 2);
  }

  public Angle getReflection(Point point, Angle direction) {
    return direction.getOppositeSemi();
  }

  public Line getRight() {
    return right;
  }

  public Point getRightPlayerStart() {
    return new Point(boundary.getWidth() - 50, boundary.getHeight() / 2);
  }

  public Line getTop() {
    return top;
  }

  public Bounce getWallHit(Point start, Angle direction) {
    Point end = Geometry.getPointOnLine(start, direction, 2000);
    Line vector = new Line(start, end);
    if (vector.intersects(top)) {
      return new Bounce(start, Side.TOP, direction, vector.getIntersection(top));
    } else if (vector.intersects(right)) {
      return new Bounce(start, Side.RIGHT, direction, vector.getIntersection(right));
    } else if (vector.intersects(bottom)) {
      return new Bounce(start, Side.BOTTOM, direction, vector.getIntersection(bottom));
    } else if (vector.intersects(left)) {
      return new Bounce(start, Side.LEFT, direction, vector.getIntersection(left));
    }
    return null;
  }

}
