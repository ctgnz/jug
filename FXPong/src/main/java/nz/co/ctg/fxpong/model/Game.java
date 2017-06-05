package nz.co.ctg.fxpong.model;

import java.util.Random;

import org.eclipse.gef4.geometry.euclidean.Angle;
import org.eclipse.gef4.geometry.planar.Point;

import nz.co.ctg.fxpong.game.GameTimer;
import nz.co.ctg.fxpong.options.GameOptions;

public class Game {
  private Player playerA;
  private Player playerB;
  private Puck puck = new Puck(16, 16);
  private GameArena arena;
  private GameTimer timer = new GameTimer();
  private Random random = new Random();
  private GameOptions options;

  public Game(GameArena arena, GameOptions options) {
    this.arena = arena;
    this.options = options;
  }

  public void init(Player playerA, Player playerB) {
    puck.setCentre(arena.getCentre());
    puck.setArena(arena);
    puck.setDirection(getFirstBounce());
    timer.setOptions(options);
    timer.add(puck);
    this.playerA = playerA;
    this.playerB = playerB;
    initPlayer(playerA, arena.getLeftPlayerStart());
    initPlayer(playerB, arena.getRightPlayerStart());
    timer.start();
  }

  private void initPlayer(Player player, Point startPoint) {
    player.setScore(0);
    player.getPaddle().setCentre(startPoint);
    player.getPaddle().setArena(arena);
    player.getPaddle().setPuck(puck);
    timer.add(player.getPaddle());
  }

  private Angle getFirstBounce() {
    return random.nextBoolean() ? Angle.fromDeg(random.nextInt(60) - 30) : Angle.fromDeg(random.nextInt(60) + 150);
  }

  public Player getPlayerA() {
    return playerA;
  }

  public Player getPlayerB() {
    return playerB;
  }

  public Puck getPuck() {
    return puck;
  }

  public void setPlayerA(Player playerA) {
    this.playerA = playerA;
  }

  public void setPlayerB(Player playerB) {
    this.playerB = playerB;
  }

  public void setPuck(Puck puck) {
    this.puck = puck;
  }
}
