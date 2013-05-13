/* ============================================================================
 * Nom du fichier   : JComboBoxTransactionType.java
 * ============================================================================
 * Date de création : 10 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import settings.Language.Text;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JComboBoxTransactionType extends JPanel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 5280250537604789528L;
   
   private JLabel lblDescription;
   private JComboBox<String> cbxTypes;
   
   /**
    * 
    */
   public JComboBoxTransactionType() {
      initContent();
      buildContent();      
   }
   
   private void buildContent() {
      setLayout(new BorderLayout(5,5));
      
      add(lblDescription, BorderLayout.WEST);
      add(cbxTypes, BorderLayout.CENTER);      
   }

   private void initContent() {
      lblDescription = new JLabel(Text.TRANSACTION_TYPE_LABEL.toString());
      cbxTypes = new JComboBox<>(new typeModel());
   }
   
   private class typeModel extends DefaultComboBoxModel<String> {
      /**
       * ID de sérialisation.
       */
      private static final long serialVersionUID = 2664713568744474205L;

      public typeModel() {
         addElement(Text.TRANSACTION_TYPE_CREDIT.toString());
         addElement(Text.TRANSACTION_TYPE_DEBIT.toString());
      }
   }
}
