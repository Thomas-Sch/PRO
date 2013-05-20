/* ============================================================================
 * Nom du fichier   : ComboBoxAuthors.java
 * ============================================================================
 * Date de création : 1 mai 2013
 * ============================================================================
 * Auteurs          : Crescenzio Fabio
 *                    Decorvet Grégoire
 *                    Jaquier Kevin
 *                    Schweizer Thomas
 * ============================================================================
 */
package gui.component.combobox;

import gui.JComboBoxTemplate;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;

import core.components.User;
import core.components.UserList;

/**
 * Liste déroulante d'utilisateurs du programme.
 * @author Crescenzio Fabio
 * @author Decorvet Grégoire
 * @author Jaquier Kevin
 * @author Schweizer Thomas
 *
 */
public class JComboBoxUsers extends JComboBoxTemplate<User> {
   
   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -7152847868675750776L;
   
   private UserList users;
   
   /**
    * Constructeur de la liste déroulante.
    */
   public JComboBoxUsers(UserList users) {
      this.users = users;
      update(users, null);
   }

   @Override
   public void update(Observable o, Object arg) {
      LinkedList<User> list = users.getAll(new SortByName());
      
      if(isFirstUse()) {
         list.addFirst(users.createFalseEntry("Sélectionner un auteur")); // TO UPDATE
      }
      
      int index = updateIndex();
      list.add(index, users.createFalseEntry("Nouvel auteur...")); // TO UPDATE
      
      User[] temp = new User[0];
      setModel(new DefaultComboBoxModel<User>(list.toArray(temp)));
   }
   
   private class SortByName implements Comparator<User> {
      @Override
      public int compare(User arg0, User arg1) {
         return arg0.getName().compareToIgnoreCase(arg1.getName());
      }
   }
}
