package frontend.controllers;

import backend.users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainPageController implements Initializable{

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField txtemail;
    @FXML
    private PasswordField txtpassword;

    @FXML
    private Text emailerror;
    @FXML
    private Text passerror;

    @FXML
    void signup(MouseEvent event) throws IOException {
        Utils.redirectScene(this.getClass(), event, "/frontend/fxml/signup.fxml", stage, scene);
    }

    @FXML
    void studentsigninclick(ActionEvent event) throws Exception{
        User user = User.fetchByEmail(txtemail.getText());
        if (user != null){
            if (user.checkPassword(txtpassword.getText())){
                Utils.redirectScene(this.getClass(),event,"/frontend/fxml/new.fxml", stage, scene);
            }
            //throw new Exception("Incorrect Password");
            passerror.setText("Please enter a valid Password");
            passerror.setTextAlignment(TextAlignment.LEFT);
            passerror.setVisible(true);
            emailerror.setVisible(false);
        }
        //throw new Exception("User does not exit");
        emailerror.setText("Please enter a valid Email Address");
        emailerror.setTextAlignment(TextAlignment.LEFT);
        emailerror.setVisible(true);
    }

    @FXML
    void systemexit(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
