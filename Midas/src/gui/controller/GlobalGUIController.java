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

import java.awt.Component;

import gui.component.JComboBoxUsers;
import gui.utils.Positions;
import gui.utils.Positions.ScreenPosition;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import core.Core;
import core.MidasLogs;
import core.log.LogsFrame;

/**
 * Contrôleur de l'interface graphique. Cette
 * classe sert aussi de passerelle entre interface graphique et la partie logique
 * de l'application.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class GlobalGUIController extends Controller {
   /**
    * @param core
    */
   public GlobalGUIController(Core core) {
      this(core, false);
   }
   
   /**
    * 
    * @param core le centre de l'application
    * @param logFrame si la fenêtre de logs est présente ou pas.
    */
   public GlobalGUIController(Core core, boolean logFrame) {
      super(core);
      
      // Définition du look and feel.
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
      
      if(logFrame) {
         if (logFrame) {
            LogsFrame logsFrame = new LogsFrame("Midas - logs", 700, 0, 600, 400);
            Positions.setPositionOnScreen(logsFrame, ScreenPosition.TOP_RIGHT);
            
            MidasLogs.addLogsToFrame(logsFrame);
         }
      }
      
      MainFrame mainFrameC = new MainFrame(getCore());
   }

   @Override
   protected void initComponents() {
      
   }
   
   @Override
   protected void initListeners() {
      
   }
   
   @Override
   public Component getGraphicalComponent() {
      return null;
   }
}
