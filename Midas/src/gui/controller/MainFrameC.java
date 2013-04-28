/* ============================================================================
 * Nom du fichier   : MainFrameC.java
 * ============================================================================
 * Date de création : 28 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.controller;

import gui.MainFrame;
import gui.utils.Positions;

import javax.swing.JFrame;

import settings.Language.Text;
import settings.Settings;
import core.Core;

/**
 * Contrôleur du contenu de la fenêtre principale.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class MainFrameC extends Controller {
   MainFrame mainFrame;
   /**
    * 
    */
   public MainFrameC(Core core) {
      super(core);
      
      mainFrame = new MainFrame(this, Text.APP_TITLE.toString());
      mainFrame.setSize(600, 400);
      Positions.setPositionOnScreen(mainFrame,  Settings.mainFrame.anchor);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      mainFrame.setVisible(true);
      
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initActionListeners()
    */
   @Override
   protected void initActionListeners() {
      // Nous n'écoutons rien sur cette fenêtre.
   }
}
