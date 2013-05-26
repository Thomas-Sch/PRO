/* ============================================================================
 * Nom du fichier   : BudgetOnTheFly.java
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
import core.IdentifiedComponent;
import database.dbComponents.DBBudgetOnTheFly;
import java.util.Date;

/**
 * Cette classe représente un budget à la volée et met à disposition un moyen
 * d'obtenir certaines informations associées audit budget.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class BudgetOnTheFly extends Budget implements IdentifiedComponent {

   private DBBudgetOnTheFly dbBudetOnTheFly;

   /**
    * Construit le budget à la volée à partir de sa représentation de la base de
    * données.
    * 
    * @param core
    *           - coeur logique du programme.
    * @param dbBudgetOnTheFly
    *           - le budget à la volée en provenance de la base de données.
    */
   public BudgetOnTheFly(Core core, DBBudgetOnTheFly dbBudetOnTheFly) {
      super(core, dbBudetOnTheFly);
      this.dbBudetOnTheFly = dbBudetOnTheFly;
   }

   /**
    * Retourne l'objet représentant ce budget à la volée pour la base de
    * données.
    * 
    * @return Le budget sous une forme compatible avec la base de données.
    */
   public DBBudgetOnTheFly getDBBudgetOnTheFly() {
      return dbBudetOnTheFly;
   }

   /**
    * Retourne la date de début de ce budget à la volée.
    * 
    * @return La date de début.
    */
   public Date getStartDate() {
      return dbBudetOnTheFly.getStart();
   }

   /**
    * Définit la date de début du budget à la volée.
    * 
    * @param date
    *           - la nouvelle date de début
    * @throws InconsistencyDate
    *            si la date de début survient après celle de fin.
    */
   public void setStartDate(Date date) throws InconsistencyDate {
      if (date.after(dbBudetOnTheFly.getEnd())) {
         throw new InconsistencyDate("BudgetOnTheFly : " +
         		"The starting date has to be before the ending date");
      }
      dbBudetOnTheFly.setStart(date);
   }

   /**
    * Retourne la date de fin du budget a la volée.
    * 
    * @return La date de fin.
    */
   public Date getEndDate() {
      return dbBudetOnTheFly.getEnd();
   }

   /**
    * Définit la date de fin du budget à la volée.
    * 
    * @param date
    *           - la nouvelle date de fin
    * @throws InconsistencyDate
    *            si la date de fin survient avant celle du début.
    */
   public void setEndtDate(Date date) throws InconsistencyDate {
      if (date.before(dbBudetOnTheFly.getStart())) {
         throw new InconsistencyDate("BudgetOnTheFly : " +
               "The ending date has to be after the starting date");
      }
      dbBudetOnTheFly.setEnd(date);
   }

   /**
    * Retourne l'identifiant du budget à la volée dans la base de données.
    * 
    * @return L'identifiant du budget à la volée.
    */
   public int getId() {
      return dbBudetOnTheFly.getId();
   }
}
