/* ============================================================================
 * Nom du fichier   : CategoryList.java
 * ============================================================================
 * Date de création : 14 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core.components;

import core.Core;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class CategoryList extends ListTemplate<Category> {

   /**
    * @param core
    */
   public CategoryList(Core core) {
      super(core);
   }

   /* (non-Javadoc)
    * @see core.components.ListTemplate#createFalseEntry(java.lang.String)
    */
   @Override
   public Category createFalseEntry(String name) {
      return new Category(core, name);
   }

   /* (non-Javadoc)
    * @see core.components.ListTemplate#get(int)
    */
   @Override
   public Category get(int id) {
      for(Category category : getList()) {
         if (category.getId() == id) {
            return category;
         }
      }
      return null;
   }

}
