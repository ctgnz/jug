package nz.co.ctg.fxpong.model;

import static org.junit.Assert.assertEquals;

import org.eclipse.gef4.geometry.euclidean.Angle;
import org.eclipse.gef4.geometry.planar.Point;
import org.junit.Test;

import javafx.geometry.Side;

public class BounceTest {

  @Test
  public void testReflectionTop() throws Exception {
    Bounce bounce = new Bounce(new Point(500, 500), Side.TOP, Angle.fromDeg(300), new Point(500, 0));
    assertEquals(60, bounce.getReflection().deg(), 0.01);
    bounce = new Bounce(new Point(500, 500), Side.TOP, Angle.fromDeg(330), new Point(500, 0));
    assertEquals(30, bounce.getReflection().deg(), 0.01);
    bounce = new Bounce(new Point(500, 500), Side.TOP, Angle.fromDeg(240), new Point(500, 0));
    assertEquals(120, bounce.getReflection().deg(), 0.01);
  }

  @Test
  public void testReflectionRight() throws Exception {
    Bounce bounce = new Bounce(new Point(500, 500), Side.RIGHT, Angle.fromDeg(20), new Point(1000, 500));
    assertEquals(160, bounce.getReflection().deg(), 0.01);
    bounce = new Bounce(new Point(500, 500), Side.RIGHT, Angle.fromDeg(70), new Point(1000, 500));
    assertEquals(110, bounce.getReflection().deg(), 0.01);
    bounce = new Bounce(new Point(500, 500), Side.RIGHT, Angle.fromDeg(300), new Point(1000, 500));
    assertEquals(240, bounce.getReflection().deg(), 0.01);
  }

  @Test
  public void testReflectionBottom() throws Exception {
    Bounce bounce = new Bounce(new Point(500, 500), Side.BOTTOM, Angle.fromDeg(45), new Point(500, 1000));
    assertEquals(315, bounce.getReflection().deg(), 0.01);
    bounce = new Bounce(new Point(500, 500), Side.BOTTOM, Angle.fromDeg(100), new Point(500, 1000));
    assertEquals(260, bounce.getReflection().deg(), 0.01);
    bounce = new Bounce(new Point(500, 500), Side.BOTTOM, Angle.fromDeg(170), new Point(500, 1000));
    assertEquals(190, bounce.getReflection().deg(), 0.01);
  }

  @Test
  public void testReflectionLeft() throws Exception {
    Bounce bounce = new Bounce(new Point(500, 500), Side.LEFT, Angle.fromDeg(200), new Point(0, 500));
    assertEquals(340, bounce.getReflection().deg(), 0.01);
    bounce = new Bounce(new Point(500, 500), Side.LEFT, Angle.fromDeg(250), new Point(0, 500));
    assertEquals(290, bounce.getReflection().deg(), 0.01);
    bounce = new Bounce(new Point(500, 500), Side.LEFT, Angle.fromDeg(120), new Point(0, 500));
    assertEquals(60, bounce.getReflection().deg(), 0.01);
  }

}
