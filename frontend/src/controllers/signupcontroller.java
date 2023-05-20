package controllers;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class signupcontroller {

	private Stage stage;
	private Scene scene;
	private ObservableList<String> UserOptions = FXCollections.
			observableArrayList("Teacher", "Student");
	@FXML
	private ComboBox<String> roles;
	@FXML
	void returnToMainPage(ActionEvent event) throws IOException {
	
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/student_system.fxml"));

		stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);

		stage.show();

	}

	public void initialize() {
		// TODO Auto-generated method stub
		roles.setValue("Student");
		roles.setItems(getUserOptions());

	}

	public ObservableList<String> getUserOptions() {
		return UserOptions;
	}
	
	

}
