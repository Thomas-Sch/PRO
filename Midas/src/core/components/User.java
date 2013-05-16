/* ============================================================================
 * Nom du fichier   : User.java
 * ============================================================================
 * Date de cr�ation : 24 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core.components;

import core.Core;
import core.CoreComponent;
import core.IdentifiedComponent;
import database.dbComponents.DBUser;

/**
 * Cette classe représente un utilisateur.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class User extends CoreComponent implements IdentifiedComponent {

   /**
    * variables d'un utilisateur
    */
   private DBUser dbUser;
 
   /**
    * Construit l'object User
    * @param core - coeur logique du programme 
    * @param dbUser - variable de la classe user
    */
   public User (Core core, DBUser dbUser) {
      super(core);
      this.dbUser = dbUser;
   }
   
   User(Core core, String name) {
      super(core);
      
      dbUser = new DBUser();
      dbUser.setName(name);
   }
   
   public DBUser getDBUser() {
      return dbUser;
   }
   
   /**
    * Retourne le nom de l'utilisateur.
    * @return le nom de l'utilisateur.
    */
   public String getName() {
      return dbUser.getName();
   }
   
   /**
    * Modifie le nom de l'utilisateur.
    * @param name - le nom de l'utilisateur.
    */
   public void setName(String name) {
      dbUser.setName(name);
   }
   
   public int getId() {
      return dbUser.getId();
   }
   
   @Override
   public String toString() {
      return getName();
   }
}
