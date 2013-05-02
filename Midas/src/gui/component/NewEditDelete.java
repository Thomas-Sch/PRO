/* ============================================================================
 * Nom du fichier   : NewEditDelete.java
 * ============================================================================
 * Date de création : 21 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Contient les bouttons pour modifier une liste de catégorie ou auteurs.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class NewEditDelete extends JPanel {
   
   /**
    * ID de série.
    */
   private static final long serialVersionUID = -2871705858912856162L;
   
   private JButton btnNew = new JButton("+");
   private JButton btnModify = new JButton("*");
   private JButton btnDelete = new JButton("-");

   /**
    * Constructeur par défaut.
    */
   public NewEditDelete() {
      setLayout(new FlowLayout(FlowLayout.LEFT));
      
      add(btnNew);
      add(btnModify);
      add(btnDelete);
   }

}
