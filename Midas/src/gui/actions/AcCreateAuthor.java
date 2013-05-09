/* ============================================================================
 * Nom du fichier   : AcCreateAuthor.java
 * ============================================================================
 * Date de création : 30 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.actions;

import gui.JNewAuthorFrame;
import gui.UserAction;

import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Core;
import core.components.User;

/**
 * Action de management de la liste des catégories.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcCreateAuthor extends UserAction {
   
   private User user;
   private JNewAuthorFrame view;
   
   public AcCreateAuthor(Core core) {
      super(core);
   }

   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      
      user = core.createUser();
      
      view = new JNewAuthorFrame((Component)event.getSource(), user);
      
      view.addValidateListener(new UserAction(core) {
         @Override
         protected void execute(Core core, ActionEvent event, Object[] dependencies) {
            core.saveUser(user);
            view.dispose();
         }
      });
      view.addCancelListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent arg0) {
            view.dispose();
         }
      });
      
      user.addObserver(view);
      
      // ATTENTION  : le réglage de la modalité doit être fait après la paramétrisation de la fenêtre !
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }
   
   public User getCreatedUser() {
      return user;
   }

}
