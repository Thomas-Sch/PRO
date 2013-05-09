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
package gui.menu;

import gui.Controller;
import gui.controller.EditMenu;
import gui.controller.FileMenu;
import gui.controller.InterrogationMenu;
import gui.controller.ViewMenu;

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
      add(view.getGraphicalComponent());
      add(interrogation.getGraphicalComponent());
   }
}
