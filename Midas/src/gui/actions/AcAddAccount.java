/* ============================================================================
 * Nom du fichier   : AcAddAccount.java
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

import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;

import core.Core;
import gui.UserAction;
import gui.views.JAddAccountFrame;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcAddAccount extends UserAction {
   
   JAddAccountFrame view;

   /**
    * @param core
    * @param dependencies
    */
   public AcAddAccount( Core core, Component parent, Object[] dependencies) {
      super(core, dependencies);
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      view = new JAddAccountFrame((Component)event.getSource());
      view.setDefaultThreshold(0);
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }
}
