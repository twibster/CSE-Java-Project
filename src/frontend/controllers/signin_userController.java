package frontend.controllers;
import backend.HTTP_Requests.SignIn_Request;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class signin_userController {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    void backtomainpage(ActionEvent event) throws IOException {
        Utils.redirectScene(this.getClass(),event,"/frontend/fxml/student_system.fxml", stage, scene);

    }

    @FXML
    void studentsigninclick(ActionEvent event)  {
        try {
            // Validate the input data
            String email = txtid.getText();
            String password = txtpassword.getText();

            // Send login request to the webserver
            SignIn_Request.sendLoginRequest(email, password);

            // If the login request is successful, redirect to the next scene
            Utils.redirectScene(this.getClass(),event,"/frontend/fxml/new.fxml", stage, scene);
        } catch (IOException e) {
            System.out.println("ERROR");
        } catch (Exception e) {
            // Display an error message if the login is unsuccessful
            System.out.println("Login Failed");
        }
    }

    @FXML
    void systemexit(ActionEvent event) {
        System.exit(0);
    }

}
