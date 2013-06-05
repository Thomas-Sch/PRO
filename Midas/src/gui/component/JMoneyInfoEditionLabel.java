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
   
   boolean isNumber = false;
   JLabel lblCurrency;

   /**
    * @param metainfo Informations contenues dans le libellé.
    * @param data Contenu du champ texte.
    */
   public JMoneyInfoEditionLabel(Text metainfo, String data) {
      super(metainfo, data);
      initListeners();
      setDataAlignement(SwingConstants.RIGHT);
      tfdData.setColumns(tfdData.getColumns() - lblCurrency.getText().length());
   }
   
   /**
    * @param metainfo Informations contenues dans le libellé.
    */
   public JMoneyInfoEditionLabel(Text metainfo) {
      this(metainfo,"");
      
      // Si on met rien comme données dans le champs texte, c'est que l'on
      // veut saisir quelquechose.
      setEditable(true); 
      
   }
   
   /**
    * Place les composants du panel.
    */
   protected void buildContent() {      
      setLayout(new GridLayout(1, 3));
      add(lblMetaInfo);
      
      JPanel pnlMoney = new JPanel(new BorderLayout(5,0));
      add(pnlMoney);
      
      pnlMoney.add(tfdData, BorderLayout.CENTER);
      
      // Le label est défini ici pour des raisons pratiques.
      lblCurrency = new JLabel(Text.SWISS_FRANC_ACRONYM.toString());
      pnlMoney.add(lblCurrency, BorderLayout.EAST);
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
    * Est-ce que le contenu du champ text contient un nombre ?
    * @return true si le contenu du champs text est valide.
    */
   public boolean isNumber() {
      return isNumber;
   }
   
   /**
    * Initialise les listeners du composant.
    */
   private void initListeners() {
      addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            try {
               Double.parseDouble(tfdData.getText());
               setValid();
            }
            catch (Exception e) {
               setInvalid();
            }
         }
      });
   }
}
