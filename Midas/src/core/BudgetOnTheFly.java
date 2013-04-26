/* ============================================================================
 * Nom du fichier   : BudgetOnTheFly.java
 * ============================================================================
 * Date de création : 24 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core;

import java.util.Date;

import database.dbComponents.DBBudgetOnTheFly;
import database.dbComponents.DBBudget;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class BudgetOnTheFly extends Budget{

   private DBBudgetOnTheFly dbBudetOnTheFly;
   
   /**
    * @param dbBudget
    */
   public BudgetOnTheFly(Budget budget, Date startDate, Date endDate) {
      super(budget.getDBBudget());
      this.dbBudetOnTheFly = new DBBudgetOnTheFly();
      this.dbBudetOnTheFly.setStart(startDate);
      this.dbBudetOnTheFly.setEnd(endDate);
   }

   
   /**
    * @param dbBudget
    */
   public BudgetOnTheFly(DBBudget dbBudget, DBBudgetOnTheFly dbBudetOnTheFly) {
      super(dbBudget);
      this.dbBudetOnTheFly = dbBudetOnTheFly;
   }

   public Date consultStartDate() {
      return dbBudetOnTheFly.getStart();
   }
   
   public void modifyStartDate(Date date) {
      dbBudetOnTheFly.setStart(date);
   }
   
   public Date consultEndDate() {
      return dbBudetOnTheFly.getEnd();
   }
   
   public void modifyEndtDate(Date date) {
      dbBudetOnTheFly.setEnd(date);
   }
}
