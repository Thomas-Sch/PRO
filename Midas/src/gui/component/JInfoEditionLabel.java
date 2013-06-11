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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import settings.Language.Text;

/**
 * Représente un champ de texte qui peut être éditable ou non.
 * 
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
    * Crée le champ texte.
    * 
    * @param metainfo
    *           - les informations contenues dans le libellé.
    * @param data
    *           - la donnée présentée.
    */
   public JInfoEditionLabel(Text metainfo, String data) {
      initContent(metainfo, data);
      buildContent();
   }

   /**
    * Crée le champ texte.
    * 
    * @param metainfo
    *           - les informations contenues dans le libellé.
    */
   public JInfoEditionLabel(Text metainfo) {
      this(metainfo, "");

      // Si on met rien comme données dans le champs texte, c'est que l'on
      // veut saisir quelque chose.
      setEditable(true);
   }

   /**
    * Initialise les composants du panneau.
    * 
    * @param metainfo
    *           - les informations contenues dans le libellé.
    * @param data
    *           - la donnée présentée.
    */
   private void initContent(Text metainfo, String data) {
      lblMetaInfo = new JLabel(metainfo.toString());
      tfdData = new JTextField(data, nbRows);
      tfdData.setEditable(false); // On ne peut pas éditer par défaut.
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

      constraints.fill = GridBagConstraints.NONE;
      constraints.insets = new Insets(0, 20, 0, 0);
      constraints.anchor = GridBagConstraints.EAST;
      constraints.weightx = 1.0;
      constraints.gridx = 1;
      add(tfdData, constraints);
   }

   /**
    * Rend le champ de donnée éditable ou non.
    * 
    * @param b
    *           - Vrai si la zone de texte est éditable, Faux si elle ne l'est
    *           pas.
    */
   public void setEditable(boolean b) {
      tfdData.setEditable(b);
   }

   /**
    * Ajoute un écouteur sur l'action de taper du texte dans le champ de saisie.
    * 
    * @param listener
    *           - l'écouteur à ajouter.
    */
   public void addTextChangedListener(TextChangedListener listener) {
      TextChangedListener.addListener(tfdData, listener);
   }

   /**
    * Retourne le contenu de la zone de texte.
    * 
    * @return Le contenu de la zone de texte.
    */
   public String getText() {
      if (tfdData == null) {
         return "";
      }
      return tfdData.getText();
   }

   /**
    * Modifie l'alignement des données présentées ou éditées.
    * 
    * @param alignment
    *           - l'alignement des données dans leur composant d'affichage.
    */
   public void setDataAlignement(int alignment) {
      tfdData.setHorizontalAlignment(alignment);
   }

   /**
    * Change la couleur du texte des données.
    * 
    * @param c
    *           - la nouvelle couleur.
    */
   public void setColor(Color c) {
      tfdData.setForeground(c);
   }

   /**
    * Change le texte du champs de données.
    * 
    * @param s
    *           - le nouveau texte.
    */
   public void setText(String s) {
      tfdData.setText(s);
   }

   /**
    * Retourne si le champs de saisie contient une saisie valide ou non. En
    * l'occurence, le champs est valide s'il n'est pas vide.
    * 
    * @return Vrai si le champ est valide, Faux le cas échéant.
    */
   public boolean isValidData() {
      return getText().length() != 0;
   }
}
