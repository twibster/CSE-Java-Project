package backend.HTTP_Requests;
import backend.users.sessionData;
import backend.Positions;
import backend.users.Admin;
import backend.users.Teacher;
import backend.users.Student;
import com.google.gson.Gson;
import com.google.gson.JsonObject;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SignIn_Request {
    public static void sendLoginRequest(String email, String password) throws IOException, Exception {
        String loginUrl = "http://localhost:8080/login";

        // Create a JSON object and add the user data
        JsonObject loginJson = new JsonObject();
        loginJson.addProperty("email", email);
        loginJson.addProperty("password", password);

        // Convert the JSON object to a string
        String loginJsonPayload = loginJson.toString();

        // Create a URL object with the login endpoint URL
        URL loginUrlObject = new URL(loginUrl);

        // Open a connection to the login URL
        HttpURLConnection loginConnection = (HttpURLConnection) loginUrlObject.openConnection();
        loginConnection.setRequestMethod("POST");
        loginConnection.setRequestProperty("Content-Type", "application/json");
        loginConnection.setDoOutput(true);

        // Write the login JSON payload to the request body
        try (OutputStream outputStream = loginConnection.getOutputStream()) {
            byte[] input = loginJsonPayload.getBytes(StandardCharsets.UTF_8);
            outputStream.write(input, 0, input.length);
        }

        // Read the login response from the server
        StringBuilder loginResponse = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(loginConnection.getInputStream()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                loginResponse.append(line);
            }
        }

        // Check if the login is successful
        if (loginConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new Exception("Login failed. Please check your email and password.");
        }
        System.out.println("Login Successful: " + loginResponse);
        // Assuming the response is valid JSON
        String jsonResponseString = loginResponse.toString();
        JsonObject jsonResponse = new Gson().fromJson(jsonResponseString, JsonObject.class);
        String firstName = jsonResponse.get("First Name").getAsString();
        String lastName = jsonResponse.get("Last Name").getAsString();
        String position = jsonResponse.get("Position").getAsString();
        String activationState = jsonResponse.get("Activation State").getAsString();
        sessionData.setUserData(firstName, lastName, email, position, activationState);

        // Close the login connection
        loginConnection.disconnect();
    }
}
