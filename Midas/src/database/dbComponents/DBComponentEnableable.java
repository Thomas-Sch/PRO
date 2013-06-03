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
 * Représente un composant de la base de données pouvant être actif ou non afin
 * de le conserver en tant qu'historique dans le second cas.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public abstract class DBComponentEnableable extends DBComponent {

   private Boolean enabled;

   /**
    * Crée un composant actif ou non.
    */
   DBComponentEnableable() {
      enabled = true;
   }

   /**
    * Retourne si le composant est actif ou non.
    * 
    * @return Vrai s'il est actif, Faux le cas échéant.
    */
   public Boolean getEnabled() {
      return enabled;
   }

   /**
    * Définit l'état actif ou non du composant.
    * 
    * @param enabled
    *           - la nouvelle valeur pour l'attribut enabled. Vrai pour un
    *           composant actif, Faux pour un inactif.
    */
   public void setEnabled(Boolean enabled) {
      this.enabled = enabled;
   }

}
