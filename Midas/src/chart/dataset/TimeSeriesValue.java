/* ============================================================================
 * Nom du fichier   : TimeSeriesValue.java
 * ============================================================================
 * Date de création : 15.05.2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package chart.dataset;

import java.util.Date;

/**
 * Représente une entrée d'un diagramme temporel.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class TimeSeriesValue extends DatasetValue {

   private Date date;

   /**
    * Crée une entrée pour un digramme temporel.
    * 
    * @param value
    *           - la valeur associée à la date.
    * @param date
    *           - la date de l'entrée.
    */
   public TimeSeriesValue(Double value, Date date) {
      super(value);
      this.date = date;
   }

   /**
    * Retourne la date de l'entrée.
    * 
    * @return La date de l'entrée.
    */
   public Date getDate() {
      return date;
   }

}