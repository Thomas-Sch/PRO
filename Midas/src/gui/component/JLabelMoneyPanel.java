/* ============================================================================
 * Nom du fichier   : JLabelMoneyPanel.java
 * ============================================================================
 * Date de création : 7 mai 2013
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

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

import settings.Language.Text;

/**
 * Classe permettant de saisir une somme d'argent
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JLabelMoneyPanel extends JLabelTextPanel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -3777685551501181998L;
   
   boolean isNumber;

   /**
    * Constructeur principal
    * @param textForLabel Somme d'argent.
    * @param textFieldColumns Taille du champ de saisie.
    */
   public JLabelMoneyPanel(Text textForLabel, int textFieldColumns) {
      super(textForLabel, textFieldColumns);
      initListeners();
   }
   
   /** 
    * Initialise les composants graphiques.
    */
   public void initContent(Text textForLabel, int textFieldColumns) {
      super.initContent(textForLabel, textFieldColumns);
      txtData.setHorizontalAlignment(JTextField.RIGHT);
      txtData.setText("0");
      setValid();
   }
   
   public void initListeners() {
      addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            try {
               Double.parseDouble(txtData.getText());
               setValid();
            }
            catch (Exception e) {
               setInvalid();
            }
         }
      });
   }
   
   /**
    * Indique que le nombre contenu dans le champ texte est invalide.
    */
   public void setInvalid() {
      isNumber = false;
      txtData.setForeground(Color.RED);
   }
   
   /**
    * Indique que le nombre contenu dans le champ texte est valide.
    */
   public void setValid() {
      isNumber = true;
      txtData.setForeground(Color.BLACK);
   }
   
   /**
    * Est-ce que le contenu du champ text contient un nombre ?
    * @return true si le contenu du champs text est valide.
    */
   public boolean isNumber() {
      return isNumber;
   }
   
   /**
    * Constructeur secondaire
    * @param textForLabel Somme d'argent.
    */
   public JLabelMoneyPanel(Text textForLabel) {
      this(textForLabel, defaultColumnsSize);
   }
}
