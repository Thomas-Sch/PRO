/* ============================================================================
 * Nom du fichier   : JBudgetList.java
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
package gui.component.list;

import gui.View;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

import core.components.Budget;
import core.components.BudgetList;

/**
 * Composant graphique pour l'affichage des listes de budget.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JBudgetList extends JList<Budget> implements View{

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -8808271053870485590L;
   
   private BudgetList budgets;
   
   /**
    * Constructeur par défaut.
    */
   public JBudgetList(BudgetList budgets) {
      this.budgets = budgets;
      setFixedCellWidth(200);
      update(budgets, null);  
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      LinkedList<Budget> list = budgets.getAll(new SortByName());
      
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
