/* ============================================================================
 * Nom du fichier   : JEditionAccount.java
 * ============================================================================
 * Date de création : 9 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.frameContent;

import gui.component.JLabelMoneyPanel;
import gui.component.JLabelTextPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import settings.Language.Text;

/**
 * Composant graphique d'édition d'un compte.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JEditionAccount extends JPanel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -1261960648709661937L;
   
// Champs de la vue.
   private JLabelTextPanel ltpName;
   private JLabelMoneyPanel lmpThreshold;
   private JLabelTextPanel ltpNumber;
   private JLabelTextPanel ltpDescription;
   
   public JEditionAccount() {
      
      setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints();
      
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.weightx = 0.5;
      constraints.weighty = 0.5;
      constraints.insets = new Insets(5, 5, 5, 5);

      ltpName = new JLabelTextPanel(Text.ACCOUNT_NAME_LABEL);
      add(ltpName, constraints);
      
      constraints.gridy = 1;
      lmpThreshold = new JLabelMoneyPanel(Text.ACCOUNT_THRESHOLD_LABEL);
      add(lmpThreshold, constraints);
      
      constraints.gridy = 2;
      ltpNumber = new JLabelTextPanel(Text.ACCOUNT_NUMBER_LABEL);
      add(ltpNumber, constraints);
      
      constraints.gridy = 3;
      ltpDescription = new JLabelTextPanel(Text.ACCOUNT_DESCRIPTION_LABEL);
      add(ltpDescription, constraints);
   }

}
