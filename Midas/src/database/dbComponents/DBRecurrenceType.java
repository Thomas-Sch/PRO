package database.dbComponents;

public class DBRecurrenceType extends DBComponent{

   String type;

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   @Override
   public String toString() {
      return "DBRecurrenceType [type=" + type + ", id=" + id + "]";
   }

}
