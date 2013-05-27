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
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class PieValue extends DatasetValue{

   private String category;
   
   public PieValue(Double value, String category) {
      super(value);
      this.category = category;
   }

   /**
    * @return le/la/les category
    */
   public String getCategory() {
      return category;
   }

   /**
    * @param category - la nouvelle valeur pour l'attribut category
    */
   public void setCategory(String category) {
      this.category = category;
   }
   

}
