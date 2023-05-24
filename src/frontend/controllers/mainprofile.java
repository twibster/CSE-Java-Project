package frontend.controllers;
import backend.HTTP_Requests.GetAssignmentRequest;
import backend.users.sessionData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


public class mainprofile implements Initializable {

    private Stage stage;
    private Scene scene;
    @FXML
    private Button profileButton;

    @FXML
    private Button assignmentsButton;

    @FXML
    private Button projectsButton;

    @FXML
    private Label contactUsLabel;

    @FXML
    private Label nameLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contactUsLabel.setText("Contact Us");
        nameLabel.setText(sessionData.getFirstName());
        try {
            GetAssignmentRequest.sendGetLastAssignmentsRequest();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void AssButton(ActionEvent event) throws IOException {
        // Handle profile button click event

        System.out.println("Assignments button clicked");
        Utils.redirectScene(this.getClass(),event,"/frontend/fxml/create_assignment.fxml", stage, scene);
    }

    @FXML
    private void ProjectButton() {
        // Handle assignments button click event
        System.out.println("Project button clicked");
    }

    @FXML
    private void profileButton() {
        // Handle projects button click event
        System.out.println("Profile button clicked");
    }

}

