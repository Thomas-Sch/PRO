/* ============================================================================
 * Nom du fichier   : JComboBoxesCategory.java
 * ============================================================================
 * Date de création : 16 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component.combobox;

import gui.View;
import gui.controller.combobox.ComboBoxesCategory;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JPanel;

import core.components.Category;
import core.components.CategoryList;

/**
 * Conteneur pour les listes déroulantes de catégories.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JComboBoxesCategory extends JPanel implements View {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 1830925821518642587L;

   private JComboBoxCategory cbcPrimary;
   private JComboBoxCategory cbcChildren;
   private ComboBoxesCategory controller;

   /**
    * Crée la vue sur les listes déroulantes de catégories.
    * 
    * @param controller
    *           - le contrôleur appelant.
    */
   public JComboBoxesCategory(ComboBoxesCategory controller) {
      this.controller = controller;
      initContent();
      buildContent();
   }

   /**
    * Initialise les composants graphiques.
    */
   public void initContent() {
      cbcPrimary = new JComboBoxCategory(controller.getPrimaryCategories());
      cbcChildren = new JComboBoxCategory(controller.getChildrenCategories(),
            true);
      cbcChildren.setVisible(false);
   }

   /**
    * Construit et positionne les composants graphiques.
    */
   public void buildContent() {
      setLayout(new GridLayout(1, 2, 10, 0));
      add(cbcPrimary);
      add(cbcChildren);
   }

   /**
    * Retourne la catégorie sélectionnée dans la liste des catégories
    * principales.
    * 
    * @return La catégorie principale sélectionnée.
    */
   public Category getSelectedPrimaryItem() {
      return (Category) cbcPrimary.getSelectedItem();
   }

   /**
    * Retourne la catégorie sélectionnée dans la liste des sous-catégories.
    * 
    * @return La sous-catégorie sélectionnée.
    */
   public Category getSelectedChildItem() {
      return (Category) cbcChildren.getSelectedItem();
   }

   /**
    * Retourne si l'élément sélectionné correspond à l'action de création d'un
    * nouvel élément dans la liste des catégories primaires.
    * 
    * @return Vrai si l'élément sélectionné est celui d'une nouvelle création,
    *         Faux le cas échéant.
    */
   public boolean isCreateNewItemSelected() {
      return cbcPrimary.isCreateNewSelected();
   }

   /**
    * Retourne si l'élément sélectionné correspond à l'invite de saisie d'un
    * élément.
    * 
    * @return Vrai si l'élément sélectionné est l'invite, Faux le cas échéant.
    */
   public boolean isPrimaryInviteSelected() {
      return cbcPrimary.isInviteSelected();
   }

   /**
    * Retourne si l'élément sélectionné correspond à l'action de création d'un
    * nouvel élément dans la liste des sous-catégories.
    * 
    * @return Vrai si l'élément sélectionné est celui d'une nouvelle création,
    *         Faux le cas échéant.
    */
   public boolean isCreateNewChildCategorySelected() {
      return cbcChildren.isCreateNewSelected();
   }

   /**
    * Renvoie si l'élément sélectionné dans la liste de catégories primaires
    * n'est pas une invite d'action.
    * 
    * @return Vrai si l'élément sélectionné est valide, Faux le cas échéant.
    */
   public boolean isValidPrimaryItemSelected() {
      return cbcPrimary.isValidItemSelected();
   }

   /**
    * Renvoie si l'élément sélectionné dans la liste de sous-catégories n'est
    * pas une invite d'action.
    * 
    * @return Vrai si l'élément sélectionné est valide, Faux le cas échéant.
    */
   public boolean isValidChildItemSelected() {
      return cbcChildren.isValidItemSelected();
   }

   /**
    * Force la sélection d'un élément de la liste des catégories primaires.
    * 
    * @param category
    *           - l'élément que l'on veut voir sélectionné.
    */
   public void setSelectedPrimaryItem(Category category) {
      cbcPrimary.setSelectedItem(category);
   }

   /**
    * Force la sélection d'un élément de la liste des sous-catégories.
    * 
    * @param category
    *           - l'élément que l'on veut voir sélectionné.
    */
   public void setSelectedChildItem(Category category) {
      cbcChildren.setSelectedItem(category);
   }

   /**
    * Ajoute un écouteur de changement de sélection sur la liste déroulante de
    * catégorie principale.
    * 
    * @param listener
    *           - l'écouteur ajouté au composant.
    */
   public void addSelectChangedPrimaryListener(ActionListener listener) {
      cbcPrimary.addActionListener(listener);
   }

   /**
    * Ajoute un écouteur de changement de sélection sur la liste déroulante des
    * sous-catégories.
    * 
    * @param listener
    *           - l'écouteur ajouté au composant.
    */
   public void addSelectChangedChildrenListener(ActionListener listener) {
      cbcChildren.addActionListener(listener);
   }

   /**
    * Défini si la liste déroulante de sélection de catégories secondaires est
    * visible ou non.
    * 
    * @param visible
    *           - si la liste des catégories secondaire est visible ou non.
    */
   public void setChildrenVisible(boolean visible) {
      cbcChildren.setVisible(visible);
   }

   /**
    * Défini les catégories que doit afficher le liste déroulante secondaire.
    * 
    * @param categories
    *           - la liste des catégories à afficher.
    */
   public void setChildrenData(CategoryList categories) {
      cbcChildren.setData(categories);
   }

   @Override
   public void update(Observable arg0, Object arg1) {
      cbcPrimary.update(arg0, arg1);
      cbcChildren.update(arg0, arg1);
   }

   /**
    * Force le composant à sélectionner l'invite d'action.
    */
   public void setInviteSelected() {
      cbcPrimary.setInviteSelected();
   }
}
