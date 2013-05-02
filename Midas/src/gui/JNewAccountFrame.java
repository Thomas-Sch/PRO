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

import gui.component.JAccountDescriptionTextInput;
import gui.component.JAccountNameTextInput;
import gui.component.JAccountNumberTextInput;
import gui.component.JThresholdTextInput;
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
    * Serial id
    */
   private static final long serialVersionUID = -2273955948172856823L;
   
   /**
    * Construit une nouvelle fenêtre pour ajouter un compte.
    */
   public JNewAccountFrame(Component parent) {
      setTitle(Text.APP_TITLE.toString());
      setLocationRelativeTo(parent);
      setVisible(true);

      getContentPane().setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints();
      
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.weightx = 0.5;
      constraints.weighty = 0.5;
      constraints.insets = new Insets(5, 5, 5, 5);

      JAccountNameTextInput t = new JAccountNameTextInput();
      add(t, constraints);
      
      constraints.gridy = 1;
      
      add(new JThresholdTextInput(), constraints);
      
      constraints.gridy = 2;
      add(new JAccountNumberTextInput(), constraints);
      
      constraints.gridy = 3;
      add(new JAccountDescriptionTextInput(), constraints);
      
      constraints.gridy = 4;
      constraints.anchor = GridBagConstraints.EAST;
      constraints.fill = GridBagConstraints.NONE;
      add(new JValidateCancelReset(), constraints);
    
      pack();
   }

}
