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

/**
 * 
 * Cette classe represente un budget à la volé
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class DBBudgetOnTheFly extends DBBudget {

   private java.util.Date start;
   private java.util.Date end;
   
   /**
    * Initialise les champs qui ne representent pas une référence
    */
   public DBBudgetOnTheFly() {
      start = null;
      end = null;
   }
   
   /**
    * @return le/la/les start
    */
   public java.util.Date getStart() {
      return start;
   }
   /**
    * @param start - la nouvelle valeur pour l'attribut start
    */
   public void setStart(java.util.Date start) {
      this.start = start;
   }
   /**
    * @return le/la/les end
    */
   public java.util.Date getEnd() {
      return end;
   }
   /**
    * @param end - la nouvelle valeur pour l'attribut end
    */
   public void setEnd(java.util.Date end) {
      this.end = end;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
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