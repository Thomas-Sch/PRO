/* ============================================================================
 * Nom du fichier   : JFileMenu.java
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
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JFileMenu extends JMenu {

   /**
    * ID de sérialisation
    */
   private static final long serialVersionUID = 1583638274791297470L;
   
   
   /**
    * 
    */
   protected JFileMenu() {
      this.setText("Fichier");
      
      // Option Fichier->Quitter.
      JMenuItem mniFileQuit = new JMenuItem("Quitter");
      add(mniFileQuit);
   }


}
