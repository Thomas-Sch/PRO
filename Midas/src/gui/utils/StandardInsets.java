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
 * TODO
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

   public StandardInsets() {
      super(size, size, size, size);
   }

   public StandardInsets(int size) {
      super(size, size, size, size);
   }
}
