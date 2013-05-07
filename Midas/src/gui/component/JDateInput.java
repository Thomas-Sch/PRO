/* ============================================================================
 * Nom du fichier   : DateInput.java
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
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

/**
 * Elément comportant la saisie d'une date.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JDateInput extends JPanel {
   private static final long serialVersionUID = 1L;
   
   /**
    * 
    */
   public JDateInput(String labelContent) {
      setLayout(new BorderLayout(5,5));
      
      add(new JLabel(labelContent), BorderLayout.WEST);      
      JDateChooser dchTime = new JDateChooser(new Date());
      add(dchTime, BorderLayout.CENTER); 
   }

}
