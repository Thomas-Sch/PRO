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

import gui.utils.TextChangedListener;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import settings.Language.Text;

/**
 * Représente un champ de texte qui peut être éditable ou non.
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
   
   protected JLabel lblMetaInfo;
   protected JTextField tfdData;
   
   /**
    * Contructeur de la classe.
    * @param metainfo Contenu du label de présentation de la donnée.
    * @param data Donnée présentée.
    */
   public JInfoEditionLabel (Text metainfo, String data) {
      initContent(metainfo, data);
      buildContent();
   }
   
   /**
    * @param metainfo Informations contenues dans le libellé.
    */
   public JInfoEditionLabel(Text metainfo) {
      this(metainfo,"");
      
      // Si on met rien comme données dans le champs texte, c'est que l'on
      // veut saisir quelquechose.
      setEditable(true); 
   }
   
   /**
    * Initialise les composants du panel.
    * @param metainfo Contenu du label de présentation de la donnée.
    * @param data Donnée présentée.
    */
   private void initContent(Text metainfo, String data) {
      lblMetaInfo = new JLabel(metainfo.toString());
      tfdData = new JTextField(data, nbRows);
      tfdData.setEditable(false); // On ne peut pas éditer par défaut.
   }
   
   /**
    * Place les composants du panel.
    */
   protected void buildContent() {
      setLayout(new GridLayout(1, 2));
      add(lblMetaInfo);
      add(tfdData); 
   }
   
   /**
    * Rends le champ de donnée éditable ou non.
    * @param b True si la zone de texte est éditable.
    */
   public void setEditable(boolean b) {
      tfdData.setEditable(b);
   }
   
   /**
    * Ajout un écouteur sur l'action de taper du texte dans le champ de saisie.
    * @param listener Action à effectuer lorsque cela se produit.
    */
   public void addTextChangedListener(TextChangedListener listener) {
      TextChangedListener.addListener(tfdData, listener);
   }
   
   /**
    * Renovie le contenu de la zone de texte.
    * @return Le contenu de la zone de texte.
    */
   public String getText() {
      if(tfdData == null) {
         return "";
      }
      return tfdData.getText();
   }
   
   /**
    * Modifie l'alignement des données présentées ou éditées.
    * @param alignment Alignement des données dans leur composant d'affichage.
    */
   public void setDataAlignement(int alignment) {
      tfdData.setHorizontalAlignment(alignment);
   }
   
   /**
    * Change la couleur du texte des données.
    * @param c Nouvelle couleur.
    */
   public void setColor(Color c) {
      tfdData.setForeground(c);
   }
   
   /**
    * Change le texte du champs de données.
    * @param s Le nouveau texte.
    */
   public void setText(String s) {
      tfdData.setText(s);
   }
   
   /**
    * Renvoie true si le champs de saisie contient une saisie valide.
    * En l'occurence, le champs est valide s'il n'est pas vide.
    */
   public boolean isValidData() {
      return getText().length() != 0;
   }
}
