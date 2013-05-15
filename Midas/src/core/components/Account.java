/* ============================================================================
 * Nom du fichier   : Account.java
 * ============================================================================
 * Date de cr�ation : 15 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi S�bastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Gr�goire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core.components;

import core.Core;
import database.dbComponents.DBAccount;

/**
 * Cette classe represente le compte d'un utilisateur
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 */
public class Account extends CoreComponent {

   /**
    * variables du compte
    */
   private DBAccount dbAccount;
   
   /**
    * Construit l'object Account
    * @param core - coeur logique du programme 
    * @param dbAcount - variable de la classe account
    */
   public Account(Core core, DBAccount dbAcount) {
      super(core);
      this.dbAccount = dbAcount;
   }
   
   public Account(Core core, String name) {
      super(core);
      
      dbAccount = new DBAccount();
      dbAccount.setName(name);
   }
   
   public DBAccount getDBAccount(){
      return dbAccount;
   }
   
   /**
    * consulter le solde actuel du compte 
    * @return un double representant le solde actuel du compte  
    */
   public Double getAccountBalance() {
      return dbAccount.getAmount();
   }
   
   /**
    * Crediter un montant sur le compte : ajouter de l'argent sur le compte
    * @param amount - representant le montant que l'on veut rajouter sur le compte  
    */
   public void credit(Double amount) {
      dbAccount.setAmount(dbAccount.getAmount() + amount);
   }
   
   public void setAmount(Double amount) {
      dbAccount.setAmount(amount);
   }
   
   /**
    * Debiter un montant sur le compte : prelever de l'argent sur le compte
    * @param amount - representant le montant que l'on veut enlever sur le compte
    * 
    * @throws montant indisponible sur le compte : lors que l'on veut prelever 
    * plus d'argent que ce qui est disponnible
    */
   public void debit(double amount) {
      if (dbAccount.getAmount() + dbAccount.getOverdraftLimit() - amount < 0) {
         // erreur 
      }
      dbAccount.setAmount(dbAccount.getAmount() - amount);
   }
   
   /**
    * consulter la limite de decouvert possible sur le compte 
    * @return un double representant la limite de decouvert 
    */
   public double getOverdraftLimit() {
      return dbAccount.getOverdraftLimit();
   }
   
   /**
    * modifier la limite de decouvert possible sur le compte le solde actuel du compte 
    * @param overdraftLimit - un double represantant la nouvelle limite de decouvert 
    * 
    * @throws nouvelle limite impossible : si le montant est deja en decouvert et si la 
    * nouvelle limite de decouvert est plus petite que le decouvert actuel
    */
   public void setOverdraftLimit(double overdraftLimit) {
      if (overdraftLimit < 0) {
         // erreur
      }
      else {
         dbAccount.setOverdraftLimit(overdraftLimit);
      }
   }
   
   /**
    * consulter le numero du compte 
    * @return le numero du compte 
    */ 
   public String getAccountNumber() {
      return dbAccount.getAccountNumber();
   }
   
   /**
    * modifie le numero du compte 
    * @param  accountNumber - le numero du compte 
    */
   public void setAccountNumber(String accountNumber) {
         dbAccount.setAccountNumber(accountNumber);
   }
   
   /**
    * consulter le nom du compte
    * @return le numero du compte 
    */ 
   public String getAccountName() {
      return dbAccount.getName();
   }
   
   /**
    * modifie le nom du compte 
    * @param accountName - le nom du compte 
    */
   public void setAccountName(String accountName)
   {
      dbAccount.setName(accountName);
   }
   
   
   /**
    * Obtenir le numero d'identification du compte dans la base de donnee
    * @return l'ID du compte
    */
   public int getId() {
      return dbAccount.getId();
   }
   
   public String toString() {
      return getAccountName();
   }
    
}
