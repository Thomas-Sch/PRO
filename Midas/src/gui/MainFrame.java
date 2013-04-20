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

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
public class MainFrame extends JFrame{
      
   /**
    * Constructeur sans paramètre.
    */
   public MainFrame(String title, int posX, int posY, int width, int height)  {
      super(title);
      
      // Aspect des fenêtres.
      try {
         javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
      } catch(Exception e) {
         e.printStackTrace();
      }
      setBounds(posX, posY, width, height);
      init();
   }
   
   /**
    * Initialisations des différentes éléments présents dans la vue.
    */
   private void init() {
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE); 

      setContentPane(buildContent());
      setMinimumSize(new Dimension(600, 400));
      
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
      pnlContent.setLayout(new BorderLayout());
      
      JTabbedPane tbpMain = new JTabbedPane();
      tbpMain.addTab("Accueil", new HomeScreen());
      
      pnlContent.add(tbpMain,BorderLayout.CENTER);
      return pnlContent;
   }   
   
}
