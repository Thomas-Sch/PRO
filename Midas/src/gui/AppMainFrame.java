/* ============================================================================
 * Nom du fichier   : AppMainFrame.java
 * ============================================================================
 * Date de création : 10 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui;

import javax.swing.JFrame;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
@SuppressWarnings("serial")
public class AppMainFrame extends JFrame {
   
   public AppMainFrame(String title, int posX, int posY, int width, int height)  {
      super(title);
      setBounds(posX, posY, width, height);
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      setVisible(true);
   }

}
