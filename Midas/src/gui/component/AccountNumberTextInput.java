package gui.component;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import settings.Language.Text;

public class AccountNumberTextInput extends JPanel {

   /**
    * ID de série.
    */
   private static final long serialVersionUID = -8003077682304893788L;
   
   // Champs composant le panel.
   private JLabel lblAccountNumber;
   private JTextField txtAccountNumber;
   
   public AccountNumberTextInput() {
      setLayout(new BorderLayout(5,5));
      
      lblAccountNumber = new JLabel(Text.ACCOUNT_NUMBER_LABEL.toString());
      txtAccountNumber = new JTextField(30);
      
      add(lblAccountNumber,BorderLayout.WEST);
      add(txtAccountNumber, BorderLayout.EAST); 
   }

}
