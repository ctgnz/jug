package nz.co.ctg.fxpong.model;

import org.eclipse.gef4.geometry.planar.Point;
import org.eclipse.gef4.geometry.planar.Rectangle;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Side;

public class Paddle implements Moveable {
  private double width;
  private double height;
  private Side side;
  private SimpleDoubleProperty x = new SimpleDoubleProperty();
  private SimpleDoubleProperty y = new SimpleDoubleProperty();
  private boolean moveUp;
  private boolean moveDown;
  private DoubleProperty velocity = new SimpleDoubleProperty(3.5d);
  private GameArena arena;
  private Rectangle bounds;
  private Puck puck;

  public Paddle(Side side, double width, double height) {
    this.side = side;
    this.width = width;
    this.height = height;
    this.bounds = new Rectangle(-width / 2, -height / 2, width, height);
  }

  public double getHeight() {
    return height;
  }

  public Side getSide() {
    return side;
  }

  public double getVelocity() {
    return velocity.get();
  }

  public double getWidth() {
    return width;
  }

  public void moveDown() {
    this.moveUp = false;
    this.moveDown = true;
  }

  public void moveUp() {
    this.moveUp = true;
    this.moveDown = false;
  }

  public void setArena(GameArena arena) {
    this.arena = arena;
  }

  public void setCentre(Point point) {
    x.set(point.x);
    y.set(point.y);
    bounds.translate(point);
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public void setSide(Side side) {
    this.side = side;
  }

  public void setVelocity(double velocity) {
    this.velocity.set(velocity);
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public void stopMoving() {
    this.moveUp = false;
    this.moveDown = false;
  }

  @Override
  public void update() {
    double delta = getVelocity();
    if (moveUp) {
      if (!bounds.touches(arena.getTop())) {
        bounds.translate(0, -delta);
        y.set(bounds.getCenter().y);
      }
    } else if (moveDown) {
      if (!bounds.touches(arena.getBottom())) {
        bounds.translate(0, delta);
        y.set(bounds.getCenter().y);
      }
    }
    if (puck.getBounds().touches(bounds)) {
      puck.reflect();
//      setNextBounce(getReflection());
    }
  }

  public DoubleProperty xProperty() {
    return x;
  }

  public DoubleProperty yProperty() {
    return y;
  }

  public void setPuck(Puck puck) {
    this.puck = puck;
  }

}
