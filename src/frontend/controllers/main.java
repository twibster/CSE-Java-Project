package frontend.controllers;

import backend.Config;
import backend.Utils;
import backend.database.CRUD;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/frontend/fxml/student_system.fxml"));
            Scene scene = new Scene(root);
            // Uncomment this line and add the application.css file if you want to use a custom CSS
            // scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            primaryStage.setTitle("Student System");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        CRUD.readUserFromCSV(Config.usersCSVPath);
        Utils.print("User database loaded successfully");
        CRUD.readMeetingFromCSV(Config.meetingsCSVPath);
        Utils.print("Meetings database loaded successfully");
        CRUD.readAssignmentFromCSV(Config.assignmentsCSVPath);
        Utils.print("Assignments database loaded successfully");
        CRUD.readSubmissionFromCSV(Config.submissionsCSVPath);
        Utils.print("Submissions database loaded successfully");
        CRUD.readFeedbackFromCSV(Config.feedbackCSVPath);
        Utils.print("Feedback database loaded successfully");
        launch(args);
    }
}