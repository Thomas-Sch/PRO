/* ============================================================================
 * Nom du fichier   : JUserList.java
 * ============================================================================
 * Date de création : 15 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component.list;

import gui.View;

import java.awt.Dimension;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

import core.components.User;
import core.components.UserList;

/**
 * Représente une liste d'utilisateurs.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JUserList extends JList<User> implements View {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 1933782144590081485L;
   
   private UserList users;

   /**
    * @param controller
    */
   public JUserList(UserList users) {
      this.users = users;
      setFixedCellWidth(200);
      update(users, null);  
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable arg0, Object arg1) {
      LinkedList<User> list = users.getAll(new SortByName());
      
      User[] temp = new User[0];
      setModel(new DefaultComboBoxModel<User>(list.toArray(temp)));
   }
   
   private class SortByName implements Comparator<User> {
      @Override
      public int compare(User arg0, User arg1) {
         return arg0.getName().compareToIgnoreCase(arg1.getName());
      }
   }
   
   public Dimension getPreferredSize() {
      return new Dimension(200, 100);
   }
   
}
