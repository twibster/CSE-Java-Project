package frontend.controllers;
import backend.HTTP_Requests.AddAssignmentRequest;
import backend.users.sessionData;
import com.google.gson.JsonObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class create_assignment {
    @FXML
    private TextField nameField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField bodyField;

    @FXML
    private TextField attachmentField;

    @FXML
    private TextField deadlineField;

    @FXML
    private void handleCreateAssignment(ActionEvent event) {
            String name = nameField.getText();
            String title = titleField.getText();
            String body = bodyField.getText();
            String attachment = attachmentField.getText();
            String deadline = deadlineField.getText();

            System.out.println("Create Assignment button clicked");

            JsonObject assignmentData = new JsonObject();
            assignmentData.addProperty("User", sessionData.getFirstName() + " " + sessionData.getFirstName());
            assignmentData.addProperty("Creator", name);
            assignmentData.addProperty("Title", title);
            assignmentData.addProperty("Body", body);
            assignmentData.addProperty("Attachment", attachment);
            assignmentData.addProperty("Deadline", deadline);

            try {
                AddAssignmentRequest.sendAssignmentRequest(sessionData.getEmail(), sessionData.getPosition(), assignmentData);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}