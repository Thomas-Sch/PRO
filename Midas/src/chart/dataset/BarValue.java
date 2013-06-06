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
 * Représente une entrée d'un diagramme en barres.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class BarValue extends DatasetValue {

   private String column;

   /**
    * Crée une association valeur / nom pour une entrée d'un diagramme en
    * barres.
    * 
    * @param value
    *           - la valeur de la barre.
    * @param column
    *           - le nom de la barre.
    */
   public BarValue(Double value, String column) {
      super(value);
      this.column = column;
   }

   /**
    * Retourne le nom de la barre.
    * 
    * @return Le nom de la barre.
    */
   public String getColumn() {
      return column;
   }

}
