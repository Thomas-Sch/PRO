/* ============================================================================
 * Nom du fichier   : ComboBoxCategory.java
 * ============================================================================
 * Date de création : 16 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component;

import gui.JComboBoxTemplate;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;

import core.components.Category;
import core.components.CategoryList;

/**
 * Liste déroulante de catégorie.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JComboBoxCategory extends JComboBoxTemplate<Category> {
   
   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 9189481079308834687L;
   
   private CategoryList categories;
   
   public JComboBoxCategory(CategoryList categories) {
      this.categories = categories;
      update(categories, null);
   }

   public void update(Observable o, Object arg) {
      LinkedList<Category> list = categories.getAll(new SortByName());
      
      if(isFirstUse()) {
         list.addFirst(categories.createFalseEntry("Sélectionner une catégorie")); // TO UPDATE
      }
      
      int index = updateIndex();
      list.add(index, categories.createFalseEntry("Nouvelle catégorie...")); // TO UPDATE
      
      Category[] temp = new Category[0];
      setModel(new DefaultComboBoxModel<Category>(list.toArray(temp)));
   }
   
   private class SortByName implements Comparator<Category> {
      @Override
      public int compare(Category arg0, Category arg1) {
         return arg0.getName().compareToIgnoreCase(arg1.getName());
      }
   }  
}
