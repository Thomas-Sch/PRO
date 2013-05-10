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

public abstract class DBComponent {

   private Integer id;

   /**
    * @return le/la/les id
    */
   public Integer getId() {
      return id;
   }
   /**
    * @param id - la nouvelle valeur pour l'attribut id
    */
   public void setId(Integer id) {
      this.id = id;
   }
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "DBComponent [id=" + id + "]";
   }
}
