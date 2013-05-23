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

import java.awt.Container;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JDialog;
import javax.swing.event.DocumentEvent;

import settings.Language.Text;

import core.MidasLogs;
import core.components.Account;

import gui.JInfoEditionPane;
import gui.component.JInfoEditionLabel;
import gui.utils.TextChangedListener;

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
   private JInfoEditionLabel ielAmount;
   private JInfoEditionLabel ielOverdraftLimit;

   /**
    * @param parent Fenêtre contenant le label.
    * @param data Compte à afficher.
    */
   public JAccountIE(JDialog parent, Container container, JAccountIE last, Account data) {
      this(parent, container, last, data, false);
   }
   
   /**
    * Rien à afficher.
    */
   public JAccountIE() {
      super();
   }
   
   public JAccountIE(JDialog parent, Container container, JAccountIE last, Account data, boolean edition) {
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
         }
      });
      
      ielAccountNumber.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            data.setAccountNumber(ielAccountNumber.getText());
            
         }
      });
      
      ielAmount.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            try {
               data.setAmount(Double.valueOf(ielAmount.getText()));
            }
            catch(NumberFormatException e) {
               MidasLogs.errors.push("Not a valid number ! : Parsing to double failed");
            }
         }
      });
      
      ielOverdraftLimit.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            try {
               data.setOverdraftLimit(Double.valueOf(ielOverdraftLimit.getText()));
            }
            catch(NumberFormatException e) {
               MidasLogs.errors.push("Not a valid number ! : Parsing to double failed");
            }
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
      //ielBankName = new JInfoEditionLabel(Text.ACCOUNT_BANK_NAME_LABEL, data.getBankName());
      ielAccountNumber = new JInfoEditionLabel(Text.ACCOUNT_NUMBER_LABEL, data.getAccountNumber());
      ielAmount = new JInfoEditionLabel(Text.AMOUNT_LABEL,String.valueOf(data.getAmount()));
      ielOverdraftLimit = new JInfoEditionLabel(Text.ACCOUNT_OVERDRAFTLIMIT_LABEL, String.valueOf(data.getOverdraftLimit()));
      
      // Ajout des champs à la liste.
      result.add(ielName);
      result.add(ielAccountNumber);
      result.add(ielAmount);
      result.add(ielOverdraftLimit);
      return result;
   }

   /* (non-Javadoc)
    * @see gui.JInfoEditionPane#buildContent()
    */
   @Override
   public void buildContent() {
      setLayout(new GridLayout(5, 0));
      add(ielName);
      add(ielAccountNumber);
      add(ielAmount);
      add(ielOverdraftLimit);
   }

}
