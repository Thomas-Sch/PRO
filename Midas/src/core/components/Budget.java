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
import database.dbComponents.DBBudget;

/**
 * Cette classe represente un budget
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class Budget extends CoreComponent {

   /**
    * variables du budget
    */
   private DBBudget dbBudget;
   
   /**
    * Construit l'object Budget
    * @param core - coeur logique du programme 
    * @param dbBudget - variable de la classe Budget
    */
   public Budget(Core core, DBBudget dbBudget) {
      super(core);
      this.dbBudget = dbBudget;
   }
   
   public DBBudget getDBBudget() {
      return dbBudget;
   }
   
   /**
    * consulte la le montant limite du budget
    * @return un double representant le montant alloue au budget
    */
   public double getLimit() {
      return dbBudget.getLimit();
   }
   
   /**
    * modifie le montant limite du budget
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
   
//   /**
//    * consulte la recurence du budget
//    * @return la recurence du budget
//    */
//   public Recurrence getRecurrence() { //---------------------TEST ERROR ???
//      return core.getRecurrence(dbBudget.getDbRecurrence());
//   }
   
   /**
    * modifie la recurence du budget
    * @param recurrence - la nouvelle recurence
    */
   public void setRecurrence(Recurrence recurrence) {
      dbBudget.setDbRecurrence(recurrence.getId());
   }
   
   /**
    * consulte le compte avec le budget est liee
    * @return le compte lie au budget
    */
   public Account getBindAccount() {
      return core.getAccount(dbBudget.getDbAccount());
   }
   
   /**
    * lie le budget a un compte
    * @param account - un compte
    */
   public void setBindAccount(Account account) {
      this.dbBudget.setDbAccount(account.getId());
   }
   
   /**
    * Obtenir le numero d'identification du budget dans la base de donnee
    * @return l'ID du budget
    */
   public int getId() {
      return dbBudget.getId();
   }
}
