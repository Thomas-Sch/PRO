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

import gui.component.CategoryList;
import gui.component.NewEditDelete;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;

import javax.crypto.spec.GCMParameterSpec;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import settings.Language.Text;

/**
 * Fenêtre de gestion des catégories.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class ManageCategoryFrame extends JDialog {

   /**
    * ID de série.
    */
   private static final long serialVersionUID = -3350759512131610325L;
   
   public ManageCategoryFrame() {
      setTitle(Text.APP_TITLE.toString());
      setVisible(true);
      setLocationRelativeTo(null);
      
      setContentPane(getContent());
      
      pack();
 
   }
   
   private JPanel getContent() {
      JPanel pnlContent = new JPanel();
      
      GridBagConstraints gbcConstraints = new GridBagConstraints();
      gbcConstraints.insets = new Insets(5, 5, 5, 5);
//      gbcConstraints.fill = GridBagConstraints.BOTH;
      gbcConstraints.weightx = 0.0;
      gbcConstraints.weighty = 0.5;
      
      pnlContent.setLayout(new GridBagLayout());
      
      gbcConstraints.gridx = 0;
      gbcConstraints.gridy = 0;

      gbcConstraints.anchor = GridBagConstraints.NORTH;
      
      pnlContent.add(new CategoryList(), gbcConstraints);
      
      gbcConstraints.gridx = 1;
      gbcConstraints.anchor = GridBagConstraints.NORTH;
      gbcConstraints.insets = new Insets(5, 50, 5, 5);
      
      pnlContent.add(new CategoryList(), gbcConstraints);
      
      return pnlContent;
   }
   

}
