package frontend.controllers.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class assignmentexampleController {
    @FXML
    private AnchorPane assignment;

    @FXML
    private Button btnedit;

    @FXML
    private Text User;
    @FXML
    private Text topic;
    @FXML
    private TextArea description;

    @FXML
    private Text deadline;
    @FXML
    private Text posteddate;


    @FXML
    void edit(ActionEvent event) {
        description.setEditable(true);

    }

    @FXML
    void showattachement(ActionEvent event) {

    }

    @FXML
    void submit(ActionEvent event) {

    }

}
