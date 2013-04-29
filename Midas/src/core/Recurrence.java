/* ============================================================================
 * Nom du fichier   : Recurrence.java
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
package core;

import java.util.Date;

import database.dbComponents.DBRecurrence;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class Recurrence {
   private DBRecurrence dbRecurrence;
   
   public Recurrence (Date startDate, Date endDate) {
      this.dbRecurrence = new DBRecurrence();
      this.dbRecurrence.setStart(startDate);
      this.dbRecurrence.setEnd(endDate);
   }
   
   public Recurrence(DBRecurrence dbRecurrence) {
      this.dbRecurrence = dbRecurrence;
   }
   
   public Integer consultDays() {
      return dbRecurrence.getDays();
   }
   
   public void modifyDays(Integer days) {
      dbRecurrence.setDays(days);
   }

   public Date consultStartDate() {
      return dbRecurrence.getStart();
   }
   
   public void modifyStartDate(Date date) {
      dbRecurrence.setStart(date);
   }
   
   public Date consultEndDate() {
      return dbRecurrence.getEnd();
   }
   
   public void modifyEndDate(Date date) {
      dbRecurrence.setEnd(date);
   }
   
   protected DBRecurrence getDBRecurence() {
      return dbRecurrence;
   }
}
