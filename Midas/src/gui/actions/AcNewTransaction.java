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
import gui.utils.Positions;
import gui.utils.Positions.ScreenPosition;
import gui.views.JNewTransaction;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import settings.Language.Text;

import core.Core;
import core.components.FinancialTransaction;

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
    * @param core
    * @param dependencies
    */
   public AcNewTransaction(Core core, Controller controller, Object[] dependencies) {
      super(core, dependencies);
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
   
   private void initListeners(Core core) {
      view.addValidateListener(new UserAction(core) {
         @Override
         protected void execute(Core core, ActionEvent event, Object[] dependencies) {
            transaction.setDate(view.getDate());
            core.saveFinancialTransaction(transaction);
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
