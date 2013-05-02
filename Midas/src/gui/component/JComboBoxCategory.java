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

import gui.testdata.CategoryData;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JComboBoxCategory extends JComboBox<Object> {
   private static final long serialVersionUID = 1L;
   
   public JComboBoxCategory() {
      
      ArrayList<String> data = new ArrayList<>();
      
      CategoryData dataModel = new CategoryData();
      
      data.add("Sélectionner une catégorie");
      for (String s : dataModel.getList()) {
         data.add(s);
      }
      
      data.add("Nouvelle catégorie...");
      
      
      setModel(new DefaultComboBoxModel<Object>(data.toArray()));
   }
}
