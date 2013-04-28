/* ============================================================================
 * Nom du fichier   : GlobalGUIController.java
 * ============================================================================
 * Date de création : 25 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.controller;

import settings.Language.Text;
import gui.MainFrame;
import gui.utils.Positions;
import gui.utils.Positions.ScreenPosition;
import core.Core;

/**
 * Contrôleur de l'interface graphique. Cette
 * classe sert aussi de passerelle entre interface graphique et le corps de
 * l'application.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class GlobalGUIController extends Controller {
   
   private MainFrame mainFrame;

   /**
    * @param core
    */
   public GlobalGUIController(Core core, String string) {
      super(core);
      
      // Aspect des fenêtres.
      try {
         javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
      } catch(Exception e) {
         e.printStackTrace();
      }
      
      initGraphicalComponents(string);
   }
   
   /**
    * 
    * @param core le centre de l'application
    * @param logFrame
    */
   public GlobalGUIController(Core core, boolean logFrame) {
      super(core);
      
      // Aspect des fenêtres.
      try {
         javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
      } catch(Exception e) {
         e.printStackTrace();
      }
      
      initGraphicalComponents();
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initActionListeners()
    */
   @Override
   protected void initActionListeners() {
      // TODO Auto-generated method stub

   }

   private void initGraphicalComponents() {
      mainFrame = new MainFrame(Text.APP_TITLE.toString());
      Positions.setPositionOnScreen(mainFrame, ScreenPosition.CENTER);
   }
}
