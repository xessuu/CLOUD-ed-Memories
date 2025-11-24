package com.cloudedmemories.login;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.InputStream;
import com.cloudedmemories.FileManagerDesktopApp.Utility.App;

public class LoginPageDesign extends Application {

    private static final String IMAGE_PATH = "/images/background/CLOUDed.png";

    @Override
    public void start(Stage primaryStage) {

        InputStream bgStream = getClass().getResourceAsStream(IMAGE_PATH);
        if (bgStream == null) {
            System.err.println("FATAL ERROR: Background image not found! Path checked: " + IMAGE_PATH);
        }
        Image bgImage = (bgStream != null) ? new Image(bgStream) : null;
        ImageView bgImageView = new ImageView(bgImage);
        bgImageView.setFitWidth(800);
        bgImageView.setFitHeight(600);
        bgImageView.setPreserveRatio(false);

        VBox loginForm = new VBox(15);
        loginForm.setAlignment(Pos.CENTER);
        loginForm.setMaxWidth(300);
        loginForm.setTranslateY(-50);

        TextField username = createStyledField(new TextField(), "admin");
        PasswordField password = createStyledField(new PasswordField(), "1234");

        Button loginButton = new Button("Login");
        loginButton.setStyle(
                "-fx-font-size: 9pt; " +
                        "-fx-padding: 3 12; " +
                        "-fx-background-color: linear-gradient(#fcc200, #ff9900); " +
                        "-fx-text-fill: black; " +
                        "-fx-background-radius: 15; " +
                        "-fx-cursor: hand;"
        );

        loginButton.setOnAction(e -> {
            String user = username.getText();
            String pass = password.getText();

            if(user.equals("admin") && pass.equals("1234")) {
                System.out.println("Login successful!");

                primaryStage.close();

                try {
                    App mainApp = new App();
                    mainApp.start(new Stage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.err.println("CRITICAL FAILURE: Failed to start main app. Check App.java FXML path!");
                }

            } else {
                System.err.println("Incorrect username or password");
            }
        });

        loginForm.getChildren().addAll(username, password, loginButton);

        StackPane root = new StackPane(bgImageView, loginForm);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Login Page Design");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private <T extends TextField> T createStyledField(T field, String placeholder) {
        field.setPromptText(placeholder);
        field.setMaxWidth(250);
        field.setStyle("-fx-font-size: 12pt; -fx-padding: 8; -fx-background-color: rgba(255, 255, 255, 0.8); -fx-background-radius: 10;");
        field.setEffect(new DropShadow(5, Color.BLACK));
        return field;
    }

    public static void main(String[] args) {
        launch(args);
    }
}