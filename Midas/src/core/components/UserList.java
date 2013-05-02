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

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import core.User;

/**
 * TODO
 * @author Crescenzio Fabio
 * @author Decorvet Grégoire
 * @author Jaquier Kevin
 * @author Schweizer Thomas
 *
 */
public class UserList extends Observable { 
   
   private LinkedList<User> users = new LinkedList<>();
   
   public UserList() {
      
   }
   
   public void addUser(User user) {
      users.add(user);
      
      setChanged();
      notifyObservers();
   }
   
   public User getAt(int index) {
      return users.get(index);
   }
   
   public User get(int userID) {
      for(User user : users) {
         if (user.getID() == userID) {
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
   
   public User createFalseUser(String firstName, String lastName) {
      return new User(firstName, lastName);
   }

}
