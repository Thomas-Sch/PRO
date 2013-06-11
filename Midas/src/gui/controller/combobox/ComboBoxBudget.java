/* ============================================================================
 * Nom du fichier   : ComboBoxBudget.java
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
package gui.controller.combobox;

import gui.Controller;
import gui.actions.AcCreateBudget;
import gui.component.combobox.JComboBoxBudget;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Core;
import core.components.Budget;
import core.components.BudgetList;

/**
 * Contrôleur de la liste déroulante de budget.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class ComboBoxBudget extends Controller {

   private JComboBoxBudget view;
   private BudgetList model;

   /**
    * Crée le contrôleur de liste déroulante de budget.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public ComboBoxBudget(Core core) {
      super(core);
      model.addObserver(view);
   }

   @Override
   protected void initComponents() {
      model = getCore().getAllBudgets();
      view = new JComboBoxBudget(model);
   }

   @Override
   protected void initListeners() {
      view.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if (view.isCreateNewSelected()) {
               AcCreateBudget action = new AcCreateBudget(getCore());
               action.actionPerformed(arg0);
               view.setSelectedItem(action.getCreatedBudget());
            }
         }
      });
   }

   @Override
   public Component getGraphicalComponent() {
      return view;
   }

   /**
    * Ajoute un écouteur de changement de sélection sur la vue.
    * 
    * @param listener
    *           - l'écouteur ajouté.
    */
   public void addSelectedChangedListener(ActionListener listener) {
      view.addActionListener(listener);
   }

   /**
    * Retourne le budget sélectionné.
    * 
    * @return Le budget sélectionné.
    */
   public Budget getSelectedItem() {
      return (Budget) view.getSelectedItem();
   }

   /**
    * Test et retourne si l'élément sélectionné dans la liste est actuellement
    * un compte et pas un libellé d'invitation.
    * 
    * @return Vrai si un compte est sélectionné, Faux le cas échéant.
    */
   public boolean isValidItemSelected() {
      return view.isValidItemSelected();
   }

   /**
    * Force le composant graphique à sélectionner l'invite d'action.
    */
   public void setInviteSelected() {
      view.setInviteSelected();
   }
}
