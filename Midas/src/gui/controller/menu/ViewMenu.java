/* ============================================================================
 * Nom du fichier   : ViewMenu.java
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
import gui.component.menu.JViewMenu;

import java.awt.Component;

import core.Core;

/**
 * Contrôleur du menu d'affichage.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class ViewMenu extends Controller {

   JViewMenu view;

   /**
    * Crée le contrôleur.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public ViewMenu(Core core) {
      super(core);
   }

   @Override
   protected void initComponents() {
      view = new JViewMenu();
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
