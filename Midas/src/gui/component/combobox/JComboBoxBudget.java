/* ============================================================================
 * Nom du fichier   : JComboBoxBudget.java
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

import settings.Language.Text;

import core.components.Budget;
import core.components.BudgetList;

/**
 * Liste déroulante graphique de budgets.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JComboBoxBudget extends JComboBoxTemplate<Budget> {
   
   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -5689004704089338643L;
   
   private BudgetList budgets;

   /**
    * Crée la liste déroulante des budgets.
    * 
    * @param budgets
    *           - la liste des budgets.
    */
   public JComboBoxBudget(BudgetList budgets) {
      this.budgets = budgets;
      update(budgets, null);
   }

   @Override
   public void update(Observable o, Object arg) {
      LinkedList<Budget> list = budgets.getAll(new SortByName());

      if(isFirstUse()) {
         list.addFirst(budgets.createFalseEntry(Text.SELECT_BUDGET_LABEL.
                                                                  toString()));
      }

      int index = updateIndex();
      list.add(index, budgets.createFalseEntry(Text.NEW_BUDGET_LABEL.
                                                                  toString())); 
      Budget[] temp = new Budget[0];
      setModel(new DefaultComboBoxModel<Budget>(list.toArray(temp)));
   }

   /**
    * Comparateur de budgets selon leurs noms.
    * 
    * @author Biolzi Sébastien
    * @author Brito Carvalho Bruno
    * @author Decorvet Grégoire
    * @author Schweizer Thomas
    * @author Sinniger Marcel
    * 
    */
   private class SortByName implements Comparator<Budget> {
      @Override
      public int compare(Budget arg0, Budget arg1) {
         return arg0.getName().compareToIgnoreCase(arg1.getName());
      }
   }

}
