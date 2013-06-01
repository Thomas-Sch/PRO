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

import java.awt.Component;

import javax.swing.event.ListSelectionListener;

import core.Core;
import core.components.Account;
import core.components.AccountList;

/**
 * Contrôleur pour la liste à séléction simple d'auteurs.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class AccountListBox extends Controller {

   JAccountList view;
   AccountList model;

   /**
    * @param core
    */
   public AccountListBox(Core core) {
      super(core);
   }

   /*
    * (non-Javadoc)
    * 
    * @see gui.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      model = getCore().getAllAccounts();
      view = new JAccountList(model);
      model.addObserver(view);
   }

   /*
    * (non-Javadoc)
    * 
    * @see gui.Controller#initListeners()
    */
   @Override
   protected void initListeners() {
   }

   /*
    * (non-Javadoc)
    * 
    * @see gui.Controller#getGraphicalComponent()
    */
   @Override
   public Component getGraphicalComponent() {
      return view;
   }
   
   /**
    * Retourne le compte selectionné dans la liste.
    * @return Le compte selectionné.
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
    * @param listener L'écouteur ajouté
    */
   public void addSelectionChangedListener(ListSelectionListener listener) {
      view.addListSelectionListener(listener);
   }
}
