package dbComponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DBController_Old {
   
   private final String dbPath = "jdbc:sqlite:Midas.sqlite3";
   
   private Connection getConnection() {
      
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
         System.out.println(e);
      }
      
      return connection;
      
   }
   
   private PreparedStatement getPreparedStatement(String sqlString, Connection connection) {
      PreparedStatement preparedStatement = null;
      try {
         preparedStatement = connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
         preparedStatement.setQueryTimeout(30);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return preparedStatement;
   }
   
   
   public DBUser createDBUser() {
      return new DBUser();
   }
   
   public DBUser getUBUser(int id) {

      String sqlString = "SELECT Use_Id, firstName, lastName FROM User WHERE Use_ID = ?";
      Connection connection = this.getConnection();
      PreparedStatement preparedStatement = this.getPreparedStatement(sqlString, connection);
      DBUser dbUser = null;
      
      try {
         preparedStatement.setInt(1, id);
         ResultSet result = preparedStatement.executeQuery();
         
         result.next();
         dbUser = new DBUser();
         dbUser.setId((result.getInt(1)));
         dbUser.setFirstName(result.getString(2));
         dbUser.setLastName(result.getString(3));

      } catch (SQLException e) {
         // TODO Auto-generated catch block         
         e.printStackTrace();
      }
      finally {
         try {
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      return dbUser;
   }
   
   public LinkedList<DBUser> getAllDBUsers() {
      return null;
   }
   
   public void saveToDatabase(DBUser dbUser) {
      
      String sqlString = "INSERT INTO User VALUES (null, ?, ?)";
      Connection connection = this.getConnection();
      PreparedStatement preparedStatement = this.getPreparedStatement(sqlString, connection);
      
      try {
         preparedStatement.setString(1, dbUser.getFirstName());
         preparedStatement.setString(2, dbUser.getLastName());
         preparedStatement.execute();
         
         // récupérer l'identifiant créer par la BDD
         ResultSet result = preparedStatement.getGeneratedKeys();
         result.next();
         dbUser.setId(result.getInt(1));

      } catch (SQLException e) {
         // TODO Auto-generated catch block         
         e.printStackTrace();
      }
      finally {
         try {
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      
   }
   
}
