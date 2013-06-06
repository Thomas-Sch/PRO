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
 * Action de quitter l'application.
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
    * @param core Va permettre d'interagir avec la base de donnée.
    * @param controller Contrôleur qui a appelé cette action.
    */
   public AcQuit(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      MidasLogs.messages.push("Fermeture de l'application");
      System.exit(0);
   }

}
