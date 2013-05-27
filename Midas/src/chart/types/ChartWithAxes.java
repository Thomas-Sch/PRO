/* ============================================================================
 * Nom du fichier   : ChartWithAxes.java
 * ============================================================================
 * Date de création : 16.05.2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package chart.types;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class ChartWithAxes extends Chart {

   private String x;
   private String y;
   
   public ChartWithAxes(String title) {
      super(title);
   }
   
   /**
    * @return le/la/les x
    */
   protected String getX() {
      return x;
   }
   /**
    * @return le/la/les y
    */
   protected String getY() {
      return y;
   }

}
