module com.example.databaseapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires kernel;
    requires layout;
    requires java.desktop;


    opens com.example.ritmic to javafx.fxml;
    exports com.example.ritmic;
    exports com.example.ritmic.GUI;
    opens com.example.ritmic.GUI to javafx.fxml;
    exports com.example.ritmic.database;
    opens com.example.ritmic.database to javafx.fxml;
    opens com.example.ritmic.model to javafx.base;
}