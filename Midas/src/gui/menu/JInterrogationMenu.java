/* ============================================================================
 * Nom du fichier   : JInterrogationMenu.java
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
package gui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Représente le menu ? de l'application.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JInterrogationMenu extends JMenu {

   /**
    * ID de sérialisation
    */
   private static final long serialVersionUID = 5260470866242311214L;
   
   /**
    * Contructeur du menu graphique "?".
    */
   public JInterrogationMenu() {
      setText("?");

      // Option ?->Aide...
      JMenuItem mniInterrogationHelp = new JMenuItem("Aide...");
      add(mniInterrogationHelp);

      // Option ?->A propos...
      JMenuItem mniInterrogationAbout = new JMenuItem("A propos...");
      add(mniInterrogationAbout); 
   }
}
