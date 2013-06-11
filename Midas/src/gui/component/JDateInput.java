/* ============================================================================
 * Nom du fichier   : JDateInput.java
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

import gui.exception.BadDateException;

import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import settings.Language.Text;

import com.toedter.calendar.JDateChooser;

/**
 * Panneau comportant la saisie d'une date.
 * 
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
    * Crée le panneau de saisie de date.
    */
   public JDateInput(Text labelContent) {
      initContent(labelContent);
      buildContent();
   }

   /**
    * Initialiser les éléments du panneau.
    * 
    * @param labelContent
    *           - le contenu de l'étiquette de meta-information du composant
    *           graphique.
    */
   public void initContent(Text labelContent) {
      dchTime = new JDateChooser(new Date());
      lblMetaInfo = new JLabel(labelContent.toString());
   }

   /**
    * Positionne les éléments dans le panneau.
    */
   public void buildContent() {
      setLayout(new BorderLayout(5, 5));
      add(lblMetaInfo, BorderLayout.WEST);
      add(dchTime, BorderLayout.EAST);
   }

   /**
    * Retourne la date sélectionnée.
    * 
    * @return La date sélectionnée.
    * @throws BadDateException
    *            si la date choisie est invalide.
    */
   public Date getDate() throws BadDateException {
      if (dchTime.getDate() == null) {
         throw new BadDateException("Invalid date");
      }
      return dchTime.getDate();
   }

   /**
    * Fixe la date du composant.
    * 
    * @param date
    *           - La nouvelle date.
    */
   public void setDate(Date date) {
      dchTime.setDate(date);
   }
}
