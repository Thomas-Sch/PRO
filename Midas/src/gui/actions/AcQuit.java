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

import java.awt.event.ActionEvent;

import core.Core;
import core.MidasLogs;
import gui.UserAction;

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
      // TODO Auto-generated constructor stub
   }

   /* (non-Javadoc)
    * @see gui.UserAction#execute(core.Core, java.awt.event.ActionEvent, java.lang.Object[])
    */
   @Override
   protected void execute(Core core, ActionEvent event, Object[] dependencies) {
      MidasLogs.messages.push("Fermeture de l'application");
   }

}
