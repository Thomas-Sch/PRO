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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import settings.Language.Text;

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
   
   // Boutons de contrôle de ce panel.
   private JButton btnAdd;
   private JButton btnModify;
   private JButton btnDelete;

   /**
    * Constructeur par défaut.
    */
   public JAddEditDelete() {
      initContent();
      initListeners();
      buildContent();
   }
   
   /**
    * Initialisation des listeners pour le comportement interne de ce composant.
    */
   public void initListeners() {
      btnModify.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent arg0) {
            if(btnModify.getText().equalsIgnoreCase(Text.MODIFY_BUTTON.toString())) {
               btnModify.setText(Text.VALIDATE_BUTTON.toString());
            } else {
               btnModify.setText(Text.MODIFY_BUTTON.toString());
            }
         }
      });
   }
   
   /**
    * Initialise les composants graphiques.
    */
   public void initContent() {
      btnAdd = new JButton(Text.ADD_BUTTON.toString());
      btnModify = new JButton(Text.MODIFY_BUTTON.toString());
      btnDelete = new JButton(Text.DELETE_BUTTON.toString());
   }
   
   /**
    * Construction des éléments grahpiques du panel.
    */
   private void buildContent() {
      setLayout(new FlowLayout(FlowLayout.LEFT));

      add(btnAdd);
      add(btnModify);
      add(btnDelete);
   }
   
   /**
    * Désactive ou active le bouton d'ajout.
    * @param b nouvelle valeur d'activation.
    */
   public void setButtonAddEnabled(boolean b) {
      btnAdd.setEnabled(b);
   }
   
   /**
    * Désactive ou active le bouton de modification.
    * @param b nouvelle valeur d'activation.
    */
   public void setButtonModifyEnabled(boolean b) {
      btnModify.setEnabled(b);
   }
   
   /**
    * Désactive ou active le bouton de suppression.
    * @param b nouvelle valeur d'activation.
    */
   public void setButtonDeleteEnabled(boolean b) {
      btnDelete.setEnabled(b);
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
