/* ============================================================================
 * Nom du fichier   : AccountBankruptcy.java
 * ============================================================================
 * Date de création : 6 juin 2013
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

import core.MidasLogs;
import core.exceptions.AmountUnavailableException;

import settings.Language.Text;

/**
 * Classe qui affiche un message d'alerte si le compte n'a plus d'argent.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AccountBankruptcy {
   
   private final String message = Text.ACCOUNT_BANKRUPTCY_MESSAGE.toString();
   
   /**
    * Affiche le message d'information à l'utilisateur.
    * @param e L'exception qui a déclenché l'alerte.
    */
   public AccountBankruptcy (AmountUnavailableException e) {
      MidasLogs.errors.push(e.getMessage());
      JOptionPane.showMessageDialog(null, message, Text.APP_TITLE.toString(), JOptionPane.ERROR_MESSAGE);
   }
}
