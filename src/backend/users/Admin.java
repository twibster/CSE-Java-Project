package backend.users;

import backend.Positions;

public class Admin extends User {
    public Admin(String first_name, String last_name, String email, String password, Positions position) throws Exception {
        super(first_name, last_name, email, password, position);
    }
}
