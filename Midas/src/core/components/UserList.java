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

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import core.Core;

/**
 * Représente la liste des utilisateurs.
 * @author Crescenzio Fabio
 * @author Decorvet Grégoire
 * @author Jaquier Kevin
 * @author Schweizer Thomas
 *
 */
public class UserList extends CoreComponent { 
   
   private LinkedList<User> users = new LinkedList<>();
   
   public UserList(Core core) {
      super(core);
   }
   
   public void addUser(User user) {
      users.add(user);
      
      setChanged();
      notifyObservers();
   }
   
   public User getAt(int index) {
      return users.get(index);
   }
   
   public User get(int userId) {
      for(User user : users) {
         if (user.getId() == userId) {
            return user;
         }
      }
      return null;
   }
   
   public LinkedList<User> getAll(Comparator<User> comp) {
      
      LinkedList<User> result = new LinkedList<>();
      
      result.addAll(users);
      
      Collections.sort(result, comp);

      return result;
   }
   
   public void setUsers(LinkedList<User> users) {
      this.users.clear();
      this.users.addAll(users);
      
      setChanged();
      notifyObservers();
   }
   
   public User createFalseUser(String name) {
      return new User(core, name);
   }

}
