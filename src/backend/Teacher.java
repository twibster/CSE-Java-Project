package backend;

public class Teacher extends User {

    public Teacher(String first_name, String last_name, String email, String password, Positions position) throws Exception {
        super(first_name, last_name, email, password, position);
    }
}
