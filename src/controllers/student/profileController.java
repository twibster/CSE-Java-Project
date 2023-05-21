package controllers.student;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class profileController implements Initializable{

    @FXML
    private ResourceBundle resources;

        @FXML
        private Button btncancel;

        @FXML
        private Button btnedit;

        @FXML
        private Button btnsave;

        @FXML
        private PasswordField txtconfirmpass;

        @FXML
        private TextField txtemail;

        @FXML
        private TextField txtid;

        @FXML
        private TextField txtname;

        @FXML
        private AnchorPane verifypane;

        @FXML
        void cancelEdits(ActionEvent event) {
        	btnedit.setVisible(true);
        	btnedit.setDisable(false);
        	
        	btncancel.setDisable(true);
        	btncancel.setVisible(false);
        	
        	btnsave.setDisable(true);
        	btnsave.setVisible(false);

        }

        @FXML
        void cancelverify(ActionEvent event) {
        	verifypane.setVisible(false);
        	
        	btnedit.setVisible(true);
        	btnedit.setDisable(false);
        	
        	btncancel.setDisable(true); 
        	btncancel.setVisible(false);
        	
        	btnsave.setDisable(true);
        	btnsave.setVisible(false);

        }

        @FXML
        void profileEdit(ActionEvent event) {
        	btncancel.setDisable(false);
        	btncancel.setVisible(true);
        	
        	btnsave.setDisable(false);
        	btnsave.setVisible(true);
        	
        	//btnedit.setDisable(true);
        	btnedit.setVisible(false);
        	
        	txtname.setDisable(false);
        	txtname.setEditable(true);
        	
        	txtemail.setDisable(false);
        	txtemail.setEditable(true);
        	
        }

        @FXML
        void saveEdits(ActionEvent event) throws IOException {
        	verifypane.setVisible(true);
        }

        @FXML
        void saveverify(ActionEvent event) {
        	verifypane.setVisible(false);
        	
        	btnedit.setVisible(true);
        	btnedit.setDisable(false);
        	
        	btncancel.setDisable(true);
        	btncancel.setVisible(false);
        	
        	btnsave.setDisable(true);
        	btnsave.setVisible(false);
        	
        	txtname.setDisable(true);
        	txtname.setEditable(false);
        	
        	txtemail.setDisable(true);
        	txtemail.setEditable(false);
        }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		assert verifypane != null : "fx:id=\"pane\" was not injected: check your FXML file 'homepage_student.fxml'.";
		
	}

}
