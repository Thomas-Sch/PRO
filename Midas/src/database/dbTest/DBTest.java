package database.dbTest;

import java.sql.Date;
import java.util.LinkedList;

import database.dbComponents.*;

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
      
      LinkedList<DBUser> us = dbController.getAllDBUsers();
      for (DBUser u : us) {
         System.out.println(u.getId() + " " + 
               u.getFirstName() + " " + 
               u.getLastName());
      }
      
      /* Test Transaction */
      Date date = Date.valueOf("2010-05-03");
      DBFinancialTransaction dbFinancialTransaction = 
    		  dbController.createFinancialTransaction();
	  dbFinancialTransaction.setAmount(2000.0);
	  dbFinancialTransaction.setDate(date);
	  dbFinancialTransaction.setReason("This is a test, mkaaay?");
	  dbFinancialTransaction.setDbAccount(null); // We shall see.
	  dbFinancialTransaction.setDbBudget(null);
	  dbFinancialTransaction.setDbCategory(null);
	  dbFinancialTransaction.setDbRecurrence(null);
	  dbFinancialTransaction.setDbUser(null);
	  dbController.saveToDatabase(dbFinancialTransaction);
	  
   }

}
