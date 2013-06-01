/* ============================================================================
 * Nom du fichier   : QuickExpenseC.java
 * ============================================================================
 * Date de création : 29 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.controller;

import gui.Controller;
import gui.component.JQuickExpense;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Core;
import core.components.FinancialTransaction;

/**
 * Controleur pour le panel d'ajout de dépenses rapides.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class QuickExpense extends Controller{
   
   JQuickExpense view;
   FinancialTransaction expense;
   
   /**
    * 
    */
   public QuickExpense(Core core) {
      super(core);
   }
   
   @Override
   protected void initComponents() {
      expense = getCore().createFinancialTransaction();
      view = new JQuickExpense(this, expense);
   }
   
   @Override
   protected void initListeners() {
      view.addValidateListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent arg0) {
            expense.setDate(view.getDate());
            expense.setAccount(expense.getBudget().getBindedAccount());
            getCore().saveFinancialTransaction(expense);
            view.reset();
         }
      });
   }

   @Override
   public Component getGraphicalComponent() {
      return view;
   }
}
