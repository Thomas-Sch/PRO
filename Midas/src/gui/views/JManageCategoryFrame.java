/* ============================================================================
 * Nom du fichier   : ManageCategoryFrame.java
 * ============================================================================
 * Date de création : 21 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.views;

import gui.JManageFrame;

import javax.swing.JPanel;

import core.Core;


/**
 * Fenêtre de gestion des catégories.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JManageCategoryFrame extends JManageFrame {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 6725916764187235442L;

   /**
    * @param core
    */
   public JManageCategoryFrame(Core core) {
      super(core);
      // TODO Auto-generated constructor stub
   }

   /* (non-Javadoc)
    * @see gui.JManageFrame#setEnabledOnEdition(boolean)
    */
   @Override
   protected void setEnabledOnEdition(boolean b) {
      // TODO Auto-generated method stub
      
   }

   /* (non-Javadoc)
    * @see gui.JManageFrame#setEnabledOnView(boolean)
    */
   @Override
   protected void setEnabledOnView(boolean b) {
      // TODO Auto-generated method stub
      
   }

   /* (non-Javadoc)
    * @see gui.JManageFrame#buildContent()
    */
   @Override
   protected JPanel buildContent() {
      // TODO Auto-generated method stub
      return null;
   }

//   /**
//    * @param controller
//    */
//   public JManageCategoryFrame(Controller controller) {
//      super(controller);
//   }
//
//   /**
//    * ID de série.
//    */
//   private static final long serialVersionUID = -3350759512131610325L;
//   
//   protected JPanel initContent() {
//      return super.initContent();
//      
////      getContent().add(new CategoryList(), getConstraints());
////         
////       getConstraints().gridx = 1;
////       getConstraints().anchor = GridBagConstraints.NORTH;
////       getConstraints().insets = new Insets(5, 50, 5, 5);
////       
////       getContent().add(new CategoryList(), getConstraints());
////      
////      return getContent();
//   }
//   
}
