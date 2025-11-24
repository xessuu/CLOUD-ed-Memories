module com.cloudedmemories.FileManagerDesktopApp {
	// Requires (JavaFX modules ug uban pa)
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires org.apache.commons.io;

	// EXPORTS
	exports com.cloudedmemories.login;
	exports com.cloudedmemories.FileManagerDesktopApp.Utility;

	// OPENS (Para ma-load ang FXML files ug Controllers)
	opens com.cloudedmemories.login to javafx.fxml;
	opens com.cloudedmemories.FileManagerDesktopApp.Utility to javafx.fxml;

	// Para sa root resources/FXML files
	opens com.cloudedmemories.FileManagerDesktopApp to javafx.fxml;
}