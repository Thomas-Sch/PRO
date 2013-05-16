/* ============================================================================
 * Nom du fichier   : ManageAuthorFrame.java
 * ============================================================================
 * Date de création : 22 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.views;

import gui.Controller;
import gui.JManageFrame;
import gui.controller.UserListBox;

import javax.swing.JPanel;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JManageAuthorFrame extends JManageFrame {

   /**
    * @param controller
    */
   public JManageAuthorFrame(Controller controller) {
      super(controller);
   }

   /**
    * ID de série.
    */
   private static final long serialVersionUID = 3252804495254018094L;  
   
   private UserListBox users;
   
   protected JPanel initContent() {
      super.initContent();
      users = new UserListBox(getCore());
      getContent().add(users.getGraphicalComponent(), getConstraints());      
      return getContent();
   }
   
   
   

}
