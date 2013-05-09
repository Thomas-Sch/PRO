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
package gui.component;

import gui.View;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import core.components.User;
import core.components.UserList;

/**
 * TODO
 * @author Crescenzio Fabio
 * @author Decorvet Grégoire
 * @author Jaquier Kevin
 * @author Schweizer Thomas
 *
 */
public class JComboBoxUsers extends JComboBox<User> implements View {
   
   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -7152847868675750776L;
   private final static int INDEX_NEW = 0;
   private final static int INDEX_NEW_FIRST_USE = 1;
   
   private UserList users;
   
   private boolean firstUse = true;
   
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
      
      if(firstUse) {
         list.addFirst(users.createFalseUser("Sélectionner un auteur")); // TO UPDATE
      }
      
      int index = INDEX_NEW;
      if(firstUse) {
         index = INDEX_NEW_FIRST_USE;
      }
      list.add(index, users.createFalseUser("Nouvel auteur...")); // TO UPDATE
      
      User[] temp = new User[0];
      setModel(new DefaultComboBoxModel<User>(list.toArray(temp)));
   }
   
   public boolean isCreateNewSelected() {
      if(firstUse) {
         return getSelectedIndex() == INDEX_NEW_FIRST_USE;
      }
      else {
         return getSelectedIndex() == INDEX_NEW;
      }
   }
   
   public void setFirstUse(boolean firstUse) {
      this.firstUse = firstUse;
   }
   
   public boolean isFirstUse() {
      return firstUse;
   }
   
   private class SortByName implements Comparator<User> {
      @Override
      public int compare(User arg0, User arg1) {
         return arg0.getName().compareToIgnoreCase(arg1.getName());
      }
   }
}
