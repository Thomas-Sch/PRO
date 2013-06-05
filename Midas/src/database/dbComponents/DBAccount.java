/* ============================================================================
 * Nom du fichier   : DBAccount.java
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

/**
 * 
 * Cette classe represente un compte
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class DBAccount extends DBComponentEnableable {

   private String name;
   private String description;
   private String nameBank;
   private String accountNumber;
   private Double amount;
   private Double Threshold;
   
  /**
   * Initialise les champs qui ne representent pas une référence
   */
   public DBAccount() {
      name = "";
      nameBank = "";
      accountNumber = "";
      amount = 0.0;
      Threshold = 0.0;
   }
   
   /**
    * @return le/la/les name
    */
   public String getName() {
      return name;
   }
   /**
    * @param name - la nouvelle valeur pour l'attribut name
    */
   public void setName(String name) {
      this.name = name;
   }
   /**
    * @return le/la/les nameBank
    */
   public String getNameBank() {
      return nameBank;
   }
   /**
    * @param nameBank - la nouvelle valeur pour l'attribut nameBank
    */
   public void setNameBank(String nameBank) {
      this.nameBank = nameBank;
   }
   /**
    * @return le/la/les accountNumber
    */
   public String getAccountNumber() {
      return accountNumber;
   }
   /**
    * @param accountNumber - la nouvelle valeur pour l'attribut accountNumber
    */
   public void setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
   }
   /**
    * @return le/la/les amount
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
    * @return le/la/les Threshold
    */
   public Double getThreshold() {
      return Threshold;
   }
   /**
    * @param overdraftLimit - la nouvelle valeur pour l'attribut Threshold
    */
   public void setThreshold(Double overdraftLimit) {
      this.Threshold = overdraftLimit;
   }

   /**
    * @return le/la/les description
    */
   public String getDescription() {
      return description;
   }

   /**
    * @param description - la nouvelle valeur pour la description
    */
   public void setDescription(String description) {
      this.description = description;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "DBAccount [name=" + name + ", description=" + description
            + ", nameBank=" + nameBank + ", accountNumber=" + accountNumber
            + ", amount=" + amount + ", Threshold=" + Threshold
            + ", getEnabled()=" + getEnabled() + ", getId()=" + getId() + "]";
   }

}
