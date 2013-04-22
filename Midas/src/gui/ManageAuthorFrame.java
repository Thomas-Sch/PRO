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
package gui;

import gui.data.AuthorData;
import gui.data.AuthorList;
import gui.data.CategoryList;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class ManageAuthorFrame extends ManageFrame {

   /**
    * ID de série.
    */
   private static final long serialVersionUID = 3252804495254018094L;  
   
   /**
    * 
    */
   public ManageAuthorFrame() {
      // TODO Auto-generated constructor stub
      getContent().add(new AuthorList(), getConstraints());
   }
   
   
   

}
