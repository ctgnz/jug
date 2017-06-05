package nz.co.ctg.fxpong.model;

import org.eclipse.gef4.geometry.euclidean.Angle;
import org.eclipse.gef4.geometry.planar.Point;
import org.eclipse.gef4.geometry.planar.Rectangle;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Puck implements Moveable {
  public static final double INITIAL_VELOCITY = 5;
  public static final double MAX_VELOCITY = 30;
  private double width;
  private double height;
  private Angle direction = Angle.fromDeg(0);
  private Point[] points;
  private int counter;
  private Bounce bounce;
  private Point destination;
  private GameArena arena;
  private ObjectProperty<Point> centre = new SimpleObjectProperty<>();
  private DoubleProperty velocity = new SimpleDoubleProperty(INITIAL_VELOCITY);
  private Rectangle bounds;

  public Puck(double width, double height) {
    this.width = width;
    this.height = height;
    this.bounds = new Rectangle(-width / 2, -height / 2, width, height);
  }

  public ObjectProperty<Point> centreProperty() {
    return centre;
  }

  public Point getCentre() {
    return centre.get();
  }

  public Angle getDirection() {
    return direction;
  }

  public double getHeight() {
    return height;
  }

  public Point getNextPoint() {
    return ++counter < points.length ? points[counter] : reflect();
  }

  public double getVelocity() {
    return velocity.get();
  }

  public double getWidth() {
    return width;
  }

  public void setArena(GameArena arena) {
    this.arena = arena;
  }

  public void setCentre(Point center) {
    centre.set(center);
    bounds.translate(bounds.getCenter().getDifference(center));
  }

  public void setDirection(Angle direction) {
    this.direction = direction;
    setNextBounce(direction);
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public void setVelocity(double velocity) {
    this.velocity.set(velocity);
  }

  public void setWidth(double width) {
    this.width = width;
  }

  protected Point reflect() {
    setNextBounce(bounce.getReflection());
    return centre.get();
  }

  private void setNextBounce(Angle direction) {
    counter = 0;
    Point start = centre.get();
    bounce = arena.getWallHit(start, direction);
    destination = bounce.getIntersect();
    points = Geometry.getPointsOnLine(start, destination, bounce.getNextBounce().getLength() / velocity.get());
  }

  public void increaseVelocity() {
    double currentVelocity = velocity.get();
    if (currentVelocity < MAX_VELOCITY) {
      velocity.set(currentVelocity + 1);
    }
  }

  @Override
  public void update() {
    Point pt = getNextPoint();
    if (pt != null) {
      setCentre(pt);
    }
  }

  public Rectangle getBounds() {
    return bounds;
  }

}
