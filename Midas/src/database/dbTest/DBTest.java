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
      
      //----------------------------------------------------------------------------------------
      // DBUser
      // ---------------------------------------------------------------------------------------
      // create
      System.out.println("----- create");
      DBUser dbUser = dbController.createDBUser();
      dbUser.setFirstName("Marcel");
      dbUser.setLastName("Sinniger");
      dbController.saveToDatabase(dbUser);
      // get
      System.out.println("get");
      DBUser dbUser2 = dbController.getUBUser(dbUser.getId());
      System.out.println(dbUser2);
      // mod
      System.out.println("mod");
      dbUser.setFirstName("asdf");
      dbController.saveToDatabase(dbUser);
      System.out.println(dbUser);
      // getAll
      System.out.println("getAll");
      LinkedList<DBUser> us = dbController.getAllDBUsers();
      for (DBUser u : us) {
         System.out.println(u);
      }
      
      // ---------------------------------------------------------------------------------------
      // Budget
      // ---------------------------------------------------------------------------------------
      // create
      
      
      // ---------------------------------------------------------------------------------------
      // Transaction
      // ---------------------------------------------------------------------------------------
      // create
      Date date = Date.valueOf("2010-05-03");
      Date date2 = Date.valueOf("2043-07-23");
      DBFinancialTransaction dbFinancialTransaction = 
            dbController.createFinancialTransaction();
      dbFinancialTransaction.setAmount(2200.0);
      dbFinancialTransaction.setDate(date2);
      dbFinancialTransaction.setReason("This is a test 2, mkaaay?");
      dbFinancialTransaction.setDbAccount(null);
      dbFinancialTransaction.setDbBudget(null);
      dbFinancialTransaction.setDbCategory(null);
      dbFinancialTransaction.setDbRecurrence(null);
      dbFinancialTransaction.setDbUser(null);
      dbController.saveToDatabase(dbFinancialTransaction);
      // get
      
      // mod
      
      // getAll
      LinkedList<DBFinancialTransaction> ft = dbController.getAllDBFinancialTransactions();
      for (DBFinancialTransaction f : ft) {
         System.out.println(f);
      }

     
      // ---------------------------------------------------------------------------------------
      // Category
      // ---------------------------------------------------------------------------------------
      // create
      DBCategory category1 = new DBCategory();
      category1.setName("Cat1");
      category1.setParentDBCategory(null);
      // mod
      
      // get
      
      // getAll
      
      
      dbController.saveToDatabase(category1);
      LinkedList<DBCategory> ca = dbController.getAllDBCategory();
      dbController.getDbCategory(1);
      for (DBCategory c : ca) {
          System.out.println(c);
      }
      
   }

}
