package nz.co.ctg.javafx;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class OptionsPane extends BorderPane {
  
  public OptionsPane(String title) {
    setTop(new Label(title));
    GridPane form = new GridPane();
    form.addRow(0, new Label("Music"), new CheckBox());
    form.addRow(1, new Label("Audio"), new CheckBox());
    setCenter(form);
  }
  
}
