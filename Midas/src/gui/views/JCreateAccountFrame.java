/* ============================================================================
 * Nom du fichier   : NewAccountFrame.java
 * ============================================================================
 * Date de création : 18 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.views;

import gui.View;
import gui.component.JLabelMoneyPanel;
import gui.component.JLabelTextPanel;
import gui.component.JValidateCancel;
import gui.utils.StandardInsets;
import gui.utils.TextChangedListener;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;

import settings.Language.Text;
import core.MidasLogs;
import core.components.Account;
/**
 * Fenêtre d'ajout de compte.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JCreateAccountFrame extends JDialog implements View{

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -2273955948172856823L;
   
   private Account account;
   
   private JLabelTextPanel ltpName;
   private JLabelTextPanel ltpBankName;
   private JLabelMoneyPanel ltpThreshold;
   private JLabelMoneyPanel ltpInitialAmount;
   private JLabelTextPanel ltpNumber;
   private JLabelTextPanel ltpDescription;
   private JValidateCancel vcrActions;
   
   /**
    * Construit une nouvelle fenêtre pour ajouter un compte.
    */
   public JCreateAccountFrame(Account account) {
      this.account = account;
      
      initComponent();
      initListeners();
      setContentPane(buildContent());
      pack();
   }
   
   /**
    * Initialise les écouteurs sur les composants de la vue.
    */
   private void initListeners() {
      ltpName.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            account.setName(ltpName.getText());
         }
      });
      
      ltpName.addTextChangedListener(new TextChangedListener() {
         @Override
         public void textChanged(DocumentEvent event) {
            account.setBankName(ltpName.getText());
         }
      });
      
      ltpThreshold.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            try {
               account.setThreshold(Double.valueOf(ltpThreshold.getText()));
            } catch(NumberFormatException e) {
               MidasLogs.errors.push("NOT PARSING");
            }
         }
      });
      
      ltpInitialAmount.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            try {
               account.setAmount(Double.valueOf(ltpInitialAmount.getText()));
            } catch(NumberFormatException e) {
               MidasLogs.errors.push("NOT PARSING");
            }
         }
      });
      
      ltpNumber.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            account.setAccountNumber(ltpNumber.getText());
         }
      });
      
      ltpDescription.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            account.setDescription(ltpDescription.getText());
         }
      });
   }
   
   private JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      
      pnlContent.setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints();
      
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.weightx = 0.5;
      constraints.weighty = 0.5;
      constraints.insets = new StandardInsets();
      pnlContent.add(ltpName, constraints);
      
      constraints.gridy = 1;
      pnlContent.add(ltpBankName, constraints);
      
      constraints.gridy = 2;
      pnlContent.add(ltpThreshold, constraints);
      
      constraints.gridy = 3;
      pnlContent.add(ltpInitialAmount, constraints);
      
      constraints.gridy = 4;
      pnlContent.add(ltpNumber, constraints);
      
      constraints.gridy = 5;
      pnlContent.add(ltpDescription, constraints);
      
      constraints.gridy = 6;
      constraints.anchor = GridBagConstraints.EAST;
      constraints.fill = GridBagConstraints.NONE;
      pnlContent.add(vcrActions, constraints);      
      return pnlContent;
   }
   
   /**
    * Initialise les composants de le fenêtre.
    */
   private void initComponent() {
      ltpName = new JLabelTextPanel(Text.ACCOUNT_NAME_LABEL);
      ltpBankName = new JLabelTextPanel(Text.ACCOUNT_BANK_NAME_LABEL);
      ltpThreshold = new JLabelMoneyPanel(Text.ACCOUNT_THRESHOLD_LABEL);
      ltpInitialAmount = new JLabelMoneyPanel(Text.ACCOUNT_INITIAL_AMOUNT_LABEL);
      ltpNumber = new JLabelTextPanel(Text.ACCOUNT_NUMBER_LABEL);
      ltpDescription = new JLabelTextPanel(Text.ACCOUNT_DESCRIPTION_LABEL);
      vcrActions = new JValidateCancel();
      vcrActions.setEnableValidateButton(true);
   }
   
   /**
    * Ajoute un écouteur sur le bouton de validation.
    * @param listener l'écouteur ajouté.
    */
   public void addValidateListener(ActionListener listener) {
      vcrActions.addValidateListener(listener);
   }
   
   /**
    * Ajout un écouteur sur le bouton d'annulation.
    * @param listener l'écouteur ajouté.
    */
   public void addCancelListener(ActionListener listener) {
      vcrActions.addCancelListener(listener);
   }
   
   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      // Pas d'update pour l'instant. Voir rapport.
   }
}
