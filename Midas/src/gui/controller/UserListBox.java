/* ============================================================================
 * Nom du fichier   : UserListBox.java
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
package gui.controller;

import gui.Controller;
import gui.component.list.JUserList;

import java.awt.Component;

import javax.swing.event.ListSelectionListener;

import core.Core;
import core.components.User;
import core.components.UserList;

/**
 * Contrôleur pour la liste graphique d'auteurs.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class UserListBox extends Controller {
   
   private JUserList view;
   private UserList model;
   

   /**
    * @param core
    */
   public UserListBox(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see gui.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      model = getCore().getAllUsers();
      view = new JUserList(model);
      model.addObserver(view);
   }

   /* (non-Javadoc)
    * @see gui.Controller#initListeners()
    */
   @Override
   protected void initListeners() {
   }

   /* (non-Javadoc)
    * @see gui.Controller#getGraphicalComponent()
    */
   @Override
   public Component getGraphicalComponent() {
      return view;
   }
      
   /**
    * Retourne l'utilisateur selectionné dans la liste.
    * @return L'utilisateur selectionné.
    */
   public User getSelectedValue() {
      return view.getSelectedValue();
   }

   public void updateModel() {
      model.setChangedAndNotifyObservers();
   }
   
   public void addSelectionChangedListener(ListSelectionListener listener) {
      view.addListSelectionListener(listener);
   }

}
