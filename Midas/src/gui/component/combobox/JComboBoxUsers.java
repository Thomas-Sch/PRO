/* ============================================================================
 * Nom du fichier   : JComboBoxAuthors.java
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

import settings.Language.Text;

import core.components.User;
import core.components.UserList;

/**
 * Liste déroulante d'utilisateurs du programme.
 * 
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
    * Crée la vue sur une liste déroulante d'utilisateurs.
    * 
    * @param users
    *           - la liste des utilisateurs
    */
   public JComboBoxUsers(UserList users) {
      this.users = users;
      update(users, null);
   }

   @Override
   public void update(Observable o, Object arg) {
      LinkedList<User> list = users.getAll(new SortByName());

      if (isFirstUse()) {
         list.addFirst(users.createFalseEntry(Text.SELECT_USER_LABEL.
                                                                  toString()));
      }

      int index = updateIndex();
      list.add(index, users.createFalseEntry(Text.NEW_USER_LABEL.toString()));

      User[] temp = new User[0];
      setModel(new DefaultComboBoxModel<User>(list.toArray(temp)));
   }

   /**
    * Comparateur d'utilisateurs selon leurs noms.
    * 
    * @author Biolzi Sébastien
    * @author Brito Carvalho Bruno
    * @author Decorvet Grégoire
    * @author Schweizer Thomas
    * @author Sinniger Marcel
    * 
    */
   private class SortByName implements Comparator<User> {
      @Override
      public int compare(User arg0, User arg1) {
         return arg0.getName().compareToIgnoreCase(arg1.getName());
      }
   }
}
