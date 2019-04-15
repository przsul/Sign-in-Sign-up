package pl.edu.utp.wtie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
	
	private static FXMLLoader loader;
	private static StackPane stackPane;
	private static List<Pane> panes = new ArrayList<>();
	private static int idx_cur = 0;
	
	public static final Database database = new Database();

	@Override
	public void start(Stage primaryStage) throws IOException {
		loader = new FXMLLoader(getClass().getResource("/fxml/RootScene.fxml"));
		stackPane = loader.load();
		
		panes.add((Pane)FXMLLoader.load(getClass().getResource("/fxml/SignUpScene.fxml")));
		panes.add((Pane)FXMLLoader.load(getClass().getResource("/fxml/SignInScene.fxml")));
		
		stackPane.getChildren().add(panes.get(0));
		
		Scene scene = new Scene(stackPane);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("LAB 4");
		primaryStage.show();
		
		App.database.connect();
	}
	
	public static void setPane(int idx) {
		stackPane.getChildren().remove(panes.get(idx_cur));
		stackPane.getChildren().add(panes.get(idx));
		idx_cur = idx;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
