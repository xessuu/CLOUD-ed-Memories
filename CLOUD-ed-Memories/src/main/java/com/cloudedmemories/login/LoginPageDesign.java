package com.cloudedmemories.login;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginPageDesign extends Application {

    @Override
    public void start(Stage primaryStage) {
        // --- Pixelated Cloudy Background ---
        Pane cloudLayer = new Pane();
        cloudLayer.setPrefSize(800, 600);
        cloudLayer.setStyle("-fx-background-color: white;");

        for (int i = 0; i < 8; i++) {
            Circle cloud = new Circle(100, Color.web("lightblue", 0.3));
            cloud.setEffect(new BoxBlur(30, 30, 3));
            cloud.setTranslateX(Math.random() * 800);
            cloud.setTranslateY(Math.random() * 600);

            TranslateTransition drift = new TranslateTransition(Duration.seconds(15 + Math.random() * 10), cloud);
            drift.setFromX(cloud.getTranslateX());
            drift.setToX(cloud.getTranslateX() + 200);
            drift.setCycleCount(Animation.INDEFINITE);
            drift.setAutoReverse(true);
            drift.play();

            cloudLayer.getChildren().add(cloud);
        }

        // --- Login Form ---
        VBox loginForm = new VBox(15); // spacing
        loginForm.setMaxWidth(300);

        TextField username = createStyledField("Username");
        PasswordField password = (PasswordField) createStyledField("Password");

        Button loginButton = new Button("Login");
        loginButton.setStyle(
                "-fx-background-color: #4A9DEC;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-pref-height: 40px;" +
                        "-fx-font-size: 14px;"
        );
        loginButton.setEffect(new DropShadow(5, Color.rgb(74,157,236,0.3)));

        loginForm.getChildren().addAll(username, password, loginButton);

        // Center the form on top of background
        StackPane root = new StackPane(cloudLayer, loginForm);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // --- Styled Text Field / Password Field ---
    private TextField createStyledField(String placeholder) {
        TextField field;
        if (placeholder.equals("Password")) {
            field = new PasswordField();
        } else {
            field = new TextField();
        }
        field.setPromptText(placeholder);

        field.setStyle(
                "-fx-border-color: transparent;" +
                        "-fx-border-width: 2px;" +
                        "-fx-pref-width: 240px;" +
                        "-fx-pref-height: 40px;" +
                        "-fx-padding: 0 0 0 12px;" +
                        "-fx-background-color: #F3F3F3;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-border-radius: 10px;"
        );

        // Hover effect
        field.setOnMouseEntered(e -> {
            field.setStyle(
                    "-fx-border-color: #4A9DEC;" +
                            "-fx-border-width: 2px;" +
                            "-fx-pref-width: 240px;" +
                            "-fx-pref-height: 40px;" +
                            "-fx-padding: 0 0 0 12px;" +
                            "-fx-background-color: white;" +
                            "-fx-background-radius: 10px;" +
                            "-fx-border-radius: 10px;"
            );
            field.setEffect(new DropShadow(7, Color.rgb(74,157,236,0.2)));
        });

        field.setOnMouseExited(e -> {
            field.setStyle(
                    "-fx-border-color: transparent;" +
                            "-fx-border-width: 2px;" +
                            "-fx-pref-width: 240px;" +
                            "-fx-pref-height: 40px;" +
                            "-fx-padding: 0 0 0 12px;" +
                            "-fx-background-color: #F3F3F3;" +
                            "-fx-background-radius: 10px;" +
                            "-fx-border-radius: 10px;"
            );
            field.setEffect(null);
        });

        // Focus effect
        field.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                field.setStyle(
                        "-fx-border-color: #4A9DEC;" +
                                "-fx-border-width: 2px;" +
                                "-fx-pref-width: 240px;" +
                                "-fx-pref-height: 40px;" +
                                "-fx-padding: 0 0 0 12px;" +
                                "-fx-background-color: white;" +
                                "-fx-background-radius: 10px;" +
                                "-fx-border-radius: 10px;"
                );
                field.setEffect(new DropShadow(7, Color.rgb(74,157,236,0.2)));
            } else {
                field.setStyle(
                        "-fx-border-color: transparent;" +
                                "-fx-border-width: 2px;" +
                                "-fx-pref-width: 240px;" +
                                "-fx-pref-height: 40px;" +
                                "-fx-padding: 0 0 0 12px;" +
                                "-fx-background-color: #F3F3F3;" +
                                "-fx-background-radius: 10px;" +
                                "-fx-border-radius: 10px;"
                );
                field.setEffect(null);
            }
        });

        return field;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
