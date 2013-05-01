package database.utils;

import java.sql.SQLException;

import core.MidasLogs;

public class DBErrorHandler {   
      
   public static void resultSetError(SQLException e) throws DatabaseException {
      MidasLogs.sqlErrors.push(e.getMessage());
      throw new DatabaseException();
   }
 
   public static void executionError(SQLException e) throws DatabaseException {
      MidasLogs.sqlErrors.push(e.getMessage());
      throw new DatabaseException();
   }

   public static void preparedStatementError(SQLException e) throws DatabaseException {
      MidasLogs.sqlErrors.push(e.getMessage());
      throw new DatabaseException();
   }
   
   public static void connectionError(SQLException e) throws DatabaseException {
      MidasLogs.sqlErrors.push(e.getMessage());
      throw new DatabaseException();
   }
   
   public static void constraintViolation() throws DatabaseConstraintViolation {
      throw new DatabaseConstraintViolation("DatabaseConstraintViolation");
   }
   
}
