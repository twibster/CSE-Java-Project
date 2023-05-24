package backend.users;

public class sessionData {
    private static String firstName;
    private static String lastName;
    private static String email;
    private static String position;
    private static String activationState;

    public static void setUserData(String firstName, String lastName, String email, String position, String activationState) {
        sessionData.firstName = firstName;
        sessionData.lastName = lastName;
        sessionData.email = email;
        sessionData.position = position;
        sessionData.activationState = activationState;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPosition() {
        return position;
    }

    public static String getActivationState() {
        return activationState;
    }
}
