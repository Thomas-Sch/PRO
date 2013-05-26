/* ============================================================================
 * Nom du fichier   : JManageCategory.java
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
package gui.views;

import gui.JManageFrame;
import gui.component.infoedition.JCategoryIE;
import gui.controller.CategoryListBox;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import settings.Language.Text;
import core.Core;
import core.components.Category;

/**
 * Fenêtre de gestion des catégories.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JManageCategory extends JManageFrame {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -6896069068105397629L;
   
   private JLabel lblListDescription;
   
   private CategoryListBox categories;

   private JCategoryIE cieInfos;

   /**
    * @param core
    */
   public JManageCategory(Core core) {
      super(core);
   }
   
   /**
    * Initialise les composants graphiques.
    */
   protected void initContent() {
      super.initContent();
      lblListDescription = new JLabel(Text.CATEGORY_LIST_LABEL.toString());
      categories = new CategoryListBox(core);
      cieInfos = new JCategoryIE();
   }
   
   /**
    * Initialise les listeners internes au composant graphique.
    */
   protected void initListeners() {
      super.initListeners();
      categories.addSelectionChangedListener(new ListSelectionListener() {
         
         @Override
         public void valueChanged(ListSelectionEvent e) {
            if(categories.getSelectedValue() != null) {
               setEnabledItemDependantButtons(true);

               switch (state) {
                  case EDITION:
                     cieInfos = new JCategoryIE(JManageCategory.this, pnlInfosActions, cieInfos, categories.getSelectedValue());
                     break;
                  case VIEW:
                     cieInfos = new JCategoryIE(JManageCategory.this, pnlInfosActions, cieInfos, categories.getSelectedValue());
                     break;
               }
            }
            else {
               setEnabledItemDependantButtons(false);
            }
         }
      });
   }
   

   /* (non-Javadoc)
    * @see gui.JManageFrame#setEnabledOnEdition(boolean)
    */
   @Override
   protected void setEnabledOnEdition(boolean b) {
      cieInfos.setEditable(b);  
   }

   /* (non-Javadoc)
    * @see gui.JManageFrame#setEnabledOnView(boolean)
    */
   @Override
   protected void setEnabledOnView(boolean b) {
      categories.getGraphicalComponent().setEnabled(b);
   }

   /* (non-Javadoc)
    * @see gui.JManageFrame#buildContent()
    */
   @Override
   protected JPanel buildContent() {
      JPanel pnlContent = new JPanel(new BorderLayout(5,5));
      
      pnlContent.add(lblListDescription, BorderLayout.NORTH);
      pnlContent.add(categories.getGraphicalComponent(),BorderLayout.WEST);
      
      pnlContent.add(pnlInfosActions, BorderLayout.CENTER);
      pnlInfosActions.setLayout(new BorderLayout());
      
      pnlInfosActions.add(aedActions, BorderLayout.SOUTH);
      pnlInfosActions.add(cieInfos, BorderLayout.CENTER);
      return pnlContent;
   }
   
   /**
    * Récupère la catégorie seléctionnée dans l'interface.
    * @return la catégorie seléctionnée.
    */
   public Category getSelectedValue() {
      return categories.getSelectedValue();
   }
   
   /**
    * Force la mise à jour la liste des catégories.
    */
   public void updateModel() {
      categories.updateModel();
      pack();
   }
}
