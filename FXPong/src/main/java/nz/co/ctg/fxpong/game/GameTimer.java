package nz.co.ctg.fxpong.game;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import nz.co.ctg.fxpong.model.Moveable;
import nz.co.ctg.fxpong.model.Puck;
import nz.co.ctg.fxpong.options.GameOptions;

public class GameTimer extends AnimationTimer {
  private int frameCount;
  private List<Moveable> movers = new ArrayList<>();
  private Puck puck;
  private GameOptions options;

  @Override
  public void handle(long now) {
    movers.forEach(mover -> mover.update());
    if (options.isIncreasePuckVelocity() && ++frameCount % 300 == 0) {
      System.out.println("Tick " + System.currentTimeMillis());
      puck.increaseVelocity();
    }
  }

  public void add(Moveable mover) {
    this.movers.add(mover);
    if (mover instanceof Puck) {
      this.puck = (Puck) mover;
    }
  }

  public void setOptions(GameOptions options) {
    this.options = options;
  }

}
