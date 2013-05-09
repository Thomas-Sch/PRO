/* ============================================================================
 * Nom du fichier   : AcManageAuthor.java
 * ============================================================================
 * Date de création : 6 mai 2013
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
import gui.views.JManageAuthorFrame;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;

import core.Core;

/**
 * Action de management de la liste des auteurs.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcManageAuthor extends UserAction {

   JManageAuthorFrame view;
   /**
    * @param core
    * @param dependencies
    */
   public AcManageAuthor(Core core, Object[] dependencies) {
      super(core, dependencies);
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      view = new JManageAuthorFrame();

      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);

   }

}
