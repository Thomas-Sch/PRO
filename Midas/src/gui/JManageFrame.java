/* ============================================================================
 * Nom du fichier   : ManageFrame.java
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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JPanel;

import settings.Language.Text;

/**
 * Classe parente pour les interfaces qui ont besoin des options de base:
 * - Ajouter, Modifier, Supprimer.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public abstract class JManageFrame extends JDialog {

   /**
    * ID de série.
    */
   private static final long serialVersionUID = 3532238860718872672L;
   
   private GridBagConstraints constraints = new GridBagConstraints();
   private JPanel content = new JPanel();
   
   /**
    * 
    */
   public JManageFrame() {
      setTitle(Text.APP_TITLE.toString());
      setVisible(true);
      setLocationRelativeTo(null);
      
      setContentPane(initContent());
      
      pack();
   }
   
   protected JPanel initContent(){
      
      constraints.insets = new Insets(5, 5, 5, 5);
      constraints.weightx = 0.0;
      constraints.weighty = 0.5;
      
      content.setLayout(new GridBagLayout());
      
      constraints.gridx = 0;
      constraints.gridy = 0;

      constraints.anchor = GridBagConstraints.NORTH;
      
      return content;
   }
   
   protected GridBagConstraints getConstraints() {
      return constraints;
   }
   
   protected JPanel getContent() {
      return content;
   }

}
