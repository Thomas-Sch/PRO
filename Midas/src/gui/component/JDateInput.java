/* ============================================================================
 * Nom du fichier   : DateInput.java
 * ============================================================================
 * Date de création : 16 avr. 2013
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
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import settings.Language.Text;

import com.toedter.calendar.JDateChooser;

/**
 * Elément comportant la saisie d'une date.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JDateInput extends JPanel {
   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 1L;
   
   private JDateChooser dchTime;
   private JLabel lblMetaInfo;
   
   /**
    * Initialise le panel avec le dateChooser et un label indiquant ce que
    * c'est.
    */
   public JDateInput(Text labelContent) {
      initContent(labelContent);
      buildContent();
   }
   
   /**
    * Initialiser les éléments du panel.
    * @param labelContent Contenu du label de metainformation du composant
    * graphique
    */
   public void initContent(Text labelContent) {
      dchTime = new JDateChooser(new Date());
      lblMetaInfo = new JLabel(labelContent.toString());
   }
   
   /**
    * Posistionne les éléments dans le panel
    */
   public void buildContent() {
      setLayout(new BorderLayout(5,5));
      add(lblMetaInfo, BorderLayout.WEST);
      add(dchTime, BorderLayout.CENTER);
   }
   
   /**
    * Renvoie la date sélectionnée.
    * @return la date sélectionnée.
    */
   public Date getDate() {
      return dchTime.getDate();
   }

}
