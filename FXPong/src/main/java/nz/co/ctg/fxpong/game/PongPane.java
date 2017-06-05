package nz.co.ctg.fxpong.game;

import javax.inject.Inject;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import nz.co.ctg.fxpong.model.Game;

public class PongPane extends BorderPane {
  private GameController controller;
  private PuckSprite puck;
  private PaddleSprite paddleA;
  private PaddleSprite paddleB;
  private Pane arena;

  @Inject
  public PongPane(GameController gc) {
    this.controller = gc;
    getStyleClass().add("pong");
    arena = new ArenaPane(controller.getArena());
    setCenter(arena);
    setMinSize(arena.getWidth(), arena.getHeight());
    arena.setOnKeyPressed(evt -> {
      if (evt.getCode() == KeyCode.SPACE) {
        startGame();
      }
    });
  }

  @Override
  public void requestFocus() {
    arena.requestFocus();
  }

  private void startGame() {
    Game game = controller.startGame();
    puck = new PuckSprite(game.getPuck());
    paddleA = new PaddleSprite(game.getPlayerA().getPaddle());
    paddleB = new PaddleSprite(game.getPlayerB().getPaddle());
    arena.getChildren().addAll(puck, paddleA, paddleB);
    arena.addEventHandler(KeyEvent.KEY_PRESSED, paddleA.keyPressedHandler());
    arena.addEventHandler(KeyEvent.KEY_PRESSED, paddleB.keyPressedHandler());
    arena.addEventHandler(KeyEvent.KEY_RELEASED, paddleA.keyReleasedHandler());
    arena.addEventHandler(KeyEvent.KEY_RELEASED, paddleB.keyReleasedHandler());
  }
}
