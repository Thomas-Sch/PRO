/* ============================================================================
 * Nom du fichier   : Recurrence.java
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
package core;

import java.util.Date;

import database.dbComponents.DBRecurrence;

/**
 * TODO
 * @author Biolzi S�bastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Gr�goire
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
