/* ============================================================================
 * Nom du fichier   : JInfoAccount.java
 * ============================================================================
 * Date de création : 8 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.views;

import gui.component.JLabelInfo;
import gui.component.JLabelMoneyInfo;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import core.components.Account;

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
public class JInfoAccount extends JPanel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 6175335102596615881L;
   
   // Champs de la vue.
   private JLabelInfo lbiName;
   private JLabelMoneyInfo lmiThreshold;
   private JLabelMoneyInfo lmiInitialAmount;
   private JLabelInfo lbiNumber;
   private JLabelInfo lbiDescription;
   
   public JInfoAccount () {
      initContent();
      buildContent();
   }
   
   public void buildContent() {
      setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints();
      
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.weightx = 0.5;
      constraints.weighty = 0.5;
      constraints.insets = new Insets(5, 5, 5, 5);
      add(lbiName, constraints);
      
      constraints.gridy = 1;
      add(lmiThreshold, constraints);
      
      constraints.gridy = 2;
      add(lmiInitialAmount, constraints);
      
      constraints.gridy = 3;
      add(lbiNumber, constraints);
      
      constraints.gridy = 4;
      add(lbiDescription, constraints);
   }
   
   public void initContent() {
      lbiName = new JLabelInfo(Text.ACCOUNT_NAME_LABEL.toString());
      lmiThreshold = new JLabelMoneyInfo(Text.ACCOUNT_THRESHOLD_LABEL.toString());
      lmiInitialAmount = new JLabelMoneyInfo(Text.ACCOUNT_INITIAL_AMOUNT_LABEL.toString());
      lbiNumber = new JLabelInfo(Text.ACCOUNT_NUMBER_LABEL.toString());
      lbiDescription = new JLabelInfo(Text.ACCOUNT_DESCRIPTION_LABEL.toString());
   }
   
   public void updateFields(Account account) {
      lbiName.setText(account.getAccountName());
      lbiNumber.setText(account.getAccountNumber());
      lmiInitialAmount.setText(String.valueOf(account.getAccountBalance()));
      lmiThreshold.setText(String.valueOf(account.getOverdraftLimit()));
   }
}
