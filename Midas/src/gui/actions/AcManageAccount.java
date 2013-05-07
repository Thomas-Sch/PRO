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

import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;

import core.Core;
import gui.JNewAccountFrame;
import gui.UserAction;

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
   
   JNewAccountFrame view;
   
   public AcManageAccount(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      
      // Devra aller dans le contrôleur pour un nouveau compte.
      view = new JNewAccountFrame((Component)event.getSource());
      view.setDefaultThreshold(0);
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }

}
