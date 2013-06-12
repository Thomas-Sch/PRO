/* ============================================================================
 * Nom du fichier   : MidasLog.java
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
package core;

import java.io.File;

import settings.Settings;
import core.log.Log;
import core.log.LogsFrame;

/**
 * Contient les différents log du programme.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class MidasLogs {

   public static Log messages = new Log("messages");
   public static Log errors = new Log("sqlErrors");
   public static Log sqlErrors = new Log("sqlErrors");
   
   /**
    * Initialise les fichiers de sorties
    */
   public static void setupFiles() {
      messages.setOutputFile(new File("Midas.log"));
      messages.setBufferSize(1);
      
      errors.setOutputFile(new File("Errors.log"));
      errors.setBufferSize(1);
      
      sqlErrors.setOutputFile(new File("SqlErrors.log"));
      sqlErrors.setBufferSize(1);
   }

   /**
    * Ajoute les logs à la fenêtre de logs donnée.
    * 
    * @param frame
    *           - la fenêtre de logs à laquelle ajouter les logs du programme.
    */
   public static void addLogsToFrame(LogsFrame frame) {
      frame.addLogPanel(messages.createLogPanel());
      frame.addLogPanel(errors.createLogPanel());
      frame.addLogPanel(sqlErrors.createLogPanel());
   }

}
