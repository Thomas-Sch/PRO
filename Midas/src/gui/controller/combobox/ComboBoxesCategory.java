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
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class ComboBoxesCategory extends Controller {

   private JComboBoxesCategory view;
   private CategoryList model;
   private CategoryList children;

   /**
    * Crée le contrôleur des deux listes déroulantes de catégories.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public ComboBoxesCategory(Core core) {
      super(core);
      model.addObserver(view);
      children.addObserver(view);
   }

   @Override
   protected void initComponents() {
      model = getCore().getAllPrimaryCategories();
      children = new CategoryList(getCore());
      view = new JComboBoxesCategory(this);
   }

   @Override
   protected void initListeners() {
      view.addSelectChangedPrimaryListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (view.isCreateNewItemSelected()) {
               AcCreateCategory action = new AcCreateCategory(getCore());
               action.actionPerformed(e);
               view.setSelectedPrimaryItem(action.getCreatedCategory());
            }
            else if (view.isPrimaryInviteSelected()) {
               view.setChildrenVisible(false);
            }
            else {
               Category parent = view.getSelectedPrimaryItem();
               CategoryList p = getCore().getChildren(parent);
               children.setItems(p.getList());
               view.setSelectedPrimaryItem(parent);
               view.setChildrenVisible(true);
            }
         }
      });

      view.addSelectChangedChildrenListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (view.isCreateNewChildCategorySelected()) {
               Category temp = view.getSelectedPrimaryItem();

               AcCreateSubCategory action = new AcCreateSubCategory(getCore(),
                     temp, children);
               action.actionPerformed(e);

               view.setSelectedChildItem(action.getCreatedCategory());
               view.setSelectedPrimaryItem(temp);
            }
         }
      });
   }

   @Override
   public Component getGraphicalComponent() {
      return view;
   }

   /**
    * Retourne la liste des catégories primaires.
    * 
    * @return La liste des catégories primaires.
    */
   public CategoryList getPrimaryCategories() {
      return model;
   }

   /**
    * Retourne la liste des sous-catégories.
    * 
    * @return La liste des sous-catégories.
    */
   public CategoryList getChildrenCategories() {
      return children;
   }

   /**
    * Ajoute un écouteur de changement de sélection sur la vue.
    * 
    * @param listener
    *           - l'écouteur ajouté.
    */
   public void addSelectedChangedListener(ActionListener listener) {
      view.addSelectChangedPrimaryListener(listener);
      view.addSelectChangedChildrenListener(listener);
   }

   /**
    * Renvoie l'item sélectionné dans l'interface.
    * 
    * @return l'item sélectionné dans l'interface.
    */
   public Category getSelectedItem() {

      // On regarde ce que l'utilisateur à sélectionné : Catégorie simple ou
      // sous catégorie ?
      if (view.isValidPrimaryItemSelected()) {
         if (view.isValidChildItemSelected()) {
            return view.getSelectedChildItem();
         }
         // Si aucune catégorie enfant n'est sélectionnée alors on renvoi
         // la catégorie parente.
         return view.getSelectedPrimaryItem();
      }
      return null;
   }

   /**
    * Test et retourne si l'élément sélectionné dans la liste est actuellement
    * un compte et pas un libellé d'invitation.
    * 
    * @return Vrai si un compte est sélectionné, Faux le cas échéant.
    */
   public boolean isValidItemSelected() {
      return view.isValidPrimaryItemSelected();
   }

   /**
    * Force le composant graphique à sélectionner l'invite d'action.
    */
   public void setInviteSelected() {
      view.setInviteSelected();
   }
}
