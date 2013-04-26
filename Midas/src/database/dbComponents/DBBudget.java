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
      return "DBBudget [limit=" + limit + ", dbRecurrence=" + dbRecurrence
            + ", dbAccount=" + dbAccount + ", id=" + id + "]";
   }

}
