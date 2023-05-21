module controllers{
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.security.core;

    opens controllers to javafx.fxml;
    opens controllers.student to javafx.fxml;

    exports controllers;
    exports controllers.student to javafx.fxml;
    exports backend;
}