package controllers;
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
    void onAdministratorButtonClick(ActionEvent event) throws IOException {
	    
	    
	    Parent root = FXMLLoader.load(getClass().getResource("/fxml/signin_admin.fxml"));
	    
	    stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
	    scene = new Scene(root);
	    stage.setScene(scene);
	    
	    stage.show();

    }

    @FXML
    void onStudentButtonClick(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("/fxml/signin_student.fxml"));
	    
	    stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
	    scene = new Scene(root);
	    stage.setScene(scene);
	    
	    stage.show();

    }

    @FXML
    void onTeacherButtonClick(ActionEvent event) throws IOException {
	       Parent root = FXMLLoader.load(getClass().getResource("/fxml/signin_teacher.fxml"));
		    
		    stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
		    scene = new Scene(root);
		    stage.setScene(scene);
		    
		    stage.show();

    }

    @FXML
    void signup(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/fxml/signup.fxml"));
	    
	    stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
	    scene = new Scene(root);
	    stage.setScene(scene);
	    
	    stage.show();

    }

}