package pl.edu.utp.wtie.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import pl.edu.utp.wtie.App;

public class RootController {
	
	@FXML
	private StackPane stackPane;

	private double xOffset = 0;
	private double yOffset = 0;
	
	private void makeWindowDragable() {
		stackPane.setOnMousePressed((e) -> {
            xOffset = App.primaryStage.getX() - e.getScreenX();
            yOffset = App.primaryStage.getY() - e.getScreenY();
		});
		
		stackPane.setOnMouseDragged((e) -> {
			App.primaryStage.setX(e.getScreenX() + xOffset);
			App.primaryStage.setY(e.getScreenY() + yOffset);
		});
	}
	
	@FXML
	void initialize() {
		makeWindowDragable();
	}
}
