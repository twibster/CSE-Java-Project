package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
    	Parent root = FXMLLoader.load(getClass().getResource("/fxml/student_system.fxml"));
	    
	    stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
	    scene = new Scene(root);
	    stage.setScene(scene);
	    
	    stage.show();
    }

    @FXML
    void studentsigninclick(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/fxml/student/homepage_student.fxml"));
	    
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
