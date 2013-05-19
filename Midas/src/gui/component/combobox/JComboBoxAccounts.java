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

import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;

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
    * Constructeur de la liste déroulante.
    */
   public JComboBoxAccounts(AccountList accounts) {
      this.accounts = accounts;
      update(accounts, null);
   }

   @Override
   public void update(Observable o, Object arg) {
      LinkedList<Account> list = accounts.getAll(new SortByName());
      
      if(isFirstUse()) {
         list.addFirst(accounts.createFalseEntry("Sélectionner un compte")); // TO UPDATE
      }
      
      int index = updateIndex();
      list.add(index, accounts.createFalseEntry("Nouveau compte...")); // TO UPDATE
      
      Account[] temp = new Account[0];
      setModel(new DefaultComboBoxModel<Account>(list.toArray(temp)));
   }
   
   public void addSelectedChangedListener(ActionListener listener) {
      addActionListener(listener);
   }
   
   private class SortByName implements Comparator<Account> {
      @Override
      public int compare(Account arg0, Account arg1) {
         return arg0.getAccountNumber().compareToIgnoreCase(arg1.getAccountNumber());
      }
   }

}
