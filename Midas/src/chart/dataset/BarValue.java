/* ============================================================================
 * Nom du fichier   : BarValue.java
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
public class BarValue extends DatasetValue{

   private String column;
   //private String row;
   
   public BarValue(Double value, String column) {
      super(value);
      this.column = column;
   }

   /**
    * @return the column
    */
   public String getColumn() {
      return column;
   }

}
