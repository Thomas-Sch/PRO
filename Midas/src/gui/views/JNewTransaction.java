/* ============================================================================
 * Nom du fichier   : JNewTransaction.java
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
import gui.controller.combobox.ComboBoxUser;
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
import core.components.FinancialTransaction;

/**
 * Nouvelle transaction sur un compte.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JNewTransaction extends JDialog implements View {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -3182363764437829156L;
   
   private Controller controller;
   private FinancialTransaction transaction;
   
   //Composants
   private ComboBoxAccount accounts;
   private ComboBoxUser users;
   private JMoneyInfoEditionLabel mielAmount;
   private JInfoEditionLabel ielReason;
   private JDateInput ditDate;

   private JValidateCancel vclActions;
   
   public JNewTransaction(Controller controller, FinancialTransaction transaction) {
      this.controller = controller;
      this.transaction = transaction;
      
      initContent();
      initListeners();
      setContentPane(buildContent());
      pack();
   }
   
   /**
    * Construit et place les composants de l'interface.
    * @return Le panel contenant les composants.
    */
   private JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      pnlContent.setLayout(new GridBagLayout());
      
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.insets = new StandardInsets();
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.anchor = GridBagConstraints.WEST;
      constraints.weightx = 0.5;
      constraints.weighty = 0.5;
      
      constraints.gridx = 0;
      constraints.gridy = 0;
      pnlContent.add(accounts.getGraphicalComponent(), constraints);
      
      
      constraints.gridy = 1;
      pnlContent.add(users.getGraphicalComponent(), constraints);

      constraints.gridy = 2;
      pnlContent.add(mielAmount, constraints);
      
      constraints.gridy = 3;
      pnlContent.add(ielReason, constraints);
      
      constraints.gridy = 4;
      pnlContent.add(ditDate, constraints);
      
      constraints.gridy = 5;
      pnlContent.add(vclActions, constraints);
      
      return pnlContent;
   }
   
   /**
    * Initialise les composants de la fenêtre.
    */
   private void initContent() {
      accounts = new ComboBoxAccount(controller.getCore());
      users = new ComboBoxUser(controller.getCore());
      ielReason = new JInfoEditionLabel(Text.REASON_LABEL);
      mielAmount = new JMoneyInfoEditionLabel(Text.AMOUNT_LABEL);
      ditDate = new JDateInput(Text.DATE_LABEL);
      
      vclActions = new JValidateCancel();
   }
   
   private void initListeners() {
     ielReason.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            transaction.setReason(ielReason.getText());
            checkItemIntegrity();
         }
      });
      
      mielAmount.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            try {
               transaction.setAmount(Double.parseDouble(mielAmount.getText()));
               mielAmount.setValid();
            } catch (NumberFormatException e) {
               MidasLogs.errors.push(e.getMessage());
               mielAmount.setInvalid();
            }
            checkItemIntegrity();
         }
      });
      
      accounts.addSelectedChangedListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            if(accounts.isValidItemSelected()) {
               transaction.setAccount(accounts.getSelectedItem());
            }
            checkItemIntegrity();
         }
      });
      
      users.addSelectedChangedListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            if(users.isValidItemSelected()) {
               transaction.setUser(users.getSelectedItem());
            }
            checkItemIntegrity();
         }
      });
   }
   
   /**
    * Ajoute un écouteur sur le bouton de validation.
    * @param listener Ecouteur ajouté.
    */
   public void addValidateListener(ActionListener listener) {
      vclActions.addValidateListener(listener);
   }
   
   /**
    * Ajoute un écouteur sur le bouton d'annulation.
    * @param listener Ecouteur ajouté.
    */
   public void addCancelListener(ActionListener listener) {
      vclActions.addCancelListener(listener);
   }
   
   /**
    * Retourne la date sélectionnée par l'utilisateur.
    * @return La date choisie.
    */
   public Date getDate() {
      return ditDate.getDate();
   }
   
   /**
    * Vérifie que l'objet complété par l'utilisateur est sauvegardable dans
    * la base de donnée.
    */
   private void checkItemIntegrity() {
      boolean checkResult;
      checkResult = ielReason.getText().length() != 0 
                    && accounts.isValidItemSelected()
                    && users.isValidItemSelected()
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
