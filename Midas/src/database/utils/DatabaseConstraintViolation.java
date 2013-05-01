package database.utils;

public class DatabaseConstraintViolation extends Exception {

   public DatabaseConstraintViolation(String message) {
      super(message);
   }
   
   private static final long serialVersionUID = 7724110393758568140L;

}
