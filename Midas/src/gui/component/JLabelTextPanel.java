/* ============================================================================
 * Nom du fichier   : JLabelTextPanel.java
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

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import settings.Language.Text;

/**
 * 
 * Classe de saisie d'information.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JLabelTextPanel extends JPanel {
   
   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -1297406355333906465L;
   
   protected static final int defaultColumnsSize = 20;
   
   protected JLabel lblLabel;
   protected JTextField txtData;
   
   /**
    * Constructeur du composant graphique
    * @param textForLabel Le texte du label de présentation de l'information.
    * @param textFieldColumns Taille du champ de saisie.
    */
   public JLabelTextPanel(Text textForLabel, int textFieldColumns) {
      initContent(textForLabel, textFieldColumns);
      buildContent();    
   }
   
   /**
    * Constructeur secondaire qui utilise la taille du champ de saisie
    * par défaut.
    * @param textForLabel
    */
   public JLabelTextPanel(Text textForLabel) {
      this(textForLabel, defaultColumnsSize);
   }
   
   /** 
    * Initialise les composants graphiques.
    */
   public void initContent(Text textForLabel, int textFieldColumns) {
      lblLabel = new JLabel(textForLabel.toString());
      txtData = new JTextField();
      txtData.setColumns(textFieldColumns);
   }
   
   /**
    * Construit le composant graphique de cette classe.
    */
   public void buildContent() {
      setLayout(new BorderLayout(5,5));
      
      add(lblLabel, BorderLayout.WEST);
      add(txtData, BorderLayout.EAST);  
      
   }
   
   /**
    * Fixe le texte contenu dans le champ de saisie.
    * @param text
    */
   public void setText(String text) {
      txtData.setText(text);
   }
   
   /**
    * Récupère le texte saisi dans le champ de saisie.
    * @return
    */
   public String getText() {
      return txtData.getText();
   }
   
   /**
    * Ajout un écouteur sur l'action de taper du texte dans le champ de saisie.
    * @param listener Action à effectuer lorsque cela se produit.
    */
   public void addTextChangedListener(TextChangedListener listener) {
      TextChangedListener.addListener(txtData, listener);
   }
   
}