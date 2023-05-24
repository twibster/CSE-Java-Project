package frontend.controllers.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class profileController {

    @FXML
    private Button btncancel;
    @FXML
    private Button btnedit;
    @FXML
    private Button btnsave;


    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtname;
    @FXML
    private PasswordField txtconfirmpass;

    @FXML
    private AnchorPane verifypane;

    @FXML
    void profileEdit(ActionEvent event) {
        btncancel.setVisible(true);
        btnsave.setVisible(true);
        btnedit.setVisible(false);

        txtname.setEditable(true);
        txtemail.setEditable(true);
        //txtpass.setEditable(true);

    }

    @FXML
    void saveEdits(ActionEvent event) {
        verifypane.setVisible(true);
    }

    @FXML
    void cancelEdits(ActionEvent event) {
        btncancel.setVisible(false);
        btnsave.setVisible(false);
        btnedit.setVisible(true);

        txtname.setEditable(false);
        txtemail.setEditable(false);
        //txtpass.setEditable(false);

        txtname.clear();
        txtemail.clear();
        //txtpass.clear();
    }

    @FXML
    void saveverify(ActionEvent event) {
        verifypane.setVisible(false);

        btncancel.setVisible(false);
        btnsave.setVisible(false);
        btnedit.setVisible(true);

        txtname.getText();
        txtemail.getText();

        txtname.setEditable(false);
        txtemail.setEditable(false);
        //txtpass.setEditable(false);


        txtconfirmpass.clear();
    }

    @FXML
    void cancelverify(ActionEvent event) {
        verifypane.setVisible(false);
        txtconfirmpass.clear();
        cancelEdits(event);
    }

}
