/* ============================================================================
 * Nom du fichier   : ReasonInput.java
 * ============================================================================
 * Date de création : 16 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import settings.Language.Text;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JReasonInput extends JPanel {
   private static final long serialVersionUID = 1L;
   
   /**
    * 
    */
   public JReasonInput() {
      setLayout(new BorderLayout(5,5));
      
      add(new JLabel(Text.REASON_LABEL.toString()), BorderLayout.WEST);
      add(new JTextField(), BorderLayout.CENTER);
   }

}
