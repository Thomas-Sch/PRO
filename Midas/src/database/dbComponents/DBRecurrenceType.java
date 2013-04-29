package database.dbComponents;

public class DBRecurrenceType extends DBComponent{

   String name;

   public String getName() {
      return name;
   }

   public void setName(String type) {
      this.name = type;
   }

   @Override
   public String toString() {
      return "DBRecurrenceType [type=" + name + ", id=" + id + "]";
   }

}
