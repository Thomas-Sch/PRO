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
import gui.View;
import gui.component.JScrollPaneDefault;
import gui.component.infoedition.JCategoryIE;
import gui.controller.listbox.CategoryListBox;

import java.awt.BorderLayout;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import settings.Language.Text;
import core.Core;
import core.components.Category;
import core.components.CategoryList;

/**
 * Fenêtre de gestion des catégories.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JManageCategory extends JManageFrame implements View {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -6896069068105397629L;

   private JLabel lblListDescription;

   private CategoryListBox categories;

   private JCategoryIE cieInfos;

   /**
    * Crée la fenêtre de gestion des catégories.
    * 
    * @param core
    *           - le coeur logique du programme.
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
            if (categories.getSelectedValue() != null) {
               setEnabledItemDependantButtons(true);

               switch (state) {
                  case EDITION:
                     cieInfos = new JCategoryIE(JManageCategory.this,
                           pnlInfosActions, cieInfos, categories
                                 .getSelectedValue());
                     break;
                  case VIEW:
                     cieInfos = new JCategoryIE(JManageCategory.this,
                           pnlInfosActions, cieInfos, categories
                                 .getSelectedValue());
                     break;
               }
            }
            else {
               setEnabledItemDependantButtons(false);
            }
         }
      });
   }

   @Override
   protected void setEnabledOnEdition(boolean b) {
      cieInfos.setEditable(b);
   }

   @Override
   protected void setEnabledOnView(boolean b) {
      categories.getGraphicalComponent().setEnabled(b);
   }

   @Override
   protected JPanel buildContent() {
      JPanel pnlContent = new JPanel(new BorderLayout(5, 5));

      pnlContent.add(lblListDescription, BorderLayout.NORTH);
      pnlContent.add(
            new JScrollPaneDefault(categories.getGraphicalComponent()),
            BorderLayout.WEST);

      pnlContent.add(pnlInfosActions, BorderLayout.CENTER);
      pnlInfosActions.setLayout(new BorderLayout());

      pnlInfosActions.add(aedActions, BorderLayout.SOUTH);
      pnlInfosActions.add(cieInfos, BorderLayout.CENTER);
      return pnlContent;
   }

   /**
    * Retourne la catégorie sélectionnée dans l'interface.
    * 
    * @return La catégorie sélectionnée.
    */
   public Category getSelectedValue() {
      return categories.getSelectedValue();
   }

   /**
    * Force la mise à jour de la liste des catégories.
    */
   public void updateModel() {
      categories.updateModel();
      pack();
   }

   @Override
   public void update(Observable o, Object arg) {
      // Pas d'update pour l'instant. Voir rapport.
   }

   /* (non-Javadoc)
    * @see gui.JManageFrame#saveItem()
    */
   @Override
   public void saveItem() {
      cieInfos.saveItem();
   }
   
   /**
    * Renvoie la liste des catégories de l'interface.
    * @return La liste des catégories.
    */
   public CategoryList getCategoryList() {
      return categories.getList();
   }
   
   /* (non-Javadoc)
    * @see gui.JManageFrame#selectNoItem()
    */
   @Override
   public void selectNoItem() {
      categories.selectNoItem();
      pnlInfosActions.remove(cieInfos);
      cieInfos = new JCategoryIE();
      pnlInfosActions.add(cieInfos);
   }
}
