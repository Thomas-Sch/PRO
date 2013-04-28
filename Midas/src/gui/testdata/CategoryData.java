/* ============================================================================
 * Nom du fichier   : CategoryData.java
 * ============================================================================
 * Date de création : 22 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.testdata;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class CategoryData extends Data<String> {
   
   /**
    * 
    */
   public CategoryData() {
      for(int i = 0; i < 10; i++) {
         addItem("Caaat" + (i + 1));
      }
   }
}
