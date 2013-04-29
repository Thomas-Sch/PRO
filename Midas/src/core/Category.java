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
package core;

import java.util.Observable;

import database.dbComponents.DBCategory;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class Category extends DisplayableComponent {

   private DBCategory dbCategory;
   
   public Category (String name, Category parent) {
      this.dbCategory = new DBCategory();
      this.dbCategory.setName(name);
      this.dbCategory.setParentDBCategory(parent.getDBCategory().getId());
   }
   
   public Category (DBCategory dbCategory) {
      this.dbCategory = dbCategory;
   }
   
   public String consultName() {
      return dbCategory.getName();
   }
   
   public void modifyName(String name)
   {
      dbCategory.setName(name);
   }
   
   public Integer consultParentCategory() {
      return dbCategory.getParentDBCategory();
   }
  
   public void bindparentCategory(Category parentCategory) {
       dbCategory.setParentDBCategory(parentCategory.getDBCategory().getId());
   }
   
   protected  DBCategory getDBCategory() {
      return dbCategory;
   }
}

