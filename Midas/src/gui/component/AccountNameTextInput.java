package gui.component;

import java.awt.FlowLayout;

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
   private JLabel lblAccountName = new JLabel(Text.ACCOUNT_NAME_LABEL.toString());
   private JTextField txtAccountName = new JTextField();
   
   public AccountNameTextInput() {
      setLayout(new FlowLayout());
      
      add(lblAccountName);
      add(txtAccountName); 
   }

}
