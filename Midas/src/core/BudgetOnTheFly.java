/* ============================================================================
 * Nom du fichier   : BudgetOnTheFly.java
 * ============================================================================
 * Date de cr�ation : 24 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi S�bastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Gr�goire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core;

import java.util.Date;

import database.dbComponents.DBBudetOnTheFly;
import database.dbComponents.DBBudget;

/**
 * TODO
 * @author Biolzi S�bastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Gr�goire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class BudgetOnTheFly extends Budget{

   private DBBudetOnTheFly dbBudetOnTheFly;
   
   /**
    * @param dbBudget
    */
   public BudgetOnTheFly(Budget budget, Date startDate, Date endDate) {
      super(budget.getDBBudget());
      this.dbBudetOnTheFly = new DBBudetOnTheFly();
      this.dbBudetOnTheFly.setStart(startDate);
      this.dbBudetOnTheFly.setEnd(endDate);
   }

   
   /**
    * @param dbBudget
    */
   public BudgetOnTheFly(DBBudget dbBudget, DBBudetOnTheFly dbBudetOnTheFly) {
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
