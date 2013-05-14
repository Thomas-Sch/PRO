/* ============================================================================
 * Nom du fichier   : AcCreateAccount.java
 * ============================================================================
 * Date de création : 9 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.actions;

import gui.UserAction;
import gui.views.JCreateAccountFrame;

import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Core;
import core.MidasLogs;
import core.components.Account;

/**
 * Action de création de compte. Contrôle également la fenêtre d'ajout
 * de compte.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcCreateAccount extends UserAction {
   
   private Account account;
   private JCreateAccountFrame view;

   /**
    * @param core
    * @param dependencies
    */
   public AcCreateAccount(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      account = core.createAccount();
            
      view = new JCreateAccountFrame((Component)event.getSource(), account);
      
      view.addValidateListener(new UserAction(core) {
         @Override
         protected void execute(Core core, ActionEvent event, Object[] dependencies) {
            core.saveAccount(account);
            view.dispose();
         }
      });
      
      view.addCancelListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent arg0) {
            view.dispose();
         }
      });
      
      account.addObserver(view);
      
      // ATTENTION  : le réglage de la modalité doit être fait après la paramétrisation de la fenêtre !
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }
   
   public Account getCreatedAccount() {
      return account;
   }
}
