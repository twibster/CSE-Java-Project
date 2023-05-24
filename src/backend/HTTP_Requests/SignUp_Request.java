package backend.HTTP_Requests;

import backend.Utils;
import com.google.gson.JsonObject;
import backend.Validators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SignUp_Request {
    public static void sendSignUpRequest(String firstName, String lastName, String email, String password, String position, String activationState) throws IOException {

        try {
            // Validate the input data
            Validators.lengthValidator(firstName, 1);
            Validators.lengthValidator(lastName, 1);
            Validators.emailValidator(email);
            Validators.passwordValidator(password);

            String signupUrl = "http://localhost:8080/signup";
            // Create a JSON object and add the user data
            JsonObject signupJson = new JsonObject();
            signupJson.addProperty("first_name", firstName);
            signupJson.addProperty("last_name", lastName);
            signupJson.addProperty("email", email);
            signupJson.addProperty("password", Utils.hash(Validators.passwordValidator(password)));
            signupJson.addProperty("position", position);
            signupJson.addProperty("activation_state", activationState);

            // Convert the JSON object to a string
            String signupJsonPayload = signupJson.toString();

            // Create a URL object with the sign-up endpoint URL
            URL signupUrlObject = new URL(signupUrl);

            // Open a connection to the sign-up URL
            HttpURLConnection signupConnection = (HttpURLConnection) signupUrlObject.openConnection();
            signupConnection.setRequestMethod("POST");
            signupConnection.setRequestProperty("Content-Type", "application/json");
            signupConnection.setDoOutput(true);

            // Write the sign-up JSON payload to the request body
            try (OutputStream outputStream = signupConnection.getOutputStream()) {
                byte[] input = signupJsonPayload.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }

            // Read the sign-up response from the server
            StringBuilder signupResponse = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(signupConnection.getInputStream()))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    signupResponse.append(line);
                }
            }

            // Print the sign-up response
            System.out.println("Signup Response: " + signupResponse.toString());

            // Close the sign-up connection
            signupConnection.disconnect();
        } catch (Exception e) {
            // Handle validation errors
            System.out.println("Error: " + e.getMessage());
        }
    }
}