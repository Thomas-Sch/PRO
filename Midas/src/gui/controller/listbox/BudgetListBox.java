/* ============================================================================
 * Nom du fichier   : BudgetListBox.java
 * ============================================================================
 * Date de création : 1 juin 2013
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
import gui.component.list.JBudgetList;

import java.awt.Component;

import javax.swing.event.ListSelectionListener;

import core.Core;
import core.components.Budget;
import core.components.BudgetList;

/**
 * Contrôleur d'une liste de budget.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class BudgetListBox extends Controller {

   private JBudgetList view;
   private BudgetList model;

   /**
    * Crée le contrôleur de la liste des budgets.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public BudgetListBox(Core core) {
      super(core);
   }

   @Override
   protected void initComponents() {
      model = getCore().getAllBudgets();
      view = new JBudgetList(model);
      model.addObserver(view);
   }

   @Override
   protected void initListeners() {
      // Aucun pour l'instant
   }

   /**
    * Retourne le budget sélectionné dans la liste.
    * 
    * @return Le budget sélectionné.
    */
   public Budget getSelectedValue() {
      return view.getSelectedValue();
   }

   /**
    * Force la mise à jour du modèle.
    */
   public void updateModel() {
      model.setChangedAndNotifyObservers();
   }

   @Override
   public Component getGraphicalComponent() {
      return view;
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
