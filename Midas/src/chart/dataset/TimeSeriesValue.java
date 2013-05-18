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
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class TimeSeriesValue extends DatasetValue {

   Date date;
   
   public TimeSeriesValue(Double value, Date date) {
      super(value);
      this.date = date;
   }

   /**
    * @return the date
    */
   public Date getDate() {
      return date;
   }

   
}
