/* ============================================================================
 * Nom du fichier   : AuthorList.java
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
package gui.data;

import javax.swing.DefaultListModel;

import gui.component.ListTemplate;

/**
 * TODO
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class AuthorList extends ListTemplate {

   /**
    * ID de série.
    */
   private static final long serialVersionUID = -7682417283987969152L;

   /*
    * (non-Javadoc)
    * 
    * @see gui.component.ListTemplate#setData(javax.swing.DefaultListModel)
    */
   @Override
   protected void setData(DefaultListModel<String> dlm) {
      for (String s : new AuthorData().getList()) {
         dlm.addElement(s);
      }
   }
}
