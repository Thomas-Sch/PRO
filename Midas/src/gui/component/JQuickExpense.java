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
package gui.component;

import gui.Controller;
import gui.controller.combobox.ComboBoxBudget;
import gui.controller.combobox.ComboBoxUser;
import gui.controller.combobox.ComboBoxesCategory;
import gui.utils.TextChangedListener;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;

import settings.Language.Text;
import core.MidasLogs;
import core.components.FinancialTransaction;

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
   private Controller controller;
   private FinancialTransaction expense;
   
   private ComboBoxBudget budgets;
   private ComboBoxesCategory categories;
   private ComboBoxUser users;
   private JLabelTextPanel ltpReason;
   private JMoneyInfoEditionLabel lmpAmount;
   private JDateInput ditDate;
   private JButton btnValidate;
   
   /**
    * ID de série.
    */
   private static final long serialVersionUID = -3027141438435669187L;

   /**
    * 
    */
   public JQuickExpense(Controller controller, FinancialTransaction expense) {
      this.controller = controller;
      this.expense = expense;
      
      initContent();
      initListeners();
      buildContent();
   }
   
   public void initContent() {
      budgets = new ComboBoxBudget(controller.getCore());
      categories = new ComboBoxesCategory(controller.getCore());
      users = new ComboBoxUser(controller.getCore());
      ltpReason = new JLabelTextPanel(Text.REASON_LABEL);
      lmpAmount = new JMoneyInfoEditionLabel(Text.AMOUNT_LABEL);
      ditDate = new JDateInput(Text.DATE_LABEL);
      
      btnValidate = new JButton(Text.VALIDATE_BUTTON.toString());
      btnValidate.setEnabled(false);
   }
   
   private void initListeners() {
      ltpReason.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            expense.setReason(ltpReason.getText());
            checkItemIntegrity();
         }
      });
      
      lmpAmount.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            try {
               expense.setAmount(Double.parseDouble(lmpAmount.getText()));
               lmpAmount.setValid();
            } catch (NumberFormatException e) {
               MidasLogs.errors.push(e.getMessage());
               lmpAmount.setInvalid();
            }
            checkItemIntegrity();
         }
      });
      
      budgets.addSelectedChangedListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            if(budgets.isValidItemSelected()) {
               expense.setBudget(budgets.getSelectedItem());
            }
            checkItemIntegrity();
         }
      });
      
      users.addSelectedChangedListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            if(users.isValidItemSelected()) {
               expense.setUser(users.getSelectedItem());
            }
            checkItemIntegrity();
         }
      });
      
      categories.addSelectedChangedListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            if(categories.isValidItemSelected()) {
               expense.setCategory(categories.getSelectedItem());
            }
            checkItemIntegrity();
         }
      });
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
      add(new JLabel(Text.QUICK_EXPENSE_LABEL.toString()), constraints);
      
      constraints.gridx = 0;
      constraints.gridy = 1;
      add(budgets.getGraphicalComponent(), constraints);
      
      
      constraints.gridx = 1;
      constraints.gridwidth = 1;
      add(users.getGraphicalComponent(), constraints);
      
      
      constraints.gridx = 2;
      constraints.gridwidth = 1;
      add(categories.getGraphicalComponent(), constraints);
        
      constraints.gridx = 0;
      constraints.gridy = 2;
      add(ltpReason, constraints);
      
      constraints.gridx = 1;
      add(lmpAmount, constraints);
      
      constraints.gridx = 2;
      add(ditDate, constraints);
      
      constraints.gridx = 4;
      constraints.gridy = 3;
      add(btnValidate, constraints);
   }
   
   /**
    * Vérifie que l'objet complété par l'utilisateur est sauvegardable dans
    * la base de donnée.
    */
   private void checkItemIntegrity() {
      boolean checkResult;
      checkResult = ltpReason.getText().length() != 0 
                    && budgets.isValidItemSelected()
                    && users.isValidItemSelected()
                    && categories.isValidItemSelected()
                    && lmpAmount.isNumber();
      btnValidate.setEnabled(checkResult);
   }
   
   /**
    * Renvoie la date choisie pas l'utilisateur.
    * @return la date choisie pas l'utilisateur.
    */
   public Date getDate() {
      return ditDate.getDate();
   }
   
   /**
    * Ajoute un écouteur sur le bouton de validation.
    * @param listener Ecouteur ajouté.
    */
   public void addValidateListener(ActionListener listener) {
      btnValidate.addActionListener(listener);
   }
   
   /**
    *  Restaure le contenu de l'interface.
    */
   public void reset() {
      budgets.setInviteSelected();
      categories.setInviteSelected();
      users.setInviteSelected();
      ltpReason.setText("");
      lmpAmount.setText("0");
      ditDate.setDate(new Date());
      btnValidate.setEnabled(false);
   }
}
