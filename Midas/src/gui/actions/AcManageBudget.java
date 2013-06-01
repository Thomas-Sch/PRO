/* ============================================================================
 * Nom du fichier   : AcManageBudget.java
 * ============================================================================
 * Date de création : 1 juin 2013
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
import gui.views.JManageBudget;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import settings.Language.Text;
import core.Core;

/**
 * Lance et contrôle la fenêtre de management d'un budget.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcManageBudget extends UserAction {
   
   private JManageBudget view;

   /**
    * @param core
    * @param dependencies
    */
   public AcManageBudget(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      view = new JManageBudget(core);
      view.setTitle(Text.APP_TITLE.toString() + " - " + Text.BUDGET_MANAGEMENT_TITLE);
      view.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);
      
      initListeners(core);

      // ATTENTION  : le réglage de la modalité doit être fait après la paramétrisation de la fenêtre !
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }
   
   private void initListeners(final Core core) {
      view.addButtonAddListener(new AcCreateBudget(core));
      
      view.addButtonModifyListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            core.saveBudget(view.getSelectedValue());
         }
      });
      
      view.addButtonDeleteListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            core.deactivateBudget(view.getSelectedValue());
            view.updateModel();
         }
      });
      
   }

}
