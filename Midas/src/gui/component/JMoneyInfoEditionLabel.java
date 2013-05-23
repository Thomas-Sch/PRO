/* ============================================================================
 * Nom du fichier   : JMoneyInfoEditionLabel.java
 * ============================================================================
 * Date de création : 23 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component;

import gui.utils.TextChangedListener;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;

import settings.Language.Text;

/**
 * Cette classe permet de présenter ou modifier une somme d'argent.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JMoneyInfoEditionLabel extends JInfoEditionLabel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -8387676719291740575L;

   /**
    * @param metainfo
    * @param data
    */
   public JMoneyInfoEditionLabel(Text metainfo, String data) {
      super(metainfo, data);
      initListeners();
      setDataAlignement(SwingConstants.RIGHT);
   }
   
   /**
    * Place les composants du panel.
    */
   protected void buildContent() {      
      setLayout(new GridLayout(1, 2));
      add(lblMetaInfo);
      
      JPanel pnlMoney = new JPanel(new BorderLayout(5,0));
      add(pnlMoney);
      
      pnlMoney.add(tfdData, BorderLayout.CENTER);
      
      // Le label est défini ici pour des raisons pratiques.
      JLabel lblCurrency = new JLabel(Text.SWISS_FRANC_ACRONYM.toString());
      pnlMoney.add(lblCurrency, BorderLayout.EAST);
   }
   
   
   
   private void initListeners() {
      addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
         
         }
      });
   }
}
