/* ============================================================================
 * Nom du fichier   : JAddEditDelete.java
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
 * Panneau contenant les boutons pour modifier une liste standard.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JAddEditDelete extends JPanel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -2871705858912856162L;

   // Boutons de contrôle de ce panel.
   private JButton btnAdd;
   private JButton btnModify;
   private JButton btnDelete;

   /**
    * Crée le panneau avec les bouton pour modifier une liste standard.
    */
   public JAddEditDelete() {
      initContent();
      initListeners();
      buildContent();
   }

   /**
    * Initialisation des écouteur pour le comportement interne de ce composant.
    */
   public void initListeners() {
      btnModify.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            if (btnModify.getText().equalsIgnoreCase(
                  Text.MODIFY_BUTTON.toString())) {
               btnModify.setText(Text.VALIDATE_BUTTON.toString());
            }
            else {
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
    * Construction des éléments graphiques du panneau.
    */
   private void buildContent() {
      setLayout(new FlowLayout(FlowLayout.LEFT));

      add(btnAdd);
      add(btnModify);
      add(btnDelete);
   }

   /**
    * Définit l'état du bouton d'ajout comme actif ou non.
    * 
    * @param b
    *           - la nouvelle valeur d'activation.
    */
   public void setButtonAddEnabled(boolean b) {
      btnAdd.setEnabled(b);
   }

   /**
    * Définit l'état du bouton de modification comme actif ou non.
    * 
    * @param b
    *           - la nouvelle valeur d'activation.
    */
   public void setButtonModifyEnabled(boolean b) {
      btnModify.setEnabled(b);
   }

   /**
    * Définit l'état du bouton de suppression comme actif ou non.
    * 
    * @param b
    *           - nouvelle valeur d'activation.
    */
   public void setButtonDeleteEnabled(boolean b) {
      btnDelete.setEnabled(b);
   }

   /**
    * Ajoute un écouteur sur le bouton d'ajout.
    * 
    * @param listener
    *           - l'écouteur à ajouter.
    */
   public void addAddActionListener(ActionListener listener) {
      btnAdd.addActionListener(listener);
   }

   /**
    * Ajoute un écouteur sur le bouton de modification.
    * 
    * @param listener
    *           - l'écouteur à ajouter.
    */
   public void addModifyActionListener(ActionListener listener) {
      btnModify.addActionListener(listener);
   }

   /**
    * Ajoute un écouteur sur le bouton de suppression.
    * 
    * @param listener
    *           - l'écouteur à ajouter.
    */
   public void addDeleteActionListener(ActionListener listener) {
      btnDelete.addActionListener(listener);
   }
}
