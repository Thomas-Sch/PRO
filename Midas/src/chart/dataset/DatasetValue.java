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
 * Représente une entrée d'un graphique et sa valeur.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class DatasetValue {

   private Double value;

   /**
    * Créer une entrée pour un graphique.
    * 
    * @param value
    *           - la valeur de l'entrée.
    */
   public DatasetValue(Double value) {
      this.value = value;
   }

   /**
    * Retourne la valeur de l'entrée.
    * 
    * @return La valeur de l'entrée.
    */
   public Double getValue() {
      return value;
   }

   /**
    * Définit la valeur de l'entrée.
    * 
    * @param value
    *           - la nouvelle valeur d'entrée.
    */
   public void setValue(Double value) {
      this.value = value;
   }

}
