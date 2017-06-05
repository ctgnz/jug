package nz.co.ctg.fxpong.model;

import org.eclipse.gef4.geometry.euclidean.Angle;
import org.eclipse.gef4.geometry.planar.Line;
import org.eclipse.gef4.geometry.planar.Point;

import javafx.geometry.Side;

public class Bounce {
  private Side wall;
  private Angle incidence;
  private Point intersect;
  private Angle reflection;
  private Point start;

  public Bounce(Point start, Side wall, Angle incidence, Point intersect) {
    this.start = start;
    this.wall = wall;
    this.incidence = incidence;
    this.intersect = intersect;
    calculateReflection();
  }

  private void calculateReflection() {
    switch (wall) {
      case TOP:
        reflection = incidence.getOppositeFull();
        break;
      case BOTTOM:
        reflection = incidence.getOppositeFull();
        break;
      case LEFT:
        reflection = incidence.getOppositeSemi();
        break;
      case RIGHT:
        reflection = incidence.getOppositeSemi();
        break;
    }
  }

  public Angle getIncidence() {
    return incidence;
  }

  public Point getIntersect() {
    return intersect;
  }

  public Line getNextBounce() {
    return new Line(start, intersect);
  }

  public Angle getReflection() {
    return reflection;
  }

  public Side getWall() {
    return wall;
  }

}
