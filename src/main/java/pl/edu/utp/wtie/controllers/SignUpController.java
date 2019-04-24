package pl.edu.utp.wtie.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.edu.utp.wtie.App;

public class SignUpController {
	
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
    
	@FXML
	private void closeApp() {
		System.exit(0);
	}
	
	@FXML
	private void minimizeApp() {
		App.primaryStage.setIconified(true);
	}
    
    private boolean isPasswordEqual() {
    	return passPasswordField.getText().equals(repeatPassPasswordField.getText());
    }
    
    @FXML
    private void toggleToSignIn() {
    	App.setPane(App.SIGN_IN);
    }
	
	@FXML
	void initialize() {
		registerButton.defaultButtonProperty().bind(registerButton.focusedProperty());
		
		registerButton.setOnAction(a -> {
			
			if(!isPasswordEqual()) {
				Alert alert = new Alert(AlertType.ERROR, "Passwords are not equal.", ButtonType.OK);
				alert.showAndWait();
				return;
			}
			
			App.database.registerUser(nameTextField.getText(), lastNameTextField.getText(),
					loginTextField.getText(), passPasswordField.getText(), 
					emailTextField.getText());
		});
	}
}
