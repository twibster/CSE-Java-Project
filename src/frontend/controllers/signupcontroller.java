package frontend.controllers;

import java.io.IOException;

import backend.constants.Positions;
import backend.users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class signupcontroller {

	private Stage stage;
	private Scene scene;

	@FXML
	private ComboBox<Positions> roles;
	
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
    private Positions position;

	private ObservableList<Positions> UserOptions = FXCollections.
			observableArrayList(Positions.TEACHER, Positions.STUDENT);

    public ObservableList<Positions> getUserOptions() {
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
		Utils.redirectScene(this.getClass(),event,"/frontend/fxml/student_system.fxml", stage, scene);
	}
    
    @FXML
    void signup(ActionEvent event) throws Exception {
    	if (switched) {
    		position = Positions.ADMIN;
    		System.out.println(position);
    	}
    	else {
    	position = roles.getValue();
		User user = User.initializeChild(txtfname.getText(), txtlname.getText(), txtemail.getText(), txtpassword.getText(), position, false);
		System.out.println(user);
		Utils.redirectScene(this.getClass(),event,"/frontend/fxml/signin_user.fxml", stage, scene);
    	}
    }
    
    public void initialize() {
		// TODO Auto-generated method stub
		roles.setValue(Positions.STUDENT);
		roles.setItems(getUserOptions());

	}

}
