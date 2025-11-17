package com.example.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the login.fxml file as the starting point
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();

        // Set up the scene with a good starting size
        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Login - Welcome!");
        stage.setScene(scene);
        stage.show();
    }
}