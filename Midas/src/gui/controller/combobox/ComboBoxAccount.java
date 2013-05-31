/* ============================================================================
 * Nom du fichier   : ComboBoxAccount.java
 * ============================================================================
 * Date de création : 9 mai 2013
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
import gui.actions.AcCreateAccount;
import gui.component.combobox.JComboBoxAccounts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Core;
import core.components.Account;
import core.components.AccountList;

/**
 * Contrôleur de la classe de liste déroulante pour les utilisateurs du
 * programme
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class ComboBoxAccount extends Controller {

   JComboBoxAccounts view;
   AccountList model;

   /**
    * Crée le contrôleur d'une ComboBox
    * @param core Coeur logique de l'application.
    */
   public ComboBoxAccount(Core core) {
      super(core);
      model.addObserver(view);
   }

   @Override
   protected void initComponents() {
      model = getCore().getAllAccounts();
      view = new JComboBoxAccounts(model);
   }

   @Override
   protected void initListeners() {
      view.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if (view.isCreateNewSelected()) {
               AcCreateAccount action = new AcCreateAccount(getCore());
               action.actionPerformed(arg0);
               view.setSelectedItem(action.getCreatedAccount());
            }
         }
      });
   }
   
   /**
    * Ajout un écouteur de changement de sélection sur la vue.
    * @param listener
    */
   public void addSelectedChangedListener(ActionListener listener) {
      view.addSelectedChangedListener(listener);
   }

   @Override
   public JComboBoxAccounts getGraphicalComponent() {
      return view;
   }
   
   /**
    * Retourne True si l'item sélectionné dans la liste est actuellement
    * un compte et pas un libellé d'invitation.
    * @return True si un compte est sélectionné.
    */
   public boolean isValidItemSelected() {
      return view.isValidItemSelected();
   }

   /**
    * @return le compte séléctionné.
    */
   public Account getSelectedItem() {
      return (Account) view.getSelectedItem();
   }
}
