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

   public static Log messages = new Log("messages", new File("Midas.log"), 1);

   public static Log errors = new Log("errors", new File("Errors.log"), 1);

   public static Log sqlErrors = new Log("sqlErrors",
         new File("sqlErrors.log"), 1);

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
