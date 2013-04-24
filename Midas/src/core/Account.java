/* ============================================================================
 * Nom du fichier   : Account.java
 * ============================================================================
 * Date de création : 15 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core;

import database.dbComponents.DBAccount;


/**
 * Cette classe represente le compte d'un utilisateur
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class Account {

   private DBAccount dbAccount;
   
   // note la valeut le solde sur le compte a sa creation est a 0 ensuite on l'alimente
   public Account (String name, String accountNumber, double overdraftLimit) {
      this.dbAccount = new DBAccount();
      this.dbAccount.setName(name);
      this.dbAccount.setAmount(0.0);
      this.dbAccount.setOverdraftLimit(overdraftLimit);
   }
   
   public Account(DBAccount dbAcount) {
      this.dbAccount = dbAcount;
   }  
   
   public Double consultAccountBalance() {
      return dbAccount.getAmount();
   }
   
   public void credit(Double amount) {
      dbAccount.setAmount(amount);
   }
   
   public void debit(double amount) {
      if (dbAccount.getAmount() + dbAccount.getOverdraftLimit() - amount < 0) {
         // erreur 
      }
      dbAccount.setAmount(dbAccount.getAmount() - amount);
   }
   
   public double consultOverdraftLimit() {
      return dbAccount.getOverdraftLimit();
   }
   
   public void modifyOverdraftLimit(double overdraftLimit) {
      if (overdraftLimit < 0) {
         // erreur
      }
      else {
         dbAccount.setOverdraftLimit(overdraftLimit);
      }
   }
   
   public String consultAccounNumber() {
      return dbAccount.getAccountNumber();
   }
   
   public void modifyAccountNumber(String accountNumber) {
         dbAccount.setAccountNumber(accountNumber);
   }
   
   public String consultAccountName() {
      return dbAccount.getName();
   }
   
   public void modifyAccountName(String accountName)
   {
      dbAccount.setName(accountName);
   }
   
   protected DBAccount getDBAccount() {
      return dbAccount;
   }
   
   
   
}
