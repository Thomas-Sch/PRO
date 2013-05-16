/* ============================================================================
 * Nom du fichier   : AcManageCategory.java
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

import gui.Controller;
import gui.UserAction;
import gui.views.JManageCategoryFrame;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;

import settings.Language.Text;

import core.Core;

/**
 * Contrôleur de l'action la gestion des catégories.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcManageCategory extends UserAction {
   
   private JManageCategoryFrame view;
   private Controller controller;

   /**
    * @param core
    * @param dependencies
    */
   public AcManageCategory(Core core,Controller controller, Object[] dependencies) {
      super(core, dependencies);
      this.controller = controller;
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      view = new JManageCategoryFrame(controller);
      view.setTitle(Text.APP_TITLE.toString() + " - " + Text.CATEGORY_MANAGEMENT_TITLE);
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }

}
