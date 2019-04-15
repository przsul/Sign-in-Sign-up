package pl.edu.utp.wtie.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pl.edu.utp.wtie.App;

public class UserController {
	
	@FXML
	private Button logoutButton;
	
	@FXML
	private void logout() {
		App.setPane(1);
	}
	
	@FXML
	void initialize() {

	}
}
