/* ============================================================================
 * Nom du fichier   : DBAccount.java
 * ============================================================================
 * Date de création : 02.05.2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package database.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteConfig;

public class DBAccess {

   private final String dbPath;
   
   public DBAccess(String dbPath) {
      
      this.dbPath = dbPath;
      
   }
   
   public Connection getConnection() throws DatabaseException {
      
      Connection connection = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
      } catch (ClassNotFoundException e) {
         System.err.println(e);
      }
      
      try {
         SQLiteConfig config = new SQLiteConfig();  
         config.enforceForeignKeys(true);
         connection = DriverManager.getConnection(dbPath, config.toProperties());
         //connection = DriverManager.getConnection(dbPath);
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
