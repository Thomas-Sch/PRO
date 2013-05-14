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
 * TODO
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
   
   private JLabelTextPanel categoryName;
   private JValidateCancel vlc;
   
   /**
    * Construit la vue.
    */
   public JCreateCategory(Component parent, Category category) {
      this.category = category;
      
      setTitle(Text.APP_TITLE.toString());
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
      
      vlc = new JValidateCancel();
      categoryName = new JLabelTextPanel("Nom", 20);
      
      pnlContent.add(categoryName);
      pnlContent.add(vlc);
      
      //Contraintes du label par rapport au contenant.
      splLayout.putConstraint(SpringLayout.WEST, categoryName, 5, SpringLayout.WEST, pnlContent);
      splLayout.putConstraint(SpringLayout.NORTH, categoryName,8, SpringLayout.NORTH, pnlContent);

      //Contraintes pour la taille du contenant.
      splLayout.putConstraint(SpringLayout.EAST, pnlContent, 5, SpringLayout.EAST, categoryName);
      splLayout.putConstraint(SpringLayout.SOUTH, pnlContent, 5, SpringLayout.SOUTH, vlc);
      
      // Contraintes pour le bouton de validation.
      splLayout.putConstraint(SpringLayout.EAST, vlc, 0, SpringLayout.EAST, pnlContent);
      splLayout.putConstraint(SpringLayout.NORTH, vlc, 5, SpringLayout.SOUTH, categoryName);
      
      categoryName.addTextChangedListener(new TextChangedListener() {
       @Override
       public void textChanged(DocumentEvent event) {
          category.setName(categoryName.getText());
       }
          });
      
      return pnlContent;
   }
   
   public void addValidateListener(ActionListener listener) {
      vlc.addValidateListener(listener);
   }
   
   public void addCancelListener(ActionListener listener) {
      vlc.addCancelListener(listener);
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   public void update(Observable arg0, Object arg1) {
      categoryName.setText(category.getName());
   } 
}
