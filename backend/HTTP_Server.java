    import java.io.IOException;
    import java.io.OutputStream;
    import java.net.InetSocketAddress;
    import java.nio.charset.StandardCharsets;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.HashMap;
    import java.util.Map;

    import com.sun.net.httpserver.HttpExchange;
    import com.sun.net.httpserver.HttpHandler;
    import com.sun.net.httpserver.HttpServer;

    public class HTTP_Server {
        private static final String DB_URL = "jdbc:mysql://localhost/my_app_database?useSSL=false&serverTimezone=UTC";
        private static final String DB_USER = "root";
        private static final String DB_PASSWORD = "password";
        private static final String DEFAULT_USER_EMAIL = "email";
        private static final String DEFAULT_USER_PASSWORD = "password";
        private static final int HTTP_OK = 200;
        private static final int HTTP_BAD_REQUEST = 400;
        private static final int HTTP_UNAUTHORIZED = 401;

        private static final String LOGIN_PATH = "/login";
        private static final String SIGNUP_PATH = "/signup";
        private static final String VIEW_USERS_PATH = "/view-users";

        private static Map<String, String> defaultUser = new HashMap<>();

        static {
            defaultUser.put("email", DEFAULT_USER_EMAIL);
            defaultUser.put("password", DEFAULT_USER_PASSWORD);
        }

        public static void main(String[] args) throws IOException {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            server.createContext(LOGIN_PATH, new LoginHandler());
            server.createContext(SIGNUP_PATH, new SignupHandler());
            server.createContext(VIEW_USERS_PATH, new ViewUsersHandler());

            server.setExecutor(null);
            server.start();
        }

        private static Connection getConnection() throws SQLException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Add this line to load the MySQL JDBC driver
            } catch (ClassNotFoundException e) {
                throw new SQLException("MySQL JDBC driver not found", e);
            }
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }

        private static class LoginHandler implements HttpHandler {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String requestMethod = exchange.getRequestMethod();
                if (requestMethod.equalsIgnoreCase("POST")) {
                    try {
                        Map<String, String> requestBody = parseRequestBody(exchange);
                        if (authenticateUser(requestBody.get("email"), requestBody.get("password"))) {
                            String response = "Login successful!";
                            sendResponse(exchange, HTTP_OK, response);
                        } else {
                            sendResponse(exchange, HTTP_UNAUTHORIZED, "Invalid email or password");
                        }
                    } catch (SQLException e) {
                        sendResponse(exchange, HTTP_BAD_REQUEST, e.getMessage());
                    }
                } else {
                    sendResponse(exchange, HTTP_BAD_REQUEST, "Invalid request method");
                }
            }
        }

        private static class SignupHandler implements HttpHandler {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String requestMethod = exchange.getRequestMethod();
                if (requestMethod.equalsIgnoreCase("POST")) {
                    try {
                        Map<String, String> requestBody = parseRequestBody(exchange);
                        createUser(requestBody);
                        String response = "User created successfully!";
                        sendResponse(exchange, HTTP_OK, response);
                    } catch (SQLException e) {
                        sendResponse(exchange, HTTP_BAD_REQUEST, e.getMessage());
                    }
                } else {
                    sendResponse(exchange, HTTP_BAD_REQUEST, "Invalid request method");
                }
            }
        }

        private static class ViewUsersHandler implements HttpHandler {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String requestMethod = exchange.getRequestMethod();
                if (requestMethod.equalsIgnoreCase("GET")) {
                    try {
                        String response = getUsersAsHtml();
                        sendResponse(exchange, HTTP_OK, response);
                    } catch (SQLException e) {
                        sendResponse(exchange, HTTP_BAD_REQUEST, e.getMessage());
                    }
                } else {
                    sendResponse(exchange, HTTP_BAD_REQUEST, "Invalid request method");
                }
            }
        }

        private static Map<String, String> parseRequestBody(HttpExchange exchange) throws IOException {
            String requestBody = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            String[] keyValuePairs = requestBody.split("&");
            Map<String, String> params = new HashMap<>();
            for (String keyValuePair : keyValuePairs) {
                String[] parts = keyValuePair.split("=");
                String key = java.net.URLDecoder.decode(parts[0], StandardCharsets.UTF_8);
                String value = java.net.URLDecoder.decode(parts[1], StandardCharsets.UTF_8);
                params.put(key, value);
            }
            return params;
        }

        private static boolean authenticateUser(String email, String password) throws SQLException {
            try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?")) {
                stmt.setString(1, email);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            }
        }

        private static void createUser(Map<String, String> user) throws SQLException {
            try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (email, password) VALUES (?, ?)")) {
                stmt.setString(1, user.get("email"));
                stmt.setString(2, user.get("password"));
                stmt.executeUpdate();
            }
        }

        private static String getUsersAsHtml() throws SQLException {
            StringBuilder html = new StringBuilder("<html><body><table><tr><th>Email</th><th>Password</th></tr>");
            try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
                ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    html.append("<tr>")
                        .append("<td>").append(rs.getString("email")).append("</td>")
                        .append("<td>").append(rs.getString("password")).append("</td>")
                        .append("</tr>");
                }
            }
            html.append("</table></body></html>");
            return html.toString();
        }

        private static void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(statusCode, response.getBytes(StandardCharsets.UTF_8).length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes(StandardCharsets.UTF_8));
            }
        }
    }