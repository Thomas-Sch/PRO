/* ============================================================================
 * Nom du fichier   : ValidateCancelReset.java
 * ============================================================================
 * Date de création : 21 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component;

import javax.swing.JButton;

import settings.Language.Text;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class ValidateCancelReset extends ValidateCancel {

   /**
    * ID de série.
    */
   private static final long serialVersionUID = -3259391489037518871L;
   
   private JButton btnReset= new JButton(Text.RESET_BUTTON.toString());
   
   public ValidateCancelReset() {
      add(btnReset);
   }

}
