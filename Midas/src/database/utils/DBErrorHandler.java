package database.utils;

import java.sql.SQLException;

public class DBErrorHandler {   
   
   private static void logSqlErrorToFile(String message) {
      // à faire /////////////////////////////////////////////
   }
   
   public static void resultSetError(SQLException e) throws DatabaseException {
      e.printStackTrace();
      logSqlErrorToFile(e.getMessage());
      throw new DatabaseException();
   }
 
   public static void executionError(SQLException e) throws DatabaseException {
      e.printStackTrace();
      logSqlErrorToFile(e.getMessage());
      throw new DatabaseException();
   }

   public static void preparedStatementError(SQLException e) throws DatabaseException {
      e.printStackTrace();
      logSqlErrorToFile(e.getMessage());
      throw new DatabaseException();
   }
   
   public static void connectionError(SQLException e) throws DatabaseException {
      e.printStackTrace();
      logSqlErrorToFile(e.getMessage());
      throw new DatabaseException();
   }
   
   public static void constraintViolation() throws DatabaseConstraintViolation {
      throw new DatabaseConstraintViolation();
   }
   
}
