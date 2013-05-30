/* ============================================================================
 * Nom du fichier   : TestRoutine.java
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
package database.test;

import database.dbComponents.DBController;
import database.utils.DatabaseConstraintViolation;
import database.utils.DatabaseException;

/**
 * 
 * Cette herberger une routine de test qui teste toutes les fonctionnalités
 * du paquet "database" et ses sous-paquets
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class ClearDatabase {
  
   /**
    * Routine de test qui teste toutes les méthodes du DBController
    * @param args
    * @throws DatabaseConstraintViolation 
    * @throws DatabaseException 
    * @throws InterruptedException 
    */
   public static void main(String[] args) throws DatabaseException, DatabaseConstraintViolation, InterruptedException {
      DBController dbController = new DBController();
      
      dbController.clearDatabase();
  
   }

}
