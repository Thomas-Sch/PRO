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
import gui.component.JLabelTextPanel;
import gui.component.JMoneyInfoEditionLabel;
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
import core.MidasLogs;
import core.components.BudgetOnTheFly;
import core.exceptions.NegativeLimit;

/**
 * Fenêtre de création d'un budget à la volée.
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
   private JMoneyInfoEditionLabel lmpAmount;
   private JValidateCancel vclActions;
   private ComboBoxAccount accounts;

   private JDateInput ditStart;
   private JDateInput ditEnd;
   
   private JLabelTextPanel ltpDescription;
   
   private Controller controller;
   
   private BudgetOnTheFly budget;

   /**
    * Crée une nouvelle fenêtre de création de budget à la volée.
    * @param controller
    * @param budget
    */
   public JCreateOnTheFlyBudget(Controller controller, BudgetOnTheFly budget) {
      this.controller = controller;
      this.budget = budget;
      
      initComponents();
      initListeners();
      setContentPane(buildContent());
      pack();
   }
   
   /**
    * Initialisation des composants de la fenêtre.
    */
   private void initComponents() {
      ltpName = new JLabelTextPanel(Text.BUDGET_NAME_LABEL);
      lmpAmount = new JMoneyInfoEditionLabel(Text.AMOUNT_LABEL);
      accounts = new ComboBoxAccount(controller.getCore());
      
      ditStart = new JDateInput(Text.BEGIN_DATE_LABEL);
      ditEnd = new JDateInput(Text.END_DATE_LABEL);
      
      ltpDescription = new JLabelTextPanel(Text.BUDGET_DESCRIPTION_LABEL);      
      vclActions = new JValidateCancel();
   }
   
   /**
    * Initialise les écouteurs internes à la fenêtre.
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
               lmpAmount.setValid();
            }
            catch (NumberFormatException e) {
               MidasLogs.errors.push(e.getMessage());
               lmpAmount.setInvalid();
            }
            catch (NegativeLimit e) {
               lmpAmount.setInvalid();
               MidasLogs.errors.push(e.getMessage());
            }
            
            vclActions.setEnableValidateButton(isValid());
         }
      });
      
      accounts.addSelectedChangedListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            vclActions.setEnableValidateButton(isValid());
            if(accounts.isValidItemSelected()) {
               budget.setBindedAccount(accounts.getSelectedItem());
            }
         }
      });
   }
   
   /**
    * Construit et positionne le contenu graphique de la fenêtre.
    * @return Le contenu graphique de la fenêtre.
    */
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
   
   /**
    * Ajoute un écouteur sur le bouton de validation de l'interface.
    * @param listener Action à effectuer lors de l'appui sur le bouton.
    */
   public void addValidateListener(ActionListener listener) {
      vclActions.addValidateListener(listener);
   }
   
   /**
    * Ajoute un écouteur sur le bouton d'annulation de l'interface.
    * @param listener Action à effectuer lors de l'appui sur le bouton.
    */
   public void addCancelListener(ActionListener listener) {
      vclActions.addCancelListener(listener);
   }
   
   /**
    * Retourne la date de début du budget sélectionné dans l'interface.
    * @return la date de début du budget sélectionné dans l'interface.
    */
   public Date getStartDate() {
      return ditStart.getDate();
   }
   
   /**
    * Retourne la date de fin du budget sélectionné dans l'interface.
    * @return la date de fin du budget sélectionné dans l'interface.
    */
   public Date getEndDate() {
      return ditEnd.getDate();
   }
   
   /**
    * Définit si les informations entrées dans l'interface
    * sont suffisantes pour être enregistrées.
    */
   public boolean isValid() {
      if(ltpName == null || accounts == null) {
         return false;
      } else {
         return ltpName.getText().length() != 0 
                && accounts.isValidItemSelected()
                && lmpAmount.isNumber();
      }
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      // Pas d'update pour l'instant. Voir rapport.
   }
}
