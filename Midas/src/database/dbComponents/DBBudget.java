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
 * Représente un budget pour la base de données, et met à disposition les
 * fonctions de manipulations de base.
 * 
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
    * Crée un budget, et initialise les champs qui ne représentent pas une
    * référence sur un autre élément.
    */
   public DBBudget() {
      name = "";
      description = "";
      limit = 0.0;
   }

   /**
    * Retourne le nom du budget.
    * 
    * @return Le nom du budget.
    */
   public String getName() {
      return name;
   }

   /**
    * Définit le nom du budget.
    * 
    * @param name
    *           - le nouveau nom.
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * Retourne la description du budget.
    * 
    * @return La description du budget.
    */
   public String getDescription() {
      return description;
   }

   /**
    * Définit la description du budget.
    * 
    * @param description
    *           - la nouvelle description.
    */
   public void setDescription(String description) {
      this.description = description;
   }

   /**
    * Retourne la valeur du seuil fixé au budget.
    * 
    * @return Le seuil du budget.
    */
   public Double getLimit() {
      return limit;
   }

   /**
    * Définit la valeur du seuil du budget.
    * 
    * @param limit
    *           - le nouveau seuil.
    */
   public void setLimit(Double limit) {
      this.limit = limit;
   }

   /**
    * Retourne l'identifiant de la récurrence du budget.
    * 
    * @return L'identifiant de la récurrence, null s'il n'y en a pas.
    */
   public Integer getDbRecurrence() {
      return dbRecurrence;
   }

   /**
    * Définit la récurrence du budget à partir l'identifiant de celle-ci.
    * 
    * @param dbRecurrence
    *           - l'identifiant de la récurrence à associer au budget.
    */
   public void setDbRecurrence(Integer dbRecurrence) {
      this.dbRecurrence = dbRecurrence;
   }

   /**
    * Retourne l'identifiant du compte auquel est associé le budget.
    * 
    * @return L'identifiant du compte associé, null s'il n'y en a pas.
    */
   public Integer getDbAccount() {
      return dbAccount;
   }

   /**
    * Définit le compte auquel est associé ce budget.
    * 
    * @param dbAccount
    *           - l'identifiant du compte auquel associer ce budget.
    */
   public void setDbAccount(Integer dbAccount) {
      this.dbAccount = dbAccount;
   }

   @Override
   public String toString() {
      return "DBBudget [name=" + name + ", description=" + description
            + ", limit=" + limit + ", dbRecurrence=" + dbRecurrence
            + ", dbAccount=" + dbAccount + ", getEnabled()=" + getEnabled()
            + ", getId()=" + getId() + "]";
   }

}
