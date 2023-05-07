import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Login_Page {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to the login/sign-up application!");

        while (true) {
            System.out.println("Enter '1' to login or '2' to sign up:");
            String choice = reader.readLine().trim();

            if (choice.equals("1")) {
                // Login
                System.out.println("Please enter your email:");
                String email = reader.readLine().trim();

                System.out.println("Please enter your password:");
                String password = reader.readLine().trim();

                // Encode email and password as URL parameters
                String postData = "email=" + URLEncoder.encode(email, StandardCharsets.UTF_8)
                        + "&password=" + URLEncoder.encode(password, StandardCharsets.UTF_8);

                // Send HTTP POST request to server
                URL url = new URL("http://localhost:8080/login");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("Content-Length", Integer.toString(postData.length()));
                OutputStream os = conn.getOutputStream();
                os.write(postData.getBytes());
                os.flush();
                os.close();

                // Check HTTP response code
                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Read HTTP response from server
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String response = br.readLine();
                    br.close();

                    // Print response from server
                    System.out.println(response);
                } else {
                    System.out.println("Error: " + responseCode + " " + conn.getResponseMessage());
                }

            } else if (choice.equals("2")) {
                // Sign up
                System.out.println("Please enter your email:");
                String email = reader.readLine().trim();

                System.out.println("Please enter your username:");
                String username = reader.readLine().trim();

                System.out.println("Please enter your name:");
                String name = reader.readLine().trim();

                System.out.println("Please enter your age:");
                String age = reader.readLine().trim();

                System.out.println("Please enter your position:");
                String position = reader.readLine().trim();

                System.out.println("Please enter your password:");
                String password = reader.readLine().trim();

                // Encode user information as URL parameters
                String postData = "email=" + URLEncoder.encode(email, StandardCharsets.UTF_8)
                        + "&username=" + URLEncoder.encode(username, StandardCharsets.UTF_8)
                        + "&name=" + URLEncoder.encode(name, StandardCharsets.UTF_8)
                        + "&age=" + URLEncoder.encode(age, StandardCharsets.UTF_8)
                        + "&position=" + URLEncoder.encode(position, StandardCharsets.UTF_8)
                        + "&password=" + URLEncoder.encode(password, StandardCharsets.UTF_8);

                // Send HTTP POST request to server
                URL url = new URL("http://localhost:8080/signup");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("Content-Length", Integer.toString(postData.length()));
                OutputStream os = conn.getOutputStream();
                os.write(postData.getBytes());
                os.flush();
                os.close();

                // Check HTTP response code
                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Read HTTP response from server
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String response = br.readLine();
                    br.close();

                    // Print response from server
                    System.out.println(response);
                } else {
                    System.out.println("Error: " + responseCode + " " + conn.getResponseMessage());
                }

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}