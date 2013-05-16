/* ============================================================================
 * Nom du fichier   : ListTemplate.java
 * ============================================================================
 * Date de création : 22 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui;

import gui.component.JAddEditDelete;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import core.Core;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public abstract class JListTemplate extends JPanel {

   /**
    * ID de série.
    */
   private static final long serialVersionUID = -6145500497570831757L;
   
   private Controller controller;
   
   private DefaultListModel<String> dlmModel = new DefaultListModel<>();
   private JList<String> lstCategory = new JList<>(dlmModel);
   
   public JListTemplate(Controller controller) {
      this.controller = controller;
      
      setData(dlmModel);
      
      GridBagConstraints gblConstraints = new GridBagConstraints();
      setLayout(new GridBagLayout());
      
      gblConstraints.fill = GridBagConstraints.HORIZONTAL;
      gblConstraints.gridx = 0;
      gblConstraints.gridy = 0;
      add(lstCategory, gblConstraints);
      
      gblConstraints.gridy = 1;
      add(new JAddEditDelete(), gblConstraints);
   }
   
   protected Core getCore() {
      return controller.getCore();
   }
   
   protected abstract void setData(DefaultListModel<String> dlm);

}
