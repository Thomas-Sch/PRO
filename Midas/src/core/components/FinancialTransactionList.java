/* ============================================================================
 * Nom du fichier   : FinancialTransactionList.java
 * ============================================================================
 * Date de création : 7 juin 2013
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
 * Représente une liste de transactions financières.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class FinancialTransactionList extends
                                          ListTemplate<FinancialTransaction> {

   /**
    * Crée une liste de transaction financière, notifiant ses observateurs
    * lorsqu'elle est mise à jour.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public FinancialTransactionList(Core core) {
      super(core);
   }

   @Override
   public FinancialTransaction createFalseEntry(String name) {
      return null;
   }

   @Override
   public FinancialTransaction get(int id) {
      for (FinancialTransaction financialTransaction : getList()) {
         if (financialTransaction.getId() == id) {
            return financialTransaction;
         }
      }
      return null;
   }
}