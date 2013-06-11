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
package gui.component.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import settings.Language.Text;

/**
 * Représente le menu "?" de l'application.
 * 
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
    * Crée le menu "?".
    */
   public JInterrogationMenu() {
      setText(Text.INTERROGATION_MENU.toString());

      // Option ?->Aide...
      JMenuItem mniInterrogationHelp = new JMenuItem(
            Text.ACTION_HELP.toString());
      add(mniInterrogationHelp);

      // Option ?->A propos...
      JMenuItem mniInterrogationAbout = new JMenuItem(
            Text.ACTION_ABOUT.toString());
      add(mniInterrogationAbout);
   }
}
