package database.dbComponents;

public class DBRecurrenceMonthly extends DBRecurrence {

   Integer everyXMonth;

   public Integer getEveryXMonth() {
      return everyXMonth;
   }

   public void setEveryXMonth(Integer everyXMonth) {
      this.everyXMonth = everyXMonth;
   }

   @Override
   public String toString() {
      return "DBRecurrenceMonthly [everyXMonth=" + everyXMonth + ", name="
            + name + ", start=" + start + ", end=" + end + ", id=" + id + "]";
   }

}
