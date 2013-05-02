/* ============================================================================
 * Nom du fichier   : DBCategory.java
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

public class DBCategory extends DBComponent {

   String name;
   Integer parentDBCategory;
   /**
    * @return retourne name
    */
   public String getName() {
      return name;
   }
   /**
    * @param name - la nouvelle valeur pour l'attribut name
    */
   public void setName(String name) {
      this.name = name;
   }
   /**
    * @return retourne parentDBCategory
    */
   public Integer getParentDBCategory() {
      return parentDBCategory;
   }
   /**
    * @param parentDBCategory - la nouvelle valeur pour l'attribut parentDBCategory
    */
   public void setParentDBCategory(Integer parentDBCategory) {
      this.parentDBCategory = parentDBCategory;
   }
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "DBCategory [name=" + name + ", parentDBCategory="
            + parentDBCategory + ", getId()=" + getId() + "]";
   }
}
