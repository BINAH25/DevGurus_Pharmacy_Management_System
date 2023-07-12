module com.example.pharmacy_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires fontawesomefx;


    opens com.example.pharmacy_management_system to javafx.fxml;
    exports com.example.pharmacy_management_system;
    opens com.example.pharmacy_management_system.Data to javafx.fxml;
    exports com.example.pharmacy_management_system.Data;
}