package com.cloudedmemories.FileManagerDesktopApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;
    @FXML private Label messageLabel;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.equals("admin") && password.equals("1234")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardUi.fxml"));
                AnchorPane dashboard = loader.load();

                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(new Scene(dashboard, 1200, 850));
                stage.setTitle("Dashboard - Clouded Memories");
            } catch (Exception e) {
                e.printStackTrace();
                messageLabel.setText("Failed to load Dashboard");
            }
        } else {
            messageLabel.setText("Invalid username or password");
        }
    }
}
