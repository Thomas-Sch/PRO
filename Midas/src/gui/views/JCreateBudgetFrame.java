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
import gui.component.JDateInput;
import gui.component.JLabelMoneyPanel;
import gui.component.JLabelTextPanel;
import gui.component.JRecursionChooser;
import gui.component.JValidateCancelReset;
import gui.controller.combobox.ComboBoxAccount;
import gui.utils.StandardInsets;
import gui.utils.TextChangedListener;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;

import settings.Language.Text;
import core.components.Budget;
import core.components.Recurrence;

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
   
   private JDateInput ditDate;
   private JRecursionChooser rcrRecurrence;
   
   private JLabelTextPanel ltpDescription;
   
   private Controller controller;
   
   private Budget budget;
   private Recurrence recurrence; // Récurrence associée au budget.
   
   public JCreateBudgetFrame(Controller controller, Budget budget, Recurrence recurrence) {
      this.controller = controller;
      this.budget = budget;
      this.recurrence = recurrence;
      
      initContent();
      initListeners();
      setContentPane(buildContent());
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
            budget.setBindedAccount(accounts.getSelectedAccount());
         }
      });
      
      rcrRecurrence.addEnabledChangedListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent arg0) {
            
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
      pnlContent.add(ditDate, constraints);

      constraints.gridy = 4;
      pnlContent.add(rcrRecurrence, constraints);
      
      constraints.gridy = 5;
      pnlContent.add(ltpDescription, constraints);
      
      constraints.gridy = 6;
      constraints.fill = GridBagConstraints.NONE;
      constraints.anchor = GridBagConstraints.EAST;
      pnlContent.add(vcrActions, constraints);
      return pnlContent;
   }
   
   private void initContent() {
      ltpName = new JLabelTextPanel(Text.BUDGET_NAME_LABEL);
      lmpAmount = new JLabelMoneyPanel(Text.AMOUNT_LABEL);
      accounts = new ComboBoxAccount(controller.getCore());
      
      ditDate = new JDateInput(Text.DATE_LABEL.toString());
      
      rcrRecurrence = new JRecursionChooser();
      
      ltpDescription = new JLabelTextPanel(Text.BUDGET_DESCRIPTION_LABEL);      
      
      vcrActions = new JValidateCancelReset();
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {

   }
   
   public void addValidateListener(ActionListener listener) {
      vcrActions.addValidateListener(listener);
   }
   
   public void addCancelListener(ActionListener actionListener) {
      vcrActions.addCancelListener(actionListener);
   }
}
