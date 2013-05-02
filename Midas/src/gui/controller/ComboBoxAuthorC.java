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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.NewAuthorFrame;
import gui.actions.AcCreateAuthor;
import gui.component.ComboBoxAuthor;
import gui.component.ComboBoxUsers;
import core.Core;
import core.MidasLogs;
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
public class ComboBoxAuthorC extends Controller {
   ComboBoxUsers view;
   UserList model;
   
   /**
    * 
    */
   public ComboBoxAuthorC(Core core) {
      super(core);
      
      model = core.getAllUsers();
      view = new ComboBoxUsers(model);
      
      model.addObserver(view);
      
      initActionListeners();
   }
   
   @Override
   protected void initActionListeners() {
      
      view.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            if(view.isCreateNewSelected()) {
               AcCreateAuthor action = new AcCreateAuthor(getCore());
               action.actionPerformed(arg0);
            }
         }
      });
   }
   
   public ComboBoxUsers getGraphicalComponent() {
      return view;
   }

}
