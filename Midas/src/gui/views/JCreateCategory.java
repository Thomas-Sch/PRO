/* ============================================================================
 * Nom du fichier   : JCreateCategory.java
 * ============================================================================
 * Date de création : 14 mai 2013
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

import core.components.Category;

/**
 * Fenêtre de création de catégorie.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JCreateCategory extends JDialog implements View{

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -1546488491086015718L;

   private Category category;
   
   private JLabelTextPanel ltpName;
   private JValidateCancel vlcActions;
   
   /**
    * Construit la vue.
    */
   public JCreateCategory(Component parent, Category category) {
      this.category = category;
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
      
      vlcActions = new JValidateCancel();
      ltpName = new JLabelTextPanel(Text.CATEGORY_NAME_LABEL);
      
      pnlContent.add(ltpName);
      pnlContent.add(vlcActions);
      
      //Contraintes du label par rapport au contenant.
      splLayout.putConstraint(SpringLayout.WEST, ltpName, 5, SpringLayout.WEST, pnlContent);
      splLayout.putConstraint(SpringLayout.NORTH, ltpName,8, SpringLayout.NORTH, pnlContent);

      //Contraintes pour la taille du contenant.
      splLayout.putConstraint(SpringLayout.EAST, pnlContent, 5, SpringLayout.EAST, ltpName);
      splLayout.putConstraint(SpringLayout.SOUTH, pnlContent, 5, SpringLayout.SOUTH, vlcActions);
      
      // Contraintes pour le bouton de validation.
      splLayout.putConstraint(SpringLayout.EAST, vlcActions, 0, SpringLayout.EAST, pnlContent);
      splLayout.putConstraint(SpringLayout.NORTH, vlcActions, 5, SpringLayout.SOUTH, ltpName);
      
      ltpName.addTextChangedListener(new TextChangedListener() {
          @Override
          public void textChanged(DocumentEvent event) {
             vlcActions.setEnableValidateButton(ltpName.getText().length() != 0);
             category.setName(ltpName.getText());
          }
       });
      
      return pnlContent;
   }
   
   /**
    * Ajoute un listener sur le bouton de validation.
    * @param listener
    */
   public void addValidateListener(ActionListener listener) {
      vlcActions.addValidateListener(listener);
   }
   
   /**
    * Ajout un listener sur le bouton d'annulation.
    * @param listener
    */
   public void addCancelListener(ActionListener listener) {
      vlcActions.addCancelListener(listener);
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable arg0, Object arg1) {
      // Pas d'update pour l'instant. Voir rapport.
   } 
}
