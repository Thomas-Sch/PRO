/* ============================================================================
 * Nom du fichier   : Categorie.java
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
import database.dbComponents.DBCategory;

/**
 * Cette classe représente une catégorie et met à disposition un moyen d'obtenir
 * certaines informations associées à ladite catégorie.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class Category extends CoreComponent implements IdentifiedComponent {

   private DBCategory dbCategory;

   /**
    * Crée une catégorie à partir de sa version correspondante de la base de
    * données.
    * 
    * @param core
    *           - coeur logique du programme.
    * @param dbCategory
    *           - la catégorie en provenance de la base de données.
    */
   public Category(Core core, DBCategory dbCategory) {
      super(core);
      this.dbCategory = dbCategory;
   }

   /**
    * Construit une catégorie fictive avec un nom uniquement.
    * 
    * <p>
    * <b>Attention : </b> ce constructeur ne doit être appelé que pour créer une
    * catégorie fictive qui ne sera jamais envoyée à la base de données.
    * 
    * @param core
    *           - coeur logique du programme.
    * @param name
    *           - nom de la catégorie fictive.
    */
   Category(Core core, String name) {
      super(core);
      dbCategory = new DBCategory();
      setName(name);
   }

   /**
    * Retourne l'objet représentant cette catégorie pour la base de données
    * 
    * @return la catégorie sous une forme compatible avec la base de données.
    */
   public DBCategory getDBCategory() {
      return dbCategory;
   }

   /**
    * Retourne le nom de la catégorie.
    * 
    * @return le nom de la catégorie.
    */
   public String getName() {
      return dbCategory.getName();
   }

   /**
    * Définit le nom de la catégorie.
    * 
    * @param name
    *           - le nom de la catégorie.
    */
   public void setName(String name) {
      dbCategory.setName(name);
      setChangedAndNotifyObservers();
   }

   /**
    * Retourne la catégorie parente si elle en a une.
    * 
    * @return la catégorie parente, null le cas échéant.
    */
   public Category getParentCategory() {
      if (dbCategory.getParentDBCategory() == null) {
         return null;
      }
      else {
         return core.getCategory(dbCategory.getParentDBCategory());
      }
   }

   /**
    * Définit la catégorie parente.
    * 
    * @param parentCategory
    *           - la catégorie parente.
    */
   public void setParentCategory(Category parentCategory) {
      dbCategory.setParentDBCategory(parentCategory.getId());
      setChangedAndNotifyObservers();
   }

   /**
    * Retourne l'identifiant de la catégorie dans la base de données.
    * 
    * @return l'ID de la catégorie.
    */
   public int getId() {
      return dbCategory.getId();
   }
   
   /**
    * 
    * Détermine si la catégorie est un enfant ou un parent.
    * @return True si cette catégorie possède un parent.
    */
   public boolean isChild() {
      return dbCategory.getParentDBCategory() != null;
   }

   /**
    * Retourne un affichage sous forme de chaîne de caractères.
    * 
    * La chaîne retournée correspond au nom afin de pouvoir profiter de cette
    * méthode dans les parties graphiques.
    * 
    * @return une chaîne de caractères représentant la catégorie.
    */
   public String toString() {
      return dbCategory.getName();
   }
}
