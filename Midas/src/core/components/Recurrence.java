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
package core.components;

import java.util.Date;

import core.Core;
import database.dbComponents.DBRecurrence;

/**
 * Cette classe représente une récurrence.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 */

public class Recurrence extends CoreComponent {
   
   /**
    * variables d'une recurrence
    */
   private DBRecurrence dbRecurrence;
   
   /**
    * Construit l'object Recurrence
    * @param core - coeur logique du programme 
    * @param dbRecurrence - variable de la classe recurrence
    */
   public Recurrence(Core core, DBRecurrence dbRecurrence) {
      super(core);
      this.dbRecurrence = dbRecurrence;
   }
   
   public DBRecurrence getDBRecurrence() {
      return dbRecurrence;
   }
   
   /**
    * consult la date de debut du budget a la volee
    * @return la date de debut
    */
   public Date getStartDate() {
      return dbRecurrence.getStart();
   }
   
   /**
    * modifie la date de debut de la recurrence
    * @param date - la date de debut
    * @throws date impossible, si la date de debut est placee apres la date de fin
    */
   public void setStartDate(Date date) {
      if(date.after(dbRecurrence.getEnd())) {
         //error
      }
      dbRecurrence.setStart(date);
   }
   
   /**
    * consult la date de debut de la recurrence
    * @return la date de debut
    */
   public Date getEndDate() {
      return dbRecurrence.getEnd();
   }
   
   /**
    * modifie la date de debut de la recurrence
    * @param date - la date de debut
    * @throws date impossible, si la date de fin est placee avant la date de debut
    */
   public void setEndtDate(Date date) {
      if(date.after(dbRecurrence.getEnd())) {
         //error
      }
      dbRecurrence.setEnd(date);
   }
   
   /**
    * Obtenir le numero d'identification de la recurrence dans la base de donnee
    * @return l'ID de la recurrence
    */
   public int getId() {
      return dbRecurrence.getId();
   }
}
