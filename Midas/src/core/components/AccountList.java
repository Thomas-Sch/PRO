/* ============================================================================
 * Nom du fichier   : AccountList.java
 * ============================================================================
 * Date de création : 9 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core.components;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import core.Core;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AccountList extends CoreComponent {
   
   private LinkedList<Account> accounts = new LinkedList<>();

   /**
    * @param core
    */
   public AccountList(Core core) {
      super(core);
   }
   
   public void addAccount(Account account) {
      accounts.add(account);
      
      setChanged();
      notifyObservers();
   }
   
   public Account getAt(int index) {
      return accounts.get(index);
   }
   
   public Account get(int userId) {
      for(Account account : accounts) {
         if (account.getId() == userId) {
            return account;
         }
      }
      return null;
   }
   
   public LinkedList<Account> getAll(Comparator<Account> comp) {
      
      LinkedList<Account> result = new LinkedList<>();
      
      result.addAll(accounts);
      
      Collections.sort(result, comp);

      return result;
   }
   
   public void setAccounts(LinkedList<Account> users) {
      this.accounts.clear();
      this.accounts.addAll(users);
      
      setChanged();
      notifyObservers();
   }
   
   public Account createFalseAccount(String name) {
      return new Account(core, name);
   }
}
