/* ============================================================================
 * Nom du fichier   : FinancialTransactionListBox.java
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
package gui.controller.listbox;

import gui.Controller;
import gui.component.list.JFinancialTransactionList;

import java.awt.Component;

import core.Core;
import core.components.FinancialTransactionList;

/**
 * Contrôleur de la liste des transactions financières.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class FinancialTransactionListBox extends Controller {

   private JFinancialTransactionList view;
   private FinancialTransactionList model;

   /**
    * Crée le contrôleur du de la liste des transactions financières.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public FinancialTransactionListBox(Core core) {
      super(core);
   }

   @Override
   protected void initComponents() {
      model = getCore().getLastFinancialTransactions();
      view = new JFinancialTransactionList(model);
      model.addObserver(view);
   }

   @Override
   protected void initListeners() {
      // Aucun pour l'instant
   }

   @Override
   public Component getGraphicalComponent() {
      return view;
   }
}
