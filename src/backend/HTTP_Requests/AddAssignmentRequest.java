package backend.HTTP_Requests;
import backend.Utils;
import backend.Validators;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AddAssignmentRequest {
    public static void sendAssignmentRequest(String email, String position, JsonObject assignmentData) throws IOException {
        try {
            // Validate the input data
            Validators.emailValidator(email);

            String assignmentUrl = "http://localhost:8080/add_assignment";
            // Create a JSON object and add the assignment data
            JsonObject assignmentJson = new JsonObject();
            assignmentJson.addProperty("email", email);
            assignmentJson.addProperty("position", position);
            assignmentJson.add("assignment_data", assignmentData);

            // Convert the JSON object to a string
            String assignmentJsonPayload = assignmentJson.toString();

            // Create a URL object with the assignment endpoint URL
            URL assignmentUrlObject = new URL(assignmentUrl);

            // Open a connection to the assignment URL
            HttpURLConnection assignmentConnection = (HttpURLConnection) assignmentUrlObject.openConnection();
            assignmentConnection.setRequestMethod("POST");
            assignmentConnection.setRequestProperty("Content-Type", "application/json");
            assignmentConnection.setDoOutput(true);

            // Write the assignment JSON payload to the request body
            try (OutputStream outputStream = assignmentConnection.getOutputStream()) {
                byte[] input = assignmentJsonPayload.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }

            // Read the assignment response from the server
            StringBuilder assignmentResponse = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assignmentConnection.getInputStream()))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    assignmentResponse.append(line);
                }
            }

            // Print the assignment response
            System.out.println("Assignment Response: " + assignmentResponse.toString());

            // Close the assignment connection
            assignmentConnection.disconnect();
        } catch (Exception e) {
            // Handle validation errors
            System.out.println("Error: " + e.getMessage());
        }
    }
}