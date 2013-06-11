/* ============================================================================
 * Nom du fichier   : AcCreateAccount.java
 * ============================================================================
 * Date de création : 22 avr. 2013
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
import gui.views.JCreateCategory;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import settings.Language.Text;
import core.Core;
import core.components.Category;

/**
 * Action qui gère la création d'une catégorie.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class AcCreateCategory extends UserAction {

   private Category category;
   private JCreateCategory view;

   /**
    * Crée l'action créant une catégorie.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public AcCreateCategory(Core core) {
      super(core);
   }

   @Override
   public void execute(Core core, ActionEvent event, Object[] dependencies) {

      // Récupération du modèle
      category = core.createCategory();
      // Vue
      view = new JCreateCategory(category);
      view.setTitle(Text.APP_TITLE.toString() + " - "
            + Text.CATEGORY_CREATION_TITLE.toString());
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);
      view.setResizable(false);

      initListeners(core);

      category.addObserver(view);

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
   public void initListeners(Core core) {
      view.addValidateListener(new UserAction(core) {
         @Override
         protected void execute(Core core, ActionEvent event,
               Object[] dependencies) {
            core.saveCategory(category);
            view.dispose();
         }
      });

      view.addCancelListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            view.dispose();
         }
      });
   }

   /**
    * Retourne la catégorie créée.
    * 
    * @return La catégorie créée.
    */
   public Category getCreatedCategory() {
      return category;
   }
}
