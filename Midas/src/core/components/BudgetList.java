/* ============================================================================
 * Nom du fichier   : BudgetList.java
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
package core.components;

import core.Core;

/**
 * Représente une list de budgets.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class BudgetList extends ListTemplate<Budget> {

   /**
    * @param core
    */
   public BudgetList(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see core.components.ListTemplate#createFalseEntry(java.lang.String)
    */
   @Override
   public Budget createFalseEntry(String name) {
      return new Budget(core, name);
   }

   /* (non-Javadoc)
    * @see core.components.ListTemplate#get(int)
    */
   @Override
   public Budget get(int id) {
      for(Budget budget : getList()) {
         if (budget.getId() == id) {
            return budget;
         }
      }
      return null;
   }

}
