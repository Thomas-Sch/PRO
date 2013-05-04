/* ============================================================================
 * Nom du fichier   : ComboBoxAuthorC.java
 * ============================================================================
 * Date de création : 28 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.controller;

import gui.actions.AcCreateAuthor;
import gui.component.JComboBoxUsers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Core;
import core.components.UserList;

/**
 * Contrôleur de la liste déroulante d'auteurs.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class ComboBoxAuthor extends Controller {
   JComboBoxUsers view;
   UserList model;
   
   /**
    * Crée le contrôleur d'une ComboBox
    */
   public ComboBoxAuthor(Core core) {
      super(core);
      
      model.addObserver(view);
   }
   
   @Override
   protected void initComponents() {
      model = getCore().getAllUsers();
      view = new JComboBoxUsers(model);
   }
   
   @Override
   protected void initListeners() {
      view.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if(view.isCreateNewSelected()) {
               AcCreateAuthor action = new AcCreateAuthor(getCore());
               action.actionPerformed(arg0);
               view.setSelectedItem(action.getCreatedUser()); 
            }
         }
      });
   }
   
   @Override
   public JComboBoxUsers getGraphicalComponent() {
      return view;
   }
   

}
