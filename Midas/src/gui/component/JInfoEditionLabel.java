/* ============================================================================
 * Nom du fichier   : JInfoEditionLabel.java
 * ============================================================================
 * Date de création : 22 mai 2013
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
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
public class JInfoEditionLabel extends JPanel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 3259394361524059135L;
   
   private final int nbRows = 20;
   
   private JLabel lblMetaInfo;
   private JTextField tfdData;
   
   public JInfoEditionLabel (Text metainfo, String data) {
      initContent(metainfo, data);
      buildContent();
   }
   
   public void initContent(Text metainfo, String data) {
      lblMetaInfo = new JLabel(metainfo.toString());
      tfdData = new JTextField(data, nbRows);
   }
   
   public void buildContent() {
      setLayout(new BorderLayout(5,5));
      add(lblMetaInfo, BorderLayout.WEST);
      add(tfdData, BorderLayout.EAST); 
   }
}
