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
import gui.component.JLabelTextPanel;
import gui.component.JMoneyInfoEditionLabel;
import gui.component.JValidateCancel;
import gui.controller.combobox.ComboBoxBudget;
import gui.controller.combobox.ComboBoxUser;
import gui.controller.combobox.ComboBoxesCategory;
import gui.utils.StandardInsets;
import gui.utils.TextChangedListener;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;

import settings.Language.Text;
import core.MidasLogs;
import core.components.FinancialTransaction;

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
   private FinancialTransaction expense;
   
   //Composants
   private ComboBoxBudget budgets;
   private ComboBoxesCategory categories;
   private ComboBoxUser users;
   private JLabelTextPanel ltpReason;
   private JMoneyInfoEditionLabel lmpAmount;
   private JDateInput ditDate;
   
   private JValidateCancel vclActions;
   
   /**
    * Crée une fenêtre pour ajouter une dépense à un budget.
    * @param controller Contrôleur de la fenêtre.
    * @param expense Nouvelle dépense à remplir.
    */
   public JNewExpense(Controller controller, FinancialTransaction expense) {
      this.controller = controller;
      this.expense = expense;
      
      initContent();
      initListeners();
      setContentPane(buildContent());
      pack();
   }
   
   /**
    * Initialise les écouteurs propre à l'interface.
    */
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
   
   private JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      pnlContent.setLayout(new GridBagLayout());
      
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
      lmpAmount = new JMoneyInfoEditionLabel(Text.AMOUNT_LABEL);
      ditDate = new JDateInput(Text.DATE_LABEL);
      
      vclActions = new JValidateCancel();
   }
   
   /**
    * Ajoute un écouteur sur le bouton de validation.
    * @param listener L'écouteur ajouté
    */
   public void addValidateListener(ActionListener listener) {
      vclActions.addValidateListener(listener);
   }
   
   /**
    * Ajoute un écouteur sur le bouton d'annulation.
    * @param listener L'écouteur ajouté.
    */
   public void addCancelListener(ActionListener listener) {
      vclActions.addCancelListener(listener);
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
                    && lmpAmount.isNumber()
                    && Double.valueOf(lmpAmount.getText()) >= 0;
      vclActions.setEnableValidateButton(checkResult);
   }
   
   /**
    * Renvoie la date choisie pas l'utilisateur.
    * @return la date choisie pas l'utilisateur.
    */
   public Date getDate() {
      return ditDate.getDate();
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      // Pas d'update pour l'instant. Voir rapport.
   }
}
