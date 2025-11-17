module com.cloudedmemories.FileManagerDesktopApp {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires java.desktop;

	opens com.cloudedmemories.FileManagerDesktopApp to javafx.fxml, javafx.base;
	opens com.cloudedmemories.FileManagerDesktopApp.model to javafx.base;

	exports com.cloudedmemories.FileManagerDesktopApp;
	exports com.cloudedmemories.FileManagerDesktopApp.model;
	exports com.cloudedmemories.FileManagerDesktopApp.Utility;
}


