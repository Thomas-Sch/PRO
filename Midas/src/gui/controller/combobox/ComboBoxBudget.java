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
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class ComboBoxBudget extends Controller {
   
   JComboBoxBudget view;
   BudgetList model;
   
   public ComboBoxBudget(Core core) {
      super(core);
      model.addObserver(view);
   }
   

   /* (non-Javadoc)
    * @see gui.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      model = getCore().getAllBudgets();
      view = new JComboBoxBudget(model);
   }

   /* (non-Javadoc)
    * @see gui.Controller#initListeners()
    */
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

   /* (non-Javadoc)
    * @see gui.Controller#getGraphicalComponent()
    */
   @Override
   public Component getGraphicalComponent() {
      return view;
   }
   
   /**
    * Ajout un écouteur de changement de sélection sur la vue.
    * @param listener Ecouteur ajouté.
    */
   public void addSelectedChangedListener(ActionListener listener) {
      view.addActionListener(listener);
   }
   
   /**
    * @return le budget séléctionné.
    */
   public Budget getSelectedItem() {
      return (Budget) view.getSelectedItem();
   }

   /**
    * Retourne True si l'item sélectionné dans la liste est actuellement
    * un compte et pas un libellé d'invitation.
    * @return True si un compte est sélectionné.
    */
   public boolean isValidItemSelected() {
      return view.isValidItemSelected();
   }
}
