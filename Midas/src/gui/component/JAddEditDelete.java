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
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Contient les bouttons pour modifier une liste standard.
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
   
   private JButton btnAdd;
   private JButton btnModify;
   private JButton btnDelete;

   /**
    * Constructeur par défaut.
    */
   public JAddEditDelete() {
      setLayout(new FlowLayout(FlowLayout.LEFT));
      buildContent();
   }
   
   /**
    * Construction des éléments grahpiques du panel.
    */
   private void buildContent() {
      btnAdd = new JButton("Ajouter");
      add(btnAdd);
      
      btnModify = new JButton("Modifier");
      add(btnModify);
      
      btnDelete = new JButton("Supprimer");
      add(btnDelete);
   }
   
   /**
    * Ajout d'une action sur le bouton btnAdd.
    * @param listener Action à effectuer.
    */
   public void addAddActionListener(ActionListener listener) {
      btnAdd.addActionListener(listener);
   }
   
   /**
    * Ajout d'une action sur le bouton btnModify.
    * @param listener Action à effectuer.
    */
   public void addModifyActionListener(ActionListener listener) {
      btnModify.addActionListener(listener);
   }

   /**
    * Ajout d'une action sur le bouton btnDelete.
    * @param listener Action à effectuer.
    */
   public void addDeleteActionListener(ActionListener listener) {
      btnDelete.addActionListener(listener);
   }
}
