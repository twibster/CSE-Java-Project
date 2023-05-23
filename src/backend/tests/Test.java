package backend.tests;

import backend.Config;
import backend.Positions;
import backend.Utils;
import backend.users.Admin;
import backend.users.Student;
import backend.users.User;
import backend.functionality.Assignment;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

public class Test{

    public static void main(String[] args) throws Exception {

        User user = UserTest.addUser();
        UserTest.emailExists();
        AssignmentTest.addAssignment(user);
        CSVTest.testCSVRead();
        CSVTest.testClearCSV();
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
                Positions.TEACHER);
        System.out.println("1- Add User Passed!");
        return admin;
    }
    public static void emailExists() {
        try {
            Student user = new Student(
                    "Omar",
                    "Omran",
                    email,
                    password,
                    Positions.STUDENT);
        } catch (Exception e) {
            if (Objects.equals(e.getMessage(), "Email is already in use")) {
                System.out.println("2- Existence Passed!");
                return;
            }
        }
        System.out.println("2- Failed!");
    }
}
class CSVTest{

    public static void testCSVRead(){
        try {
            Utils.readUserFromCSV(Config.usersCSVPath);
        } catch (Exception e) {
            if (Objects.equals(e.getMessage(), "Email is already in use")) {
                System.out.println("4- CSV Write Pass!");
                System.out.println("5- CSV Read Pass!");
                return;
            }
        }
        System.out.println("4- Failed!");
        System.out.println("5- Failed!");
    }
    public static void testClearCSV() throws Exception {
        Utils.clearCSV(Config.usersCSVPath);
        Utils.readUserFromCSV(Config.usersCSVPath);
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