package backend.tests;

import backend.Positions;
import backend.users.Admin;
import backend.users.Student;
import backend.users.User;
import backend.functionality.Assignment;


import java.time.LocalDateTime;
import java.util.Objects;

public class Test{

    public static void main(String[] args) throws Exception {
        User user = UserTest.addUser();
        UserTest.emailExists();
        AssignmentTest.addAssignment(user);
    }

}
class UserTest{
    public static String email = "omar.omran@ieee-zsb.org";
    public static String password = "Test1234";
    public static User addUser() throws Exception {
        Admin admin = new Admin(
                "John",
                "Doe",
                email,
                password,
                Positions.Teacher);
        System.out.println("1- Add User Passed!");
        return admin;
    }
    public static void emailExists() throws Exception{
        try {
            Student user = new Student(
                    "Omar",
                    "Omran",
                    email,
                    password,
                    Positions.Student);
        } catch (Exception e) {
            if (Objects.equals(e.getMessage(), "Email is already in use")) {
                System.out.println("2- Existence Passed!");
                return;
            }
        }
        System.out.println("2- Failed!");
    }
}

class AssignmentTest{
    public static Assignment addAssignment(User user) throws Exception {
        Assignment assignment = new Assignment(
                user,
                "First ever assignment",
                "This is an actual assignment, stay tudent lol",
                LocalDateTime.of(2024,02,12,4,40)
        );
        System.out.println("3- Add Assignment Passed!");
        return assignment;
    }
}