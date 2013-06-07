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
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class FinancialTransactionListBox extends Controller {

   JFinancialTransactionList view;
   FinancialTransactionList model;
   /**
    * @param core
    */
   public FinancialTransactionListBox(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see gui.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      model = getCore().getLastFinancialTransactions();
      view = new JFinancialTransactionList(model);
      model.addObserver(view);
   }

   /* (non-Javadoc)
    * @see gui.Controller#initListeners()
    */
   @Override
   protected void initListeners() {

   }

   /* (non-Javadoc)
    * @see gui.Controller#getGraphicalComponent()
    */
   @Override
   public Component getGraphicalComponent() {
      return view;
   }

}
