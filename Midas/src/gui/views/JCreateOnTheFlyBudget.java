/* ============================================================================
 * Nom du fichier   : JCreateOnTheFlyBudget.java
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
import gui.component.JDateInput;
import gui.component.JLabelMoneyPanel;
import gui.component.JLabelTextPanel;
import gui.component.JValidateCancel;
import gui.controller.combobox.ComboBoxAccount;
import gui.utils.StandardInsets;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JDialog;
import javax.swing.JPanel;

import settings.Language.Text;
import core.components.BudgetOnTheFly;

/**
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JCreateOnTheFlyBudget extends JDialog implements View{

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -4692092965659440366L;
   
   private JLabelTextPanel ltpName;
   private JLabelMoneyPanel ltpAmount;
   private JValidateCancel vclActions;
   private ComboBoxAccount accounts;

   private JDateInput ditStart;
   private JDateInput ditEnd;
   
   private JLabelTextPanel ltpDescription;
   
   private Controller controller;
   
   private BudgetOnTheFly budget;

   public JCreateOnTheFlyBudget(Component parent, Controller controller, BudgetOnTheFly budget) {
      this.controller = controller;
      this.budget = budget;
      
      setContentPane(buildContent());
      setLocationRelativeTo(parent);
      setResizable(false);
      pack();
      update(null, null);
   }
   
   private JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      pnlContent.setLayout(new GridBagLayout());
      
      initComponents();
      
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
      pnlContent.add(ltpAmount, constraints);
      
      constraints.gridy = 2;
      pnlContent.add(accounts.getGraphicalComponent(), constraints);
      
      constraints.gridy = 3;
      pnlContent.add(ditStart, constraints);
      
      constraints.gridy = 4;
      pnlContent.add(ditEnd, constraints);     
      
      constraints.gridy = 5;
      pnlContent.add(ltpDescription, constraints);
      
      constraints.gridy = 6;
      constraints.fill = GridBagConstraints.NONE;
      constraints.anchor = GridBagConstraints.EAST;
      pnlContent.add(vclActions, constraints);
      return pnlContent;
   }
   
   private void initComponents() {
      ltpName = new JLabelTextPanel(Text.BUDGET_NAME_LABEL);
      ltpAmount = new JLabelMoneyPanel(Text.AMOUNT_LABEL);
      accounts = new ComboBoxAccount(controller.getCore());
      
      ditStart = new JDateInput(Text.BEGIN_DATE_LABEL);
      ditEnd = new JDateInput(Text.END_DATE_LABEL);
      
      ltpDescription = new JLabelTextPanel(Text.BUDGET_DESCRIPTION_LABEL);      
      
      vclActions = new JValidateCancel();
   }
   
   public void addValidateListener(ActionListener listener) {
      vclActions.addValidateListener(listener);
   }
   
   public void addCancelListener(ActionListener actionListener) {
      vclActions.addCancelListener(actionListener);
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      // Pas d'update pour l'instant. Voir rapport.
   }
}
