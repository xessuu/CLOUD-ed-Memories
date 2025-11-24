package com.cloudedmemories.FileManagerDesktopApp.Utility;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

	// Ang saktong ABSOLUTE PATH
	private static final String FXML_PATH = "/com/cloudedmemories/FileManagerDesktopApp/DashboardUI.fxml";

	@Override
	public void start(Stage stage) throws IOException {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource(FXML_PATH)
			);

			if (fxmlLoader.getLocation() == null) {
				throw new IOException("FXML resource not found! Path tried: " + FXML_PATH);
			}

			Scene scene = new Scene(fxmlLoader.load(), 1200, 700);

			stage.setTitle("CLOUD-ed Memories File Manager");
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("CRITICAL FXML LOAD ERROR: Check DashboardUI.fxml and its contents/controller.", e);
		}
	}

	public static void main(String[] args) {
		launch();
	}
}