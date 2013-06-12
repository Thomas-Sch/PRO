/* ============================================================================
 * Nom du fichier   : InterrogationMenu.java
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
package gui.controller.menu;

import gui.Controller;
import gui.component.menu.JInterrogationMenu;

import java.awt.Component;

import core.Core;

/**
 * Contrôleur du menu "?".
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class InterrogationMenu extends Controller {

   private JInterrogationMenu view;

   /**
    * Crée le contrôleur du menu.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public InterrogationMenu(Core core) {
      super(core);
   }

   @Override
   protected void initComponents() {
      view = new JInterrogationMenu();
   }

   @Override
   protected void initListeners() {
      // Aucun pour l'instant.
   }

   @Override
   public Component getGraphicalComponent() {
      return view;
   }

}
