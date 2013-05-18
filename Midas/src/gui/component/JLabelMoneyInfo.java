/* ============================================================================
 * Nom du fichier   : JLabelMoneyInfo.java
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
package gui.component;

import javax.swing.JTextField;


/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JLabelMoneyInfo extends JLabelInfo {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -2274610463809339887L;

   /**
    * @param metaInfo
    * @param data
    */
   public JLabelMoneyInfo(String metaInfo) {
      super(metaInfo);
      setDataAlignement(JTextField.RIGHT);
   }


}
