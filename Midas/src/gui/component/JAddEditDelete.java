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
public class JAddEditDelete extends JPanel {
   
   /**
    * ID de série.
    */
   private static final long serialVersionUID = -2871705858912856162L;
   
   private JButton btnNew = new JButton("Ajouter");
   private JButton btnModify = new JButton("Modifier");
   private JButton btnDelete = new JButton("Supprimer");

   /**
    * Constructeur par défaut.
    */
   public JAddEditDelete() {
      setLayout(new FlowLayout(FlowLayout.LEFT));
      
      add(btnNew);
      add(btnModify);
      add(btnDelete);
   }

}
