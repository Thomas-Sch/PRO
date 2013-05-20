/* ============================================================================
 * Nom du fichier   : ComboBoxBudget.java
 * ============================================================================
 * Date de création : 16 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component.combobox;

import gui.JComboBoxTemplate;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;

import core.components.Budget;
import core.components.BudgetList;

/**
 * Liste déroulante graphique de budgets.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JComboBoxBudget extends JComboBoxTemplate<Budget> {
   private static final long serialVersionUID = 1L;
   
   private BudgetList budgets;

   /**
    * @param model
    */
   public JComboBoxBudget(BudgetList budgets) {
      this.budgets = budgets;
      update(budgets,null);
   }

   public void update(Observable o, Object arg) {
      LinkedList<Budget> list = budgets.getAll(new SortByName());
      
      if(isFirstUse()) {
         list.addFirst(budgets.createFalseEntry("Sélectionner un budget")); // TO UPDATE
      }
      
      int index = updateIndex();
      list.add(index, budgets.createFalseEntry("Nouveau budget...")); // TO UPDATE
      
      Budget[] temp = new Budget[0];
      setModel(new DefaultComboBoxModel<Budget>(list.toArray(temp)));
   }
   
   private class SortByName implements Comparator<Budget> {
      @Override
      public int compare(Budget arg0, Budget arg1) {
         return arg0.getName().compareToIgnoreCase(arg1.getName());
      }
   }

}
