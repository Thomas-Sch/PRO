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

import core.Core;
import core.MidasLogs;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AccountList extends ListTemplate<Account> {
   
   /**
    * @param core Coeur de l'application.
    */
   public AccountList(Core core) {
      super(core);
   }
   
   public Account createFalseEntry(String name) {
      return new Account(core, name);
   }

   public Account get(int userId) {
    for(Account account : getList()) {
       if (account.getId() == userId) {
          return account;
       }
    }
    return null;
   }
}
