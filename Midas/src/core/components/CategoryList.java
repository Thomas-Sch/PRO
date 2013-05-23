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
 * Représente une liste de catégories.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class CategoryList extends ListTemplate<Category> {

   /**
    * Crée une liste de catégories, notifiant ses observateurs lorsqu'elle est
    * mise à jour.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public CategoryList(Core core) {
      super(core);
   }

   @Override
   public Category createFalseEntry(String name) {
      return new Category(core, name);
   }

   @Override
   public Category get(int id) {
      for (Category category : getList()) {
         if (category.getId() == id) {
            return category;
         }
      }
      return null;
   }

}
