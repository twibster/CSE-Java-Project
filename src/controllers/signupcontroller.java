package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class signupcontroller {

	private Stage stage;
	private Scene scene;

	@FXML
	private ComboBox<String> roles;
	
	@FXML
    private AnchorPane adminkey;
	 
	@FXML
    private Text signupswitch;

    @FXML
    private Text txtsignup;
    
    @FXML
    private AnchorPane rolepane;
    
    @FXML
    private PasswordField txtadminkey;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtfname;

    @FXML
    private TextField txtlname;

    @FXML
    private PasswordField txtpassword;
    
    private boolean switched = false;
    private String role;
    
    private ObservableList<String> UserOptions = FXCollections.
			observableArrayList("Teacher", "Student");

    public ObservableList<String> getUserOptions() {
		return UserOptions;
	}
    
    @FXML
    void adminsignup(MouseEvent event) {
    	if (switched) {
    		adminkey.setVisible(false);
        	txtsignup.setText("User Sign-up");
        	rolepane.setVisible(true);
        	signupswitch.setText("Click here to sign-up as an admin");
        	switched = false;
    	}
    	else {
	    	adminkey.setVisible(true);
	    	txtsignup.setText("Admin Sign-up");
	    	rolepane.setVisible(false);
	    	signupswitch.setText("Click here to sign-up as a user");
	    	switched = true;
    	}
    }

    @FXML
	void returnToMainPage(ActionEvent event) throws IOException {
		System.out.println("Administrator button clicked!");

		Parent root = FXMLLoader.load(getClass().getResource("/fxml/student_system.fxml"));

		stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);

		stage.show();

	}
    
    @FXML
    void signup(ActionEvent event) {
    	if (switched) {
    		role = "Admin";
    		System.out.println(role);
    	}
    	else {
    	role = roles.getValue();
    	System.out.println(role);
    	}
    }
    
    public void initialize() {
		// TODO Auto-generated method stub
		roles.setValue("Student");
		roles.setItems(getUserOptions());

	}

}
