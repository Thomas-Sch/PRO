/* ============================================================================
 * Nom du fichier   : Categorie.java
 * ============================================================================
 * Date de cr�ation : 24 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi S�bastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Gr�goire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core.components;

import core.Core;
import database.dbComponents.DBCategory;

/**
 * Cette classe represente une categorie
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class Category extends CoreComponent {

   /**
    * variables d'une categorie
    */
   private DBCategory dbCategory;

   /**
    * Construit l'object Category
    * @param core - coeur logique du programme 
    * @param dbCategory - variable de la classe Category
    */
   public Category (Core core, DBCategory dbCategory) {
     super(core);
     this.dbCategory = dbCategory;
   }
   
   public Category(Core core, String name) {
      super(core);
      dbCategory = new DBCategory();
      setName(name);
   }
   
   public DBCategory getDBCategory() {
      return dbCategory;
   }
   
   /**
    * Consulte le nom de la catégorie.
    * @return le nom de la catégorie.
    */
   public String getName() {
      return dbCategory.getName();
   }
   
   /**
    * modifie le nom de la categorie
    * @param name - le nom de la categorie
    */
   public void setName(String name)
   {
      dbCategory.setName(name);
   }
   
   /**
    * consulte la categorie parente
    * @return la categorie parente
    */
   public Category getParentCategory() {
      return core.getCategory(dbCategory.getParentDBCategory());
   }
  
   /**
    * modifie la categorie parente
    * @param parentCategory - la categorie parente
    */
   public void setParentCategory(Category parentCategory) {
       dbCategory.setParentDBCategory(parentCategory.getId());
   }
   
   /**
    * Obtenir le numero d'identification de la categorie dans la base de donnee
    * @return l'ID de la categorie
    */
   public int getId() {
      return dbCategory.getId();
   }
   
   public String toString() {
      return dbCategory.getName();
   }
}

