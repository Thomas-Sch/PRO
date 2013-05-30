/* ============================================================================
 * Nom du fichier   : JNewExpense.java
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
import gui.component.JTimeSliceChooser;
import gui.component.JValidateCancel;
import gui.controller.combobox.ComboBoxBudget;
import gui.controller.combobox.ComboBoxUser;
import gui.controller.combobox.ComboBoxesCategory;
import gui.utils.StandardInsets;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JPanel;

import settings.Language.Text;

/**
 * Fenêtre graphique pour ajouter une dépense.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JNewExpense extends javax.swing.JDialog implements View {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 9007162125947939904L;
   
   private Controller controller;
   
   //Composants
   private ComboBoxBudget budgets;
   private ComboBoxesCategory categories;
   private ComboBoxUser users;
   private JLabelTextPanel ltpReason;
   private JLabelMoneyPanel lmpAmount;
   private JDateInput ditDate;

   private JTimeSliceChooser rcrRecurrenceOptions;
   
   private JValidateCancel vclActions;
   
   
   public JNewExpense(Controller controller) {
      this.controller = controller;
      setContentPane(buildContent());
      pack();
   }
   
   private JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      pnlContent.setLayout(new GridBagLayout());
      
      initContent();
      
      GridBagConstraints constraints = new GridBagConstraints();
      
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.anchor = GridBagConstraints.WEST;
      constraints.insets = new StandardInsets();
      constraints.weightx = 0.5;
      constraints.weighty = 0.5;
      
      constraints.gridx = 0;
      constraints.gridy = 0;
      pnlContent.add(budgets.getGraphicalComponent(), constraints);
      
      constraints.gridy = 1;
      pnlContent.add(categories.getGraphicalComponent(), constraints);
      
      constraints.gridx = 0;
      constraints.gridy = 2;
      pnlContent.add(users.getGraphicalComponent(), constraints);
      
      constraints.gridy = 3;
      pnlContent.add(ltpReason, constraints);
      
      constraints.gridy = 4;
      pnlContent.add(lmpAmount, constraints);
      
      constraints.gridy = 5;
      pnlContent.add(ditDate, constraints);
      
      constraints.gridy = 6;
      pnlContent.add(rcrRecurrenceOptions, constraints);
      
      constraints.gridy = 7;
      constraints.anchor = GridBagConstraints.EAST;
      constraints.fill = GridBagConstraints.NONE;
      pnlContent.add(vclActions, constraints);
      
      return pnlContent;
   }

   private void initContent() {
      budgets = new ComboBoxBudget(controller.getCore());
      categories = new ComboBoxesCategory(controller.getCore());
      users = new ComboBoxUser(controller.getCore());
      ltpReason = new JLabelTextPanel(Text.REASON_LABEL);
      lmpAmount = new JLabelMoneyPanel(Text.AMOUNT_LABEL);
      ditDate = new JDateInput(Text.DATE_LABEL);
      
      rcrRecurrenceOptions = new JTimeSliceChooser();
      
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
      // Pas d'update pour l'instant. Voir rapport.
   }
}
