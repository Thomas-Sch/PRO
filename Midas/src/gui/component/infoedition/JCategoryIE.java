/* ============================================================================
 * Nom du fichier   : JCategoryIE.java
 * ============================================================================
 * Date de création : 26 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component.infoedition;

import gui.JInfoEditionPane;
import gui.JManageFrame;
import gui.component.JInfoEditionLabel;
import gui.utils.TextChangedListener;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.event.DocumentEvent;

import settings.Language.Text;
import core.components.Category;

/**
 * Panel d'édition des informations d'une catégorie.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JCategoryIE extends JInfoEditionPane<Category> {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 9096965303469092507L;
   
   private JInfoEditionLabel ielName;
   private JInfoEditionLabel ielParent;

   /**
    * @param parent Fenêtre contenant le label.
    * @param data Catégorie à afficher.
    */
   public JCategoryIE(JManageFrame parent, Container container, JCategoryIE last, Category data) {
      this(parent, container, last, data, false);
   }
   
   /**
    * Rien à afficher.
    */
   public JCategoryIE() {
      super();
   }
   
   public JCategoryIE(JManageFrame parent, Container container, JCategoryIE last, Category data, boolean edition) {
      super(parent, container, last, data, edition);
   }


   /* (non-Javadoc)
    * @see gui.JInfoEditionPane#initListeners()
    */
   @Override
   public void initListeners() {
      ielName.addTextChangedListener(new TextChangedListener() {
         @Override
         public void textChanged(DocumentEvent event) {
            checkItemIntegrity();
         }
      });
   }

   /* (non-Javadoc)
    * @see gui.JInfoEditionPane#initContent(java.lang.Object)
    */
   @Override
   public LinkedList<JInfoEditionLabel> initContent(Category data) {
      LinkedList<JInfoEditionLabel> result = new LinkedList<>();
      
      // Définition des champs.
      ielName = new JInfoEditionLabel(Text.CATEGORY_NAME_LABEL, data.getName());   
      ielParent = new JInfoEditionLabel(Text.CATEGORY_PARENT_LABEL, (data.isChild() ? data.getParentCategory().getName() : ""));
      
      // Ajout des champs à la liste.
      result.add(ielName);

      return result;
   }

   /* (non-Javadoc)
    * @see gui.JInfoEditionPane#buildContent()
    */
   @Override
   public void buildContent() {
      setLayout(new GridLayout(2, 1));
      add(ielName);
      
      // On affiche le parent seulement si la catégorie en possède un.
      if(data.isChild()) {
         add(ielParent);
      }
   }
   
   /**
    * Vérifie que l'objet complété par l'utilisateur est sauvegardable dans
    * la base de donnée.
    */
   private void checkItemIntegrity() {
      boolean checkResult;
      checkResult = ielName.isValidData();
      setEnabledValidateButton(checkResult);
   }

   /* (non-Javadoc)
    * @see gui.JInfoEditionPane#saveItem()
    */
   @Override
   public void saveItem() {
      data.setName(ielName.getText());
   }
}
