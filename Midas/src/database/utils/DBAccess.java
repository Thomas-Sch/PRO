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

/**
 * Cette classe permet de se connecter à une base de données SQLite.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class DBAccess {

   private final String dbPath;

   /**
    * Crée le connecteur à la base de données dont le chemin est spécifié.
    * 
    * @param dbPath
    *           - le lien sur la base de données.
    */
   public DBAccess(String dbPath) {
      this.dbPath = dbPath;
   }

   /**
    * Cette méthode permet de récupérer une connection à la base de données.
    * Ceci permet de créer un "Statement" contenant la requête.
    * 
    * @return Une connection ouverte à la base de données.
    * @throws DatabaseException
    *            si une erreur survient lors de l'accès à la base de données.
    */
   public Connection getConnection() throws DatabaseException {

      Connection connection = null;

      try {
         Class.forName("org.sqlite.JDBC"); // charger le driver pour SQLite
      }
      catch (ClassNotFoundException e) {
         DBErrorHandler.connectionError(e);
      }

      try {
         SQLiteConfig config = new SQLiteConfig();

         // Appliquer les contraintes issues des clés étrangères
         config.enforceForeignKeys(true);

         connection = DriverManager
               .getConnection(dbPath, config.toProperties());
      }
      catch (SQLException e) {
         DBErrorHandler.connectionError(e);
      }

      return connection;
   }

   /**
    * Cette procédure retourne directement un PreparedStatement qui permet
    * d'envoyer des requêtes SQL à la base de données. Les PreparedStatement
    * préservent la base de données des attaques d'injection SQL.
    * 
    * @param sqlString
    *           - la requête SQL du PreparedStatement.
    * @return Un PreparedStatement correspondant à la requête donnée.
    * @throws DatabaseException
    *            si une erreur est survenue lors de l'établissement de la
    *            requête.
    */
   public PreparedStatement getPreparedStatement(String sqlString)
         throws DatabaseException {
      Connection connection = this.getConnection();
      PreparedStatement preparedStatement = null;
      try {
         preparedStatement = connection.prepareStatement(sqlString,
               Statement.RETURN_GENERATED_KEYS);
         preparedStatement.setQueryTimeout(30);
      }
      catch (SQLException e) {
         DBErrorHandler.preparedStatementError(e);
      }

      return preparedStatement;
   }

   /**
    * Termine la connection qui a été ouverte pendant la création d'un
    * PreparedStatement.
    * 
    * @param preparedStatement
    *           - la requête préparée concernée.
    * @throws DatabaseException
    *            si une erreur survient lors de la fermeture.
    */
   public void destroyPreparedStatement(PreparedStatement preparedStatement)
         throws DatabaseException {
      try {
         if (preparedStatement.getConnection() != null) {
            preparedStatement.getConnection().close();
         }
      }
      catch (SQLException e) {
         DBErrorHandler.preparedStatementError(e);
      }
   }
}