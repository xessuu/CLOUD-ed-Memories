package com.example.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * This is the controller for your main application scene (hello-view.fxml).
 * It's from your original uploaded files.
 */
public class LoginController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to your Main JavaFX Application!");
    }
}