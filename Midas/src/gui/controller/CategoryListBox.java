/* ============================================================================
 * Nom du fichier   : CategoryListBox.java
 * ============================================================================
 * Date de création : 26 mai 2013
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
import gui.component.list.JCategoryList;

import java.awt.Component;

import javax.swing.event.ListSelectionListener;

import core.Core;
import core.components.Category;
import core.components.CategoryList;

/**
 * Classe de contrôle pour les listesbox de catégories.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class CategoryListBox extends Controller {

   JCategoryList view;
   CategoryList model;
   
   /**
    * @param core
    */
   public CategoryListBox(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see gui.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      model = getCore().getAllPrimaryCategories();
      view = new JCategoryList(model);
      model.addObserver(view);
   }

   /* (non-Javadoc)
    * @see gui.Controller#initListeners()
    */
   @Override
   protected void initListeners() {
   }

   /* (non-Javadoc)
    * @see gui.Controller#getGraphicalComponent()
    */
   @Override
   public Component getGraphicalComponent() {
      return view;
   }
   
   /**
    * Retourne la catégorie selectionné dans la liste.
    * @return La catégorie selectionné.
    */
   public Category getSelectedValue() {
      return view.getSelectedValue();
   }

   public void updateModel() {
      model.setChangedAndNotifyObservers();
   }
   
   public void addSelectionChangedListener(ListSelectionListener listener) {
      view.addListSelectionListener(listener);
   }

}
