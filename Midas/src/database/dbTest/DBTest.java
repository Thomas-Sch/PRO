package database.dbTest;

import java.sql.Date;
import java.util.LinkedList;

import database.dbComponents.*;
import database.utils.DatabaseConstraintViolation;
import database.utils.DatabaseException;

public class DBTest {

   /**
    * @param args
    * @throws DatabaseException 
    * @throws DatabaseConstraintViolation 
    */
   public static void main(String[] args) throws DatabaseException, DatabaseConstraintViolation {
      
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
      Date date2 = Date.valueOf("2043-07-23");
      DBFinancialTransaction dbFinancialTransaction = 
    		  dbController.createFinancialTransaction();
	  dbFinancialTransaction.setAmount(2200.0);
	  dbFinancialTransaction.setDate(date2);
	  dbFinancialTransaction.setReason("This is a test 2, mkaaay?");
	  dbFinancialTransaction.setDbAccount(null); // We shall see.
	  dbFinancialTransaction.setDbBudget(null);
	  dbFinancialTransaction.setDbCategory(null);
	  dbFinancialTransaction.setDbRecurrence(null);
	  dbFinancialTransaction.setDbUser(null);
	  dbController.saveToDatabase(dbFinancialTransaction);
	  
      LinkedList<DBFinancialTransaction> ft = dbController.getAllDBFinancialTransactions();
      for (DBFinancialTransaction f : ft) {
         System.out.println(f.getId() + " " + 
               f.getReason() + " " + 
               f.getAmount() + " " +
               f.getDate());
      }
      
      /*DBFinancialTransaction testFinance = new DBFinancialTransaction();
      testFinance = dbController.getFinancialTransaction(1);
      System.out.println(testFinance.getReason() + " " + testFinance.getDate());*/
	  
      
      /*Category*/
      DBCategory category1 = new DBCategory();
      category1.setName("Cat1");
      category1.setParentDBCategory(null);
      
      dbController.saveToDatabase(category1);
      LinkedList<DBCategory> ca = dbController.getAllDBCategory();
      dbController.getDBCategory(1);
      for (DBCategory c : ca) {
          System.out.println(c.getId() + " " + 
                c.getName() + " " + 
                c.getParentDBCategory() + " ");
       }
      
   }

}
