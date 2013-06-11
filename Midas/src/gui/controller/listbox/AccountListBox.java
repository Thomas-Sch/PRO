/* ============================================================================
 * Nom du fichier   : AccountList.java
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
package gui.controller.listbox;

import gui.Controller;
import gui.component.list.JAccountList;

import javax.swing.event.ListSelectionListener;

import core.Core;
import core.components.Account;
import core.components.AccountList;

/**
 * Contrôleur pour la liste à sélection simple d'auteurs.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class AccountListBox extends Controller {

   private JAccountList view;
   private AccountList model;

   /**
    * Crée le contrôleur d'une liste d'auteurs.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public AccountListBox(Core core) {
      super(core);
   }

   @Override
   protected void initComponents() {
      model = getCore().getAllAccounts();
      view = new JAccountList(model);
      model.addObserver(view);
   }

   @Override
   protected void initListeners() {
   }

   @Override
   public JAccountList getGraphicalComponent() {
      return view;
   }

   /**
    * Retourne le compte sélectionné dans la liste.
    * 
    * @return Le compte sélectionné.
    */
   public Account getSelectedValue() {
      return view.getSelectedValue();
   }

   /**
    * Force la mise à jour du modèle.
    */
   public void updateModel() {
      model.setChangedAndNotifyObservers();
   }

   /**
    * Ajoute un écouteur lorsque la sélection change dans la liste.
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
