module controllers{
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.security.core;
    requires spring.security.crypto;

    opens controllers to javafx.fxml;
   // opens controllers.student to javafx.fxml;

    exports controllers;
    //exports controllers.student to javafx.fxml;
    exports backend;
    exports backend.tests;
    exports backend.users;
    exports backend.functionality;
}