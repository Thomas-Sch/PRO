/* ============================================================================
 * Nom du fichier   : JCategoryList.java
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
package gui.component.list;

import gui.View;

import java.awt.Dimension;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

import core.components.Category;
import core.components.CategoryList;

/**
 * Classe représentant une liste de catégories.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JCategoryList extends JList<Category> implements View{

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -8841502612212684097L;
   
   private CategoryList categories;
   /**
    * Constructeur par défaut.
    */
   public JCategoryList(CategoryList categories) {
      this.categories = categories;
      update(categories, null);  
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      LinkedList<Category> list = categories.getAll(new SortByName());
      
      Category[] temp = new Category[0];
      setModel(new DefaultComboBoxModel<Category>(list.toArray(temp)));
   }
   
   private class SortByName implements Comparator<Category> {
      @Override
      public int compare(Category arg0, Category arg1) {
         return arg0.getName().compareToIgnoreCase(arg1.getName());
      }
   }
   
   /**
    * Retourne les dimensions préférées de la liste.
    */
   public Dimension getPreferredSize() {
      return new Dimension(200, 50);
   }

}
