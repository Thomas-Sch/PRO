/* ============================================================================
 * Nom du fichier   : frmMainScreen.java
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

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

/**
 * GUI du menu d'accueil ou menu principal.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
@SuppressWarnings("serial")
public class JMainScreen extends JFrame{
   
   private final  GridBagConstraints constraints = new GridBagConstraints();
   
   /**
    * Constructeur sans paramètre.
    */
   public JMainScreen() {
      super("Midas");
      
      // Initialisations diverses
      setLocationRelativeTo(null); //Ouvre le programme au millieu de l'écran
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);      
   }

   public Dimension getMinimumSize() {
      return new Dimension(100, 200);
   }
}
