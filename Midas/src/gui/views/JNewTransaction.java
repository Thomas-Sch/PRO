/* ============================================================================
 * Nom du fichier   : JNewTransaction.java
 * ============================================================================
 * Date de création : 10 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.views;

import gui.Controller;
import gui.View;
import gui.component.JComboBoxTransactionType;
import gui.component.JDateInput;
import gui.component.JLabelMoneyPanel;
import gui.component.JLabelTextPanel;
import gui.component.JValidateCancel;
import gui.controller.ComboBoxAccount;
import gui.controller.ComboBoxUser;
import gui.utils.StandardInsets;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

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
public class JNewTransaction extends JDialog implements View {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -3182363764437829156L;
   
   private Controller controller;
   
   //Composants
   private ComboBoxAccount accounts;
   private JComboBoxTransactionType cttType;
   private ComboBoxUser users;
   private JLabelTextPanel ltpReason;
   private JLabelMoneyPanel lmpAmount;
   private JDateInput ditDate;
   private JCheckBox cbxRecurrence;
   
   private ButtonGroup radioGroup;
   private JRadioButton rbtDaily;
   private JRadioButton rbtWeekly;
   private JRadioButton rbtMonthly;
   private JRadioButton rbtAnnual;
   
   private JValidateCancel vclActions;
   
   public JNewTransaction(Controller controller) {
      this.controller = controller;
      setContentPane(buildContent());
      pack();
   }
   
   public JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      pnlContent.setLayout(new GridBagLayout());
      
      initContent();
      
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.insets = new StandardInsets();
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.anchor = GridBagConstraints.WEST;
      constraints.weightx = 0.5;
      constraints.weighty = 0.5;
      
      constraints.gridx = 0;
      constraints.gridy = 0;
      pnlContent.add(accounts.getGraphicalComponent(), constraints);
      
      constraints.gridx = 1;
      pnlContent.add(cttType, constraints);
      
      constraints.gridx = 0;
      constraints.gridy = 1;
      pnlContent.add(users.getGraphicalComponent(), constraints);
      
      constraints.gridx = 1;
      pnlContent.add(ltpReason, constraints);
      
      constraints.gridx = 2;
      pnlContent.add(lmpAmount, constraints);
      
      constraints.gridx = 0;
      constraints.gridy = 2;
      pnlContent.add(ditDate, constraints);
      
      constraints.gridx = 0;
      constraints.gridy = 3;
      pnlContent.add(cbxRecurrence, constraints);
      
      constraints.gridy = 4;
      pnlContent.add(rbtDaily, constraints);
      
      constraints.gridy = 5;
      pnlContent.add(rbtWeekly, constraints);
      
      constraints.gridy = 6;
      pnlContent.add(rbtMonthly, constraints);
      
      constraints.gridy = 7;
      pnlContent.add(rbtAnnual, constraints);
      
      constraints.gridx = 2;
      constraints.gridy = 8;
      pnlContent.add(vclActions, constraints);
      
      return pnlContent;
   }
   
   public void initContent() {
      accounts = new ComboBoxAccount(controller.getCore());
      cttType = new JComboBoxTransactionType();
      users = new ComboBoxUser(controller.getCore());
      ltpReason = new JLabelTextPanel(Text.REASON_LABEL.toString());
      lmpAmount = new JLabelMoneyPanel(Text.AMOUNT_LABEL.toString());
      ditDate = new JDateInput(Text.DATE_LABEL.toString());
      cbxRecurrence = new JCheckBox(Text.RECURRENCE_LABEL.toString());
      
      radioGroup = new ButtonGroup();
      rbtDaily = new JRadioButton(Text.DAILY_LABEL.toString());
      rbtWeekly = new JRadioButton(Text.WEEKLY_LABEL.toString());
      rbtMonthly = new JRadioButton(Text.MONTHLY_LABEL.toString());
      rbtAnnual = new JRadioButton(Text.ANNUAL_LABEL.toString());
      radioGroup.add(rbtDaily);
      radioGroup.add(rbtWeekly);
      radioGroup.add(rbtMonthly);
      radioGroup.add(rbtAnnual);
      
      vclActions = new JValidateCancel();
   }
   
   public void addValidateListener(ActionListener listener) {
      vclActions.addValidateListener(listener);
   }
   
   public void addCancelListener(ActionListener listener) {
      vclActions.addCancelListener(listener);
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
   }

}
