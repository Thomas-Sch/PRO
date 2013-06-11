/* ============================================================================
 * Nom du fichier   : NegativeBudget.java
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

import core.components.Budget;

import settings.Language.Text;

/**
 * Affiche un message à l'utilisateur indiquant que son budget est dépassé.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class NegativeBudget {
   private String message = Text.NEGATIVE_BUDGET_MESSAGE.toString();

   /**
    * Affiche un message d'information concernant un budget.
    * 
    * @param budget
    *           - le budget concerné.
    */
   public NegativeBudget(Budget budget) {
      message += " [" + Text.BUDGET_LABEL.toString() + " : " + budget.getName()
            + "]";
      JOptionPane.showMessageDialog(null, message, Text.APP_TITLE.toString(),
            JOptionPane.INFORMATION_MESSAGE);
   }

}
