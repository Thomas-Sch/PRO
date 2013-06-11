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

import gui.Controller;
import gui.component.menu.JMainMenu;
import core.Core;

/**
 * Contrôleur du menu principal.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class MainMenu extends Controller {

   JMainMenu mainMenu;

   /**
    * Crée le contrôleur du menu principal.
    * 
    * @param core - le coeur logique du programme.
    */
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

   @Override
   public JMainMenu getGraphicalComponent() {
      return mainMenu;
   }

}
