package nz.co.ctg.fxpong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nz.co.ctg.fxpong.game.GameController;
import nz.co.ctg.fxpong.game.PongPane;
import nz.co.ctg.fxpong.options.OptionsPane;

public class PongFX extends Application {
  @Override
  public void start(Stage primaryStage) {
    try {
      StackPane root = new StackPane();
      OptionsPane options = new OptionsPane("Options");
      root.getChildren().add(options);
      PongPane pong = new PongPane(new GameController());
      root.getChildren().add(pong);
      Scene scene = new Scene(root);
      scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.setTitle("Pong FX");
      primaryStage.show();
      pong.requestFocus();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
