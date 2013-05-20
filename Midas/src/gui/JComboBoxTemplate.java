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
   
   
   public boolean isCreateNewSelected() {
      if(firstUse) {
         return getSelectedIndex() == INDEX_NEW_FIRST_USE;
      }
      else {
         return getSelectedIndex() == INDEX_NEW;
      }
   }
   
   public boolean isInviteSelected() {
      return getSelectedIndex() == 0;
   }
   
   public void setFirstUse(boolean firstUse) {
      this.firstUse = firstUse;
   }
   
   public boolean isFirstUse() {
      return firstUse;
   }
   
   public int updateIndex() {
      int index = INDEX_NEW;
      if(isFirstUse()) {
         index = INDEX_NEW_FIRST_USE;
      }
      
      return index;
   }
}
