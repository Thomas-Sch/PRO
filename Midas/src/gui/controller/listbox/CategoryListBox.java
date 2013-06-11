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
package gui.controller.listbox;

import gui.Controller;
import gui.component.list.JCategoryList;

import java.awt.Component;

import javax.swing.event.ListSelectionListener;

import core.Core;
import core.components.Category;
import core.components.CategoryList;

/**
 * Contrôleur pour une liste de catégories.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class CategoryListBox extends Controller {

   private JCategoryList view;
   private CategoryList model;

   /**
    * Crée le contrôleur de la liste des catégories.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public CategoryListBox(Core core) {
      super(core);
   }

   @Override
   protected void initComponents() {
      model = getCore().getAllCategories();
      view = new JCategoryList(model);
      model.addObserver(view);
   }

   @Override
   protected void initListeners() {
   }

   @Override
   public Component getGraphicalComponent() {
      return view;
   }

   /**
    * Retourne la catégorie sélectionnée dans la liste.
    * 
    * @return La catégorie sélectionnée.
    */
   public Category getSelectedValue() {
      return view.getSelectedValue();
   }

   /**
    * Force une mise à jour du modèle.
    */
   public void updateModel() {
      model.setChangedAndNotifyObservers();
   }

   /**
    * Ajoute un écouteur sur la liste de ce contrôleur.
    * 
    * @param listener
    *           - l'écouteur ajouté.
    */
   public void addSelectionChangedListener(ListSelectionListener listener) {
      view.addListSelectionListener(listener);
   }

   /**
    * Force la désélection sur la liste.
    */
   public void selectNoItem() {
      view.setSelectedIndex(-1);
      model.setChangedAndNotifyObservers();
   }

   /**
    * Retourne la liste des catégories de ce contrôleur.
    * 
    * @return La liste des catégories.
    */
   public CategoryList getList() {
      return model;
   }
}
