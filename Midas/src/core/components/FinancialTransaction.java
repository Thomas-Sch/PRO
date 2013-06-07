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

import settings.Language.Text;

/**
 * Cette classe représente une transaction financière et met à disposition un
 * moyen d'obtenir certaines informations associées à ladite transaction.
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
      setChangedAndNotifyObservers();
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
      setChangedAndNotifyObservers();
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
    * @param reason
    *           - la raison de la transaction.
    */
   public void setReason(String reason) {
      dbFinancialTransaction.setReason(reason);
      setChangedAndNotifyObservers();
   }

   /**
    * Retourne le budget auquel la transaction est rattachée.
    * 
    * @return Le budget concerné par la transaction.
    */
   public Budget getBudget() {
      Budget result = null;
      
      Integer dbBudgetID = dbFinancialTransaction.getDbBudget();
      if (dbBudgetID != null) {
         result = core.getBudget(dbBudgetID);
      }
      
      return result;
   }

   /**
    * Retourne l'identifiant, par rapport à la base de données, du budget auquel
    * est associé cette transaction.
    * 
    * @return L'identifant du budget associé.
    */
   public int getBudgetId() {
      return dbFinancialTransaction.getDbBudget();
   }

   /**
    * Retourne l'identifiant, par rapport à la base de données, du compte auquel
    * est associé cette transaction.
    * 
    * @return L'identifiant du compte associé.
    */
   public int getAccountId() {
      return dbFinancialTransaction.getDbAccount();
   }

   /**
    * Définit le budget associé à cette transaction.
    * 
    * @param budget
    *           - le budget auquel rattacher cette transaction.
    */
   public void setBudget(Budget budget) {
      dbFinancialTransaction.setDbBudget(budget.getId());
      setChangedAndNotifyObservers();
   }

   /**
    * Retourne la catégorie à laquelle appartient cette transaction.
    * 
    * @return La catégorie de la transaction.
    */
   public Category getCategory() {
      return core.getCategory(dbFinancialTransaction.getDbCategory());
   }

   /**
    * Définit la catégorie de la transaction.
    * 
    * @param category
    *           - la catégorie à laquelle appartient la transaction.
    */
   public void setCategory(Category category) {
      dbFinancialTransaction.setDbCategory(category.getId());
      setChangedAndNotifyObservers();
   }

   /**
    * Retourne le compte associé à la transaction financière.
    * 
    * @return Le compte auquel est rattaché la transaction.
    */
   public Account getAccount() {
      return core.getAccount(dbFinancialTransaction.getDbAccount());
   }

   /**
    * Définit le compte associé à la transaction financière.
    * 
    * @param account
    *           - le compte rattaché à la transaction.
    */
   public void setAccount(Account account) {
      dbFinancialTransaction.setDbAccount(account.getId());
      setChangedAndNotifyObservers();
   }

   /**
    * Retourne la récurrence de la transaction financière.
    * 
    * @return La recurrence de la transaction.
    */
   public Recurrence getRecurrence() {
      return core.getRecurrence(dbFinancialTransaction.getDbRecurrence());
   }

   /**
    * Définit la récurrence de la transaction financière.
    * 
    * @param recurrence
    *           - la recurrence de la transaction.
    */
   public void setRecurrence(Recurrence recurrence) {
      dbFinancialTransaction.setDbRecurrence(recurrence.getId());
      setChangedAndNotifyObservers();
   }

   /**
    * Retourne l'utilisateur ayant effectué la transaction.
    * 
    * @return L'utilisateur à l'origine de la transaction.
    */
   public User getUser() {
      return core.getUser(dbFinancialTransaction.getDbUser());
   }

   /**
    * Définit l'utilisateur ayant effectué la transaction.
    * 
    * @param user
    *           - l'utilisateur à l'origine de la transaction.
    */
   public void setUser(User user) {
      dbFinancialTransaction.setDbUser(user.getId());
      setChangedAndNotifyObservers();
   }
   
   /**
    * Détermine si l'objet est une dépense ou une transaction.
    * 
    * @return Vrai si l'objet est une dépense, Faux s'il s'agit d'une
    *         transaction.
    */
   public boolean isExpense() {
      return dbFinancialTransaction.getDbBudget() != null;
   }
   
   /**
    * Test et retourne si la transaction peut être effectuée sans mettre le
    * compte associé en péril s'il s'agit d'une transaction, ou sans mettre le
    * budget associé en péril s'il s'agit d'une dépense.
    * 
    * @return Vrai si la transaction peut s'effectuer sans risque, Faux si cela
    *         engendre un dépassement de seuil.
    */
   public boolean isHealthy() {
      boolean result = false;

      if (getBudget() != null) {
         result = getBudget().getRemainingAmount() - getAmount() >= 0;
      }
      else if (getAccount() != null) {
         result = getAccount().getAmount() - getAmount() >= 0;
      }

      return result;
   }

   /**
    * Retourne l'identifiant de la transaction financière dans la base de
    * données.
    * 
    * @return L'identifiant de la transaction financière.
    */
   public int getId() {
      return dbFinancialTransaction.getId();
   }
   
   /**
    * Affichage des transactions financières.
    */
   public String toString() {
      String result = "[" + (isExpense() ? Text.EXPENSE_LABEL : Text.TRANSACTION_LABEL) + "] ";

      result += Text.USER_LABEL + ": " + getUser() + ", ";
      result += Text.ACCOUNT_LABEL + ": " + getAccountId() + ", ";
      if(isExpense())
         result += Text.BUDGET_LABEL + ": " + getBudget() + ", ";
      result += Text.REASON_LABEL + ": " + getReason() + ", ";
      result += Text.AMOUNT_LABEL + ": " + getAmount() + " " + Text.SWISS_FRANC_ACRONYM.toString();
      return result;
   }
}
