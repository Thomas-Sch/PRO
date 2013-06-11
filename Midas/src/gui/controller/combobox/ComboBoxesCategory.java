/* ============================================================================
 * Nom du fichier   : ComboBoxesCategory.java
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
package gui.controller.combobox;

import gui.Controller;
import gui.actions.AcCreateCategory;
import gui.actions.AcCreateSubCategory;
import gui.component.combobox.JComboBoxCategory;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import core.Core;
import core.components.Category;
import core.components.CategoryList;

/**
 * Contrôleur pour les deux listes déroulantes de catégories.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class ComboBoxesCategory extends Controller {
   
   JComboBoxCategory viewPrimary;
   JComboBoxCategory viewChildren;
   CategoryList primary;
   CategoryList children;

   /**
    * @param core
    */
   public ComboBoxesCategory(Core core) {
      super(core);
      primary.addObserver(viewPrimary);
      children.addObserver(viewChildren);
   }

   /* (non-Javadoc)
    * @see gui.Controller#initComponents()
    */
   @Override
   protected void initComponents() {
      primary = getCore().getAllPrimaryCategories();
      children = new CategoryList(getCore());
      viewPrimary = new JComboBoxCategory(primary);
      viewChildren = new JComboBoxCategory(children, true);
      viewChildren.setVisible(false);
   }

   /* (non-Javadoc)
    * @see gui.Controller#initListeners()
    */
   @Override
   protected void initListeners() {
      viewPrimary.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if (viewPrimary.isCreateNewSelected()) {
               AcCreateCategory action = new AcCreateCategory(getCore());
               action.actionPerformed(arg0);
               viewPrimary.setSelectedItem(action.getCreatedCategory());
               viewChildren.setVisible(true);
            } else if(viewPrimary.isInviteSelected()) {
               viewChildren.setVisible(false);
            }else {
               Category parent = (Category) viewPrimary.getSelectedItem();
               children.setItems(getCore().getChildren(parent).getList());
               viewPrimary.setSelectedItem(parent);
               viewChildren.setVisible(true);
            }
         }
      });
      
      viewChildren.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (viewChildren.isCreateNewSelected()) {
               Category parent = (Category) viewPrimary.getSelectedItem();
              
               AcCreateSubCategory action = new AcCreateSubCategory(getCore(), 
                                                              parent, children);
               action.actionPerformed(e);
               viewChildren.setSelectedItem(action.getCreatedCategory());
            }   
         }
      });
   }

   /* (non-Javadoc)
    * @see gui.Controller#getGraphicalComponent()
    */
   @Override
   public Component getGraphicalComponent() {
      return buildContent();
   }
   
   /**
    * Ajout un écouteur de changement de sélection sur la vue.
    * @param listener Ecouteur ajouté.
    */
   public void addSelectedChangedListener(ActionListener listener) {
      viewPrimary.addActionListener(listener);
   }
   
   /**
    * Renvoie l'item sélectionné dans l'interface.
    * @return l'item sélectionné dans l'interface.
    */
   public Category getSelectedItem() {
      // On regarde ce que l'utilisateur à selectionné : Catégorie simple ou 
      // sous catégorie ?.
      if(viewPrimary.isValidItemSelected()) {
         if(viewChildren.isValidItemSelected()) {
            return (Category) viewChildren.getSelectedItem();
         } 
         // Si aucune catégorie enfant n'est sélectionnée alors on renvoi
         // la catégorie parente.
         return (Category) viewPrimary.getSelectedItem();
      }
      return null;
   }
   
   /**
    * Construit et place les composants contrôlés par cet objet.
    * @return Le contenu controlé par cet objet.
    */
   public JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      pnlContent.setLayout(new BorderLayout(5,5));
      pnlContent.add(viewPrimary, BorderLayout.CENTER);
      pnlContent.add(viewChildren, BorderLayout.EAST);
      return pnlContent;
   }
   
   /**
    * Retourne True si l'item sélectionné dans la liste est actuellement
    * un compte et pas un libellé d'invitation.
    * @return True si un compte est sélectionné.
    */
   public boolean isValidItemSelected() {
      return viewPrimary.isValidItemSelected();
   }
   
   /**
    * Force le composant graphique à sélectionner l'invite d'action de base.
    */
   public void setInviteSelected() {
      viewPrimary.setInviteSelected();
   }
}
