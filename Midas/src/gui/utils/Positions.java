/* ============================================================================
 * Nom du fichier   : Positions.java
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
package gui.utils;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Fonctions utilitaires permettant de positionner une fenêtre par rapport à
 * l'écran.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class Positions {

   /**
    * Type énuméré des positions utilisables.
    * 
    * @author Biolzi Sébastien
    * @author Brito Carvalho Bruno
    * @author Decorvet Grégoire
    * @author Schweizer Thomas
    * @author Sinniger Marcel
    * 
    */
   public enum ScreenPosition {
      CENTER, TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
   };

   /**
    * Constructeur privé évitant une instanciation extérieure de l'objet.
    */
   private Positions() {
   }

   /**
    * Positionne la fenêtre donnée à la position spécifiée sur l'écran.
    * 
    * @param frame
    *           - la fenêtre à positionner.
    * @param position
    *           - la position voulue sur l'écran.
    */
   public static void setPositionOnScreen(JFrame frame, ScreenPosition position) {
      Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();

      Point location = computeRelativePosition(screenDimensions.width,
            screenDimensions.height, frame.getWidth(), frame.getHeight(),
            position);

      frame.setLocation(location.x, location.y);
   }

   /**
    * Positionne la fenêtre de dialogue donnée à la position spécifiée sur
    * l'écran.
    * 
    * @param dialog
    *           - la fenêtre de dialogue à positionner.
    * @param position
    *           - la position voulue sur l'écran.
    */
   public static void setPositionOnScreen(JDialog dialog,
         ScreenPosition position) {
      Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();

      Point location = computeRelativePosition(screenDimensions.width,
            screenDimensions.height, dialog.getWidth(), dialog.getHeight(),
            position);

      dialog.setLocation(location.x, location.y);
   }

   /**
    * Détermine et retourne la position relative que doit avoir la fenêtre pour
    * être à la position de l'écran donnée.
    * 
    * @param containerWidth
    *           - la largeur de l'écran.
    * @param containerHeight
    *           - la hauteur de l'écran.
    * @param frameWidth
    *           - la largeur de la fenêtre.
    * @param frameHeight
    *           - la hauteur de la fenêtre.
    * @param position
    *           - la position voulue pour la fenêtre sur l'écran.
    * @return La position en x et y que doit prendre la fenêtre.
    */
   public static Point computeRelativePosition(int containerWidth,
         int containerHeight, int frameWidth, int frameHeight,
         ScreenPosition position) {

      Point result = new Point(0, 0);

      switch (position) {
         case CENTER:
            result.x = (containerWidth - frameWidth) / 2;
            result.y = (containerHeight - frameHeight) / 2;
            break;

         case BOTTOM_LEFT:
            result.x = 0;
            result.y = containerHeight - frameHeight;
            break;

         case BOTTOM_RIGHT:
            result.x = containerWidth - frameWidth;
            result.y = containerHeight - frameHeight;
            break;

         case TOP_RIGHT:
            result.x = containerWidth - frameWidth;
            result.y = 0;
            break;

         case TOP_LEFT:
         default:
            result.x = 0;
            result.y = 0;
      }

      return result;
   }
}
