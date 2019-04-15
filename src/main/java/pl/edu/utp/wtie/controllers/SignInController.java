package pl.edu.utp.wtie.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {
	
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
    private void toggleVisiblePassword(ActionEvent event) {
        if (showPassCheckBox.isSelected()) {
            passTextField.setText(passPasswordField.getText());
            passTextField.setVisible(true);
            passPasswordField.setVisible(false);
            return;
        }
        passPasswordField.setText(passTextField.getText());
        passPasswordField.setVisible(true);
        passTextField.setVisible(false);
    }
	
	@FXML
	void initialize() {
		
	}
}
