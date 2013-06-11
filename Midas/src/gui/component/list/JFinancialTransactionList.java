/* ============================================================================
 * Nom du fichier   : JFinancialTransactionList.java
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
package gui.component.list;

import gui.View;

import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

import core.components.FinancialTransaction;
import core.components.FinancialTransactionList;

/**
 * Composant graphique pour l'affichage des listes de transactions financières.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JFinancialTransactionList extends JList<FinancialTransaction>
      implements View {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -349345898946417973L;

   private FinancialTransactionList transactions;

   /**
    * Crée la vue d'une liste de transactions financières.
    */
   public JFinancialTransactionList(FinancialTransactionList transactions) {
      this.transactions = transactions;
      update(transactions, null);
   }

   @Override
   public void update(Observable arg0, Object arg1) {
      LinkedList<FinancialTransaction> list = transactions.getList();

      FinancialTransaction[] temp = new FinancialTransaction[0];
      setModel(new DefaultComboBoxModel<FinancialTransaction>(
            list.toArray(temp)));
   }
}
