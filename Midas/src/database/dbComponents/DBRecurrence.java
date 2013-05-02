/* ============================================================================
 * Nom du fichier   : DBRecurrence.java
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

public class DBRecurrence extends DBComponent {

   private Date start;
   private Date end;
   private Integer days;
   
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
   public Integer getDays() {
      return days;
   }
   public void setDays(Integer days) {
      this.days = days;
   }
   @Override
   public String toString() {
      return "DBRecurrence [start=" + start + ", end=" + end + ", days=" + days
            + ", id=" + id + "]";
   }


}
