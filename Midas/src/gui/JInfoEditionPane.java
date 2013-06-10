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
 * Panneau d'affichage ou de modification d'informations.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * @param <E> - le type de données.
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
    * Crée le panneau sans aucune information à afficher.
    */
   public JInfoEditionPane() {

   }

   /**
    * Crée le panneau et se met en mode "Présentation des données".
    * 
    * @param parent
    *           - fenêtre parente qui contient cet objet.
    * @param container
    *           - container direct de cet objet.
    * @param last
    *           - objet précédent affiché de cette classe.
    * @param data
    *           - les nouvelles données à afficher.
    */
   public JInfoEditionPane(JManageFrame parent, Container container,
         JInfoEditionPane<E> last, E data) {
      this(parent, container, last, data, false);
   }

   /**
    * Crée le panneau en mode "Edition" ou "Présentation de données".
    * 
    * @param parent
    *           - fenêtre parente qui contient cet objet.
    * @param container
    *           - container direct de cet objet.
    * @param last
    *           - objet précédent affiché de cette classe.
    * @param data
    *           - les nouvelles données à afficher.
    * @param edition
    *           - Vrai pour le mode "Edition", Faux pour le mode
    *           "Présentation de données".
    */
   public JInfoEditionPane(JManageFrame parent, Container container,
         JInfoEditionPane<E> last, E data, boolean edition) {
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
      parent.pack(); // On adapte la fenêtre pour afficher le nouveau contenu
                     // crée.
   }

   /**
    * Initialise les listeners propres à ce panneau.
    */
   public abstract void initListeners();

   /**
    * Initialise les composants du panneau et les ajoute dans la liste des
    * champs.
    */
   public abstract LinkedList<JInfoEditionLabel> initContent(E data);

   /**
    * Construit et place les composants sur le panneau.
    */
   public abstract void buildContent();

   /**
    * Change l'état des champs pour les éditer ou les bloquer.
    * 
    * @param b
    *           - Vrai si les champs sont éditables, Faux dans le cas contraire.
    */
   public void setEditable(boolean b) {
      // On rend les champs éditables ou non selon les préférences fournies.
      if (list != null) {
         for (JInfoEditionLabel ielItem : list) {
            ielItem.setEditable(b);
         }
      }
   }

   /**
    * Active ou désactive le bouton de validation.
    * 
    * @param b
    *           - la nouvelle valeur d'activation.
    */
   protected void setEnabledValidateButton(boolean b) {
      parent.setEnabledValidateButton(b);
   }
   
   /**
    * Sauvegarde l'item modifié dans l'interface.
    */
   public abstract void saveItem();
}
