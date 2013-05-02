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

public class DBBudget extends DBComponent {

   private String name; 
   private Double limit;
   private Integer dbRecurrence;
   private Integer dbAccount;
   
   /**
    * @return retourne name
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
    * @return retourne limit
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
    * @return retourne dbRecurrence
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
    * @return retourne dbAccount
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
      return "DBBudget [name=" + name + ", limit=" + limit + ", dbRecurrence="
            + dbRecurrence + ", dbAccount=" + dbAccount + ", getId()="
            + getId() + "]";
   }

}
