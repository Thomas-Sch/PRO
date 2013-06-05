/* ============================================================================
 * Nom du fichier   : DBBudget.java
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
 * Représente un budget pour la base de données, et met à disposition
 * les fonctions de manipulations de base. 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class DBBudget extends DBComponentEnableable {

   private String name; 
   private String description;
   private Double limit;
   private Integer dbRecurrence;
   private Integer dbAccount;
   
   /**
    * Crée un budget, et initialise les champs qui ne
    * représentent pas une référence sur un autre élément.
    */
   public DBBudget() {
      name = "";
      description = "";
      limit = 0.0;
   }
   
   /**
    * Retourne le nom du budget.
    * @return Le nom du budget.
    */
   public String getName() {
      return name;
   }
   
   /**
    * Définit le nom du budget. TODO
    * @param name - la nouvelle valeur pour l'attribut name
    */
   public void setName(String name) {
      this.name = name;
   }
   /**
    * @return the description
    */
   public String getDescription() {
      return description;
   }

   /**
    * @param description the description to set
    */
   public void setDescription(String description) {
      this.description = description;
   }
   /**
    * @return le/la/les limit
    */
   public Double getLimit() {
      return limit;
   }
   /**
    * @param limit - la nouvelle valeur pour l'attribut limit
    */
   public void setLimit(Double limit) {
      this.limit = limit;
   }
   /**
    * @return le/la/les dbRecurrence
    */
   public Integer getDbRecurrence() {
      return dbRecurrence;
   }
   /**
    * @param dbRecurrence - la nouvelle valeur pour l'attribut dbRecurrence
    */
   public void setDbRecurrence(Integer dbRecurrence) {
      this.dbRecurrence = dbRecurrence;
   }
   /**
    * @return le/la/les dbAccount
    */
   public Integer getDbAccount() {
      return dbAccount;
   }
   /**
    * @param dbAccount - la nouvelle valeur pour l'attribut dbAccount
    */
   public void setDbAccount(Integer dbAccount) {
      this.dbAccount = dbAccount;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "DBBudget [name=" + name + ", description=" + description
            + ", limit=" + limit + ", dbRecurrence=" + dbRecurrence
            + ", dbAccount=" + dbAccount + ", getEnabled()=" + getEnabled()
            + ", getId()=" + getId() + "]";
   } 

}
