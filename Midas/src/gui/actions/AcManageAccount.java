/* ============================================================================
 * Nom du fichier   : AcManageAccount.java
 * ============================================================================
 * Date de création : 7 mai 2013
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
import gui.controller.ManageAccount;
import gui.views.JAddAccountFrame;

import java.awt.event.ActionEvent;

import core.Core;

/**
 * Contrôleur pour l'ajout, modification et consultation des comptes.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcManageAccount extends UserAction {
   
   JAddAccountFrame view;
   
   public AcManageAccount(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      
      new ManageAccount(core);
      
//      // Devra aller dans le contrôleur pour un nouveau compte.
//      view = new JAddAccountFrame((Component)event.getSource());
//      view.setDefaultThreshold(0);
//      view.setModalityType(ModalityType.APPLICATION_MODAL);
//      view.setVisible(true);
   }

}
