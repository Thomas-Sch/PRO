/* ============================================================================
 * Nom du fichier   : ComboBoxAuthorC.java
 * ============================================================================
 * Date de création : 28 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.controller.combobox;

import gui.Controller;
import gui.actions.AcCreateUser;
import gui.component.combobox.JComboBoxUsers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Core;
import core.components.User;
import core.components.UserList;

/**
 * Contrôleur de la liste déroulante d'auteurs.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class ComboBoxUser extends Controller {

   private JComboBoxUsers view;
   private UserList model;

   /**
    * Crée le contrôleur d'une liste déroulante d'auteurs.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public ComboBoxUser(Core core) {
      super(core);
      model.addObserver(view);
   }

   @Override
   protected void initComponents() {
      model = getCore().getAllUsers();
      view = new JComboBoxUsers(model);
   }

   @Override
   protected void initListeners() {
      view.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if (view.isCreateNewSelected()) {
               AcCreateUser action = new AcCreateUser(getCore());
               action.actionPerformed(arg0);
               view.setSelectedItem(action.getCreatedUser());
            }
         }
      });
   }

   @Override
   public JComboBoxUsers getGraphicalComponent() {
      return view;
   }

   /**
    * Test et retourne si l'élément sélectionné dans la liste est actuellement un
    * compte et pas un libellé d'invitation.
    * 
    * @return Vrai si un compte est sélectionné, Faux le cas échéant.
    */
   public boolean isValidItemSelected() {
      return view.isValidItemSelected();
   }

   /**
    * Retourne l'utilisateur sélectionné.
    * 
    * @return L'utilisateur sélectionné.
    */
   public User getSelectedItem() {
      return (User) view.getSelectedItem();
   }

   /**
    * Ajoute un écouteur de changement de sélection sur la vue.
    * 
    * @param listener
    *           - l'écouteur passé.
    */
   public void addSelectedChangedListener(ActionListener listener) {
      view.addActionListener(listener);
   }

   /**
    * Force le composant graphique à sélectionner l'invite d'action.
    */
   public void setInviteSelected() {
      view.setInviteSelected();
   }
}
