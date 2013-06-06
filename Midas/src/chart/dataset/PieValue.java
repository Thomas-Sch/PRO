/* ============================================================================
 * Nom du fichier   : PieValue.java
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
 * Représente une entrée d'un graphique de type "camembert".
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class PieValue extends DatasetValue {

   private String category;

   /**
    * Crée une entrée pour un graphique de type "camembert".
    * 
    * @param value
    *           - la valeur de l'entrée.
    * @param category
    *           - le nom de catégorie de l'entrée.
    */
   public PieValue(Double value, String category) {
      super(value);
      this.category = category;
   }

   /**
    * Retourne le nom de la catégorie de l'entrée.
    * 
    * @return le/la/les category
    */
   public String getCategory() {
      return category;
   }

   /**
    * Définit le nom de la catégorie de l'entrée.
    * 
    * @param category
    *           - le nouveau nom de catégorie.
    */
   public void setCategory(String category) {
      this.category = category;
   }

}
