package backend.users;

import backend.Utils;
import backend.Positions;
import backend.Validators;

import java.util.ArrayList;
import java.util.Objects;

public abstract class User {
    private static int count;
    public static ArrayList<User> database = new ArrayList<>();
    public final int id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    public static String emailexcep;
    Positions position;

    public User(String first_name, String last_name, String email, String password, Positions position) throws Exception {

        this.setFirst_name(first_name);
        this.setLast_name(last_name);
        this.setEmail(email);
        this.setPassword(password);
        this.position = position;

        this.id = count++;
        database.add(this);
    }
    public String getFirst_name(){
        return first_name;
    }

    public void setFirst_name(String first_name) throws Exception {
        this.first_name = Validators.lengthValidator(first_name,3);;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) throws Exception {
        this.last_name = Validators.lengthValidator(last_name, 3);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (fetchByEmail(email) != null){
            emailexcep = "Email is already in use";
        }
        this.email = Validators.emailValidator(email);
    }

    public void setPassword(String password) throws Exception {
        this.password = Utils.hash(Validators.passwordValidator(password));
    }

    public boolean checkPassword(String password){
        return Utils.checkHash(password, this.password);
    }

    public Positions getPosition() {
        return position;
    }

    // Start of static methods
    public static void deleteUser(User user){
        database.remove(user);
        user = null;
    }
    public static User fetchByEmail(String email){
        for(User user: database){
            if (Objects.equals(user.email, email)) {
                return user;
            }
        }
        return null;
    }
    public static User initializeChild(String first_name, String last_name, String email, String password, Positions position) throws Exception {
        switch (position) {
            case Admin -> {
                return new Admin(first_name, last_name, email, password, position);
            }
            case Teacher -> {
                return new Teacher(first_name, last_name, email, password, position);
            }
            case Student -> {
                return new Student(first_name, last_name, email, password, position);
            }
        }
        return null;
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

