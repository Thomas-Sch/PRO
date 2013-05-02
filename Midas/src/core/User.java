/* ============================================================================
 * Nom du fichier   : User.java
 * ============================================================================
 * Date de cr�ation : 24 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi S�bastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Gr�goire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core;

import database.dbComponents.DBUser;

/**
 * TODO
 * @author Biolzi S�bastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Gr�goire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class User extends DisplayableComponent {

   private DBUser dbUser;
   
   public User (String firstName, String lastName) {
      dbUser = new DBUser();
      dbUser.setFirstName(firstName);
      dbUser.setLastName(lastName);
   }
   
   public Integer getID() {
      return dbUser.getId();
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
   
   @Override
   public String toString() {
      return (dbUser.getFirstName() + " " + dbUser.getLastName()).trim();
   }
}
