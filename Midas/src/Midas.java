import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import settings.Language;
import settings.Language.Text;
import settings.Settings;
import gui.MainFrame;
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
      
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }
      catch (ClassNotFoundException ex) {
         MidasLogs.errors.push("Launcher", "Choosen LookAndFeel does not exists.");
      }
      catch (InstantiationException ex) {
         MidasLogs.errors.push("Launcher", "Unable to create the choosen LookAndFeel.");
      }
      catch (IllegalAccessException ex) {
         MidasLogs.errors.push("Launcher", "LookAndFeel class or initializer is not accessible.");
      }
      catch (UnsupportedLookAndFeelException ex) {
         MidasLogs.errors.push("Launcher", "Choosen LookAndFeel is not supported.");
      }
      catch (ClassCastException ex) {
         MidasLogs.errors.push("Launcher", "Choosen LookAndFeel is not a real LookAndFeel."); 
      }
      
      
      /*
       * Création de la fenêtre de logs
       */
      if (LOG_FRAME_ON) {
         LogsFrame logsFrame = new LogsFrame("Midas - logs", 700, 0, 600, 400);
         Positions.setPositionOnScreen(logsFrame, ScreenPosition.TOP_RIGHT);
         
         MidasLogs.addLogsToFrame(logsFrame);
      }
      
      /*
       * Démarrage de l'application
       */
      
      Core core = new Core();
      
      MainFrame mainFrame = new MainFrame(Text.APP_TITLE.toString(),
                                                Settings.mainFrame.positionX,
                                                Settings.mainFrame.positionY,
                                                Settings.mainFrame.width,
                                                Settings.mainFrame.height);
      
      Positions.setPositionOnScreen(mainFrame, Settings.mainFrame.anchor);
      
      MidasLogs.messages.push("Launcher", "Initialization done.");
      
      // Auto création du template de langue
      Settings.createTemplateForLanguage("fr");  
   }

}
