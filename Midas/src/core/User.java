/* ============================================================================
 * Nom du fichier   : User.java
 * ============================================================================
 * Date de création : 24 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core;

import database.dbComponents.DBUser;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class User {

   private DBUser dbUser;
   
   public User (String firstName, String lastName) {
      dbUser = new DBUser();
      dbUser.setFirstName(firstName);
      dbUser.setLastName(lastName);
   }
   
   public User (DBUser dbUser) {
      this.dbUser = dbUser;
   }
   
   public String consultFirstName() {
      return dbUser.getFirstName();
   }
   public void modifyFirstName(String firstName) {
      dbUser.setFirstName(firstName);
   }
   
   public String consultLastName() {
      return dbUser.getLastName();
   }
   public void modifyLastName(String lastName) {
      dbUser.setLastName(lastName);
   }
   
   protected DBUser getDBUser() {
      return dbUser;
   }
}
