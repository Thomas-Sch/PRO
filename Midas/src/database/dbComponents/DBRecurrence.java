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

/**
 * Représente une récurrence pour la base de données, et met à disposition les
 * fonctions de manipulations de base.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class DBRecurrence extends DBComponent {

   private Date start;
   private Date end;
   private Integer intervalRecurrence;

   /**
    * Crée une récurrence, et initialise les champs qui ne représentent pas
    * une référence sur un autre élément.
    */
   public DBRecurrence() {
      start = null;
      end = null;
      intervalRecurrence = 0;
   }

   /**
    * Retourne la date de début de la récurrence.
    * 
    * @return La date de début.
    */
   public Date getStart() {
      return start;
   }

   /**
    * Définit la date de début de la récurrence.
    * 
    * @param start
    *           - la nouvelle date de début.
    */
   public void setStart(Date start) {
      this.start = start;
   }

   /**
    * Retourne la date de fin de la récurrence.
    * 
    * @return La date de fin.
    */
   public Date getEnd() {
      return end;
   }

   /**
    * Définit la date de fin de la récurrence.
    * 
    * @param end
    *           - la nouvelle date de fin.
    */
   public void setEnd(Date end) {
      this.end = end;
   }

   /**
    * Retourne l'intervalle de récurrence.
    * 
    * @return L'intervalle de recurrence.
    */
   public Integer getintervalRecurrence() {
      return intervalRecurrence;
   }

   /**
    * Définit l'intervalle de récurrence.
    * 
    * @param intervalRecurrence
    *           - le nouvel intervalle.
    */
   public void setIntervalRecurrence(Integer intervalRecurrence) {
      this.intervalRecurrence = intervalRecurrence;
   }

   @Override
   public String toString() {
      return "DBRecurrence [start=" + start + ", end=" + end
            + ", intervalRecurrence=" + intervalRecurrence + ", getId()="
            + getId() + "]";
   }

}
