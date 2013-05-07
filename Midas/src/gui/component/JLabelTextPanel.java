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

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

class JLabelTextPanel extends JPanel {
   
   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -1297406355333906465L;
   private SpringLayout layout;
   private JLabel label;
   private JTextField textField;
   
   JLabelTextPanel(String textForLabel, int textFieldColumns) {
      
      layout = new SpringLayout();
      
      label = new JLabel(textForLabel);
      textField = new JTextField();
      textField.setColumns(textFieldColumns);
      
      setLayout(layout);
      
      add(label);
      add(textField);
      
      // Contraintes du label
      layout.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, this);
      layout.putConstraint(SpringLayout.EAST, label, 5, SpringLayout.HORIZONTAL_CENTER, this);
      
      // Contraintes du textfield
      layout.putConstraint(SpringLayout.NORTH, textField, 5, SpringLayout.NORTH, this);
      layout.putConstraint(SpringLayout.WEST, textField, 5, SpringLayout.HORIZONTAL_CENTER, this);
      
      // Contraintes du conteneur
      layout.putConstraint(SpringLayout.SOUTH, this, 5, SpringLayout.SOUTH, textField);
      layout.putConstraint(SpringLayout.EAST, this, 5, SpringLayout.SOUTH, textField);
      
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