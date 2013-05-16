/* ============================================================================
 * Nom du fichier   : datasetValue.java
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

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class DatasetValue {

   private Double value;
   
   public DatasetValue(Double value) {
      this.value = value;
   }

   /**
    * @return the value
    */
   public Double getValue() {
      return value;
   }

   /**
    * @param value the value to set
    */
   public void setValue(Double value) {
      this.value = value;
   }

}
