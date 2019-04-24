package pl.edu.utp.wtie.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pl.edu.utp.wtie.App;

public class AdminController {
	
	@FXML
	private Button logoutButton;
	
	@FXML
	private void logout() {
		App.setPane(App.SIGN_IN);
	}
	
	@FXML
	private void closeApp() {
		System.exit(0);
	}
	
	@FXML
	private void minimizeApp() {
		App.primaryStage.setIconified(true);
	}
	
	@FXML
	void initialize() {

	}
}
