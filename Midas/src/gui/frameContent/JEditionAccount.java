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

import gui.component.JLabelInfo;
import gui.component.JLabelMoneyInfo;

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
   private JLabelInfo lbiName;
   private JLabelMoneyInfo lmiThreshold;
   private JLabelInfo lbiNumber;
   private JLabelInfo lbiDescription;
   
   public JEditionAccount() {
      
      setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints();
      
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.weightx = 0.5;
      constraints.weighty = 0.5;
      constraints.insets = new Insets(5, 5, 5, 5);

      lbiName = new JLabelInfo(Text.ACCOUNT_NAME_LABEL.toString());
      add(lbiName, constraints);
      
      constraints.gridy = 1;
      lmiThreshold = new JLabelMoneyInfo(Text.ACCOUNT_THRESHOLD_LABEL.toString());
      add(lmiThreshold, constraints);
      
      constraints.gridy = 2;
      lbiNumber = new JLabelInfo(Text.ACCOUNT_NUMBER_LABEL.toString());
      add(lbiNumber, constraints);
      
      constraints.gridy = 3;
      lbiDescription = new JLabelInfo(Text.ACCOUNT_DESCRIPTION_LABEL.toString());
      add(lbiDescription, constraints);
   }

}
