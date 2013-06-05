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
 * Représente une catégorie ou une sous-catégorie.
 * 
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
    * Crée une catégorie , et initialise les champs qui ne représentent pas une
    * référence sur un autre élément.
    */
   public DBCategory() {
      name = "";
   }

   /**
    * Retourne le nom de la catégorie.
    * 
    * @return Le nom de la catégorie.
    */
   public String getName() {
      return name;
   }

   /**
    * Définit le nom de la catégorie
    * 
    * @param name
    *           - le nouveau nom.
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * Retourne l'identifiant de la catégorie parente.
    * 
    * @return L'identifant de la catégorie parente, null s'il n'y en a pas.
    */
   public Integer getParentDBCategory() {
      return parentDBCategory;
   }

   /**
    * Définit la catégorie parente comme étant celle correspondant à
    * l'identifiant donné.
    * 
    * @param parentDBCategory
    *           - l'identifiant de la nouvelle catégorie parente.
    */
   public void setParentDBCategory(Integer parentDBCategory) {
      this.parentDBCategory = parentDBCategory;
   }

   @Override
   public String toString() {
      return "DBCategory [name=" + name + ", parentDBCategory="
            + parentDBCategory + ", getEnabled()=" + getEnabled()
            + ", getId()=" + getId() + "]";
   }

}
