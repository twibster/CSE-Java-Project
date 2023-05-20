package controllers;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class studentcontroller {
	private Stage stage;
	private Scene scene;

	
    @FXML
    void backtomainpage(ActionEvent event) throws IOException {
    	
    	
System.out.println("Administrator button clicked!");
	    
	    Parent root = FXMLLoader.load(getClass().getResource("/fxml/student_system.fxml"));
	    
	    stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
	    scene = new Scene(root);
	    stage.setScene(scene);
	    
	    stage.show();

    }

    @FXML
    void studentsigninclick() {
    	System.out.println("Student button clicked!");

    }

}
