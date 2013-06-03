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

   private Double amount;
   private Date date;
   private String reason;
   private Integer dbUser;
   private Integer dbBudget;
   private Integer dbAccount;
   private Integer dbCategory;
   private Integer dbRecurrence;

   /**
    * Crée une transaction financière, en initialisant les champs qui ne
    * représentent pas une référence sur un autre élément.
    */
   public DBFinancialTransaction() {
      amount = 0.0;
      date = new java.util.Date(0);
      reason = "";
   }

   /**
    * Retourne le montant de la transaction.
    * 
    * @return Le montant de la transaction.
    */
   public Double getAmount() {
      return amount;
   }

   /**
    * Définit le montant de la transaction.
    * 
    * @param amount
    *           - la nouveau montant.
    */
   public void setAmount(Double amount) {
      this.amount = amount;
   }

   /**
    * Retourne la date de la transaction.
    * 
    * @return La date de la transaction.
    */
   public Date getDate() {
      return date;
   }

   /**
    * Définit la date de la transaction.
    * 
    * @param date
    *           - la nouvelle date.
    */
   public void setDate(Date date) {
      this.date = date;
   }

   /**
    * Retourne un texte décrivant la raison de la transaction.
    * 
    * @return Un descriptif justifiant la transaction.
    */
   public String getReason() {
      return reason;
   }

   /**
    * Définit le texte décrivant la transaction.
    * 
    * @param reason
    *           - la nouvelle description.
    */
   public void setReason(String reason) {
      this.reason = reason;
   }

   /**
    * Retourne l'identifiant de l'utilisateur à l'origine de cette transaction.
    * 
    * @return L'identifiant de l'auteur de la transaction.
    */
   public Integer getDbUser() {
      return dbUser;
   }

   /**
    * Définit l'utilisateur à l'origine de la transaction.
    * 
    * @param dbUser
    *           - l'identifiant de l'auteur de la transaction.
    */
   public void setDbUser(Integer dbUser) {
      this.dbUser = dbUser;
   }

   /**
    * Retourne l'identifiant du budget concerné par cette transaction.
    * 
    * @return L'identifiant du budget concerné.
    */
   public Integer getDbBudget() {
      return dbBudget;
   }

   /**
    * Définit le budget concerné par cette transaction.
    * 
    * @param dbBudget
    *           - l'identifiant du budget concerné.
    */
   public void setDbBudget(Integer dbBudget) {
      this.dbBudget = dbBudget;
   }

   /**
    * Retourne l'identifiant du compte concerné par cette transaction.
    * 
    * @return L'identifiant du compte concerné.
    */
   public Integer getDbAccount() {
      return dbAccount;
   }

   /**
    * Définit le compte concerné par cette transaction.
    * 
    * @param dbAccount
    *           - l'identifiant du compte concerné.
    */
   public void setDbAccount(Integer dbAccount) {
      this.dbAccount = dbAccount;
   }

   /**
    * Retourne l'identifiant de la catégorie à laquelle appartient cette
    * transaction.
    * 
    * @return L'identifiant de la catégorie de cette transaction.
    */
   public Integer getDbCategory() {
      return dbCategory;
   }

   /**
    * Définit la catégorie à laquelle appartient cette transaction.
    * 
    * @param dbCategory
    *           - l'identifiant de la catégorie.
    */
   public void setDbCategory(Integer dbCategory) {
      this.dbCategory = dbCategory;
   }

   /**
    * Retourne l'identifiant de la récurrence de cette transaction.
    * 
    * @return L'identifiant de la récurrence.
    */
   public Integer getDbRecurrence() {
      return dbRecurrence;
   }

   /**
    * Définit la récurrence de cette transaction.
    * 
    * @param dbRecurrence
    *           - l'identifiant de la récurrence.
    */
   public void setDbRecurrence(Integer dbRecurrence) {
      this.dbRecurrence = dbRecurrence;
   }

   @Override
   public String toString() {
      return "DBFinancialTransaction [amount=" + amount + ", date=" + date
            + ", reason=" + reason + ", dbUser=" + dbUser + ", dbBudget="
            + dbBudget + ", dbAccount=" + dbAccount + ", dbCategory="
            + dbCategory + ", dbRecurrence=" + dbRecurrence + ", getId()="
            + getId() + "]";
   }

}
