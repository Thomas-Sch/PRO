/* ============================================================================
 * Nom du fichier   : NewAuthorFrame.java
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
package gui;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * Classe représentant la fenêtre pour ajouter un nouvel auteur.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class NewAuthorFrame extends JDialog {

   /**
    * 
    */
   private static final long serialVersionUID = 3040336599330764009L;
   
   
   /**
    * 
    */
   public NewAuthorFrame(Component parent) {
      setVisible(true);
      setModal(true);
      setContentPane(buildContent());
      this.setLocationRelativeTo(parent);
      setResizable(true);
      pack();
   }
   
   private JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      
      SpringLayout splLayout = new SpringLayout();
      pnlContent.setLayout(splLayout);
      
      JLabel lblAuthor = new JLabel("Saisissez le nom de l'auteur:");
      JTextField txtAuthor = new JTextField(20);
      JButton btnValidate = new JButton("Valider");
      
      pnlContent.add(lblAuthor);
      pnlContent.add(txtAuthor);
      pnlContent.add(btnValidate);
      
      
      //Contraintes du label par rapport au contenant.
      splLayout.putConstraint(SpringLayout.WEST, lblAuthor, 5, SpringLayout.WEST, pnlContent);
      splLayout.putConstraint(SpringLayout.NORTH, lblAuthor,8, SpringLayout.NORTH, pnlContent);

      //Contraintes entre label, text et contenant.
      splLayout.putConstraint(SpringLayout.WEST, txtAuthor, 5, SpringLayout.EAST, lblAuthor);
      splLayout.putConstraint(SpringLayout.NORTH, txtAuthor, 5, SpringLayout.NORTH, pnlContent);

      //Contraintes pour la taille du contenant.
      splLayout.putConstraint(SpringLayout.EAST, pnlContent, 5, SpringLayout.EAST, txtAuthor);
      splLayout.putConstraint(SpringLayout.SOUTH, pnlContent, 5, SpringLayout.SOUTH, btnValidate);
      
      // Contraintes pour le bouton de validation.
      splLayout.putConstraint(SpringLayout.EAST, btnValidate, -5, SpringLayout.EAST, pnlContent);
      splLayout.putConstraint(SpringLayout.NORTH, btnValidate, 5, SpringLayout.SOUTH, txtAuthor);
      
      return pnlContent;
   }
   
}
