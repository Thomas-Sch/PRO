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
package gui.views;

import gui.View;
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
public class JCreateAuthorFrame extends JDialog implements View{

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 3040336599330764009L;
   
   private User user;
 
   private JLabelTextPanel authorName;
   private JValidateCancel vclActions;
   
   /**
    * Construit la vue.
    */
   public JCreateAuthorFrame(Component parent, User user) {
      this.user = user;
      
      setContentPane(buildContent());
      setLocationRelativeTo(parent);
      setResizable(false);
      pack();
      update(null, null);
   }
   
   private JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      
      SpringLayout splLayout = new SpringLayout();
      pnlContent.setLayout(splLayout);
      
      vclActions = new JValidateCancel();
      authorName = new JLabelTextPanel(Text.USER_NAME_LABEL);
      
      pnlContent.add(authorName);
      pnlContent.add(vclActions);
      
      //Contraintes du label par rapport au contenant.
      splLayout.putConstraint(SpringLayout.WEST, authorName, 5, SpringLayout.WEST, pnlContent);
      splLayout.putConstraint(SpringLayout.NORTH, authorName,8, SpringLayout.NORTH, pnlContent);

      //Contraintes pour la taille du contenant.
      splLayout.putConstraint(SpringLayout.EAST, pnlContent, 5, SpringLayout.EAST, authorName);
      splLayout.putConstraint(SpringLayout.SOUTH, pnlContent, 5, SpringLayout.SOUTH, vclActions);
      
      // Contraintes pour le bouton de validation.
      splLayout.putConstraint(SpringLayout.EAST, vclActions, 0, SpringLayout.EAST, pnlContent);
      splLayout.putConstraint(SpringLayout.NORTH, vclActions, 5, SpringLayout.SOUTH, authorName);
      
       authorName.addTextChangedListener(new TextChangedListener() {
          @Override
          public void textChanged(DocumentEvent event) {
             if(authorName.getText().length() == 0) {
                vclActions.setEnableValidateButton(false);
             } else {
                user.setName(authorName.getText());
                vclActions.setEnableValidateButton(true);
             }
          }
       });
      
      return pnlContent;
   }
   
   public void addValidateListener(ActionListener listener) {
      vclActions.addValidateListener(listener);
   }
   
   public void addCancelListener(ActionListener listener) {
      vclActions.addCancelListener(listener);
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      // Pas d'update pour l'instant. Voir rapport.
   } 
}
