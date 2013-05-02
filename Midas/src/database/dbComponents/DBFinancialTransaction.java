/* ============================================================================
 * Nom du fichier   : DBFinancialTransaction.java
 * ============================================================================
 * Date de création : 02.05.2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package database.dbComponents;

import java.util.Date;


public class DBFinancialTransaction extends DBComponent {

   Double amount;
   Date date;
   String reason;
   Integer dbUser;
   Integer dbBudget;
   Integer dbAccount;
   Integer dbCategory;
   Integer dbRecurrence;
   
   /**
    * @return retourne amount
    */
   public Double getAmount() {
      return amount;
   }

   /**
    * @param amount - la nouvelle valeur pour l'attribut amount
    */
   public void setAmount(Double amount) {
      this.amount = amount;
   }

   /**
    * @return retourne date
    */
   public Date getDate() {
      return date;
   }

   /**
    * @param date - la nouvelle valeur pour l'attribut date
    */
   public void setDate(Date date) {
      this.date = date;
   }

   /**
    * @return retourne reason
    */
   public String getReason() {
      return reason;
   }

   /**
    * @param reason - la nouvelle valeur pour l'attribut reason
    */
   public void setReason(String reason) {
      this.reason = reason;
   }

   /**
    * @return retourne dbUser
    */
   public Integer getDbUser() {
      return dbUser;
   }

   /**
    * @param dbUser - la nouvelle valeur pour l'attribut dbUser
    */
   public void setDbUser(Integer dbUser) {
      this.dbUser = dbUser;
   }

   /**
    * @return retourne dbBudget
    */
   public Integer getDbBudget() {
      return dbBudget;
   }

   /**
    * @param dbBudget - la nouvelle valeur pour l'attribut dbBudget
    */
   public void setDbBudget(Integer dbBudget) {
      this.dbBudget = dbBudget;
   }

   /**
    * @return retourne dbAccount
    */
   public Integer getDbAccount() {
      return dbAccount;
   }

   /**
    * @param dbAccount - la nouvelle valeur pour l'attribut dbAccount
    */
   public void setDbAccount(Integer dbAccount) {
      this.dbAccount = dbAccount;
   }

   /**
    * @return retourne dbCategory
    */
   public Integer getDbCategory() {
      return dbCategory;
   }

   /**
    * @param dbCategory - la nouvelle valeur pour l'attribut dbCategory
    */
   public void setDbCategory(Integer dbCategory) {
      this.dbCategory = dbCategory;
   }

   /**
    * @return retourne dbRecurrence
    */
   public Integer getDbRecurrence() {
      return dbRecurrence;
   }

   /**
    * @param dbRecurrence - la nouvelle valeur pour l'attribut dbRecurrence
    */
   public void setDbRecurrence(Integer dbRecurrence) {
      this.dbRecurrence = dbRecurrence;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "DBFinancialTransaction [amount=" + amount + ", date=" + date
            + ", reason=" + reason + ", dbUser=" + dbUser + ", dbBudget="
            + dbBudget + ", dbAccount=" + dbAccount + ", dbCategory="
            + dbCategory + ", dbRecurrence=" + dbRecurrence + "]";
   }
}
