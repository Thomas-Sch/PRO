/* ============================================================================
 * Nom du fichier   : AcCreateSubCategory.java
 * ============================================================================
 * Date de création : 18 mai 2013
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
import java.awt.event.ActionListener;

import settings.Language.Text;

import core.Core;
import core.components.Category;
import core.components.CategoryList;
import gui.UserAction;
import gui.utils.Positions;
import gui.utils.Positions.ScreenPosition;
import gui.views.JCreateCategory;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcCreateSubCategory extends UserAction {
   
   private Category parent;
   private Category category;
   private CategoryList list;
   private JCreateCategory view;

   /**
    * @param core
    * @param dependencies
    */
   public AcCreateSubCategory(Core core, Category parent, CategoryList list) {
      super(core, parent);
      this.parent = parent;
      this.list = list;
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      // Récupération du modèle
      category = core.createCategory();      
      // Vue
      view = new JCreateCategory((Component)event.getSource(), category);
      view.setTitle(Text.APP_TITLE.toString() + " - " + Text.SUBCATEGORY_CREATION_TITLE.toString());
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);
      
      view.addValidateListener(new UserAction(core) {
         @Override
         protected void execute(Core core, ActionEvent event, Object[] dependencies) {
            category.setParentCategory(parent);
            core.saveSubCategory(category, list);
            view.dispose();
         }
      });
      
      view.addCancelListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            view.dispose();
         }
      });
      
      category.addObserver(view);
      
      // ATTENTION  : le réglage de la modalité doit être fait après la paramétrisation de la fenêtre !
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }
   
   public Category getCreatedCategory() {
      return category;
   }

}
