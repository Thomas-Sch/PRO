package database.dbComponents;

import java.sql.SQLException;

public class DBErrorHandler {

   private static void logSqlErrorToFile() {
      // à faire /////////////////////////////////////////////
   }
   
   static void resultSetError(SQLException e) {
      e.printStackTrace();
   }
 
   static void executeError(SQLException e) {
      e.printStackTrace();
   }

   static void preparedStatementError(SQLException e) {
      e.printStackTrace();
   }
   
   static void connectionError(SQLException e) {
      e.printStackTrace();
   }
   
}
