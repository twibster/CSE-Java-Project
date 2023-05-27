package backend.users;

import backend.constants.Positions;

public class Student extends User {
    public Student(String first_name, String last_name, String email, String password, Positions position, boolean csv) throws Exception {
        super(first_name, last_name, email, password, position, csv);
    }
}
