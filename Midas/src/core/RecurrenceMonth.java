/* ============================================================================
 * Nom du fichier   : RecurrenceMonthly.java
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

import database.dbComponents.DBRecurrence;
import database.dbComponents.DBRecurrenceMonth;

/**
 * TODO
 * @author Biolzi S�bastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Gr�goire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class RecurrenceMonth extends Recurrence{
   
   private DBRecurrenceMonth dbRecurrenceMonth;
   
   /**
    * @param dbRecurrence
    */
   public RecurrenceMonth(DBRecurrence dbRecurrence, int recurrence) {
      super(dbRecurrence);
      this.dbRecurrenceMonth = new DBRecurrenceMonth();
      this.dbRecurrenceMonth.setEveryXMonth(recurrence);
   }
   
   public Integer consultRecurrence () {
      return dbRecurrenceMonth.getEveryXMonth(); 
   }
   
   public void modifyRecurrence (int recurrence) {
      dbRecurrenceMonth.setEveryXMonth(recurrence); 
   }
}
