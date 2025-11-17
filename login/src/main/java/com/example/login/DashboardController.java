package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button logoutButton;

    /**
     * Initializes the controller and sets the welcome message.
     * This method is called by the LoginController after loading the FXML.
     */
    public void initData(String username) {
        welcomeLabel.setText("Welcome, " + username + "!");
    }

    @FXML
    protected void handleLogoutButtonAction(ActionEvent event) {
        try {
            // Load the login.fxml file
            Parent loginRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));

            // Get the current stage (window)
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the login root
            Scene scene = new Scene(loginRoot);

            // Set the scene on the stage
            stage.setScene(scene);
            stage.setTitle("Login - Welcome!");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            // Handle error (e.g., show an alert)
        }
    }
}