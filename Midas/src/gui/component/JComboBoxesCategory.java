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
package gui.component;

import java.util.Observable;

import gui.View;

import javax.swing.JPanel;

import core.components.CategoryList;

/**
 * Conteneur pour les listes box de catégories.
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
   
   public JComboBoxCategory(CategoryList categories) {
      this.categories = categories;
      update(categories, null);
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      // TODO Auto-generated method stub

   }

}
