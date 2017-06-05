package nz.co.ctg.fxpong.game;

import javafx.beans.binding.Bindings;
import javafx.scene.shape.Rectangle;
import nz.co.ctg.fxpong.model.Puck;

public class PuckSprite extends Rectangle {
  private Puck puck;

  public PuckSprite(Puck puck) {
    getStyleClass().add("puck");
    this.puck = puck;
    double w = puck.getWidth();
    double h = puck.getHeight();
    setWidth(w);
    setHeight(h);
    setTranslateX(-w / 2);
    setTranslateY(-h / 2);
    layoutXProperty().bind(Bindings.createDoubleBinding(() -> puck.centreProperty().get().x, puck.centreProperty()));
    layoutYProperty().bind(Bindings.createDoubleBinding(() -> puck.centreProperty().get().y, puck.centreProperty()));
  }

  public Puck getPuck() {
    return puck;
  }

  public void setPuck(Puck puck) {
    this.puck = puck;
  }
}
