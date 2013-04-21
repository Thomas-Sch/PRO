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
package gui.component;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * Liste de catégorie avec les boutons pour modifier les entrées.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class CategoryList extends JPanel {
   
   /**
    * ID de série.
    */
   private static final long serialVersionUID = -7682417283987969152L;
   
   DefaultListModel<String> dlmModel = new DefaultListModel<>();
   JList<String> lstCategory = new JList<>(dlmModel);
   
   
   /**
    * 
    */
   public CategoryList() {
      
      // Contenu de la liste.
      for(int i = 0; i < 10; ++i) {
         dlmModel.addElement("Cat" + (i + 1));
      }
      
      GridBagConstraints gblConstraints = new GridBagConstraints();
      setLayout(new GridBagLayout());
      
      gblConstraints.fill = GridBagConstraints.HORIZONTAL;
      gblConstraints.gridx = 0;
      gblConstraints.gridy = 0;
      add(lstCategory, gblConstraints);
      
      gblConstraints.gridy = 1;
      add(new NewEditDelete(), gblConstraints);
   }


}
