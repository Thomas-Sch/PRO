/* ============================================================================
 * Nom du fichier   : MainFrame.java
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
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
@SuppressWarnings("serial")
public class JMainFrame extends JFrame{
   
   Controller controller;   
   
   // Composants graphiques extérieurs.
   MainMenu menu;
   HomeScreen home;
       
   /**
    * Constructeur sans paramètre.
    */
   public JMainFrame(Controller controller, String title)  {
      super(title);
      this.controller = controller;
      
      menu = new MainMenu(controller.getCore());
      home = new HomeScreen(controller.getCore());
      
      // Composants graphiques.
      setContentPane(buildContent());
      pack();
   }
   
   /**
    * Renvoie le contenu de l'interface.
    * Notre interface est composée d'un menu principal,
    * et d'une fenêtre à onlgets.
    * @return Le contenu à afficher.
    */
   private JPanel buildContent() {
      
      // Définission du menu principal.
      setJMenuBar(menu.getGraphicalComponent());
      
      // Définission du contenur principal.
      JPanel pnlContent = new JPanel();
      pnlContent.setLayout(new BorderLayout());
      
      JTabbedPane tbpMain = new JTabbedPane();
      tbpMain.addTab(Text.HOME_SCREEN_NAME.toString(), home.getGraphicalComponent());
      
      pnlContent.add(tbpMain,BorderLayout.CENTER);
      return pnlContent;
   }   
   
}
