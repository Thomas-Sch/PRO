/* ============================================================================
 * Nom du fichier   : DBComponent.java
 * ============================================================================
 * Date de création : 02.05.2013
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
 * Représente un composant de la base de données.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public abstract class DBComponent {

   private Integer id;

   /**
    * Retourne l'identifiant pour la base de données du composant.
    * @return L'identifiant.
    */
   public Integer getId() {
      return id;
   }
   
   /**
    * Définit l'identifiant pour la base de données du composant.
    * @param id - le nouvel identifiant.
    */
   protected void setId(Integer id) {
      this.id = id;
   }
   
   @Override
   public String toString() {
      return "DBComponent [id=" + id + "]";
   }
}
