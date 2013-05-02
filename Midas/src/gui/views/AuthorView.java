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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import core.components.User;

import settings.Language.Text;
import gui.View;
import gui.component.ValidateCancel;
import gui.utils.TextChangedListener;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AuthorView extends JDialog implements View {
   
   private User user;
   
   private LabelTextPanel authorName;
   private MyValidateCancel vlc;
   
   public AuthorView(Component parent, User user) {
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
   
   private class MyValidateCancel extends JPanel {
      
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
   
   private class LabelTextPanel extends JPanel {
      
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
