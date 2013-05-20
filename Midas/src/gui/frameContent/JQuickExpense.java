/* ============================================================================
 * Nom du fichier   : QuickExpense.java
 * ============================================================================
 * Date de création : 28 avr. 2013
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
import gui.component.JDateInput;
import gui.component.JLabelMoneyPanel;
import gui.component.JReasonInput;
import gui.controller.combobox.ComboBoxBudget;
import gui.controller.combobox.ComboBoxUser;
import gui.controller.combobox.ComboBoxesCategory;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import settings.Language.Text;

/**
 * Panel permettant l'ajout d'une dépense rapide.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JQuickExpense extends JPanel {
   Controller controller;

   
   //Composants de l'interface.
   JButton btnValidate;
   
   ComboBoxesCategory categories;
   ComboBoxBudget budgets;
   
   /**
    * ID de série.
    */
   private static final long serialVersionUID = -3027141438435669187L;

   /**
    * 
    */
   public JQuickExpense(Controller controller) {
      this.controller = controller;
      
      initContent();
      buildContent();
   }
   
   public void initContent() {
      categories = new ComboBoxesCategory(controller.getCore());
      budgets = new ComboBoxBudget(controller.getCore());
   }
   
   public void buildContent() {
      GridBagLayout layout = new GridBagLayout();
      setLayout(layout);
      
      GridBagConstraints constraints = new GridBagConstraints();
      
      constraints.fill = GridBagConstraints.HORIZONTAL;
      
      constraints.insets = new Insets(5, 5, 5, 5);
      constraints.weighty = 0.0;
      
      // Paramétrage des contraintes et ajout du panel d'alerte.
      constraints.weightx = 0.1;
      constraints.gridx = 0;
      constraints.gridy = 0;     
      constraints.anchor = GridBagConstraints.NORTH;
      add(new JLabel(Text.QUICK_EXPENSE_LABEL.toString()), constraints);
      
      ComboBoxUser authors = new ComboBoxUser(controller.getCore());
      constraints.gridx = 0;
      constraints.gridy = 1;
      add(authors.getGraphicalComponent(), constraints);
      
      constraints.gridx = 1;
      add(new JLabelMoneyPanel(Text.AMOUNT_LABEL), constraints);
      
      constraints.gridx = 2;
      add(new JDateInput(Text.DATE_LABEL.toString()), constraints);
      
      constraints.gridx = 0;
      constraints.gridy = 2;

      
      add(budgets.getGraphicalComponent(), constraints);
      
      constraints.gridx = 1;
      add(categories.getGraphicalComponent(), constraints);

      constraints.gridx = 0;
      constraints.gridy = 3;
      constraints.gridwidth = 3;
      add(new JReasonInput(), constraints);
      
      constraints.gridx = 2;
      constraints.gridy = 4;
      constraints.gridwidth = 1;
      btnValidate = new JButton("Valider la dépense");
      add(btnValidate, constraints);
      
   }
   
   public JButton getValidateButton() {
      return  btnValidate;
   }
}
