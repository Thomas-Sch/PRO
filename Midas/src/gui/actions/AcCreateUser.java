/* ============================================================================
 * Nom du fichier   : AcCreateUser.java
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

import gui.UserAction;
import gui.utils.Positions;
import gui.utils.Positions.ScreenPosition;
import gui.views.JCreateUserFrame;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import settings.Language.Text;
import core.Core;
import core.components.User;

/**
 * Action réalisant la création d'un nouvel utilisateur.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class AcCreateUser extends UserAction {

   private User user;
   private JCreateUserFrame view;

   /**
    * Crée l'action qui va lancer le processus de création d'un nouvel
    * utilisateur.
    * 
    * @param core
    *           Va permettre d'interagir avec la base de donnée.
    */
   public AcCreateUser(Core core) {
      super(core);
   }

   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {

      user = core.createUser();

      view = new JCreateUserFrame(user);
      view.setTitle(Text.APP_TITLE.toString() + " - "
            + Text.USER_CREATION_TITLE.toString());
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);
      view.setResizable(false);

      initListeners(core);

      user.addObserver(view);

      // ATTENTION : le réglage de la modalité doit être fait après la
      // paramétrisation de la fenêtre !
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }

   /**
    * Initialise les écouteurs de l'action.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public void initListeners(Core core) {
      view.addValidateListener(new UserAction(core) {
         @Override
         protected void execute(Core core, ActionEvent event,
               Object[] dependencies) {
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
   }

   /**
    * Retourne l'utilisateur produit par cette action.
    * 
    * @return L'utilisateur crée.
    */
   public User getCreatedUser() {
      return user;
   }

}
