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
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;

import settings.Language.Text;

/**
 * Cette classe permet de présenter ou modifier une somme d'argent.
 * 
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

   private boolean isNumber = false;
   private JLabel lblCurrency;

   /**
    * Crée le champ représentant une somme d'argent.
    * 
    * @param metainfo
    *           - les informations contenues dans le libellé.
    * @param data
    *           - le contenu du champ texte.
    */
   public JMoneyInfoEditionLabel(Text metainfo, String data) {
      super(metainfo, data);
      initListeners();
      setDataAlignement(SwingConstants.RIGHT);
      tfdData.setColumns(tfdData.getColumns() - lblCurrency.getText().length());
      checkValidity();
   }

   /**
    * Crée le champ représentant une somme d'argent.
    * 
    * @param metainfo
    *           - les informations contenues dans le libellé.
    */
   public JMoneyInfoEditionLabel(Text metainfo) {
      this(metainfo, "");

      // Si on met rien comme données dans le champs texte, c'est que l'on
      // veut saisir quelque chose.
      setEditable(true);
   }

   /**
    * Place les composants du panneau.
    */
   protected void buildContent() {

      setLayout(new GridBagLayout());

      GridBagConstraints constraints = new GridBagConstraints();
      constraints.anchor = GridBagConstraints.WEST;
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.weightx = 0.0;
      constraints.gridx = 0;
      constraints.gridy = 0;
      add(lblMetaInfo, constraints);

      JPanel pnlMoney = new JPanel(new BorderLayout(4, 0));
      pnlMoney.add(tfdData, BorderLayout.CENTER);

      // Le label est défini ici pour des raisons pratiques.
      lblCurrency = new JLabel(Text.SWISS_FRANC_ACRONYM.toString());
      pnlMoney.add(lblCurrency, BorderLayout.EAST);

      constraints.fill = GridBagConstraints.NONE;
      constraints.anchor = GridBagConstraints.EAST;
      constraints.weightx = 1.0;
      constraints.gridx = 1;
      constraints.insets = new Insets(0, 20, 0, 0);
      add(pnlMoney, constraints);

   }

   /**
    * Indique que le nombre contenu dans le champ texte est invalide.
    */
   public void setInvalid() {
      isNumber = false;
      tfdData.setForeground(Color.RED);
   }

   /**
    * Indique que le nombre contenu dans le champ texte est valide.
    */
   public void setValid() {
      isNumber = true;
      tfdData.setForeground(Color.BLACK);
   }

   /**
    * Retourne si le contenu du champ text contient un nombre.
    * 
    * @return Vrai si le contenu du champs text est un nombre, Faux le cas
    *         échéant.
    */
   public boolean isNumber() {
      return isNumber;
   }

   /**
    * Retourne si le contenu du champ est un nombre positif.
    * 
    * @return Vrai si le nombre est positif, Faux le cas échéant.
    */
   public boolean isPositive() {
      return isNumber() && Double.parseDouble(getText()) >= 0;
   }

   /**
    * Initialise les écouteurs du composant.
    */
   private void initListeners() {
      addTextChangedListener(new TextChangedListener() {

         @Override
         public void textChanged(DocumentEvent event) {
            checkValidity();
         }
      });
   }

   /**
    * Vérifie qu'un nombre est contenu dans le champs texte.
    */
   private void checkValidity() {
      try {
         Double.parseDouble(tfdData.getText());
         setValid();
      }
      catch (Exception e) {
         setInvalid();
      }
   }
}
