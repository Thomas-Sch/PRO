/* ============================================================================
 * Nom du fichier   : MainWindow.java
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
package guis;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

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
public class MainWindow extends JFrame{
   
   // Contraintes pour les composants graphiques
   GridBagConstraints constraints = new GridBagConstraints();
      
   /**
    * Constructeur sans paramètre.
    */
   public MainWindow() {
      super("Midas");
      
      // Aspect des fenêtres.
      try {
         javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
      } catch(Exception e) {
         e.printStackTrace();
      }
      
      init();
      
   }
   
   /**
    * Initialisations des différentes éléments présents dans la vue.
    */
   private void init() {
      setLocationRelativeTo(null); //Ouvre le programme au milieu de l'écran.
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE); 
//      setSize(200, 100);
      
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
      setJMenuBar(new MainMenu());
      
      // Définission du contenur principal.
      JPanel pnlContent = new JPanel();
      pnlContent.setLayout(new FlowLayout());
      
      constraints.insets = new Insets(3, 3, 3, 3);
      constraints.fill = GridBagConstraints.HORIZONTAL;
      
      constraints.gridheight = 1;
      constraints.gridwidth = 1;
      constraints.gridx = 0;
      constraints.gridy = 0;
      
      // Définission des onglets.
      JTabbedPane tbpMain = new JTabbedPane();
      tbpMain.addTab("Salut", new JLabel("P"));
      tbpMain.addTab("Hello", new JLabel("J"));
     
      pnlContent.add(tbpMain,constraints);
      return pnlContent;
   }   
   
}
