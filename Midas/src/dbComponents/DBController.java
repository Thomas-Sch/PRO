package dbComponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DBController {
   
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
   
   private PreparedStatement getPreparedStatement(String sqlString) {
      Connection connection = this.getConnection();
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
   
   private void destroyPreparedStatement(PreparedStatement preparedStatement) {
      try {
         if (preparedStatement.getConnection() != null) {
            preparedStatement.getConnection().close();
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   private void insert(PreparedStatement preparedStatement, DBComponent dbComponent) {
      try {
         preparedStatement.execute();
         // récupérer l'identifiant créer par la BDD
         ResultSet result = preparedStatement.getGeneratedKeys();
         result.next();
         dbComponent.setId(result.getInt(1));
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   private void update (PreparedStatement preparedStatement) {
      try {
         preparedStatement.execute();      
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   public DBUser createDBUser() {
      return new DBUser();
   }
   
   public DBUser getUBUser(int id) {

      String sqlString = "SELECT Use_Id, firstName, lastName FROM User WHERE Use_ID = ?";
      PreparedStatement preparedStatement = this.getPreparedStatement(sqlString);
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
         this.destroyPreparedStatement(preparedStatement);
      }
      return dbUser;
   }
   
   public LinkedList<DBUser> getAllDBUsers() {
      return null;
   }
   
   public void saveToDatabase(DBUser dbUser) {
      String sqlString;
      PreparedStatement preparedStatement = null;
      try {
         if (dbUser.getId() == null) {
            sqlString = "INSERT INTO User " +
                        "VALUES (null, ?, ?)";
            preparedStatement = this.getPreparedStatement(sqlString);
            preparedStatement.setString(1, dbUser.getFirstName());
            preparedStatement.setString(2, dbUser.getLastName());
            this.insert(preparedStatement, dbUser);
         } else {
            sqlString = "UPDATE User " +
                        "SET firstName = ?, lastName = ? " +
                        "WHERE Use_Id = ?";
            preparedStatement = this.getPreparedStatement(sqlString);
            preparedStatement.setString(1, dbUser.getFirstName());
            preparedStatement.setString(2, dbUser.getLastName());
            preparedStatement.setInt(3, dbUser.getId());
            this.update(preparedStatement);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block         
         e.printStackTrace();
      }
      finally {
         this.destroyPreparedStatement(preparedStatement);
      }
   }
   
}
