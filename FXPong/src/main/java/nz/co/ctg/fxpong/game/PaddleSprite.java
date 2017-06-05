package nz.co.ctg.fxpong.game;

import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import nz.co.ctg.fxpong.model.Paddle;

public class PaddleSprite extends Rectangle {
  private Paddle paddle;
  private final KeyCode upKey;
  private final KeyCode downKey;

  public PaddleSprite(Paddle paddle) {
    getStyleClass().add("paddle");
    this.paddle = paddle;
    double w = paddle.getWidth();
    double h = paddle.getHeight();
    setWidth(w);
    setHeight(h);
    setTranslateX(-w / 2);
    setTranslateY(-h / 2);
    layoutXProperty().bind(paddle.xProperty());
    layoutYProperty().bind(paddle.yProperty());
    if (paddle.getSide() == Side.LEFT) {
      upKey = KeyCode.A;
      downKey = KeyCode.Z;
    } else {
      upKey = KeyCode.UP;
      downKey = KeyCode.DOWN;
    }
  }

  public EventHandler<KeyEvent> keyReleasedHandler() {
    return evt -> {
      if (evt.getCode() == upKey || evt.getCode() == downKey) {
        paddle.stopMoving();
      }
    };
  }

  public EventHandler<KeyEvent> keyPressedHandler() {
    return evt -> {
      if (evt.getCode() == upKey) {
        paddle.moveUp();
      } else if (evt.getCode() == downKey) {
        paddle.moveDown();
      }
    };
  }

  public Paddle getPaddle() {
    return paddle;
  }

  public void setPaddle(Paddle paddle) {
    this.paddle = paddle;
  }

}
