package dbTest;

import dbComponents.*;

public class DBTest {

   /**
    * @param args
    */
   public static void main(String[] args) {
      
      
      
      DBController dbController = new DBController();
      DBUser dbUser = dbController.createDBUser();
      dbUser.setFirstName("Marcel");
      dbUser.setLastName("Sinniger");
      dbController.saveToDatabase(dbUser);
      
      DBUser dbUser2 = dbController.getUBUser(dbUser.getId());
      System.out.println(dbUser2.getId() + " " + 
                         dbUser2.getFirstName() + " " + 
                         dbUser2.getLastName());
      
      dbUser.setFirstName("asdf");
      dbController.saveToDatabase(dbUser);
      
      DBUser dbUser3 = dbController.getUBUser(dbUser.getId());
      System.out.println(dbUser3.getId() + " " + 
                         dbUser3.getFirstName() + " " + 
                         dbUser3.getLastName());
      

   }

}
