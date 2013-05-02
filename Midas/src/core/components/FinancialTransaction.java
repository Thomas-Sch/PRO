/* ============================================================================
 * Nom du fichier   : FinancialTransaction.java
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
package core.components;

import java.util.Date;

import core.Core;

import database.dbComponents.DBBudget;
import database.dbComponents.DBComponent;
import database.dbComponents.DBFinancialTransaction;
import database.dbComponents.DBUser;

/**
 * cette classe represente une transaction financiere
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */

public class FinancialTransaction extends CoreComponent {
      
   /**
    * variables d'une transaction financiere
    */
   private DBFinancialTransaction dbFinancialTransaction;
   
   /**
    * Construit l'object FinancialTransaction
    * @param core - coeur logique du programme 
    * @param dbAcount - variable de la classe account
    */
   public FinancialTransaction(Core core, DBFinancialTransaction dbFinancialTransaction) {
      super(core);
      this.dbFinancialTransaction = dbFinancialTransaction;
   }
   
   public DBFinancialTransaction getDBFinancialTransaction() {
      return dbFinancialTransaction;
   }
       
   /**
    * consulter le montant de la transaction 
    * @return un double representant le montant 
    */
   public double getAmount() {
      return dbFinancialTransaction.getAmount();
   }
      
   /**
    * modifier le montant de la transaction 
    * @param amount- le montant de la transaction 
    */    
  public void setAmount(double amount) {
      dbFinancialTransaction.setAmount(amount);
   }
   
  /**
   * consulter la date de la transaction
   * @return la date de la transaction
   */ 
  public Date getDate() {
      return dbFinancialTransaction.getDate();
   }
   
  /**
   * modifie la date de la transaction
   * @param date - la date de la transaction  
   */ 
  public void setDate(Date date) {
      dbFinancialTransaction.setDate(date);
   }
   
  /**
   * consulter la raison de la transaction
   * @return la raison de la transaction
   */ 
  public String getReason() {
      return dbFinancialTransaction.getReason();
   }
   
  /**
   * modifier la raison de la transaction
   * @param la raison de la transaction
   */  
  public void setReason(String reason) {
      dbFinancialTransaction.setReason(reason);
   }
   
  /**
   * consulte le budget auquel la transaction est liee
   * @return le budget
   */ 
  public Budget getBudget() {
     return core.getBudget(dbFinancialTransaction.getDbBudget());
  }
  
  /**
   * Ajoute la transaction dans un budget
   * @param budget - un budget 
   */  
  public void addToBudget(Budget budget) { 
     dbFinancialTransaction.setDbBudget(budget.getId());
   }
   
  /**
   * consulte la categorie auquelle la transaction est liee
   * @return la categorie
   */
  public Category getCategory() {
     return core.getCategory(dbFinancialTransaction.getDbCategory());
  }
  
  /**
   * Ajoute la transaction dans une categorie
   * @param category - une categorie 
   */  
  public void addToCategory(Category category) { 
      dbFinancialTransaction.setDbCategory(category.getId());
    }
    
  /**
   * consulte le compte source de la transaction
   * @return le compte
   */
  public Account getAccount() {
      return core.getAccount(dbFinancialTransaction.getDbAccount());
   }
  
  /**
   * modifie le compte source de la transaction
   * @param account - le compte source
   */
  public void setAccount(Account account) {
      dbFinancialTransaction.setDbAccount(account.getId());
   }
   
//  /**
//   * consulte la recurence de la transaction
//   * @return la recurrence
//   */
//  public Recurrence getRecurrence() {
//      return core.getRecurrence(dbFinancialTransaction.getDbRecurrence());
//   }
  
  /**
   * modifie la recurence de la transaction
   * @param recurrence -  la recurrence
   */
  public void setRecurrence(Recurrence recurrence) {
      dbFinancialTransaction.setDbRecurrence(recurrence.getId()); 
   }
  
  /**
   * consult la personne ayant effectuer la transaction
   * @return la personne ayant effectuer la transaction
   */
  public User getUser() {
     return core.getUser(dbFinancialTransaction.getDbUser());
  }
  
  /**
   * modifie l'utilisateur ayant effectuer la transaction
   * @param user - l'utilisateur
   */
  public void setUser(User user) {
      dbFinancialTransaction.setDbUser(user.getId());
   }
   
  /**
   * Obtenir le numero d'identification de la transaction dans la base de donnee
   * @return l'ID de la transaction
   */ 
  public int getId() {
      return dbFinancialTransaction.getId();
   }
}
