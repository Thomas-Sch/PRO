/* ============================================================================
 * Nom du fichier   : RecurrenceMonthly.java
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

import database.dbComponents.DBRecurrence;
import database.dbComponents.DBRecurrenceMonthly;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class RecurrenceMonth extends Recurrence{
   
   private DBRecurrenceMonthly dbRecurrenceMonth;
   
   /**
    * @param dbRecurrence
    */
   public RecurrenceMonth(DBRecurrence dbRecurrence, int recurrence) {
      super(dbRecurrence);
      this.dbRecurrenceMonth = new DBRecurrenceMonthly();
      this.dbRecurrenceMonth.setEveryXMonth(recurrence);
   }
   
   public Integer consultRecurrence () {
      return dbRecurrenceMonth.getEveryXMonth(); 
   }
   
   public void modifyRecurrence (int recurrence) {
      dbRecurrenceMonth.setEveryXMonth(recurrence); 
   }
}
