package nz.co.ctg.fxpong.game;

import javafx.geometry.Side;
import nz.co.ctg.fxpong.model.Game;
import nz.co.ctg.fxpong.model.GameArena;
import nz.co.ctg.fxpong.model.Player;
import nz.co.ctg.fxpong.options.GameOptions;

public class GameController {
  private Game game;
  private GameOptions options = new GameOptions();
  private Player playerA = new Player(Side.LEFT);
  private Player playerB = new Player(Side.RIGHT);
  private GameArena arena = new GameArena(options.getArenaSize());

  public Game startGame() {
    arena = new GameArena(options.getArenaSize());
    game = new Game(arena, options);
    game.init(playerA, playerB);
    return game;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public GameArena getArena() {
    return arena;
  }

}
