/* ============================================================================
 * Nom du fichier   : ComboBoxAccount.java
 * ============================================================================
 * Date de création : 16 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component.combobox;

import gui.JComboBoxTemplate;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;

import settings.Language.Text;
import core.components.Account;
import core.components.AccountList;

/**
 * Liste déroulante de comptes.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JComboBoxAccounts extends JComboBoxTemplate<Account>{
   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -7152847868675750776L;
   
   private AccountList accounts;
   
   /**
    * Crée de la liste déroulante.
    * 
    * @param accounts
    *           - les comptes à afficher dans la liste.
    */
   public JComboBoxAccounts(AccountList accounts) {
      this.accounts = accounts;
      update(accounts, null);
   }

   @Override
   public void update(Observable o, Object arg) {
      LinkedList<Account> list = accounts.getAll(new SortByName());
      
      if(isFirstUse()) {
         list.addFirst(accounts.createFalseEntry(Text.SELECT_ACCOUNT_LABEL.
                                                                  toString()));
      }
      
      int index = updateIndex();
      list.add(index, accounts.createFalseEntry(Text.NEW_ACCOUNT_LABEL.
                                                                  toString()));
      
      Account[] temp = new Account[0];
      setModel(new DefaultComboBoxModel<Account>(list.toArray(temp)));
   }
   
   /**
    * Comparateur de comptes selon leur numéros.
    * 
    * @author Biolzi Sébastien
    * @author Brito Carvalho Bruno
    * @author Decorvet Grégoire
    * @author Schweizer Thomas
    * @author Sinniger Marcel
    * 
    */
   private class SortByName implements Comparator<Account> {
      @Override
      public int compare(Account arg0, Account arg1) {
         return arg0.getAccountNumber().compareToIgnoreCase(arg1.getAccountNumber());
      }
   }
}
