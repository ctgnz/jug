package nz.co.ctg.javafx;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class OptionsPane extends BorderPane {
  
  public OptionsPane(String title) {
    setTop(new Label(title));
    setCenter(new GridPane());
  }
  
}
