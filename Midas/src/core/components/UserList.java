/* ============================================================================
 * Nom du fichier   : UserList.java
 * ============================================================================
 * Date de création : 1 mai 2013
 * ============================================================================
 * Auteurs          : Crescenzio Fabio
 *                    Decorvet Grégoire
 *                    Jaquier Kevin
 *                    Schweizer Thomas
 * ============================================================================
 */
package core.components;

import core.Core;

/**
 * Représente la liste des utilisateurs.
 * @author Crescenzio Fabio
 * @author Decorvet Grégoire
 * @author Jaquier Kevin
 * @author Schweizer Thomas
 *
 */
public class UserList extends ListTemplate<User> { 
   
   public UserList(Core core) {
      super(core);
   }
   
   public User get(int userId) {
      for(User user : getList()) {
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
