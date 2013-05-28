/* ============================================================================
 * Nom du fichier   : Budget.java
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
import core.exceptions.LimitNegative;
import database.dbComponents.DBBudget;
import java.util.LinkedList;

/**
 * Cette classe représente un budget et met à disposition un moyen d'obtenir
 * certaines informations associées audit budget.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class Budget extends CoreComponent implements IdentifiedComponent {

   private DBBudget dbBudget;

   /**
    * Crée un budget à partir de sa représentation dans la base de données.
    * 
    * @param core
    *           - coeur logique du programme.
    * @param dbBudget
    *           - le budget en provenance de la base de données.
    */
   public Budget(Core core, DBBudget dbBudget) {
      super(core);
      this.dbBudget = dbBudget;
   }

   /**
    * Construit un budget fictif avec un nom uniquement.
    * 
    * <p>
    * <b>Attention : </b> ce constructeur ne doit être appelé que pour créer un
    * budget fictif qui ne sera jamais envoyé à la base de données.
    * 
    * @param core
    *           - coeur logique du programme.
    * @param name
    *           - nom du budget fictif.
    */
   Budget(Core core, String name) {
      super(core);

      dbBudget = new DBBudget();
      dbBudget.setName(name);
   }

   /**
    * Retourne l'objet représentant ce budget pour la base de données.
    * 
    * @return Le budget sous une forme compatible avec la base de données.
    */
   public DBBudget getDBBudget() {
      return dbBudget;
   }

   /**
    * Renvoie le nom du budget courant.
    * 
    * @return Le nom du budget.
    */
   public String getName() {
      return dbBudget.getName();
   }

   /**
    * Définit le nom du budget.
    * 
    * @param name
    *           - le nom du budget
    */
   public void setName(String name) {
      dbBudget.setName(name);
   }

   /**
    * Retourne la description du budget.
    * 
    * @return La description du budget.
    */
   public String getDescription() {
      return dbBudget.getDescription();
   }

   /**
    * Définit la description associée au budget.
    * 
    * @param description
    *           - la description du budget.
    */
   public void setDescription(String description) {
      dbBudget.setDescription(description);
   }

   /**
    * Consulte le montant limite du budget.
    * 
    * @return Le montant limite alloué au budget.
    */
   public double getLimit() {
      return dbBudget.getLimit();
   }

   /**
    * Définit le montant limite du budget.
    * 
    * @param limit
    *           - le montant limite du budget.
    * 
    * @throws LimitNegative : 
    *             si une limite negative est passée en paramètre
    */
   public void setLimit(double limit) throws LimitNegative {
      if (limit < 0) {
         throw new LimitNegative("Budget : the Limit can not be a negative number");
      }
      else {
         dbBudget.setLimit(limit);
      }
   }

   /**
    * Retourne la récurrence du budget.
    * 
    * @return La récurrence du budget si elle existe, null le cas échéant.
    */
   public Recurrence getRecurrence() {
      return core.getRecurrence(dbBudget.getDbRecurrence());
   }

   /**
    * Définit la récurrence du budget.
    * 
    * @param recurrence
    *           - la nouvelle récurrence
    */
   public void setRecurrence(Recurrence recurrence) {
      dbBudget.setDbRecurrence(recurrence.getId());
   }

   /**
    * Retourne le compte auquel est relié le budget.
    * 
    * @return Le compte lié au budget.
    */
   public Account getBindedAccount() {
      return core.getAccount(dbBudget.getDbAccount());
   }

   /**
    * Lie le budget au compte spécifié.
    * 
    * @param account
    *           - le compte auquel se réfère le budget.
    */
   public void setBindedAccount(Account account) {
      this.dbBudget.setDbAccount(account.getId());
   }

   /**
    * Retourne la liste de toutes les transactions financières liées à ce
    * budget.
    * 
    * @return La liste des transactions financières associées.
    */
   public LinkedList<FinancialTransaction> getRelatedFinancialTransaction() {
      return core.getAllFinancialTransactionRelatedToBudget(getId());
   }

   /**
    * Retourne la montant total actuellement dépensé pour ce budget.
    * 
    * @return Le montant total dépensé.
    */
   public double getTotalOutgoings() {

      LinkedList<FinancialTransaction> financialTransactions =
                                             getRelatedFinancialTransaction();

      double outgoing = 0.0;

      for (FinancialTransaction financialTrans : financialTransactions) {
         outgoing += financialTrans.getAmount();
      }

      return outgoing;
   }

   /**
    * Retourne le montant encore utilisable pour tenir ce budget.
    * 
    * @return Le montant utilisable.
    */
   public double getRemainingAmount() {
      return getLimit() - getTotalOutgoings();
   }

   /**
    * Retourne la plus grande dépense de ce budget.
    * 
    * @return La plus grande dépense.
    */
   public double getGreatestOutgoing() {

      LinkedList<FinancialTransaction> financialTransactions = getRelatedFinancialTransaction();

      double greatest = 0.0;

      for (FinancialTransaction financialTrans : financialTransactions) {
         greatest = Math.max(financialTrans.getAmount(), greatest);
      }

      return greatest;
   }

   /**
    * Retourne le montant moyen des transactions associées à ce budget.
    * 
    * @return Le montant moyen des transactions.
    */
   public double getAverageOutgoing() {
      LinkedList<FinancialTransaction> financialTransactions =
                                             getRelatedFinancialTransaction();

      double outgoing = 0.0;

      for (FinancialTransaction financialTrans : financialTransactions) {
         outgoing += financialTrans.getAmount();
      }

      return outgoing / financialTransactions.size();
   }

   /**
    * Retourne l'identifiant du budget dans la base de données.
    * 
    * @return L'identifiant du budget.
    */
   public int getId() {
      return dbBudget.getId();
   }

   /**
    * Retourne l'identifiant du compte associé.
    * 
    * @return L'identifiant du compte associé.
    */
   public int getBindedAccountId() {
      return dbBudget.getDbAccount();
   }

   /**
    * Retourne un affichage sous forme de chaîne de caractères.
    * <p>
    * La chaîne retournée correspond au nom afin de pouvoir profiter de cette
    * méthode dans les parties graphiques.
    * 
    * @return Une chaîne de caractères représentant le budget.
    */
   public String toString() {
      return getName();
   }

}
