package backend.users;

import backend.Positions;

public class Teacher extends Admin {

    public Teacher(String first_name, String last_name, String email, String password, Positions position) throws Exception {
        super(first_name, last_name, email, password, position);
    }
}
