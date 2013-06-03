/* ============================================================================
 * Nom du fichier   : DBErrorHandler.java
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

import java.sql.SQLException;
import core.MidasLogs;

/**
 * 
 * Cette classe centralise et gère les éventuelles exceptions issues du
 * paquetage "database" et ses sous-paquetages.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class DBErrorHandler {

   /**
    * Cette méthode stocke l'erreur issue du traitement d'une requête SQL dans
    * un fichier d'erreur et propage l'exception sous la forme généralisée à
    * l'appelant.
    * 
    * @param e
    *           - l'exception levée.
    * @throws DatabaseException
    *            l'exception généralisée.
    */
   public static void resultSetError(SQLException e) throws DatabaseException {
      MidasLogs.sqlErrors.push(e.getMessage());
      throw new DatabaseException();
   }

   /**
    * Cette méthode stocke l'erreur depuis la base de données dans un fichier
    * d'erreur et propage l'exception sous la forme généralisée à l'appelant.
    * 
    * @param e
    *           - l'exception levée.
    * @throws DatabaseException
    *            l'exception généralisée.
    */
   public static void executionError(SQLException e) throws DatabaseException {
      MidasLogs.sqlErrors.push(e.getMessage());
      throw new DatabaseException();
   }

   /**
    * Cette méthode stocke l'erreur issue de la création de la requête SQL dans
    * un fichier d'erreur et propage l'exception sous la forme généralisée à
    * l'appelant.
    * 
    * @param e
    *           - l'exception levée.
    * @throws DatabaseException
    *            l'exceptions généralisée.
    */
   public static void preparedStatementError(SQLException e)
         throws DatabaseException {
      MidasLogs.sqlErrors.push(e.getMessage());
      throw new DatabaseException();
   }

   /**
    * Cette méthode stocke l'erreur issue de la connection à la base de données
    * dans un fichier d'erreur et propage l'exception sous la forme généralisée
    * à l'appelant.
    * 
    * @param e
    *           - l'exception levée.
    * @throws DatabaseException
    *            l'exceptions généralisée.
    */
   public static void connectionError(Exception e) throws DatabaseException {
      MidasLogs.sqlErrors.push(e.getMessage());
      throw new DatabaseException();
   }

   /**
    * Cette méthode informe l'appelant sous la forme généralisée d'une violation
    * de contrainte.
    * 
    * @throws DatabaseConstraintViolation
    *            l'exception généralisée.
    */
   public static void constraintViolation() throws DatabaseConstraintViolation {
      throw new DatabaseConstraintViolation("DatabaseConstraintViolation");
   }
}
