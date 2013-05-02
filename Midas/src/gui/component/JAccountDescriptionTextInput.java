package gui.component;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import settings.Language.Text;

public class JAccountDescriptionTextInput extends JPanel {
   
   private JLabel lblAccountDescription;
   private JTextField txtAccountDescription;

   /**
    * ID de série.
    */
   private static final long serialVersionUID = -4260017189796079510L;
   
   public JAccountDescriptionTextInput() {
      setLayout(new BorderLayout(5,5));
      
      lblAccountDescription = new JLabel(Text.ACCOUNT_DESCRIPTION_LABEL.toString());
      txtAccountDescription = new JTextField(30);
      
      add(lblAccountDescription,BorderLayout.WEST);
      add(txtAccountDescription, BorderLayout.EAST); 
   }

}
