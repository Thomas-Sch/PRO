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
 * Conteneur pour les combobox de catégories.
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
   
   public JComboBoxesCategory(ComboBoxesCategory controller) {
      this.controller = controller;
      initContent();
      buildContent();
   }
   
   public void initContent() {
      cbcPrimary = new JComboBoxCategory(controller.getPrimaryCategories());
      cbcChildren = new JComboBoxCategory(controller.getChildrenCategories(), true);
      cbcChildren.setVisible(false);
   }
   public void buildContent() {
      setLayout(new GridLayout(1,2,10,0));
      add(cbcPrimary);
      add(cbcChildren);
   }
   
   /**
    * Renvoi l'item sélectionné dans la liste de catégories principales.
    * @return La catégorie sélectionnée.
    */
   public Category getSelectedPrimaryItem() {
      return (Category)cbcPrimary.getSelectedItem();
   }
   
   /**
    * Renvoi l'item sélectionné dans la liste de catégories enfant.
    * @return La catégorie sélectionnée.
    */
   public Category getSelectedChildItem() {
      return (Category)cbcChildren.getSelectedItem();
   }
   
   public boolean isCreateNewItemSelected() {
      return cbcPrimary.isCreateNewSelected();      
   }
   
   public boolean isPrimaryInviteSelected() {
      return cbcPrimary.isInviteSelected();
   }
   
   public boolean isCreateNewChildCategorySelected() {
      return cbcChildren.isCreateNewSelected();
   }
   
   /**
    * Renvoie si l'item sélectionné dans la slite n'est pas un invite d'action.
    * @return true si l'item sélectioné est valide.
    */
   public boolean isValidPrimaryItemSelected() {
      return cbcPrimary.isValidItemSelected();
   }
   
   /**
    * Renvoie si l'item sélectionné dans la liste n'est pas un
    * invite d'action.
    * @return true si l'item sélectionné est valide.
    */
   public boolean isValidChildItemSelected() {
      return cbcChildren.isValidItemSelected();
   }
   
   /**
    * Force la sélection d'un item dans le composant.
    * @param category Item que l'on veut voir sélectionné.
    */
   public void setSelectedPrimaryItem(Category category) {
      cbcPrimary.setSelectedItem(category);
   }
   
   /**
    * Force la sélection d'un item dans le composant.
    * @param category Item que l'on veut voir sélectionné.
    */
   public void setSelectedChildItem(Category category) {
      cbcChildren.setSelectedItem(category);
   }
   
   /**
    * Ajout un écouteur de changement de sélection sur la liste déroulante
    * de catégorie principale.
    * @param listener l'écouteur ajouté au composant.
    */
   public void addSelectChangedPrimaryListener(ActionListener listener) {
      cbcPrimary.addActionListener(listener);
   }
   
   /**
    * Ajout un écouteur de changement de sélection sur la liste déroulante
    * de catégorie secondaire.
    * @param listener l'écouteur ajouté au composant.
    */
   public void addSelectChangedChildrenListener(ActionListener listener) {
      cbcChildren.addActionListener(listener);
   }
      
   /**
    * Rends la liste déroulante de sélection de catégories secondaires invisible.
    * @param visible
    */
   public void setChildrenVisible(boolean visible) {
      cbcChildren.setVisible(visible);
   }
   
   /**
    * Définit les catégories que doit afficher le liste déroulante secondaire.
    * @param categories Catégories à afficher.
    */
   public void setChildrenData(CategoryList categories) {
      cbcChildren.setData(categories);
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      cbcPrimary.update(arg0, arg1);
      cbcChildren.update(arg0, arg1);
   }
}
