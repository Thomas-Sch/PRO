/* ============================================================================
 * Nom du fichier   : FinancialTransaction.java
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

import database.dbComponents.DBBudget;
import database.dbComponents.DBComponent;
import database.dbComponents.DBFinancialTransaction;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class FinancialTransaction {
      private DBFinancialTransaction dbFinancialTransaction;
      
      public FinancialTransaction (User user, double amount, Account account, Date date, 
                                    String reason, Budget budget, Category category, Recurrence recurrence) {
         
         this.dbFinancialTransaction = new DBFinancialTransaction();
         this.dbFinancialTransaction.setDbUser(user.getDBUser().getId());
         this.dbFinancialTransaction.setAmount(amount);
         this.dbFinancialTransaction.setDbAccount(account.getDBAccount().getId());
         this.dbFinancialTransaction.setDate(date);
         this.dbFinancialTransaction.setReason(reason);
         if (budget != null)
            this.dbFinancialTransaction.setDbBudget(budget.getDBBudget().getId()); //-----------null possible??
         if (category != null)
            this.dbFinancialTransaction.setDbCategory(category.getDBCategory().getId());
         if (recurrence != null)
            this.dbFinancialTransaction.setDbRecurrence(recurrence.getDBRecurence().getId());
      }
      
      public FinancialTransaction(DBFinancialTransaction dbFinancialTransaction) {
         this.dbFinancialTransaction = dbFinancialTransaction;
      }
      
      public double consultAmount() {
         return dbFinancialTransaction.getAmount();
      }
      
      public void modifyAmount(double amount) {
         dbFinancialTransaction.setAmount(amount);
      }
      
      public Date consultDate() {
         return dbFinancialTransaction.getDate();
      }
      
      public void modifyDate(Date date) {
         dbFinancialTransaction.setDate(date);
      }
      
      public String consultReasont() {
         return dbFinancialTransaction.getReason();
      }
      
      public void modifyReason(String reason) {
         dbFinancialTransaction.setReason(reason);
      }
      
      public void addToBudget(Budget budget) { 
        dbFinancialTransaction.setDbBudget(budget.getDBBudget().getId());
      }
      
      public void removeToBudget() {  //----------------------------------??? remove
         dbFinancialTransaction.setDbBudget(null);
      }
      
      public Budget consultBindBudget() {
         return dbBudget; // --- ?? BUG lien car Id();
      }
      
      public void addToCategory(Category category) { 
         dbFinancialTransaction.setDbCategory(category.getDBCategory().getId());
       }
       
       public void removeAccountSrc() {  //----------------------------------??? remove LIEN BUG
          dbFinancialTransaction.setDbCategory(null);
       }
      
      public Account consultAccountSRC() { //---------------------------------??? remove LIEN BUG je ne peux pas recup l'account
         return dbFinancialTransaction.getDbAccount();
      }
      
      public void modifyRecurrence(Recurrence) {
         dbFinancialTransaction.setDbRecurrence(null); 
      }
      
      public void removeRecurrence() { //-------------------?? valeur par default
         dbFinancialTransaction.setDbRecurrence(null);
      }
      
      public void modifiyUser(User user) {
         dbFinancialTransaction.setDbUser(user.getDBUser());
      }
      
      public User consultUser() {
         return dbFinancialTransaction.getDbUser(); // ---- bug ID
      }
   }
