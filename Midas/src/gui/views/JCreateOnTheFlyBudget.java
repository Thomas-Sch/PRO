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
import gui.component.JInfoEditionLabel;
import gui.component.JMoneyInfoEditionLabel;
import gui.component.JValidateCancel;
import gui.controller.combobox.ComboBoxAccount;
import gui.exception.BadDateException;
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
import core.exceptions.NegativeLimitException;

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
   
   private JInfoEditionLabel ielName;
   private JMoneyInfoEditionLabel mielAmount;
   private JValidateCancel vclActions;
   private ComboBoxAccount accounts;

   private JDateInput ditStart;
   private JDateInput ditEnd;
   
   private JInfoEditionLabel ielDescription;
   
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
      ielName = new JInfoEditionLabel(Text.BUDGET_NAME_LABEL);
      mielAmount = new JMoneyInfoEditionLabel(Text.AMOUNT_LABEL);
      accounts = new ComboBoxAccount(controller.getCore());
      
      ditStart = new JDateInput(Text.BEGIN_DATE_LABEL);
      ditEnd = new JDateInput(Text.END_DATE_LABEL);
      
      ielDescription = new JInfoEditionLabel(Text.BUDGET_DESCRIPTION_LABEL);      
      vclActions = new JValidateCancel();
   }
   
   /**
    * Initialise les écouteurs internes à la fenêtre.
    */
   private void initListeners() {
      ielName.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            budget.setName(ielName.getText());
            checkItemIntegrity();
         }
      });
      
      ielDescription.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            budget.setDescription(ielDescription.getText()); 
         }
      });
      
      mielAmount.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            try {
               budget.setLimit(Double.valueOf(mielAmount.getText()));
               mielAmount.setValid();
            }
            catch (NumberFormatException e) {
               MidasLogs.errors.push(e.getMessage());
               mielAmount.setInvalid();
            }
            catch (NegativeLimitException e) {
               mielAmount.setInvalid();
               MidasLogs.errors.push(e.getMessage());
            }
            checkItemIntegrity();
         }
      });
      
      accounts.addSelectedChangedListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if(accounts.isValidItemSelected()) {
               budget.setBindedAccount(accounts.getSelectedItem());
            }
            checkItemIntegrity();
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
      pnlContent.add(ielName, constraints);
      
      constraints.gridy = 1;
      pnlContent.add(mielAmount, constraints);
      
      constraints.gridy = 2;
      pnlContent.add(accounts.getGraphicalComponent(), constraints);
      
      constraints.gridy = 3;
      pnlContent.add(ditStart, constraints);
      
      constraints.gridy = 4;
      pnlContent.add(ditEnd, constraints);     
      
      constraints.gridy = 5;
      pnlContent.add(ielDescription, constraints);
      
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
    * @throws BadDateException Si la date est invalide.
    */
   public Date getStartDate() throws BadDateException {
      return ditStart.getDate();
   }
   
   /**
    * Retourne la date de fin du budget sélectionné dans l'interface.
    * @return la date de fin du budget sélectionné dans l'interface.
    * @throws BadDateException Si la date est invalide.
    */
   public Date getEndDate() throws BadDateException {
      return ditEnd.getDate();
   }
   
   
   /**
    * Vérifie que l'objet complété par l'utilisateur est sauvegardable dans
    * la base de donnée.
    */
   private void checkItemIntegrity() {
      boolean checkResult;
      checkResult = ielName.isValidData() 
            && accounts.isValidItemSelected()
            && mielAmount.isNumber();
      vclActions.setEnableValidateButton(checkResult);
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      // Pas d'update pour l'instant. Voir rapport.
   }
}
