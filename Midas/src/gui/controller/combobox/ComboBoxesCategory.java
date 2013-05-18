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
package gui.controller.combobox;

import gui.Controller;
import gui.actions.AcCreateCategory;
import gui.actions.AcCreateSubCategory;
import gui.component.combobox.JComboBoxesCategory;

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
      children.addObserver(view);
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
         public void actionPerformed(ActionEvent e) {
            if (view.isCreateNewCategorySelected()) {
               AcCreateCategory action = new AcCreateCategory(getCore());
               action.actionPerformed(e);
               view.setSelectedCategory(action.getCreatedCategory());
            }else if(view.isPrimaryInviteSelected()) {
               view.setChildrenVisible(false);
            }else {
               Category parent = view.getSelectedPrimaryCategory();
               CategoryList p = getCore().getChildren(parent);
               children.setItems(p.getList());
               view.setSelectedCategory(parent);
               view.setChildrenVisible(true);
            }
         }
      });
      
      view.addSelectChangedChildrenListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (view.isCreateNewSubCategorySelected()) {
               Category temp = view.getSelectedPrimaryCategory();
              
               AcCreateSubCategory action = new AcCreateSubCategory(getCore(), temp, children);
               action.actionPerformed(e);
               
               Category ret = action.getCreatedCategory();
               
               System.out.println(ret.getName());
               
               view.setSelectedSubCategory(ret);
               view.setSelectedCategory(temp);
               
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
   
   public CategoryList getChildrenCategories() {
      return children;
   }
}
