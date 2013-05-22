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
 * Représente une liste de comptes.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class AccountList extends ListTemplate<Account> {

   /**
    * Crée une liste de comptes, notifiant ses observateurs lorsqu'elle est mise
    * à jour.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public AccountList(Core core) {
      super(core);
   }

   @Override
   public Account createFalseEntry(String name) {
      return new Account(core, name);
   }

   @Override
   public Account get(int id) {
      for (Account account : getList()) {
         if (account.getId() == id) {
            return account;
         }
      }
      return null;
   }
}
