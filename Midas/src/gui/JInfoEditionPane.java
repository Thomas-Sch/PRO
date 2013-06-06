/* ============================================================================
 * Nom du fichier   : JInfoEditionPane.java
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
package gui;

import gui.component.JInfoEditionLabel;

import java.awt.Container;
import java.util.LinkedList;

import javax.swing.JPanel;

/**
 * Panel d'affichage ou de modification d'informations.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * @param <E>
 *
 */
public abstract class JInfoEditionPane<E> extends JPanel {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -1271766180763265086L;
   
   // Données représentées par ce panel.
   // (En protected pour gagner en lisibilité chez les enfants.)
   protected E data;
   
   private JManageFrame parent;
   
   private LinkedList<JInfoEditionLabel> list;
   
   /**
    * Constructeur par défaut => aucune information à afficher.
    */
   public JInfoEditionPane () {
   }

   /**
    * La classe ce met en mode "Présentation des données".
    * @param parent Fenêtre parente qui contient cet objet.
    * @param container Container direct de cet objet.
    * @param last Objet précédent affiché de cette classe.
    * @param data Les nouvelles données à afficher.
    */
   public JInfoEditionPane (JManageFrame parent, Container container, JInfoEditionPane<E> last, E data) {
      this(parent, container, last, data, false);
   }
   
   /**
    * La classe se met en mode "Edition" ou "Présentation de données".
    * @param parent Fenêtre parente qui contient cet objet.
    * @param container Container direct de cet objet.
    * @param last Objet précédent affiché de cette classe.
    * @param data Les nouvelles données à afficher.
    * @param edition True => mode "Edition". False => "Présentation de données".
    */
   public JInfoEditionPane (JManageFrame parent, Container container, JInfoEditionPane<E> last, E data, boolean edition) {
      // On enlève ce qui était affiché avant.
      container.remove(last);
      this.data = data;
      this.parent = parent;
      
      // On initialise le contenu et récupère la liste des composants.
      list = initContent(data);
      
      setEditable(edition);

      initListeners();
      buildContent();
      
      // On ajout ce que l'on vient de créer.
      container.add(this);
      parent.pack(); // On adapte la fenêtre pour afficher le nouveau contenu crée.
   }
   
   /**
    * Initialise les listeners propre à ce panel.
    */
   public abstract void initListeners();

   /**
    * Initialise les composants du panel et les ajoute dans la liste des champs.
    */
   public abstract LinkedList<JInfoEditionLabel> initContent(E data);
   
   /**
    * Construit et place les composants sur le panel.
    */
   public abstract void buildContent();
   
   /**
    * Change l'état des champs pour les éditer ou les bloquer.
    * @param b True => les champs sont éditables.
    */
   public void setEditable(boolean b) {
      // On rend les champs éditables ou non selon les préférences fournies.
      if(list != null) {
         for(JInfoEditionLabel ielItem : list) {
            ielItem.setEditable(b);
         }
      }
   }
   
   /**
    * Active ou désactive le bouton de validation.
    * @param b La nouvelle valeur d'activation.
    */
   protected void setEnabledValidateButton(boolean b) {
      parent.setEnabledValidateButton(b);
   }
}
