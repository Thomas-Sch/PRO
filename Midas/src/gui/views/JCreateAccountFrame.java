/* ============================================================================
 * Nom du fichier   : JCreateAccountFrame.java
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
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JCreateAccountFrame extends JDialog implements View {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -2273955948172856823L;

   private Account account;

   private JInfoEditionLabel ielName;
   private JInfoEditionLabel ielBankName;
   private JMoneyInfoEditionLabel mielThreshold;
   private JMoneyInfoEditionLabel mielInitialAmount;
   private JInfoEditionLabel ielNumber;
   private JInfoEditionLabel ielDescription;
   private JValidateCancel vclActions;

   /**
    * Crée la fenêtre d'ajout de compte.
    * 
    * @param account
    *           - le nouveau compte à remplir.
    */
   public JCreateAccountFrame(Account account) {
      this.account = account;

      initComponent();
      initListeners();
      setContentPane(buildContent());
      pack();
   }

   /**
    * Initialise les listeners à usage interne de l'interface.
    */
   private void initListeners() {
      ielName.addTextChangedListener(new TextChangedListener() {

         @Override
         public void textChanged(DocumentEvent event) {
            account.setName(ielName.getText());
            checkItemIntegrity();
         }
      });

      ielBankName.addTextChangedListener(new TextChangedListener() {
         @Override
         public void textChanged(DocumentEvent event) {
            account.setBankName(ielBankName.getText());
            checkItemIntegrity();
         }
      });

      mielThreshold.addTextChangedListener(new TextChangedListener() {

         @Override
         public void textChanged(DocumentEvent event) {
            try {
               account.setThreshold(Double.valueOf(mielThreshold.getText()));
               mielThreshold.setValid();
            }
            catch (NumberFormatException e) {
               MidasLogs.errors.push("NOT PARSING");
               mielThreshold.setInvalid();
            }
            checkItemIntegrity();
         }
      });

      mielInitialAmount.addTextChangedListener(new TextChangedListener() {

         @Override
         public void textChanged(DocumentEvent event) {
            try {
               account.setAmount(Double.valueOf(mielInitialAmount.getText()));
               mielInitialAmount.setValid();
            }
            catch (NumberFormatException e) {
               MidasLogs.errors.push("NOT PARSING");
               mielInitialAmount.setInvalid();
            }
            checkItemIntegrity();
         }
      });

      ielNumber.addTextChangedListener(new TextChangedListener() {

         @Override
         public void textChanged(DocumentEvent event) {
            account.setAccountNumber(ielNumber.getText());
            checkItemIntegrity();
         }
      });

      ielDescription.addTextChangedListener(new TextChangedListener() {

         @Override
         public void textChanged(DocumentEvent event) {
            account.setDescription(ielDescription.getText());
         }
      });
      checkItemIntegrity();
   }

   /**
    * Construit le contenu de la fenêtre.
    * 
    * @return Le contenu de la fenêtre.
    */
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
      pnlContent.add(ielName, constraints);

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
      pnlContent.add(vclActions, constraints);
      return pnlContent;
   }

   /**
    * Initialise les composants de le fenêtre.
    */
   private void initComponent() {
      ielName = new JInfoEditionLabel(Text.ACCOUNT_NAME_LABEL);
      ielBankName = new JInfoEditionLabel(Text.ACCOUNT_BANK_NAME_LABEL);
      mielThreshold = new JMoneyInfoEditionLabel(Text.ACCOUNT_THRESHOLD_LABEL);
      mielInitialAmount = new JMoneyInfoEditionLabel(
            Text.ACCOUNT_INITIAL_AMOUNT_LABEL);
      ielNumber = new JInfoEditionLabel(Text.ACCOUNT_NUMBER_LABEL);
      ielDescription = new JInfoEditionLabel(Text.ACCOUNT_DESCRIPTION_LABEL);
      vclActions = new JValidateCancel();
      vclActions.setEnableValidateButton(true);
   }

   /**
    * Ajoute un écouteur sur le bouton de validation.
    * 
    * @param listener
    *           - l'écouteur ajouté.
    */
   public void addValidateListener(ActionListener listener) {
      vclActions.addValidateListener(listener);
   }

   /**
    * Ajout un écouteur sur le bouton d'annulation.
    * 
    * @param listener
    *           - l'écouteur ajouté.
    */
   public void addCancelListener(ActionListener listener) {
      vclActions.addCancelListener(listener);
   }

   /**
    * Vérifie que l'objet complété par l'utilisateur peut être sauvegardé dans
    * la base de données.
    */
   private void checkItemIntegrity() {
      boolean checkResult;
      checkResult = ielName.isValidData() 
                     && ielBankName.isValidData()
                     && ielNumber.isValidData()
                     && mielThreshold.isNumber()
                     && mielInitialAmount.isNumber();
      vclActions.setEnableValidateButton(checkResult);
   }
   
   @Override
   public void update(Observable arg0, Object arg1) {
      // Pas d'update pour l'instant. Voir rapport.
   }
}
