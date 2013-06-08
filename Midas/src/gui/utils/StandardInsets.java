/* ============================================================================
 * Nom du fichier   : StandardInsets.java
 * ============================================================================
 * Date de création : 9 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.utils;

import java.awt.Insets;

/**
 * Définit la taille standard des bordures.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class StandardInsets extends Insets {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -4316725909012937650L;

   private static final int size = 5;

   /**
    * Crée une taille standard de bordures avec les paramètres par défaut.
    */
   public StandardInsets() {
      super(size, size, size, size);
   }

   /**
    * Crée une taille de bordures uniformes selon la valeur donnée.
    * 
    * @param size
    *           - la taille uniforme des bordures.
    */
   public StandardInsets(int size) {
      super(size, size, size, size);
   }
}
