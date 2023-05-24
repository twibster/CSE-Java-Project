package backend.HTTP_Requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serial;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetAssignmentRequest {
    public static String sendGetLastAssignmentsRequest() throws IOException {
        String getLastAssignmentsUrl = "http://localhost:8080/get-last-assignments";

        // Create a URL object with the get-last-assignments endpoint URL
        URL getLastAssignmentsUrlObject = new URL(getLastAssignmentsUrl);

        // Open a connection to the get-last-assignments URL
        HttpURLConnection getLastAssignmentsConnection = (HttpURLConnection) getLastAssignmentsUrlObject.openConnection();
        getLastAssignmentsConnection.setRequestMethod("GET");

        // Read the get-last-assignments response from the server
        StringBuilder getLastAssignmentsResponse = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getLastAssignmentsConnection.getInputStream()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                getLastAssignmentsResponse.append(line);
            }
        }

        // Check if the get-last-assignments request is successful
        if (getLastAssignmentsConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed to retrieve last assignments. Status code: " + getLastAssignmentsConnection.getResponseCode());
        }

        // Assuming the response is valid JSON
        String jsonResponseString = getLastAssignmentsResponse.toString();
        System.out.println(jsonResponseString);
        return jsonResponseString;
    }
}
