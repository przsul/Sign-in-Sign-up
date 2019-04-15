package pl.edu.utp.wtie;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
	
	private static FXMLLoader loader;
	private static StackPane stackPane;
	public static final Database database = new Database();

	@Override
	public void start(Stage primaryStage) throws IOException {
		loader = new FXMLLoader(getClass().getResource("/fxml/SignInScene.fxml"));
		stackPane = loader.load();
				
		Scene scene = new Scene(stackPane);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("App");
		primaryStage.show();
		
		App.database.connect();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
