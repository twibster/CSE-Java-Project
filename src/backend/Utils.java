package backend;

import backend.users.User;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.*;

public class Utils {
    public static void print(Object toPrint){
        System.out.println(toPrint);
    }
    public static void PrintArray(Object[] array){
        for (Object item: array){
            System.out.println(item);
        }
    }
    public static String hash(String toHash){
        return BCrypt.hashpw(toHash, BCrypt.gensalt());
    }
    public static Boolean checkHash(String toCompare, String storedHash){
        return BCrypt.checkpw(toCompare, storedHash);
    }
    public static void writeAppendToCSV(String toWrite, String destination, boolean append) throws IOException {
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
                User.initializeChild(user[1],user[2],user[3],user[4],Positions.fromValue(user[5]));
            }
            csvReader.close();
        } catch (Exception e) {
            if (!(e instanceof FileNotFoundException)){
                throw new RuntimeException(e);
            }
        }
    }
    public static void clearCSV(String source) throws IOException {
        writeAppendToCSV("", source, false);
    }
}
