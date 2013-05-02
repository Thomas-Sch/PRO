/* ============================================================================
 * Nom du fichier   : ManageCategoryFrame.java
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
package gui;

import gui.testdata.CategoryList;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;


/**
 * Fenêtre de gestion des catégories.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JManageCategoryFrame extends JManageFrame {

   /**
    * ID de série.
    */
   private static final long serialVersionUID = -3350759512131610325L;
   
   protected JPanel initContent() {
      super.initContent();
      
      getContent().add(new CategoryList(), getConstraints());
         
       getConstraints().gridx = 1;
       getConstraints().anchor = GridBagConstraints.NORTH;
       getConstraints().insets = new Insets(5, 50, 5, 5);
       
       getContent().add(new CategoryList(), getConstraints());
      
      return getContent();
   }
   
}
