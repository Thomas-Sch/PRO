/* ============================================================================
 * Nom du fichier   : Account.java
 * ============================================================================
 * Date de création : 15 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core.components;

import java.util.LinkedList;

import core.Core;
import core.CoreComponent;
import core.IdentifiedComponent;
import database.dbComponents.DBAccount;

/**
 * Cette classe représente le compte d'un utilisateur et les méthodes relatives
 * à sa gestion.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 */
public class Account extends CoreComponent implements IdentifiedComponent {

   private DBAccount dbAccount;

   /**
    * Construit l'object Account.
    * 
    * @param core
    *           - coeur logique du programme.
    * @param dbAcount
    *           - le compte en provenance de la base de données.
    */
   public Account(Core core, DBAccount dbAcount) {
      super(core);
      this.dbAccount = dbAcount;
   }

   /**
    * Construit un compte fictif avec un nom uniquement.
    * 
    * <p>
    * <b>Attention : </b> ce constructeur ne doit être appelé que pour créer un
    * compte fictif qui ne sera jamais envoyé à la base de données.
    * 
    * @param core
    *           - coeur logique du programme.
    * @param name
    *           - le nom du compte.
    */
   Account(Core core, String name) {
      super(core);

      dbAccount = new DBAccount();
      dbAccount.setName(name);
   }

   /**
    * Retourne l'objet représentant ce compte pour la base de données
    * 
    * @return Le compte sous une forme compatible avec la base de données.
    */
   public DBAccount getDBAccount() {
      return dbAccount;
   }

   /**
    * Retourne le solde actuel du compte.
    * 
    * @return Le solde actuel du compte.
    */
   public double getAmount() {
      return dbAccount.getAmount();
   }

   /**
    * Créditer un montant sur le compte : ajouter de l'argent sur le compte.
    * 
    * @param amount
    *           - le montant à rajouter sur le compte.
    */
   public void credit(double amount) {
      dbAccount.setAmount(dbAccount.getAmount() + amount);
   }

   /**
    * Définit le montant sur le compte.
    * 
    * @param amount
    *           - représente le montant du compte.
    */
   public void setAmount(double amount) {
      dbAccount.setAmount(amount);
   }

   /**
    * Définit le nom de la banque associée à ce compte.
    * 
    * @param name
    *           - le nom de la banque.
    */
   public void setBankName(String name) {
      dbAccount.setNameBank(name);
   }

   /**
    * Débite un certain montant donné depuis le compte.
    * 
    * @param amount
    *           - le montant à débiter.
    * @throws montant
    *            indisponible sur le compte : lors que l'on veut prelever plus
    *            d'argent que ce qui est disponnible
    */
   public void debit(double amount) {
      if (dbAccount.getAmount() + dbAccount.getOverdraftLimit() - amount < 0) {
         // erreur
      }
      dbAccount.setAmount(dbAccount.getAmount() - amount);
   }

   /**
    * Retourne la limite de découvert possible sur le compte.
    * 
    * @return La limite de découvert.
    */
   public double getOverdraftLimit() {
      return dbAccount.getOverdraftLimit();
   }

   /**
    * Définit la limite de découvert possible sur le compte.
    * 
    * @param overdraftLimit
    *           - la nouvelle limite de découvert.
    * 
    * @throws nouvelle
    *            limite impossible : si le montant est déjà en découvert et si
    *            la nouvelle limite de découvert est plus petite que le
    *            découvert actuel.
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
    * Retourne le numéro du compte.
    * 
    * @return Le numéro du compte.
    */
   public String getAccountNumber() {
      return dbAccount.getAccountNumber();
   }

   /**
    * Définit le numéro du compte.
    * 
    * @param accountNumber
    *           - le numéro du compte.
    */
   public void setAccountNumber(String accountNumber) {
      dbAccount.setAccountNumber(accountNumber);
   }

   /**
    * Retourne le nom du compte.
    * 
    * @return Le nom du compte.
    */
   public String getName() {
      return dbAccount.getName();
   }

   /**
    * Définit le nom du compte.
    * 
    * @param accountName
    *           - le nom du compte-
    */
   public void setName(String accountName) {
      dbAccount.setName(accountName);
   }

   /**
    * Retourne la liste des budgets associés à ce compte.
    * 
    * @return La liste des budgets associés.
    */
   public LinkedList<Budget> getBindedBudgets() {
      return core.getAllBudgtesRelatedToAccount(getId());
   }

   /**
    * Obtenir le numéro d'identification du compte dans la base de donnée.
    * 
    * @return L'identifiant du compte
    */
   public int getId() {
      return dbAccount.getId();
   }

   /**
    * Retourne un affichage sous forme de chaînes de caractères.
    * <p>
    * La chaîne retournée correspond au nom afin de pouvoir profiter de cette
    * méthode dans les parties graphiques.
    * 
    * @return Une chaîne de caractères représentant le compte.
    */
   public String toString() {
      return getName();
   }

}
