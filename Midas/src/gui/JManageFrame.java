/* ============================================================================
 * Nom du fichier   : JManageFrame.java
 * ============================================================================
 * Date de création : 21 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui;

import gui.component.JAddEditDelete;
import core.Core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * Classe parente pour les interfaces qui ont besoin des options de base : <li>
 * Ajouter</li> <li>Modifier</li> <li>Supprimer</li>
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public abstract class JManageFrame extends JDialog {

   /**
    * ID de série.
    */
   private static final long serialVersionUID = 3532238860718872672L;

   // Etat de l'interface (contrôlé en interne).
   protected enum State {
      EDITION, VIEW
   };

   protected State state;
   protected Core core;

   protected JAddEditDelete aedActions;
   protected JPanel pnlInfosActions;

   /**
    * Crée le canevas de l'interface.
    * 
    * @param controller
    *           - contrôleur de cet objet.
    */
   public JManageFrame(Core core) {
      this.core = core;
      state = State.VIEW;
      initContent();
      initListeners();
      setContentPane(buildContent());
      pack();
   }

   /**
    * Initialise les composants graphiques.
    */
   protected void initContent() {
      aedActions = new JAddEditDelete();
      pnlInfosActions = new JPanel();

      // On désactive les boutons qui utilisent une sélection de la liste car
      // aucun compte n'est sélectionné par défaut.
      setEnabledItemDependantButtons(false);
   }

   /**
    * Initialise les "listeners" internes au composant graphique.
    */
   protected void initListeners() {
      aedActions.addModifyActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            switch (state) {
               case VIEW:
                  state = State.EDITION;
                  break;

               case EDITION:
                  state = State.VIEW;
                  break;
            }

            setEnabledOnEdition(state == State.EDITION);
            setEnabledOnView(state == State.VIEW);
            aedActions.setButtonAddEnabled(state == State.VIEW);
            aedActions.setButtonDeleteEnabled(state == State.VIEW);
            pack();
         }
      });
   }

   /**
    * Définit si le composant est actif ou non lors de l'édition.
    * 
    * @param b
    *           - l'état lors de l'édition.
    */
   protected abstract void setEnabledOnEdition(boolean b);

   /**
    * Définit si le composant est actif ou non lors de la visualisation.
    * 
    * @param b
    *           - l'état lors de la visualisation.
    */
   protected abstract void setEnabledOnView(boolean b);

   /**
    * Construction des éléments de la vue.
    * 
    * @return Le panneau contenant les éléments graphiques.
    */
   protected abstract JPanel buildContent();

   /**
    * Active ou désactive les boutons qui dépendent d'un compte cible.
    * 
    * @param b
    *           - nouvel état d'activation des boutons.
    */
   protected void setEnabledItemDependantButtons(boolean b) {
      aedActions.setButtonDeleteEnabled(b);
      aedActions.setButtonModifyEnabled(b);
   }

   /**
    * Active ou désactive le bouton de validation.
    * 
    * @param b
    *           - valeur d'activation.
    */
   public void setEnabledValidateButton(boolean b) {
      aedActions.setButtonModifyEnabled(b);
   }

   /**
    * Ajout de l'action à effectuer lors du clique sur le bouton d'ajout.
    * 
    * @param listener
    *           - l'action à effectuer.
    */
   public void addButtonAddListener(ActionListener listener) {
      aedActions.addAddActionListener(listener);
   }

   /**
    * Ajout de l'action à effectuer lors du clique sur le bouton de
    * modification.
    * 
    * @param listener
    *           - l'action à effectuer.
    */
   public void addButtonModifyListener(ActionListener listener) {
      aedActions.addModifyActionListener(listener);
   }

   /**
    * Ajout de l'action à effectuer lors du clique sur le bouton de suppression
    * 
    * @param listener
    *           - l'action à effectuer.
    */
   public void addButtonDeleteListener(ActionListener listener) {
      aedActions.addDeleteActionListener(listener);
   }
   
   /**
    * Sauvegarde l'item modifié dans l'interface.
    */
   public abstract void saveItem();
   
   /**
    * Force la liste de l'interface à ne sélectionner aucun item.
    */
   public abstract void selectNoItem();
}
