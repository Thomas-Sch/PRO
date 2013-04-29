package database.dbComponents;

import java.util.Date;

public abstract class DBRecurrence extends DBComponent {

   private Date start;
   private Date end;
   private DBRecurrenceType type;
   
   public Date getStart() {
      return start;
   }
   public void setStart(Date start) {
      this.start = start;
   }
   public Date getEnd() {
      return end;
   }
   public void setEnd(Date end) {
      this.end = end;
   }
   public DBRecurrenceType getType() {
      return type;
   }
   public void setType(DBRecurrenceType type) {
      this.type = type;
   }
   @Override
   public String toString() {
      return "DBRecurrence [start=" + start + ", end=" + end + ", type=" + type
            + ", id=" + id + "]";
   }

}
