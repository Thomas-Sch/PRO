/* ============================================================================
 * Nom du fichier   : JViewMenu.java
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
 * Représente le menu "Afficher" de l'application.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JViewMenu extends JMenu {

   /**
    * ID de sérialisation
    */
   private static final long serialVersionUID = 4157312860138677663L;

   /**
    * Crée le menu "Afficher".
    */
   public JViewMenu() {

      setText(Text.VIEW_MENU.toString());

      // Sous menu Afficher->Graphiques.
      JMenu mnuViewGraphic = new JMenu(Text.ACTION_LIST.toString());
      add(mnuViewGraphic);

      // Sous menu Afficher->Listes.
      JMenu mnuViewList = new JMenu(Text.ACTION_GRAPH.toString());
      add(mnuViewList);

      // Option Afficher->Listes->20 derniers mouvements d'argent.
      JMenuItem mniViewListLast20 = new JMenuItem(
            Text.ACTION_LIST_LAST20.toString());
      mnuViewList.add(mniViewListLast20);

      // Option Afficher->Listes->Mouvements entre deux dates.
      JMenuItem mniViewListInterval = new JMenuItem(
            Text.ACTION_LIST_TRANSACTION.toString());
      mnuViewList.add(mniViewListInterval);
   }

}
