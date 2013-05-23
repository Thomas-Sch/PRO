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
package core.components;

import core.Core;
import core.CoreComponent;
import core.IdentifiedComponent;
import database.dbComponents.DBFinancialTransaction;
import java.util.Date;

/**
 * Cette classe représente une transaction financière.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */

public class FinancialTransaction extends CoreComponent implements
      IdentifiedComponent {

   private DBFinancialTransaction dbFinancialTransaction;

   /**
    * Crée une transaction financière à partir de sa représentation dans la base
    * de données.
    * 
    * @param core
    *           - coeur logique du programme.
    * @param dbFinancialTransaction
    *           - la transaction financière en provenance de la base de données.
    */
   public FinancialTransaction(Core core,
         DBFinancialTransaction dbFinancialTransaction) {
      super(core);
      this.dbFinancialTransaction = dbFinancialTransaction;
   }
   
   /**
    * Retourne l'objet représentant cette transaction pour la base de données.
    * 
    * @return La transaction sous une forme compatible avec la base de données.
    */
   public DBFinancialTransaction getDBFinancialTransaction() {
      return dbFinancialTransaction;
   }

   /**
    * Retourne le montant de la transaction.
    * 
    * @return Le montant de la transaction.
    */
   public double getAmount() {
      return dbFinancialTransaction.getAmount();
   }

   /**
    * Définit le montant de la transaction.
    * 
    * @param amount
    *           - le montant de la transaction.
    */
   public void setAmount(double amount) {
      dbFinancialTransaction.setAmount(amount);
   }

   /**
    * Retourne la date de la transaction.
    * 
    * @return La date de la transaction
    */
   public Date getDate() {
      return dbFinancialTransaction.getDate();
   }

   /**
    * Définit la date de la transaction.
    * 
    * @param date
    *           - la date de la transaction.
    */
   public void setDate(Date date) {
      dbFinancialTransaction.setDate(date);
   }

   /**
    * Retourne le texte décrivant la raison de la transaction.
    * 
    * @return La raison de la transaction.
    */
   public String getReason() {
      return dbFinancialTransaction.getReason();
   }

   /**
    * Définit le texte décrivant la raison de la transaction.
    * 
    * @param reason - la raison de la transaction.
    */
   public void setReason(String reason) {
      dbFinancialTransaction.setReason(reason);
   }

   /**
    * Retourne le budget auquel la transaction est rattachée.
    * 
    * @return Le budget concerné par la transaction.
    */
   public Budget getBudget() {
      return core.getBudget(dbFinancialTransaction.getDbBudget());
   }
   
   /**
    * Retourne l'identifiant, par rapport à la base de données, du budget auquel est associé cette transaction.
    * @return L'identifant du budget.
    */
   public int getBudgetId() {
      return dbFinancialTransaction.getDbBudget();
   }
   
   /**
    * Retourne l'identifiant, par rapport à la base de données, 
    * @return
    */
   public int getAccountId() {
      return dbFinancialTransaction.getDbAccount();
   }

   /**
    * Ajoute la transaction dans un budget
    * 
    * @param budget
    *           - un budget
    */
   public void addToBudget(Budget budget) {
      dbFinancialTransaction.setDbBudget(budget.getId());
   }

   /**
    * consulte la categorie auquelle la transaction est liee
    * 
    * @return la categorie
    */
   public Category getCategory() {
      return core.getCategory(dbFinancialTransaction.getDbCategory());
   }

   /**
    * Ajoute la transaction dans une categorie
    * 
    * @param category
    *           - une categorie
    */
   public void addToCategory(Category category) {
      dbFinancialTransaction.setDbCategory(category.getId());
   }

   /**
    * consulte le compte source de la transaction
    * 
    * @return le compte
    */
   public Account getAccount() {
      return core.getAccount(dbFinancialTransaction.getDbAccount());
   }

   /**
    * modifie le compte source de la transaction
    * 
    * @param account
    *           - le compte source
    */
   public void setAccount(Account account) {
      dbFinancialTransaction.setDbAccount(account.getId());
   }

   /**
    * consulte la recurence de la transaction
    * 
    * @return la recurrence
    */
   public Recurrence getRecurrence() {
      return core.getRecurrence(dbFinancialTransaction.getDbRecurrence());
   }

   /**
    * modifie la recurence de la transaction
    * 
    * @param recurrence
    *           - la recurrence
    */
   public void setRecurrence(Recurrence recurrence) {
      dbFinancialTransaction.setDbRecurrence(recurrence.getId());
   }

   /**
    * consult la personne ayant effectuer la transaction
    * 
    * @return la personne ayant effectuer la transaction
    */
   public User getUser() {
      return core.getUser(dbFinancialTransaction.getDbUser());
   }

   /**
    * modifie l'utilisateur ayant effectuer la transaction
    * 
    * @param user
    *           - l'utilisateur
    */
   public void setUser(User user) {
      dbFinancialTransaction.setDbUser(user.getId());
   }

   public int getId() {
      return dbFinancialTransaction.getId();
   }
}
