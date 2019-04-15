package pl.edu.utp.wtie.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import pl.edu.utp.wtie.Database;

public class SignUpController {
	
	private Database database = new Database();
	
    @FXML
    private TextField nameTextField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passPasswordField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Label signInLabel;

    @FXML
    private Label signUpLabel;

    @FXML
    private PasswordField repeatPassPasswordField;
    
    private boolean isPasswordEqual() {
    	return passPasswordField.getText().equals(repeatPassPasswordField.getText());
    }
	
	@FXML
	void initialize() {
		database.connect();

		registerButton.setOnAction(a -> {
			
			if(!isPasswordEqual()) {
				Alert alert = new Alert(AlertType.ERROR, "Passwords are not equal.", ButtonType.OK);
				alert.showAndWait();
				return;
			}
			
			database.registerUser(nameTextField.getText(), lastNameTextField.getText(),
					loginTextField.getText(), passPasswordField.getText(), 
					emailTextField.getText());
		});
	}
}
