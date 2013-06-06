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
import core.exceptions.AmountUnavailable;

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
   
   private final String message = "Le compte ne dispose pas d'assez de provisions pour effectuer la dépense !";
   
   public AccountBankruptcy (AmountUnavailable e) {
      MidasLogs.errors.push(e.getMessage());
      JOptionPane.showMessageDialog(null, message, Text.APP_TITLE.toString(), JOptionPane.OK_OPTION);
   }

}
