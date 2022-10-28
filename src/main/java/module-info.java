module com.example.jogodavelhamateus {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.jogodavelhamateus to javafx.fxml;
    exports com.example.jogodavelhamateus;
    exports com.example.jogodavelhamateus.controller;
    opens com.example.jogodavelhamateus.controller to javafx.fxml;
}