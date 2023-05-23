package frontend.controllers;

import java.io.IOException;

import backend.Positions;
import backend.Validators;
import backend.users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import static backend.users.User.emailexcep;

public class signupcontroller {

	private Stage stage;
	private Scene scene;

	@FXML
	private ComboBox<Positions> roles;

	@FXML
	private Text adminkeyerror;
	@FXML
	private Text emailerror;
	@FXML
	private Text fnameerror;
	@FXML
	private Text lnameerror;
	@FXML
	private Text passerror;

	@FXML
	private Button btnsignup;
	@FXML
	private Button btnreturn;

	@FXML
    private AnchorPane adminkey;
	@FXML
	private AnchorPane registeredpane;
	@FXML
	private AnchorPane rolepane;
	@FXML
	private VBox vbox;

	@FXML
    private Text signupswitch;
    @FXML
    private Text txtsignup;

    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtfname;
    @FXML
    private TextField txtlname;
    @FXML
    private PasswordField txtpassword;
	@FXML
	private PasswordField txtadminkey;

    private boolean switched = false;
	private boolean errors = false;
    private Positions position;


	private ObservableList<Positions> UserOptions = FXCollections.
			observableArrayList(Positions.Teacher, Positions.Student);

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
			passerror.setVisible(false);
			lnameerror.setVisible(false);
			fnameerror.setVisible(false);
			emailerror.setVisible(false);
			adminkeyerror.setVisible(false);
    	}
    	else {
	    	adminkey.setVisible(true);
	    	txtsignup.setText("Admin Sign-up");
	    	rolepane.setVisible(false);
	    	signupswitch.setText("Click here to sign-up as a user");
	    	switched = true;
			passerror.setVisible(false);
			lnameerror.setVisible(false);
			fnameerror.setVisible(false);
			emailerror.setVisible(false);
			adminkeyerror.setVisible(false);

    	}
    }

    @FXML
	void returnToMainPage(ActionEvent event) throws IOException {
		Utils.redirectScene(this.getClass(),event,"/frontend/fxml/student_system1.fxml", stage, scene);
	}
    
    @FXML
    void signup(ActionEvent event) throws Exception {
		errors = false;
    	if (switched) {
    		position = Positions.Admin;
    		System.out.println(position);
    	}
    	else {
    	position = roles.getValue();
		System.out.println(position);
    	}
		if(Validators.lengthValidator(txtfname.getText(), 3) == null){fnameerror.setVisible(true); errors = true;}
		if(Validators.lengthValidator(txtlname.getText(), 3) == null){lnameerror.setVisible(true); errors=true;}

		if (User.fetchByEmail(txtemail.getText()) != null) {emailerror.setText(User.emailexcep); emailerror.setVisible(true); errors = true;}
		else if (Validators.emailValidator(txtemail.getText()) == null) {
		emailerror.setVisible(Validators.emailValidator(txtemail.getText()) == null); errors = true;}

		if (Validators.passwordValidator(txtpassword.getText()) == null) {
			passerror.setText(Validators.passexcep);
			passerror.setVisible(true);
			errors = true;
		}

		if (!errors) {
			User user = User.initializeChild(txtfname.getText(), txtlname.getText(), txtemail.getText(), txtpassword.getText(), position);
			registeredpane.setVisible(true);
			vbox.setDisable(true);
			signupswitch.setDisable(true);
			btnreturn.setDisable(true);
			btnsignup.setDisable(true);
			System.out.println(user);
		}
		else{System.out.println("NO USER MADE");}
    }

	@FXML
	void signedupreturn(ActionEvent event) throws IOException{
		Utils.redirectScene(this.getClass(), event, "/frontend/fxml/student_system1.fxml", stage, scene);

	}
    
    public void initialize() {
		// TODO Auto-generated method stub
		roles.setValue(Positions.Student);
		roles.setItems(getUserOptions());

	}

}
