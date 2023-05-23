package frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainprofile implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private Button profileButton;
    private Button assignmentsButton;
    private Button projectsButton;
    private Label contactUsLabel;

    private boolean switched = false;
    private boolean switchedas = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize your controller here
    }

    @FXML
    private void AssButton() throws IOException {
        // Handle profile button click event
        if (switchedas) {
            pane.setVisible(false);
            switched = false;
            return;
        }
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("/frontend/fxml/homepage/assignments.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().addAll(fxml);
        pane.setVisible(true);
        switched = true;
        System.out.println("Assignments button clicked");
    }

    @FXML
    private void ProjectButton() {
        // Handle assignments button click event
        System.out.println("Project button clicked");
    }

    @FXML
    private void profileButton() throws IOException {
        // Handle projects button click event
        if (switched) {
            pane.setVisible(false);
            switched = false;
            return;
        }
        System.out.println("Profile button clicked");
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("/frontend/fxml/homepage/profile.fxml"));
        pane.getChildren().removeAll();
        pane.getChildren().addAll(fxml);
        pane.setVisible(true);
        switched = true;
    }

}

