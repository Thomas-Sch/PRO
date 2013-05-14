/* ============================================================================
 * Nom du fichier   : JFileMenu.java
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

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import settings.Language.Text;

/**
 * Représente le menu fichier de l'application.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JFileMenu extends JMenu {

   /**
    * ID de sérialisation
    */
   private static final long serialVersionUID = 1583638274791297470L;
   
   JMenuItem mniFilequit;
   
   
   /**
    * 
    */
   public JFileMenu() {
      this.setText("Fichier");
      
      initComponents();
   }
   
   /**
    * Initialise les composants graphiques.
    */
   private void initComponents() {
      mniFilequit = new JMenuItem(Text.ACTION_QUIT.toString());
      add(mniFilequit);
   }
   
   public void addQuitListener(ActionListener listener) {
      mniFilequit.addActionListener(listener);
   }
}
