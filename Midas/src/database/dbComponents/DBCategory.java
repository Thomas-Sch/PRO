package database.dbComponents;

public class DBCategory extends DBComponent {

   String name;
   Integer parentDBCategory;
   
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public Integer getParentDBCategory() {
      return parentDBCategory;
   }
   public void setParentDBCategory(Integer parentDBCategory) {
      this.parentDBCategory = parentDBCategory;
   }
   @Override
   public String toString() {
      return "DBCategory [name=" + name + ", parentDBCategory="
            + parentDBCategory + ", id=" + id + "]";
   }

}
