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
package gui;

import gui.controller.Controller;
import gui.controller.HomeScreenC;
import gui.controller.MainMenuC;

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
public class MainFrame extends JFrame{
   
   Controller controller;   
   
   // Composants graphiques extérieurs.
   MainMenuC menu;
   HomeScreenC home;
       
   /**
    * Constructeur sans paramètre.
    */
   public MainFrame(Controller controller, String title)  {
      super(title);
      this.controller = controller;
      
      menu = new MainMenuC(controller.getCore());
      home = new HomeScreenC(controller.getCore());
      
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
