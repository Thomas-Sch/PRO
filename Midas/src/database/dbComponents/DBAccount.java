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
 * Représente un compte pour la base de données, et met à disposition les
 * fonctions de manipulations de base.
 * 
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
    * Crée un compte, et initialise les champs qui ne représentent pas une
    * référence sur un autre élément.
    */
   public DBAccount() {
      name = "";
      nameBank = "";
      accountNumber = "";
      amount = 0.0;
      Threshold = 0.0;
   }

   /**
    * Retourne le nom du compte.
    * 
    * @return Le nom du compte.
    */
   public String getName() {
      return name;
   }

   /**
    * Définit le nom du compte.
    * 
    * @param name
    *           - le nouveau nom.
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * Retourne le nom de la banque auprès de laquelle est enregistré le compte.
    * 
    * @return Le nom de la banque.
    */
   public String getNameBank() {
      return nameBank;
   }

   /**
    * Définit le nom de la banque auprès de laquelle est enregistré le compte.
    * 
    * @param nameBank
    *           - le nouveau nom.
    */
   public void setNameBank(String nameBank) {
      this.nameBank = nameBank;
   }

   /**
    * Retourne le numéro de compte par rapport à la banque.
    * 
    * @return Le numéro de compte.
    */
   public String getAccountNumber() {
      return accountNumber;
   }

   /**
    * Définit le numéro de compte par rapport à la banque.
    * 
    * @param accountNumber
    *           - le nouveau numéro de compte.
    */
   public void setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
   }

   /**
    * Retourne le montant restant sur le compte.
    * 
    * @return Le montant restant sur le compte.
    */
   public Double getAmount() {
      return amount;
   }

   /**
    * Définit le montant restant sur le compte.
    * 
    * @param amount
    *           - le nouveau montant restant.
    */
   public void setAmount(Double amount) {
      this.amount = amount;
   }

   /**
    * Retourne le montant définit comme seuil minimal du compte.
    * 
    * @return La valeur du seuil minimal.
    */
   public Double getThreshold() {
      return Threshold;
   }

   /**
    * Définit le seuil minimal du compte.
    * 
    * @param overdraftLimit
    *           - le montant du seuil minimal.
    */
   public void setThreshold(Double overdraftLimit) {
      this.Threshold = overdraftLimit;
   }

   /**
    * Retourne la description du compte.
    * 
    * @return La description du compte.
    */
   public String getDescription() {
      return description;
   }

   /**
    * Définit la description du compte.
    * 
    * @param description
    *           - la nouvelle description.
    */
   public void setDescription(String description) {
      this.description = description;
   }

   @Override
   public String toString() {
      return "DBAccount [name=" + name + ", description=" + description
            + ", nameBank=" + nameBank + ", accountNumber=" + accountNumber
            + ", amount=" + amount + ", Threshold=" + Threshold
            + ", getEnabled()=" + getEnabled() + ", getId()=" + getId() + "]";
   }

}
