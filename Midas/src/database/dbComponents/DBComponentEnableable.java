/* ============================================================================
 * Nom du fichier   : DBComponentEnableable.java
 * ============================================================================
 * Date de création : 16.05.2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package database.dbComponents;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public abstract class DBComponentEnableable  extends DBComponent {

   private Boolean enabled;
   
   DBComponentEnableable() {
      enabled = true;
   }
   
   /**
    * @return le/la/les enabled
    */
   public Boolean getEnabled() {
      return enabled;
   }

   /**
    * @param name - la nouvelle valeur pour l'attribut enabled
    */
   public void setEnabled(Boolean enabled) {
      this.enabled = enabled;
   }

}
