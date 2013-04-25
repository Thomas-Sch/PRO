/* ============================================================================
 * Nom du fichier   : Budget.java
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

import database.dbComponents.DBAccount;
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
public class Budget {

   private DBBudget dbBudget;
   
   public Budget (double limit, Account account, Recurrence recurrence) {
      this.dbBudget = new DBBudget();
      this.dbBudget.setLimit(limit);
      this.dbBudget.setDbAccount(account.getDBAccount().getId());
      this.dbBudget.setDbRecurrence(recurrence.getDBRecurence().getId());
   }
   
   public Budget(DBBudget dbBudget) {
      this.dbBudget = dbBudget;
   }
   
   public double consultLimit() {
      return dbBudget.getLimit();
   }
   
   public void modifyLimit(double limit) {
      if (limit < 0) {
         // erreur
      }
      else {
         dbBudget.setLimit(limit);
      }
   }
   
   public Recurrence consultRecurrence() { //---------------------TEST ERROR ???
      return dbBudget.getDbRecurrence();
   }
   
   public void modifyRecurrence(Recurrence recurrence) {
      this.dbBudget.setDbRecurrence(recurrence.getDBRecurence().getId());
   }
   
   public Integer consultBindAccount() {
      return dbBudget.getDbAccount();
   }
   
   public void bindAccount(Account account) {
      this.dbBudget.setDbAccount(account.getDBAccount().getId());
   }
   
   protected DBBudget getDBBudget() {
      return dbBudget;
   }
}
