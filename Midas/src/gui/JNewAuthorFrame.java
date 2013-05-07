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

import gui.component.JLabelTextPanel;
import gui.component.JValidateCancel;
import gui.utils.TextChangedListener;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;

import settings.Language.Text;
import core.components.User;

/**
 * Classe représentant la fenêtre pour ajouter un nouvel auteur.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JNewAuthorFrame extends JDialog implements View{

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 3040336599330764009L;
   
   private User user;
 
   private JLabelTextPanel authorName;
   private JValidateCancel vlc;
   /**
    * 
    */
   public JNewAuthorFrame(Component parent, User user) {
      this.user = user;
      
      setTitle(Text.APP_TITLE.toString());
      setContentPane(buildContent());
      setLocationRelativeTo(parent);
      setResizable(false);
      pack();
      update(null, null);
   }
   
   public void addValidateListener(ActionListener listener) {
      vlc.addValidateListener(listener);
   }
   
   public void addCancelListener(ActionListener listener) {
      vlc.addCancelListener(listener);
   }
   
   private JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      
      SpringLayout splLayout = new SpringLayout();
      pnlContent.setLayout(splLayout);
      
      vlc = new JValidateCancel();
      authorName = new JLabelTextPanel("Nom", 20);
      
      pnlContent.add(authorName);
      pnlContent.add(vlc);
      
      //Contraintes du label par rapport au contenant.
      splLayout.putConstraint(SpringLayout.WEST, authorName, 5, SpringLayout.WEST, pnlContent);
      splLayout.putConstraint(SpringLayout.NORTH, authorName,8, SpringLayout.NORTH, pnlContent);

      //Contraintes pour la taille du contenant.
      splLayout.putConstraint(SpringLayout.EAST, pnlContent, 5, SpringLayout.EAST, authorName);
      splLayout.putConstraint(SpringLayout.SOUTH, pnlContent, 5, SpringLayout.SOUTH, vlc);
      
      // Contraintes pour le bouton de validation.
      splLayout.putConstraint(SpringLayout.EAST, vlc, 0, SpringLayout.EAST, pnlContent);
      splLayout.putConstraint(SpringLayout.NORTH, vlc, 5, SpringLayout.SOUTH, authorName);
      
       authorName.addTextChangedListener(new TextChangedListener() {
       @Override
       public void textChanged(DocumentEvent event) {
          user.setName(authorName.getText());
       }
          });
      
      return pnlContent;
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      authorName.setText(user.getName());
      
   }
   
}
