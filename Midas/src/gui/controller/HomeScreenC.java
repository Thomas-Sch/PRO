/* ============================================================================
 * Nom du fichier   : HomeScreenC.java
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

import gui.HomeScreen;
import core.Core;

/**
 * Contrôleur de l'écran d'accueil.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class HomeScreenC extends Controller {
   
   HomeScreen homeScreen;
   
   public HomeScreenC (Core core) {
      super(core);
      homeScreen = new HomeScreen(this);
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initActionListeners()
    */
   @Override
   protected void initActionListeners() {
      // TODO Auto-generated method stub

   }
   
   public HomeScreen getGraphicalComponent() {
      return homeScreen;
   }


}
