/* ============================================================================
 * Nom du fichier   : ChartWithAxis.java
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
 * Représente un graphique ayant des noms pour les axes X et Y.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class ChartWithAxis extends Chart {

   private String x;
   private String y;

   /**
    * Crée un graphique avec des noms pour les axes X et Y.
    * 
    * @param title
    *           - le titre du graphique.
    */
   public ChartWithAxis(String title, String xAxis, String yAxis) {
      super(title);
      x = xAxis;
      y = yAxis;
   }

   /**
    * Retourne le nom de l'axe X.
    * 
    * @return Le nom de l'axe X.
    */
   protected String getX() {
      return x;
   }

   /**
    * Retourne le nom de l'axe Y.
    * 
    * @return Le nom de l'axe Y.
    */
   protected String getY() {
      return y;
   }

}
