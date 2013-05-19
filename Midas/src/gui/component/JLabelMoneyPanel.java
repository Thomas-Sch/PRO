/* ============================================================================
 * Nom du fichier   : JLabelMoneyPanel.java
 * ============================================================================
 * Date de création : 7 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component;

import javax.swing.JTextField;

import settings.Language.Text;

/**
 * Classe permettant de saisir un montant d'argent.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JLabelMoneyPanel extends JLabelTextPanel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -3777685551501181998L;

   /**
    * @param textForLabel
    * @param textFieldColumns
    */
   public JLabelMoneyPanel(Text textForLabel, int textFieldColumns) {
      super(textForLabel, textFieldColumns);
      textField.setHorizontalAlignment(JTextField.RIGHT);
   }
   
   public JLabelMoneyPanel(Text textForLabel) {
      super(textForLabel);
      textField.setHorizontalAlignment(JTextField.RIGHT);
   }

}
