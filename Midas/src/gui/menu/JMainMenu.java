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

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

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
   
   public JMenu file;
   public JMenu edit;
   public JMenu view;
   public JMenu interrogation;
   
   /**
    * Construit le menu avec ses composants.
    */
   public JMainMenu() {  
      file = new JFileMenu();
      edit = new JEditMenu();
      view = new JViewMenu();
      interrogation = new JInterrogationMenu();
      
      add(file);
      add(edit);
      add(view);
      add(interrogation);
   }
}
