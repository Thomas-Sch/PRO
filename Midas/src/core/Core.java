/* ============================================================================
 * Nom du fichier   : Core.java
 * ============================================================================
 * Date de création : 7 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core;

import core.components.Account;
import database.dbComponents.DBController;
import settings.Settings;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class Core {
   
   private Settings settings = new Settings();
   
   private DBController dbController = new DBController();
   
   public Core() {
      settings.loadSettings();
   }
   
   
   public Account createAccount() {
      
      return new Account(dbController.createDBAccount());
      
   }
   
   public Category getCategoryID(Integer id) {
      return new Category(dbController.getCategory(id));
   }
   
}
