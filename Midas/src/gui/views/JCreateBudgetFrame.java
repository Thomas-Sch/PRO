/* ============================================================================
 * Nom du fichier   : JCreateBudgetFrame.java
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
package gui.views;

import gui.Controller;
import gui.View;
import gui.component.JLabelMoneyPanel;
import gui.component.JLabelTextPanel;
import gui.component.JValidateCancelReset;
import gui.controller.combobox.ComboBoxAccount;
import gui.utils.StandardInsets;
import gui.utils.TextChangedListener;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.DocumentEvent;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import core.components.Budget;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JCreateBudgetFrame extends JDialog implements View{

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -2619002208500615656L;
   
   private JLabelTextPanel ltpName;
   private JLabelMoneyPanel lmpAmount;
   private JValidateCancelReset vcrActions;
   private ComboBoxAccount accounts;
   
   private JRadioButton rbtMonth;
   private JRadioButton rbtYear;
   private ButtonGroup group;
   
   private JMonthChooser mcrMonth;
   private JYearChooser ycrYear;
   
   private JCheckBox cbxRecurrence;
   
   private JLabelTextPanel ltpDescription;
   
   private Controller controller;
   
   private Budget budget;
   
   public JCreateBudgetFrame(Component parent, Controller controller, Budget budget) {
      this.controller = controller;
      this.budget = budget;
      initContent();
      initListeners();
      setContentPane(buildContent());
      setLocationRelativeTo(parent);
      setResizable(false);
      pack();
      update(null, null);
   }
   
   /**
    * 
    */
   private void initListeners() {
      ltpName.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            budget.setName(ltpName.getText());
         }
      });
      
      ltpDescription.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            budget.setDescription(ltpDescription.getText()); 
         }
      });
      
      lmpAmount.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            budget.setLimit(Double.valueOf(lmpAmount.getText()));
         }
      });
      
      accounts.addSelectedChangedListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            budget.setBindAccount(accounts.getSelectedAccount());
         }
      });
      
   }

   private JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      pnlContent.setLayout(new GridBagLayout());
      
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.anchor = GridBagConstraints.WEST;
      
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.weightx = 0.5;
      constraints.weighty = 0.5;
      constraints.insets = new StandardInsets();
      pnlContent.add(ltpName, constraints);
      
      constraints.gridy = 1;
      pnlContent.add(lmpAmount, constraints);
      
      constraints.gridy = 2;
      pnlContent.add(accounts.getGraphicalComponent(), constraints);

      constraints.gridy = 3;
      constraints.weighty = 0.2;
      pnlContent.add(rbtMonth, constraints);
      
      constraints.gridy = 4;
      pnlContent.add(rbtYear, constraints);
      
      constraints.weighty = 0.5;
      constraints.gridy = 5;
      pnlContent.add(mcrMonth, constraints);
      
      constraints.gridy = 6;
      constraints.fill = GridBagConstraints.NONE;
      pnlContent.add(ycrYear, constraints);
      
      constraints.gridy = 7;
      constraints.fill = GridBagConstraints.HORIZONTAL;
      pnlContent.add(cbxRecurrence, constraints);
      
      constraints.gridy = 8;
      pnlContent.add(ltpDescription, constraints);
      
      constraints.gridy = 9;
      constraints.fill = GridBagConstraints.NONE;
      constraints.anchor = GridBagConstraints.EAST;
      pnlContent.add(vcrActions, constraints);
      return pnlContent;
   }
   
   private void initContent() {
      ltpName = new JLabelTextPanel("Nom du budget");
      lmpAmount = new JLabelMoneyPanel("Somme");
      accounts = new ComboBoxAccount(controller.getCore());
      
      rbtMonth = new JRadioButton("Mensuel");
      rbtYear = new JRadioButton("Annuel");
      group = new ButtonGroup();
      
      group.add(rbtMonth);
      group.add(rbtYear);
      
      mcrMonth = new JMonthChooser();
      ycrYear = new JYearChooser();
      
      cbxRecurrence = new JCheckBox("Récurrence");
      
      ltpDescription = new JLabelTextPanel("Description");      
      
      vcrActions = new JValidateCancelReset();
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      // TODO Auto-generated method stub
      
   }
   
   public void addValidateListener(ActionListener listener) {
      vcrActions.addValidateListener(listener);
   }
   
   public void addCancelListener(ActionListener actionListener) {
      vcrActions.addCancelListener(actionListener);
   }
}
