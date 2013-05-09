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

import java.awt.event.ActionListener;

import javax.swing.JButton;

import settings.Language.Text;

/**
 * Groupe de contrôle avec un bouton pour réinitialiser les champs.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JValidateCancelReset extends JValidateCancel {

   /**
    * ID de série.
    */
   private static final long serialVersionUID = -3259391489037518871L;
   
   private JButton btnReset= new JButton(Text.RESET_BUTTON.toString());
   
   /**
    * Constructeur de l'objet graphique.
    */
   public JValidateCancelReset() {
      add(btnReset);
   }
   
   public void addResetListener(ActionListener listener) {
      btnReset.addActionListener(listener);
   }
}
