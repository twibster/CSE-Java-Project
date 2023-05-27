package backend.database;

import backend.constants.Positions;
import backend.users.User;

import java.io.*;

public class CRUD {

    public static void add(String toWrite, String destination, boolean append) throws IOException {
        FileWriter csvWriter = new FileWriter(destination, append);
        csvWriter.write(toWrite);
        csvWriter.flush();
        csvWriter.close();
    }

    public static void readUserFromCSV(String source) throws Exception {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(source));
            String line;
            while ((line = csvReader.readLine()) != null) {
                String[] user = line.split(",");
                User.initializeChild(user[1],user[2],user[3],user[4], Positions.fromValue(user[5]), true);
            }
            csvReader.close();
        } catch (Exception e) {
            if (!(e instanceof FileNotFoundException)){
                throw new RuntimeException(e);
            }
        }
    }

    public static void clearCSV(String source) throws IOException {
        add("", source, false);
    }
}
