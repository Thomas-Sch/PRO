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
import gui.alert.AccountBankruptcy;
import gui.alert.BadDate;
import gui.alert.NegativeBudget;
import gui.component.JQuickExpense;
import gui.exception.BadDateException;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Core;
import core.components.FinancialTransaction;
import core.exceptions.AmountUnavailableException;

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
            try {
               expense.setDate(view.getDate());
               expense.setAccount(expense.getBudget().getBindedAccount());
               
               // On regarde si le budget était tenu avant.
               boolean wasPositive = expense.getBudget().isPositive();
               
               getCore().saveFinancialTransaction(expense);
               view.reset();
               if(wasPositive && !expense.getBudget().isPositive()) {
                  new NegativeBudget(expense.getBudget());
               }
            }
            catch (AmountUnavailableException e) {
               new AccountBankruptcy(e);
            }
            catch (BadDateException e) {
              new BadDate(e);
            }
            
         }
      });
   }

   @Override
   public Component getGraphicalComponent() {
      return view;
   }
}
