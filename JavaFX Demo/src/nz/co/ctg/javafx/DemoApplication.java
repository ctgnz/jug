package nz.co.ctg.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DemoApplication extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		OptionsPane options = new OptionsPane();
    primaryStage.setScene(new Scene(options));
		primaryStage.setTitle("JavaFX Demo");
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.show();
	}

}
