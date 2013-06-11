/* ============================================================================
 * Nom du fichier   : AcCreateAccount.java
 * ============================================================================
 * Date de création : 9 mai 2013
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
import gui.views.JCreateAccountFrame;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import settings.Language.Text;
import core.Core;
import core.components.Account;

/**
 * Action de création de compte. Contrôle également la fenêtre d'ajout de
 * compte.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class AcCreateAccount extends UserAction {

   private Account account;
   private JCreateAccountFrame view;

   /**
    * Crée l'action de création de compte.
    * 
    * @param core
    *           - le coeur logique de l'application.
    */
   public AcCreateAccount(Core core) {
      super(core);
   }

   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      account = core.createAccount();

      // Réglages de la fenêtre.
      view = new JCreateAccountFrame(account);
      Positions.setPositionOnScreen(view, ScreenPosition.CENTER);
      view.setTitle(Text.APP_TITLE + " - " + Text.ACCOUNT_CREATION_TITLE);
      view.setResizable(false);

      initListeners(core);

      account.addObserver(view);

      // ATTENTION : le réglage de la modalité doit être fait après la
      // paramétrisation de la fenêtre !
      view.setModalityType(ModalityType.APPLICATION_MODAL);
      view.setVisible(true);
   }

   /**
    * Initialise les écouteurs pour ce contrôleur/action.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public void initListeners(Core core) {
      view.addValidateListener(new UserAction(core) {
         @Override
         protected void execute(Core core, ActionEvent event,
               Object[] dependencies) {
            core.saveAccount(account);
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
    * Retourne le compte produit par cette action.
    * 
    * @return Le compte produit.
    */
   public Account getCreatedAccount() {
      return account;
   }
}
