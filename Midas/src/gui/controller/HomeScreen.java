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

import gui.Controller;
import gui.frameContent.JHomeScreen;
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
public class HomeScreen extends Controller {
   
   JHomeScreen homeScreen;
   
   public HomeScreen (Core core) {
      super(core);
   }   

   @Override
   protected void initComponents() {
      homeScreen = new JHomeScreen(this);
   }
   
   @Override
   protected void initListeners() {
      // Pas de listener
   }
   
   public JHomeScreen getGraphicalComponent() {
      return homeScreen;
   }
}
