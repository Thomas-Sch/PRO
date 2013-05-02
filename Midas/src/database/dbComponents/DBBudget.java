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

   String name; 
   Double limit;
   Integer dbRecurrence;
   Integer dbAccount;
   
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public Double getLimit() {
      return limit;
   }
   public void setLimit(Double limit) {
      this.limit = limit;
   }
   public Integer getDbRecurrence() {
      return dbRecurrence;
   }
   public void setDbRecurrence(Integer dbRecurrence) {
      this.dbRecurrence = dbRecurrence;
   }
   public Integer getDbAccount() {
      return dbAccount;
   }
   public void setDbAccount(Integer dbAccount) {
      this.dbAccount = dbAccount;
   }
   @Override
   public String toString() {
      return "DBBudget [name=" + name + ", limit=" + limit + ", dbRecurrence="
            + dbRecurrence + ", dbAccount=" + dbAccount + ", id=" + id + "]";
   }




}
