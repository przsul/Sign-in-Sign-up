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
	void initialize() {
		loginButton.setOnAction(a -> {
			if(App.database.login(loginTextField.getText(), passPasswordField.getText(), passTextField.getText())) {
				Alert alert = new Alert(AlertType.INFORMATION, "Successful login!", ButtonType.OK);
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.ERROR, "Bad login or password.", ButtonType.OK);
				alert.showAndWait();				
			}
		});
	}
}
