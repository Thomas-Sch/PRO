/* ============================================================================
 * Nom du fichier   : JMainFrame.java
 * ============================================================================
 * Date de création : 12 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.views;

import gui.Controller;
import gui.controller.HomeScreen;
import gui.controller.MainMenu;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import settings.Language.Text;

/**
 * Fenêtre principale.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JMainFrame extends JFrame {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 1933259049533441028L;

   Controller controller;

   // Composants graphiques extérieurs.
   MainMenu menu;
   HomeScreen home;

   /**
    * Crée la fenêtre principale.
    * 
    * @param controller
    *           - le contrôleur de la fenêtre.
    * @param title
    *           - le titre de la fenêtre.
    */
   public JMainFrame(Controller controller, String title) {
      super(title);
      this.controller = controller;

      menu = new MainMenu(controller.getCore());
      home = new HomeScreen(controller.getCore());

      // Composants graphiques.
      setContentPane(buildContent());
      pack();
   }

   /**
    * Retourne le contenu de l'interface.
    * 
    * <p>
    * Notre interface est composée d'un menu principal, et d'une fenêtre à
    * onglets.
    * 
    * @return Le contenu à afficher.
    */
   private JPanel buildContent() {

      // Définition du menu principal.
      setJMenuBar(menu.getGraphicalComponent());

      // Définition du conteneur principal.
      JPanel pnlContent = new JPanel();
      pnlContent.setLayout(new BorderLayout());

      JTabbedPane tbpMain = new JTabbedPane();
      tbpMain.addTab(Text.HOME_SCREEN_NAME.toString(),
            home.getGraphicalComponent());

      pnlContent.add(tbpMain, BorderLayout.CENTER);
      return pnlContent;
   }

}
