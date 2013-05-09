/* ============================================================================
 * Nom du fichier   : JAccountList.java
 * ============================================================================
 * Date de création : 8 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.frameContent;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
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
public class JAccountList extends JPanel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -8808271053870485590L;
   
   private JList<String> lstAccount;
   
  
   /**
    * Constructeur par défaut.
    */
   public JAccountList() {
      setLayout(new BorderLayout(5,5));
      
      
      lstAccount = new JList<>(new Model());
      
      add(lstAccount, BorderLayout.CENTER);
      
   }
   
   private class Model extends DefaultListModel<String> {
      /**
       * ID de sérialisation.
       */
      private static final long serialVersionUID = 1513007892074649851L;
      
      public Model() {
         addElement("Account1");
         addElement("Account 2");
      }      
   }

}
