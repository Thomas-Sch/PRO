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

import gui.menu.JMainMenu;
import core.Core;

/**
 * Contrôleur du menu principal.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class MainMenu extends Controller {
   
   JMainMenu mainMenu;
   
   public MainMenu(Core core) {
      super(core);
   }
   
   @Override
   protected void initComponents() {
      mainMenu = new JMainMenu(this);
   }
   
   @Override
   protected void initListeners() {
   }
   
   public JMainMenu getGraphicalComponent() {
      return mainMenu;
   }
   
   

}
