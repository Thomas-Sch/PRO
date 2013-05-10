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
 * Cette classe centralise et gère les eventuelles exceptions issues du paquet
 * "database" et ses sous paquets
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class DBErrorHandler {   
      
   /**
    * Cette méthode stocke l'erreur issu du traitement d'un requête SQL
    * dans un fichier d'erreur et progage l'exception sous la forme
    * généralisée à l'appéllant
    * @param e - l'exception levée
    * @throws DatabaseException
    */
   public static void resultSetError(SQLException e) throws DatabaseException {
      MidasLogs.sqlErrors.push(e.getMessage());
      throw new DatabaseException();
   }
 
   /**
    * Cette méthode stocke l'erreur depuis la base de données
    * dans un fichier d'erreur et progage l'exception sous la forme
    * généralisée à l'appéllant
    * @param e - l'exception levée
    * @throws DatabaseException
    */
   public static void executionError(SQLException e) throws DatabaseException {
      MidasLogs.sqlErrors.push(e.getMessage());
      throw new DatabaseException();
   }

   /**
    * Cette méthode stocke l'erreur issu de la création de la requête SQL
    * dans un fichier d'erreur et progage l'exception sous la forme
    * généralisée à l'appéllant
    * @param e - l'exception levée
    * @throws DatabaseException
    */
   public static void preparedStatementError(SQLException e) throws DatabaseException {
      MidasLogs.sqlErrors.push(e.getMessage());
      throw new DatabaseException();
   }
   
   /**
    * Cette méthode stocke l'erreur issu de la connection à la base de données
    * dans un fichier d'erreur et progage l'exception sous la forme
    * généralisée à l'appéllant
    * @param e - l'exception levée
    * @throws DatabaseException
    */
   public static void connectionError(Exception e) throws DatabaseException {
      MidasLogs.sqlErrors.push(e.getMessage());
      throw new DatabaseException();
   }
   
   /**
    * Cette méthode informe l'appélant sous la forme généralisée
    * d'une violation de contrainte.
    * @throws DatabaseConstraintViolation
    */
   public static void constraintViolation() throws DatabaseConstraintViolation {
      throw new DatabaseConstraintViolation("DatabaseConstraintViolation");
   }  
}
