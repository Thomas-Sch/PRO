package database.dbComponents;

import java.util.Date;

public class DBRecurrence extends DBComponent {
   String name;
   Date start;
   Date end;
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
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
   
}
