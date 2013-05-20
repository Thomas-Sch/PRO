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

import gui.Controller;
import gui.component.JLabelMoneyPanel;
import gui.component.JLabelTextPanel;
import gui.utils.TextChangedListener;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;

import core.components.Account;

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
   
   private Account current;
   
// Champs de la vue.
   private JLabelTextPanel ltpName;
   private JLabelMoneyPanel lmpThreshold;
   private JLabelMoneyPanel lmpBalance;
   private JLabelTextPanel ltpNumber;
   private JLabelTextPanel ltpDescription;
   
   public JEditionAccount() {
      initContent();
      initListeners();
      buildContent();
   }
   
   public void initContent() {
      ltpName = new JLabelTextPanel(Text.ACCOUNT_NAME_LABEL);
      lmpThreshold = new JLabelMoneyPanel(Text.ACCOUNT_THRESHOLD_LABEL);
      lmpBalance = new JLabelMoneyPanel(Text.AMOUNT_LABEL);
      ltpNumber = new JLabelTextPanel(Text.ACCOUNT_NUMBER_LABEL);
      ltpDescription = new JLabelTextPanel(Text.ACCOUNT_DESCRIPTION_LABEL);
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
      add(ltpName, constraints);
      
      constraints.gridy = 1;
      add(lmpBalance, constraints);
      
      constraints.gridy = 2;
      add(lmpThreshold, constraints);
      
      constraints.gridy = 3;
      add(ltpNumber, constraints);
      
      constraints.gridy = 4;
      add(ltpDescription, constraints);
   }
   
   public void initListeners() {
      ltpNumber.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            current.setAccountNumber(ltpNumber.getText());
         }
      });
   }
   
   public void updateFields(Account account) {
      current = account;
      ltpName.setText(account.getAccountName());
      ltpNumber.setText(account.getAccountNumber());
      lmpBalance.setText(String.valueOf(account.getAccountBalance()));
      lmpThreshold.setText(String.valueOf(account.getOverdraftLimit()));
   }
   
   public void saveModifications(Controller controller) {
      controller.getCore().saveAccount(current);
   }
}
