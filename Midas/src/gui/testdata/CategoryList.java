/* ============================================================================
 * Nom du fichier   : CategoryList.java
 * ============================================================================
 * Date de création : 21 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.testdata;

import gui.JListTemplate;

import javax.swing.DefaultListModel;


/**
 * Liste de catégorie avec les boutons pour modifier les entrées.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class CategoryList extends JListTemplate {
   
   /**
    * ID de série.
    */
   private static final long serialVersionUID = -7682417283987969152L;

   /* (non-Javadoc)
    * @see gui.component.ListTemplate#setData(javax.swing.DefaultListModel)
    */
   @Override
   protected void setData(DefaultListModel<String> dlm) {
      for(String s : new CategoryData().getList()) {
         dlm.addElement(s);
      }        
   }
}
