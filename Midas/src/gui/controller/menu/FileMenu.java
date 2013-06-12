/* ============================================================================
 * Nom du fichier   : FileMenu.java
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
import gui.actions.AcQuit;
import gui.component.menu.JFileMenu;

import java.awt.Component;

import core.Core;

/**
 * Contrôleur du menu fichier.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class FileMenu extends Controller {

   private JFileMenu view;

   /**
    * Crée le contrôleur du menu fichier.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public FileMenu(Core core) {
      super(core);
   }

   @Override
   protected void initComponents() {
      view = new JFileMenu();
   }

   @Override
   protected void initListeners() {
      view.addQuitListener(new AcQuit(getCore()));
   }

   @Override
   public Component getGraphicalComponent() {
      return view;
   }

}
