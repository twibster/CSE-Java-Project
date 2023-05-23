package backend;

import java.time.LocalDateTime;

public class Validators {
    public static String passexcep;
     public static String lengthValidator(String toCheck, int requiredLength) throws Exception {
         toCheck = toCheck.strip();
         if (toCheck.length() >= requiredLength) {
             return toCheck;
         }
         else{return null;}
     }

    public static String emailValidator(String email) throws Exception {
         email = email.strip();
         String[] beforeAndAfterAt = email.split("@");
         if (beforeAndAfterAt.length == 2){
             String[] beforeAndAfterDot = beforeAndAfterAt[1].split("\\.");
             if (beforeAndAfterDot.length >= 2){
                 return email;
             }
         }
         else {return null;}
        return email;
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
         if (length < 8) {passexcep = "Password must be a minimum of 8 characters"; return null;}
         if (!numeric) {passexcep = "Password must contain at least one number"; return null;}
         if (!upper) { passexcep = "Password must contain at least one upper case character"; return null;}
         if (!lower) { passexcep = "Password must contain at least one lower case character"; return null;}
         return password;
    }
    public static String attachmentValidator(String attachment) throws Exception{
         attachment = attachment.strip();
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
    public static Positions positionValidator(Positions userPosition, Positions[] requiredPosition) throws Exception {
         for (Positions position: requiredPosition){
             if (userPosition == position){
                 return userPosition;
             }
         }
         throw new Exception("You do not have permission to do this");
    }
}
