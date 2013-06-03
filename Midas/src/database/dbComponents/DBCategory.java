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

/**
 * 
 * Cette classe represente une catégorie ou une sous-catégorie
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class DBCategory extends DBComponentEnableable {

   private String name;
   private Integer parentDBCategory;
   
   /**
    * Initialise les champs qui ne representent pas une référence
    */
   public DBCategory() {
      name = "";
   }
   
   /**
    * @return le/la/les name
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
    * @return le/la/les parentDBCategory
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
            + parentDBCategory + ", getEnabled()=" + getEnabled()
            + ", getId()=" + getId() + "]";
   }
   
}
