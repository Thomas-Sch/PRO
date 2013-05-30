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
package core.components;

import java.util.Date;

import core.Core;
import core.CoreComponent;
import core.IdentifiedComponent;
import core.exceptions.InconsistencyDate;
import database.dbComponents.DBRecurrence;

/**
 * Cette classe représente une récurrence et met à disposition un moyen
 * d'obtenir certaines informations associées à ladite récurrence.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 */

public class Recurrence extends CoreComponent implements IdentifiedComponent {

   private DBRecurrence dbRecurrence;

   /**
    * Crée une récurrence à partir de sa représentation dans la base de données.
    * 
    * @param core
    *           - coeur logique du programme.
    * @param dbRecurrence
    *           - la récurrence en provenance de la base de données.
    */
   public Recurrence(Core core, DBRecurrence dbRecurrence) {
      super(core);
      this.dbRecurrence = dbRecurrence;
   }

   /**
    * Retourne l'objet représentant cette récurrence pour la base de données.
    * 
    * @return La récurrence sous une forme compatible avec la base de données.
    */
   public DBRecurrence getDBRecurrence() {
      return dbRecurrence;
   }

   /**
    * Retourne la date de début de la récurrence.
    * 
    * @return La date de début.
    */
   public Date getStartDate() {
      return dbRecurrence.getStart();
   }

   /**
    * Définit la date de début de la recurrence.
    * 
    * @param date
    *           - la date de début.
    * @throws InconsistencyDate
    *            si la date de début est ultérieure à la date de fin.
    */
   public void setStartDate(Date date) throws InconsistencyDate {
      dbRecurrence.setStart(date);
      setChangedAndNotifyObservers();
   }

   /**
    * Définit la valeur de l'intervalle de récurrence.
    * 
    * @param i
    *           - la valeur de l'intervalle.
    */
   public void setIntervalRecurrence(int i) {
      dbRecurrence.setIntervalRecurrence(i);
      setChangedAndNotifyObservers();
   }

   /**
    * Retourne la valeur de l'intervalle de récurrence.
    * 
    * @return La valeur de l'intervalle de récurrence.
    */
   public int getIntervalRecurrence() {
      return dbRecurrence.getintervalRecurrence();
   }

   /**
    * Retourne la date de fin de la récurrence
    * 
    * @return La date de fin de la récurrence.
    */
   public Date getEndDate() {
      return dbRecurrence.getEnd();
   }

   /**
    * Définit la date de fin de la recurrence.
    * 
    * @param date
    *           - la date de fin.
    * @throws InconsistencyDate
    *            si la date de fin est antérieure à la date de début.
    */
   public void setEndtDate(Date date) throws InconsistencyDate {
      dbRecurrence.setEnd(date);
      setChangedAndNotifyObservers();
   }

   /**
    * Retourne l'identifiant de la récurrence dans la base de données.
    * 
    * @return L'identifiant de la récurrence.
    */
   public int getId() {
      return dbRecurrence.getId();
   }
}
