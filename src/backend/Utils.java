package backend;

import org.springframework.security.crypto.bcrypt.BCrypt;

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
}
