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

public class DBBudgetOnTheFly extends DBBudget {

   java.util.Date start;
   java.util.Date end;
   
   public Date getStart() {
      return start;
   }
   public void setStart(Date start) {
      this.start = start;
   }
   public Date getEnd() {
      return end;
   }
   public void setEnd(Date end) {
      this.end = end;
   }
   @Override
   public String toString() {
      return super.toString() + "DBBudetOnTheFly [start=" + start + ", end=" + end + ", limit="
            + limit + ", dbRecurrence=" + dbRecurrence + ", dbAccount="
            + dbAccount + ", id=" + id + "]";
   }

}
