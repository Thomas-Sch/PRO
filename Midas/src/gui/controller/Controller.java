/* ============================================================================
 * Nom du fichier   : Controller.java
 * ============================================================================
 * Date de création : 25 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.controller;

import core.Core;

/**
 * Modèle pour tous les contrôleurs graphiques.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public abstract class Controller {
   private Core core;
   
   protected Controller(Core core) {
      this.core = core;
   }
   
   protected abstract void initActionListeners();
   
   /**
    * Renvoie core.
    * @return La partie logique de l'application.
    */
   public Core getCore() {
      return core;
   }
}
