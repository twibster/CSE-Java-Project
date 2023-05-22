package frontend.controllers;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.stage.Stage;
public class StudentSystemController {
	
	private Stage stage;
	private Scene scene;
	
    @FXML
    void signin(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/frontend/fxml/signin_user.fxml"));
	    
	    stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
	    scene = new Scene(root);
	    stage.setScene(scene);
	    
	    stage.show();
    }

    @FXML
    void signup(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/frontend/fxml/signup.fxml"));
	    
	    stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
	    scene = new Scene(root);
	    stage.setScene(scene);
	    
	    stage.show();

    }
    
    @FXML
    void systemexit(ActionEvent event) {
    	System.exit(0);
    }

}