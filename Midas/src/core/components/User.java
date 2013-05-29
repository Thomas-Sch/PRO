/* ============================================================================
 * Nom du fichier   : User.java
 * ============================================================================
 * Date de création : 24 avr. 2013
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
import core.CoreComponent;
import core.IdentifiedComponent;
import database.dbComponents.DBUser;

/**
 * Cette classe représente un utilisateur / auteur et met à disposition un moyen
 * d'obtenir certaines informations associées audit utilisateur.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class User extends CoreComponent implements IdentifiedComponent {

   private DBUser dbUser;

   /**
    * Crée un utilisateur / auteur à partir de sa représentation dans la base de
    * données.
    * 
    * @param core
    *           - coeur logique du programme.
    * @param dbUser
    *           - l'utilisateur en provenance de la base de données.
    */
   public User(Core core, DBUser dbUser) {
      super(core);
      this.dbUser = dbUser;
   }

   /**
    * Construit un utilisateur fictif avec un nom uniquement.
    * 
    * <p>
    * <b>Attention : </b> ce constructeur ne doit être appelé que pour créer un
    * utilisateur fictif qui ne sera jamais envoyé à la base de données.
    * 
    * @param core
    *           - coeur logique du programme.
    * @param name
    *           - nom de l'utilisateur fictif.
    */
   User(Core core, String name) {
      super(core);

      dbUser = new DBUser();
      dbUser.setName(name);
   }

   /**
    * Retourne l'objet représentant cet utilisateur pour la base de données.
    * 
    * @return L'utilisateur sous une forme compatible avec la base de données.
    */
   public DBUser getDBUser() {
      return dbUser;
   }

   /**
    * Retourne le nom de l'utilisateur.
    * 
    * @return Le nom de l'utilisateur.
    */
   public String getName() {
      return dbUser.getName();
   }

   /**
    * Définit le nom de l'utilisateur.
    * 
    * @param name
    *           - le nom de l'utilisateur.
    */
   public void setName(String name) {
      dbUser.setName(name);
   }

   /**
    * Retourne l'identifiant de l'utilisateur dans la base de données.
    * 
    * @return L'identifiant de l'utilisateur.
    */
   public int getId() {
      return dbUser.getId();
   }

   /**
    * Retourne un affichage sous forme de chaîne de caractères.
    * <p>
    * La chaîne retournée correspond au nom afin de pouvoir profiter de cette
    * méthode dans les parties graphiques.
    * 
    * @return Une chaîne de caractères représentant l'utilisateur.
    */
   public String toString() {
      return getName();
   }
}
