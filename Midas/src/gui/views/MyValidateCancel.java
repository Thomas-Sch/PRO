/* ============================================================================
 * Nom du fichier   : MyValidateCancel.java
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
package gui.views;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import settings.Language.Text;

// A exporter
class MyValidateCancel extends JPanel {
   
   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -1245096748671153657L;
   private JButton btnValidate = new JButton(Text.VALIDATE_BUTTON.toString());
   private JButton btnCancel = new JButton(Text.CANCEL_BUTTON.toString());
   
   private FlowLayout fltLayout = new FlowLayout();
   
   MyValidateCancel() {
      
      setLayout(fltLayout);
      
      add(btnValidate);
      add(btnCancel);
   }
   
   public void addValidateListener(ActionListener listener) {
      btnValidate.addActionListener(listener);
   }
   
   public void addCancelListener(ActionListener listener) {
      btnCancel.addActionListener(listener);
   }
}