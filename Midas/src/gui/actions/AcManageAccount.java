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
import gui.utils.Positions;
import gui.utils.Positions.ScreenPosition;
import gui.views.JManageAccount;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import settings.Language.Text;
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
   
   private JManageAccount view;
   
   
   public AcManageAccount(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(final Core core, ActionEvent event, Object[] dependencies) {
      view = new JManageAccount(core);
      view.setTitle(Text.APP_TITLE.toString() + " - " + Text.ACCOUNT_MANAGEMENT_TITLE);
      view.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);
      
      view.addButtonAddListener(new AcCreateAccount(core));
      
      view.addButtonModifyListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            core.saveAccount(view.getSelectedValue());
         }
      });
      
      view.addButtonDeleteListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            core.deactivateAccount(view.getSelectedValue());
            view.updateModel();
         }
      });
      
      // ATTENTION  : le réglage de la modalité doit être fait après la paramétrisation de la fenêtre !
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }

}
