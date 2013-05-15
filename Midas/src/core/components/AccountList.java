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

/**
 * Liste de comptes.
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

   public Account get(int id) {
    for(Account account : getList()) {
       if (account.getId() == id) {
          return account;
       }
    }
    return null;
   }
}
