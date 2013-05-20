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
 * Classe permettant de saisir une somme d'argent
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
    * Constructeur principal
    * @param textForLabel Somme d'argent.
    * @param textFieldColumns Taille du champ de saisie.
    */
   public JLabelMoneyPanel(Text textForLabel, int textFieldColumns) {
      super(textForLabel, textFieldColumns);
      txtData.setHorizontalAlignment(JTextField.RIGHT);
   }
   
   /**
    * Constructeur secondaire
    * @param textForLabel Somme d'argent.
    */
   public JLabelMoneyPanel(Text textForLabel) {
      this(textForLabel, defaultColumnsSize);
   }
}
