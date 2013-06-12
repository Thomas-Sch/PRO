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
import gui.View;
import gui.component.list.JCategoryList;

import java.awt.Component;
import java.util.Observable;

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
public class CategoryListBox extends Controller implements View{
   private JCategoryList view;
   private CategoryList primary; // Liste des catégories primaires du Core.
   private CategoryList model; // Liste contenue dans la vue.
   
   /**
    * Crée le contrôleur de la liste des catégories.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public CategoryListBox(Core core) {
      super(core);
      // On observe la liste des catégories primaires afin de gérer nos 
      // composants graphiques.
      primary.addObserver(this);
   }

   @Override
   protected void initComponents() {
      primary = getCore().getAllPrimaryCategories();
      model = new CategoryList(getCore());
      initModel();

      view = new JCategoryList(model);
      
      model.addObserver(view);
   }
   
   private void initModel() {
      model.getList().clear();
      model.setItems(primary.getList());
      
      CategoryList allChilds = new CategoryList(getCore());
      
      for(Category c : model.getList()) {
         allChilds.addAll(getCore().getChildren(c));
      }
      
      model.addAll(allChilds);
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
      primary.setChangedAndNotifyObservers();
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
      primary.setChangedAndNotifyObservers();
   }

   /**
    * Retourne la liste des catégories de ce contrôleur.
    * 
    * @return La liste des catégories.
    */
   public CategoryList getList() {
      return model;
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      initModel();
   }
}
