package frontend.controllers;

import java.io.IOException;

import backend.users.User;
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
    	Parent root = FXMLLoader.load(getClass().getResource("/frontend/fxml/student_system.fxml"));
	    
	    stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
	    scene = new Scene(root);
	    stage.setScene(scene);
	    
	    stage.show();
    }

    @FXML
    void studentsigninclick(ActionEvent event) throws Exception {
        User user = User.fetchByEmail(txtid.getText());
        if (user != null){
            if (user.checkPassword(txtpassword.getText())){
                Parent root = FXMLLoader.load(getClass().getResource("/frontend/fxml/new.fxml"));

                stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
                scene = new Scene(root);
                stage.setScene(scene);

                stage.show();
                return;
            }
            throw new Exception("Incorrect Password");
        }
        throw new Exception("User does not exit");


    }

    @FXML
    void systemexit(ActionEvent event) {
    	System.exit(0);
    }

}
