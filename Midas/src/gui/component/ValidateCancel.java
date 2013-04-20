package gui.component;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import settings.Language.Text;

public class ValidateCancel extends JPanel {

   /**
    * ID de série.
    */
   private static final long serialVersionUID = -2927910491428579256L;
   
   private JButton btnValidate = new JButton(Text.VALIDATE_BUTTON.toString());
   private JButton btnCancel = new JButton(Text.CANCEL_BUTTON.toString());
   
   public ValidateCancel() {
      setLayout(new FlowLayout());
      
      add(btnValidate);
      add(btnCancel);
      // TODO Auto-generated constructor stub
   }

}
