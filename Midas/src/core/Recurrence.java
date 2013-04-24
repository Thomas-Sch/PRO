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
   
   public Recurrence (String name, Date startDate, Date endDate) {
      this.dbRecurrence = new DBRecurrence();
      this.dbRecurrence.setName(name);
      this.dbRecurrence.setStart(startDate);
      this.dbRecurrence.setEnd(endDate);
   }
   
   public Recurrence(DBRecurrence dbRecurrence) {
      this.dbRecurrence = dbRecurrence;
   }
   
   public String consultName() {
      return dbRecurrence.getName();
   }
   public void modifyName(String name) {
      dbRecurrence.setName(name);
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
