package frontend.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class homepage_studentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane pane;
    
    ObservableList<String> items = FXCollections.
    		observableArrayList("task1");
    
    

    @FXML
    void backtomainpage(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void showAssignments(ActionEvent event) throws IOException {
    	
    	if (pane != null) {
    		pane.getChildren().removeAll();
    	}
    	
    	Parent fxml = FXMLLoader.load(getClass().getResource("/frontend/fxml/student/assignments.fxml"));
    	pane.getChildren().removeAll();
    	pane.getChildren().addAll(fxml);
    	
    	
    	
    	//ListView<String> listView = new ListView<>(items);
    	
    }

    @FXML
    void showProfile(ActionEvent event) throws IOException {
    	Parent fxml = FXMLLoader.load(getClass().getResource("/frontend/fxml/student/profile.fxml"));
    	pane.getChildren().removeAll();
    	pane.getChildren().addAll(fxml);

    }

    @FXML
    void showProjects(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'homepage_student.fxml'.";

    }

}
