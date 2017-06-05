package nz.co.ctg.fxpong.game;

import org.eclipse.gef4.geometry.planar.Point;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import nz.co.ctg.fxpong.model.GameArena;

public class ArenaPane extends Pane {
  private GameArena arena;

  public ArenaPane(GameArena arena) {
    this.arena = arena;
    getStyleClass().add("arena");
    setWidth(arena.getBoundary().getWidth());
    setHeight(arena.getBoundary().getHeight());
    getChildren().add(createHalfwayLine());
  }

  private Line createHalfwayLine() {
    Line halfway = new Line();
    halfway.getStyleClass().add("halfway-line");
    Point top = arena.getBoundary().getTop();
    Point bottom = arena.getBoundary().getBottom();
    halfway.setStartX(top.x);
    halfway.setStartY(top.y);
    halfway.setEndX(bottom.x);
    halfway.setEndY(bottom.y);
    return halfway;
  }

}