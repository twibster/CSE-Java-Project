package backend;

import java.time.LocalDateTime;

public class Validators {
     public static String lengthValidator(String toCheck, int requiredLength) throws Exception {
        if (toCheck.length()>= requiredLength){
            return toCheck;
        }
        throw new Exception("The provided string is less than " + requiredLength);
    }
    public static String emailValidator(String email) throws Exception {
         String[] beforeAndAfterAt = email.split("@");
         if (beforeAndAfterAt.length == 2){
             String[] beforeAndAfterDot = beforeAndAfterAt[1].split("\\.");
             if (beforeAndAfterDot.length >= 2){
                 return email;
             }
         }
         throw new Exception("Not a valid email");
    }
    public static String passwordValidator(String password) throws Exception{
         boolean upper = false, lower = false, numeric = false;
         int length = 0;
         for(char ch: password.toCharArray()){
             if (Character.isDigit(ch)) numeric = true;
             else if (Character.isUpperCase(ch)) upper = true;
             else if (Character.isLowerCase(ch)) lower = true;
             length ++;
         }
         if (length < 8) throw new Exception("Password must be a minimum of 8 characters");
         if (!numeric) throw new Exception("Password must contain at least one number");
         if (!upper) throw new Exception("Password must contain at least one upper case character");
         if (!lower) throw new Exception("Password must contain at least one lower case character");
         return password;
    }
    public static String attachmentValidator(String attachment) throws Exception{
         String[] beforeAndAfterDot = attachment.split("\\.");
         if (beforeAndAfterDot.length == 2){
             return attachment;
         }
         throw new Exception("Not a valid attachment");
    }
    public static LocalDateTime deadlineValidator(LocalDateTime deadline) throws Exception{
         if (deadline.isAfter(LocalDateTime.now())){
             return deadline;
         }
         throw new Exception("Are you living in the past?");
    }
}
