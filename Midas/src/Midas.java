import gui.controller.GlobalGUIController;
import settings.Settings;
import core.Core;
import core.MidasLogs;

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
 * Classe de lancement pour l'application.
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
      
      
      // Lancement de la partie logique du logiciel.
      Core core = new Core();
      
      // Lancement de la partie graphique du logiciel.
      new GlobalGUIController(core, LOG_FRAME_ON);
      
      MidasLogs.messages.push("Launcher", "Initialization done.");
      
      // Auto création du template de langue et du fichier update
      Settings.createTemplateForLanguage("fr");
      Settings.createUpdateForLanguage("fr");
   }

}
