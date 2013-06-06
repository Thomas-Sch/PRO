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
import gui.component.JInfoEditionLabel;
import gui.component.JValidateCancel;
import gui.utils.TextChangedListener;

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
   
   private JInfoEditionLabel ielName;
   private JValidateCancel vclActions;
   
   /**
    * Construit la vue.
    */
   public JCreateCategory(Category category) {
      this.category = category;
      initContent();
      initListeners();
      setContentPane(buildContent());
      pack();
   }
   
   /**
    * Initialise le contenu de la fenêtre.
    */
   private void initContent() {
      vclActions = new JValidateCancel();
      ielName = new JInfoEditionLabel(Text.CATEGORY_NAME_LABEL);
   }
   
   /**
    * Initialise les écouteurs internes à la fenêtre.
    */
   private void initListeners() {
      ielName.addTextChangedListener(new TextChangedListener() {
         @Override
         public void textChanged(DocumentEvent event) {
            category.setName(ielName.getText());
            checkItemIntegrity();
         }
      });
   }
   
   /**
    * Construit et place les composants de la fenêtre.
    * @return
    */
   private JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      
      SpringLayout splLayout = new SpringLayout();
      pnlContent.setLayout(splLayout);
      
      pnlContent.add(ielName);
      pnlContent.add(vclActions);
      
      //Contraintes du label par rapport au contenant.
      splLayout.putConstraint(SpringLayout.WEST, ielName, 5, SpringLayout.WEST, pnlContent);
      splLayout.putConstraint(SpringLayout.NORTH, ielName,8, SpringLayout.NORTH, pnlContent);

      //Contraintes pour la taille du contenant.
      splLayout.putConstraint(SpringLayout.EAST, pnlContent, 5, SpringLayout.EAST, ielName);
      splLayout.putConstraint(SpringLayout.SOUTH, pnlContent, 5, SpringLayout.SOUTH, vclActions);
      
      // Contraintes pour le bouton de validation.
      splLayout.putConstraint(SpringLayout.EAST, vclActions, 0, SpringLayout.EAST, pnlContent);
      splLayout.putConstraint(SpringLayout.NORTH, vclActions, 5, SpringLayout.SOUTH, ielName);
      
      return pnlContent;
   }
   
   /**
    * Ajoute un listener sur le bouton de validation.
    * @param listener
    */
   public void addValidateListener(ActionListener listener) {
      vclActions.addValidateListener(listener);
   }
   
   /**
    * Ajout un listener sur le bouton d'annulation.
    * @param listener
    */
   public void addCancelListener(ActionListener listener) {
      vclActions.addCancelListener(listener);
   }
   
   /**
    * Vérifie que l'objet complété par l'utilisateur est sauvegardable dans
    * la base de donnée.
    */
   private void checkItemIntegrity() {
      boolean checkResult;
      checkResult = ielName.isValidData();
      vclActions.setEnableValidateButton(checkResult);
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable arg0, Object arg1) {
      // Pas d'update pour l'instant. Voir rapport.
   } 
}
