package dbComponents;

public class DBBudget extends DBComponent {

   Double limit;
   Integer dbRecurrence;
   Integer dbAccount;
   
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

}
