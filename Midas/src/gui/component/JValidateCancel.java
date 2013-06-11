/* ============================================================================
 * Nom du fichier   : JValidateCancel.java
 * ============================================================================
 * Date de création : 7 mai 2013
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

import settings.Language.Text;

/**
 * Panneau comprenant un bouton valider et un bouton annuler.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JValidateCancel extends JPanel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -2927910491428579256L;

   private JButton btnValidate = new JButton(Text.VALIDATE_BUTTON.toString());
   private JButton btnCancel = new JButton(Text.CANCEL_BUTTON.toString());

   private FlowLayout fltLayout = new FlowLayout();

   /**
    * Crée un panneau valider - annuler.
    */
   public JValidateCancel() {
      setLayout(fltLayout);
      add(btnValidate);
      add(btnCancel);

      setEnableValidateButton(false);
   }

   /**
    * Ajoute un écouteur sur le bouton valider.
    * 
    * @param listener
    *           - l'écouteur à ajouter.
    */
   public void addValidateListener(ActionListener listener) {
      btnValidate.addActionListener(listener);
   }

   /**
    * Ajoute un écouteur sur le bouton annuler.
    * 
    * @param listener
    *           - l'écouteur à ajouter.
    */
   public void addCancelListener(ActionListener listener) {
      btnCancel.addActionListener(listener);
   }

   /**
    * Définit l'état actif ou non du bouton valider.
    * 
    * @param enable
    *           - si le bouton doit être actif ou non.
    */
   public void setEnableValidateButton(boolean enable) {
      btnValidate.setEnabled(enable);
   }
}
