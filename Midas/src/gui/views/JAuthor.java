/* ============================================================================
 * Nom du fichier   : AuthorView.java
 * ============================================================================
 * Date de création : 30 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.views;

import gui.View;
import gui.utils.TextChangedListener;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;

import settings.Language.Text;
import core.components.User;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JAuthor extends JDialog implements View {
   
   /**
    * ID de sérialisation
    */
   private static final long serialVersionUID = -3924649117533563277L;

   private User user;
   
   private LabelTextPanel authorName;
   private MyValidateCancel vlc;
   
   public JAuthor(Component parent, User user) {
      this.user = user;
      
      setTitle(Text.APP_TITLE.toString());
      setContentPane(buildContent());
      setLocationRelativeTo(parent);
      setResizable(true);
      pack();
      
      
      update(user, null);
      
   }
   
   public void addValidateListener(ActionListener listener) {
      vlc.addValidateListener(listener);
   }
   
   public void addCancelListener(ActionListener listener) {
      vlc.addCancelListener(listener);
   }
   
   private JPanel buildContent() {
      JPanel pnlContent = new JPanel();
      JPanel listPane = new JPanel();
      
      pnlContent.setLayout(new BorderLayout());
      listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
      
      authorName = new LabelTextPanel("Nom :", 20);
      
      vlc = new MyValidateCancel();
      
      authorName.addTextChangedListener(new TextChangedListener() {
         @Override
         public void textChanged(DocumentEvent event) {
            user.setName(authorName.getText());
         }
      });
      
      listPane.add(authorName);
      pnlContent.add(listPane, BorderLayout.CENTER);
      pnlContent.add(vlc, BorderLayout.PAGE_END);
      
      return pnlContent;
   }
   
   @Override
   public void update(Observable arg0, Object arg1) {
      authorName.setText(user.getName());
   }
   
   // A exporter
   private class MyValidateCancel extends JPanel {
      
      /**
       * ID de sérialisation.
       */
      private static final long serialVersionUID = -1245096748671153657L;
      private JButton btnValidate = new JButton(Text.VALIDATE_BUTTON.toString());
      private JButton btnCancel = new JButton(Text.CANCEL_BUTTON.toString());
      
      private FlowLayout fltLayout = new FlowLayout();
      
      private MyValidateCancel() {
         
         setLayout(fltLayout);
         
         add(btnValidate);
         add(btnCancel);
      }
      
      public void addValidateListener(ActionListener listener) {
         btnValidate.addActionListener(listener);
      }
      
      public void addCancelListener(ActionListener listener) {
         btnCancel.addActionListener(listener);
      }
   }
   
   
   // A exporter
   private class LabelTextPanel extends JPanel {
      
      /**
       * ID de sérialisation.
       */
      private static final long serialVersionUID = -1297406355333906465L;
      private SpringLayout layout;
      private JLabel label;
      private JTextField textField;
      
      private LabelTextPanel(String textForLabel, int textFieldColumns) {
         
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

}
