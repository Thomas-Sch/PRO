/* ============================================================================
 * Nom du fichier   : ManageAuthorFrame.java
 * ============================================================================
 * Date de création : 22 avr. 2013
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
import gui.component.infoedition.JUserIE;
import gui.controller.UserListBox;

import java.awt.BorderLayout;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import settings.Language.Text;
import core.Core;
import core.components.User;

/**
 * Management des utilisateurs du programme.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */

public class JManageUser extends JManageFrame implements View{

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 1820447188846446278L;
   
   private JLabel lblListDescription;
   
   private UserListBox users;

   private JUserIE uieInfos;

   /**
    * @param controller Contrôleur de cet objet graphique.
    */
   public JManageUser(Core core) {
      super(core);
   }

   /**
    * Initialise les composants graphiques.
    */
   protected void initContent() {
      super.initContent();
      lblListDescription = new JLabel(Text.USER_LIST_LABEL.toString());
      users = new UserListBox(core);
      uieInfos = new JUserIE();
   }
   
   /**
    * Initialise les listeners internes au composant graphique.
    */
   protected void initListeners() {
      super.initListeners();
      users.addSelectionChangedListener(new ListSelectionListener() {
         
         @Override
         public void valueChanged(ListSelectionEvent e) {
            if(users.getSelectedValue() != null) {
               setEnabledItemDependantButtons(true);

               switch (state) {
                  case EDITION:
                     uieInfos = new JUserIE(JManageUser.this, pnlInfosActions, uieInfos, users.getSelectedValue());
                     break;
                  case VIEW:
                     uieInfos = new JUserIE(JManageUser.this, pnlInfosActions, uieInfos, users.getSelectedValue());
                     break;
               }
            }
            else {
               setEnabledItemDependantButtons(false);
            }
         }
      });
   }
   
   /**
    * Construction des éléments de la vue.
    * @return Le panel contenant les éléments graphiques.
    */
   protected JPanel buildContent() {
      JPanel pnlContent = new JPanel(new BorderLayout(5,5));
      
      pnlContent.add(lblListDescription, BorderLayout.NORTH);
      pnlContent.add(users.getGraphicalComponent(),BorderLayout.WEST);
      
      pnlContent.add(pnlInfosActions, BorderLayout.CENTER);
      pnlInfosActions.setLayout(new BorderLayout());
      
      pnlInfosActions.add(aedActions, BorderLayout.SOUTH);
      pnlInfosActions.add(uieInfos, BorderLayout.CENTER);
      return pnlContent;
   }
   

   /**
    * Récupère le compte seléctionné dans l'interface.
    * @return le compte seléctionné.
    */
   public User getSelectedUser() {
      return users.getSelectedValue();
   }
   
   /**
    * Force la mise à jour la liste des comptes.
    */
   public void updateModel() {
      users.updateModel();
      pack();
   }

   /* (non-Javadoc)
    * @see gui.JManageFrame#setEnabledOnEdition(boolean)
    */
   @Override
   protected void setEnabledOnEdition(boolean b) {
      uieInfos.setEditable(b);      
   }

   /* (non-Javadoc)
    * @see gui.JManageFrame#setEnabledOnView(boolean)
    */
   @Override
   protected void setEnabledOnView(boolean b) {
      users.getGraphicalComponent().setEnabled(b);
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      // Pas d'update pour l'instant. Voir rapport.
   } 
}

