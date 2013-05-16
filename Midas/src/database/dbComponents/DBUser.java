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

public class DBUser extends DBComponentEnableable {

   private String name;   

   /**
    * Initialise les champs qui ne representent pas une référence
    */
   public DBUser() {
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

}
