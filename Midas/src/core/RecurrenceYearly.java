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
import database.dbComponents.DBRecurrenceYearly;

/**
 * TODO
 * @author Biolzi S�bastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Gr�goire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class RecurrenceYearly extends Recurrence{
   

   private DBRecurrenceYearly dbRecurrenceYearly;
   
   /**
    * @param dbRecurrence
    */
   public RecurrenceYearly(DBRecurrence dbRecurrence, int recurrence) {
      super(dbRecurrence);
      this.dbRecurrenceYearly= new DBRecurrenceYearly();
      this.dbRecurrenceYearly.setEveryXYear(recurrence);
   }
   
   public Integer consultRecurrence () {
      return dbRecurrenceYearly.getEveryXYear();
   }
   
   public void modifyRecurrence (int recurrence) {
      dbRecurrenceYearly.setEveryXYear(recurrence); 
   }
}
