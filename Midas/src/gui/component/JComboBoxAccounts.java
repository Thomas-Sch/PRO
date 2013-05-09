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
package gui.component;

import gui.View;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import core.components.Account;
import core.components.AccountList;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JComboBoxAccounts extends JComboBox<Account> implements View{
   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -7152847868675750776L;
   private final static int INDEX_NEW = 0;
   private final static int INDEX_NEW_FIRST_USE = 1;
   
   private AccountList accounts;
   
   private boolean firstUse = true;
   
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
      
      if(firstUse) {
         list.addFirst(accounts.createFalseAccount("Sélectionner un compte")); // TO UPDATE
      }
      
      int index = INDEX_NEW;
      if(firstUse) {
         index = INDEX_NEW_FIRST_USE;
      }
      list.add(index, accounts.createFalseAccount("Nouveau compte...")); // TO UPDATE
      
      Account[] temp = new Account[0];
      setModel(new DefaultComboBoxModel<Account>(list.toArray(temp)));
   }
   
   public boolean isCreateNewSelected() {
      if(firstUse) {
         return getSelectedIndex() == INDEX_NEW_FIRST_USE;
      }
      else {
         return getSelectedIndex() == INDEX_NEW;
      }
   }
   
   public void setFirstUse(boolean firstUse) {
      this.firstUse = firstUse;
   }
   
   public boolean isFirstUse() {
      return firstUse;
   }
   
   private class SortByName implements Comparator<Account> {
      @Override
      public int compare(Account arg0, Account arg1) {
         return arg0.getAccountNumber().compareToIgnoreCase(arg1.getAccountNumber());
      }
   }

}
