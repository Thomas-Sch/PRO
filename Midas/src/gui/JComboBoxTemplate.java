/* ============================================================================
 * Nom du fichier   : JComboBoxTemplate.java
 * ============================================================================
 * Date de création : 13 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui;

import javax.swing.JComboBox;

/**
 * Classe modèle pour les composants graphique de liste déroulante.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * @param <E> Type de données de la classe.
 *
 */
public abstract class JComboBoxTemplate<E> extends JComboBox<E> implements View{

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -2706536658657235248L;
   
   private final int INDEX_NEW = 0;
   private final int INDEX_NEW_FIRST_USE = 1;
   
   private boolean firstUse = true;
   
   /**
    * Est-ce que le message d'invite à ajouter un nouvel item est
    * sélectionné ?
    * @return True si c'est le cas.
    */
   public boolean isCreateNewSelected() {
      if(firstUse) {
         return getSelectedIndex() == INDEX_NEW_FIRST_USE;
      }
      else {
         return getSelectedIndex() == INDEX_NEW;
      }
   }
   
   /**
    * Est-ce que le message d'invite à sélectionner un item de la liste est
    * sélectionné ?
    * @return True si c'est le cas.
    */
   public boolean isInviteSelected() {
      return getSelectedIndex() == 0;
   }
   
   /**
    * Défini que le composant a déjà été utilisé une fois.
    * @param firstUse
    */
   public void setFirstUse(boolean firstUse) {
      this.firstUse = firstUse;
   }
   
   /**
    * Renvoie si la comboBox à déjà été utilisée.
    * @return True => Déjà utilisée au moins une fois.
    */
   public boolean isFirstUse() {
      return firstUse;
   }
   
   /**
    * Mise à jour des index de sélection du composant.
    * @return
    */
   public int updateIndex() {
      int index = INDEX_NEW;
      if(isFirstUse()) {
         index = INDEX_NEW_FIRST_USE;
      }  
      return index;
   }
   
   /**
    * Vérifie si l'item sélectionné dans la liste n'est pas un invite d'action.
    * @return Si l'item sélectionné dans la liste n'est pas un invite d'action.
    */
   public boolean isValidItemSelected() {
      return !(isCreateNewSelected() || isInviteSelected());
   }

}
