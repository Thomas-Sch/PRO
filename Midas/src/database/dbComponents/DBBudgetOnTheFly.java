/* ============================================================================
 * Nom du fichier   : DBBudgetOnTheFly.java
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

import java.util.Date;

/**
 * Représente un budget à la volée pour la base de données, et met à disposition
 * les fonctions de manipulations de base.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class DBBudgetOnTheFly extends DBBudget {

   private Date start;
   private Date end;

   /**
    * Crée un budget à la volée, et initialise les champs qui ne représentent
    * pas une référence sur un autre élément.
    */
   public DBBudgetOnTheFly() {
      start = null;
      end = null;
   }

   /**
    * Retourne la date du commencement du budget.
    * 
    * @return La date de début.
    */
   public Date getStart() {
      return start;
   }

   /**
    * Définit la date du commencement du budget.
    * 
    * @param start
    *           - la nouvelle date de début.
    */
   public void setStart(Date start) {
      this.start = start;
   }

   /**
    * Retourne la date de terminaison du budget.
    * 
    * @return La date de fin.
    */
   public Date getEnd() {
      return end;
   }

   /**
    * Définit la date de terminaison du budget.
    * 
    * @param end
    *           - la nouvelle date de fin.
    */
   public void setEnd(Date end) {
      this.end = end;
   }

   @Override
   public String toString() {
      return "DBBudgetOnTheFly [start=" + start + ", end=" + end
            + ", getName()=" + getName() + ", getDescription()="
            + getDescription() + ", getLimit()=" + getLimit()
            + ", getDbRecurrence()=" + getDbRecurrence() + ", getDbAccount()="
            + getDbAccount() + ", getEnabled()=" + getEnabled() + ", getId()="
            + getId() + "]";
   }

}