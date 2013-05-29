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
import gui.component.JTimeSliceChooser;
import gui.component.JValidateCancel;
import gui.controller.combobox.ComboBoxAccount;
import gui.utils.StandardInsets;
import gui.utils.TextChangedListener;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Observable;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;

import settings.Language.Text;
import utils.TimeSlice;
import core.components.Budget;
import core.exceptions.NegativeLimit;

/**
 * Fenêtre de création d'un budget.
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
   private JValidateCancel vclActions;
   private ComboBoxAccount accounts;
   
   private JDateInput ditDate;
   private JTimeSliceChooser tscBudgetLength;
   
   private JLabelTextPanel ltpDescription;
   
   private Controller controller;
   
   private Budget budget;
   
   public JCreateBudgetFrame(Controller controller, Budget budget) {
      this.controller = controller;
      this.budget = budget;
      
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
            vclActions.setEnableValidateButton(isValid());
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
            try {
               budget.setLimit(Double.valueOf(lmpAmount.getText()));
            }
            catch (NumberFormatException e) {
               e.printStackTrace();
            }
            catch (NegativeLimit e) {
               e.printStackTrace();
            }
         }
      });
      
      accounts.addSelectedChangedListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            vclActions.setEnableValidateButton(isValid());
            if(accounts.isValidAccountSelected()) {
               budget.setBindedAccount(accounts.getSelectedAccount());
            }
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
      pnlContent.add(tscBudgetLength, constraints);
      
      constraints.gridy = 5;
      pnlContent.add(ltpDescription, constraints);
      
      constraints.gridy = 6;
      constraints.fill = GridBagConstraints.NONE;
      constraints.anchor = GridBagConstraints.EAST;
      pnlContent.add(vclActions, constraints);
      return pnlContent;
   }
   
   private void initContent() {
      ltpName = new JLabelTextPanel(Text.BUDGET_NAME_LABEL);
      lmpAmount = new JLabelMoneyPanel(Text.AMOUNT_LABEL);
      accounts = new ComboBoxAccount(controller.getCore());
      
      ditDate = new JDateInput(Text.DATE_LABEL);
      
      tscBudgetLength = new JTimeSliceChooser(TimeSlice.DAILY, TimeSlice.WEEKLY, TimeSlice.MONTHLY, TimeSlice.ANNUAL);
      
      ltpDescription = new JLabelTextPanel(Text.BUDGET_DESCRIPTION_LABEL);      
      
      vclActions = new JValidateCancel();
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {

   }
   
   /**
    * Ajoute le listener lors de l'appui sur le bouton de validation.
    * @param listener
    */
   public void addValidateListener(ActionListener listener) {
      vclActions.addValidateListener(listener);
   }
   
   /**
    * Ajoute le listener lors de l'appui sur le bouton d'annulation.
    * @param actionListener
    */
   public void addCancelListener(ActionListener actionListener) {
      vclActions.addCancelListener(actionListener);
   }
   
   /**
    * Renvoie la date sélectionnée.
    * @return la date sélectionnée.
    */
   public Date getDate() {
      return ditDate.getDate();
   }
   
   /**
    * Renvoie l'intervalle de temps choisie par l'utilisateur.
    * @return l'intervalle de temps choisie par l'utilisateur.
    */
   public TimeSlice getTimeSlice() {
      return tscBudgetLength.getTimeSlice();
   }
   
   /**
    * Définit si les informations entrées dans l'interface
    * sont suffisantes pour être enregistrées.
    */
   public boolean isValid() {
      if(ltpName == null || accounts == null) {
         return false;
      } else {
         return ltpName.getText().length() != 0 && accounts.isValidAccountSelected();
      }
   }
}
