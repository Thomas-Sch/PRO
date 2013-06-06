/* ============================================================================
 * Nom du fichier   : AcNewTransaction.java
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
import gui.utils.Positions;
import gui.utils.Positions.ScreenPosition;
import gui.views.JNewTransaction;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import settings.Language.Text;
import core.Core;
import core.components.FinancialTransaction;
import core.exceptions.AmountUnavailable;

/**
 * Contrôleur et action de l'ajout d'une transaction.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcNewTransaction extends UserAction {
   
   private JNewTransaction view;
   private Controller controller;
   
   private FinancialTransaction transaction;

   /**
    * Crée une nouvelle action qui va gérer l'ajout d'une transaction.
    * @param core Va permettre d'interagir avec la base de donnée.
    * @param controller Contrôleur qui a appelé cette action.
    */
   public AcNewTransaction(Core core, Controller controller) {
      super(core);
      this.controller = controller;
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      transaction = core.createFinancialTransaction();
      
      view = new JNewTransaction(controller, transaction);
      view.setTitle(Text.APP_TITLE.toString() + " - " + Text.TRANSACTION_CREATION_TITLE);
      view.setResizable(false);
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);
      
      initListeners(core);

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
               transaction.setDate(view.getDate());
               core.saveFinancialTransaction(transaction);
            } catch (AmountUnavailable e) {
               new AccountBankruptcy(e);
            }
            view.dispose();
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
