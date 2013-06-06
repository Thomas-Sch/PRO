/* ============================================================================
 * Nom du fichier   : MainMenu.java
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
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
@SuppressWarnings("serial")
public class JMainMenu extends JMenuBar {
   
   public FileMenu file;
   public EditMenu edit;
   public ViewMenu view;
   public InterrogationMenu interrogation;
   
   /**
    * Construit le menu avec ses composants.
    */
   public JMainMenu(Controller controller) {  
      file = new FileMenu(controller.getCore());
      edit = new EditMenu(controller.getCore());
      
      view = new ViewMenu(controller.getCore());
      interrogation = new InterrogationMenu(controller.getCore());
      
      add(file.getGraphicalComponent());
      add(edit.getGraphicalComponent());
      
      /*
       * Ces menus ne sont pas ajoutés car aucune interface ne leur est
       * associée.
      add(view.getGraphicalComponent());
      add(interrogation.getGraphicalComponent());
      */
   }
}
