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
 * Représente une liste de budgets.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class BudgetList extends ListTemplate<Budget> {

   /**
    * Crée une liste de budgets, notifiant ses observateurs lorsqu'elle est mise
    * à jour.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public BudgetList(Core core) {
      super(core);
   }

   @Override
   public Budget createFalseEntry(String name) {
      return new Budget(core, name);
   }

   @Override
   public Budget get(int id) {
      for (Budget budget : getList()) {
         if (budget.getId() == id) {
            return budget;
         }
      }
      return null;
   }

}
