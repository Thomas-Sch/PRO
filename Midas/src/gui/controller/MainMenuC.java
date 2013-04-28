/* ============================================================================
 * Nom du fichier   : MainMenuC.java
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

import gui.MainMenu;
import core.Core;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class MainMenuC extends Controller {
   
   MainMenu mainMenu;
   
   public MainMenuC(Core core) {
      super(core);
      mainMenu = new MainMenu();
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initActionListeners()
    */
   @Override
   protected void initActionListeners() {
   }
   
   public MainMenu getGraphicalComponent() {
      return mainMenu;
   }

}
