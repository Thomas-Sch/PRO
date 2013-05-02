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
   /**
    * @return retourne start
    */
   public Date getStart() {
      return start;
   }
   /**
    * @param start - la nouvelle valeur pour l'attribut start
    */
   public void setStart(Date start) {
      this.start = start;
   }
   /**
    * @return retourne end
    */
   public Date getEnd() {
      return end;
   }
   /**
    * @param end - la nouvelle valeur pour l'attribut end
    */
   public void setEnd(Date end) {
      this.end = end;
   }
   /**
    * @return retourne days
    */
   public Integer getDays() {
      return days;
   }
   /**
    * @param days - la nouvelle valeur pour l'attribut days
    */
   public void setDays(Integer days) {
      this.days = days;
   }
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "DBRecurrence [start=" + start + ", end=" + end + ", days=" + days
            + ", getId()=" + getId() + "]";
   }
   
}
