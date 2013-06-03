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
 * 
 * Cette classe represente un budget 
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
    * Initialise les champs qui ne representent pas une référence
    */
   public DBBudget() {
      name = "";
      description = "";
      limit = 0.0;
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
