package frontend.controllers.homepage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class assignmentsController implements Initializable {

    @FXML
    private VBox vbox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addassignments() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/frontend/fxml/homepage/assignmentexample.fxml"));

        vbox.getChildren().add(root);

        System.out.println("Add pressed");

    }
}
