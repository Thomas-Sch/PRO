package database.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {

   private final String dbPath;
   
   public DBAccess(String dbPath) {
      
      this.dbPath = dbPath;
      
   }
   
   private Connection getConnection() throws DatabaseException {
      
      Connection connection = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
      } catch (ClassNotFoundException e) {
         System.err.println(e);
      }
      
      try {
         connection = DriverManager.getConnection(dbPath);
      }
      catch (SQLException e) {
         DBErrorHandler.connectionError(e);
      }
      
      return connection;
      
   }

   public PreparedStatement getPreparedStatement(String sqlString) throws DatabaseException {
      Connection connection = this.getConnection();
      PreparedStatement preparedStatement = null;
      try {
         preparedStatement = connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
         preparedStatement.setQueryTimeout(30);
      } catch (SQLException e) {
         DBErrorHandler.preparedStatementError(e);
      }
      
      return preparedStatement;
   }
   
   public void destroyPreparedStatement(PreparedStatement preparedStatement) throws DatabaseException {
      try {
         if (preparedStatement.getConnection() != null) {
            preparedStatement.getConnection().close();
         }
      } catch (SQLException e) {
         DBErrorHandler.preparedStatementError(e);
      }
   }

}
