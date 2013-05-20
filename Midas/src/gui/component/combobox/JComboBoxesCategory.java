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

import java.awt.FlowLayout;
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
      setLayout(new FlowLayout(FlowLayout.LEFT, 5,0));
      add(cbcPrimary);
      add(cbcChildren);
   }
   
   public Category getSelectedPrimaryCategory() {
      return (Category)cbcPrimary.getSelectedItem();
   }
   
   public boolean isCreateNewCategorySelected() {
      return cbcPrimary.isCreateNewSelected();      
   }
   
   public boolean isPrimaryInviteSelected() {
      return cbcPrimary.isInviteSelected();
   }
   
   public boolean isCreateNewSubCategorySelected() {
      return cbcChildren.isCreateNewSelected();
   }
   
   public void setSelectedCategory(Category category) {
      cbcPrimary.setSelectedItem(category);
   }
   
   public void setSelectedSubCategory(Category category) {
      cbcChildren.setSelectedItem(category);
   }
   
   public void addSelectChangedPrimaryListener(ActionListener listener) {
      cbcPrimary.addActionListener(listener);
   }
   
   public void addSelectChangedChildrenListener(ActionListener listener) {
      cbcChildren.addActionListener(listener);
   }
   
   public void setChildrenVisible(boolean visible) {
      cbcChildren.setVisible(visible);
   }
   
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
