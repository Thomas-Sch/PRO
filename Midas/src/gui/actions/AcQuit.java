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
    * @param core
    * @param dependencies
    */
   public AcQuit(Core core, Object[] dependencies) {
      super(core, dependencies);
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
