/* ============================================================================
 * Nom du fichier   : BadDate.java
 * ============================================================================
 * Date de création : 7 juin 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.alert;

import javax.swing.JOptionPane;

import settings.Language.Text;
import gui.exception.BadDateException;
import core.MidasLogs;

/**
 * Affiche un message à l'utilisateur s'il ne rentre pas une date correcte.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class BadDate {

   private final String message = Text.BAD_DATE_MESSAGE.toString();

   /**
    * Affiche le message d'information à l'utilisateur.
    * 
    * @param e
    *           - l'exception qui a déclenché l'alerte.
    */
   public BadDate(BadDateException e) {
      MidasLogs.errors.push(e.getMessage());
      JOptionPane.showMessageDialog(null, message, Text.APP_TITLE.toString(),
            JOptionPane.ERROR_MESSAGE);
   }
}
