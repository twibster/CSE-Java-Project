package backend.users;

import backend.Positions;
import backend.functionality.Assignment;

import java.time.LocalDateTime;

public class Admin extends User {
    public Admin(String first_name, String last_name, String email, String password, Positions position, boolean csv) throws Exception {
        super(first_name, last_name, email, password, position, csv);
    }
    public Assignment createAssignment(String title, String body, String attachment, LocalDateTime deadline) throws Exception {
        return new Assignment(this, title, body, attachment, deadline);
    }
    public Assignment createAssignment(String title, String body, LocalDateTime deadline) throws Exception {
        return new Assignment(this, title, body, deadline);
    }
}
