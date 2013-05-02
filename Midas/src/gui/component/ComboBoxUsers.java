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
import gui.controller.Controller;
import gui.testdata.AuthorData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import core.User;
import core.components.UserList;

/**
 * TODO
 * @author Crescenzio Fabio
 * @author Decorvet Grégoire
 * @author Jaquier Kevin
 * @author Schweizer Thomas
 *
 */
public class ComboBoxUsers extends JComboBox<User> implements View {
   
   private final static int INDEX_NEW = 0;
   private final static int INDEX_NEW_FIRST_USE = 1;
   
   private UserList users;
   
   private boolean firstUse = true;
   
   /**
    * Constructeur de la liste déroulante.
    */
   public ComboBoxUsers(UserList users) {
      this.users = users;
      
      update(users, null);
   }

   @Override
   public void update(Observable o, Object arg) {
      LinkedList<User> list = users.getAll(new SortByName());
      
      if(firstUse) {
         list.addFirst(users.createFalseUser("", "Sélectionner un auteur")); // TO UPDATE
      }
      
      int index = INDEX_NEW;
      if(firstUse) {
         index = INDEX_NEW_FIRST_USE;
      }
      list.add(index, users.createFalseUser("", "Nouvel auteur...")); // TO UPDATE
      
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
         
         int result;
         result = arg0.consultLastName().compareToIgnoreCase(arg1.consultLastName());
         
         // En cas d'égalité, comparaison du prénom
         if (result == 0) {
            return arg0.consultFirstName().compareToIgnoreCase(arg1.consultFirstName());
         }
         else {
            return result;
         }
      }
      
   }
}
