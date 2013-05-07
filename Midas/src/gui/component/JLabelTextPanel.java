/* ============================================================================
 * Nom du fichier   : JLabelTextPanel.java
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

import gui.utils.TextChangedListener;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JLabelTextPanel extends JPanel {
   
   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -1297406355333906465L;
   
   private FlowLayout layout;
   private JLabel label;
   private JTextField textField;
   
   public JLabelTextPanel(String textForLabel, int textFieldColumns) {
      
      layout = new FlowLayout();
      label = new JLabel(textForLabel);
      
      textField = new JTextField();
      textField.setColumns(textFieldColumns);
      
      setLayout(layout);
      
      add(label);
      add(textField);      
   }
   
   public void setText(String text) {
      textField.setText(text);
   }
   
   public String getText() {
      return textField.getText();
   }
   
   public void addTextChangedListener(TextChangedListener listener) {
      TextChangedListener.addListener(textField, listener);
   }
   
}