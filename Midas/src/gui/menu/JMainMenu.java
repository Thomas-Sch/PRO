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

import gui.controller.Controller;
import gui.controller.EditMenu;
import gui.controller.FileMenu;

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
   public JViewMenu view;
   public JInterrogationMenu interrogation;
   
   /**
    * Construit le menu avec ses composants.
    */
   public JMainMenu(Controller controller) {  
      file = new FileMenu(controller.getCore());
      edit = new EditMenu(controller.getCore());
      
      view = new JViewMenu();
      interrogation = new JInterrogationMenu();
      
      add(file.getGraphicalComponent());
      add(edit.getGraphicalComponent());
      add(view);
      add(interrogation);
   }
}
