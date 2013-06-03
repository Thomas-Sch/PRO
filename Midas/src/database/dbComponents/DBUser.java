/* ============================================================================
 * Nom du fichier   : DBUser.java
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
 * Représente un utilisateur pour la base de données, et met à disposition les
 * fonctions de manipulations de base.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class DBUser extends DBComponentEnableable {

   private String name;

   /**
    * Initialise les champs qui ne représentent pas une référence.
    */
   public DBUser() {
      name = "";
   }

   /**
    * Retourne le nom de l'utilisateur.
    * 
    * @return Le nom de l'utilisateur.
    */
   public String getName() {
      return name;
   }

   /**
    * Définit le nom de l'utilisateur.
    * 
    * @param name
    *           - la nouveau nom de l'utilisateur.
    */
   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return "DBUser [name=" + name + ", getEnabled()=" + getEnabled()
            + ", getId()=" + getId() + "]";
   }

}
