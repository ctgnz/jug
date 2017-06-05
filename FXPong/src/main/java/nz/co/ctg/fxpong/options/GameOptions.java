package nz.co.ctg.fxpong.options;

import org.eclipse.gef4.geometry.planar.Dimension;

public class GameOptions {
  public static final Dimension SMALL = new Dimension(800, 400);
  public static final Dimension MEDIUM = new Dimension(1200, 600);
  public static final Dimension LARGE = new Dimension(1600, 800);
  private Dimension arenaSize = SMALL;
  private boolean increasePuckVelocity = false;

  public Dimension getArenaSize() {
    return arenaSize;
  }

  public boolean isIncreasePuckVelocity() {
    return increasePuckVelocity;
  }

  public void setArenaSize(Dimension arenaSize) {
    this.arenaSize = arenaSize;
  }

  public void setIncreasePuckVelocity(boolean increasePuckVelocity) {
    this.increasePuckVelocity = increasePuckVelocity;
  }
}
