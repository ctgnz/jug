package nz.co.ctg.fxpong.model;

import javafx.geometry.Side;

public class Player {
  private String name;
  private Paddle paddle;
  private int score;

  public Player(Side side) {
    paddle = new Paddle(side, 16, 64);
  }

  public String getName() {
    return name;
  }

  public Paddle getPaddle() {
    return paddle;
  }

  public int getScore() {
    return score;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPaddle(Paddle paddle) {
    this.paddle = paddle;
  }

  public void setScore(int score) {
    this.score = score;
  }
}
