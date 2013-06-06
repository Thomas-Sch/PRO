/* ============================================================================
 * Nom du fichier   : JAccountIE.java
 * ============================================================================
 * Date de création : 22 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component.infoedition;

import gui.JInfoEditionPane;
import gui.JManageFrame;
import gui.component.JInfoEditionLabel;
import gui.component.JMoneyInfoEditionLabel;
import gui.utils.TextChangedListener;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.event.DocumentEvent;

import settings.Language.Text;
import core.MidasLogs;
import core.components.Account;

/**
 * Représente les informations d'un compte.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JAccountIE extends JInfoEditionPane<Account> {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -4003398565236786611L;
   
   // Composants graphiques.
   private JInfoEditionLabel ielName;
   private JInfoEditionLabel ielBankName;
   private JInfoEditionLabel ielAccountNumber;
   private JMoneyInfoEditionLabel mielAmount;
   private JMoneyInfoEditionLabel mielOverdraftLimit;
   private JInfoEditionLabel ielDescription;

   /**
    * @param parent Fenêtre contenant le label.
    * @param data Compte à afficher.
    */
   public JAccountIE(JManageFrame parent, Container container, JAccountIE last, Account data) {
      this(parent, container, last, data, false);
   }
   
   /**
    * Rien à afficher.
    */
   public JAccountIE() {
      super();
   }
   
   public JAccountIE(JManageFrame parent, Container container, JAccountIE last, Account data, boolean edition) {
      super(parent, container, last, data, edition);
   }


   /* (non-Javadoc)
    * @see gui.JInfoEditionPane#initListeners()
    */
   @Override
   public void initListeners() {
      ielName.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            data.setName(ielName.getText());
            checkItemIntegrity();
         }
      });
      
      ielBankName.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            data.setBankName(ielBankName.getText());
            checkItemIntegrity();
         }
      });
      
      ielAccountNumber.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            data.setAccountNumber(ielAccountNumber.getText());
            checkItemIntegrity();
         }
      });
      
      mielOverdraftLimit.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            try {
               data.setThreshold(Double.valueOf(mielOverdraftLimit.getText()));
               mielOverdraftLimit.setValid();
            }
            catch(NumberFormatException e) {
               MidasLogs.errors.push("Not a valid number (" + mielOverdraftLimit.getText() + ")! : Parsing to double failed");
               mielOverdraftLimit.setInvalid();
            }
            checkItemIntegrity();
         }
      });
      
      ielDescription.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            data.setDescription(ielDescription.getText());
         }
      });
   }

   /* (non-Javadoc)
    * @see gui.JInfoEditionPane#initContent()
    */
   @Override
   public LinkedList<JInfoEditionLabel> initContent(Account data) {
      LinkedList<JInfoEditionLabel> result = new LinkedList<>();
      
      // Définition des champs.
      ielName = new JInfoEditionLabel(Text.ACCOUNT_NAME_LABEL, data.getName());
      ielBankName = new JInfoEditionLabel(Text.ACCOUNT_BANK_NAME_LABEL, data.getBankName());
      ielAccountNumber = new JInfoEditionLabel(Text.ACCOUNT_NUMBER_LABEL, data.getAccountNumber());
      mielAmount = new JMoneyInfoEditionLabel(Text.ACCOUNT_BALANCE_LABEL,String.valueOf(data.getAmount()));
      mielOverdraftLimit = new JMoneyInfoEditionLabel(Text.ACCOUNT_THRESHOLD_LABEL, String.valueOf(data.getThreshold()));
      ielDescription = new JInfoEditionLabel(Text.ACCOUNT_DESCRIPTION_LABEL, data.getDescription());
      
      // Ajout des champs à la liste.
      result.add(ielName);
      result.add(ielBankName);
      result.add(ielAccountNumber);
      result.add(mielOverdraftLimit);
      result.add(ielDescription);
      return result;
   }

   /* (non-Javadoc)
    * @see gui.JInfoEditionPane#buildContent()
    */
   @Override
   public void buildContent() {
      setLayout(new GridLayout(6, 1));
      add(ielName);
      add(ielBankName);
      add(ielAccountNumber);
      add(mielAmount);
      add(mielOverdraftLimit);
      add(ielDescription);
   }
   
   /**
    * Vérifie que l'objet complété par l'utilisateur est sauvegardable dans
    * la base de donnée.
    */
   private void checkItemIntegrity() {
      boolean checkResult;
      checkResult = ielName.isValidData()
                    && ielBankName.isValidData()
                    && ielAccountNumber.isValidData()
                    && mielOverdraftLimit.isNumber();
      setEnabledValidateButton(checkResult);
   }
}
