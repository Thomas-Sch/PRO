/* ============================================================================
 * Nom du fichier   : ComboBoxesCategory.java
 * ============================================================================
 * Date de création : 14 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.controller;

import gui.Controller;
import gui.actions.AcCreateCategory;
import gui.component.JComboBoxesCategory;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Core;
import core.components.Category;
import core.components.CategoryList;

/**
 * Contrôleur pour les deux listes déroulantes de catégories.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class ComboBoxesCategory extends Controller {
   
   JComboBoxesCategory view;
   CategoryList model;
   CategoryList children;

   /**
    * @param core
    */
   public ComboBoxesCategory(Core core) {
      super(core);
      model.addObserver(view);
   }

   /* (non-Javadoc)
    * @see gui.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      model = getCore().getAllPrimaryCategories();
      children = new CategoryList(getCore());
      view = new JComboBoxesCategory(this);
   }

   /* (non-Javadoc)
    * @see gui.Controller#initListeners()
    */
   @Override
   protected void initListeners() {
      view.addSelectChangedPrimaryListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if (view.isCreateNewCategorySelected()) {
               AcCreateCategory action = new AcCreateCategory(getCore());
               action.actionPerformed(arg0);
               view.setSelectedCategory(action.getCreatedCategory());
            }
         }
      });
   }

   /* (non-Javadoc)
    * @see gui.Controller#getGraphicalComponent()
    */
   @Override
   public Component getGraphicalComponent() {
      return view;
   }
   
   public CategoryList getPrimaryCategories() {
      return model;
   }
   
   public CategoryList getChildren(Category category) {
      return getCore().getChildren(category);
   }

}
