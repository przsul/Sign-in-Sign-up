package pl.edu.utp.wtie.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import pl.edu.utp.wtie.App;

public class SignInController {
	
	private int loginAttempt = 0;
	
    @FXML
    private Button loginButton;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passPasswordField;

    @FXML
    private Label signInLabel;

    @FXML
    private Label signUpLabel;

    @FXML
    private CheckBox showPassCheckBox;

    @FXML
    private TextField passTextField;
    
	@FXML
	private void closeApp() {
		System.exit(0);
	}
	
	@FXML
	private void minimizeApp() {
		App.primaryStage.setIconified(true);
	}
    
    @FXML
    private void toggleVisiblePassword(ActionEvent event) {
        if (showPassCheckBox.isSelected()) {
            passTextField.setText(passPasswordField.getText());
            passTextField.setVisible(true);
            passPasswordField.setText("");
            passPasswordField.setVisible(false);
            return;
        }
        passPasswordField.setText(passTextField.getText());
        passPasswordField.setVisible(true);
        passTextField.setText("");
        passTextField.setVisible(false);
    }
    
    @FXML
    private void toggleToSignUp() {
    	App.setPane(App.SIGN_UP);
    }
	
	@FXML
	void initialize() {
		loginButton.defaultButtonProperty().bind(loginButton.focusedProperty());
		
		loginButton.setOnAction(a -> {
			
			String privilege = App.database.login(loginTextField.getText(), passPasswordField.getText(), passTextField.getText());
			
			loginTextField.setText("");
			passTextField.setText("");
			passPasswordField.setText("");
			
			if(privilege == null) {
				Alert alert = new Alert(AlertType.ERROR, "Bad login or password.", ButtonType.OK);
				alert.showAndWait();
				loginAttempt++;
			} else if(privilege.equals("Admin"))
				App.setPane(App.ADMIN);
			else if(privilege.equals("User"))
				App.setPane(App.USER);
			
			if(loginAttempt == 3) {
				
				loginTextField.setDisable(true);
				passTextField.setDisable(true);
				passPasswordField.setDisable(true);
				showPassCheckBox.setDisable(true);
				loginButton.setDisable(true);
				
				Alert alert = new Alert(AlertType.ERROR, "You have exceeded the login limit.", ButtonType.OK);
				alert.showAndWait();
			}
		});
	}
}
