module com.cloudedmemories.FileManagerDesktopApp {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires org.apache.commons.io;

	exports com.cloudedmemories.login;
	exports com.cloudedmemories.FileManagerDesktopApp.Utility;

	opens com.cloudedmemories.login to javafx.fxml;
	opens com.cloudedmemories.FileManagerDesktopApp.Utility to javafx.fxml;

	opens com.cloudedmemories.FileManagerDesktopApp to javafx.fxml;
}