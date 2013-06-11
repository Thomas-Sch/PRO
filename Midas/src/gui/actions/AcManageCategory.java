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

import gui.UserAction;
import gui.utils.Positions;
import gui.utils.Positions.ScreenPosition;
import gui.views.JManageCategory;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import settings.Language.Text;
import core.Core;

/**
 * Action / contrôleur de l'action s'occupant de la gestion des catégories.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class AcManageCategory extends UserAction {

   private JManageCategory view;

   /**
    * Crée une nouvelle action qui va gérer les modifications des catégories.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public AcManageCategory(Core core) {
      super(core);
   }

   @Override
   protected void execute(final Core core, ActionEvent event,
         Object[] dependencies) {
      view = new JManageCategory(core);
      view.setTitle(Text.APP_TITLE.toString() + " - "
            + Text.CATEGORY_MANAGEMENT_TITLE);
      view.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);

      initListeners(core);

      // ATTENTION : le réglage de la modalité doit être fait après la
      // paramétrisation de la fenêtre !
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }

   /**
    * Initialise les écouteurs de l'action.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   private void initListeners(final Core core) {
      view.addButtonAddListener(new AcCreateCategory(core));

      view.addButtonModifyListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            view.saveItem();
            core.saveCategory(view.getSelectedValue());
         }
      });

      view.addButtonDeleteListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            core.deactivateCategory(view.getSelectedValue(),
                  view.getCategoryList());
            view.selectNoItem();
            view.updateModel();
         }
      });
   }

}
