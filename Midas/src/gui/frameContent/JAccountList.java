/* ============================================================================
 * Nom du fichier   : JAccountList.java
 * ============================================================================
 * Date de création : 8 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.frameContent;

import gui.View;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

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
public class JAccountList extends JList<Account> implements View{

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -8808271053870485590L;
   
   private final static int INDEX_NEW = 0;
   private final static int INDEX_NEW_FIRST_USE = 1;
   
   private AccountList accounts;
   
   private boolean firstUse = true;   
  
   /**
    * Constructeur par défaut.
    */
   public JAccountList(AccountList accounts) {
      this.accounts = accounts;
      update(accounts, null);  
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
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
         return arg0.getAccountName().compareToIgnoreCase(arg1.getAccountName());
      }
   }
}
