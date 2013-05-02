/* ============================================================================
 * Nom du fichier   : BudgetOnTheFly.java
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

import java.util.Date;
import core.Core;
import database.dbComponents.DBBudgetOnTheFly;

/**
 * Cette classe represente un budet a la volee
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class BudgetOnTheFly extends Budget {

   /**
    * variables du budget a la volee
    */
   private DBBudgetOnTheFly dbBudetOnTheFly;
   
   /**
    * Construit l'object Budget
    * @param core - coeur logique du programme 
    * @param dbBudget - les caracteristiques du budget
    * @param dbBudetOnTheFly - les caracteristiques du budget 
    */
   public BudgetOnTheFly(Core core, DBBudgetOnTheFly dbBudetOnTheFly) {
      super(core, dbBudetOnTheFly);
      this.dbBudetOnTheFly = dbBudetOnTheFly;
   }
   
   public DBBudgetOnTheFly getDBBudgetOnTheFly() {
      return dbBudetOnTheFly;
   }

   /**
    * consult la date de debut du budget a la volee
    * @return la date de debut
    */
   public Date getStartDate() {
      return dbBudetOnTheFly.getStart();
   }
   
   /**
    * modifie la date de debut du budget à la volee
    * @param date - la date de debut
    * @throws date impossible, si la date de debut est placee apres la date de fin
    */
   public void setStartDate(Date date) {
      if(date.after(dbBudetOnTheFly.getEnd())) {
         //error
      }
      dbBudetOnTheFly.setStart(date);
   }
   
   /**
    * consult la date de debut du budget a la volee
    * @return la date de debut
    */
   public Date getEndDate() {
      return dbBudetOnTheFly.getEnd();
   }
   
   /**
    * modifie la date de debut du budget à la volee
    * @param date - la date de debut
    * @throws date impossible, si la date de fin est placee avant la date de debut
    */
   public void setEndtDate(Date date) {
      if(date.after(dbBudetOnTheFly.getEnd())) {
         //error
      }
      dbBudetOnTheFly.setEnd(date);
   }
   
   /**
    * Obtenir le numero d'identification du budget a la volee dans la base de donnee
    * @return l'ID du budget a la volee
    */
   public int getId() {
      return dbBudetOnTheFly.getId();
   }
}
