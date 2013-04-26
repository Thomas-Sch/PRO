package database.dbComponents;

public class DBRecurrenceYearly extends DBRecurrence {

   Integer everyXYear;

   public Integer getEveryXYear() {
      return everyXYear;
   }

   public void setEveryXYear(Integer everyXYear) {
      this.everyXYear = everyXYear;
   }

   @Override
   public String toString() {
      return "DBRecurrenceYearly [everyXYear=" + everyXYear + ", name=" + name
            + ", start=" + start + ", end=" + end + ", id=" + id + "]";
   }

}
