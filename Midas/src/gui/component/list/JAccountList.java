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
package gui.component.list;

import gui.View;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

import core.components.Account;
import core.components.AccountList;

/**
 * Composant graphique pour l'affichage d'une liste de comptes.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JAccountList extends JList<Account> implements View {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -8808271053870485590L;

   private AccountList accounts;

   /**
    * Crée la vue d'une liste de comptes.
    * 
    * @param accounts
    *           - la liste de comptes.
    */
   public JAccountList(AccountList accounts) {
      this.accounts = accounts;
      this.setFixedCellWidth(200);
      update(accounts, null);
   }

   @Override
   public void update(Observable arg0, Object arg1) {
      LinkedList<Account> list = accounts.getAll(new SortByName());

      Account[] temp = new Account[0];
      setModel(new DefaultComboBoxModel<Account>(list.toArray(temp)));
   }

   /**
    * Comparateur de comptes selon leur noms.
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
         return arg0.getName().compareToIgnoreCase(arg1.getName());
      }
   }
}
