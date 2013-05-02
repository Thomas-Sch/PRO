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

public class DBAccount extends DBComponent {

   String name;
   String nameBank;
   String accountNumber;
   Double amount;
   Double overdraftLimit;
   
   /**
    * @return retourne name
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
    * @return retourne nameBank
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
    * @return retourne accountNumber
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
    * @return retourne overdraftLimit
    */
   public Double getOverdraftLimit() {
      return overdraftLimit;
   }
   /**
    * @param overdraftLimit - la nouvelle valeur pour l'attribut overdraftLimit
    */
   public void setOverdraftLimit(Double overdraftLimit) {
      this.overdraftLimit = overdraftLimit;
   }
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "DBAccount [name=" + name + ", nameBank=" + nameBank
            + ", accountNumber=" + accountNumber + ", amount=" + amount
            + ", overdraftLimit=" + overdraftLimit + ", getId()=" + getId()
            + "]";
   }

}
