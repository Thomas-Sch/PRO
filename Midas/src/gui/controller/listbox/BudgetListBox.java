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
 * Contrôleur des listes de budget.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class BudgetListBox extends Controller {
   
   JBudgetList view;
   BudgetList model;

   /**
    * @param core Coeur logique du programme.
    */
   public BudgetListBox(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see gui.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      model = getCore().getAllBudgets();
      view = new JBudgetList(model);
      model.addObserver(view);
   }

   /* (non-Javadoc)
    * @see gui.Controller#initListeners()
    */
   @Override
   protected void initListeners() {      
   }
   
   /**
    * Retourne le budget selectionné dans la liste.
    * @return Le budget selectionné.
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

   /* (non-Javadoc)
    * @see gui.Controller#getGraphicalComponent()
    */
   @Override
   public Component getGraphicalComponent() {
      return view;
   }
   
   /**
    * Ajoute un écouteur lorsque la sélection change dans la liste.
    * @param listener L'écouteur ajouté
    */
   public void addSelectionChangedListener(ListSelectionListener listener) {
      view.addListSelectionListener(listener);
   }

}
