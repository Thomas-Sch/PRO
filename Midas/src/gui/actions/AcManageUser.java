/* ============================================================================
 * Nom du fichier   : AcManageUser.java
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
import gui.utils.Positions;
import gui.utils.Positions.ScreenPosition;
import gui.views.JManageUser;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import settings.Language.Text;
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
public class AcManageUser extends UserAction {
   
   private JManageUser view;
   /**
    * @param core
    * @param dependencies
    */
   public AcManageUser(Core core, Controller controller, Object[] dependencies) {
      super(core, dependencies);
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(final Core core, ActionEvent event, Object[] dependencies) {
      view = new JManageUser(core);
      view.setTitle(Text.APP_TITLE.toString() + " - " + Text.USER_MANAGEMENT_TITLE);
      view.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);
      
      view.addButtonAddListener(new AcCreateUser(core));
      
      view.addButtonModifyListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            core.saveUser(view.getSelectedUser());
         }
      });
      
      view.addButtonDeleteListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            core.deactivateUser(view.getSelectedUser());
            view.updateModel();
         }
      });
      
      // ATTENTION  : le réglage de la modalité doit être fait après la paramétrisation de la fenêtre !
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }

}
