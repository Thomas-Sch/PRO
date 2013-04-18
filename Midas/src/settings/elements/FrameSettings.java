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
import utils.XMLGetters;

import org.jdom2.Element;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class FrameSettings {
   
   private String name;
   
   public int width, height;
   
   public int positionX, positionY;
   
   public ScreenPosition anchor;
   
   public FrameSettings(String name) {
      this.name = name;
   }
   
   public String getName(){
      return name;
   }
   
   public void setFromXML(Element element) {
      width = XMLGetters.getIntegerChild(element, "width", 100);
      height = XMLGetters.getIntegerChild(element, "height", 100);
      
      positionX = XMLGetters.getIntegerChild(element, "posX", 0);
      positionX = XMLGetters.getIntegerChild(element, "posY", 0);
      
      try {
         anchor = ScreenPosition.valueOf(XMLGetters.getStringChild(element,
                  "pos", ScreenPosition.TOP_LEFT.toString()).toUpperCase());
      }
      catch(Exception ex){
         anchor = ScreenPosition.TOP_LEFT;
      }
   }
   
}
