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
package gui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Représente le menu afficher de l'application.
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
    * 
    */
   protected JViewMenu() {
      setText("Afficher");

      // Sous menu Afficher->Graphiques.
      JMenu mnuViewGraphic = new JMenu("Graphiques");
      add(mnuViewGraphic);

      // Sous menu Afficher->Listes.
      JMenu mnuViewList = new JMenu("Listes");
      add(mnuViewList);
         
      // Option Afficher->Listes->20 derniers mouvements d'argent.
      JMenuItem mniViewListLast20 = new JMenuItem("Les 20 derniers mouvements d'argent");
      mnuViewList.add(mniViewListLast20);

      // Option Afficher->Listes->Mouvements entre deux dates.
      JMenuItem mniViewListInterval = new JMenuItem("Mouvements d'argent dans un interval");
      mnuViewList.add(mniViewListInterval);
   }

}
