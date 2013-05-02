package gui.component;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import settings.Language.Text;

public class ThresholdTextInput extends JPanel {

   /**
    * 
    */
   private static final long serialVersionUID = -3080495005197994222L;
   // Champs composant le panel.
   private JLabel lblThreshold;
   private JTextField txtThreshold;
   
   public ThresholdTextInput() {
      setLayout(new BorderLayout(5,5));
      
      lblThreshold = new JLabel(Text.THRESHOLD_LABEL.toString());
      txtThreshold = new JTextField(30);
      
      add(lblThreshold, BorderLayout.WEST);
      add(txtThreshold, BorderLayout.EAST); 
   }

}
