/* ============================================================================
 * Nom du fichier   : AmountInput.java
 * ============================================================================
 * Date de création : 16 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import settings.Language.Text;

/**
 * Zone de saisie d'un montant d'argent.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AmountInput extends JPanel {
   private static final long serialVersionUID = 1L;
   
   /**
    * 
    */
   public AmountInput() {
      setLayout(new BorderLayout(5,5));
      
      add(new JLabel(Text.AMOUNT_LABEL.toString()), BorderLayout.WEST);
      
      JTextField txtAmountInput = new JTextField("...");
      
      add(txtAmountInput, BorderLayout.CENTER);
   }

}
