package gui.component;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import settings.Language.Text;

public class AccountNameTextInput extends JPanel {

   /**
    * ID de série.
    */
   private static final long serialVersionUID = 5945902975916400712L;

   // Champs composant le panel.
   private JLabel lblAccountName;
   private JTextField txtAccountName;
   
   public AccountNameTextInput() {
      setLayout(new BorderLayout(5,5));
      
      lblAccountName = new JLabel(Text.ACCOUNT_NAME_LABEL.toString());
      txtAccountName = new JTextField(30);
      
      add(lblAccountName,BorderLayout.WEST);
      add(txtAccountName, BorderLayout.EAST); 
   }

}
