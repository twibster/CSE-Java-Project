package backend;

public enum Positions{
    ADMIN("Admin"),
    TEACHER("Teacher"),
    STUDENT("Student");

    private final String value;
    Positions(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public static Positions fromValue(String value) {
        for (Positions day : Positions.values()) {
            if (day.getValue().equalsIgnoreCase(value)) {
                return day;
            }
        }
        throw new IllegalArgumentException("Invalid Position value: " + value);
    }
}
