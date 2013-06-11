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
package gui.controller.listbox;

import gui.Controller;
import gui.component.list.JUserList;

import java.awt.Component;

import javax.swing.event.ListSelectionListener;

import core.Core;
import core.components.User;
import core.components.UserList;

/**
 * Contrôleur pour la liste graphique d'auteurs.
 * 
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
    * Crée le contrôleur de la liste d'auteurs.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public UserListBox(Core core) {
      super(core);
   }

   @Override
   protected void initComponents() {
      model = getCore().getAllUsers();
      view = new JUserList(model);
      model.addObserver(view);
   }

   @Override
   protected void initListeners() {
   }

   @Override
   public Component getGraphicalComponent() {
      return view;
   }

   /**
    * Retourne l'utilisateur sélectionné dans la liste.
    * 
    * @return L'utilisateur sélectionné.
    */
   public User getSelectedValue() {
      return view.getSelectedValue();
   }

   /**
    * Force une mise à jour du modèle.
    */
   public void updateModel() {
      model.setChangedAndNotifyObservers();
   }

   /**
    * Ajoute un écouteur sur la liste du contrôleur.
    * 
    * @param listener
    *           - l'écouteur ajouté.
    */
   public void addSelectionChangedListener(ListSelectionListener listener) {
      view.addListSelectionListener(listener);
   }

   /**
    * Force la désélection sur la liste.
    */
   public void selectNoItem() {
      view.setSelectedIndex(-1);
      model.setChangedAndNotifyObservers();
   }

}
