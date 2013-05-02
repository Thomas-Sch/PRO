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

   Integer id;
   
   public Integer getId() {
      return id;
   }
   
   void setId(Integer id) {
      this.id = id;
   }

}
