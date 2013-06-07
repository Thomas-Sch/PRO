/* ============================================================================
 * Nom du fichier   : AcNewExpense.java
 * ============================================================================
 * Date de création : 10 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.actions;

import gui.Controller;
import gui.UserAction;
import gui.alert.AccountBankruptcy;
import gui.alert.BadDate;
import gui.alert.NegativeBudget;
import gui.exception.BadDateException;
import gui.utils.Positions;
import gui.utils.Positions.ScreenPosition;
import gui.views.JNewExpense;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import settings.Language.Text;
import core.Core;
import core.components.FinancialTransaction;
import core.exceptions.AmountUnavailableException;

/**
 * Contrôleur et action de l'ajout d'une dépense.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcNewExpense extends UserAction {
   
   private FinancialTransaction expense;
   private Controller controller;
   private JNewExpense view;

   /**
    * Crée une nouvelle action qui va gérer l'ajout d'une dépense.
    * @param core Va permettre d'interagir avec la base de donnée.
    * @param controller Contrôleur qui a appelé cette action.
    */
   public AcNewExpense(Core core, Controller controller) {
      super(core);
      this.controller = controller;
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      expense = core.createFinancialTransaction();
      
      // Réglages de la fenêtre.
      view = new JNewExpense(controller, expense);
      view.setTitle(Text.APP_TITLE.toString() + " - " + Text.EXPENSE_CREATION_TITLE.toString());
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);
      view.setResizable(false);
      
      initListeners(core);
   
      expense.addObserver(view);
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }
   
   /**
    * Initialise les listeners de cette action.
    * @param core Coeur logique de l'application.
    */
   private void initListeners(Core core) {
      view.addValidateListener(new UserAction(core) {
         @Override
         protected void execute(Core core, ActionEvent event, Object[] dependencies) {
            try {               
               expense.setDate(view.getDate());
               expense.setAccount(expense.getBudget().getBindedAccount());
               
               // On regarde si le budget était tenu avant.
               boolean wasPositive = expense.getBudget().isPositive();
               core.saveFinancialTransaction(expense);
               view.dispose();
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
      
      view.addCancelListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent arg0) {
            view.dispose();
         }
      });
   }
}
