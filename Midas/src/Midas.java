import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import settings.Language;
import settings.Language.Text;
import settings.Settings;
import gui.MainFrame;
import gui.controller.GlobalGUIController;
import gui.utils.Positions;
import gui.utils.Positions.ScreenPosition;
import core.Core;
import core.MidasLogs;
import core.log.Log;
import core.log.LogsFrame;

/* ============================================================================
 * Nom du fichier   : Midas.java
 * ============================================================================
 * Date de création : 15 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class Midas {
   
   private final static boolean LOG_FRAME_ON = true;
   
   public static void main(String[] args) {    
      
      /*
       * Démarrage de l'application
       */
      
      Core core = new Core();
      
      GlobalGUIController guiController = new GlobalGUIController(core, LOG_FRAME_ON);
      
      MidasLogs.messages.push("Launcher", "Initialization done.");
      
      // Auto création du template de langue et du fichier update
      Settings.createTemplateForLanguage("fr");
      Settings.createUpdateForLanguage("fr");
   }

}
