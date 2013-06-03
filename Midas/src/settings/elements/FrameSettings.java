/* ============================================================================
 * Nom du fichier   : FrameSettings.java
 * ============================================================================
 * Date de création : 17 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package settings.elements;

import gui.utils.Positions.ScreenPosition;

/**
 * Conteneur pour les paramètres
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 */
public class FrameSettings {

   private String name;

   public int width, height;

   public int positionX, positionY;

   public ScreenPosition anchor;

   /**
    * Créer un conteneur de paramètres d'une fenêtre avec le nom donné.
    * 
    * @param name
    *           - le nom de la fenêtre.
    */
   public FrameSettings(String name) {
      if (name == null || name.isEmpty()) {
         this.name = "unknown";
      }
      else {
         this.name = name;
      }
   }

   /**
    * Retourne le nom de la fenêtre.
    * 
    * @return Le nom de la fenêtre.
    */
   public String getName() {
      return name;
   }

}
