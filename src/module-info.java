module controllers{
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.security.core;
    requires spring.security.crypto;

    opens frontend.controllers to javafx.fxml;
    opens frontend.controllers.student to javafx.fxml;

    exports frontend.controllers;
    exports frontend.controllers.student to javafx.fxml;
    exports backend;
    exports backend.tests;
    exports backend.users;
    exports backend.functionality;
}