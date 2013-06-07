/* ============================================================================
 * Nom du fichier   : BadTimeSlice.java
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

import gui.exception.BadTimeSliceException;

import javax.swing.JOptionPane;

import settings.Language.Text;
import core.MidasLogs;

/**
 * Classe qui affiche un message d'alerte si l'utilisateur ne choisi pas
 * d'intervalle de temps.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class BadTimeSlice {
   private final String message = Text.BAD_TIME_SLICE_MESSAGE.toString();

   /**
    * Affiche le message d'information à l'utilisateur.
    * @param e L'exception qui a déclenché l'alerte.
    */
   public BadTimeSlice (BadTimeSliceException e) {
      MidasLogs.errors.push(e.getMessage());
      JOptionPane.showMessageDialog(null, message, Text.APP_TITLE.toString(), JOptionPane.ERROR_MESSAGE);
   }
}