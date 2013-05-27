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
    * @return le/la/les value
    */
   public Double getValue() {
      return value;
   }

   /**
    * @param value - la nouvelle valeur pour l'attribut value
    */
   public void setValue(Double value) {
      this.value = value;
   }

}
