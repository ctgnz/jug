package nz.co.ctg.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DemoApplication extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane pane = new BorderPane();
		pane.setTop(new Label("Options"));
    primaryStage.setScene(new Scene(pane));
		primaryStage.setTitle("JavaFX Demo");
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.show();
	}

}
