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
 * Modèle pour les composants graphiques de liste déroulante.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * @param <E>
 *           - le type de données de la classe.
 * 
 */
public abstract class JComboBoxTemplate<E> extends JComboBox<E> implements View {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -2706536658657235248L;

   private final int INDEX_NEW = 0;
   private final int INDEX_NEW_FIRST_USE = 1;

   private boolean firstUse = true;

   /**
    * Retourne si le message d'invitation à ajouter un nouvel élément est
    * sélectionné ou non.
    * 
    * @return Vrai s'il est sélectionné, Faux le cas échéant.
    */
   public boolean isCreateNewSelected() {
      if (firstUse) {
         return getSelectedIndex() == INDEX_NEW_FIRST_USE;
      }
      else {
         return getSelectedIndex() == INDEX_NEW;
      }
   }

   /**
    * Retourne si le message d'invitation à sélectionner un élément de la liste
    * est sélectionné ou non.
    * 
    * @return Vrai s'il est sélectionné, Faux le cas échéant.
    */
   public boolean isInviteSelected() {
      return getSelectedIndex() == 0;
   }

   /**
    * Défini que le composant a déjà été utilisé une fois.
    * 
    * @param firstUse
    *           - Vrai s'il a déjà été utilisé, Faux le cas contraire.
    */
   public void setFirstUse(boolean firstUse) {
      this.firstUse = firstUse;
   }

   /**
    * Retourne si la liste déroulante à déjà été utilisée.
    * 
    * @return Vrai si elle a été utilisée au moins une fois, Faux le cas
    *         échéant.
    */
   public boolean isFirstUse() {
      return firstUse;
   }

   /**
    * Mise à jour des index de sélection du composant.
    * 
    * @return La valeur de l'index.
    */
   public int updateIndex() {
      int index = INDEX_NEW;
      if (isFirstUse()) {
         index = INDEX_NEW_FIRST_USE;
      }
      return index;
   }

   /**
    * Test et retourne si l'élément sélectionné dans la liste est un élément
    * valide et non un élément permettant d'interagir avec la liste.
    * 
    * @return Vrai si l'élément sélectionné dans la liste n'est pas un invite
    *         d'action, Faux la cas échéant.
    */
   public boolean isValidItemSelected() {
      return !(isCreateNewSelected() || isInviteSelected());
   }

   /**
    * Force la liste à sélectionner l'invite d'action.
    */
   public void setInviteSelected() {
      setSelectedIndex(0);
   }

}
