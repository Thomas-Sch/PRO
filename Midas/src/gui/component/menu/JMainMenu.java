/* ============================================================================
 * Nom du fichier   : JMainMenu.java
 * ============================================================================
 * Date de création : 13 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component.menu;

import gui.Controller;
import gui.controller.menu.EditMenu;
import gui.controller.menu.FileMenu;
import gui.controller.menu.InterrogationMenu;
import gui.controller.menu.ViewMenu;

import javax.swing.JMenuBar;

/**
 * Classe contenant le menu principal de notre application.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JMainMenu extends JMenuBar {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 4143588954471515225L;

   private FileMenu file;
   private EditMenu edit;
   
   // Ces menus ne sont pas utilisés pour l'instant.
   //   private ViewMenu view;
   //   private InterrogationMenu interrogation;

   /**
    * Construit le menu avec ses composants.
    */
   public JMainMenu(Controller controller) {
      file = new FileMenu(controller.getCore());
      edit = new EditMenu(controller.getCore());

      //      view = new ViewMenu(controller.getCore());
      //      interrogation = new InterrogationMenu(controller.getCore());

      add(file.getGraphicalComponent());
      add(edit.getGraphicalComponent());

      // Ces menus ne sont pas ajoutés dans cette version car aucune interface
      // ne leur est associée.
      // add(view.getGraphicalComponent());
      // add(interrogation.getGraphicalComponent());

   }
}
