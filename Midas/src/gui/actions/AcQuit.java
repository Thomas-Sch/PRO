/* ============================================================================
 * Nom du fichier   : AcQuit.java
 * ============================================================================
 * Date de création : 4 mai 2013
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

import java.awt.event.ActionEvent;

import core.Core;
import core.MidasLogs;

/**
 * Action permettant de quitter l'application.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class AcQuit extends UserAction {

   /**
    * Crée une nouvelle action qui va gérer la fermeture de l'application.
    * 
    * @param core
    *           - le coeur logique du programme.
    * @param controller
    *           - le contrôleur qui a appelé cette action.
    */
   public AcQuit(Core core) {
      super(core);
   }

   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      MidasLogs.messages.push("Fermeture de l'application");
      System.exit(0);
   }

}
