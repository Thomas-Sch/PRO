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
   
   public Double getAmount() {
      return amount;
   }
   public void setAmount(Double amount) {
      this.amount = amount;
   }
   public Date getDate() {
      return date;
   }
   public void setDate(Date date) {
      this.date = date;
   }
   public String getReason() {
      return reason;
   }
   public void setReason(String reason) {
      this.reason = reason;
   }
   public Integer getDbUser() {
      return dbUser;
   }
   public void setDbUser(Integer dbUser) {
      this.dbUser = dbUser;
   }
   public Integer getDbBudget() {
      return dbBudget;
   }
   public void setDbBudget(Integer dbBudget) {
      this.dbBudget = dbBudget;
   }
   public Integer getDbAccount() {
      return dbAccount;
   }
   public void setDbAccount(Integer dbAccount) {
      this.dbAccount = dbAccount;
   }
   public Integer getDbCategory() {
      return dbCategory;
   }
   public void setDbCategory(Integer dbCategory) {
      this.dbCategory = dbCategory;
   }
   public Integer getDbRecurrence() {
      return dbRecurrence;
   }
   public void setDbRecurrence(Integer dbRecurrence) {
      this.dbRecurrence = dbRecurrence;
   }
   @Override
   public String toString() {
      return "DBFinancialTransaction [amount=" + amount + ", date=" + date
            + ", reason=" + reason + ", dbUser=" + dbUser + ", dbBudget="
            + dbBudget + ", dbAccount=" + dbAccount + ", dbCategory="
            + dbCategory + ", dbRecurrence=" + dbRecurrence + ", id=" + id
            + "]";
   }

}
