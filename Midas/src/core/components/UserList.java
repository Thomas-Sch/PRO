/* ============================================================================
 * Nom du fichier   : UserList.java
 * ============================================================================
 * Date de création : 1 mai 2013
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

/**
 * Représente la liste des utilisateurs.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class UserList extends ListTemplate<User> {

   /**
    * Crée une liste d'utilisateurs, notifiant ses observateurs lorsqu'elle est
    * mise à jour.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public UserList(Core core) {
      super(core);
   }

   @Override
   public User get(int userId) {
      for (User user : getList()) {
         if (user.getId() == userId) {
            return user;
         }
      }
      return null;
   }

   @Override
   public User createFalseEntry(String name) {
      return new User(core, name);
   }

}
