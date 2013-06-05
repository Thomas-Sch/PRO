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
import gui.component.JInfoEditionLabel;
import gui.component.JMoneyInfoEditionLabel;
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
   
   private JInfoEditionLabel ielpName;
   private JInfoEditionLabel ielBankName;
   private JMoneyInfoEditionLabel mielThreshold;
   private JMoneyInfoEditionLabel mielInitialAmount;
   private JInfoEditionLabel ielNumber;
   private JInfoEditionLabel ielDescription;
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
      ielpName.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            account.setName(ielpName.getText());
         }
      });
      
      ielpName.addTextChangedListener(new TextChangedListener() {
         @Override
         public void textChanged(DocumentEvent event) {
            account.setBankName(ielpName.getText());
         }
      });
      
      mielThreshold.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            try {
               account.setThreshold(Double.valueOf(mielThreshold.getText()));
            } catch(NumberFormatException e) {
               MidasLogs.errors.push("NOT PARSING");
            }
         }
      });
      
      mielInitialAmount.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            try {
               account.setAmount(Double.valueOf(mielInitialAmount.getText()));
            } catch(NumberFormatException e) {
               MidasLogs.errors.push("NOT PARSING");
            }
         }
      });
      
      ielNumber.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            account.setAccountNumber(ielNumber.getText());
         }
      });
      
      ielDescription.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            account.setDescription(ielDescription.getText());
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
      pnlContent.add(ielpName, constraints);
      
      constraints.gridy = 1;
      pnlContent.add(ielBankName, constraints);
      
      constraints.gridy = 2;
      pnlContent.add(mielThreshold, constraints);
      
      constraints.gridy = 3;
      pnlContent.add(mielInitialAmount, constraints);
      
      constraints.gridy = 4;
      pnlContent.add(ielNumber, constraints);
      
      constraints.gridy = 5;
      pnlContent.add(ielDescription, constraints);
      
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
      ielpName = new JInfoEditionLabel(Text.ACCOUNT_NAME_LABEL);
      ielBankName = new JInfoEditionLabel(Text.ACCOUNT_BANK_NAME_LABEL);
      mielThreshold = new JMoneyInfoEditionLabel(Text.ACCOUNT_THRESHOLD_LABEL);
      mielInitialAmount = new JMoneyInfoEditionLabel(Text.ACCOUNT_INITIAL_AMOUNT_LABEL);
      ielNumber = new JInfoEditionLabel(Text.ACCOUNT_NUMBER_LABEL);
      ielDescription = new JInfoEditionLabel(Text.ACCOUNT_DESCRIPTION_LABEL);
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
