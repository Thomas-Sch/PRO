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
import gui.controller.GlobalGUIController;
import settings.Settings;
import core.Core;
import core.MidasLogs;

/**
 * Classe servant à démarrer l'application.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * @version 1.0
 * 
 */
public class Midas {

   private final static boolean LOG_FRAME_ON = true;
   private final static boolean DEVELOPPEMENT_MODE_ON = true;

   /**
    * Méthode principale utilisée automatiquement au lancement.
    * 
    * @param args
    */
   public static void main(String[] args) {

      // Lancement de la partie logique du logiciel.
      Core core = new Core();

      // Lancement de la partie graphique du logiciel.
      new GlobalGUIController(core, LOG_FRAME_ON);

      MidasLogs.messages.push("Launcher", "Initialization done.");

      // Auto création du template de langue et du fichier update
      if (DEVELOPPEMENT_MODE_ON) {
         Settings.createTemplateForLanguage("fr");
         Settings.createUpdateForLanguage("fr");
      }

   }

}
