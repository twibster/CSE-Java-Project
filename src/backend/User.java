package backend;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private static int count;
    public static ArrayList<User> database = new ArrayList<>();
    final int id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    Positions position;

    public User(String first_name, String last_name, String email, String password, Positions position) throws Exception {
        this.id = count++;
        this.setFirst_name(first_name);
        this.setLast_name(last_name);
        this.setEmail(email);
        this.setPassword(password);
        this.position = position;

        database.add(this);
    }
    public String getFirst_name(){
        return first_name;
    }

    public void setFirst_name(String first_name) throws Exception {
        this.first_name = Validator.LengthValidator(first_name,3);;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) throws Exception {
        this.last_name = Validator.LengthValidator(last_name, 3);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        Object[] queryResult = fetchByEmail(email);
        if (queryResult[0] != null){
            throw new Exception("This email is already in use");
        }
        this.email = Validator.EmailValidator(email);
    }

    public void setPassword(String password) throws Exception {
        this.password = Functions.Hash(Validator.PasswordValidator(password));
    }

    public boolean checkPassword(String password){
        return Functions.CheckHash(password, this.password);
    }

    // Start of static methods
    public static void deleteUser(User user){
        database.remove(user);
        user = null;
    }
    public static Object[] fetchByEmail(String email){
        Object[] queryResult = {null};
        for(User user: database){
            if (Objects.equals(user.email, email)) {
                queryResult[0] = user;
            }
        }
        return queryResult;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", position=" + position +
                '}';
    }
}

