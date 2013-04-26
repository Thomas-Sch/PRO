package database.dbComponents;

public class DBUser extends DBComponent {

   String firstName;
   String lastName;
   
   public String getFirstName() {
      return firstName;
   }
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   public String getLastName() {
      return lastName;
   }
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
   @Override
   public String toString() {
      return "DBUser [firstName=" + firstName + ", lastName=" + lastName
            + ", id=" + id + "]";
   }

}
