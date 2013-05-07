/* ============================================================================
 * Nom du fichier   : NewAccountFrame.java
 * ============================================================================
 * Date de création : 18 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui;

import gui.component.JLabelMoneyPanel;
import gui.component.JLabelTextPanel;
import gui.component.JValidateCancelReset;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;

import settings.Language.Text;
/**
 * Fenêtre d'ajout de compte.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JNewAccountFrame extends JDialog {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -2273955948172856823L;
   
   private JLabelTextPanel ltpName;
   private JLabelMoneyPanel ltpThreshold;
   private JLabelMoneyPanel ltpInitialAmount;
   private JLabelTextPanel ltpNumber;
   private JLabelTextPanel ltpDescription;
   
   // Contrôle la longueur des boîtes de texte.
   private final int textboxLength = 20;
   
   /**
    * Construit une nouvelle fenêtre pour ajouter un compte.
    */
   public JNewAccountFrame(Component parent) {
      setTitle(Text.APP_TITLE.toString());
      setLocationRelativeTo(parent);
      
      getContentPane().setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints();
      
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.weightx = 0.5;
      constraints.weighty = 0.5;
      constraints.insets = new Insets(5, 5, 5, 5);

      ltpName = new JLabelTextPanel(Text.ACCOUNT_NAME_LABEL.toString(), textboxLength);
      add(ltpName, constraints);
      
      constraints.gridy = 1;
      ltpThreshold = new JLabelMoneyPanel(Text.ACCOUNT_THRESHOLD_LABEL.toString(), textboxLength);
      add(ltpThreshold, constraints);
      
      constraints.gridy = 2;
      ltpInitialAmount = new JLabelMoneyPanel(Text.ACCOUNT_INITIAL_AMOUNT_LABEL.toString(), textboxLength);
      add(ltpInitialAmount, constraints);
      
      constraints.gridy = 3;
      ltpNumber = new JLabelTextPanel(Text.ACCOUNT_NUMBER_LABEL.toString(), textboxLength);
      add(ltpNumber, constraints);
      
      constraints.gridy = 4;
      ltpDescription = new JLabelTextPanel(Text.ACCOUNT_DESCRIPTION_LABEL.toString(), textboxLength);
      add(ltpDescription, constraints);
      
      constraints.gridy = 5;
      constraints.anchor = GridBagConstraints.EAST;
      constraints.fill = GridBagConstraints.NONE;
      add(new JValidateCancelReset(), constraints);
      pack();
   }

   /**
    * @param i
    */
   public void setDefaultThreshold(int i) {
      ltpThreshold.setText("0");
   }

}
