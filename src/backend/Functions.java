package backend;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Functions {
    public static void PrintArray(Object[] array){
        for (Object item: array){
            System.out.println(item);
        }
    }
    public static String Hash(String toHash){
        return BCrypt.hashpw(toHash, BCrypt.gensalt());
    }
    public static Boolean CheckHash(String toCompare, String storedHash){
        return BCrypt.checkpw(toCompare, storedHash);
    }
}
