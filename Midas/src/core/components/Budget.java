/* ============================================================================
 * Nom du fichier   : Budget.java
 * ============================================================================
 * Date de cr�ation : 24 avr. 2013
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
import core.CoreComponent;
import core.IdentifiedComponent;
import database.dbComponents.DBBudget;

/**
 * Cette classe represente un budget.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class Budget extends CoreComponent implements IdentifiedComponent {

   /**
    * Variables du budget.
    */
   private DBBudget dbBudget;
   
   /**
    * Construit l'object Budget.
    * @param core - coeur logique du programme 
    * @param dbBudget - variable de la classe Budget
    */
   public Budget(Core core, DBBudget dbBudget) {
      super(core);
      this.dbBudget = dbBudget;
   }
   
   /**
    * Construit l'object Budget avec un nom uniquement.
    * @param core Contrôleur logique du programme.
    * @param name Nom du budget.
    */
   public Budget(Core core, String name) {
      super(core);
      
      dbBudget = new DBBudget();
      dbBudget.setName(name);
   }
   
   

   /**
    * Retourne les variables du budget
    * @return un object contenant les variables utilisees par le budget
    */
   public DBBudget getDBBudget() {
      return dbBudget;
   }
   
   /**
    * Renvoie le nom du budget courant.
    * @return Le nom du budget.
    */
   public String getName() {
      return dbBudget.getName();
   }
   
   public void setName(String name) {
      dbBudget.setName(name);
   }
   
   public void setDescription(String description) {
      dbBudget.setDescription(description);
   }
   
   /**
    * Consulte la le montant limite du budget.
    * @return un double representant le montant alloue au budget
    */
   public double getLimit() {
      return dbBudget.getLimit();
   }
   
   /**
    * Modifie le montant limite du budget.
    * @param limit - le montant limite du budget
    * 
    * @throws erreur de saisie : si une limite negative est passee en parametre 
    */
   public void setLimit(double limit) {
      if (limit < 0) {
         // erreur
      }
      else {
         dbBudget.setLimit(limit);
      }
   }
   
   /**
   * Consulte la recurence du budget.
   * @return la recurence du budget
   */
   public Recurrence getRecurrence() {
      return core.getRecurrence(dbBudget.getDbRecurrence());
   }
   
   /**
    * Modifie la recurence du budget.
    * @param recurrence - la nouvelle recurence
    */
   public void setRecurrence(Recurrence recurrence) {
      dbBudget.setDbRecurrence(recurrence.getId());
   }
   
   /**
    * Consulte le compte avec le budget est liee.
    * @return le compte lie au budget
    */
   public Account getBindedAccount() {
      return core.getAccount(dbBudget.getDbAccount());
   }
   
   /**
    * Lie le budget a un compte.
    * @param account - un compte
    */
   public void setBindedAccount(Account account) {
      this.dbBudget.setDbAccount(account.getId());
   }
   
   /**
    * Obtenir le numero d'identification du budget dans la base de donnee.
    * @return l'ID du budget
    */
   public int getId() {
      return dbBudget.getId();
   }
   
   /**
    * Retourne le nom du budget.
    * @return un chaine de caractere representant le nom du compte
    */
   public String toString() {
      return getName();
   }
}
