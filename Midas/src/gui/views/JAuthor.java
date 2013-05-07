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

import java.util.Observable;

import javax.swing.JDialog;

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

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update(Observable arg0, Object arg1) {
      // TODO Auto-generated method stub
      
   }

//   private User user;
//   
//   private JLabelTextPanel authorName;
//   private MyValidateCancel vlc;
//   
//   public JAuthor(Component parent, User user) {
//      this.user = user;
//      
//      setTitle(Text.APP_TITLE.toString());
//      setContentPane(buildContent());
//      setLocationRelativeTo(parent);
//      setResizable(true);
//      pack();
//      
//      
//      update(user, null);
//      
//   }
//   
//   public void addValidateListener(ActionListener listener) {
//      vlc.addValidateListener(listener);
//   }
//   
//   public void addCancelListener(ActionListener listener) {
//      vlc.addCancelListener(listener);
//   }
//   
//   private JPanel buildContent() {
//      JPanel pnlContent = new JPanel();
//      JPanel listPane = new JPanel();
//      
//      pnlContent.setLayout(new BorderLayout());
//      listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
//      
//      authorName = new JLabelTextPanel("Nom :", 20);
//      
//      vlc = new MyValidateCancel();
//      
//      authorName.addTextChangedListener(new TextChangedListener() {
//         @Override
//         public void textChanged(DocumentEvent event) {
//            user.setName(authorName.getText());
//         }
//      });
//      
//      listPane.add(authorName);
//      pnlContent.add(listPane, BorderLayout.CENTER);
//      pnlContent.add(vlc, BorderLayout.PAGE_END);
//      
//      return pnlContent;
//   }
//   
//   @Override
//   public void update(Observable arg0, Object arg1) {
//      authorName.setText(user.getName());
//   }

}
